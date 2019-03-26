package com.codefactory.abstracts;

import com.codefactory.node.XmlNode;
import utils.Util_String;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author King2016s 2016-11-26
 */
public abstract class ParseBase {
	private String nodename;
	private String hashcode;
	private List<ParseBase> nodelist = new ArrayList<ParseBase>();
	private List<String> propertylist = new ArrayList<String>();
	private String morgstring;
	private String nodebody;
	/**
	 * // 用来判断 是否为<xxx ></xxx> 的结束方式 可能为< />
	 */
	private boolean isspecial = false;

	/**
	 * 此构造函数不建议使用 请使用子类的构造方法
	 */
	public ParseBase() {

	}

	/**
	 * * 默认的生成节点方式 这里为了抽象类的一些特性做的处理 因 主要的解析方法是在抽象类里进行的属性 如果 子类想要 进行调用
	 * 需要进行build用来链接两者关系 因为在抽象类的解析方法里需要使用当前解析器的对象 但是在书写抽象方法时 子类解析器并不一定存在
	 * 所以预留这个链接方法 获得当前子类的类对象
	 * 
	 * @param nodename
	 *            可选参数 节点名称
	 * @return
	 */
	public abstract ParseBase build(String... nodename);

	/**
	 * @param orgstring
	 *            用来解析节点集合的方法 进行节点及属性装配
	 * @return
	 */
	public ParseBase parse(String orgstring) {
		morgstring = orgstring.replace("/>"," />");//为了防止空节点 加个空格
//		System.out.println(morgstring);
//		System.out.println("--------");
		Pattern head = getEndPattern();//获得当前结点头

		Matcher headm = head.matcher(morgstring);
		//判断是否具有根节点 isspecial为true则表示不具有根节点
		if (headm.find()) {
			String headtmp = headm.group(1);
//			System.out.println(headtmp);
			Pattern bodyp = getBodyModelSpecial(headtmp);
//			System.out.println(bodyp);
			Matcher bodym = bodyp.matcher(morgstring);
			if (bodym.find()) {
				String bodystring = bodym.group();

				if (morgstring.length()-(morgstring.indexOf(bodystring) + bodystring.length()) <=5) {
					nodename = headtmp;
				} else {
					isspecial = true;
				}

			} else {
				isspecial = true;
			}
		} else {
			isspecial = true;
		}
		if(isspecial){
			Pattern heads = getSpecailPattern();//获得当前结点头
			Matcher headms = heads.matcher(morgstring);
			if(headms.find()){
				nodename=headms.group(1);
			}
		}
		nodebody = morgstring;//节点体
//		System.out.println(nodebody);
		if (nodename != null && !nodename.equals("")) {
			Pattern body = getBodyPattern(nodename);
			Matcher bodym = body.matcher(morgstring);
			if (bodym.find()) {
				nodebody = bodym.group(1);
//				System.out.println(nodebody);
			} else {
				Pattern body2 = getSpecailBodyPattern(nodename);
				Matcher bodym2 = body2.matcher(morgstring);
				if (bodym2.find()) {
					nodebody = bodym2.group(1);
				}
			}
		}
		Pattern bodyhead = getHeadPattern();
//		System.out.println(bodyhead);
		Matcher bodyheadm = bodyhead.matcher(nodebody);
		while (bodyheadm.find()) {
			boolean needreset = false;
			String tmphead = bodyheadm.group(1)
					.replace("/","")
					.replace(Util_String.washString(getSpecailEnd()), "")
					.replace(Util_String.washString(getSpecailHead()), "");
//			System.out.println(tmphead);
			Pattern bodymodeltmp = getBodyModel(tmphead);
//			System.out.println(bodymodeltmp);
			Matcher bodymodelmtmp = bodymodeltmp.matcher(nodebody);
			int a = -1;
			int b = -1;
			String tmpnormal = null;
			String tmpspecail = null;
			while (bodymodelmtmp.find()) {
//				System.out.println("进入循环");
				needreset = false;
				tmpnormal = bodymodelmtmp.group();
//				System.out.println(tmpnormal);
//				System.out.println("-----------------");
				if (Util_String.is22match(tmpnormal, getNodeHead(tmphead), getNodeEnd(tmphead))) {
					a = nodebody.indexOf(tmpnormal, 0);
//					System.out.println(tmphead);
					break;
				} else {
//					System.out.println(tmphead);
					Pattern specail = getSpecailPattern();
					Matcher specailm = specail.matcher(tmpnormal);
					boolean needreset2 = false;
					while (specailm.find()) {

						tmpspecail = specailm.group();
						if (Util_String.is222match(tmpspecail,
								getSpecailHead(), getSpecailEnd())) {
//							System.out.println(tmphead);
							nodebody = nodebody.replaceFirst(
									Util_String.washString(tmpspecail), "");
							tmpnormal = tmpnormal.replaceFirst(
									Util_String.washString(tmpspecail), "");
							addNode(build(specailm.group(1)).parse(tmpspecail));
							bodyheadm.reset(nodebody);
							needreset2 = true;
						} else {
							break;
						}
					}
					if (needreset2) {
						needreset = true;
						break;
					} else {
						if (Util_String.is22match(tmpnormal,
								getNodeHead(tmphead), getNodeEnd(tmphead))) {
							a = nodebody.indexOf(tmpnormal, 0);
							break;
						} else {
							int number = Util_String.getSubStringNumber(
									tmpnormal, getNodeHead(tmphead));
							bodymodeltmp = getBodyModel(tmphead, number);
							needreset = true;
							bodyheadm.reset(nodebody);
							bodymodelmtmp = bodymodeltmp.matcher(nodebody);
							bodymodelmtmp.reset(nodebody);

						}
					}

				}
			}
			if (needreset) {

			} else {
				Pattern specail = getSpecailPattern();
				Matcher specailm = specail.matcher(nodebody);
				while (specailm.find()) {
					tmpspecail = specailm.group();
					if (Util_String.is222match(tmpspecail, getSpecailHead(),
							getSpecailEnd())) {
						b = nodebody.indexOf(tmpspecail, 0);
						break;
					} else {
						break;
					}
				}
				if (a != -1 && a < b) {
					nodebody = nodebody.replaceFirst(
							Util_String.washString(tmpnormal), "");
					addNode(build().parse(tmpnormal));
					bodyheadm.reset(nodebody);

				} else if (b != -1 && b < a) {
					nodebody = nodebody.replaceFirst(
							Util_String.washString(tmpspecail), "");
					addNode(build(specailm.group(1)).parse(tmpspecail));
					bodyheadm.reset(nodebody);
				} else {
					if (a == -1 && b == -1) {

					} else if (a == -1 && b != -1) {
						nodebody = nodebody.replaceFirst(
								Util_String.washString(tmpspecail), "");
						addNode(build(specailm.group(1)).parse(tmpspecail));
						bodyheadm.reset(nodebody);
					} else if (b == -1 && a != -1) {
						nodebody = nodebody.replaceFirst(
								Util_String.washString(tmpnormal), "");
						addNode(build().parse(tmpnormal));
						bodyheadm.reset(nodebody);
					}
				}
			}

		}

		if (!nodebody.trim().equals("")) {
			Pattern propetry = getPropetryPattern();
			Matcher propetrym = propetry.matcher(nodebody);
			boolean isfinnd=false;
			while (propetrym.find()) {
				isfinnd=true;
				addProperty(propetrym.group(1), propetrym.group(2));
			}
			if(!isfinnd){
				Pattern propetrynofind = Pattern.compile("(.*)");
				Matcher propetrymnofind = propetrynofind.matcher(nodebody);
				while (propetrymnofind.find()) {
					addPropertyNoFind(propetrymnofind.group().trim());
				}

			}
		}
		return this;
	}

	/**
	 * @param head
	 *            获得当前节点 特定头的属性 的正则
	 * @return
	 */
	public abstract Pattern getPropertyValuePattern(String head);

	/**
	 * @return 获得属性匹配正则 用来分离属性进行装配
	 */
	public abstract Pattern getPropetryPattern();

	/**
	 * @param tmpmodelname
	 *            用节点名 来正则匹配 需要进行分离的内容 贪婪匹配 用来确定是不是根节点
	 * @return
	 */
	public abstract Pattern getBodyModelSpecial(String tmpmodelname);

	/**
	 * @param tmpmodelname
	 *            用节点名 来正则匹配 需要进行分离的内容
	 * @return
	 */
	public abstract Pattern getBodyModel(String tmpmodelname);

	/**
	 * 再用节点当前正则匹配不出正确的 首尾方式时 进行必要纠正 正则的方法
	 * 
	 * @param tmpmodelname
	 * @param duplicate
	 * @return
	 */
	public abstract Pattern getBodyModel(String tmpmodelname, int duplicate);

	/**
	 * 获得当前一级节点下的所有节点集合 进行分离装配的 正则
	 * 
	 * @param modelnametmp
	 * @return
	 */
	public abstract Pattern getBodyPattern(String modelnametmp);

	/**
	 * 获得节点头正则 用来匹配出节点 头
	 * 
	 * @return
	 */
	public abstract Pattern getHeadPattern();

	/**
	 * 获得节点尾正则 用来匹配出节点 头
	 * 
	 * @return
	 */
	public abstract Pattern getEndPattern();

	/**
	 * 获得属性结尾
	 * 
	 * @return
	 */
	public abstract String getPropertyEnd();

	/**
	 * 获得节点头 在进行修正装配式会需要
	 * 
	 * @param modelname
	 * @return
	 */
	public abstract String getNodeHead(String modelname);

	/**
	 * 获得节点尾 在分析是否获得的内容能独立成节点用到
	 * 
	 * @param modelname
	 * @return
	 */
	public abstract String getNodeEnd(String modelname);

	/**
	 * 用明确的特殊节点 获得 节点内容 的匹配正则
	 * 
	 * @param modelnametmp
	 * @return
	 */
	public abstract Pattern getSpecailBodyPattern(String modelnametmp);

	/**
	 * 匹配出特殊节点 比如 xml的 <xxxx ssss:ssss/> 的名字 在进行详细处理
	 * 作用于getSpecailBodyPattern(modelnametmp)
	 * 
	 * @return
	 */
	public abstract Pattern getSpecailPattern();

	/**
	 * 获得明确的特殊节点头 暂时未用
	 * 
	 * @param head
	 * @return
	 */
	public abstract Pattern getSpecailPattern(String head);

	/**
	 * 获得节点头符号 针对特殊节点
	 * 
	 * @return
	 */
	public abstract String getSpecailHead();

	/**
	 * 获得属性特殊头
	 * 
	 * @return
	 */
	public abstract String getSpecailHead2();

	/**
	 * 获得节点尾符号
	 * 
	 * @return
	 */
	public abstract String getSpecailEnd();
	public abstract String getSpecailEnd1();
	/**
	 * 获得节点特殊尾 针对特殊节点
	 * 
	 * @return
	 */
	public abstract String getSpecailEnd2();

	/**
	 * 获得特殊分割符号 分离key和value
	 * 
	 * @return
	 */
	public abstract String separator();

	/**
	 * 获得value的双侧符号
	 * 
	 * @return
	 */
	public abstract String valueclude();

	/**
	 * 用节点名和属性key对属性移除
	 * 
	 * @param model
	 * @param key
	 * @return
	 */
	public ParseBase removeProperty(String model, String key) {
		if (model.equals(nodename)) {
			int needremove = -1;
			for (int i = 0; i < propertylist.size(); i++) {
				if (propertylist.get(i).matches(
						getSpecailHead2() + key + separator() + "(.*)")) {
					needremove = i;
					break;
				}
			}
			if (needremove != -1) {
				propertylist.remove(needremove);
			} else {
			}
		} else {
			for (int i = 0; i < nodelist.size(); i++) {
				nodelist.get(i).removeProperty(model, key);
			}
		}
		return this;
	}
	public ParseBase findNodeByProperty(String property){
		List<ParseBase> singlenodelist=getNodeAllLevel();
		for (int i = 0; i < singlenodelist.size(); i++) {
			if (singlenodelist.get(i).isIncludeProperty(property)) {
				return singlenodelist.get(i);
			}
		}
		return null;
	}
	public ParseBase copy(){
//		System.out.println(getEntityString());
		return build().parse(getEntityString());
	}
	/**
	 * 对已经存在的节点 进行子节点增加 特征量为拥有特定属性的某个节点 比如id为多少
	 * 
	 * @param property  例如 android:id=@+id/scrollmain 记得转义 "android:id=\"@\\+id/scrollmain\""
	 * @param child
	 * @return
	 */
	public ParseBase addNodeToAlreadyNodeByProperty(String property, ParseBase... child) {

		for (int i = 0; i < nodelist.size(); i++) {
			if (nodelist.get(i).isIncludeProperty(property)) {
				nodelist.get(i).addNode(child);
			} else {
				nodelist.get(i).addNodeToAlreadyNodeByProperty(property, child);
			}
		}
		return this;
	}
	/**
	 * 对已经存在的节点 进行子节点增加 特征量为拥有特定节点名字的的某个节点 比如对activity进行批量注册为多少
	 * 
	 * @param nodename
	 * @param child
	 * @return
	 */
	public ParseBase addNodeToAlreadyNodeByNodeName(String nodename, ParseBase... child) {

		
			if (getNodename().equals(nodename)) {
				addNode(child);
			} else {
				for (int j = 0; j < nodelist.size(); j++) {
					nodelist.get(j).addNodeToAlreadyNodeByNodeName(nodename, child);
				}
				
			}
		
		return this;
	}
	/**
	 * 再当前节点 增加子节点
	 * 
	 * @param child
	 * @return
	 */
	public ParseBase addNode(ParseBase... child) {
		for (int i = 0; i < child.length; i++) {
			nodelist.add(child[i].setHashCode(UUID.randomUUID().toString()));
		}
		return this;
	}

	/**
	 * 对当前节点 正则删除节点
	 * 
	 * @param regex
	 * @return
	 */
	public ParseBase removeNodeRegex(String regex) {
		for (int i = 0; i < nodelist.size(); i++) {
			if (nodename.matches(regex)) {
				nodelist.remove(i);
				i--;
			}
		}
		return this;
	}

	/**
	 * 用节点名 加节点唯一标识进行删除
	 * 
	 * @param nodename
	 * @param hashcode
	 * @return
	 */
	public ParseBase removeNode(String nodename, String hashcode) {
		for (int i = 0; i < nodelist.size(); i++) {
			if (nodename.equals(nodelist.get(i).getNodename())
					&& hashcode.equals(nodelist.get(i).getHashCode())) {
				nodelist.remove(i);
				i--;
			}
		}
		return this;
	}

	/**
	 * 在特定节点名下 增加特定属性
	 * 
	 * @param modelnodename
	 * @param key
	 * @param value
	 * @return
	 */
	public ParseBase addProperty(String modelnodename, String key, String value) {
		if (modelnodename.equals(nodename)) {
			addProperty(key, value);
		} else {
			for (int i = 0; i < nodelist.size(); i++) {
				nodelist.get(i).addProperty(modelnodename, key, value);
			}
		}
		return this;
	}

	/**
	 * 设置唯一识别码来标记节点
	 * 
	 * @param code
	 * @return
	 */
	public ParseBase setHashCode(String code) {
		hashcode = code;
		return this;
	}

	/**
	 * 再当前节点 增加属性 如果属性已经存在则修改
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	public ParseBase addProperty(String key, String value) {

		if (!isIncludePropertyRegex(key, value)) {
			propertylist.add(key.trim() + separator() + valueclude() + value
					+ valueclude());
		} else {
			for (int i = 0; i < propertylist.size(); i++) {
				if (propertylist.get(i).matches(
						key.trim() + separator() + "(.*)")) {
					propertylist.set(i, key.trim() + separator() + valueclude()
							+ value + valueclude());
				}
			}
		}

		return this;
	}

	/**
	 * 对某些出现的非正常格式属性进行记录
	 * @param linestring
	 * @return
	 */
	public ParseBase addPropertyNoFind(String linestring) {
		if(linestring.trim().equals("")){

		}else{
			propertylist.add(linestring);
		}

		return this;
	}

	/**
	 * 完整判断属性是否存在 本层属性不涉及子节点
	 * 
	 * @param completeProperty
	 * @return
	 */
	public boolean isIncludeProperty(String completeProperty) {
		boolean isin = false;
		for (int i = 0; i < propertylist.size(); i++) {
//			System.out.println(propertylist.get(i));
			if (propertylist.get(i).matches("(.*)" + completeProperty + "(.*)")) {
				isin = true;
				break;

			}
		}
		return isin;
	}

	/**
	 * 正则判断属性是否存在
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	public boolean isIncludePropertyRegex(String key, String value) {
		boolean isin = false;
		for (int i = 0; i < propertylist.size(); i++) {
			if (propertylist.get(i).matches("(.*?)" + key + "(.*)")) {
				isin = true;
				break;
			}
		}
		return isin;
	}
	/**
	 * 用节点名获得 节点集合 所有的
	 *
	 * @param
	 * @return
	 */
	public List<ParseBase> getNodeAllLevel() {
		List<ParseBase> nodelist2 = new ArrayList<ParseBase>();

		for (int i = 0; i < nodelist.size(); i++) {
			nodelist2.add(nodelist.get(i));
			nodelist2.addAll(nodelist.get(i).getNodeAllLevel());
		}
		return nodelist2;
	}
	/**
	 * 用节点名获得 节点集合 所有的
	 *
	 * @param nodename
	 * @return
	 */
	public List<ParseBase> getNodeAllLevel(String nodename) {
		List<ParseBase> nodelist2 = new ArrayList<ParseBase>();
		for (int i = 0; i < nodelist.size(); i++) {
			if (nodelist.get(i).getNodename().equals(nodename)) {
				nodelist2.add(nodelist.get(i));
			}else{
				nodelist2.addAll(nodelist.get(i).getNodeAllLevel(nodename));
			}
		}
		return nodelist2;
	}
	/**
	 * 用节点名获得 节点集合 本层的
	 * 
	 * @param nodename
	 * @return
	 */
	public List<ParseBase> getNodeInThisLevel(String nodename) {
		List<ParseBase> nodelist2 = new ArrayList<ParseBase>();
		for (int i = 0; i < nodelist.size(); i++) {
			if (nodelist.get(i).getNodename().equals(nodename)) {
				nodelist2.add(nodelist.get(i));
			}
		}
		return nodelist2;
	}
	/**
	 * 获得这一层节点下 某个节点的所有属性 全部为小写
	 *
	 * @param head
	 * @return
	 */
	public List<String> getPropertyValueInThisLevelNodeLowerCase(String head) {
		List<String> result = new ArrayList<String>();
		if (head.equals("")) {
		} else {
			for (int i = 0; i < propertylist.size(); i++) {
				boolean needloop = true;
//				System.out.println(propertylist
//						.get(i));
				Pattern propertyvalue = getPropertyValuePattern(head);
//				System.out.println(propertyvalue);
				Matcher propertyvaluem = propertyvalue.matcher(propertylist
						.get(i));
				while (propertyvaluem.find()) {
					result.add(propertyvaluem.group(2).toLowerCase());
				}
				if (!needloop) {
					break;
				}
			}
		}
		return result;
	}
	/**
	 * 获得这一层节点下 某个节点的所有属性
	 * 
	 * @param head
	 * @return
	 */
	public List<String> getPropertyValueInThisLevelNode(String head) {
		List<String> result = new ArrayList<String>();
		if (head.equals("")) {
		} else {
			for (int i = 0; i < propertylist.size(); i++) {
				boolean needloop = true;
//				System.out.println(propertylist
//						.get(i));
				Pattern propertyvalue = getPropertyValuePattern(head);
//				System.out.println(propertyvalue);
				Matcher propertyvaluem = propertyvalue.matcher(propertylist
						.get(i));
				while (propertyvaluem.find()) {
					result.add(propertyvaluem.group(2));
				}
				if (!needloop) {
					break;
				}
			}
		}
		return result;
	}

	/**
	 * 将节点集合进行输出成字符串
	 * 
	 * @return
	 */
	public String getEntityString() {
		return getEntityString(0).replace("/>/>","/>").replace(">>",">").replace("]]","]").replace("<<","<").replace("[[","[");
	}

	/**
	 * 字符串生成的层级重载函数
	 * 
	 * @param level
	 * @return
	 */
	private String getEntityString(int level) {

		String result = "";
		if (nodelist.size() > 0) {
			for (int i = 0; i < nodelist.size(); i++) {
				result = result
						+ nodelist.get(i)
								.getEntityString(
										(nodename == null || nodename
												.equals("")) ? level
												: level + 1);
			}
		} else {
			
		}
		result = getPropertyString((nodename == null || nodename.equals("")) ? level
				: level + 1)
				+ getPropertyEnd() + result;
		String tab = "";
		for (int i = 0; i < level; i++) {
			tab = tab + "\t";
		}

		if (isspecial) {

			if (nodename == null || nodename.equals("")) {

			} else {
				result = "" + tab + getSpecailHead() + nodename + "\r\n"
						+ result + "" + getSpecailEnd2() + "\r\n";
			}
		} else {
			if (nodename == null || nodename.equals("")) {

			} else {
				result = "" + tab + getNodeHead(nodename) + "\r\n" + result
						+ "" + tab + getNodeEnd(nodename) + "\r\n";
			}

		}
		return result;
	}

	/**
	 * 获得层级量的属性字符串 层级就是制表符的数量
	 * 
	 * @param level
	 * @return
	 */
	public String getPropertyString(int level) {
		String tab = "";
		for (int i = 0; i < level - 1; i++) {
			tab = tab + "\t";
		}
		String result = "";
		if(propertylist.size()==0){
			if (isspecial) {
				result = getSpecailEnd2();
			} else {

				result = getSpecailEnd1();
			}
		}
		for (int i = 0; i < propertylist.size(); i++) {
			if (i + 1 >= propertylist.size()) {
				if (isspecial) {
					result = result + tab + propertylist.get(i);
				} else {
					result = result + tab + propertylist.get(i)
							+ getSpecailEnd1() + "\r\n";
				}

			} else {
				result = result + tab + propertylist.get(i) +"\r\n";
			}

		}
		return result;
	}

	/**
	 * 获得节点名字
	 * 
	 * @return
	 */
	public String getNodename() {
		return nodename;
	}

	/**
	 * 设置节点名字 多用于 自装配节点
	 * 
	 * @param nodename
	 * @return
	 */
	public ParseBase setNodename(String nodename) {
		this.nodename = nodename;
		return this;
	}

	/**
	 * 获得节点唯一识别码
	 * 
	 * @return
	 */
	public String getHashCode() {
		return hashcode;
	}

	/**
	 * 获得节点名列表
	 * 
	 * @return
	 */
	public List<String> getModelnameChild() {
		List<String> childname = new ArrayList<String>();
		for (int i = 0; i < nodelist.size(); i++) {
			childname.add(nodelist.get(i).getNodename());
		}
		return childname;
	}

	/**
	 * 方法废弃 之前不知道有重置方法 所以 进行手动 seek位置 目前不用此方法进行数据替换了
	 * 
	 * @param length
	 * @return
	 */
	public String getLengthString(int length) {
		String result = "";
		for (int i = 0; i < length; i++) {
			result = result + " ";
		}
		return result;
	}

	/**
	 * 获得属性列表 未来会改成 key+value的实体形式
	 * 
	 * @return
	 */
	public List<NodeEntity> getPropertyList() {
		List<NodeEntity> result = new ArrayList<NodeEntity>();
		for (int i = 0; i < propertylist.size(); i++) {
			String[] org = propertylist.get(i).split(
					Util_String.washString(separator()));
			result.add(new NodeEntity(org[0].trim(), separator(), org[1].trim()));
		}
		return result;
	}

	/**
	 * 获得第几个key 遍历时用到
	 * 
	 * @param index
	 * @return
	 */
	public String getKeyInIndex(int index) {
		String org = propertylist.get(index);
		Pattern propetry = getPropetryPattern();
		Matcher propetrym = propetry.matcher(org);
		if (propetrym.find()) {
			return propetrym.group(1);
		}
		return null;
	}

	/**
	 * 获得第几个value 遍历时用到
	 * 
	 * @param index
	 * @return
	 */
	public String getValueInIndex(int index) {
		String org = propertylist.get(index);
		Pattern propetry = getPropetryPattern();
		Matcher propetrym = propetry.matcher(org);
		if (propetrym.find()) {
			return propetrym.group(2);
		}
		return null;
	}

	/**
	 * 手动设置节点是否特殊 如果故意设置为特殊节点 将抛弃子节点
	 * 
	 * @param isspecial
	 * @return
	 */
	public ParseBase setIsSpecail(boolean isspecial) {
		this.isspecial = isspecial;
		return this;
	}

	/**
	 * 判断是否为特殊节点
	 * 
	 * @return
	 */
	public boolean isSpecail() {
		return isspecial;
	}

}
