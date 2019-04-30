package com.test.pdf;

import com.itextpdf.text.Font;

public class FontBuilder2 {
    Font font;

    public FontBuilder2(Font font) {
        this.font = font;
    }
    public FontBuilder2 setSize(final float size){
        font.setSize(size);
        return this;
    }
    public Font build(){
        return font;
    }
}
