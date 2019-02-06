package com.wisdomregulation.pdflink;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;

/**
 * Created by King6rf on 2017/6/15.
 * 段落辅助类
 */
public class ParagraphBuilder extends Paragraph{
    public ParagraphBuilder(Chunk chunk) {
        super(chunk);
    }
    public ParagraphBuilder() {
        super();
    }
    public ParagraphBuilder(String string) {
        super(string);
    }
    public ParagraphBuilder(String string, Font font) {
        super(string, font);
    }

    public ParagraphBuilder setAlignmentS(int alignment) {
        this.setAlignment(alignment);
        return this;
    }
    public ParagraphBuilder setFirstLineIndentS(float firstLineIndent) {
        this.setFirstLineIndent(firstLineIndent);
        return this;
    }
}
