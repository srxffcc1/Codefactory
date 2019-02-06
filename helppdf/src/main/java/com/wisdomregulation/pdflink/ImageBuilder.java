package com.wisdomregulation.pdflink;

import com.itextpdf.text.Image;

/**
 * Created by King6rf on 2017/6/15.
 * 图片辅助类
 */
public class ImageBuilder {
    public static Image getInstance(final Object object)  {
        try {
            if(object==null){
                return null;
            }
            else if(object.getClass().getSimpleName().equals(String.class.getSimpleName())){
                return Image.getInstance((String)object);
            }else if(object.getClass().getSimpleName().equals(java.net.URL.class.getSimpleName())){
                return Image.getInstance((java.net.URL)object);
            }else if(object.getClass().getSimpleName().equals(byte[].class.getSimpleName())){
                return Image.getInstance((byte[])object);
            }else{
                return null;
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;

    }
}
