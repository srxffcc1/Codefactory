package com.wisdomregulation.shark;

import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfWriter;
import com.wisdomregulation.pdflink.DownLoaderTask;
import com.wisdomregulation.data.entitybase.Base_Entity;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class PdfFactoryEntity {
    protected PdfWriter dpfwPdfWriter;
    protected OutputStream pdfout;
    protected String fileout;
    protected boolean canprinter = false;
    protected Document document;
    protected static String city = "";
    protected Paragraph space1, space2, space3, space4;
    protected Rectangle rect;
    protected boolean ttfiscomplete = false;
    protected long timeout = 4000;
    protected DownLoaderTask.DownLoaderListener listener;
    protected long oldopentime = 0;
    protected String simdir;

    protected Font simkai2312_z1;
    /**
     * 黑体一，一等于26
     */
    protected Font simhei_z1;
    /**
     * 华文中宋小二，小二等于18
     */
    protected Font simzhongsong_zx2;
    /**
     * 华文中宋二，二等于22
     */
    protected Font simzhongsong_z2;
    /**
     * 仿宋_GB2312小三，小三等于15
     */
    protected Font simfang2312_zx3;
    /**
     * 仿宋_GB2312三，小三等于16
     */
    protected Font simfang2312_z3;
    /**
     * 仿宋_GB2312五号，五号等于10.5
     */
    protected Font simfang2312_z5;
    /**
     * 仿宋小四，小四等于10.5
     */
    protected Font simfang_zx4;
    protected int foottype = 0;//0为共几页第几页 1为第几页共几页
    /**
     * 临时保存用的文书list用来支持批量
     */
    protected List<Base_Entity> tmpbooklist = new ArrayList<Base_Entity>();
    protected boolean firstPrint = true;

    public PdfFactoryEntity(PdfWriter dpfwPdfWriter, OutputStream pdfout, String fileout, boolean canprinter, Document document, Paragraph space1, Paragraph space2, Paragraph space3, Paragraph space4, Rectangle rect, boolean ttfiscomplete, long timeout, DownLoaderTask.DownLoaderListener listener, long oldopentime, String simdir, Font simkai2312_z1, Font simhei_z1, Font simzhongsong_zx2, Font simzhongsong_z2, Font simfang2312_zx3, Font simfang2312_z3, Font simfang2312_z5, Font simfang_zx4, int foottype, List<Base_Entity> tmpbooklist, boolean firstPrint) {
        this.dpfwPdfWriter = dpfwPdfWriter;
        this.pdfout = pdfout;
        this.fileout = fileout;
        this.canprinter = canprinter;
        this.document = document;
        this.space1 = space1;
        this.space2 = space2;
        this.space3 = space3;
        this.space4 = space4;
        this.rect = rect;
        this.ttfiscomplete = ttfiscomplete;
        this.timeout = timeout;
        this.listener = listener;
        this.oldopentime = oldopentime;
        this.simdir = simdir;
        this.simkai2312_z1 = simkai2312_z1;
        this.simhei_z1 = simhei_z1;
        this.simzhongsong_zx2 = simzhongsong_zx2;
        this.simzhongsong_z2 = simzhongsong_z2;
        this.simfang2312_zx3 = simfang2312_zx3;
        this.simfang2312_z3 = simfang2312_z3;
        this.simfang2312_z5 = simfang2312_z5;
        this.simfang_zx4 = simfang_zx4;
        this.foottype = foottype;
        this.tmpbooklist = tmpbooklist;
        this.firstPrint = firstPrint;
    }
}
