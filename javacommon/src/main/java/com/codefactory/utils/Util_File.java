package com.codefactory.utils;

import com.codefactory.intface.CallBack;
import utils.EncodingDetect;
import utils.Util_String;

import java.io.*;

public class Util_File {
	public static String inputStream2String(String filePath) {
		String fileEncode= EncodingDetect.getJavaEncode(filePath);
//		System.out.println(fileEncode);
		InputStream is = null;
		try {
			is = new FileInputStream(filePath);
		} catch (Exception e) {

		}
		return inputStream2String(is,fileEncode);
	}

    public static String inputStream2String(File file) {
        String fileEncode=EncodingDetect.getJavaEncode(file.getAbsolutePath());
//        System.out.println(fileEncode);
        InputStream is = null;
        try {
            is = new FileInputStream(file.getAbsolutePath());
        } catch (Exception e) {

        }
        return inputStream2String(is,fileEncode);
    }
	public static void string2Stream(String needprint,File file){
		File fileparent=new File(file.getAbsolutePath()).getParentFile();
		if(fileparent!=null&&!fileparent.exists()){
			fileparent.mkdirs();
		}
		try {
			FileOutputStream os=new FileOutputStream(file.getAbsolutePath());
			os.write(needprint.getBytes());
			os.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	public static void string2Stream(String needprint,String filepath){
		File fileparent=new File(filepath).getParentFile();
		if(fileparent!=null&&!fileparent.exists()){
			fileparent.mkdirs();
		}
		try {
			FileOutputStream os=new FileOutputStream(filepath);
			os.write(needprint.getBytes());
			os.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	public static String inputStream2String(InputStream is,String charset) {

		InputStreamReader reader = null;
		StringWriter writer = new StringWriter();
		if (null == is) {
			return null;
		}
		StringBuilder resultSb = null;
		try {
			reader = new InputStreamReader(is, charset);
			char[] buffer = new char[1024];
			int n = 0;
			while (-1 != (n = reader.read(buffer))) {
				writer.write(buffer, 0, n);
			}
		} catch (Exception ex) {
		} finally {
			closeIO(is);
		}
		return null == writer ? null : writer.toString();
	}
	public static void closeIO(Closeable... closeables) {
		if (null == closeables || closeables.length <= 0) {
			return;
		}
		for (Closeable cb : closeables) {
			try {
				if (null == cb) {
					continue;
				}
				cb.close();
			} catch (IOException e) {

			}
		}
	}
    public static void deletelink(String parentpath,CallBack back) {
   	 
        File realFile = new File(parentpath);
        if (realFile.isDirectory()) {
            File[] subfiles = realFile.listFiles();
            for (File file : subfiles) {
                if (file.isDirectory()) {
                    deletelink(file.getAbsolutePath(),back);
                } else {
                	if(file.getName().matches("((.*)((?i)\\.LAYOUT\\.BINLAYOUT))|((.*)((?i)\\.DAT\\.BINDAT))")){
                		System.out.println(file.getAbsolutePath());
                		file.delete();
                		
                	}
                	
                }
            }
        }
    }
    //返回除了这些文件夹下的资源
	public static void getFileUnderDirEx(String parentpath,String direxregex,String filenameregex,CallBack back) {
//		System.out.println(direxregex);
		File realFile = new File(parentpath);
		if (realFile.isDirectory()) {
			File[] subfiles = realFile.listFiles();
			for (File file : subfiles) {
				if (file.isDirectory()) {
//
					if(file.getAbsolutePath().replace("\\","/").matches(direxregex)){
//						System.out.println(file.getAbsolutePath());
					}else{
						getFiles(file.getAbsolutePath(),filenameregex,back);
					}

				} else {
					if(!filenameregex.equals("")){
						if(file.getName().matches(filenameregex)){
							if(back!=null){
								back.back(file);
							}

//                    		System.out.println(file.getName());
//                    		String filepath=file.getAbsolutePath().replace("新IMBA最终版14_11_12", "STY");
//                    		if(new File(filepath).exists()){
//                    			back.back(file,new File(filepath));
//                    		}else{
//                    			back.back(file);
//                    		}

						}
					}else{
						if(back!=null){
							back.back(file);
						}
					}


				}
			}
		}

	}
    public static void getFiles(String parentpath,String filenameregex,CallBack back) {
    	 
        File realFile = new File(parentpath);
        if (realFile.isDirectory()) {
            File[] subfiles = realFile.listFiles();
            for (File file : subfiles) {
                if (file.isDirectory()) {
                    getFiles(file.getAbsolutePath(),filenameregex,back);
                } else {
                	if(!filenameregex.equals("")){
                		if(file.getName().matches(filenameregex)){
                    		if(back!=null){
                    			back.back(file);
                    		}
                    		
//                    		System.out.println(file.getName());
//                    		String filepath=file.getAbsolutePath().replace("新IMBA最终版14_11_12", "STY");
//                    		if(new File(filepath).exists()){
//                    			back.back(file,new File(filepath));
//                    		}else{
//                    			back.back(file);
//                    		}
                    		
                    	}
                	}else{
                		if(back!=null){
                			back.back(file);
                		}
                	}
                	
                	
                }
            }
        }else{
			if(!filenameregex.equals("")){
				if(realFile.getName().matches(filenameregex)){
					if(back!=null){
						back.back(realFile);
					}

//                    		System.out.println(file.getName());
//                    		String filepath=file.getAbsolutePath().replace("新IMBA最终版14_11_12", "STY");
//                    		if(new File(filepath).exists()){
//                    			back.back(file,new File(filepath));
//                    		}else{
//                    			back.back(file);
//                    		}

				}
			}else{
				if(back!=null){
					back.back(realFile);
				}
			}
		}
        
    }
	//拷贝文件
	public static void copy(String src, String des) {
		File file1=new File(src);
		File[] fs=file1.listFiles();
		File file2=new File(des);
		if(!file2.exists()){
			file2.mkdirs();
		}
		for (File f : fs) {
			if(f.isFile()){
				fileCopy(f.getPath(),des+"\\"+f.getName()); //调用文件拷贝的方法
			}else if(f.isDirectory()){
				copy(f.getPath(),des+"\\"+f.getName());
			}
		}

	}

	/**
	 * 文件拷贝的方法
	 */
	public  static void fileCopy(String src, String des) {

		try {
			FileInputStream ins = new FileInputStream(new File(src));
			FileOutputStream out = new FileOutputStream(new File(des));
			byte[] b = new byte[1024];
			int n=0;
			while((n=ins.read(b))!=-1){
                out.write(b, 0, n);
            }
			ins.close();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}


	}
}
