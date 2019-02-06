package com.wisdomregulation.pdflink;

public class StringFactoryBuild {
    public static final AbstractStringFactory result=new StringFactory();
    public static AbstractStringFactory build(){
        return result;
    }
}
