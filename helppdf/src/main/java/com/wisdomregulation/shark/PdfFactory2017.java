package com.wisdomregulation.shark;

import com.wisdomregulation.data.entitybase.Base_Entity;

public class PdfFactory2017 extends PdfFactory {
    //这段方法是单例模式的处理
    protected final static PdfFactory2017 pdfhelp = new PdfFactory2017();

    public static PdfFactory2017 create() {
        return pdfhelp;
    }

    @Override
    protected PdfFactory getFactory() {
        return pdfhelp;
    }
//自己实现有不一样需求要修改的文书
}
