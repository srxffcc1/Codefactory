package com.wisdomregulation.pdflink;

import java.io.*;

/**
 * Created by King6rf on 2017/4/6. 打印附件用的包裹类
 */
public class PdfImageCopy {
    private Object image;//是个byte[] 图片
    private String info="";

    private String imagepath;
    public PdfImageCopy() {

    }
    public PdfImageCopy(Object image) {
        this.image = image;
    }
    public PdfImageCopy(Object image, String info) {
        this.image = image;
        this.info = info;
    }
    public String getImagepath() {
        return imagepath;
    }

    public PdfImageCopy setImagepath(String imagepath) {
        this.imagepath = imagepath;
        return this;
    }



    public Object getImage() {
        if(image!=null){
            return image;
        }else{
            if(imagepath!=null){
                image=getBytes(imagepath);
            }
        }
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
    private byte[] getBytes(String filePath){
        byte[] buffer = null;
        try {
            File file = new File(filePath);
            FileInputStream fis = new FileInputStream(file);
            ByteArrayOutputStream bos = new ByteArrayOutputStream(1000);
            byte[] b = new byte[1000];
            int n;
            while ((n = fis.read(b)) != -1) {
                bos.write(b, 0, n);
            }
            fis.close();
            bos.close();
            buffer = bos.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buffer;
    }
}
