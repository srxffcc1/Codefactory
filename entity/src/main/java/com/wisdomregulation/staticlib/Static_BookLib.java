package com.wisdomregulation.staticlib;



/**
 * 静态字段类
 * @author King2016s
 *
 */
public class Static_BookLib {
	public static void main(String[] args) {
//		System.out.println(BOOKNAMELIST2017.length);
		getAllPublicWensShuAndName();
	}
	public static void getAllPublicWensShuAndName(){
		for (int i = 0; i < WEBBOOKNAME2017.length; i++) {
			System.out.println("\t//"+ BOOKNAMELIST2017[i]+"\n" +
					"\tpublic "+ WEBBOOKNAME2017[i]+" "+changeHeadToLowCase(WEBBOOKNAME2017[i])+";");
		}
	}
	/**
	 * 获得首位小写的字符串
	 * @param keyword
	 * @return
	 */
	public static String changeHeadToLowCase(String keyword) {
		String result="";
		String head=keyword.substring(0,1).toLowerCase();
		String body=keyword.substring(1,keyword.length());
		result=head+body;
		return result;
	}

	public static String getWenshuEntityStringWithName2017(String chinesename){
		String result="";

		for (int i = 0; i < BOOKNAMELIST2017.length; i++) {
			if(chinesename.trim().equals(BOOKNAMELIST2017[i])){
				result= WEBBOOKNAME2017[i];
				break;
			}
		}
			return result;
	}
	public static String getWebObjChildStringWithName2017(String chinesename){
		String result="";

		for (int i = 0; i < BOOKNAMELIST2017.length; i++) {
			if(chinesename.trim().equals(BOOKNAMELIST2017[i])){
				result= WEBBOOKNAMECHILD2017[i];
				break;
			}
		}
		return result;
	}
	public static String getWenshuEntityStringWithName(String chinesename){
		String result="";

		for (int i = 0; i < BOOKNAMELIST.length; i++) {
			if(chinesename.trim().equals(BOOKNAMELIST[i])){
				result= WEBBOOKNAME[i];
				break;
			}
		}
		return result;
	}
	public static final String[] WEBBOOKNAME2017 =new String[]{
			"WsLasp",
			"WsXcjcfa",
			"WsXcjc",
			"WsXcclcs",
			"WsZlxqzg",
			"WsZgfc",
			"WsXzqzsp",
			"WsCfkyjds",
			"WsCfkyqd",
			"WsYccfkyqxjds",
			"WsCfkycljds",
			"WsTzgdtzs",
			"WsTzgdjds",
			"WsHfgdtzs",
			"WsXwtz",
			"WsXwbl",
			"WsKybl",
			"WsCyqzpz",
			"WsXxdjbc",
			"WsXxdjtzs",
			"WsXxdjclspb",
			"WsXxdjcljds",
			"WsJdwts",
			"WsXzcfgzs",
			"WsDsrcssbbl",
			"WsTzgzs",
			"WsTzhtzs",
			"WsTzbl",
			"WsTzhbg",
			"WsAjclcp",
			"WsXzcftljl",
			"WsXzcfdw",
			"WsXzcfgr",
			"WsXzcfjdsdw",
			"WsXzcfjdsgr",
			"WsFkcjtzs",
			"WsJcfkjds",
			"WsYqjnfkspb",
			"WsYqjnfkpzs",
			"WsSdhz",
			"WsQzzxsxcgs",
			"WsQzzxsqs",
			"WsAjysspb",
			"WsAjyss",
			"WsAjyqspb",
			"WsJaspb",
			"WsAjsy",
			"WsJnml",
	};
	public static final String[] WEBBOOKNAMETZ =new String[]{
			"WsLasp",
			"WsXcjcfa",
			"LawWsXcjc",
			"LawWsXcclcs",
			"LawWsZlxqzg",
			"LawWsZgfc",
			"WsXzqzsp",
			"WsCfkyjds",
			"WsCfkyqd",
			"WsYccfkyqxjds",
			"WsCfkycljds",
			"WsTzgdtzs",
			"WsTzgdjds",
			"WsHfgdtzs",
			"WsXwtz",
			"WsXwbl",
			"WsKybl",
			"WsCyqzpz",
			"WsXxdjbc",
			"WsXxdjtzs",
			"WsXxdjclspb",
			"WsXxdjcljds",
			"WsJdwts",
			"WsXzcfgzs",
			"WsDsrcssbbl",
			"WsTzgzs",
			"WsTzhtzs",
			"WsTzbl",
			"WsTzhbg",
			"WsAjclcp",
			"WsXzcftljl",
			"WsXzcfdw",
			"WsXzcfgr",
			"WsXzcfjdsdw",
			"WsXzcfjdsgr",
			"WsFkcjtzs",
			"WsJcfkjds",
			"WsYqjnfkspb",
			"WsYqjnfkpzs",
			"WsSdhz",
			"WsQzzxsxcgs",
			"WsQzzxsqs",
			"WsAjysspb",
			"WsAjyss",
			"WsAjyqspb",
			"WsJaspb",
			"WsAjsy",
			"WsJnml",
	};
	public static final String[] WEBBOOKNAMECHILD2017 =new String[]{
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"Cfky",//         8

			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"WsCyqz",//			17

			"",
			"",
			"",
			"",
			"Jdwts",//			22

			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"Sdhz",//			39

			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"Jnml",//			47
	};
	public static final String[] WEBBOOKNAMECHILDTZ =new String[]{
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"Cfky",//         8

			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"WsCyqz",//			17

			"",
			"",
			"",
			"",
			"Jdwts",//			22

			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"Sdhz",//			39

			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"Jnml",//			47
	};

	public static final String[] WEBBOOKNAME =new String[]{
			"WsLasp",
			"WsXwtz",
			"WsXwbl",
			"WsKybl",
			"WsCyqzpz", //对应Entity_Book4
			"WsXxdjbc",
			"WsXxdjtzs",
			"WsXxdjclspb",
			"WsXxdjcljds",
			"WsXcjc",
			"WsXcclcs",
			"WsZlxqzg",
			"WsZgfc",
			"WsQzcs",
			"WsJdwts", //对应Entity_Book14
			"WsXzcfgzs",
			"WsDsrcssbbl",
			"WsTzgzs",
			"WsTzhtzs",
			"WsTzbl",
			"WsTzhbg",
			"WsAjclcp",
			"WsXzcftljl",
			"WsXzcfdw",
			"WsXzcfgr",
			"WsXzcfjdsdw",
			"WsXzcfjdsgr",
			"WsFkcjtzs",
			"WsYqjnfkspb",
			"WsYqjnfkpzs",
			"WsSdhz", //对应Entity_Book30
			"WsQzzxsqs",
			"WsJaspb",
			"WsAjysspb",
			"WsAjyss",
			"WsAjsy",
			"WsJnml" };//对应Entity_Book36

	public static final String[] WEBBOOKNAMECHILD =new String[]{
			"",
			"",
			"",
			"",
			"WsCyqz", //对应Entity_Book4 WsCyqzpz
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"Jdwts", //对应Entity_Book14 WsJdwts
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"Sdhz", //对应Entity_Book30 WsSdhz
			"",
			"",
			"",
			"",
			"",
			"Jnml" };//对应Entity_Book36 WsJnml
	public static final String[] BOOKNAMELIST = new String[] {
			"立案审批表",
			"询问通知单", 
			"询问笔录", 
			"勘查笔录", 
			"抽样取证凭证", 
			"先行登记保存证据审批表", 
			"先行登记保存证据通知单",
			"先行登记保存证据处理审批表", 
			"先行登记保存证据处理决定书",
			"现场检查记录", 
			"现场处理措施决定书",
			"责令限期整改指令书", 
			"整改复查意见书", 
			"强制措施决定书", 
			"鉴定委托书", 
			"行政处罚告知书", 
			"当事人陈述申辩笔录",
			"听证告知书", 
			"听证会通知书", 
			"听证笔录", 
			"听证会报告书", 
			"案件处理呈批表", 
			"行政处罚集体讨论记录",
			"行政（当场）处罚决定书（单位）", 
			"行政（当场）处罚决定书（个人）", 
			"行政处罚决定书（单位）", 
			"行政处罚决定书（个人）",
			"罚款催缴通知书", 
			"延期（分期）缴纳罚款审批表", 
			"延期（分期）缴纳罚款批准书", 
			"文书送达回执", 
			"强制执行申请书",
			"结案审批表", 
			"案件移送审批表", 
			"案件移送书", 
			"案卷首页", 
			"卷内目录" };


	public static final String[] BOOKNAMELIST2017 = new String[] {
			"立案审批表",
			"现场检查方案",
			"现场检查记录",
			"现场处理措施决定书",
			"责令限期整改指令书",
			"整改复查意见书",
			"行政强制审批表",
			"查封扣押决定书",
			"查封扣押（场所、设施、财物）清单",
			"延长查封扣押期限决定书",
			"查封扣押处理决定书",
			"停止供电（供应民用爆炸物品）通知书",
			"停止供电（供应民用爆炸物品）决定书",
			"恢复供电（供应民用爆炸物品）通知书",
			"询问通知书",
			"询问笔录",
			"勘验笔录",
			"抽样取证凭证",
			"先行登记保存证据审批表",
			"先行登记保存证据通知书",
			"先行登记保存证据处理审批表",
			"先行登记保存证据处理决定书",
			"鉴定委托书",
			"行政处罚告知书",
			"当事人陈述申辩笔录",
			"行政处罚听证告知书",
			"行政处罚听证会通知书",
			"听证笔录",
			"听证会报告书",
			"案件处理呈批表",
			"行政处罚集体讨论记录",
			"行政（当场）处罚决定书（单位）",
			"行政（当场）处罚决定书（个人）",
			"行政处罚决定书（单位）",
			"行政处罚决定书（个人）",
			"缴纳罚款催告书",
			"加处罚款决定书",
			"延期（分期）缴纳罚款审批表",
			"延期（分期）缴纳罚款批准书",
			"文书送达回执",
			"行政强制执行事先催告书",
			"强制执行申请书",
			"案件移送审批表",
			"案件移送书",
			"案件延期审批表",
			"结案审批表",
			"案卷（首页）",
			"卷内目录" };
}
