package com.wisdomregulation.pdflink;

import com.itextpdf.text.Font;

public class FontBuilder {
    Font fonttmp;

    public FontBuilder(Font font) {
        fonttmp=new Font(font.getBaseFont(),font.getSize(),font.getStyle(),font.getColor());
    }
    public FontBuilder setSize(final float size){
        fonttmp.setSize(size);
        return this;
    }
    public Font build(){
        return fonttmp;
    }
}
