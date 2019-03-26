package utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Util_Class {
	private static final Util_Class us=new Util_Class();
	private Util_Class() {

	}
	public static Util_Class create(){
		return us;
	}
	
	/**
	 * 获得src路径
	 * @param needfind
	 * @return
	 */
	public String getSrcFilePath(Object needfind) {
		
		String srcfilepath = needfind.getClass().getResource(File.separator)
				.getPath();
		File file=new File(srcfilepath);
		srcfilepath=file.getParent();
		srcfilepath=srcfilepath.replaceAll("\\\\", "/");
		System.out.println("28src:"+srcfilepath);
		if(srcfilepath.contains("bin")){
			srcfilepath = srcfilepath.replaceAll("/bin/", "@");
			int first = srcfilepath.indexOf("@");
			srcfilepath = srcfilepath.substring(0, first) + "/src/";
		}else{
			srcfilepath = srcfilepath.replaceAll("/build/classes/main/", "@").replaceAll("/out/production/classes/","@");
			int first = srcfilepath.indexOf("@");
			srcfilepath = srcfilepath.substring(0, first) + "/src/main/java/";
		}
		System.out.println("38src:"+srcfilepath);
		return srcfilepath;
	}
	public String getPackageFilePath(Object needfind) {
		
		String srcfilepath = needfind.getClass().getResource(File.separator)
				.getPath();
		File file=new File(srcfilepath);
		srcfilepath=file.getParent();
		srcfilepath=srcfilepath.replaceAll("\\\\", "/");
		if(srcfilepath.contains("bin")){
			srcfilepath = srcfilepath.replaceAll("/bin/", "@");
			int first = srcfilepath.indexOf("@");
			srcfilepath = srcfilepath.substring(first+1, srcfilepath.length());
		}else{
			srcfilepath = srcfilepath.replaceAll("/build/classes/main/", "@");
			int first = srcfilepath.indexOf("@");
			srcfilepath = srcfilepath.substring(first+1, srcfilepath.length());
		}
//		srcfilepath=srcfilepath.replaceAll("\\\\", "/");
//		srcfilepath = srcfilepath.replaceAll("/bin/", "@");
//		int first = srcfilepath.indexOf("@");
//		srcfilepath = srcfilepath.substring(first+1, srcfilepath.length());
		System.out.println("60:"+srcfilepath);
		return srcfilepath;
	}
	
	/**
	 * 迭代获得所有类路径
	 * @param srcpath
	 * @return
	 */
	public List<String> getAllClassObject(String srcpath) {
		List<String> list = new ArrayList<String>();
		File src = new File(srcpath);
		File[] filelist = src.listFiles();
		for (int i = 0; i < filelist.length; i++) {

			if (filelist[i].isDirectory()) {
				list.addAll(getAllClassObject(filelist[i].getAbsolutePath()));
			} else {
				list.add(filelist[i].getAbsolutePath());
			}

		}
		return list;
	}
	
	/**
	 * 迭代获得所有类路径
	 * @param packagefilepath
	 * @return
	 */
	public List<String> getAllClassObjectNoiteration(String srcpath,String packagefilepath,String regex) {
		List<String> list = new ArrayList<String>();
		File src = new File(srcpath+"/"+packagefilepath);
		System.out.println("94src:"+src);
		File[] filelist = src.listFiles();
		for (int i = 0; i < filelist.length; i++) {

			if (filelist[i].isDirectory()) {
				
			} else {
				if(regex.equals("")){
					list.add(filelist[i].getAbsolutePath());
				}else{
					if(filelist[i].getName().matches(regex)){
						list.add(filelist[i].getAbsolutePath());
					}	
				}
				
				
			}

		}
		return list;
	}

	/**
	 * 获得所有类对象
	 * @param needfind 父类
	 * @return
	 */
	public List<Object> getReaAllClassObject(Object needfind) {
		List<Object> result = new ArrayList<Object>();
		String srcfilepath=getSrcFilePath(needfind);
		List<String> list = getAllClassObject(srcfilepath);
		for (int i = 0; i < list.size(); i++) {
			String classpath = list.get(i).replaceAll("\\\\", "/").replaceAll(srcfilepath, "").replaceAll("/", ".").trim();
			classpath=classpath.substring(0, classpath.length()-5);//去掉java这个后缀
			System.out.println("119classpath:"+classpath);
			try {
				Object tmp = Class.forName(classpath).newInstance();
				result.add(tmp);
			} catch (Exception e) {
				// TODO: handle exception
			}

		}
		return result;
	}

	/**
	 * 需要传一个包名下的对象 以此来获得 包绝对路径 获得包名下所有同级类
	 * 
	 * @param needfind
	 * @return
	 */
	public List<Object> getReaAllClassObjectInThisPackage(Object needfind,String regex) {
		List<Object> result = new ArrayList<Object>();
		String srcfilepath=getSrcFilePath(needfind);
		System.out.println("140src:"+srcfilepath);
		String packagefilepath=getPackageFilePath(needfind);
		System.out.println("142pack:"+packagefilepath);
		List<String> list = getAllClassObjectNoiteration(srcfilepath,packagefilepath,regex);
		for (int i = 0; i < list.size(); i++) {
			System.out.println("145:"+list.get(i));
			String classpath = list.get(i).replaceAll("\\\\", "/")
					.replaceAll(srcfilepath, "").replaceAll("/", ".")
					.trim();
			classpath=classpath.substring(0, classpath.length()-5);
			System.out.println("150:"+classpath);
			try {
				Object tmp = Class.forName(classpath).newInstance();
				result.add(tmp);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return result;
	}
	/**
	 * 获得所有符合约束的 子类对象
	 * @param parent
	 * @param expclassname
	 * @return
	 */
	public List<Object> getReaAllSubObject(Object parent,String[] expclassname) {
		List<Object> result = new ArrayList<Object>();
		List<Object> list = getReaAllClassObject(parent);
		for (int i = 0; i < list.size(); i++) {
			if(parent.getClass()==list.get(i).getClass()){
				
			}
			else if (parent.getClass().isAssignableFrom(list.get(i).getClass())) {
				if(isInExtClass(list.get(i),expclassname)){
					
				}else{
					result.add(list.get(i));
				}
				
			}
			else{
				
			}
		}
		return result;
	}
	/**
	 * 判断是否要排除
	 * @param target
	 * @param expclassname
	 * @return
	 */
	public boolean isInExtClass(Object target,String[] expclassname){
		boolean isin=false;
		for (int i = 0; i < expclassname.length; i++) {
			if(target.getClass().getSimpleName().matches("(.*)"+expclassname[i]+"(.*)")){
				isin=true;
				break;
			}
		}
		return isin;
	}
}
