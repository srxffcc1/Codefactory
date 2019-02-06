//package com.wisdomregulation.shark;
//
//import com.itextpdf.text.BaseColor;
//import com.itextpdf.text.Chunk;
//import com.itextpdf.text.Document;
//import com.itextpdf.text.DocumentException;
//import com.itextpdf.text.Element;
//import com.itextpdf.text.Font;
//import com.itextpdf.text.FontFactory;
//import com.itextpdf.text.Image;
//import com.itextpdf.text.PageSize;
//import com.itextpdf.text.Paragraph;
//import com.itextpdf.text.Phrase;
//import com.itextpdf.text.Rectangle;
//import com.itextpdf.text.pdf.BaseField;
//import com.itextpdf.text.pdf.BaseFont;
//import com.itextpdf.text.pdf.ColumnText;
//import com.itextpdf.text.pdf.PdfContentByte;
//import com.itextpdf.text.pdf.PdfFormField;
//import com.itextpdf.text.pdf.PdfPCell;
//import com.itextpdf.text.pdf.PdfPTable;
//import com.itextpdf.text.pdf.PdfPageEvent;
//import com.itextpdf.text.pdf.PdfWriter;
//import com.itextpdf.text.pdf.RadioCheckField;
//import com.itextpdf.text.pdf.draw.LineSeparator;
//import com.wisdomregulation.pdflink.DownLoaderTask;
//import com.wisdomregulation.data.entitybase.Base_Entity;
//import com.wisdomregulation.pdflink.*;
//import com.wisdomregulation.staticlib.Static_BookLib;
//
//import java.io.*;
//import java.lang.reflect.Method;
//import java.util.ArrayList;
//import java.util.List;
//
//@Deprecated
//public class PdfFactoryOld {//未调整完毕
//    private Font fontChineseNormalsimfang12;
//    private Font fontChineseBoldsimfang16;
//    private Font fontChineseBoldsimhei15;
//    private Font fontChineseBoldsimhei20;
//    private Font fontChineseBoldsimhei19;
//    private Font fontChineseBoldsimhei17;
//    private PdfWriter dpfwPdfWriter;
//    private OutputStream pdfout;
//    private static final PdfFactoryOld pdfhelp = new PdfFactoryOld();
//    private BaseFont bfSongChinese;
//    private BaseFont bfHeiChinese;
//    private String fileout;
//    private boolean canprinter = false;
//    private Document document;
//    private static String city = "石家庄市";
//    private Paragraph space1;
//    private Paragraph space2;
//    private Rectangle rect;
//    public long timeout=4000;
//    DownLoaderTask.DownLoaderListener listener;
//    private List<Base_Entity> tmpbooklist = new ArrayList<Base_Entity>();
//    long oldopentime=0;
//    public String getCity() {
//        return city;
//    }
//
//    public PdfFactoryOld setCity(String city) {
//        PdfFactoryOld.city = city;
//        return this;
//    }
//
//    /**
//     * 获得输出路径
//     *
//     * @return
//     */
//    public String getFileout() {
//        return fileout;
//    }
//
//    /**
//     * 设置输出路径
//     *
//     * @param fileout
//     * @return
//     */
//    public PdfFactoryOld setFileout(String fileout) {
//        this.fileout = fileout;
//        try {
//            this.pdfout=new FileOutputStream(fileout);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        return this;
//    }
//    public PdfFactoryOld setPdfout(OutputStream pdfout) {
//        this.pdfout = pdfout;
//        return this;
//    }
//    /**
//     * 初始化一个pdf代理
//     *
//     * @return
//     */
//    public static PdfFactoryOld create() {
//        return pdfhelp;
//    }
//
//    /**
//     * 设置一般参数
//     */
//    private PdfFactoryOld() {
//    }
//
//    public PdfFactoryOld setListener(DownLoaderTask.DownLoaderListener listener) {
//        this.listener = listener;
//        return this;
//    }
//
//    /**
//     * 设置pdf字体
//     *
//     * @param simdir 字体路径
//     * @return
//     */
//    public PdfFactoryOld setTTFpath(String simdir) {
//        try {
//            if (fontChineseNormalsimfang12 == null) {
//
////                bfSongChinese = BaseFont.createFont(simpath + "simfang.ttf",
////                        BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
////                bfHeiChinese = BaseFont.createFont(simpath + "simhei.ttf",
////                        BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
//
//                long kaishishijian = System.currentTimeMillis();
////                if(!new File(simdir + "/simfang.ttf").exists()){
////                    DownLoaderTask.getInstance().setListener(listener).downloadFile(DownLoaderTask.qiniuhost+"simfang.ttf",simdir);
////                }
////                if(!new File(simdir + "/simfang2312.ttf").exists()){
////                    DownLoaderTask.getInstance().setListener(listener).downloadFile(DownLoaderTask.qiniuhost+"simfang2312.ttf",simdir);
////                }
////                if(!new File(simdir + "/simhei.ttf").exists()){
////                    DownLoaderTask.getInstance().setListener(listener).downloadFile(DownLoaderTask.qiniuhost+"simhei.ttf",simdir);
////                }
////                if(!new File(simdir + "/simkai2312.ttf").exists()){
////                    DownLoaderTask.getInstance().setListener(listener).downloadFile(DownLoaderTask.qiniuhost+"simkai2312.ttf",simdir);
////                }
////                if(!new File(simdir + "/simzhongsong.ttf").exists()){
////                    DownLoaderTask.getInstance().setListener(listener).downloadFile(DownLoaderTask.qiniuhost+"simzhongsong.ttf",simdir);
////                }
//
//                if(!"".equals(simdir)){
//                    simdir=simdir+"/";
//                    if (new File(simdir + "simfang.ttf").exists()
//                            && new File(simdir + "simfang2312.ttf").exists()
//                            && new File(simdir + "simhei.ttf").exists()
//                            && new File(simdir + "simkai2312.ttf").exists()
//                            && new File(simdir + "simzhongsong.ttf").exists()) {
//                    } else {
//                        DownLoaderTask.getInstance().setListener(listener).downloadFileandcompression(DownLoaderTask.qiniuhost + "Font.zip", simdir);
//
//                    }
//                }
//
//                fontChineseNormalsimfang12 = FontFactory.getFont(simdir + "simfang.ttf", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED, 12, Font.NORMAL,
//                        BaseColor.BLACK);
//                fontChineseBoldsimfang16 = FontFactory.getFont(simdir + "simfang.ttf", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED, 16, Font.BOLD,
//                        BaseColor.BLACK);
//
//                fontChineseBoldsimhei15 = FontFactory.getFont(simdir + "simhei.ttf", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED, 15, Font.BOLD,
//                        BaseColor.BLACK);
//                fontChineseBoldsimhei19 = FontFactory.getFont(simdir + "simhei.ttf", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED, 19, Font.NORMAL,
//                        BaseColor.BLACK);
//                fontChineseBoldsimhei17 = FontFactory.getFont(simdir + "simhei.ttf", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED, 17, Font.NORMAL,
//                        BaseColor.BLACK);
//                fontChineseBoldsimhei20 = FontFactory.getFont(simdir + "simhei.ttf", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED, 20, Font.BOLD,
//                        BaseColor.BLACK);
//            }
//
//        } catch (Exception e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        return this;
//
//    }
//    private PdfFactoryOld openImp() {
//        if(isopening){
//            return this;
//        }
//        isopening=true;
//        try {
//            oldopentime=System.currentTimeMillis();
//            tmpbooklist.clear();
//            document = new Document(PageSize.A4, 80, 80, 100, 55);
//            dpfwPdfWriter = PdfWriter.getInstance(document,
//                    pdfout);
//            // 改为全局打开
//            if (rect == null) {
//                rect = new Rectangle(36, 54, 559, 788);
//                rect.setBorderColor(BaseColor.BLACK);
//            }
//
//
//            dpfwPdfWriter.setBoxSize("art", rect);// 设置页面外部框格为了加页眉页脚做准备
//            document.open();
//            canprinter = true;
//        } catch (DocumentException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } catch (Exception e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        return this;
//    }
//    boolean isopening=false;
//    boolean iscloseing=false;
//    public PdfFactoryOld setTimeout(long timeout) {
//        this.timeout = timeout;
//        return this;
//    }
//    /**
//     * 打开pdf文件开始写入
//     *
//     * @return
//     */
//    public PdfFactoryOld open() {
//        if(oldopentime==0){
//            oldopentime= System.currentTimeMillis();
//            return openImp();
//        }else{
//            long sub=System.currentTimeMillis()-oldopentime;
//            if(sub>timeout){
//                return openImp();
//            }else{
//
//            }
//            return this;
//        }
//
//
//
//
//    }
//
//    /**
//     * 写完之后关闭pdf文件
//     *
//     * @return
//     */
//    public PdfFactoryOld close() {
//        return close(null);
//    }
//    public PdfFactoryOld closeOnMainThread(final IPdfBack back) {
//        if(!isopening){
//            if (back != null) {
//                back.writeError();
//            }
//            return this;
//        }
//        if(iscloseing){
//            if (back != null) {
//                back.writeError();
//            }
//            return this;
//        }
//        iscloseing=true;
//        try {
//            if (back != null) {
//                back.writeStart();
//            }
//            for (int i = 0; i < tmpbooklist.size(); i++) {
//                Base_Entity book = tmpbooklist.get(i);
//                Object image = tmpbooklist.get(i).getExtraObj();
//                try {
//                    book.resetKey();
//                    Method printm = getClass().getDeclaredMethod("printer" + book.getClass().getSimpleName(), Base_Entity.class, Object.class);
//                    printm.setAccessible(true);
//                    printm.invoke(PdfFactoryOld.this, book, image);
//                    book.resetKey();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//
//            try {
//                document.close();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            if (back != null) {
//                back.writeEnd();
//            }
//            isopening=false;
//            iscloseing=false;
//            canprinter = false;
//
//        } catch (Exception e) {
//
//        }
//        return this;
//    }
//    /**
//     * 写完之后关闭pdf文件
//     *
//     * @return
//     */
//    public PdfFactoryOld close(final IPdfBack back) {
//        if(!isopening){
//            if (back != null) {
//                back.writeError();
//            }
//            return this;
//        }
//        if(iscloseing){
//            if (back != null) {
//                back.writeError();
//            }
//            return this;
//        }
//        iscloseing=true;
//        try {
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    if (back != null) {
//                        back.writeStart();
//                    }
//                    for (int i = 0; i < tmpbooklist.size(); i++) {
//                        Base_Entity book = tmpbooklist.get(i);
//                        Object image = tmpbooklist.get(i).getExtraObj();
//                        try {
//                            Method printm = PdfFactoryOld.this.getClass().getDeclaredMethod("printer" + book.getClass().getSimpleName(), Base_Entity.class, Object.class);
//                            printm.setAccessible(true);
//                            printm.invoke(PdfFactoryOld.this, book, image);
//                            book.resetKey();
//                        } catch (Exception e) {
//                            e.printStackTrace();
//                        }
//                    }
//                    try {
//                        document.close();
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                    if (back != null) {
//                        back.writeEnd();
//                    }
//                    isopening=false;
//                    iscloseing=false;
//                    canprinter = false;
//                }
//            }).start();
//
//        } catch (Exception e) {
//
//        }
//        return this;
//    }
//
//    public PdfFactoryOld printerMaster(final Base_Entity book, final Object image) {
//
//        if (!canprinter) {
//            return this;
//        } else {
//            tmpbooklist.add(book.setExtraObj(image));
////            try {
////                Method printm = this.getClass().getDeclaredMethod("printer" + book.getClass().getSimpleName(), Base_Entity.class, Object.class);
////                printm.setAccessible(true);
////                printm.invoke(this, book, image);
////            } catch (Exception e) {
////                e.printStackTrace();
////            }
//            return this;
//        }
//
//    }
//
//    /**
//     * 输出成pdf的管理方法
//     *
//     * @param book
//     * @return
//     */
//
//    public PdfFactoryOld printerMaster(final Base_Entity book) {
//        if (!canprinter) {
//            return this;
//        } else {
//            tmpbooklist.add(book.setExtraObj(null));
////            try {
////                Method printm = this.getClass().getDeclaredMethod("printer" + book.getClass().getSimpleName(), Base_Entity.class, Object.class);
////                printm.setAccessible(true);
////                printm.invoke(this, book, null);
////            } catch (Exception e) {
////                e.printStackTrace();
////            }
//            return this;
//        }
//
//    }
//
//    /**
//     * 测量长度
//     *
//     * @param phrase1
//     */
//    public static void toMeasurefloat(Phrase phrase1) {
//        float result = 0;
//        List<Chunk> mArrayList1 = phrase1.getChunks();
//        for (int i = 0; i < mArrayList1.size(); i++) {
//            float everyblock = ((Chunk) (mArrayList1.get(i))).getWidthPoint();
//            result = result + everyblock;
//        }
////        PdfFactoryLog.println(result);
//    }
//
//    /**
//     * 测量长度
//     *
//     * @param phrase1
//     */
//    public static void toNewMeasurefloat(Phrase phrase1) {
//        float result = 0;
//        List<Chunk> mArrayList1 = phrase1.getChunks();
//        for (int i = 0; i < mArrayList1.size(); i++) {
//            float everyblock = ((Chunk) (mArrayList1.get(i))).getWidthPoint();
//            result = result + everyblock;
//        }
//
//    }
//
//    /**
//     * 获得文书类型
//     *
//     * @param booktypename
//     * @return
//     */
//    public static Base_Entity getEneityBook(String booktypename) {
//        int typeid = -1;
//        Base_Entity bookeneity = null;
//        for (int i = 1; i < Static_BookLib.BOOKNAMELIST.length; i++) {
//            if (booktypename.equals(Static_BookLib.BOOKNAMELIST[i])) {
//                typeid = i - 1;
//                break;
//            }
//        }
//        if (typeid != -1) {
//            try {
//                bookeneity = (Base_Entity) (Class.forName("com.wisdomregulation.data.entitybook." + "Entity_Book" + (typeid)).newInstance());
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        return bookeneity;
//    }
//
//    //将用@符号和#号进行分割
//    public static String getListItemValue(String orgliststring, int listindex, int itemindex) {
//
//        String[] listitem = null;
//        String[] listitemitem = null;
//        if (orgliststring != null && orgliststring.matches("(.*)@(.*)")) {
//            listitem = orgliststring.split("@");
//            if (listitem != null && listitem.length >= listindex + 1) {
//                listitemitem = listitem[listindex].split("#");
//                if (listitemitem != null && listitemitem.length >= itemindex + 1) {
//                    return listitemitem[itemindex].trim();
//                } else {
//                    return "";
//                }
//            } else {
//                return "";
//            }
//        } else {
//            return "";
//        }
//
//    }
//
//    public void printFrameWork(final Base_Entity book, final Object image, IPdfBackFrame pdf_backframe) {
//        try {
//            if (space1 == null) {
//                space1 = new Paragraph("  ");
//                space1.setLeading(1f);// 自定义空格
//                space1.setSpacingBefore(5f);
//            }
//            if (space2 == null) {
//                space2 = new Paragraph("  ");
//                space2.setLeading(1f);// 自定义空格
//                space2.setSpacingBefore(5f);
//            }
//
//            // 改为全局打开//打开
//
//            dpfwPdfWriter.setPageEvent(new PdfPageEvent() {// 换页监听
//
//                @Override
//                public void onStartPage(PdfWriter arg0, Document arg1) {
//                    // TODO Auto-generated method stub
//
//                }
//
//                @Override
//                public void onSectionEnd(PdfWriter arg0, Document arg1,
//                                         float arg2) {
//                    // TODO Auto-generated method stub
//
//                }
//
//                @Override
//                public void onSection(PdfWriter arg0, Document arg1,
//                                      float arg2, int arg3, final Paragraph arg4) {
//                    // TODO Auto-generated method stub
//
//                }
//
//                @Override
//                public void onParagraphEnd(PdfWriter arg0,
//                                           Document arg1, float arg2) {
//                    // TODO Auto-generated method stub
//
//                }
//
//                @Override
//                public void onParagraph(PdfWriter arg0, Document arg1,
//                                        float arg2) {
//                    // TODO Auto-generated method stub
//
//                }
//
//                @Override
//                public void onOpenDocument(PdfWriter arg0, Document arg1) {
//                    // TODO Auto-generated method stub
//
//                }
//
//                @Override
//                public void onGenericTag(PdfWriter arg0, Document arg1,
//                                         Rectangle arg2, String arg3) {
//                    // TODO Auto-generated method stub
//
//                }
//
//                @Override
//                public void onEndPage(PdfWriter arg0, Document arg1) {
//                    Rectangle rect = dpfwPdfWriter.getBoxSize("art");
//                    // switch(dpfwPdfWriter.getPageNumber() % 2) {
//                    // case 0:
//                    // ColumnText.showTextAligned(dpfwPdfWriter.getDirectContent(),
//                    // Element.ALIGN_RIGHT, new Phrase("even header"),
//                    // rect.getRight(), rect.getTop(), 0);
//                    // break;
//                    // case 1:
//                    // ColumnText.showTextAligned(dpfwPdfWriter.getDirectContent(),
//                    // Element.ALIGN_CENTER, new Phrase("odd header"),
//                    // (rect.getLeft() + rect.getRight()) / 2,
//                    // rect.getTop(), 0);
//                    // break;
//                    // }
//                    // ColumnText.showTextAligned(dpfwPdfWriter.getDirectContent(),
//                    // Element.ALIGN_CENTER, new
//                    // Phrase(String.format("page %d",
//                    // dpfwPdfWriter.getPageNumber())),
//                    // (rect.getLeft() + rect.getRight()) / 2,
//                    // rect.getBottom() - 18, 0);
//
//                }
//
//                @Override
//                public void onCloseDocument(PdfWriter arg0,
//                                            Document arg1) {
//                    // TODO Auto-generated method stub
//
//                }
//
//                @Override
//                public void onChapterEnd(PdfWriter arg0, Document arg1,
//                                         float arg2) {
//                    // TODO Auto-generated method stub
//
//                }
//
//                @Override
//                public void onChapter(PdfWriter arg0, Document arg1,
//                                      float arg2, final Paragraph arg3) {
//                    // TODO Auto-generated method stub
//
//                }
//            });
//            pdf_backframe.writeContent();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void printerContinue(final Base_Entity book, final Object image, final IPdfBack pdf_back, final int newpagelength) {
//        printFrameWork(book, image, new IPdfBackFrame() {
//            @Override
//            public void writeContent() throws Exception {
//                final Paragraph title = new Paragraph("续页", fontChineseNormalsimfang12);// Paragraph就是段落
//                title.setLeading(1f);// 段落距离
//                // title.setSpacingBefore(25f);//段落留白
//                title.setAlignment(Element.ALIGN_RIGHT);// 居中
//                document.add(title);// 写入文档
//                final Paragraph titleLine1 = new Paragraph(new Chunk(new LineSeparator()));// 加入一个换行
//                titleLine1.setLeading(1f);
//                titleLine1.setSpacingBefore(5f);
//                document.add(titleLine1);
//                final Paragraph titleLine2 = new Paragraph(new Chunk(new LineSeparator()));
//                titleLine2.setLeading(1f);
//                titleLine2.setSpacingBefore(1f);
//                document.add(titleLine2);
//                final Paragraph title2 = new Paragraph("", fontChineseBoldsimhei15);
//
//                title2.setLeading(1f);
////			title2.setSpacingBefore(17f);
//                title2.setAlignment(Element.ALIGN_CENTER);
//                document.add(title2);
//
//                final Paragraph paragraph5 = new Paragraph();
//                paragraph5.setAlignment(Element.ALIGN_LEFT);
////			paragraph5.setIndentationLeft(24f);
//                paragraph5.setLeading(20f);
//
//                Phrase phrase6 = new Phrase();
//                phrase6.add(ChunkFactoryOld.tableunderLine("", newpagelength,
//                        fontChineseNormalsimfang12));
//                toMeasurefloat(phrase6);
//                paragraph5.add(phrase6);
//
//                document.add(paragraph5);
//                if (pdf_back != null) {
//                    pdf_back.writeEnd();
//                }
//                PdfContentByte canvas2 = dpfwPdfWriter.getDirectContent();
//                // 电子签章
//                Image img = ImageBuilder.getInstance(image);
//                if (img != null) {
//                    img.setAbsolutePosition(350, 140);
//                    canvas2.addImage(img);
//                }
//
//                document.newPage();// 结束保存
//            }
//        });
//
//    }
//
//    //立案审批表
//    public void printerEntity_Book0(final Base_Entity book, final Object image) {
//        printFrameWork(book, image, new IPdfBackFrame() {
//            @Override
//            public void writeContent() throws Exception {
//                //此处写页面布局
//                final Paragraph title = new Paragraph("" + city + "安全生产行政执法文书", fontChineseBoldsimhei15);// Paragraph就是段落
//                title.setLeading(1f);// 段落距离
//                // title.setSpacingBefore(25f);//段落留白
//                title.setAlignment(Element.ALIGN_CENTER);// 居中
//                document.add(title);// 写入文档
//                final Paragraph titleLine1 = new Paragraph(new Chunk(new LineSeparator()));// 加入一个换行
//                titleLine1.setLeading(1f);
//                titleLine1.setSpacingBefore(5f);
//                document.add(titleLine1);
//                final Paragraph titleLine2 = new Paragraph(new Chunk(new LineSeparator()));
//                titleLine2.setLeading(1f);
//                titleLine2.setSpacingBefore(1f);
//                document.add(titleLine2);
//                final Paragraph title2 = new Paragraph("立案审批表", fontChineseBoldsimhei15);
//
//                title2.setLeading(1f);
//                title2.setSpacingBefore(17f);
//                title2.setAlignment(Element.ALIGN_CENTER);
//                document.add(title2);
//
//                final Paragraph title3 = new Paragraph("( " + book.getValue(0)
//                        + " )安监管立〔" + book.getValue(1) + "〕" + book.getValue(2)
//                        + "号", fontChineseNormalsimfang12);
//                title3.setLeading(1f);
//                title3.setSpacingBefore(34f);
//                title3.setAlignment(Element.ALIGN_CENTER);
//                document.add(title3);
//
//                document.add(space1);
//
//                final Paragraph firstParagraph6 = new Paragraph();
//                firstParagraph6.setIndentationLeft(24f);
//                firstParagraph6.setLeading(24f);
//                firstParagraph6.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase1 = new Phrase();
//                phrase1.add(new Chunk("案由：", fontChineseNormalsimfang12));
//                phrase1.add(ChunkFactoryOld.underLine(book.getValue(3), 360,
//                        fontChineseNormalsimfang12));
//                toMeasurefloat(phrase1);
//
//                Phrase phrase2 = new Phrase();
//                phrase2.add(new Chunk("案件来源：", fontChineseNormalsimfang12));
//                phrase2.add(ChunkFactoryOld.underLine(book.getValue(4), 190,
//                        fontChineseNormalsimfang12));
//                phrase2.add(new Chunk("时间：", fontChineseNormalsimfang12));
//                phrase2.add(ChunkFactoryOld.underLine(book.getValue(5), 100,
//                        fontChineseNormalsimfang12));
//                toMeasurefloat(phrase2);
//
//                Phrase phrase3 = new Phrase();
//                phrase3.add(new Chunk("案件名称：", fontChineseNormalsimfang12));
//                phrase3.add(ChunkFactoryOld.underLine(book.getValue(6), 340,
//                        fontChineseNormalsimfang12));
//                toMeasurefloat(phrase3);
//
//                Phrase phrase4 = new Phrase();
//                phrase4.add(new Chunk("当事人：", fontChineseNormalsimfang12));
//                phrase4.add(ChunkFactoryOld.underLine(book.getValue(7), 180,
//                        fontChineseNormalsimfang12));
//                phrase4.add(new Chunk("电话：", fontChineseNormalsimfang12));
//                phrase4.add(ChunkFactoryOld.underLine(book.getValue(8), 122,
//                        fontChineseNormalsimfang12));
//                toMeasurefloat(phrase4);
//
//                Phrase phrase5 = new Phrase();
//                phrase5.add(new Chunk("当事人基本情况：", fontChineseNormalsimfang12));
//                phrase5.add(ChunkFactoryOld.underLine(book.getValue(9), 300,
//                        fontChineseNormalsimfang12));
//                toMeasurefloat(phrase5);
//
//                Phrase phrase6 = new Phrase();
//                phrase6.add(new Chunk("当事人地址：", fontChineseNormalsimfang12));
//                phrase6.add(ChunkFactoryOld.underLine(book.getValue(10), 180,
//                        fontChineseNormalsimfang12));
//                phrase6.add(new Chunk("邮编：", fontChineseNormalsimfang12));
//                phrase6.add(ChunkFactoryOld.underLine(book.getValue(11), 100,
//                        fontChineseNormalsimfang12));
//                toMeasurefloat(phrase6);
//
//                firstParagraph6.add(phrase1);
//                firstParagraph6.add(phrase2);
//                firstParagraph6.add(phrase3);
//                firstParagraph6.add(phrase4);
//                firstParagraph6.add(phrase5);
//                firstParagraph6.add(phrase6);
//
//                document.add(firstParagraph6);
//                document.add(space2);
//
//                PdfPTable table = new PdfPTable(1);
//                table.getDefaultCell().setUseAscender(false);
//                table.getDefaultCell().setUseDescender(true);
//
//                table.setSpacingBefore(10f);// 设置表格上面空白宽度
//                table.setWidthPercentage(100f);
//
//                PdfPCell rowCell1 = new PdfPCell();
//                Phrase rowCell1P = new Phrase();
//                final Paragraph tableParagraph1 = new Paragraph();
//                rowCell1P.add(new Chunk("案件基本情况：", fontChineseNormalsimfang12));
//                rowCell1P.add(ChunkFactoryOld.tablenounderLine(
//                        book.getValue(12), 3372, fontChineseNormalsimfang12));
//                tableParagraph1.add(rowCell1P);
//                rowCell1.addElement(tableParagraph1);
//
//                PdfPCell rowCell2 = new PdfPCell();
//                Phrase rowCell2P1 = new Phrase();
//                Phrase rowCell2P2 = new Phrase();
//                Phrase rowCell2P3 = new Phrase();
//                final Paragraph tableParagraph2 = new Paragraph();
//                tableParagraph2.setLeading(30f);
//                rowCell2P1.add(new Chunk("承办人意见：", fontChineseNormalsimfang12));
//                rowCell2P1.add(ChunkFactoryOld.tablenounderLine(
//                        book.getValue(13), 330, fontChineseNormalsimfang12));
//                toMeasurefloat(rowCell2P1);
//                rowCell2P2.add(new Chunk("\n承办人（签名）：", fontChineseNormalsimfang12));
//                rowCell2P2.add(ChunkFactoryOld.tableunderLine(
//                        book.getValue(14), 48, fontChineseNormalsimfang12));
//                rowCell2P2.add(new Chunk("证号：", fontChineseNormalsimfang12));
//                rowCell2P2.add(ChunkFactoryOld.tableunderLine(
//                        book.getValue(15), 48, fontChineseNormalsimfang12));
//                rowCell2P2.add(ChunkFactoryOld.tablenounderLine("", 276,
//                        fontChineseNormalsimfang12));
//                toMeasurefloat(rowCell2P2);
//
//                rowCell2P3.add(ChunkFactoryOld.tablenounderLine("", 72,
//                        fontChineseNormalsimfang12));
//                rowCell2P3.add(ChunkFactoryOld.tableunderLine(
//                        book.getValue(16), 48, fontChineseNormalsimfang12));
//                rowCell2P3.add(new Chunk("证号：", fontChineseNormalsimfang12));
//                rowCell2P3.add(ChunkFactoryOld.tableunderLine(
//                        book.getValue(17), 48, fontChineseNormalsimfang12));
//                rowCell2P3.add(ChunkFactoryOld.tablenounderLine("", 36,
//                        fontChineseNormalsimfang12));
//                rowCell2P3.add(ChunkFactoryOld.tablenounderLine(StringFactoryBuild.build().getTime(book.getValue(18), 0), 18,
//                        fontChineseNormalsimfang12));
//                rowCell2P3.add(new Chunk("年", fontChineseNormalsimfang12));
//                rowCell2P3.add(ChunkFactoryOld.tablenounderLine(StringFactoryBuild.build().getTime(book.getValue(18), 1), 12,
//                        fontChineseNormalsimfang12));
//                rowCell2P3.add(new Chunk("月", fontChineseNormalsimfang12));
//                rowCell2P3.add(ChunkFactoryOld.tablenounderLine(StringFactoryBuild.build().getTime(book.getValue(18), 2), 12,
//                        fontChineseNormalsimfang12));
//                rowCell2P3.add(new Chunk("日", fontChineseNormalsimfang12));
//                toMeasurefloat(rowCell2P3);
//
//                tableParagraph2.add(rowCell2P1);
//                tableParagraph2.add(rowCell2P2);
//                tableParagraph2.add(rowCell2P3);
//                rowCell2.addElement(tableParagraph2);
//
//                PdfPTable celltable = new PdfPTable(2);
//                PdfPTable celltable3 = new PdfPTable(1);
//                PdfPTable celltable4 = new PdfPTable(1);
//                final Paragraph tableParagraph31 = new Paragraph();
//                tableParagraph31.setLeading(15f);
//                final Paragraph tableParagraph32 = new Paragraph();
//                tableParagraph32.setLeading(15f);
//                PdfPCell rowCell311;
//                PdfPCell rowCell312;
//                Phrase rowCell3P1 = new Phrase();
//                Phrase rowCell3P2 = new Phrase();
//                Phrase rowCell3P3 = new Phrase();
//                Phrase rowCell3P4 = new Phrase();
//                rowCell3P1.add(new Chunk("审核意见：", fontChineseNormalsimfang12));
//                rowCell3P1.add(ChunkFactoryOld.tablenounderLine(book.getValue(19), 648,
//                        fontChineseNormalsimfang12));
//                toMeasurefloat(rowCell3P1);
//                toMeasurefloat(rowCell3P2);
//
//                rowCell3P3.add(ChunkFactoryOld.tablenounderLine("    ",
//                        60, fontChineseNormalsimfang12));
//                rowCell3P3.add(new Chunk("审核人（签名）：", fontChineseNormalsimfang12));
//                rowCell3P3.add(ChunkFactoryOld.tablenounderLine(book.getValue(20), 48,
//                        fontChineseNormalsimfang12));
//                rowCell3P3.add(ChunkFactoryOld.tablenounderLine("    ",
//                        120, fontChineseNormalsimfang12));
//                toMeasurefloat(rowCell3P3);
//                rowCell3P4.add(ChunkFactoryOld.tablenounderLine("    ",
//                        60, fontChineseNormalsimfang12));
//                rowCell3P4.add(ChunkFactoryOld.tablenounderLine(StringFactoryBuild.build().getTime(book.getValue(21), 0), 72,
//                        fontChineseNormalsimfang12));
//                rowCell3P4.add(new Chunk("年", fontChineseNormalsimfang12));
//                rowCell3P4.add(ChunkFactoryOld.tablenounderLine(StringFactoryBuild.build().getTime(book.getValue(21), 1), 18,
//                        fontChineseNormalsimfang12));
//                rowCell3P4.add(new Chunk("月", fontChineseNormalsimfang12));
//                rowCell3P4.add(ChunkFactoryOld.tablenounderLine(StringFactoryBuild.build().getTime(book.getValue(21), 2), 18,
//                        fontChineseNormalsimfang12));
//                rowCell3P4.add(new Chunk("日", fontChineseNormalsimfang12));
//                toMeasurefloat(rowCell3P4);
//
//                tableParagraph31.add(rowCell3P1);
//                tableParagraph31.add(rowCell3P2);
//                tableParagraph32.add(rowCell3P3);
//                tableParagraph32.add(rowCell3P4);
//                rowCell311 = new PdfPCell();
//                rowCell311.setFixedHeight(60f);
//                rowCell311.setBorder(0);
//                rowCell311.addElement(tableParagraph31);
//                rowCell312 = new PdfPCell();
//                rowCell312.setFixedHeight(20f);
//                rowCell312.setBorder(0);
//                rowCell312.addElement(tableParagraph32);
//
//                celltable3.addCell(rowCell311);
//                celltable3.addCell(rowCell312);
//
//                final Paragraph tableParagraph41 = new Paragraph();
//                tableParagraph41.setLeading(15f);
//                final Paragraph tableParagraph42 = new Paragraph();
//                tableParagraph42.setLeading(15f);
//                PdfPCell rowCell411;
//                PdfPCell rowCell412;
//                Phrase rowCell4P1 = new Phrase();
//                Phrase rowCell4P2 = new Phrase();
//                Phrase rowCell4P3 = new Phrase();
//                Phrase rowCell4P4 = new Phrase();
//                rowCell4P1.add(new Chunk("审批意见：", fontChineseNormalsimfang12));
//                rowCell4P1.add(ChunkFactoryOld.tablenounderLine(book.getValue(22), 648,
//                        fontChineseNormalsimfang12));
//                toMeasurefloat(rowCell4P1);
//                toMeasurefloat(rowCell4P2);
//
//                rowCell4P3.add(ChunkFactoryOld.tablenounderLine("    ",
//                        60, fontChineseNormalsimfang12));
//                rowCell4P3.add(new Chunk("审批人（签名）：", fontChineseNormalsimfang12));
//                rowCell4P3.add(ChunkFactoryOld.tablenounderLine(book.getValue(23), 48,
//                        fontChineseNormalsimfang12));
//                rowCell4P3.add(ChunkFactoryOld.tablenounderLine("   ",
//                        120, fontChineseNormalsimfang12));
//                toMeasurefloat(rowCell4P3);
//                rowCell4P4.add(ChunkFactoryOld.tablenounderLine("   ",
//                        60, fontChineseNormalsimfang12));
//                rowCell4P4.add(ChunkFactoryOld.tablenounderLine(StringFactoryBuild.build().getTime(book.getValue(24), 0), 72,
//                        fontChineseNormalsimfang12));
//                rowCell4P4.add(new Chunk("年", fontChineseNormalsimfang12));
//                rowCell4P4.add(ChunkFactoryOld.tablenounderLine(StringFactoryBuild.build().getTime(book.getValue(24), 1), 18,
//                        fontChineseNormalsimfang12));
//                rowCell4P4.add(new Chunk("月", fontChineseNormalsimfang12));
//                rowCell4P4.add(ChunkFactoryOld.tablenounderLine(StringFactoryBuild.build().getTime(book.getValue(24), 2), 18,
//                        fontChineseNormalsimfang12));
//                rowCell4P4.add(new Chunk("日", fontChineseNormalsimfang12));
//                toMeasurefloat(rowCell4P4);
//
//                tableParagraph41.add(rowCell4P1);
//                tableParagraph41.add(rowCell4P2);
//                tableParagraph42.add(rowCell4P3);
//                tableParagraph42.add(rowCell4P4);
//                rowCell411 = new PdfPCell();
//                rowCell411.setFixedHeight(60f);
//                rowCell411.setBorder(0);
//                rowCell411.addElement(tableParagraph41);
//                rowCell412 = new PdfPCell();
//                rowCell412.setFixedHeight(20f);
//                rowCell412.setBorder(0);
//                rowCell412.addElement(tableParagraph42);
//                celltable4.addCell(rowCell411);
//                celltable4.addCell(rowCell412);
//
//                celltable.addCell(celltable3);
//                celltable.addCell(celltable4);
//
//                PdfPCell rowCell3;
//                rowCell3 = new PdfPCell(celltable);
//                rowCell1.setFixedHeight(230f);
//                rowCell2.setFixedHeight(100f);
//                rowCell3.setFixedHeight(115f);
//                table.addCell(rowCell1);
//                table.addCell(rowCell2);
//                table.addCell(rowCell3);
//
//                document.add(table);
//                PdfContentByte canvas2 = dpfwPdfWriter.getDirectContent();
//                // 电子签章
//                Image img = ImageBuilder.getInstance(image);
//                if (img != null) {
//                    img.setAbsolutePosition(350, 140);
//                    canvas2.addImage(img);
//                }
//                document.newPage();// 结束保存
//            }
//        });
//
//    }
//
//    //询问通知单
//    public void printerEntity_Book1(final Base_Entity book, final Object image) {
//        printFrameWork(book, image, new IPdfBackFrame() {
//            @Override
//            public void writeContent() throws Exception {
//                //此处写页面布局
//                final Paragraph title = new Paragraph("" + city + "安全生产行政执法文书", fontChineseBoldsimhei15);// Paragraph就是段落
//                title.setLeading(1f);// 段落距离
//                // title.setSpacingBefore(25f);//段落留白
//                title.setAlignment(Element.ALIGN_CENTER);// 居中
//                document.add(title);// 写入文档
//                final Paragraph titleLine1 = new Paragraph(new Chunk(new LineSeparator()));// 加入一个换行
//                titleLine1.setLeading(1f);
//                titleLine1.setSpacingBefore(5f);
//                document.add(titleLine1);
//                final Paragraph titleLine2 = new Paragraph(new Chunk(new LineSeparator()));
//                titleLine2.setLeading(1f);
//                titleLine2.setSpacingBefore(1f);
//                document.add(titleLine2);
//                final Paragraph title2 = new Paragraph("询问通知书", fontChineseBoldsimhei15);
//
//                title2.setLeading(1f);
//                title2.setSpacingBefore(17f);
//                title2.setAlignment(Element.ALIGN_CENTER);
//                document.add(title2);
//
//                final Paragraph title3 = new Paragraph("( " + book.getValue(0) + " )安监管询〔" + book.getValue(1) + "〕"
//                        + book.getValue(2) + "号", fontChineseNormalsimfang12);
//                title3.setLeading(1f);
//                title3.setSpacingBefore(34f);
//                title3.setAlignment(Element.ALIGN_CENTER);
//                document.add(title3);
//
//                document.add(space1);
//                document.add(space1);
//
//                final Paragraph entParagraph = new Paragraph();
//                entParagraph.setLeading(24f);
//                entParagraph.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase1 = new Phrase();
//                phrase1.add((ChunkFactoryOld.underLine(book.getValue(3), 192,
//                        fontChineseNormalsimfang12)));
//                phrase1.add(new Chunk(":", fontChineseNormalsimfang12));
//                toMeasurefloat(phrase1);
//
//                entParagraph.add(phrase1);
//
//                document.add(entParagraph);
//
//                final Paragraph paragraph1 = new Paragraph();
//                paragraph1.setFirstLineIndent(24f);
//                paragraph1.setLeading(24f);
//                paragraph1.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase2 = new Phrase();
//                phrase2.add(new Chunk("因", fontChineseNormalsimfang12));
//                phrase2.add(ChunkFactoryOld.underLine(book.getValue(4), 336,
//                        fontChineseNormalsimfang12));
//                phrase2.add(new Chunk("，请你于", fontChineseNormalsimfang12));
//
//                toMeasurefloat(phrase2);
//
//                Phrase phrase3 = new Phrase();
//                phrase3.add(ChunkFactoryOld.underLine(StringFactoryBuild.build().getTime(book.getValue(5), 0), 24,
//                        fontChineseNormalsimfang12));
//                phrase3.add(new Chunk("年", fontChineseNormalsimfang12));
//                phrase3.add(ChunkFactoryOld.underLine(StringFactoryBuild.build().getTime(book.getValue(5), 1), 24,
//                        fontChineseNormalsimfang12));
//                phrase3.add(new Chunk("月", fontChineseNormalsimfang12));
//                phrase3.add(ChunkFactoryOld.underLine(StringFactoryBuild.build().getTime(book.getValue(5), 2), 24,
//                        fontChineseNormalsimfang12));
//                phrase3.add(new Chunk("日", fontChineseNormalsimfang12));
//                phrase3.add(ChunkFactoryOld.underLine(StringFactoryBuild.build().getTime(book.getValue(5), 3), 24,
//                        fontChineseNormalsimfang12));
//                phrase3.add(new Chunk("时到", fontChineseNormalsimfang12));
//                phrase3.add(ChunkFactoryOld.underLine(book.getValue(6), 112,
//                        fontChineseNormalsimfang12));
//                phrase3.add(new Chunk("接受询问调查，来时", fontChineseNormalsimfang12));
//                toMeasurefloat(phrase3);
//
//                Phrase phrase4 = new Phrase();
//                phrase4.add(new Chunk("请携带下列证件材料（见打√处）：", fontChineseNormalsimfang12));
//                toMeasurefloat(phrase4);
//
//                paragraph1.add(phrase2);
//                paragraph1.add(phrase3);
//                paragraph1.add(phrase4);
//
//                document.add(paragraph1);
//
//                final Paragraph paragraph2 = new Paragraph();
//                paragraph2.setIndentationLeft(36f);
//                paragraph2.setLeading(24f);
//                paragraph2.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase5 = new Phrase();
//                phrase5.add(new Chunk("身份证", fontChineseNormalsimfang12));
//                phrase5.add(Chunk.NEWLINE);
//                toMeasurefloat(phrase5);
//
//                Phrase phrase6 = new Phrase();
//                phrase6.add(new Chunk("营业执照", fontChineseNormalsimfang12));
//                phrase6.add(Chunk.NEWLINE);
//                toMeasurefloat(phrase6);
//
//                Phrase phrase7 = new Phrase();
//                phrase7.add(new Chunk("法定代表人身份证明或者委托书", fontChineseNormalsimfang12));
//                phrase7.add(Chunk.NEWLINE);
//                toMeasurefloat(phrase7);
//
//                paragraph2.add(phrase5);
//                paragraph2.add(phrase6);
//                paragraph2.add(phrase7);
//
//                document.add(paragraph2);
//
//                // checkbox start
//                PdfContentByte cb = dpfwPdfWriter.getDirectContent();
//                RadioCheckField bt = new RadioCheckField(dpfwPdfWriter,
//                        ChunkFactoryOld.setCheckBoxArea(102, 548, 10), "Yes260",
//                        ChunkFactoryOld.getCheck(book.getValue(7), 1));
//                bt.setCheckType(RadioCheckField.TYPE_CHECK);
//                bt.setBorderWidth(BaseField.BORDER_WIDTH_THIN);
//                bt.setBorderColor(BaseColor.BLACK);
//                bt.setChecked(true);
//                PdfFormField ck = bt.getCheckField();
//                dpfwPdfWriter.addAnnotation(ck);
//
//                RadioCheckField bt2 = new RadioCheckField(dpfwPdfWriter,
//                        ChunkFactoryOld.setCheckBoxArea(102, 524, 10), "Yes149",
//                        ChunkFactoryOld.getCheck(book.getValue(7), 2));
//                bt2.setCheckType(RadioCheckField.TYPE_CHECK);
//                bt2.setBorderWidth(BaseField.BORDER_WIDTH_THIN);
//                bt2.setBorderColor(BaseColor.BLACK);
//                bt2.setChecked(true);
//                PdfFormField ck2 = bt2.getCheckField();
//                dpfwPdfWriter.addAnnotation(ck2);
//
//                RadioCheckField bt3 = new RadioCheckField(dpfwPdfWriter,
//                        ChunkFactoryOld.setCheckBoxArea(102, 500, 10), "Yes57", ChunkFactoryOld.getCheck(book.getValue(7), 3));
//                bt3.setCheckType(RadioCheckField.TYPE_CHECK);
//                bt3.setBorderWidth(BaseField.BORDER_WIDTH_THIN);
//                bt3.setBorderColor(BaseColor.BLACK);
//                bt3.setChecked(true);
//                PdfFormField ck3 = bt3.getCheckField();
//                dpfwPdfWriter.addAnnotation(ck3);
//
//                RadioCheckField bt4 = new RadioCheckField(dpfwPdfWriter,
//                        ChunkFactoryOld.setCheckBoxArea(102, 476, 10), "Yes318",
//                        ChunkFactoryOld.getCheck(book.getValue(7), 4));
//                bt4.setCheckType(RadioCheckField.TYPE_CHECK);
//                bt4.setBorderWidth(BaseField.BORDER_WIDTH_THIN);
//                bt4.setBorderColor(BaseColor.BLACK);
//                bt4.setChecked(true);
//                PdfFormField ck4 = bt4.getCheckField();
//                dpfwPdfWriter.addAnnotation(ck4);
//                // checkbox end
//
//                final Paragraph paragraph3 = new Paragraph();
//                paragraph3.setFirstLineIndent(0f);
//                paragraph3.setLeading(24f);
//                paragraph3.setAlignment(Element.ALIGN_CENTER);
//
//                Phrase phrase8 = new Phrase(ChunkFactoryOld.underLine(book.getValue(8), 1640,
//                        fontChineseNormalsimfang12, 60, 430));
//                toMeasurefloat(phrase8);
//                paragraph3.add(phrase8);
//
//                document.add(paragraph3);
//
//                final Paragraph paragraph4 = new Paragraph();
//                paragraph4.setFirstLineIndent(24f);
//                paragraph4.setLeading(24f);
//                paragraph4.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase9 = new Phrase();
//                phrase9.add(new Chunk("如无法按时前来，请及时联系。", fontChineseNormalsimfang12));
//                toMeasurefloat(phrase9);
//
//                paragraph4.add(phrase9);
//                document.add(paragraph4);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                final Paragraph paragraph5 = new Paragraph();
//                paragraph5.setFirstLineIndent(24f);
//                paragraph5.setLeading(24f);
//                paragraph5.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase10 = new Phrase();
//                phrase10.add(new Chunk("安全生产监督管理部门地址：", fontChineseNormalsimfang12));
//                phrase10.add(ChunkFactoryOld.underLine(book.getValue(9), 228,
//                        fontChineseNormalsimfang12));
//                toMeasurefloat(phrase10);
//
//                paragraph5.add(phrase10);
//                document.add(paragraph5);
//
//                final Paragraph paragraph6 = new Paragraph();
//                paragraph6.setFirstLineIndent(24f);
//                paragraph6.setLeading(24f);
//                paragraph6.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase11 = new Phrase();
//                phrase11.add(new Chunk("联系人：", fontChineseNormalsimfang12));
//                phrase11.add(ChunkFactoryOld.underLine(book.getValue(10), 102,
//                        fontChineseNormalsimfang12));
//                phrase11.add(new Chunk("联系电话：", fontChineseNormalsimfang12));
//                phrase11.add(ChunkFactoryOld.underLine(book.getValue(11), 166,
//                        fontChineseNormalsimfang12));
//                toMeasurefloat(phrase11);
//
//                paragraph6.add(phrase11);
//                document.add(paragraph6);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//
//                final Paragraph paragraph7 = new Paragraph();
//                paragraph7.setFirstLineIndent(264f);
//                paragraph7.setLeading(24f);
//                paragraph7.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase12 = new Phrase();
//                phrase12.add(new Chunk("安全生产监督管理部门（公章）", fontChineseNormalsimfang12));
//                toMeasurefloat(phrase12);
//
//                paragraph7.add(phrase12);
//                document.add(paragraph7);
//
//                final Paragraph paragraph8 = new Paragraph();
//                paragraph8.setFirstLineIndent(276f);
//                paragraph8.setLeading(24f);
//                paragraph8.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase13 = new Phrase();
//                phrase13.add(ChunkFactoryOld.tablenounderLine(StringFactoryBuild.build().getTime(book.getValue(12), 0), 36,
//                        fontChineseNormalsimfang12));
//                phrase13.add(new Chunk("年", fontChineseNormalsimfang12));
//                phrase13.add(ChunkFactoryOld.tablenounderLine(StringFactoryBuild.build().getTime(book.getValue(12), 1), 12,
//                        fontChineseNormalsimfang12));
//                phrase13.add(new Chunk("月", fontChineseNormalsimfang12));
//                phrase13.add(ChunkFactoryOld.tablenounderLine(StringFactoryBuild.build().getTime(book.getValue(12), 2), 12,
//                        fontChineseNormalsimfang12));
//                phrase13.add(new Chunk("日", fontChineseNormalsimfang12));
//                phrase13.add(ChunkFactoryOld.tablenounderLine("", 36,
//                        fontChineseNormalsimfang12));
//                toMeasurefloat(phrase13);
//
//                paragraph8.add(phrase13);
//                document.add(paragraph8);
//                document.add(space1);
//
//                final Paragraph bottomLine1 = new Paragraph(
//                        new Chunk(new LineSeparator()));// 加入一个换行
//                bottomLine1.setLeading(1f);
//                bottomLine1.setSpacingBefore(5f);
//
//                document.add(bottomLine1);
//
//                final Paragraph paragraph9 = new Paragraph();
//                Phrase phrase14 = new Phrase();
//                phrase14.add(new Chunk("本文书一式两份：一份由安全生产监督管理部门备案，一份交被询问人。",
//                        fontChineseNormalsimfang12));
//                paragraph9.add(phrase14);
//
//                document.add(paragraph9);
//
//                PdfContentByte canvas2 = dpfwPdfWriter.getDirectContent();
//                // 电子签章
//                Image img = ImageBuilder.getInstance(image);
//                if (img != null) {
//                    img.setAbsolutePosition(350, 140);
//                    canvas2.addImage(img);
//                }
//                document.newPage();// 结束保存
//            }
//        });
//
//    }
//
//    //询问笔录
//    public void printerEntity_Book2(final Base_Entity book, final Object image) {
//        printFrameWork(book, image, new IPdfBackFrame() {
//            @Override
//            public void writeContent() throws Exception {
//                //此处写页面布局
//                final Paragraph title = new Paragraph("" + city + "安全生产行政执法文书", fontChineseBoldsimhei15);// Paragraph就是段落
//                title.setLeading(1f);// 段落距离
//                // title.setSpacingBefore(25f);//段落留白
//                title.setAlignment(Element.ALIGN_CENTER);// 居中
//                document.add(title);// 写入文档
//                final Paragraph titleLine1 = new Paragraph(new Chunk(new LineSeparator()));// 加入一个换行
//                titleLine1.setLeading(1f);
//                titleLine1.setSpacingBefore(5f);
//                document.add(titleLine1);
//                final Paragraph titleLine2 = new Paragraph(new Chunk(new LineSeparator()));
//                titleLine2.setLeading(1f);
//                titleLine2.setSpacingBefore(1f);
//                document.add(titleLine2);
//                final Paragraph title2 = new Paragraph("询问笔录", fontChineseBoldsimhei15);
//
//                title2.setLeading(1f);
//                title2.setSpacingBefore(17f);
//                title2.setAlignment(Element.ALIGN_CENTER);
//
//                document.add(title2);
//                document.add(space1);
//                document.add(space1);
//
//                final Paragraph paragraph1 = new Paragraph();
//                paragraph1.setIndentationLeft(24f);
//                paragraph1.setLeading(24f);
//                paragraph1.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase1 = new Phrase();
//                phrase1.add(new Chunk("询问时间：", fontChineseNormalsimfang12));
//                phrase1.add(ChunkFactoryOld
//                        .underLine(StringFactoryBuild.build().getTime(book.getValue(3), 0), 18, fontChineseNormalsimfang12));
//                phrase1.add(new Chunk("年", fontChineseNormalsimfang12));
//                phrase1.add(ChunkFactoryOld
//                        .underLine(StringFactoryBuild.build().getTime(book.getValue(3), 1), 12, fontChineseNormalsimfang12));
//                phrase1.add(new Chunk("月", fontChineseNormalsimfang12));
//                phrase1.add(ChunkFactoryOld
//                        .underLine(StringFactoryBuild.build().getTime(book.getValue(3), 2), 4, fontChineseNormalsimfang12));
//                phrase1.add(new Chunk("日", fontChineseNormalsimfang12));
//                phrase1.add(ChunkFactoryOld
//                        .underLine(StringFactoryBuild.build().getTime(book.getValue(3), 3), 4, fontChineseNormalsimfang12));
//                phrase1.add(new Chunk("时", fontChineseNormalsimfang12));
//                phrase1.add(ChunkFactoryOld
//                        .underLine(StringFactoryBuild.build().getTime(book.getValue(3), 4), 4, fontChineseNormalsimfang12));
//                phrase1.add(new Chunk("分至", fontChineseNormalsimfang12));
//                phrase1.add(ChunkFactoryOld
//                        .underLine(StringFactoryBuild.build().getTime(book.getValue(4), 2), 4, fontChineseNormalsimfang12));
//                phrase1.add(new Chunk("日", fontChineseNormalsimfang12));
//                phrase1.add(ChunkFactoryOld
//                        .underLine(StringFactoryBuild.build().getTime(book.getValue(4), 3), 4, fontChineseNormalsimfang12));
//                phrase1.add(new Chunk("时", fontChineseNormalsimfang12));
//                phrase1.add(ChunkFactoryOld
//                        .underLine(StringFactoryBuild.build().getTime(book.getValue(4), 4), 4, fontChineseNormalsimfang12));
//                phrase1.add(new Chunk("分", fontChineseNormalsimfang12));
//
//                phrase1.add(ChunkFactoryOld.tablenounderLine("", 18,
//                        fontChineseNormalsimfang12));
//                phrase1.add(new Chunk("第", fontChineseNormalsimfang12));
//                phrase1.add(ChunkFactoryOld
//                        .underLine(book.getValue(5), 18, fontChineseNormalsimfang12));
//                phrase1.add(new Chunk("次询问", fontChineseNormalsimfang12));
//
//                Phrase phrase2 = new Phrase();
//                phrase2.add(new Chunk("询问地点：", fontChineseNormalsimfang12));
//                phrase2.add(ChunkFactoryOld.underLine(book.getValue(6), 336,
//                        fontChineseNormalsimfang12));
//
//                Phrase phrase3 = new Phrase();
//                phrase3.add(new Chunk("被询问人姓名：", fontChineseNormalsimfang12));
//                phrase3.add(ChunkFactoryOld
//                        .underLine(book.getValue(7), 36, fontChineseNormalsimfang12));
//                phrase3.add(new Chunk("性别：", fontChineseNormalsimfang12));
//                phrase3.add(ChunkFactoryOld
//                        .underLine(book.getValue(8), 24, fontChineseNormalsimfang12));
//                phrase3.add(new Chunk("年龄：", fontChineseNormalsimfang12));
//                phrase3.add(ChunkFactoryOld
//                        .underLine(book.getValue(9), 24, fontChineseNormalsimfang12));
//                phrase3.add(new Chunk("身份证号：", fontChineseNormalsimfang12));
//                phrase3.add(ChunkFactoryOld
//                        .underLine(book.getValue(10), 60, fontChineseNormalsimfang12));
//
//                Phrase phrase4 = new Phrase();
//                phrase4.add(new Chunk("工作单位：", fontChineseNormalsimfang12));
//                phrase4.add(ChunkFactoryOld.underLine(book.getValue(11), 240,
//                        fontChineseNormalsimfang12));
//                phrase4.add(new Chunk("职务：", fontChineseNormalsimfang12));
//                phrase4.add(ChunkFactoryOld
//                        .underLine(book.getValue(12), 48, fontChineseNormalsimfang12));
//
//                Phrase phrase5 = new Phrase();
//                phrase5.add(new Chunk("住址：", fontChineseNormalsimfang12));
//                phrase5.add(ChunkFactoryOld.underLine(book.getValue(13), 264,
//                        fontChineseNormalsimfang12));
//                phrase5.add(new Chunk("电话：", fontChineseNormalsimfang12));
//                phrase5.add(ChunkFactoryOld
//                        .underLine(book.getValue(14), 48, fontChineseNormalsimfang12));
//
//                Phrase phrase6 = new Phrase();
//                phrase6.add(new Chunk("询问人：", fontChineseNormalsimfang12));
//                phrase6.add(ChunkFactoryOld
//                        .underLine(book.getValue(15), 84, fontChineseNormalsimfang12));
//                phrase6.add(new Chunk("单位及职务：", fontChineseNormalsimfang12));
//                phrase6.add(ChunkFactoryOld.underLine(book.getValue(16), 180,
//                        fontChineseNormalsimfang12));
//
//                Phrase phrase7 = new Phrase();
//                phrase7.add(new Chunk("记录人：", fontChineseNormalsimfang12));
//                phrase7.add(ChunkFactoryOld
//                        .underLine(book.getValue(17), 84, fontChineseNormalsimfang12));
//                phrase7.add(new Chunk("单位及职务：", fontChineseNormalsimfang12));
//                phrase7.add(ChunkFactoryOld.underLine(book.getValue(18), 180,
//                        fontChineseNormalsimfang12));
//
//                Phrase phrase8 = new Phrase();
//                phrase8.add(new Chunk("在场人：", fontChineseNormalsimfang12));
//                phrase8.add(ChunkFactoryOld.underLine(book.getValue(19), 348,
//                        fontChineseNormalsimfang12));
//
//                paragraph1.add(phrase1);
//                paragraph1.add(phrase2);
//                paragraph1.add(phrase3);
//                paragraph1.add(phrase4);
//                paragraph1.add(phrase5);
//                paragraph1.add(phrase6);
//                paragraph1.add(phrase7);
//                paragraph1.add(phrase8);
//
//                document.add(paragraph1);
//
//                final Paragraph paragraph2 = new Paragraph();
//                paragraph2.setFirstLineIndent(24f);
//                paragraph2.setLeading(24f);
//                paragraph2.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase9 = new Phrase();
//                phrase9.add(new Chunk("我们是", fontChineseNormalsimfang12));
//                phrase9.add(ChunkFactoryOld
//                        .underLine(book.getValue(20), 36, fontChineseNormalsimfang12));
//                phrase9.add(new Chunk("安全生产监督管理局的执法人员", fontChineseNormalsimfang12));
//                phrase9.add(ChunkFactoryOld
//                        .underLine(book.getValue(21), 48, fontChineseNormalsimfang12));
//                phrase9.add(new Chunk("、", fontChineseNormalsimfang12));
//                phrase9.add(ChunkFactoryOld
//                        .underLine(book.getValue(22), 48, fontChineseNormalsimfang12));
//                phrase9.add(new Chunk("，证", fontChineseNormalsimfang12));
//
//                Phrase phrase10 = new Phrase();
//                phrase10.add(new Chunk("件号码为", fontChineseNormalsimfang12));
//                phrase10.add(ChunkFactoryOld.underLine(book.getValue(23), 60,
//                        fontChineseNormalsimfang12));
//                phrase10.add(new Chunk("、", fontChineseNormalsimfang12));
//                phrase10.add(ChunkFactoryOld.underLine(book.getValue(24), 60,
//                        fontChineseNormalsimfang12));
//                phrase10.add(new Chunk("，这是我们的证件（出示证件）。我们依法", fontChineseNormalsimfang12));
//
//                Phrase phrase11 = new Phrase();
//                phrase11.add(new Chunk("就", fontChineseNormalsimfang12));
//                phrase11.add(ChunkFactoryOld.underLine(book.getValue(25), 384,
//                        fontChineseNormalsimfang12));
//                phrase11.add(new Chunk("的有", fontChineseNormalsimfang12));
//
//                Phrase phrase12 = new Phrase();
//                phrase12.add(new Chunk("关问题向您了解情况，您有如实回答问题的义务，也有陈述、申辩和申请回避的",
//                        fontChineseNormalsimfang12));
//
//                Phrase phrase13 = new Phrase();
//                phrase13.add(new Chunk("权利。您听清楚了吗？", fontChineseNormalsimfang12));
//
//                paragraph2.add(phrase9);
//                paragraph2.add(phrase10);
//                paragraph2.add(phrase11);
//                paragraph2.add(phrase12);
//                paragraph2.add(phrase13);
//
//                document.add(paragraph2);
//
//                final Paragraph paragraph3 = new Paragraph();
//                paragraph3.setFirstLineIndent(24f);
//                paragraph3.setLeading(24f);
//                paragraph3.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase14 = new Phrase();
//                 phrase14.add(new Chunk("询问记录：", fontChineseNormalsimfang12));
//                phrase14.add(ChunkFactoryOld.underLine(book.getValue(26), 3354,
//                        fontChineseNormalsimfang12,84,430));
//
//                paragraph3.add(phrase14);
//                document.add(paragraph3);
//                document.add(space1);
//                document.add(space1);
//
//                final Paragraph paragraph4 = new Paragraph();
//                paragraph4.setIndentationLeft(24f);
//
//                Phrase phrase15 = new Phrase();
//                phrase15.add(new Chunk("询问人（签名）：", fontChineseNormalsimfang12));
//                phrase15.add(ChunkFactoryOld.tablenounderLine(book.getValue(27), 120,
//                        fontChineseNormalsimfang12));
//                phrase15.add(new Chunk("记录人（签名）：", fontChineseNormalsimfang12));
//                phrase15.add(ChunkFactoryOld.tablenounderLine(book.getValue(28), 60,
//                        fontChineseNormalsimfang12));
//
//                Phrase phrase16 = new Phrase();
//                phrase16.add(new Chunk("\n被询问人（签名）：", fontChineseNormalsimfang12));
//                phrase16.add(ChunkFactoryOld.tablenounderLine(book.getValue(29), 156,
//                        fontChineseNormalsimfang12));
//                phrase16.add(ChunkFactoryOld.tablenounderLine(StringFactoryBuild.build().getTime(book.getValue(30), 0), 24,
//                        fontChineseNormalsimfang12));
//                phrase16.add(new Chunk("年", fontChineseNormalsimfang12));
//                phrase16.add(ChunkFactoryOld.tablenounderLine(StringFactoryBuild.build().getTime(book.getValue(30), 1), 6,
//                        fontChineseNormalsimfang12));
//                phrase16.add(new Chunk("月", fontChineseNormalsimfang12));
//                phrase16.add(ChunkFactoryOld.tablenounderLine(StringFactoryBuild.build().getTime(book.getValue(30), 2), 6,
//                        fontChineseNormalsimfang12));
//                phrase16.add(new Chunk("日", fontChineseNormalsimfang12));
//
//                paragraph4.add(phrase15);
//                paragraph4.add(phrase16);
//                paragraph4.setLeading(24);
//                document.add(paragraph4);
//                document.add(space1);
//
//                final Paragraph bottomLine1 = new Paragraph(
//                        new Chunk(new LineSeparator()));// 加入一个换行
//                bottomLine1.setLeading(1f);
//                bottomLine1.setSpacingBefore(5f);
//
//                document.add(bottomLine1);
//
//                final Paragraph paragraph5 = new Paragraph();
//                Phrase phrase17 = new Phrase();
//
//                phrase17.add(ChunkFactoryOld.tablenounderLine("", 336,
//                        fontChineseNormalsimfang12));
//                // phrase17.add(new Chunk("共",fontChineseKNormal));
//                // phrase17.add(Help_Pdf_Help.tablenounderLine("", 24,
//                // fontChineseKNormal));
//                // phrase17.add(new Chunk("页",fontChineseKNormal));
//                // phrase17.add(Help_Pdf_Help.tablenounderLine("", 24,
//                // fontChineseKNormal));
//                // phrase17.add(new Chunk("第",fontChineseKNormal));
//                // phrase17.add(Help_Pdf_Help.tablenounderLine("", 24,
//                // fontChineseKNormal));
//                // phrase17.add(new Chunk("页",fontChineseKNormal));
//                paragraph5.add(phrase17);
////                PdfContentByte canvas = dpfwPdfWriter.getDirectContent();
//
////                Phrase phrase18 = new Phrase();
////
////                phrase18.add(new Chunk("询问记录：", fontChineseNormalsimfang12));
////                ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phrase18,
////                        104, 370, 0);
//
//                document.add(paragraph5);
//
//                PdfContentByte canvas2 = dpfwPdfWriter.getDirectContent();
//                // 电子签章
//                Image img = ImageBuilder.getInstance(image);
//                if (img != null) {
//                    img.setAbsolutePosition(350, 140);
//                    canvas2.addImage(img);
//                }
//                document.newPage();// 结束保存
//            }
//        });
//
//    }
//
//    //勘查笔录
//    public void printerEntity_Book3(final Base_Entity book, final Object image) {
//        printFrameWork(book, image, new IPdfBackFrame() {
//            @Override
//            public void writeContent() throws Exception {
//                //此处写页面布局
//                document.add(space1);
//
//                final Paragraph title = new Paragraph("" + city + "安全生产行政执法文书", fontChineseBoldsimhei15);// Paragraph就是段落
//                title.setLeading(1f);// 段落距离
//                // title.setSpacingBefore(25f);//段落留白
//                title.setAlignment(Element.ALIGN_CENTER);// 居中
//                document.add(title);// 写入文档
//                final Paragraph titleLine1 = new Paragraph(new Chunk(new LineSeparator()));// 加入一个换行
//                titleLine1.setLeading(1f);
//                titleLine1.setSpacingBefore(5f);
//                document.add(titleLine1);
//                final Paragraph titleLine2 = new Paragraph(new Chunk(new LineSeparator()));
//                titleLine2.setLeading(1f);
//                titleLine2.setSpacingBefore(1f);
//                document.add(titleLine2);
//                final Paragraph title2 = new Paragraph("勘验笔录", fontChineseBoldsimhei15);
//
//                title2.setLeading(1f);
//                title2.setSpacingBefore(17f);
//                title2.setAlignment(Element.ALIGN_CENTER);
//                document.add(title2);
//
//                final Paragraph title3 = new Paragraph("( " + book.getValue(0) + " )安监管勘〔" + book.getValue(1) + "〕"
//                        + book.getValue(2) + "号", fontChineseNormalsimfang12);
//                title3.setLeading(1f);
//                title3.setSpacingBefore(34f);
//                title3.setAlignment(Element.ALIGN_CENTER);
//                document.add(title3);
//
//                final Paragraph paragraph1 = new Paragraph();
//                paragraph1.setIndentationLeft(24f);
//                paragraph1.setLeading(24f);
//                paragraph1.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase1 = new Phrase();
//                phrase1.add(new Chunk("勘验时间：", fontChineseNormalsimfang12));
//                phrase1.add(ChunkFactoryOld
//                        .underLine(StringFactoryBuild.build().getTime(book.getValue(3), 0), 42, fontChineseNormalsimfang12));
//                phrase1.add(new Chunk("年", fontChineseNormalsimfang12));
//                phrase1.add(ChunkFactoryOld
//                        .underLine(StringFactoryBuild.build().getTime(book.getValue(3), 1), 18, fontChineseNormalsimfang12));
//                phrase1.add(new Chunk("月", fontChineseNormalsimfang12));
//                phrase1.add(ChunkFactoryOld
//                        .underLine(StringFactoryBuild.build().getTime(book.getValue(3), 2), 18, fontChineseNormalsimfang12));
//                phrase1.add(new Chunk("日", fontChineseNormalsimfang12));
//                phrase1.add(ChunkFactoryOld
//                        .underLine(StringFactoryBuild.build().getTime(book.getValue(3), 3), 12, fontChineseNormalsimfang12));
//                phrase1.add(new Chunk("时", fontChineseNormalsimfang12));
//                phrase1.add(ChunkFactoryOld
//                        .underLine(StringFactoryBuild.build().getTime(book.getValue(3), 4), 12, fontChineseNormalsimfang12));
//                phrase1.add(new Chunk("分至", fontChineseNormalsimfang12));
//                phrase1.add(ChunkFactoryOld
//                        .underLine(StringFactoryBuild.build().getTime(book.getValue(4), 2), 12, fontChineseNormalsimfang12));
//                phrase1.add(new Chunk("日", fontChineseNormalsimfang12));
//                phrase1.add(ChunkFactoryOld
//                        .underLine(StringFactoryBuild.build().getTime(book.getValue(4), 3), 12, fontChineseNormalsimfang12));
//                phrase1.add(new Chunk("时", fontChineseNormalsimfang12));
//                phrase1.add(ChunkFactoryOld
//                        .underLine(StringFactoryBuild.build().getTime(book.getValue(4), 4), 12, fontChineseNormalsimfang12));
//                phrase1.add(new Chunk("分", fontChineseNormalsimfang12));
//
//                Phrase phrase2 = new Phrase();
//                phrase2.add(new Chunk("勘验场所：", fontChineseNormalsimfang12));
//                phrase2.add(ChunkFactoryOld.underLine(book.getValue(5), 180,
//                        fontChineseNormalsimfang12));
//                phrase2.add(new Chunk("天气情况：", fontChineseNormalsimfang12));
//                phrase2.add(ChunkFactoryOld.underLine(book.getValue(6), 78,
//                        fontChineseNormalsimfang12));
//
//                Phrase phrase3 = new Phrase();
//                phrase3.add(new Chunk("勘验人：", fontChineseNormalsimfang12));
//                phrase3.add(ChunkFactoryOld
//                        .underLine(book.getValue(7), 84, fontChineseNormalsimfang12));
//                phrase3.add(new Chunk("单位及职务：", fontChineseNormalsimfang12));
//                phrase3.add(ChunkFactoryOld.underLine(book.getValue(8), 174,
//                        fontChineseNormalsimfang12));
//
//                Phrase phrase4 = new Phrase();
//                phrase4.add(new Chunk("勘验人：", fontChineseNormalsimfang12));
//                phrase4.add(ChunkFactoryOld
//                        .underLine(book.getValue(9), 84, fontChineseNormalsimfang12));
//                phrase4.add(new Chunk("单位及职务：", fontChineseNormalsimfang12));
//                phrase4.add(ChunkFactoryOld.underLine(book.getValue(10), 174,
//                        fontChineseNormalsimfang12));
//
//                Phrase phrase5 = new Phrase();
//                phrase5.add(new Chunk("当事人：", fontChineseNormalsimfang12));
//                phrase5.add(ChunkFactoryOld
//                        .underLine(book.getValue(11), 84, fontChineseNormalsimfang12));
//                phrase5.add(new Chunk("单位及职务：", fontChineseNormalsimfang12));
//                phrase5.add(ChunkFactoryOld.underLine(book.getValue(12), 174,
//                        fontChineseNormalsimfang12));
//
//                Phrase phrase6 = new Phrase();
//                phrase6.add(new Chunk("当事人：", fontChineseNormalsimfang12));
//                phrase6.add(ChunkFactoryOld
//                        .underLine(book.getValue(13), 84, fontChineseNormalsimfang12));
//                phrase6.add(new Chunk("单位及职务：", fontChineseNormalsimfang12));
//                phrase6.add(ChunkFactoryOld.underLine(book.getValue(14), 174,
//                        fontChineseNormalsimfang12));
//
//                Phrase phrase7 = new Phrase();
//                phrase7.add(new Chunk("被邀请人：", fontChineseNormalsimfang12));
//                phrase7.add(ChunkFactoryOld
//                        .underLine(book.getValue(15), 72, fontChineseNormalsimfang12));
//                phrase7.add(new Chunk("单位及职务：", fontChineseNormalsimfang12));
//                phrase7.add(ChunkFactoryOld.underLine(book.getValue(16), 174,
//                        fontChineseNormalsimfang12));
//
//                Phrase phrase8 = new Phrase();
//                phrase8.add(new Chunk("记录人：", fontChineseNormalsimfang12));
//                phrase8.add(ChunkFactoryOld
//                        .underLine(book.getValue(17), 84, fontChineseNormalsimfang12));
//                phrase8.add(new Chunk("单位及职务：", fontChineseNormalsimfang12));
//                phrase8.add(ChunkFactoryOld.underLine(book.getValue(18), 174,
//                        fontChineseNormalsimfang12));
//
//                paragraph1.add(phrase1);
//                paragraph1.add(phrase2);
//                paragraph1.add(phrase3);
//                paragraph1.add(phrase4);
//                paragraph1.add(phrase5);
//                paragraph1.add(phrase6);
//                paragraph1.add(phrase7);
//                paragraph1.add(phrase8);
//
//                document.add(paragraph1);
//
//                final Paragraph paragraph2 = new Paragraph();
//                paragraph2.setFirstLineIndent(24f);
//                paragraph2.setLeading(24f);
//                paragraph2.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase9 = new Phrase();
//                phrase9.add(new Chunk("我们是", fontChineseNormalsimfang12));
//                phrase9.add(ChunkFactoryOld
//                        .underLine(book.getValue(19), 54, fontChineseNormalsimfang12));
//                phrase9.add(new Chunk("安全生产监督管理局的执法人员", fontChineseNormalsimfang12));
//
//                phrase9.add(ChunkFactoryOld
//                        .underLine(book.getValue(20), 42, fontChineseNormalsimfang12));
//                phrase9.add(new Chunk("、", fontChineseNormalsimfang12));
//                phrase9.add(ChunkFactoryOld
//                        .underLine(book.getValue(21), 42, fontChineseNormalsimfang12));
//                phrase9.add(new Chunk("，", fontChineseNormalsimfang12));
//
//                Phrase phrase10 = new Phrase();
//                phrase10.add(new Chunk("证件号码为", fontChineseNormalsimfang12));
//                phrase10.add(ChunkFactoryOld.underLine(book.getValue(22), 60,
//                        fontChineseNormalsimfang12));
//                phrase10.add(new Chunk("、", fontChineseNormalsimfang12));
//                phrase10.add(ChunkFactoryOld.underLine(book.getValue(23), 60,
//                        fontChineseNormalsimfang12));
//                phrase10.add(new Chunk("，这是我们的证件（出示证件）。现依法", fontChineseNormalsimfang12));
//
//                Phrase phrase11 = new Phrase();
//                phrase11.add(new Chunk("进行勘验检查，请予以配合。", fontChineseNormalsimfang12));
//
//                paragraph2.add(phrase9);
//                paragraph2.add(phrase10);
//                paragraph2.add(phrase11);
//
//                document.add(paragraph2);
//
//                final Paragraph paragraph3 = new Paragraph();
//                paragraph3.setFirstLineIndent(24f);
//                paragraph3.setLeading(24f);
//                paragraph3.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase12 = new Phrase();
//                phrase12.add(new Chunk("勘验情况：", fontChineseNormalsimfang12));
//                phrase12.add(ChunkFactoryOld.underLine(book.getValue(24), 3788,
//                        fontChineseNormalsimfang12,84,430));
//
//                paragraph3.add(phrase12);
//
//                document.add(paragraph3);
//
//                final Paragraph paragraph4 = new Paragraph();
//                paragraph4.setIndentationLeft(24f);
//                paragraph4.setLeading(24f);
//                paragraph4.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase13 = new Phrase();
//                phrase13.add(new Chunk("勘验人（签名）：", fontChineseNormalsimfang12));
//                phrase13.add(ChunkFactoryOld.underLine(book.getValue(25), 84,
//                        fontChineseNormalsimfang12));
//                phrase13.add(ChunkFactoryOld.tablenounderLine("", 24,
//                        fontChineseNormalsimfang12));
//                phrase13.add(new Chunk("勘验人（签名）：", fontChineseNormalsimfang12));
//                phrase13.add(ChunkFactoryOld.underLine(book.getValue(26), 66,
//                        fontChineseNormalsimfang12));
//
//                Phrase phrase14 = new Phrase();
//                phrase14.add(new Chunk("当事人（签名）：", fontChineseNormalsimfang12));
//                phrase14.add(ChunkFactoryOld.underLine(book.getValue(27), 84,
//                        fontChineseNormalsimfang12));
//                phrase14.add(ChunkFactoryOld.tablenounderLine("", 24,
//                        fontChineseNormalsimfang12));
//                phrase14.add(new Chunk("联系方式：", fontChineseNormalsimfang12));
//                phrase14.add(ChunkFactoryOld.underLine(book.getValue(28), 102,
//                        fontChineseNormalsimfang12));
//
//                Phrase phrase15 = new Phrase();
//                phrase15.add(new Chunk("当事人（签名）：", fontChineseNormalsimfang12));
//                phrase15.add(ChunkFactoryOld.underLine(book.getValue(29), 84,
//                        fontChineseNormalsimfang12));
//                phrase15.add(ChunkFactoryOld.tablenounderLine("", 24,
//                        fontChineseNormalsimfang12));
//                phrase15.add(new Chunk("联系方式：", fontChineseNormalsimfang12));
//                phrase15.add(ChunkFactoryOld.underLine(book.getValue(30), 102,
//                        fontChineseNormalsimfang12));
//
//                Phrase phrase16 = new Phrase();
//                phrase16.add(new Chunk("被邀请人（签名）：", fontChineseNormalsimfang12));
//                phrase16.add(ChunkFactoryOld.underLine(book.getValue(31), 72,
//                        fontChineseNormalsimfang12));
//                phrase16.add(ChunkFactoryOld.tablenounderLine("", 24,
//                        fontChineseNormalsimfang12));
//                phrase16.add(new Chunk("联系方式：", fontChineseNormalsimfang12));
//                phrase16.add(ChunkFactoryOld.underLine(book.getValue(32), 102,
//                        fontChineseNormalsimfang12));
//
//                paragraph4.add(phrase13);
//                paragraph4.add(phrase14);
//                paragraph4.add(phrase15);
//                paragraph4.add(phrase16);
//
//                document.add(paragraph4);
//                document.add(space1);
//
//                final Paragraph bottomLine1 = new Paragraph(
//                        new Chunk(new LineSeparator()));// 加入一个换行
//                bottomLine1.setLeading(1f);
//                bottomLine1.setSpacingBefore(5f);
//
//                document.add(bottomLine1);
//
//                final Paragraph paragraph5 = new Paragraph();
//                paragraph5.setLeading(24f);
//                paragraph5.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase17 = new Phrase();
//                phrase17.add(new Chunk("本页填写不下的内容或需绘制勘验图的，可另附页。",
//                        fontChineseNormalsimfang12));
//                phrase17.add(ChunkFactoryOld.tablenounderLine("", 48,
//                        fontChineseNormalsimfang12));
//
//                // phrase17.add(new Chunk("共",fontChineseKNormal));
//                // phrase17.add(Help_Pdf_Help.tablenounderLine("", 24,
//                // fontChineseKNormal));
//                // phrase17.add(new Chunk("页",fontChineseKNormal));
//                // phrase17.add(Help_Pdf_Help.tablenounderLine("", 24,
//                // fontChineseKNormal));
//                // phrase17.add(new Chunk("第",fontChineseKNormal));
//                // phrase17.add(Help_Pdf_Help.tablenounderLine("", 24,
//                // fontChineseKNormal));
//                // phrase17.add(new Chunk("页",fontChineseKNormal));
//                paragraph5.add(phrase17);
//
////                PdfContentByte canvas = dpfwPdfWriter.getDirectContent();
////
////                Phrase phrase18 = new Phrase();
////                phrase18.add(new Chunk("勘验情况：", fontChineseNormalsimfang12));
////                ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phrase18,
////                        104, 393, 0);
//                document.add(paragraph5);
//                PdfContentByte canvas2 = dpfwPdfWriter.getDirectContent();
//                // 电子签章
//                Image img = ImageBuilder.getInstance(image);
//                if (img != null) {
//                    img.setAbsolutePosition(350, 140);
//                    canvas2.addImage(img);
//                }
//                document.newPage();
//            }
//        });
//
//    }
//
//    //抽样取证凭证
//    public void printerEntity_Book4(final Base_Entity book, final Object image) {
//        printFrameWork(book, image, new IPdfBackFrame() {
//            @Override
//            public void writeContent() throws Exception {
//                //此处写页面布局
//                document.add(space1);
//
//                final Paragraph title = new Paragraph("" + city + "安全生产行政执法文书", fontChineseBoldsimhei15);// Paragraph就是段落
//                title.setLeading(1f);// 段落距离
//                // title.setSpacingBefore(25f);//段落留白
//                title.setAlignment(Element.ALIGN_CENTER);// 居中
//                document.add(title);// 写入文档
//                final Paragraph titleLine1 = new Paragraph(new Chunk(new LineSeparator()));// 加入一个换行
//                titleLine1.setLeading(1f);
//                titleLine1.setSpacingBefore(5f);
//                document.add(titleLine1);
//                final Paragraph titleLine2 = new Paragraph(new Chunk(new LineSeparator()));
//                titleLine2.setLeading(1f);
//                titleLine2.setSpacingBefore(1f);
//                document.add(titleLine2);
//                final Paragraph title2 = new Paragraph("抽样取证凭证", fontChineseBoldsimhei15);
//
//                title2.setLeading(1f);
//                title2.setSpacingBefore(17f);
//                title2.setAlignment(Element.ALIGN_CENTER);
//                document.add(title2);
//
//                final Paragraph title3 = new Paragraph("( " + book.getValue(0) + " )安监管抽〔" + book.getValue(1) + "〕"
//                        + book.getValue(2) + "号", fontChineseNormalsimfang12);
//                title3.setLeading(1f);
//                title3.setSpacingBefore(34f);
//                title3.setAlignment(Element.ALIGN_CENTER);
//                document.add(title3);
//
//                document.add(space1);
//
//                final Paragraph paragraph1 = new Paragraph();
//                paragraph1.setIndentationLeft(24f);
//                paragraph1.setLeading(24f);
//                paragraph1.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase1 = new Phrase();
//                phrase1.add(new Chunk("被抽样取证单位：", fontChineseNormalsimfang12));
//                phrase1.add(ChunkFactoryOld.underLine(book.getValue(3), 144,
//                        fontChineseNormalsimfang12));
//                phrase1.add(new Chunk("现场负责人：", fontChineseNormalsimfang12));
//                phrase1.add(ChunkFactoryOld
//                        .underLine(book.getValue(4), 72, fontChineseNormalsimfang12));
//
//                Phrase phrase2 = new Phrase();
//                phrase2.add(new Chunk("单位地址：", fontChineseNormalsimfang12));
//                phrase2.add(ChunkFactoryOld.underLine(book.getValue(5), 108,
//                        fontChineseNormalsimfang12));
//                phrase2.add(new Chunk("联系电话：", fontChineseNormalsimfang12));
//                phrase2.add(ChunkFactoryOld
//                        .underLine(book.getValue(6), 54, fontChineseNormalsimfang12));
//                phrase2.add(new Chunk("邮编：", fontChineseNormalsimfang12));
//                phrase2.add(ChunkFactoryOld
//                        .underLine(book.getValue(7), 54, fontChineseNormalsimfang12));
//
//                Phrase phrase3 = new Phrase();
//                phrase3.add(new Chunk("抽样取证时间：", fontChineseNormalsimfang12));
//                phrase3.add(ChunkFactoryOld
//                        .underLine(StringFactoryBuild.build().getTime(book.getValue(8), 0), 36, fontChineseNormalsimfang12));
//                phrase3.add(new Chunk("年", fontChineseNormalsimfang12));
//                phrase3.add(ChunkFactoryOld
//                        .underLine(StringFactoryBuild.build().getTime(book.getValue(8), 1), 12, fontChineseNormalsimfang12));
//                phrase3.add(new Chunk("月", fontChineseNormalsimfang12));
//                phrase3.add(ChunkFactoryOld
//                        .underLine(StringFactoryBuild.build().getTime(book.getValue(8), 2), 12, fontChineseNormalsimfang12));
//                phrase3.add(new Chunk("日", fontChineseNormalsimfang12));
//                phrase3.add(ChunkFactoryOld
//                        .underLine(StringFactoryBuild.build().getTime(book.getValue(8), 3), 12, fontChineseNormalsimfang12));
//                phrase3.add(new Chunk("时", fontChineseNormalsimfang12));
//                phrase3.add(ChunkFactoryOld
//                        .underLine(StringFactoryBuild.build().getTime(book.getValue(8), 4), 12, fontChineseNormalsimfang12));
//                phrase3.add(new Chunk("分至", fontChineseNormalsimfang12));
//                phrase3.add(ChunkFactoryOld
//                        .underLine(StringFactoryBuild.build().getTime(book.getValue(9), 2), 12, fontChineseNormalsimfang12));
//                phrase3.add(new Chunk("日", fontChineseNormalsimfang12));
//                phrase3.add(ChunkFactoryOld
//                        .underLine(StringFactoryBuild.build().getTime(book.getValue(9), 3), 12, fontChineseNormalsimfang12));
//                phrase3.add(new Chunk("时", fontChineseNormalsimfang12));
//                phrase3.add(ChunkFactoryOld
//                        .underLine(StringFactoryBuild.build().getTime(book.getValue(9), 4), 12, fontChineseNormalsimfang12));
//                phrase3.add(new Chunk("分", fontChineseNormalsimfang12));
//
//                Phrase phrase4 = new Phrase();
//                phrase4.add(new Chunk("抽样地点：", fontChineseNormalsimfang12));
//                phrase4.add(ChunkFactoryOld.underLine(book.getValue(10), 336,
//                        fontChineseNormalsimfang12));
//
//                paragraph1.add(phrase1);
//                paragraph1.add(phrase2);
//                paragraph1.add(phrase3);
//                paragraph1.add(phrase4);
//
//                document.add(paragraph1);
//
//                final Paragraph paragraph2 = new Paragraph();
//                paragraph2.setFirstLineIndent(24f);
//                paragraph2.setLeading(24f);
//                paragraph2.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase5 = new Phrase();
//                phrase5.add(new Chunk(
//                        "依据《中华人民共和国行政处罚法》第三十七条第二款规定，对被抽样取证单位的下列物品进行抽样取证。",
//                        fontChineseNormalsimfang12));
//
//                paragraph2.add(phrase5);
//
//                document.add(paragraph2);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                // 表格start
//                PdfPTable table = new PdfPTable(1);
//                table.setWidthPercentage(100f);
//
//                PdfPCell lin01 = new PdfPCell();
//                final Paragraph lin01p0 = new Paragraph("序号", fontChineseNormalsimfang12);
//                lin01p0.setAlignment(Element.ALIGN_CENTER);
//                lin01.addElement(lin01p0);
//                PdfPCell lin02 = new PdfPCell();
//                final Paragraph lin02p0 = new Paragraph("证据物品名称", fontChineseNormalsimfang12);
//                lin02p0.setAlignment(Element.ALIGN_CENTER);
//                lin02.addElement(lin02p0);
//                PdfPCell lin03 = new PdfPCell();
//                final Paragraph lin03p0 = new Paragraph("规格及批号", fontChineseNormalsimfang12);
//                lin03p0.setAlignment(Element.ALIGN_CENTER);
//                lin03.addElement(lin03p0);
//                PdfPCell lin04 = new PdfPCell();
//                final Paragraph lin04p0 = new Paragraph("数量", fontChineseNormalsimfang12);
//                lin04p0.setAlignment(Element.ALIGN_CENTER);
//                lin04.addElement(lin04p0);
//                PdfPTable celltable0 = new PdfPTable(4);
//                float[] celltable0float = new float[4];
//                celltable0float[0] = 1f;
//                celltable0float[1] = 6f;
//                celltable0float[2] = 4f;
//                celltable0float[3] = 1f;
//                celltable0.setTotalWidth(celltable0float);
//                celltable0.addCell(lin01);
//                celltable0.addCell(lin02);
//                celltable0.addCell(lin03);
//                celltable0.addCell(lin04);
//                PdfPCell row0 = new PdfPCell(celltable0);
//                row0.setFixedHeight(24f);
//                table.addCell(row0);
//
//
//                for (int i = 0; i < 9; i++) {
//                    PdfPCell lin91 = new PdfPCell();
//                    final Paragraph lin91p0 = new Paragraph(getListItemValue(book.getValue(11), i, 0), fontChineseNormalsimfang12);
//                    lin91p0.setAlignment(Element.ALIGN_CENTER);
//                    lin91.addElement(lin91p0);
//                    PdfPCell lin92 = new PdfPCell();
//                    final Paragraph lin92p0 = new Paragraph(getListItemValue(book.getValue(11), i, 1), fontChineseNormalsimfang12);
//                    lin92p0.setAlignment(Element.ALIGN_CENTER);
//                    lin92.addElement(lin92p0);
//                    PdfPCell lin93 = new PdfPCell();
//                    final Paragraph lin93p0 = new Paragraph(getListItemValue(book.getValue(11), i, 2), fontChineseNormalsimfang12);
//                    lin93p0.setAlignment(Element.ALIGN_CENTER);
//                    lin93.addElement(lin93p0);
//                    PdfPCell lin94 = new PdfPCell();
//                    final Paragraph lin94p0 = new Paragraph(getListItemValue(book.getValue(11), i, 3), fontChineseNormalsimfang12);
//                    lin94p0.setAlignment(Element.ALIGN_CENTER);
//                    lin94.addElement(lin94p0);
//                    PdfPTable cellTable9 = new PdfPTable(4);
//                    cellTable9.setWidths(celltable0float);
//                    cellTable9.addCell(lin91);
//                    cellTable9.addCell(lin92);
//                    cellTable9.addCell(lin93);
//                    cellTable9.addCell(lin94);
//                    PdfPCell row9 = new PdfPCell(cellTable9);
//                    row9.setFixedHeight(24f);
//                    table.addCell(row9);
//                }
//
//
//                document.add(table);
//                document.add(space1);
//                // 表格end
//
//                final Paragraph paragraph3 = new Paragraph();
//                paragraph3.setIndentationLeft(24f);
//                paragraph3.setLeading(24f);
//                paragraph3.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase6 = new Phrase();
//                phrase6.add(new Chunk("被抽样取证单位现场负责人（签名）：", fontChineseNormalsimfang12));
//                phrase6.add(ChunkFactoryOld
//                        .underLine(book.getValue(12), 84, fontChineseNormalsimfang12));
//
//                paragraph3.add(phrase6);
//                document.add(paragraph3);
//
//                final Paragraph paragraph4 = new Paragraph();
//                paragraph4.setIndentationLeft(24f);
//                paragraph4.setLeading(24f);
//                paragraph4.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase7 = new Phrase();
//                phrase7.add(new Chunk("安全生产监管执法人员（签名）：", fontChineseNormalsimfang12));
//                phrase7.add(ChunkFactoryOld
//                        .underLine(book.getValue(13), 60, fontChineseNormalsimfang12));
//                phrase7.add(new Chunk("证号：", fontChineseNormalsimfang12));
//                phrase7.add(ChunkFactoryOld
//                        .underLine(book.getValue(14), 60, fontChineseNormalsimfang12));
//
//                paragraph4.add(phrase7);
//                document.add(paragraph4);
//
//                final Paragraph paragraph5 = new Paragraph();
//                paragraph5.setIndentationLeft(0f);
//                paragraph5.setLeading(24f);
//                paragraph5.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase8 = new Phrase();
//                phrase8.add(ChunkFactoryOld.tablenounderLine("", 192,
//                        fontChineseNormalsimfang12));
//                phrase8.add(ChunkFactoryOld
//                        .underLine(book.getValue(15), 60, fontChineseNormalsimfang12));
//                phrase8.add(new Chunk("证号：", fontChineseNormalsimfang12));
//                phrase8.add(ChunkFactoryOld
//                        .underLine(book.getValue(16), 60, fontChineseNormalsimfang12));
//
//                paragraph5.add(phrase8);
//                document.add(paragraph5);
//                document.add(space1);
//
//                final Paragraph paragraph6 = new Paragraph();
//                paragraph6.setFirstLineIndent(264f);
//                paragraph6.setLeading(24f);
//                paragraph6.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase9 = new Phrase();
//                phrase9.add(new Chunk("安全生产监督管理部门（公章）", fontChineseNormalsimfang12));
//                toMeasurefloat(phrase9);
//
//                paragraph6.add(phrase9);
//                document.add(paragraph6);
//
//                final Paragraph paragraph7 = new Paragraph();
//                paragraph7.setFirstLineIndent(264f);
//                paragraph7.setLeading(24f);
//                paragraph7.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase10 = new Phrase();
//                phrase10.add(ChunkFactoryOld.tablenounderLine(StringFactoryBuild.build().getTime(book.getValue(17), 0), 36,
//                        fontChineseNormalsimfang12));
//                phrase10.add(new Chunk("年", fontChineseNormalsimfang12));
//                phrase10.add(ChunkFactoryOld.tablenounderLine(StringFactoryBuild.build().getTime(book.getValue(17), 1), 12,
//                        fontChineseNormalsimfang12));
//                phrase10.add(new Chunk("月", fontChineseNormalsimfang12));
//                phrase10.add(ChunkFactoryOld.tablenounderLine(StringFactoryBuild.build().getTime(book.getValue(17), 2), 12,
//                        fontChineseNormalsimfang12));
//                phrase10.add(new Chunk("日", fontChineseNormalsimfang12));
//                toMeasurefloat(phrase10);
//
//                paragraph7.add(phrase10);
//                document.add(paragraph7);
//                document.add(space2);
//
//                final Paragraph bottomLine1 = new Paragraph(
//                        new Chunk(new LineSeparator()));// 加入一个换行
//                bottomLine1.setLeading(1f);
//                bottomLine1.setSpacingBefore(5f);
//
//                document.add(bottomLine1);
//
//                final Paragraph paragraph8 = new Paragraph();
//                Phrase phrase11 = new Phrase();
//                phrase11.add(new Chunk("本文书一式两份：一份由安全生产监督管理部门备案，一份交被抽样取证单位。",
//                        fontChineseNormalsimfang12));
//                paragraph8.add(phrase11);
//
//                document.add(paragraph8);
//
//                PdfContentByte canvas2 = dpfwPdfWriter.getDirectContent();
//                // 电子签章
//                Image img = ImageBuilder.getInstance(image);
//                if (img != null) {
//                    img.setAbsolutePosition(350, 140);
//                    canvas2.addImage(img);
//                }
//                document.newPage();
//            }
//        });
//
//    }
//
//    //先行登记保存证据审批表
//    public void printerEntity_Book5(final Base_Entity book, final Object image) {
//        printFrameWork(book, image, new IPdfBackFrame() {
//            @Override
//            public void writeContent() throws Exception {
//                //此处写页面布局
//                document.add(space1);
//
//                final Paragraph title = new Paragraph("" + city + "安全生产行政执法文书", fontChineseBoldsimhei15);// Paragraph就是段落
//                title.setLeading(1f);// 段落距离
//                // title.setSpacingBefore(25f);//段落留白
//                title.setAlignment(Element.ALIGN_CENTER);// 居中
//                document.add(title);// 写入文档
//                final Paragraph titleLine1 = new Paragraph(new Chunk(new LineSeparator()));// 加入一个换行
//                titleLine1.setLeading(1f);
//                titleLine1.setSpacingBefore(5f);
//                document.add(titleLine1);
//                final Paragraph titleLine2 = new Paragraph(new Chunk(new LineSeparator()));
//                titleLine2.setLeading(1f);
//                titleLine2.setSpacingBefore(1f);
//                document.add(titleLine2);
//                final Paragraph title2 = new Paragraph("先行登记保存证据审批表", fontChineseBoldsimhei15);
//
//                title2.setLeading(1f);
//                title2.setSpacingBefore(17f);
//                title2.setAlignment(Element.ALIGN_CENTER);
//                document.add(title2);
//                document.add(space2);
//
//                final Paragraph paragraph1 = new Paragraph();
//                paragraph1.setLeading(34f);
//                paragraph1.setIndentationLeft(2f);
//                paragraph1.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase1 = new Phrase();
//                phrase1.add(new Chunk("案件名称:", fontChineseNormalsimfang12));
//                phrase1.add(ChunkFactoryOld.underLine(book.getValue(3), 366,
//                        fontChineseNormalsimfang12));
//
//                paragraph1.add(phrase1);
//                document.add(paragraph1);
//                document.add(space2);
//
//                // 表格start
//                PdfPTable table = new PdfPTable(1);
//                table.setWidthPercentage(100f);
//
//                PdfPCell lin01 = new PdfPCell();
//                final Paragraph lin01p0 = new Paragraph("当事人\n及基本情况", fontChineseNormalsimfang12);
//                lin01p0.setAlignment(Element.ALIGN_CENTER);
//                lin01.addElement(lin01p0);
//                PdfPCell lin02 = new PdfPCell();
//                final Paragraph lin02p0 = new Paragraph();
//                Phrase phrase02p0 = new Phrase();
//                phrase02p0.add(ChunkFactoryOld.tablenounderLine(book.getValue(4), 744, fontChineseNormalsimfang12));
//
//                lin02p0.add(phrase02p0);
//                lin02.addElement(lin02p0);
//                PdfPTable celltable0 = new PdfPTable(2);
//                float[] celltable0float = new float[2];
//                celltable0float[0] = 3f;
//                celltable0float[1] = 7f;
//                celltable0.setTotalWidth(celltable0float);
//                celltable0.addCell(lin01);
//                celltable0.addCell(lin02);
//                PdfPCell row0 = new PdfPCell(celltable0);
//                row0.setFixedHeight(55f);
//                table.addCell(row0);
//
//                PdfPCell lin11 = new PdfPCell();
//                final Paragraph lin11p0 = new Paragraph("\n\n\n案件基本情况 ",
//                        fontChineseNormalsimfang12);
//                lin11p0.setAlignment(Element.ALIGN_CENTER);
//                lin11.addElement(lin11p0);
//                PdfPCell lin12 = new PdfPCell();
//                final Paragraph lin12p0 = new Paragraph();
//                Phrase phrase12p0 = new Phrase();
//                phrase12p0.add(ChunkFactoryOld.tablenounderLine(book.getValue(5), 1488, fontChineseNormalsimfang12));
//
//                lin12p0.add(phrase12p0);
//
//                lin12.addElement(lin12p0);
//                PdfPTable cellTable1 = new PdfPTable(2);
//                cellTable1.setWidths(celltable0float);
//                cellTable1.addCell(lin11);
//                cellTable1.addCell(lin12);
//                PdfPCell row1 = new PdfPCell(cellTable1);
//                row1.setFixedHeight(145f);
//                table.addCell(row1);
//
//                PdfPCell lin21 = new PdfPCell();
//                final Paragraph lin21p0 = new Paragraph("\n证据名称及数量 ", fontChineseNormalsimfang12);
//                lin21p0.setAlignment(Element.ALIGN_CENTER);
//                lin21.addElement(lin21p0);
//                PdfPCell lin22 = new PdfPCell();
//                final Paragraph lin22p0 = new Paragraph();
//
//                Phrase phrase22p0 = new Phrase();
//                phrase22p0.add(ChunkFactoryOld.tablenounderLine(book.getValue(6), 744, fontChineseNormalsimfang12));
//
//                lin22p0.add(phrase22p0);
//
//                lin22.addElement(lin22p0);
//                PdfPTable cellTable2 = new PdfPTable(2);
//                cellTable2.setWidths(celltable0float);
//                cellTable2.addCell(lin21);
//                cellTable2.addCell(lin22);
//                PdfPCell row2 = new PdfPCell(cellTable2);
//                row2.setFixedHeight(65f);
//                table.addCell(row2);
//
//                PdfPCell lin31 = new PdfPCell();
//                final Paragraph lin31p0 = new Paragraph("\n\n提请理由及依据", fontChineseNormalsimfang12);
//                lin31p0.setAlignment(Element.ALIGN_CENTER);
//                lin31.addElement(lin31p0);
//                PdfPCell lin32 = new PdfPCell();
//                final Paragraph lin32p0 = new Paragraph();
//
//                Phrase phrase32p0 = new Phrase();
//                phrase32p0.add(ChunkFactoryOld.tablenounderLine(book.getValue(7), 1116, fontChineseNormalsimfang12));
//
//                lin32p0.add(phrase32p0);
//
//                lin32.addElement(lin32p0);
//                PdfPTable cellTable3 = new PdfPTable(2);
//                cellTable3.setWidths(celltable0float);
//                cellTable3.addCell(lin31);
//                cellTable3.addCell(lin32);
//                PdfPCell row3 = new PdfPCell(cellTable3);
//                row3.setFixedHeight(85f);
//                table.addCell(row3);
//
//                PdfPCell lin41 = new PdfPCell();
//                final Paragraph lin41p0 = new Paragraph("保存方式", fontChineseNormalsimfang12);
//                lin41p0.setAlignment(Element.ALIGN_CENTER);
//                lin41.addElement(lin41p0);
//                PdfPCell lin42 = new PdfPCell();
//                final Paragraph lin42p0 = new Paragraph();
//
//                Phrase phrase42p0 = new Phrase();
//                phrase42p0.add(ChunkFactoryOld.tablenounderLine(book.getValue(8), 372, fontChineseNormalsimfang12));
//
//                lin42p0.add(phrase42p0);
//
//
//                lin42.addElement(lin42p0);
//                PdfPTable cellTable4 = new PdfPTable(2);
//                cellTable4.setWidths(celltable0float);
//                cellTable4.addCell(lin41);
//                cellTable4.addCell(lin42);
//                PdfPCell row4 = new PdfPCell(cellTable4);
//                row4.setFixedHeight(36f);
//                table.addCell(row4);
//
//                PdfPCell lin51 = new PdfPCell();
//                final Paragraph lin51p0 = new Paragraph();
//                lin51p0.setIndentationLeft(1f);
//                lin51p0.setLeading(24f);
//                lin51p0.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase2 = new Phrase();
//                phrase2.add(new Chunk("承办人意见：", fontChineseNormalsimfang12));
//                phrase2.add(ChunkFactoryOld.tablenounderLine(book.getValue(9), 180,
//                        fontChineseNormalsimfang12));
//
//                Phrase phrase3 = new Phrase();
//                phrase3.add(new Chunk("承办人（签名）：", fontChineseNormalsimfang12));
//                phrase3.add(ChunkFactoryOld.tablenounderLine(book.getValue(10), 180,
//                        fontChineseNormalsimfang12));
//                phrase3.add(ChunkFactoryOld.tablenounderLine(StringFactoryBuild.build().getTime(book.getValue(11), 0), 12,
//                        fontChineseNormalsimfang12));
//                phrase3.add(new Chunk("年", fontChineseNormalsimfang12));
//                phrase3.add(ChunkFactoryOld.tablenounderLine(StringFactoryBuild.build().getTime(book.getValue(11), 1), 12,
//                        fontChineseNormalsimfang12));
//                phrase3.add(new Chunk("月", fontChineseNormalsimfang12));
//                phrase3.add(ChunkFactoryOld.tablenounderLine(StringFactoryBuild.build().getTime(book.getValue(11), 2), 12,
//                        fontChineseNormalsimfang12));
//                phrase3.add(new Chunk("日", fontChineseNormalsimfang12));
//
//                lin51p0.add(phrase2);
//                lin51p0.add(space2);
//                lin51p0.add(space2);
//                lin51p0.add(phrase3);
//                lin51.addElement(lin51p0);
//
//                PdfPTable cellTable5 = new PdfPTable(1);
//                cellTable5.setWidthPercentage(250f);
//                cellTable5.addCell(lin51);
//                PdfPCell row5 = new PdfPCell(cellTable5);
//                row5.setFixedHeight(70f);
//                table.addCell(row5);
//
//                PdfPCell lin61 = new PdfPCell();
//                final Paragraph lin61p0 = new Paragraph();
//                lin61p0.setIndentationLeft(1f);
//                lin61p0.setLeading(24f);
//                lin61p0.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase4 = new Phrase();
//                phrase4.add(new Chunk("部门负责人意见：", fontChineseNormalsimfang12));
//                phrase4.add(ChunkFactoryOld.tablenounderLine(book.getValue(12), 180,
//                        fontChineseNormalsimfang12));
//
//                Phrase phrase5 = new Phrase();
//                phrase5.add(new Chunk("负责人（签名）：", fontChineseNormalsimfang12));
//                phrase5.add(ChunkFactoryOld.tablenounderLine(book.getValue(13), 180,
//                        fontChineseNormalsimfang12));
//                phrase5.add(ChunkFactoryOld.tablenounderLine(StringFactoryBuild.build().getTime(book.getValue(14), 0), 12,
//                        fontChineseNormalsimfang12));
//                phrase5.add(new Chunk("年", fontChineseNormalsimfang12));
//                phrase5.add(ChunkFactoryOld.tablenounderLine(StringFactoryBuild.build().getTime(book.getValue(14), 1), 12,
//                        fontChineseNormalsimfang12));
//                phrase5.add(new Chunk("月", fontChineseNormalsimfang12));
//                phrase5.add(ChunkFactoryOld.tablenounderLine(StringFactoryBuild.build().getTime(book.getValue(14), 2), 12,
//                        fontChineseNormalsimfang12));
//                phrase5.add(new Chunk("日", fontChineseNormalsimfang12));
//
//                lin61p0.add(phrase4);
//                lin61p0.add(space2);
//                lin61p0.add(space2);
//                lin61p0.add(phrase5);
//                lin61.addElement(lin61p0);
//
//                PdfPTable cellTable6 = new PdfPTable(1);
//                cellTable6.setWidthPercentage(250f);
//                cellTable6.addCell(lin61);
//                PdfPCell row6 = new PdfPCell(cellTable6);
//                row6.setFixedHeight(70f);
//                table.addCell(row6);
//
//                PdfPCell lin71 = new PdfPCell();
//                final Paragraph lin71p0 = new Paragraph();
//                lin71p0.setIndentationLeft(1f);
//                lin71p0.setLeading(24f);
//                lin71p0.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase6 = new Phrase();
//                phrase6.add(new Chunk("机关负责人意见：", fontChineseNormalsimfang12));
//                phrase6.add(ChunkFactoryOld.tablenounderLine(book.getValue(15), 180,
//                        fontChineseNormalsimfang12));
//
//                Phrase phrase7 = new Phrase();
//                phrase7.add(new Chunk("负责人（签名）：", fontChineseNormalsimfang12));
//                phrase7.add(ChunkFactoryOld.tablenounderLine(book.getValue(16), 180,
//                        fontChineseNormalsimfang12));
//                phrase7.add(ChunkFactoryOld.tablenounderLine(StringFactoryBuild.build().getTime(book.getValue(17), 0), 12,
//                        fontChineseNormalsimfang12));
//                phrase7.add(new Chunk("年", fontChineseNormalsimfang12));
//                phrase7.add(ChunkFactoryOld.tablenounderLine(StringFactoryBuild.build().getTime(book.getValue(17), 1), 12,
//                        fontChineseNormalsimfang12));
//                phrase7.add(new Chunk("月", fontChineseNormalsimfang12));
//                phrase7.add(ChunkFactoryOld.tablenounderLine(StringFactoryBuild.build().getTime(book.getValue(17), 2), 12,
//                        fontChineseNormalsimfang12));
//                phrase7.add(new Chunk("日", fontChineseNormalsimfang12));
//
//                lin71p0.add(phrase6);
//                lin71p0.add(space2);
//                lin71p0.add(space2);
//                lin71p0.add(phrase7);
//                lin71.addElement(lin71p0);
//
//                PdfPTable cellTable7 = new PdfPTable(1);
//                cellTable7.setWidthPercentage(250f);
//                cellTable7.addCell(lin71);
//                PdfPCell row7 = new PdfPCell(cellTable7);
//                row7.setFixedHeight(80f);
//                table.addCell(row7);
//
//                document.add(table);
//                // 表格end
//
//                PdfContentByte canvas2 = dpfwPdfWriter.getDirectContent();
//                // 电子签章
//                Image img = ImageBuilder.getInstance(image);
//                if (img != null) {
//                    img.setAbsolutePosition(350, 140);
//                    canvas2.addImage(img);
//                }
//                document.newPage();
//            }
//        });
//
//    }
//
//    //先行登记保存证据通知单
//    public void printerEntity_Book6(final Base_Entity book, final Object image) {
//        printFrameWork(book, image, new IPdfBackFrame() {
//            @Override
//            public void writeContent() throws Exception {
//                //此处写页面布局
//                document.add(space1);
//
//                final Paragraph title = new Paragraph("" + city + "安全生产行政执法文书", fontChineseBoldsimhei15);// Paragraph就是段落
//                title.setLeading(1f);// 段落距离
//                // title.setSpacingBefore(25f);//段落留白
//                title.setAlignment(Element.ALIGN_CENTER);// 居中
//                document.add(title);// 写入文档
//                final Paragraph titleLine1 = new Paragraph(new Chunk(new LineSeparator()));// 加入一个换行
//                titleLine1.setLeading(1f);
//                titleLine1.setSpacingBefore(5f);
//                document.add(titleLine1);
//                final Paragraph titleLine2 = new Paragraph(new Chunk(new LineSeparator()));
//                titleLine2.setLeading(1f);
//                titleLine2.setSpacingBefore(1f);
//                document.add(titleLine2);
//                final Paragraph title2 = new Paragraph("先行登记保存证据通知书", fontChineseBoldsimhei15);
//
//                title2.setLeading(1f);
//                title2.setSpacingBefore(17f);
//                title2.setAlignment(Element.ALIGN_CENTER);
//                document.add(title2);
//
//                final Paragraph title3 = new Paragraph("( " + book.getValue(0) + " )安监管先保通〔" + book.getValue(1) + "〕"
//                        + book.getValue(2) + "号", fontChineseNormalsimfang12);
//                title3.setLeading(1f);
//                title3.setSpacingBefore(34f);
//                title3.setAlignment(Element.ALIGN_CENTER);
//                document.add(title3);
//
//                document.add(space1);
//
//                final Paragraph entParagraph = new Paragraph();
//                entParagraph.setLeading(24f);
//                entParagraph.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase1 = new Phrase();
//                phrase1.add((ChunkFactoryOld.underLine(book.getValue(3), 216,
//                        fontChineseNormalsimfang12)));
//                phrase1.add(new Chunk(":", fontChineseNormalsimfang12));
//                toMeasurefloat(phrase1);
//
//                entParagraph.add(phrase1);
//
//                document.add(entParagraph);
//
//                final Paragraph paragraph1 = new Paragraph();
//                paragraph1.setFirstLineIndent(24f);
//                paragraph1.setLeading(24f);
//                paragraph1.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase2 = new Phrase();
//                phrase2.add(new Chunk("你（单位）涉嫌", fontChineseNormalsimfang12));
//                phrase2.add(ChunkFactoryOld.underLine(book.getValue(4), 264,
//                        fontChineseNormalsimfang12));
//                phrase2.add(new Chunk(
//                        "行为。为确保调查取证工作，依据《中华人民共和国行政处罚法》第三十七条第二款的规定，本行政机关决定对你（单位）的有关证据（证据名称、数量等详见附后清单）采取先行登记保存措施。",
//                        fontChineseNormalsimfang12));
//
//                paragraph1.add(phrase2);
//                document.add(paragraph1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//
//                final Paragraph paragraph2 = new Paragraph(new Chunk("文书制作注意事项：",
//                        fontChineseNormalsimfang12));
//                paragraph2.setFirstLineIndent(24f);
//                paragraph2.setLeading(24f);
//                paragraph2.setAlignment(Element.ALIGN_LEFT);
//
//                document.add(paragraph2);
//
//                final Paragraph paragraph3 = new Paragraph();
//                paragraph3.setFirstLineIndent(24f);
//                paragraph3.setLeading(24f);
//                paragraph3.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase3 = new Phrase();
//                phrase3.add(new Chunk("1.对先行登记保存的证据，本行政机关将在七日内依法作出处理决定。请你",
//                        fontChineseNormalsimfang12));
//
//                Phrase phrase4 = new Phrase();
//                phrase4.add(new Chunk("（单位）于", fontChineseNormalsimfang12));
//                phrase4.add(ChunkFactoryOld
//                        .underLine(StringFactoryBuild.build().getTime(book.getValue(5), 0), 60, fontChineseNormalsimfang12));
//                phrase4.add(new Chunk("年", fontChineseNormalsimfang12));
//                phrase4.add(ChunkFactoryOld
//                        .underLine(StringFactoryBuild.build().getTime(book.getValue(5), 1), 36, fontChineseNormalsimfang12));
//                phrase4.add(new Chunk("月", fontChineseNormalsimfang12));
//                phrase4.add(ChunkFactoryOld
//                        .underLine(StringFactoryBuild.build().getTime(book.getValue(5), 2), 36, fontChineseNormalsimfang12));
//                phrase4.add(new Chunk("日到", fontChineseNormalsimfang12));
//                phrase4.add(ChunkFactoryOld.underLine(book.getValue(6), 138,
//                        fontChineseNormalsimfang12));
//
//                Phrase phrase5 = new Phrase();
//                phrase5.add(new Chunk("接受对先行登记保存证据的处理决定。", fontChineseNormalsimfang12));
//
//                paragraph3.add(phrase3);
//                paragraph3.add(phrase4);
//                paragraph3.add(phrase5);
//
//                document.add(paragraph3);
//
//                final Paragraph paragraph4 = new Paragraph();
//                paragraph4.setFirstLineIndent(24f);
//                paragraph4.setLeading(24f);
//                paragraph4.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase6 = new Phrase();
//                phrase6.add(new Chunk(
//                        "2.对就地先行登记保存的证据，在本行政机关作出处理决定前，你（单位）负有妥善保管的义务，不得有缺失、灭失、损毁或擅自移动等改变证据物品的任何行为。",
//                        fontChineseNormalsimfang12));
//                paragraph4.add(phrase6);
//
//                document.add(paragraph4);
//
//                final Paragraph paragraph5 = new Paragraph();
//                paragraph5.setFirstLineIndent(24f);
//                paragraph5.setLeading(24f);
//                paragraph5.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase7 = new Phrase();
//                phrase7.add(new Chunk("3.请核对证据清单后，签名确认。", fontChineseNormalsimfang12));
//                paragraph5.add(phrase7);
//
//                document.add(paragraph5);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//
//                final Paragraph paragraph6 = new Paragraph();
//                paragraph6.setFirstLineIndent(264f);
//                paragraph6.setLeading(24f);
//                paragraph6.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase8 = new Phrase();
//                phrase8.add(new Chunk("安全生产监督管理部门（公章）", fontChineseNormalsimfang12));
//                toMeasurefloat(phrase8);
//
//                paragraph6.add(phrase8);
//                document.add(paragraph6);
//
//                final Paragraph paragraph7 = new Paragraph();
//                paragraph7.setFirstLineIndent(264f);
//                paragraph7.setLeading(24f);
//                paragraph7.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase9 = new Phrase();
//                phrase9.add(ChunkFactoryOld.tablenounderLine(StringFactoryBuild.build().getTime(book.getValue(8), 0), 36,
//                        fontChineseNormalsimfang12));
//                phrase9.add(new Chunk("年", fontChineseNormalsimfang12));
//                phrase9.add(ChunkFactoryOld.tablenounderLine(StringFactoryBuild.build().getTime(book.getValue(8), 1), 6,
//                        fontChineseNormalsimfang12));
//                phrase9.add(new Chunk("月", fontChineseNormalsimfang12));
//                phrase9.add(ChunkFactoryOld.tablenounderLine(StringFactoryBuild.build().getTime(book.getValue(8), 2), 6,
//                        fontChineseNormalsimfang12));
//                phrase9.add(new Chunk("日", fontChineseNormalsimfang12));
//                toMeasurefloat(phrase9);
//
//                paragraph7.add(phrase9);
//                document.add(paragraph7);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                final Paragraph paragraph8 = new Paragraph();
//                paragraph8.setFirstLineIndent(24f);
//                paragraph8.setLeading(24f);
//                paragraph8.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase10 = new Phrase();
//                phrase10.add(new Chunk("被通知人或被通知人单位负责人（签名）：", fontChineseNormalsimfang12));
//                phrase10.add(ChunkFactoryOld.underLine(book.getValue(7), 84,
//                        fontChineseNormalsimfang12));
//
//                paragraph8.add(phrase10);
//                document.add(paragraph8);
//
//                final Paragraph bottomLine1 = new Paragraph(
//                        new Chunk(new LineSeparator()));// 加入一个换行
//                bottomLine1.setLeading(1f);
//                bottomLine1.setSpacingBefore(4f);
//
//                document.add(bottomLine1);
//
//                final Paragraph paragraph9 = new Paragraph();
//                Phrase phrase14 = new Phrase();
//                phrase14.add(new Chunk("本文书一式两份：一份由安全生产监督管理部门备案，一份交被取证人（单位）。",
//                        fontChineseNormalsimfang12));
//                paragraph9.add(phrase14);
//
//                document.add(paragraph9);
//
//                PdfContentByte canvas2 = dpfwPdfWriter.getDirectContent();
//                // 电子签章
//                Image img = ImageBuilder.getInstance(image);
//                if (img != null) {
//                    img.setAbsolutePosition(350, 140);
//                    canvas2.addImage(img);
//                }
//
//                document.newPage();// 结束保存
//            }
//        });
//
//    }
//
//    //先行登记保存证据处理审批表
//    public void printerEntity_Book7(final Base_Entity book, final Object image) {
//        printFrameWork(book, image, new IPdfBackFrame() {
//            @Override
//            public void writeContent() throws Exception {
//                //此处写页面布局
//                document.add(space1);
//
//                final Paragraph title = new Paragraph("" + city + "安全生产行政执法文书", fontChineseBoldsimhei15);// Paragraph就是段落
//                title.setLeading(1f);// 段落距离
//                // title.setSpacingBefore(25f);//段落留白
//                title.setAlignment(Element.ALIGN_CENTER);// 居中
//                document.add(title);// 写入文档
//                final Paragraph titleLine1 = new Paragraph(new Chunk(new LineSeparator()));// 加入一个换行
//                titleLine1.setLeading(1f);
//                titleLine1.setSpacingBefore(5f);
//                document.add(titleLine1);
//                final Paragraph titleLine2 = new Paragraph(new Chunk(new LineSeparator()));
//                titleLine2.setLeading(1f);
//                titleLine2.setSpacingBefore(1f);
//                document.add(titleLine2);
//                final Paragraph title2 = new Paragraph("先行登记保存证据处理审批表", fontChineseBoldsimhei15);
//
//                title2.setLeading(1f);
//                title2.setSpacingBefore(17f);
//                title2.setAlignment(Element.ALIGN_CENTER);
//                document.add(title2);
//                document.add(space2);
//                document.add(space2);
//                document.add(space2);
//
//                final Paragraph paragraph1 = new Paragraph();
//                paragraph1.setLeading(24f);
//                paragraph1.setIndentationLeft(2f);
//                paragraph1.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase1 = new Phrase();
//                phrase1.add(new Chunk("案件名称:", fontChineseNormalsimfang12));
//                phrase1.add(ChunkFactoryOld.underLine(book.getValue(3), 366,
//                        fontChineseNormalsimfang12));
//
//                paragraph1.add(phrase1);
//                document.add(paragraph1);
//                document.add(space2);
//
//                // 表格start
//                PdfPTable table = new PdfPTable(1);
//                table.setWidthPercentage(100f);
//
//                PdfPCell lin01 = new PdfPCell();
//                final Paragraph lin01p0 = new Paragraph("当事人及\n基本情况", fontChineseNormalsimfang12);
//                lin01p0.setAlignment(Element.ALIGN_CENTER);
//                lin01.addElement(lin01p0);
//                PdfPCell lin02 = new PdfPCell();
//                final Paragraph lin02p0 = new Paragraph();
//
//                Phrase phrase02p0 = new Phrase();
//                phrase02p0.add(ChunkFactoryOld.tablenounderLine(book.getValue(4), 744, fontChineseNormalsimfang12));
//                lin02p0.add(phrase02p0);
//
//                lin02.addElement(lin02p0);
//                PdfPTable celltable0 = new PdfPTable(2);
//                float[] celltable0float = new float[2];
//                celltable0float[0] = 2f;
//                celltable0float[1] = 8f;
//                celltable0.setTotalWidth(celltable0float);
//                celltable0.addCell(lin01);
//                celltable0.addCell(lin02);
//                PdfPCell row0 = new PdfPCell(celltable0);
//                row0.setFixedHeight(45f);
//                table.addCell(row0);
//
//                PdfPCell lin11 = new PdfPCell();
//                final Paragraph lin11p0 = new Paragraph("\n\n\n案件基本情况 ",
//                        fontChineseNormalsimfang12);
//                lin11p0.setAlignment(Element.ALIGN_CENTER);
//                lin11.addElement(lin11p0);
//                PdfPCell lin12 = new PdfPCell();
//                final Paragraph lin12p0 = new Paragraph();
//
//                Phrase phrase12p0 = new Phrase();
//                phrase12p0.add(ChunkFactoryOld.tablenounderLine(book.getValue(5), 1488, fontChineseNormalsimfang12));
//                lin12p0.add(phrase12p0);
//
//
//                lin12.addElement(lin12p0);
//                PdfPTable cellTable1 = new PdfPTable(2);
//                cellTable1.setWidths(celltable0float);
//                cellTable1.addCell(lin11);
//                cellTable1.addCell(lin12);
//                PdfPCell row1 = new PdfPCell(cellTable1);
//                row1.setFixedHeight(140f);
//                table.addCell(row1);
//
//                PdfPCell lin21 = new PdfPCell();
//                final Paragraph lin21p0 = new Paragraph("\n证据名称及数量 ", fontChineseNormalsimfang12);
//                lin21p0.setAlignment(Element.ALIGN_CENTER);
//                lin21.addElement(lin21p0);
//                PdfPCell lin22 = new PdfPCell();
//                final Paragraph lin22p0 = new Paragraph();
//
//                Phrase phrase22p0 = new Phrase();
//                phrase22p0.add(ChunkFactoryOld.tablenounderLine(book.getValue(6), 1116, fontChineseNormalsimfang12));
//                lin22p0.add(phrase22p0);
//
//
//                lin22.addElement(lin22p0);
//                PdfPTable cellTable2 = new PdfPTable(2);
//                cellTable2.setWidths(celltable0float);
//                cellTable2.addCell(lin21);
//                cellTable2.addCell(lin22);
//                PdfPCell row2 = new PdfPCell(cellTable2);
//                row2.setFixedHeight(80f);
//                table.addCell(row2);
//
//                PdfPCell lin31 = new PdfPCell();
//                final Paragraph lin31p0 = new Paragraph("\n提请理由及依据", fontChineseNormalsimfang12);
//                lin31p0.setAlignment(Element.ALIGN_CENTER);
//                lin31.addElement(lin31p0);
//                PdfPCell lin32 = new PdfPCell();
//                final Paragraph lin32p0 = new Paragraph();
//
//
//                Phrase phrase32p0 = new Phrase();
//                phrase32p0.add(ChunkFactoryOld.tablenounderLine(book.getValue(7), 1116, fontChineseNormalsimfang12));
//                lin32p0.add(phrase32p0);
//
//
//                lin32.addElement(lin32p0);
//                PdfPTable cellTable3 = new PdfPTable(2);
//                cellTable3.setWidths(celltable0float);
//                cellTable3.addCell(lin31);
//                cellTable3.addCell(lin32);
//                PdfPCell row3 = new PdfPCell(cellTable3);
//                row3.setFixedHeight(85f);
//                table.addCell(row3);
//
//                PdfPCell lin51 = new PdfPCell();
//                final Paragraph lin51p0 = new Paragraph();
//                lin51p0.setIndentationLeft(1f);
//                lin51p0.setLeading(24f);
//                lin51p0.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase2 = new Phrase();
//                phrase2.add(new Chunk("承办人意见：", fontChineseNormalsimfang12));
//                phrase2.add(ChunkFactoryOld.tablenounderLine(book.getValue(8), 180,
//                        fontChineseNormalsimfang12));
//
//                Phrase phrase3 = new Phrase();
//                phrase3.add(new Chunk("承办人（签名）：", fontChineseNormalsimfang12));
//                phrase3.add(ChunkFactoryOld.tablenounderLine(book.getValue(9), 180,
//                        fontChineseNormalsimfang12));
//                phrase3.add(ChunkFactoryOld.tablenounderLine(StringFactoryBuild.build().getTime(book.getValue(10), 0), 12,
//                        fontChineseNormalsimfang12));
//                phrase3.add(new Chunk("年", fontChineseNormalsimfang12));
//                phrase3.add(ChunkFactoryOld.tablenounderLine(StringFactoryBuild.build().getTime(book.getValue(10), 1), 12,
//                        fontChineseNormalsimfang12));
//                phrase3.add(new Chunk("月", fontChineseNormalsimfang12));
//                phrase3.add(ChunkFactoryOld.tablenounderLine(StringFactoryBuild.build().getTime(book.getValue(10), 2), 12,
//                        fontChineseNormalsimfang12));
//                phrase3.add(new Chunk("日", fontChineseNormalsimfang12));
//
//                lin51p0.add(phrase2);
//                lin51p0.add(space2);
//                lin51p0.add(space2);
//                lin51p0.add(phrase3);
//                lin51.addElement(lin51p0);
//
//                PdfPTable cellTable5 = new PdfPTable(1);
//                cellTable5.setWidthPercentage(250f);
//                cellTable5.addCell(lin51);
//                PdfPCell row5 = new PdfPCell(cellTable5);
//                row5.setFixedHeight(85f);
//                table.addCell(row5);
//
//                PdfPCell lin61 = new PdfPCell();
//                final Paragraph lin61p0 = new Paragraph();
//                lin61p0.setIndentationLeft(1f);
//                lin61p0.setLeading(24f);
//                lin61p0.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase4 = new Phrase();
//                phrase4.add(new Chunk("部门负责人意见：", fontChineseNormalsimfang12));
//                phrase4.add(ChunkFactoryOld.tablenounderLine(book.getValue(11), 180,
//                        fontChineseNormalsimfang12));
//
//                Phrase phrase5 = new Phrase();
//                phrase5.add(new Chunk("负责人（签名）：", fontChineseNormalsimfang12));
//                phrase5.add(ChunkFactoryOld.tablenounderLine(book.getValue(12), 180,
//                        fontChineseNormalsimfang12));
//                phrase5.add(ChunkFactoryOld.tablenounderLine(StringFactoryBuild.build().getTime(book.getValue(13), 0), 12,
//                        fontChineseNormalsimfang12));
//                phrase5.add(new Chunk("年", fontChineseNormalsimfang12));
//                phrase5.add(ChunkFactoryOld.tablenounderLine(StringFactoryBuild.build().getTime(book.getValue(13), 1), 12,
//                        fontChineseNormalsimfang12));
//                phrase5.add(new Chunk("月", fontChineseNormalsimfang12));
//                phrase5.add(ChunkFactoryOld.tablenounderLine(StringFactoryBuild.build().getTime(book.getValue(13), 2), 12,
//                        fontChineseNormalsimfang12));
//                phrase5.add(new Chunk("日", fontChineseNormalsimfang12));
//
//                lin61p0.add(phrase4);
//                lin61p0.add(space2);
//                lin61p0.add(space2);
//                lin61p0.add(phrase5);
//                lin61.addElement(lin61p0);
//
//                PdfPTable cellTable6 = new PdfPTable(1);
//                cellTable6.setWidthPercentage(250f);
//                cellTable6.addCell(lin61);
//                PdfPCell row6 = new PdfPCell(cellTable6);
//                row6.setFixedHeight(85f);
//                table.addCell(row6);
//
//                PdfPCell lin71 = new PdfPCell();
//                final Paragraph lin71p0 = new Paragraph();
//                lin71p0.setIndentationLeft(1f);
//                lin71p0.setLeading(24f);
//                lin71p0.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase6 = new Phrase();
//                phrase6.add(new Chunk("机关负责人意见：", fontChineseNormalsimfang12));
//                phrase6.add(ChunkFactoryOld.tablenounderLine(book.getValue(14), 180,
//                        fontChineseNormalsimfang12));
//
//                Phrase phrase7 = new Phrase();
//                phrase7.add(new Chunk("负责人（签名）：", fontChineseNormalsimfang12));
//                phrase7.add(ChunkFactoryOld.tablenounderLine(book.getValue(15), 180,
//                        fontChineseNormalsimfang12));
//                phrase7.add(ChunkFactoryOld.tablenounderLine(StringFactoryBuild.build().getTime(book.getValue(16), 0), 12,
//                        fontChineseNormalsimfang12));
//                phrase7.add(new Chunk("年", fontChineseNormalsimfang12));
//                phrase7.add(ChunkFactoryOld.tablenounderLine(StringFactoryBuild.build().getTime(book.getValue(16), 1), 12,
//                        fontChineseNormalsimfang12));
//                phrase7.add(new Chunk("月", fontChineseNormalsimfang12));
//                phrase7.add(ChunkFactoryOld.tablenounderLine(StringFactoryBuild.build().getTime(book.getValue(16), 2), 12,
//                        fontChineseNormalsimfang12));
//                phrase7.add(new Chunk("日", fontChineseNormalsimfang12));
//
//                lin71p0.add(phrase6);
//                lin71p0.add(space2);
//                lin71p0.add(space2);
//                lin71p0.add(phrase7);
//                lin71.addElement(lin71p0);
//
//                PdfPTable cellTable7 = new PdfPTable(1);
//                cellTable7.setWidthPercentage(250f);
//                cellTable7.addCell(lin71);
//                PdfPCell row7 = new PdfPCell(cellTable7);
//                row7.setFixedHeight(85f);
//                table.addCell(row7);
//
//                document.add(table);
//                document.add(space1);
//                // 表格end
//
//                PdfContentByte canvas2 = dpfwPdfWriter.getDirectContent();
//                // 电子签章
//                Image img = ImageBuilder.getInstance(image);
//                if (img != null) {
//                    img.setAbsolutePosition(350, 140);
//                    canvas2.addImage(img);
//                }
//                document.newPage();
//            }
//        });
//
//    }
//
//    //先行登记保存证据处理决定书
//    public void printerEntity_Book8(final Base_Entity book, final Object image) {
//        printFrameWork(book, image, new IPdfBackFrame() {
//            @Override
//            public void writeContent() throws Exception {
//                //此处写页面布局
//                document.add(space1);
//
//                final Paragraph title = new Paragraph("" + city + "安全生产行政执法文书", fontChineseBoldsimhei15);// Paragraph就是段落
//                title.setLeading(1f);// 段落距离
//                // title.setSpacingBefore(25f);//段落留白
//                title.setAlignment(Element.ALIGN_CENTER);// 居中
//                document.add(title);// 写入文档
//                final Paragraph titleLine1 = new Paragraph(new Chunk(new LineSeparator()));// 加入一个换行
//                titleLine1.setLeading(1f);
//                titleLine1.setSpacingBefore(5f);
//                document.add(titleLine1);
//                final Paragraph titleLine2 = new Paragraph(new Chunk(new LineSeparator()));
//                titleLine2.setLeading(1f);
//                titleLine2.setSpacingBefore(1f);
//                document.add(titleLine2);
//                final Paragraph title2 = new Paragraph("先行登记保存证据处理决定书", fontChineseBoldsimhei15);
//
//                title2.setLeading(1f);
//                title2.setSpacingBefore(17f);
//                title2.setAlignment(Element.ALIGN_CENTER);
//                document.add(title2);
//
//                final Paragraph title3 = new Paragraph("( " + book.getValue(0) + " )安监管先保处〔" + book.getValue(1) + "〕"
//                        + book.getValue(2) + "号", fontChineseNormalsimfang12);
//                title3.setLeading(1f);
//                title3.setSpacingBefore(34f);
//                title3.setAlignment(Element.ALIGN_CENTER);
//                document.add(title3);
//
//                document.add(space2);
//
//                final Paragraph entParagraph = new Paragraph();
//                entParagraph.setLeading(24f);
//                entParagraph.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase1 = new Phrase();
//                phrase1.add((ChunkFactoryOld.underLine(book.getValue(2), 192,
//                        fontChineseNormalsimfang12)));
//                phrase1.add(new Chunk(":", fontChineseNormalsimfang12));
//                toMeasurefloat(phrase1);
//
//                entParagraph.add(phrase1);
//
//                document.add(entParagraph);
//
//                final Paragraph paragraph1 = new Paragraph();
//                paragraph1.setFirstLineIndent(306f);
//                paragraph1.setLeading(24f);
//                paragraph1.setAlignment(Element.ALIGN_LEFT);
//
//                final Paragraph paragraph1_1 = new Paragraph();
//                paragraph1_1.setFirstLineIndent(0f);
//                paragraph1_1.setLeading(24f);
//                paragraph1_1.setAlignment(Element.ALIGN_LEFT);
//
//                final Paragraph paragraph1_2 = new Paragraph();
//                paragraph1_2.setFirstLineIndent(24f);
//                paragraph1_2.setLeading(24f);
//                paragraph1_2.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase2 = new Phrase();
//                Phrase phrase2_1 = new Phrase();
//                Phrase phrase2_2 = new Phrase();
//                // phrase2.add(new Chunk("本机关于", fontChineseKNormal));
//                // phrase2.add(Help_Pdf_Help.underLine("", 60,
//                // fontChineseKNormal));
//                // phrase2.add(new Chunk("年", fontChineseKNormal));
//                // phrase2.add(Help_Pdf_Help.underLine("", 36,
//                // fontChineseKNormal));
//                // phrase2.add(new Chunk("月", fontChineseKNormal));
//                // phrase2.add(Help_Pdf_Help.underLine("", 36,
//                // fontChineseKNormal));
//                // phrase2.add(new Chunk("日对你（单位）的", fontChineseKNormal));
//                PdfContentByte canvas = dpfwPdfWriter.getDirectContent();
//
//                Phrase phrase18 = new Phrase();
////                phrase18.add(new Chunk("对上述物品做如下处理：", fontChineseNormalsimfang12));
//                ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phrase18,
//                        120, 625, 0);
//                Phrase phrase22 = new Phrase();
//                phrase22.add(new Chunk("本机关于", fontChineseNormalsimfang12));
//                phrase22.add(ChunkFactoryOld.underLine(StringFactoryBuild.build().getTime(book.getValue(4), 0), 36,
//                        fontChineseNormalsimfang12));
//                phrase22.add(new Chunk("年", fontChineseNormalsimfang12));
//                phrase22.add(ChunkFactoryOld.underLine(StringFactoryBuild.build().getTime(book.getValue(4), 1), 12,
//                        fontChineseNormalsimfang12));
//                phrase22.add(new Chunk("月", fontChineseNormalsimfang12));
//                phrase22.add(ChunkFactoryOld.underLine(StringFactoryBuild.build().getTime(book.getValue(4), 2), 12,
//                        fontChineseNormalsimfang12));
//                phrase22.add(new Chunk("日对你（单位）的", fontChineseNormalsimfang12));
//                ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phrase22,
//                        120, 625, 0);
//                phrase2.add(ChunkFactoryOld.underLine(book.getValue(5), 972,
//                        fontChineseNormalsimfang12,306,430));
//
//
//                phrase2_1.add(new Chunk("等物品进行了先行登记保存[文号:", fontChineseNormalsimfang12));
//                phrase2_1.add(ChunkFactoryOld.tablenounderLine("", 0,
//                        fontChineseNormalsimfang12));
//                phrase2_1.add(new Chunk("（", fontChineseNormalsimfang12));
//                phrase2_1.add(ChunkFactoryOld.tablenounderLine(book.getValue(6), 24,
//                        fontChineseNormalsimfang12));
//                phrase2_1.add(new Chunk("）安监管先保通〔", fontChineseNormalsimfang12));
//                phrase2_1.add(ChunkFactoryOld.tablenounderLine(book.getValue(7), 24,
//                        fontChineseNormalsimfang12));
//                phrase2_1.add(new Chunk("〕", fontChineseNormalsimfang12));
//                phrase2_1.add(ChunkFactoryOld.tablenounderLine(book.getValue(8), 24,
//                        fontChineseNormalsimfang12));
//                phrase2_1.add(new Chunk("号]。现依法对上述物品做如下处理：", fontChineseNormalsimfang12));
//
////                phrase2_1.add(new Chunk("对上述物品作出如下处理：", fontChineseKNormal));
//
//                phrase2_2.add(ChunkFactoryOld.underLine(book.getValue(9), 3850,
//                        fontChineseNormalsimfang12,24,430));
//
//                paragraph1.add(phrase2);
//                paragraph1_1.add(phrase2_1);
//                paragraph1_2.add(phrase2_2);
//                document.add(paragraph1);
//                document.add(paragraph1_1);
//                document.add(paragraph1_2);
//
//                final Paragraph paragraph2 = new Paragraph();
//                paragraph2.setFirstLineIndent(24f);
//                paragraph2.setLeading(24f);
//                paragraph2.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase3 = new Phrase();
//                phrase3.add(new Chunk("如果不服本决定，可以依法在60日内向", fontChineseNormalsimfang12));
//                phrase3.add(ChunkFactoryOld.underLine(book.getValue(10), 120,
//                        fontChineseNormalsimfang12));
//                phrase3.add(new Chunk("人民政府或者", fontChineseNormalsimfang12));
//                phrase3.add(ChunkFactoryOld.underLine(book.getValue(11), 108,
//                        fontChineseNormalsimfang12));
//                phrase3.add(new Chunk("申请行政复议，或者在三个月内依法向", fontChineseNormalsimfang12));
//                phrase3.add(ChunkFactoryOld
//                        .underLine(book.getValue(12), 84, fontChineseNormalsimfang12));
//                phrase3.add(new Chunk("人民法院提起行政诉讼，但本决定不停止执行，法律另有规定的除外。",
//                        fontChineseNormalsimfang12));
//                paragraph2.add(phrase3);
//
//                document.add(paragraph2);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
////                document.add(space1);
////                document.add(space1);
//
//                final Paragraph paragraph3 = new Paragraph();
//                paragraph3.setFirstLineIndent(264f);
//                paragraph3.setLeading(24f);
//                paragraph3.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase4 = new Phrase();
//                phrase4.add(new Chunk("安全生产监督管理部门（公章）", fontChineseNormalsimfang12));
//                toMeasurefloat(phrase4);
//
//                paragraph3.add(phrase4);
//                document.add(paragraph3);
//
//                final Paragraph paragraph4 = new Paragraph();
//                paragraph4.setFirstLineIndent(264f);
//                paragraph4.setLeading(24f);
//                paragraph4.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase5 = new Phrase();
//                phrase5.add(ChunkFactoryOld.tablenounderLine(StringFactoryBuild.build().getTime(book.getValue(13), 0), 36,
//                        fontChineseNormalsimfang12));
//                phrase5.add(new Chunk("年", fontChineseNormalsimfang12));
//                phrase5.add(ChunkFactoryOld.tablenounderLine(StringFactoryBuild.build().getTime(book.getValue(13), 1), 12,
//                        fontChineseNormalsimfang12));
//                phrase5.add(new Chunk("月", fontChineseNormalsimfang12));
//                phrase5.add(ChunkFactoryOld.tablenounderLine(StringFactoryBuild.build().getTime(book.getValue(13), 2), 12,
//                        fontChineseNormalsimfang12));
//                phrase5.add(new Chunk("日", fontChineseNormalsimfang12));
//                toMeasurefloat(phrase5);
//
//                paragraph4.add(phrase5);
//                document.add(paragraph4);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//
//                final Paragraph bottomLine1 = new Paragraph(
//                        new Chunk(new LineSeparator()));// 加入一个换行
//                bottomLine1.setLeading(1f);
//                bottomLine1.setSpacingBefore(10f);
//
//                document.add(bottomLine1);
//
//                final Paragraph paragraph9 = new Paragraph();
//                Phrase phrase14 = new Phrase();
//                phrase14.add(new Chunk("本文书一式两份：一份由安全生产监督管理部门备案，一份交被取证单位。",
//                        fontChineseNormalsimfang12));
//                paragraph9.add(phrase14);
//
//                document.add(paragraph9);
//
//                PdfContentByte canvas2 = dpfwPdfWriter.getDirectContent();
//                // 电子签章
//                Image img = ImageBuilder.getInstance(image);
//                if (img != null) {
//                    img.setAbsolutePosition(350, 140);
//                    canvas2.addImage(img);
//                }
//
//                document.newPage();// 结束保存
//            }
//        });
//
//    }
//
//    //现场检查记录
//    public void printerEntity_Book9(final Base_Entity book, final Object image) {
//        printFrameWork(book, image, new IPdfBackFrame() {
//            @Override
//            public void writeContent() throws Exception {
//                //此处写页面布局
//                document.add(space1);
//
//                final Paragraph title = new Paragraph("" + city + "安全生产行政执法文书", fontChineseBoldsimhei15);// Paragraph就是段落
//                title.setLeading(1f);// 段落距离
//                // title.setSpacingBefore(25f);//段落留白
//                title.setAlignment(Element.ALIGN_CENTER);// 居中
//                document.add(title);// 写入文档
//                final Paragraph titleLine1 = new Paragraph(new Chunk(new LineSeparator()));// 加入一个换行
//                titleLine1.setLeading(1f);
//                titleLine1.setSpacingBefore(5f);
//                document.add(titleLine1);
//                final Paragraph titleLine2 = new Paragraph(new Chunk(new LineSeparator()));
//                titleLine2.setLeading(1f);
//                titleLine2.setSpacingBefore(1f);
//                document.add(titleLine2);
//                final Paragraph title2 = new Paragraph("现场检查记录", fontChineseBoldsimhei15);
//
//                title2.setLeading(1f);
//                title2.setSpacingBefore(17f);
//                title2.setAlignment(Element.ALIGN_CENTER);
//
//                document.add(title2);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//
//                final Paragraph paragraph1 = new Paragraph();
//                paragraph1.setIndentationLeft(24f);
//                paragraph1.setLeading(24f);
//                paragraph1.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase1 = new Phrase();
//                phrase1.add(new Chunk("被检查单位：", fontChineseNormalsimfang12));
//                phrase1.add(ChunkFactoryOld.underLine(book.getValue(3), 324,
//                        fontChineseNormalsimfang12));
//
//                Phrase phrase2 = new Phrase();
//                phrase2.add(new Chunk("地  址：", fontChineseNormalsimfang12));
//                phrase2.add(ChunkFactoryOld.underLine(book.getValue(4), 348,
//                        fontChineseNormalsimfang12));
//
//                Phrase phrase3 = new Phrase();
//                phrase3.add(new Chunk("法定代表人（负责人）：", fontChineseNormalsimfang12));
//                phrase3.add(ChunkFactoryOld
//                        .underLine(book.getValue(5), 48, fontChineseNormalsimfang12));
//                phrase3.add(new Chunk("职务：", fontChineseNormalsimfang12));
//                phrase3.add(ChunkFactoryOld
//                        .underLine(book.getValue(6), 42, fontChineseNormalsimfang12));
//                phrase3.add(new Chunk("联系电话：", fontChineseNormalsimfang12));
//                phrase3.add(ChunkFactoryOld
//                        .underLine(book.getValue(7), 56, fontChineseNormalsimfang12));
//
//                Phrase phrase4 = new Phrase();
//                phrase4.add(new Chunk("检查场所：", fontChineseNormalsimfang12));
//                phrase4.add(ChunkFactoryOld.underLine(book.getValue(8), 336,
//                        fontChineseNormalsimfang12));
//
//                Phrase phrase5 = new Phrase();
//                phrase5.add(new Chunk("检查时间：", fontChineseNormalsimfang12));
//                phrase5.add(ChunkFactoryOld
//                        .underLine(StringFactoryBuild.build().getTime(book.getValue(9), 0), 18, fontChineseNormalsimfang12));
//                phrase5.add(new Chunk("年", fontChineseNormalsimfang12));
//                phrase5.add(ChunkFactoryOld
//                        .underLine(StringFactoryBuild.build().getTime(book.getValue(9), 1), 18, fontChineseNormalsimfang12));
//                phrase5.add(new Chunk("月", fontChineseNormalsimfang12));
//                phrase5.add(ChunkFactoryOld
//                        .underLine(StringFactoryBuild.build().getTime(book.getValue(9), 2), 18, fontChineseNormalsimfang12));
//                phrase5.add(new Chunk("日", fontChineseNormalsimfang12));
//                phrase5.add(ChunkFactoryOld
//                        .underLine(StringFactoryBuild.build().getTime(book.getValue(9), 3), 18, fontChineseNormalsimfang12));
//                phrase5.add(new Chunk("时", fontChineseNormalsimfang12));
//                phrase5.add(ChunkFactoryOld
//                        .underLine(StringFactoryBuild.build().getTime(book.getValue(9), 4), 18, fontChineseNormalsimfang12));
//                phrase5.add(new Chunk("分至", fontChineseNormalsimfang12));
//                phrase5.add(ChunkFactoryOld
//                        .underLine(StringFactoryBuild.build().getTime(book.getValue(10), 2), 18, fontChineseNormalsimfang12));
//                phrase5.add(new Chunk("日", fontChineseNormalsimfang12));
//                phrase5.add(ChunkFactoryOld
//                        .underLine(StringFactoryBuild.build().getTime(book.getValue(10), 3), 18, fontChineseNormalsimfang12));
//                phrase5.add(new Chunk("时", fontChineseNormalsimfang12));
//                phrase5.add(ChunkFactoryOld
//                        .underLine(StringFactoryBuild.build().getTime(book.getValue(10), 4), 18, fontChineseNormalsimfang12));
//                phrase5.add(new Chunk("分", fontChineseNormalsimfang12));
//
//                paragraph1.add(phrase1);
//                paragraph1.add(phrase2);
//                paragraph1.add(phrase3);
//                paragraph1.add(phrase4);
//                paragraph1.add(phrase5);
//
//                document.add(paragraph1);
//
//                final Paragraph paragraph2 = new Paragraph();
//                paragraph2.setFirstLineIndent(24f);
//                paragraph2.setLeading(24f);
//                paragraph2.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase6 = new Phrase();
//                phrase6.add(new Chunk("我们是", fontChineseNormalsimfang12));
//                phrase6.add(ChunkFactoryOld
//                        .underLine(book.getValue(11), 60, fontChineseNormalsimfang12));
//                phrase6.add(new Chunk("安全生产监督管理局的执法人员", fontChineseNormalsimfang12));
//                phrase6.add(ChunkFactoryOld
//                        .underLine(book.getValue(12), 48, fontChineseNormalsimfang12));
//                phrase6.add(new Chunk("、", fontChineseNormalsimfang12));
//                phrase6.add(ChunkFactoryOld
//                        .underLine(book.getValue(13), 48, fontChineseNormalsimfang12));
//                phrase6.add(new Chunk("，证", fontChineseNormalsimfang12));
//
//                Phrase phrase7 = new Phrase();
//                phrase7.add(new Chunk("件号码为", fontChineseNormalsimfang12));
//                phrase7.add(ChunkFactoryOld
//                        .underLine(book.getValue(14), 60, fontChineseNormalsimfang12));
//                phrase7.add(new Chunk("、", fontChineseNormalsimfang12));
//                phrase7.add(ChunkFactoryOld
//                        .underLine(book.getValue(15), 60, fontChineseNormalsimfang12));
//                phrase7.add(new Chunk("，这是我们的证件（出示证件）。现依法对你单位进行现场检查，请予以配合。",
//                        fontChineseNormalsimfang12));
//
//                paragraph2.add(phrase6);
//                paragraph2.add(phrase7);
//
//                document.add(paragraph2);
//
//                final Paragraph paragraph3 = new Paragraph();
//                paragraph3.setFirstLineIndent(24f);
//                paragraph3.setLeading(24f);
//                paragraph3.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase8 = new Phrase();
//                phrase8.add(new Chunk("检查情况：", fontChineseNormalsimfang12));
//                phrase8.add(ChunkFactoryOld.underLine(book.getValue(16), 5514,
//                        fontChineseNormalsimfang12,"检查情况检查捡",430));
//
//                paragraph3.add(phrase8);
//                document.add(paragraph3);
//                document.add(space1);
//
//                final Paragraph paragraph4 = new Paragraph();
//                paragraph4.setIndentationLeft(24f);
//
//                Phrase phrase9 = new Phrase();
//                phrase9.add(new Chunk("检查人员（签名）：", fontChineseNormalsimfang12));
//                phrase9.add(ChunkFactoryOld
//                        .underLine(book.getValue(17), 84, fontChineseNormalsimfang12));
//                phrase9.add(new Chunk("、", fontChineseNormalsimfang12));
//                phrase9.add(ChunkFactoryOld
//                        .underLine(book.getValue(18), 84, fontChineseNormalsimfang12));
//                phrase9.add("\n");
//                phrase9.add(new Chunk("被检查单位现场负责人（签名）：", fontChineseNormalsimfang12));
//                phrase9.add(ChunkFactoryOld
//                        .underLine(book.getValue(19), 84, fontChineseNormalsimfang12));
//                phrase9.add("\n");
//                phrase9.add(ChunkFactoryOld.tablenounderLine("", 264,
//                        fontChineseNormalsimfang12));
//                phrase9.add(ChunkFactoryOld.tablenounderLine(StringFactoryBuild.build().getTime(book.getValue(20), 0), 36,
//                        fontChineseNormalsimfang12));
//                phrase9.add(new Chunk("年", fontChineseNormalsimfang12));
//                phrase9.add(ChunkFactoryOld.tablenounderLine(StringFactoryBuild.build().getTime(book.getValue(20), 1), 12,
//                        fontChineseNormalsimfang12));
//                phrase9.add(new Chunk("月", fontChineseNormalsimfang12));
//                phrase9.add(ChunkFactoryOld.tablenounderLine(StringFactoryBuild.build().getTime(book.getValue(20), 2), 12,
//                        fontChineseNormalsimfang12));
//                phrase9.add(new Chunk("日", fontChineseNormalsimfang12));
//
//                paragraph4.add(phrase9);
//                paragraph4.setLeading(26);
//                document.add(paragraph4);
//                document.add(space1);
//
//                final Paragraph bottomLine1 = new Paragraph(
//                        new Chunk(new LineSeparator()));// 加入一个换行
//                bottomLine1.setLeading(1f);
//                bottomLine1.setSpacingBefore(5f);
//
//                document.add(bottomLine1);
//
//                final Paragraph paragraph5 = new Paragraph();
//                Phrase phrase17 = new Phrase();
//
//                phrase17.add(ChunkFactoryOld.tablenounderLine("", 288,
//                        fontChineseNormalsimfang12));
//                // phrase17.add(new Chunk("共",fontChineseKNormal));
//                // phrase17.add(Help_Pdf_Help.tablenounderLine("", 36,
//                // fontChineseKNormal));
//                // phrase17.add(new Chunk("页",fontChineseKNormal));
//                // phrase17.add(Help_Pdf_Help.tablenounderLine("", 36,
//                // fontChineseKNormal));
//                // phrase17.add(new Chunk("第",fontChineseKNormal));
//                // phrase17.add(Help_Pdf_Help.tablenounderLine("", 36,
//                // fontChineseKNormal));
//                // phrase17.add(new Chunk("页",fontChineseKNormal));
//                paragraph5.add(phrase17);
//
//                document.add(paragraph5);
//                PdfContentByte canvas = dpfwPdfWriter.getDirectContent();
//
//                Phrase phrase18 = new Phrase();
////                phrase18.add(new Chunk("检查情况：", fontChineseNormalsimfang12));
////                ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phrase18,
////                        104, 474, 0);
//                PdfContentByte canvas2 = dpfwPdfWriter.getDirectContent();
//                // 电子签章
//                Image img = ImageBuilder.getInstance(image);
//                if (img != null) {
//                    img.setAbsolutePosition(350, 140);
//                    canvas2.addImage(img);
//                }
//                document.newPage();// 结束保存
//            }
//        });
//
//    }
//
//    //现场处理措施决定书
//    public void printerEntity_Book10(final Base_Entity book, final Object image) {
//        printFrameWork(book, image, new IPdfBackFrame() {
//            @Override
//            public void writeContent() throws Exception {
//                //此处写页面布局
//                document.add(space1);
//
//                final Paragraph title = new Paragraph("" + city + "安全生产行政执法文书", fontChineseBoldsimhei15);// Paragraph就是段落
//                title.setLeading(1f);// 段落距离
//                // title.setSpacingBefore(25f);//段落留白
//                title.setAlignment(Element.ALIGN_CENTER);// 居中
//                document.add(title);// 写入文档
//                final Paragraph titleLine1 = new Paragraph(new Chunk(new LineSeparator()));// 加入一个换行
//                titleLine1.setLeading(1f);
//                titleLine1.setSpacingBefore(5f);
//                document.add(titleLine1);
//                final Paragraph titleLine2 = new Paragraph(new Chunk(new LineSeparator()));
//                titleLine2.setLeading(1f);
//                titleLine2.setSpacingBefore(1f);
//                document.add(titleLine2);
//                final Paragraph title2 = new Paragraph("现场处理措施决定书", fontChineseBoldsimhei15);
//
//                title2.setLeading(1f);
//                title2.setSpacingBefore(17f);
//                title2.setAlignment(Element.ALIGN_CENTER);
//                document.add(title2);
//
//                final Paragraph title3 = new Paragraph("( " + book.getValue(0) + " )安监管现决〔" + book.getValue(1) + "〕"
//                        + book.getValue(2) + "号", fontChineseNormalsimfang12);
//                title3.setLeading(1f);
//                title3.setSpacingBefore(25f);
//                title3.setAlignment(Element.ALIGN_CENTER);
//                document.add(title3);
//
//                document.add(space1);
//
//                final Paragraph entParagraph = new Paragraph();
//                entParagraph.setLeading(24f);
//                entParagraph.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase1 = new Phrase();
//                phrase1.add((ChunkFactoryOld.underLine(book.getValue(3), 216,
//                        fontChineseNormalsimfang12)));
//                phrase1.add(new Chunk(":", fontChineseNormalsimfang12));
//                toMeasurefloat(phrase1);
//
//                entParagraph.add(phrase1);
//
//                document.add(entParagraph);
//
//                final Paragraph paragraph1 = new Paragraph();
//                paragraph1.setFirstLineIndent(24f);
//                paragraph1.setLeading(24f);
//                paragraph1.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase2 = new Phrase();
//                phrase2.add(new Chunk("我局于", fontChineseNormalsimfang12));
//                phrase2.add(ChunkFactoryOld
//                        .underLine(StringFactoryBuild.build().getTime(book.getValue(4), 0), 24, fontChineseNormalsimfang12));
//                phrase2.add(new Chunk("年", fontChineseNormalsimfang12));
//                phrase2.add(ChunkFactoryOld
//                        .underLine(StringFactoryBuild.build().getTime(book.getValue(4), 1), 12, fontChineseNormalsimfang12));
//                phrase2.add(new Chunk("月", fontChineseNormalsimfang12));
//                phrase2.add(ChunkFactoryOld
//                        .underLine(StringFactoryBuild.build().getTime(book.getValue(4), 2), 12, fontChineseNormalsimfang12));
//                phrase2.add(new Chunk("日现场检查时，发现你单位有下列违法违规行为和事故隐患：",
//                        fontChineseNormalsimfang12));
//
//                toMeasurefloat(phrase2);
//
//                paragraph1.add(phrase2);
//
//                document.add(paragraph1);
//
//                final Paragraph paragraph2 = new Paragraph();
//                paragraph2.setIndentationLeft(24f);
//                paragraph2.setLeading(24f);
//                paragraph2.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase3 = new Phrase();
//                phrase3.add(ChunkFactoryOld.underLine("1." + book.getValue(5), 394,
//                        fontChineseNormalsimfang12));
//                phrase3.add(ChunkFactoryOld
//                        .underLine("；", 0, fontChineseNormalsimfang12));
//                phrase3.add(ChunkFactoryOld.underLine("2." + book.getValue(6), 394,
//                        fontChineseNormalsimfang12));
//                phrase3.add(ChunkFactoryOld
//                        .underLine("；", 1, fontChineseNormalsimfang12));
//                phrase3.add(ChunkFactoryOld.underLine("3." + book.getValue(7), 262,
//                        fontChineseNormalsimfang12));
//                phrase3.add(ChunkFactoryOld
//                        .underLine("。", 1, fontChineseNormalsimfang12));
//                phrase3.add(new Chunk("（此栏不够，可另附页）", fontChineseNormalsimfang12));
//                phrase3.add(Chunk.NEWLINE);
//                toMeasurefloat(phrase3);
//
//                paragraph2.add(phrase3);
//
//                document.add(paragraph2);
//
//                final Paragraph paragraph3 = new Paragraph();
//                paragraph3.setFirstLineIndent(24f);
//                paragraph3.setLeading(24f);
//                paragraph3.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase4 = new Phrase();
//                 phrase4.add(new Chunk("以上存在的问题无法保证安全生产，依据", fontChineseNormalsimfang12));
//                phrase4.add(ChunkFactoryOld.underLine(book.getValue(8), 464,
//                        fontChineseNormalsimfang12,248,430));
//                phrase4.add(new Chunk(
//                        "                                                ",
//                        fontChineseNormalsimfang12));
//
//                toMeasurefloat(phrase4);
//                paragraph3.add(phrase4);
//
//                document.add(paragraph3);
//
//                final Paragraph paragraph4 = new Paragraph();
//                paragraph4.setIndentationLeft(24f);
//                paragraph4.setLeading(24f);
//                paragraph4.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase5 = new Phrase();
//                phrase5.add(ChunkFactoryOld.underLine("1." + book.getValue(9), 394,
//                        fontChineseNormalsimfang12));
//                phrase5.add(ChunkFactoryOld
//                        .underLine("；", 0, fontChineseNormalsimfang12));
//                phrase5.add(ChunkFactoryOld.underLine("2." + book.getValue(10), 394,
//                        fontChineseNormalsimfang12));
//                phrase5.add(ChunkFactoryOld
//                        .underLine("；", 1, fontChineseNormalsimfang12));
//                phrase5.add(ChunkFactoryOld.underLine("3." + book.getValue(11), 262,
//                        fontChineseNormalsimfang12));
//                phrase5.add(ChunkFactoryOld
//                        .underLine("。", 1, fontChineseNormalsimfang12));
//                phrase5.add(new Chunk("（此栏不够，可另附页）", fontChineseNormalsimfang12));
//                phrase5.add(Chunk.NEWLINE);
//                toMeasurefloat(phrase5);
//
//                paragraph4.add(phrase5);
//                document.add(paragraph4);
//
//                final Paragraph paragraph5 = new Paragraph();
//                paragraph5.setFirstLineIndent(24f);
//                paragraph5.setLeading(24f);
//                paragraph5.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase6 = new Phrase();
//                phrase6.add(new Chunk("如果不服本决定，可以依法在60日内向", fontChineseNormalsimfang12));
//                phrase6.add(ChunkFactoryOld.underLine(book.getValue(12), 126,
//                        fontChineseNormalsimfang12));
//                phrase6.add(new Chunk("人民政府或者", fontChineseNormalsimfang12));
//                phrase6.add(ChunkFactoryOld.underLine(book.getValue(13), 126,
//                        fontChineseNormalsimfang12));
//                phrase6.add(new Chunk("申请行政复议，或者在三个月内依法向", fontChineseNormalsimfang12));
//                phrase6.add(ChunkFactoryOld.underLine(book.getValue(14), 64,
//                        fontChineseNormalsimfang12));
//                phrase6.add(new Chunk("人民法院提起行政诉讼，但本决定不停止执行，法律另有规定的除外。",
//                        fontChineseNormalsimfang12));
//
//                toMeasurefloat(phrase6);
//                paragraph5.add(phrase6);
//
//                document.add(paragraph5);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                final Paragraph paragraph6 = new Paragraph();
//                paragraph6.setIndentationLeft(24f);
//                paragraph6.setLeading(24f);
//                paragraph6.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase7 = new Phrase();
//                phrase7.add(new Chunk("安全生产监管执法人员（签名）：", fontChineseNormalsimfang12));
//                phrase7.add(ChunkFactoryOld
//                        .underLine(book.getValue(15), 84, fontChineseNormalsimfang12));
//                phrase7.add(new Chunk("证号：", fontChineseNormalsimfang12));
//                phrase7.add(ChunkFactoryOld
//                        .underLine(book.getValue(16), 84, fontChineseNormalsimfang12));
//                phrase7.add("\n");
//                phrase7.add(ChunkFactoryOld.tablenounderLine("", 168,
//                        fontChineseNormalsimfang12));
//                phrase7.add(ChunkFactoryOld
//                        .underLine(book.getValue(17), 84, fontChineseNormalsimfang12));
//                phrase7.add(new Chunk("证号：", fontChineseNormalsimfang12));
//                phrase7.add(ChunkFactoryOld
//                        .underLine(book.getValue(18), 84, fontChineseNormalsimfang12));
//                phrase7.add("\n");
//                phrase7.add(new Chunk("被检查单位负责人（签名）：", fontChineseNormalsimfang12));
//                phrase7.add(ChunkFactoryOld
//                        .underLine(book.getValue(19), 84, fontChineseNormalsimfang12));
//                paragraph6.add(phrase7);
//
//                document.add(paragraph6);
//                document.add(space1);
//                document.add(space1);
//
//                final Paragraph paragraph7 = new Paragraph();
//                paragraph7.setFirstLineIndent(264f);
//                paragraph7.setLeading(24f);
//                paragraph7.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase8 = new Phrase();
//                phrase8.add(new Chunk("安全生产监督管理部门（公章）", fontChineseNormalsimfang12));
//                toMeasurefloat(phrase8);
//
//                paragraph7.add(phrase8);
//                document.add(paragraph7);
//
//                final Paragraph paragraph8 = new Paragraph();
//                paragraph8.setFirstLineIndent(264f);
//                paragraph8.setLeading(24f);
//                paragraph8.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase9 = new Phrase();
//                phrase9.add(ChunkFactoryOld.tablenounderLine(StringFactoryBuild.build().getTime(book.getValue(20), 0), 36,
//                        fontChineseNormalsimfang12));
//                phrase9.add(new Chunk("年", fontChineseNormalsimfang12));
//                phrase9.add(ChunkFactoryOld.tablenounderLine(StringFactoryBuild.build().getTime(book.getValue(20), 1), 12,
//                        fontChineseNormalsimfang12));
//                phrase9.add(new Chunk("月", fontChineseNormalsimfang12));
//                phrase9.add(ChunkFactoryOld.tablenounderLine(StringFactoryBuild.build().getTime(book.getValue(20), 2), 12,
//                        fontChineseNormalsimfang12));
//                phrase9.add(new Chunk("日", fontChineseNormalsimfang12));
//                toMeasurefloat(phrase9);
//
//                paragraph8.add(phrase9);
//                document.add(paragraph8);
//
//                final Paragraph bottomLine1 = new Paragraph(
//                        new Chunk(new LineSeparator()));// 加入一个换行
//                bottomLine1.setLeading(1f);
//                bottomLine1.setSpacingBefore(5f);
//
//                document.add(bottomLine1);
//
//                final Paragraph paragraph9 = new Paragraph();
//                Phrase phrase10 = new Phrase();
//                phrase10.add(new Chunk("本文书一式两份：一份由安全生产监督管理部门备案，一份交被检查单位。",
//                        fontChineseNormalsimfang12));
//                phrase10.add(ChunkFactoryOld.tablenounderLine("", 2,
//                        fontChineseNormalsimfang12));
//
//                paragraph9.add(phrase10);
//
//                document.add(paragraph9);
//                PdfContentByte canvas = dpfwPdfWriter.getDirectContent();
//
//                Phrase phrase18 = new Phrase();
////                phrase18.add(new Chunk("以上存在的问题无法保证安全生产，依据", fontChineseNormalsimfang12));
////                ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phrase18,
////                        104, 514, 0);
//
//                Phrase phrase19 = new Phrase();
//                phrase19.add(new Chunk("的规定，现做出如下现场", fontChineseNormalsimfang12));
//                ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phrase19,
//                        372, 491, 0);
//
//                Phrase phrase20 = new Phrase();
//                phrase20.add(new Chunk("处理决定：", fontChineseNormalsimfang12));
//                ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phrase20,
//                        80, 465, 0);
//                PdfContentByte canvas2 = dpfwPdfWriter.getDirectContent();
//                // 电子签章
//                Image img = ImageBuilder.getInstance(image);
//                if (img != null) {
//                    img.setAbsolutePosition(350, 140);
//                    canvas2.addImage(img);
//                }
//                document.newPage();// 结束保存
//            }
//        });
//
//    }
//
//    //责令限期整改指令书
//    public void printerEntity_Book11(final Base_Entity book, final Object image) {
//        printFrameWork(book, image, new IPdfBackFrame() {
//            @Override
//            public void writeContent() throws Exception {
//                //此处写页面布局
//                document.add(space1);
//
//                final Paragraph title = new Paragraph("" + city + "安全生产行政执法文书", fontChineseBoldsimhei15);// Paragraph就是段落
//                title.setLeading(1f);// 段落距离
//                // title.setSpacingBefore(25f);//段落留白
//                title.setAlignment(Element.ALIGN_CENTER);// 居中
//                document.add(title);// 写入文档
//                final Paragraph titleLine1 = new Paragraph(new Chunk(new LineSeparator()));// 加入一个换行
//                titleLine1.setLeading(1f);
//                titleLine1.setSpacingBefore(5f);
//                document.add(titleLine1);
//                final Paragraph titleLine2 = new Paragraph(new Chunk(new LineSeparator()));
//                titleLine2.setLeading(1f);
//                titleLine2.setSpacingBefore(1f);
//                document.add(titleLine2);
//                final Paragraph title2 = new Paragraph("责令限期整改指令书", fontChineseBoldsimhei15);
//
//                title2.setLeading(1f);
//                title2.setSpacingBefore(17f);
//                title2.setAlignment(Element.ALIGN_CENTER);
//                document.add(title2);
//
//                final Paragraph title3 = new Paragraph("( " + book.getValue(0) + " )安监管责改〔" + book.getValue(1) + "〕"
//                        + book.getValue(2) + "号", fontChineseNormalsimfang12);
//                title3.setLeading(1f);
//                title3.setSpacingBefore(34f);
//                title3.setAlignment(Element.ALIGN_CENTER);
//                document.add(title3);
//
//                document.add(space1);
//
//                final Paragraph entParagraph = new Paragraph();
//                entParagraph.setLeading(24f);
//                entParagraph.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase1 = new Phrase();
//                phrase1.add((ChunkFactoryOld.underLine(book.getValue(3), 216,
//                        fontChineseNormalsimfang12)));
//                phrase1.add(new Chunk(":", fontChineseNormalsimfang12));
//                toMeasurefloat(phrase1);
//
//                entParagraph.add(phrase1);
//
//                document.add(entParagraph);
//
//                final Paragraph paragraph1 = new Paragraph();
//                paragraph1.setFirstLineIndent(24f);
//                paragraph1.setLeading(24f);
//                paragraph1.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase2 = new Phrase();
//                phrase2.add(new Chunk("经查，你单位存在下列问题：", fontChineseNormalsimfang12));
//                toMeasurefloat(phrase2);
//
//                paragraph1.add(phrase2);
//                document.add(paragraph1);
//
//                final Paragraph paragraph2 = new Paragraph();
//                paragraph2.setFirstLineIndent(24f);
//                paragraph2.setLeading(24f);
//                paragraph2.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase3 = new Phrase();
//                phrase3.add(ChunkFactoryOld.underLine("1." + book.getValue(4), 820,
//                        fontChineseNormalsimfang12,30,430));
//                toMeasurefloat(phrase3);
//
//                paragraph2.add(phrase3);
//                document.add(paragraph2);
//
//                final Paragraph paragraph3 = new Paragraph();
//                paragraph3.setFirstLineIndent(24f);
//                paragraph3.setLeading(24f);
//                paragraph3.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase4 = new Phrase();
//                phrase4.add(ChunkFactoryOld.underLine("2." + book.getValue(5), 820,
//                        fontChineseNormalsimfang12,30,430));
//                toMeasurefloat(phrase4);
//
//                paragraph3.add(phrase4);
//                document.add(paragraph3);
//
//                final Paragraph paragraph4 = new Paragraph();
//                paragraph4.setFirstLineIndent(24f);
//                paragraph4.setLeading(24f);
//                paragraph4.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase5 = new Phrase();
//                phrase5.add(ChunkFactoryOld.underLine("3." + book.getValue(6), 820,
//                        fontChineseNormalsimfang12,30,430));
//                toMeasurefloat(phrase5);
//
//                paragraph4.add(phrase5);
//                document.add(paragraph4);
//
//                final Paragraph paragraph5 = new Paragraph();
//                paragraph5.setFirstLineIndent(24f);
//                paragraph5.setLeading(24f);
//                paragraph5.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase6 = new Phrase();
//                phrase6.add(ChunkFactoryOld.underLine("4." + book.getValue(7), 682,
//                        fontChineseNormalsimfang12,30,430));
//                phrase6.add(new Chunk("（此栏不够，可另附页）。", fontChineseNormalsimfang12));
//                toMeasurefloat(phrase6);
//
//                paragraph5.add(phrase6);
//                document.add(paragraph5);
//
//                final Paragraph paragraph6 = new Paragraph();
//                paragraph6.setFirstLineIndent(24f);
//                paragraph6.setLeading(24f);
//                paragraph6.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase7 = new Phrase();
//                phrase7.add(new Chunk("现责令你单位对上述第", fontChineseNormalsimfang12));
//                phrase7.add(ChunkFactoryOld
//                        .underLine(book.getValue(8), 60, fontChineseNormalsimfang12));
//                phrase7.add(new Chunk("项问题于", fontChineseNormalsimfang12));
//                phrase7.add(ChunkFactoryOld
//                        .underLine(StringFactoryBuild.build().getTime(book.getValue(9), 0), 24, fontChineseNormalsimfang12));
//                phrase7.add(new Chunk("年", fontChineseNormalsimfang12));
//                phrase7.add(ChunkFactoryOld
//                        .underLine(StringFactoryBuild.build().getTime(book.getValue(9), 1), 12, fontChineseNormalsimfang12));
//                phrase7.add(new Chunk("月", fontChineseNormalsimfang12));
//                phrase7.add(ChunkFactoryOld
//                        .underLine(StringFactoryBuild.build().getTime(book.getValue(9), 2), 12, fontChineseNormalsimfang12));
//                phrase7.add(new Chunk(
//                        "日前整改完毕，达到有关法律法规规章和标准规定的要求。逾期不整改或达不到要求的，依法给予行政处罚；由此造成事故的，依法追究有关人员的责任。",
//                        fontChineseNormalsimfang12));
//                toMeasurefloat(phrase7);
//                paragraph6.add(phrase7);
//
//                document.add(paragraph6);
//
//                final Paragraph paragraph7 = new Paragraph();
//                paragraph7.setFirstLineIndent(24f);
//                paragraph7.setLeading(24f);
//                paragraph7.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase8 = new Phrase();
//                phrase8.add(new Chunk("如果不服本决定，可以依法在60日内向", fontChineseNormalsimfang12));
//                phrase8.add(ChunkFactoryOld.underLine(book.getValue(10), 102,
//                        fontChineseNormalsimfang12));
//                phrase8.add(new Chunk("人民政府或者", fontChineseNormalsimfang12));
//                phrase8.add(ChunkFactoryOld.underLine(book.getValue(11), 108,
//                        fontChineseNormalsimfang12));
//                phrase8.add(new Chunk("申请行政复议，或者在三个月内依法向", fontChineseNormalsimfang12));
//                phrase8.add(ChunkFactoryOld.underLine(book.getValue(12), 84,
//                        fontChineseNormalsimfang12));
//                phrase8.add(new Chunk("人民法院提起行政诉讼，但本指令不停止执行，法律另有规定的除外。",
//                        fontChineseNormalsimfang12));
//
//                toMeasurefloat(phrase8);
//                paragraph7.add(phrase8);
//
//                document.add(paragraph7);
//                document.add(space1);
//                document.add(space1);
//
//                final Paragraph paragraph8 = new Paragraph();
//                paragraph8.setIndentationLeft(24f);
//                paragraph8.setLeading(24f);
//                paragraph8.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase9 = new Phrase();
//                phrase9.add(new Chunk("安全生产监管执法人员（签名）：", fontChineseNormalsimfang12));
//                phrase9.add(ChunkFactoryOld
//                        .underLine(book.getValue(13), 84, fontChineseNormalsimfang12));
//                phrase9.add(new Chunk("证号：", fontChineseNormalsimfang12));
//                phrase9.add(ChunkFactoryOld
//                        .underLine(book.getValue(14), 84, fontChineseNormalsimfang12));
//                phrase9.add("\n");
//                phrase9.add(ChunkFactoryOld.tablenounderLine("", 168,
//                        fontChineseNormalsimfang12));
//                phrase9.add(ChunkFactoryOld
//                        .underLine(book.getValue(15), 84, fontChineseNormalsimfang12));
//                phrase9.add(new Chunk("证号：", fontChineseNormalsimfang12));
//                phrase9.add(ChunkFactoryOld
//                        .underLine(book.getValue(16), 84, fontChineseNormalsimfang12));
//                phrase9.add("\n");
//                phrase9.add(new Chunk("被检查单位负责人（签名）：", fontChineseNormalsimfang12));
//                phrase9.add(ChunkFactoryOld.underLine(book.getValue(17), 102,
//                        fontChineseNormalsimfang12));
//                paragraph8.add(phrase9);
//
//                document.add(paragraph8);
//                document.add(space1);
//                document.add(space1);
//                final Paragraph paragraph9 = new Paragraph();
//                paragraph9.setFirstLineIndent(264f);
//                paragraph9.setLeading(24f);
//                paragraph9.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase10 = new Phrase();
//                phrase10.add(new Chunk("安全生产监督管理部门（公章）", fontChineseNormalsimfang12));
//                toMeasurefloat(phrase10);
//
//                paragraph9.add(phrase10);
//                document.add(paragraph9);
//                document.add(space1);
//
//                final Paragraph paragraph10 = new Paragraph();
//                paragraph10.setFirstLineIndent(264f);
//                paragraph10.setLeading(24f);
//                paragraph10.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase11 = new Phrase();
//                phrase11.add(ChunkFactoryOld.tablenounderLine(StringFactoryBuild.build().getTime(book.getValue(18), 0), 36,
//                        fontChineseNormalsimfang12));
//                phrase11.add(new Chunk("年", fontChineseNormalsimfang12));
//                phrase11.add(ChunkFactoryOld.tablenounderLine(StringFactoryBuild.build().getTime(book.getValue(18), 1), 12,
//                        fontChineseNormalsimfang12));
//                phrase11.add(new Chunk("月", fontChineseNormalsimfang12));
//                phrase11.add(ChunkFactoryOld.tablenounderLine(StringFactoryBuild.build().getTime(book.getValue(18), 2), 12,
//                        fontChineseNormalsimfang12));
//                phrase11.add(new Chunk("日", fontChineseNormalsimfang12));
//                toMeasurefloat(phrase11);
//
//                paragraph10.add(phrase11);
//                document.add(paragraph10);
//
//                final Paragraph bottomLine1 = new Paragraph(
//                        new Chunk(new LineSeparator()));// 加入一个换行
//                bottomLine1.setLeading(1f);
//                bottomLine1.setSpacingBefore(5f);
//
//                document.add(bottomLine1);
//
//                final Paragraph paragraph11 = new Paragraph();
//                Phrase phrase12 = new Phrase();
//                phrase12.add(new Chunk("本文书一式两份：一份由安全生产监督管理部门备案，一份交被检查单位。",
//                        fontChineseNormalsimfang12));
//
//                paragraph11.add(phrase12);
//
//                document.add(paragraph11);
//
//                PdfContentByte canvas2 = dpfwPdfWriter.getDirectContent();
//                // 电子签章
//                Image img = ImageBuilder.getInstance(image);
//                if (img != null) {
//                    img.setAbsolutePosition(350, 140);
//                    canvas2.addImage(img);
//                }
//                document.newPage();// 结束保存
//
//                if (!book.getValue("续页").equals("")) {
//                    printerContinue(book, image, new IPdfBack() {
//                        @Override
//                        public void writeError() {
//
//                        }
//
//                        @Override
//                        public void writeStart() {
//
//                        }
//
//                        @Override
//                        public void writeEnd() {
//                            try {
//
//
//                                document.add(paragraph8);
//                                document.add(space1);
//                                document.add(space1);
//                                document.add(paragraph9);
//                                document.add(space1);
//                                document.add(paragraph10);
//                            } catch (DocumentException e) {
//                                e.printStackTrace();
//                            }
//                        }
//                    }, 23000);
//                }
//            }
//        });
//
//    }
//
//    //整改复查意见书
//    public void printerEntity_Book12(final Base_Entity book, final Object image) {
//        printFrameWork(book, image, new IPdfBackFrame() {
//            @Override
//            public void writeContent() throws Exception {
//                //此处写页面布局
//                document.add(space1);
//
//                final Paragraph title = new Paragraph("" + city + "安全生产行政执法文书", fontChineseBoldsimhei15);// Paragraph就是段落
//                title.setLeading(1f);// 段落距离
//                // title.setSpacingBefore(25f);//段落留白
//                title.setAlignment(Element.ALIGN_CENTER);// 居中
//                document.add(title);// 写入文档
//                final Paragraph titleLine1 = new Paragraph(new Chunk(new LineSeparator()));// 加入一个换行
//                titleLine1.setLeading(1f);
//                titleLine1.setSpacingBefore(5f);
//                document.add(titleLine1);
//                final Paragraph titleLine2 = new Paragraph(new Chunk(new LineSeparator()));
//                titleLine2.setLeading(1f);
//                titleLine2.setSpacingBefore(1f);
//                document.add(titleLine2);
//                final Paragraph title2 = new Paragraph("整改复查意见书", fontChineseBoldsimhei15);
//
//                title2.setLeading(1f);
//                title2.setSpacingBefore(17f);
//                title2.setAlignment(Element.ALIGN_CENTER);
//                document.add(title2);
//
//                final Paragraph title3 = new Paragraph("( " + book.getValue(0) + " )安监管复查〔" + book.getValue(1) + "〕"
//                        + book.getValue(2) + "号", fontChineseNormalsimfang12);
//                title3.setLeading(1f);
//                title3.setSpacingBefore(34f);
//                title3.setAlignment(Element.ALIGN_CENTER);
//                document.add(title3);
//
//                document.add(space2);
//
//                final Paragraph entParagraph = new Paragraph();
//                entParagraph.setLeading(24f);
//                entParagraph.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase1 = new Phrase();
//                phrase1.add((ChunkFactoryOld.underLine(book.getValue(3), 216,
//                        fontChineseNormalsimfang12)));
//                phrase1.add(new Chunk(":", fontChineseNormalsimfang12));
//                toMeasurefloat(phrase1);
//
//                entParagraph.add(phrase1);
//
//                document.add(entParagraph);
//
//                final Paragraph paragraph1 = new Paragraph();
//                paragraph1.setFirstLineIndent(24f);
//                paragraph1.setLeading(24f);
//                paragraph1.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase2 = new Phrase();
//                phrase2.add(new Chunk("本机关于", fontChineseNormalsimfang12));
//                phrase2.add(ChunkFactoryOld
//                        .underLine(StringFactoryBuild.build().getTime(book.getValue(4), 0), 18, fontChineseNormalsimfang12));
//                phrase2.add(new Chunk("年", fontChineseNormalsimfang12));
//                phrase2.add(ChunkFactoryOld
//                        .underLine(StringFactoryBuild.build().getTime(book.getValue(4), 1), 18, fontChineseNormalsimfang12));
//                phrase2.add(new Chunk("月", fontChineseNormalsimfang12));
//                phrase2.add(ChunkFactoryOld
//                        .underLine(StringFactoryBuild.build().getTime(book.getValue(4), 2), 18, fontChineseNormalsimfang12));
//                phrase2.add(new Chunk("日作出了", fontChineseNormalsimfang12));
//                phrase2.add(ChunkFactoryOld.underLine(book.getValue(5), 184,
//                        fontChineseNormalsimfang12));
//                phrase2.add(new Chunk("的决定", fontChineseNormalsimfang12));
//
//                phrase2.add(new Chunk("[(", fontChineseNormalsimfang12));
//                phrase2.add(ChunkFactoryOld.tablenounderLine(book.getValue(6), 36,
//                        fontChineseNormalsimfang12));
//                phrase2.add(new Chunk(")安监管", fontChineseNormalsimfang12));
//                phrase2.add(ChunkFactoryOld
//                        .underLine(book.getValue(7), 36, fontChineseNormalsimfang12));
//                phrase2.add(new Chunk("〔", fontChineseNormalsimfang12));
//                phrase2.add(ChunkFactoryOld.tablenounderLine(book.getValue(8), 36,
//                        fontChineseNormalsimfang12));
//                phrase2.add(new Chunk("〕", fontChineseNormalsimfang12));
//                phrase2.add(ChunkFactoryOld.tablenounderLine(book.getValue(9), 36,
//                        fontChineseNormalsimfang12));
//                phrase2.add(new Chunk("号]，经对你单位整改情况进行复查，提出如下意见：\n",
//                        fontChineseNormalsimfang12));
//                phrase2.add(ChunkFactoryOld.underLine(book.getValue(10), 3870,
//                        fontChineseNormalsimfang12,0,430));
//
//                paragraph1.add(phrase2);
//                document.add(paragraph1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//
//                final Paragraph paragraph8 = new Paragraph();
//                paragraph8.setIndentationLeft(24f);
//                paragraph8.setLeading(24f);
//                paragraph8.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase9 = new Phrase();
//
//                phrase9.add(new Chunk("被检查单位负责人（签名）：", fontChineseNormalsimfang12));
//                phrase9.add(ChunkFactoryOld
//                        .underLine(book.getValue(11), 84, fontChineseNormalsimfang12));
//                phrase9.add("\n");
//                phrase9.add(new Chunk("安全生产监管执法人员（签名）：", fontChineseNormalsimfang12));
//                phrase9.add(ChunkFactoryOld
//                        .underLine(book.getValue(12), 84, fontChineseNormalsimfang12));
//                phrase9.add(new Chunk("证号：", fontChineseNormalsimfang12));
//                phrase9.add(ChunkFactoryOld
//                        .underLine(book.getValue(13), 84, fontChineseNormalsimfang12));
//                phrase9.add("\n");
//                phrase9.add(ChunkFactoryOld.tablenounderLine("", 168,
//                        fontChineseNormalsimfang12));
//                phrase9.add(ChunkFactoryOld
//                        .underLine(book.getValue(14), 84, fontChineseNormalsimfang12));
//                phrase9.add(new Chunk("证号：", fontChineseNormalsimfang12));
//                phrase9.add(ChunkFactoryOld
//                        .underLine(book.getValue(15), 84, fontChineseNormalsimfang12));
//
//                paragraph8.add(phrase9);
//
//                document.add(paragraph8);
//                document.add(space1);
//                document.add(space1);
//                document.add(space2);
//                document.add(space1);
//                document.add(space2);
//                document.add(space1);
//                final Paragraph paragraph9 = new Paragraph();
//                paragraph9.setFirstLineIndent(264f);
//                paragraph9.setLeading(24f);
//                paragraph9.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase10 = new Phrase();
//                phrase10.add(new Chunk("安全生产监督管理部门（公章）", fontChineseNormalsimfang12));
//                toMeasurefloat(phrase10);
//
//                paragraph9.add(phrase10);
//                document.add(paragraph9);
//                document.add(space1);
//
//                final Paragraph paragraph10 = new Paragraph();
//                paragraph10.setFirstLineIndent(264f);
//                paragraph10.setLeading(24f);
//                paragraph10.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase11 = new Phrase();
//                phrase11.add(ChunkFactoryOld.tablenounderLine(StringFactoryBuild.build().getTime(book.getValue(16), 0), 36,
//                        fontChineseNormalsimfang12));
//                phrase11.add(new Chunk("年", fontChineseNormalsimfang12));
//                phrase11.add(ChunkFactoryOld.tablenounderLine(StringFactoryBuild.build().getTime(book.getValue(16), 1), 12,
//                        fontChineseNormalsimfang12));
//                phrase11.add(new Chunk("月", fontChineseNormalsimfang12));
//                phrase11.add(ChunkFactoryOld.tablenounderLine(StringFactoryBuild.build().getTime(book.getValue(16), 2), 12,
//                        fontChineseNormalsimfang12));
//                phrase11.add(new Chunk("日", fontChineseNormalsimfang12));
//                toMeasurefloat(phrase11);
//
//                paragraph10.add(phrase11);
//                document.add(paragraph10);
//                document.add(space2);
//                document.add(space1);
//
//                final Paragraph bottomLine1 = new Paragraph(
//                        new Chunk(new LineSeparator()));// 加入一个换行
//                bottomLine1.setLeading(1f);
//                bottomLine1.setSpacingBefore(5f);
//
//                document.add(bottomLine1);
//
//                final Paragraph paragraph11 = new Paragraph();
//                Phrase phrase12 = new Phrase();
//                phrase12.add(new Chunk("本文书一式两份：一份由安全生产监督管理部门备案，一份交被复查单位。",
//                        fontChineseNormalsimfang12));
//
//                // phrase12.add(Help_Pdf_Help.tablenounderLine("", 2,
//                // fontChineseKNormal));
//                // phrase12.add(new Chunk("共",fontChineseKNormal));
//                // phrase12.add(Help_Pdf_Help.tablenounderLine("", 4,
//                // fontChineseKNormal));
//                // phrase12.add(new Chunk("页",fontChineseKNormal));
//                // phrase12.add(Help_Pdf_Help.tablenounderLine("", 5,
//                // fontChineseKNormal));
//                // phrase12.add(new Chunk("第",fontChineseKNormal));
//                // phrase12.add(Help_Pdf_Help.tablenounderLine("", 4,
//                // fontChineseKNormal));
//                // phrase12.add(new Chunk("页",fontChineseKNormal));
//
//                paragraph11.add(phrase12);
//
//                document.add(paragraph11);
//
//                PdfContentByte canvas2 = dpfwPdfWriter.getDirectContent();
//                // 电子签章
//                Image img = ImageBuilder.getInstance(image);
//                if (img != null) {
//                    img.setAbsolutePosition(350, 140);
//                    canvas2.addImage(img);
//                }
//                document.newPage();// 结束保存
//            }
//        });
//
//    }
//
//    //强制措施决定书
//    public void printerEntity_Book13(final Base_Entity book, final Object image) {
//        printFrameWork(book, image, new IPdfBackFrame() {
//            @Override
//            public void writeContent() throws Exception {
//                //此处写页面布局
//                document.add(space1);
//
//                final Paragraph title = new Paragraph("" + city + "安全生产行政执法文书", fontChineseBoldsimhei15);// Paragraph就是段落
//                title.setLeading(1f);// 段落距离
//                // title.setSpacingBefore(25f);//段落留白
//                title.setAlignment(Element.ALIGN_CENTER);// 居中
//                document.add(title);// 写入文档
//                final Paragraph titleLine1 = new Paragraph(new Chunk(new LineSeparator()));// 加入一个换行
//                titleLine1.setLeading(1f);
//                titleLine1.setSpacingBefore(5f);
//                document.add(titleLine1);
//                final Paragraph titleLine2 = new Paragraph(new Chunk(new LineSeparator()));
//                titleLine2.setLeading(1f);
//                titleLine2.setSpacingBefore(1f);
//                document.add(titleLine2);
//                final Paragraph title2 = new Paragraph("强制措施决定书", fontChineseBoldsimhei15);
//
//                title2.setLeading(1f);
//                title2.setSpacingBefore(17f);
//                title2.setAlignment(Element.ALIGN_CENTER);
//                document.add(title2);
//
//                final Paragraph title3 = new Paragraph("( " + book.getValue(0) + " )安监管强措〔" + book.getValue(1) + "〕"
//                        + book.getValue(2) + "号", fontChineseNormalsimfang12);
//                title3.setLeading(1f);
//                title3.setSpacingBefore(34f);
//                title3.setAlignment(Element.ALIGN_CENTER);
//                document.add(title3);
//
//                document.add(space1);
//
//                final Paragraph entParagraph = new Paragraph();
//                entParagraph.setLeading(24f);
//                entParagraph.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase1 = new Phrase();
//                phrase1.add((ChunkFactoryOld.underLine(book.getValue(3), 216,
//                        fontChineseNormalsimfang12)));
//                phrase1.add(new Chunk(":", fontChineseNormalsimfang12));
//                toMeasurefloat(phrase1);
//
//                entParagraph.add(phrase1);
//
//                document.add(entParagraph);
//
//                final Paragraph paragraph1 = new Paragraph();
//                paragraph1.setFirstLineIndent(24f);
//                paragraph1.setLeading(24f);
//                paragraph1.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase2 = new Phrase();
//                 phrase2.add(new
//                 Chunk("我局在现场检查时，发现你单位（现场）存在下列问题：",fontChineseNormalsimfang12));
//                phrase2.add(ChunkFactoryOld.underLine(book.getValue(4), 2682,
//                        fontChineseNormalsimfang12,324,430));
//                toMeasurefloat(phrase2);
//
//                paragraph1.add(phrase2);
//                document.add(paragraph1);
//
//                final Paragraph paragraph2 = new Paragraph();
//                paragraph2.setFirstLineIndent(24f);
//                paragraph2.setLeading(24f);
//                paragraph2.setAlignment(Element.ALIGN_LEFT);
//
//                final Paragraph paragraph2_1 = new Paragraph();
//                paragraph2_1.setFirstLineIndent(24f);
//                paragraph2_1.setLeading(24f);
//                paragraph2_1.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase3 = new Phrase();
//                Phrase phrase3_1 = new Phrase();
//                 phrase3.add(new Chunk("以上存在的问题无法保障安全生产，依据", fontChineseNormalsimfang12));
//                phrase3.add(ChunkFactoryOld.underLine(book.getValue(5), 582,
//                        fontChineseNormalsimfang12,250,430));
//                phrase3.add(new Chunk("，", fontChineseNormalsimfang12));
//                 phrase3.add(new Chunk("\n决定采取以下强制措施：", fontChineseNormalsimfang12));
//                phrase3.add(ChunkFactoryOld.underLine(book.getValue(6), 1578,
//                        fontChineseNormalsimfang12,134,430));
//                toMeasurefloat(phrase3);
//
//                paragraph2.add(phrase3);
////                paragraph2_1.add(phrase3_1);
//                document.add(paragraph2);
//                document.add(paragraph2_1);
//                final Paragraph paragraph3 = new Paragraph();
//                paragraph3.setFirstLineIndent(24f);
//                paragraph3.setLeading(24f);
//                paragraph3.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase4 = new Phrase();
//                phrase4.add(new Chunk("如果不服本决定，可以依法在60日内向", fontChineseNormalsimfang12));
//                phrase4.add(ChunkFactoryOld.underLine(book.getValue(7), 132,
//                        fontChineseNormalsimfang12));
//                phrase4.add(new Chunk("人民政府或者", fontChineseNormalsimfang12));
//                phrase4.add(ChunkFactoryOld.underLine(book.getValue(8), 120,
//                        fontChineseNormalsimfang12));
//                phrase4.add(new Chunk("申请行政复议，或者在三个月内依法向", fontChineseNormalsimfang12));
//                phrase4.add(ChunkFactoryOld.underLine(book.getValue(9), 108,
//                        fontChineseNormalsimfang12));
//                phrase4.add(new Chunk("人民法院提起行政诉讼，但本决定不停止执行，法律另有规定的除外。",
//                        fontChineseNormalsimfang12));
//
//                toMeasurefloat(phrase4);
//                paragraph3.add(phrase4);
//
//                document.add(paragraph3);
//                document.add(space1);
//                document.add(space1);
//                document.add(space2);
//                document.add(space2);
//                document.add(space2);
//                document.add(space2);
//                document.add(space2);
//                document.add(space2);
//                document.add(space2);
//                document.add(space2);
//                document.add(space2);
//                document.add(space2);
//                document.add(space2);
//                document.add(space2);
//
//                final Paragraph paragraph4 = new Paragraph();
//                paragraph4.setFirstLineIndent(264f);
//                paragraph4.setLeading(24f);
//                paragraph4.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase5 = new Phrase();
//                phrase5.add(new Chunk("安全生产监督管理部门（公章）", fontChineseNormalsimfang12));
//                toMeasurefloat(phrase5);
//
//                paragraph4.add(phrase5);
//                document.add(paragraph4);
//                document.add(space2);
//
//                final Paragraph paragraph5 = new Paragraph();
//                paragraph5.setFirstLineIndent(264f);
//                paragraph5.setLeading(24f);
//                paragraph5.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase6 = new Phrase();
//                phrase6.add(ChunkFactoryOld.tablenounderLine(StringFactoryBuild.build().getTime(book.getValue(10), 0), 36,
//                        fontChineseNormalsimfang12));
//                phrase6.add(new Chunk("年", fontChineseNormalsimfang12));
//                phrase6.add(ChunkFactoryOld.tablenounderLine(StringFactoryBuild.build().getTime(book.getValue(10), 1), 12,
//                        fontChineseNormalsimfang12));
//                phrase6.add(new Chunk("月", fontChineseNormalsimfang12));
//                phrase6.add(ChunkFactoryOld.tablenounderLine(StringFactoryBuild.build().getTime(book.getValue(10), 2), 12,
//                        fontChineseNormalsimfang12));
//                phrase6.add(new Chunk("日", fontChineseNormalsimfang12));
//                toMeasurefloat(phrase6);
//
//                paragraph5.add(phrase6);
//                document.add(paragraph5);
//
//                final Paragraph bottomLine1 = new Paragraph(
//                        new Chunk(new LineSeparator()));// 加入一个换行
//                bottomLine1.setLeading(1f);
//                bottomLine1.setSpacingBefore(5f);
//
//                document.add(bottomLine1);
//
//                final Paragraph paragraph6 = new Paragraph();
//                Phrase phrase7 = new Phrase();
//                phrase7.add(new Chunk("本文书一式两份：一份由安全生产监督管理部门备案，一份交被检查单位。",
//                        fontChineseNormalsimfang12));
//
//                paragraph6.add(phrase7);
//
//                document.add(paragraph6);
//                PdfContentByte canvas = dpfwPdfWriter.getDirectContent();
//
//                Phrase phrase18 = new Phrase();
//                Phrase phrase19 = new Phrase();
//                Phrase phrase20 = new Phrase();
////                phrase18.add(new Chunk("我局在现场检查时，发现你单位（现场）存在下列问题：",
////                        fontChineseNormalsimfang12));
////                ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phrase18,
////                        104, 625, 0);
////                phrase19.add(new Chunk("以上存在的问题无法保障安全生产，依据", fontChineseNormalsimfang12));
////                ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phrase19,
////                        104, 457, 0);
////                phrase20.add(new Chunk("决定采取一下强制措施：", fontChineseNormalsimfang12));
////                ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phrase20,
////                        80, 408, 0);
//                PdfContentByte canvas2 = dpfwPdfWriter.getDirectContent();
//                // 电子签章
//                Image img = ImageBuilder.getInstance(image);
//                if (img != null) {
//                    img.setAbsolutePosition(350, 140);
//                    canvas2.addImage(img);
//                }
//                document.newPage();// 结束保存
//            }
//        });
//
//    }
//
//    //鉴定委托书
//    public void printerEntity_Book14(final Base_Entity book, final Object image) {
//        printFrameWork(book, image, new IPdfBackFrame() {
//            @Override
//            public void writeContent() throws Exception {
//                //此处写页面布局
//                document.add(space1);
//
//                final Paragraph title = new Paragraph("" + city + "安全生产行政执法文书", fontChineseBoldsimhei15);// Paragraph就是段落
//                title.setLeading(1f);// 段落距离
//                // title.setSpacingBefore(25f);//段落留白
//                title.setAlignment(Element.ALIGN_CENTER);// 居中
//                document.add(title);// 写入文档
//                final Paragraph titleLine1 = new Paragraph(new Chunk(new LineSeparator()));// 加入一个换行
//                titleLine1.setLeading(1f);
//                titleLine1.setSpacingBefore(5f);
//                document.add(titleLine1);
//                final Paragraph titleLine2 = new Paragraph(new Chunk(new LineSeparator()));
//                titleLine2.setLeading(1f);
//                titleLine2.setSpacingBefore(1f);
//                document.add(titleLine2);
//                final Paragraph title2 = new Paragraph("鉴定委托书", fontChineseBoldsimhei15);
//
//                title2.setLeading(1f);
//                title2.setSpacingBefore(17f);
//                title2.setAlignment(Element.ALIGN_CENTER);
//                document.add(title2);
//
//                final Paragraph title3 = new Paragraph("( " + book.getValue(0) + " )安监管鉴〔" + book.getValue(1) + "〕"
//                        + book.getValue(2) + "号", fontChineseNormalsimfang12);
//                title3.setLeading(1f);
//                title3.setSpacingBefore(34f);
//                title3.setAlignment(Element.ALIGN_CENTER);
//                document.add(title3);
//
//                document.add(space1);
//
//                final Paragraph entParagraph = new Paragraph();
//                entParagraph.setLeading(24f);
//                entParagraph.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase1 = new Phrase();
//                phrase1.add((ChunkFactoryOld.underLine(book.getValue(3), 216,
//                        fontChineseNormalsimfang12)));
//                phrase1.add(new Chunk(":", fontChineseNormalsimfang12));
//                toMeasurefloat(phrase1);
//
//                entParagraph.add(phrase1);
//
//                document.add(entParagraph);
//                document.add(space2);
//
//                final Paragraph paragraph1 = new Paragraph(
//                        "因调查有关安全生产违法案件的需要，本行政机关现委托你单位对下列物品进行鉴定：",
//                        fontChineseNormalsimfang12);
//                paragraph1.setAlignment(Element.ALIGN_LEFT);
//                paragraph1.setFirstLineIndent(24f);
//                paragraph1.setLeading(24f);
//
//                document.add(paragraph1);
//                document.add(space2);
//
//                // 表格start
//                PdfPTable table = new PdfPTable(1);
//                table.setWidthPercentage(100f);
//
//                PdfPCell lin01 = new PdfPCell();
//                final Paragraph lin01p0 = new Paragraph("物品名称", fontChineseNormalsimfang12);
//                lin01p0.setAlignment(Element.ALIGN_CENTER);
//                lin01.addElement(lin01p0);
//                PdfPCell lin02 = new PdfPCell();
//                final Paragraph lin02p0 = new Paragraph("规格型号", fontChineseNormalsimfang12);
//                lin02p0.setAlignment(Element.ALIGN_CENTER);
//                lin02.addElement(lin02p0);
//                PdfPCell lin03 = new PdfPCell();
//                final Paragraph lin03p0 = new Paragraph("数量", fontChineseNormalsimfang12);
//                lin03p0.setAlignment(Element.ALIGN_CENTER);
//                lin03.addElement(lin03p0);
//                PdfPCell lin04 = new PdfPCell();
//                final Paragraph lin04p0 = new Paragraph("备注", fontChineseNormalsimfang12);
//                lin04p0.setAlignment(Element.ALIGN_CENTER);
//                lin04.addElement(lin04p0);
//                PdfPTable celltable0 = new PdfPTable(4);
//                float[] celltable0float = new float[4];
//                celltable0float[0] = 4f;
//                celltable0float[1] = 4f;
//                celltable0float[2] = 1f;
//                celltable0float[3] = 3f;
//                celltable0.setTotalWidth(celltable0float);
//                celltable0.addCell(lin01);
//                celltable0.addCell(lin02);
//                celltable0.addCell(lin03);
//                celltable0.addCell(lin04);
//                PdfPCell row0 = new PdfPCell(celltable0);
//                row0.setFixedHeight(25f);
//                table.addCell(row0);
//
//                for (int i = 0; i < 5; i++) {
//                    PdfPCell lin51 = new PdfPCell();
//                    final Paragraph lin51p0 = new Paragraph(getListItemValue(book.getValue(4), i, 0), fontChineseNormalsimfang12);
//                    lin51p0.setAlignment(Element.ALIGN_CENTER);
//                    lin51.addElement(lin51p0);
//                    PdfPCell lin52 = new PdfPCell();
//                    final Paragraph lin52p0 = new Paragraph(getListItemValue(book.getValue(4), i, 1), fontChineseNormalsimfang12);
//                    lin52p0.setAlignment(Element.ALIGN_CENTER);
//                    lin52.addElement(lin52p0);
//                    PdfPCell lin53 = new PdfPCell();
//                    final Paragraph lin53p0 = new Paragraph(getListItemValue(book.getValue(4), i, 2), fontChineseNormalsimfang12);
//                    lin53p0.setAlignment(Element.ALIGN_CENTER);
//                    lin53.addElement(lin53p0);
//                    PdfPCell lin54 = new PdfPCell();
//                    final Paragraph lin54p0 = new Paragraph(getListItemValue(book.getValue(4), i, 3), fontChineseNormalsimfang12);
//                    lin54p0.setAlignment(Element.ALIGN_CENTER);
//                    lin54.addElement(lin54p0);
//                    PdfPTable cellTable5 = new PdfPTable(4);
//                    cellTable5.setWidths(celltable0float);
//                    cellTable5.addCell(lin51);
//                    cellTable5.addCell(lin52);
//                    cellTable5.addCell(lin53);
//                    cellTable5.addCell(lin54);
//                    PdfPCell row5 = new PdfPCell(cellTable5);
//                    row5.setFixedHeight(25f);
//                    table.addCell(row5);
//                }
//
//
//                document.add(table);
//                // 表格end
//
//                final Paragraph paragraph2 = new Paragraph("鉴定要求：", fontChineseNormalsimfang12);
//                paragraph2.setAlignment(Element.ALIGN_LEFT);
//                paragraph2.setFirstLineIndent(24f);
//                paragraph2.setLeading(24f);
//                document.add(paragraph2);
//
//                final Paragraph paragraph3 = new Paragraph();
//                paragraph3.setAlignment(Element.ALIGN_LEFT);
//                paragraph3.setLeading(24f);
//
//                Phrase phrase2 = new Phrase();
//                phrase2.add(ChunkFactoryOld.underLine(book.getValue(5), 1728,
//                        fontChineseNormalsimfang12));
//                paragraph3.add(phrase2);
//
//                document.add(paragraph3);
//
//                final Paragraph paragraph4 = new Paragraph();
//                paragraph4.setFirstLineIndent(24f);
//                paragraph4.setAlignment(Element.ALIGN_LEFT);
//                paragraph4.setLeading(24f);
//
//                Phrase phrase3 = new Phrase();
//                phrase3.add(new Chunk("请于", fontChineseNormalsimfang12));
//                phrase3.add(ChunkFactoryOld.tablenounderLine(StringFactoryBuild.build().getTime(book.getValue(6), 0), 24,
//                        fontChineseNormalsimfang12));
//                phrase3.add(new Chunk("年", fontChineseNormalsimfang12));
//                phrase3.add(ChunkFactoryOld.tablenounderLine(StringFactoryBuild.build().getTime(book.getValue(6), 1), 24,
//                        fontChineseNormalsimfang12));
//                phrase3.add(new Chunk("月", fontChineseNormalsimfang12));
//                phrase3.add(ChunkFactoryOld.tablenounderLine(StringFactoryBuild.build().getTime(book.getValue(6), 2), 24,
//                        fontChineseNormalsimfang12));
//                phrase3.add(new Chunk("日前向本行政机关提交鉴定结果。", fontChineseNormalsimfang12));
//
//                paragraph4.add(phrase3);
//
//                document.add(paragraph4);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//
//                final Paragraph paragraph5 = new Paragraph();
//                paragraph5.setFirstLineIndent(264f);
//                paragraph5.setLeading(24f);
//                paragraph5.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase5 = new Phrase();
//                phrase5.add(new Chunk("安全生产监督管理部门（公章）", fontChineseNormalsimfang12));
//                toMeasurefloat(phrase5);
//
//                paragraph5.add(phrase5);
//                document.add(paragraph5);
//                document.add(space2);
//
//                final Paragraph paragraph6 = new Paragraph();
//                paragraph6.setFirstLineIndent(264f);
//                paragraph6.setLeading(24f);
//                paragraph6.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase6 = new Phrase();
//                phrase6.add(ChunkFactoryOld.tablenounderLine(StringFactoryBuild.build().getTime(book.getValue(7), 0), 36,
//                        fontChineseNormalsimfang12));
//                phrase6.add(new Chunk("年", fontChineseNormalsimfang12));
//                phrase6.add(ChunkFactoryOld.tablenounderLine(StringFactoryBuild.build().getTime(book.getValue(7), 1), 12,
//                        fontChineseNormalsimfang12));
//                phrase6.add(new Chunk("月", fontChineseNormalsimfang12));
//                phrase6.add(ChunkFactoryOld.tablenounderLine(StringFactoryBuild.build().getTime(book.getValue(7), 2), 12,
//                        fontChineseNormalsimfang12));
//                phrase6.add(new Chunk("日", fontChineseNormalsimfang12));
//                toMeasurefloat(phrase6);
//
//                paragraph6.add(phrase6);
//                document.add(paragraph6);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//
//                final Paragraph paragraph7 = new Paragraph();
//                Phrase phrase7 = new Phrase();
//                phrase7.add(new Chunk("注： 鉴定结果请提出具体鉴定报告书，并由鉴定人员签名并加盖鉴定机构公章。",
//                        fontChineseNormalsimfang12));
//
//                paragraph7.add(phrase7);
//
//                document.add(paragraph7);
//                PdfContentByte canvas2 = dpfwPdfWriter.getDirectContent();
//                // 电子签章
//                Image img = ImageBuilder.getInstance(image);
//                if (img != null) {
//                    img.setAbsolutePosition(350, 140);
//                    canvas2.addImage(img);
//                }
//
//                document.newPage();// 结束保存
//            }
//        });
//
//    }
//
//    //行政处罚告知书
//    public void printerEntity_Book15(final Base_Entity book, final Object image) {
//        printFrameWork(book, image, new IPdfBackFrame() {
//            @Override
//            public void writeContent() throws Exception {
//                //此处写页面布局
//                document.add(space1);
//
//                final Paragraph title = new Paragraph("" + city + "安全生产行政执法文书", fontChineseBoldsimhei15);// Paragraph就是段落
//                title.setLeading(1f);// 段落距离
//                // title.setSpacingBefore(25f);//段落留白
//                title.setAlignment(Element.ALIGN_CENTER);// 居中
//                document.add(title);// 写入文档
//                final Paragraph titleLine1 = new Paragraph(new Chunk(new LineSeparator()));// 加入一个换行
//                titleLine1.setLeading(1f);
//                titleLine1.setSpacingBefore(5f);
//                document.add(titleLine1);
//                final Paragraph titleLine2 = new Paragraph(new Chunk(new LineSeparator()));
//                titleLine2.setLeading(1f);
//                titleLine2.setSpacingBefore(1f);
//                document.add(titleLine2);
//                final Paragraph title2 = new Paragraph("行政处罚告知书", fontChineseBoldsimhei15);
//
//                title2.setLeading(1f);
//                title2.setSpacingBefore(17f);
//                title2.setAlignment(Element.ALIGN_CENTER);
//                document.add(title2);
//
//                final Paragraph title3 = new Paragraph("( " + book.getValue(0) + " )安监管罚告〔" + book.getValue(1) + "〕"
//                        + book.getValue(2) + "号", fontChineseNormalsimfang12);
//                title3.setLeading(1f);
//                title3.setSpacingBefore(34f);
//                title3.setAlignment(Element.ALIGN_CENTER);
//                document.add(title3);
//
//                document.add(space1);
//                document.add(space1);
//
//                final Paragraph entParagraph = new Paragraph();
//                entParagraph.setLeading(24f);
//                entParagraph.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase1 = new Phrase();
//                phrase1.add((ChunkFactoryOld.underLine(book.getValue(3), 108,
//                        fontChineseNormalsimfang12)));
//                phrase1.add(new Chunk(":", fontChineseNormalsimfang12));
//                toMeasurefloat(phrase1);
//
//                entParagraph.add(phrase1);
//
//                document.add(entParagraph);
//
//                final Paragraph paragraph1 = new Paragraph();
//                paragraph1.setFirstLineIndent(24f);
//                paragraph1.setLeading(24f);
//                paragraph1.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase2 = new Phrase();
//                 phrase2.add(new Chunk("经查，你（单位）有",fontChineseNormalsimfang12));
//                phrase2.add(ChunkFactoryOld.underLine(book.getValue(4), 2830,
//                        fontChineseNormalsimfang12,130,430));
//                phrase2.add(new Chunk("的行为。", fontChineseNormalsimfang12));
//                toMeasurefloat(phrase2);
//
//                paragraph1.add(phrase2);
//                document.add(paragraph1);
//
//                final Paragraph paragraph2 = new Paragraph();
//                paragraph2.setFirstLineIndent(24f);
//                paragraph2.setLeading(24f);
//                paragraph2.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase3 = new Phrase();
//
//                 phrase3.add(new Chunk("以上行为违反了", fontChineseNormalsimfang12));
//                phrase3.add(ChunkFactoryOld.underLine(book.getValue(5), 1170,
//                        fontChineseNormalsimfang12,108,430));
//                phrase3.add(new Chunk("的规定，依据", fontChineseNormalsimfang12));
//                phrase3.add(ChunkFactoryOld.underLine(book.getValue(6), 342,
//                        fontChineseNormalsimfang12,72,430));
//                phrase3.add(ChunkFactoryOld
//                        .underLine("，", 0, fontChineseNormalsimfang12));
//                phrase3.add(new Chunk("拟对你（单位）作出", fontChineseNormalsimfang12));
//                phrase3.add(ChunkFactoryOld.underLine(book.getValue(7), 306,
//                        fontChineseNormalsimfang12,108,430));
//                phrase3.add(new Chunk("的行政处罚。", fontChineseNormalsimfang12));
//                toMeasurefloat(phrase3);
//
//                paragraph2.add(phrase3);
//                document.add(paragraph2);
//
//                final Paragraph paragraph3 = new Paragraph();
//                paragraph3.setFirstLineIndent(24f);
//                paragraph3.setLeading(24f);
//                paragraph3.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase4 = new Phrase();
//                phrase4.add(new Chunk(
//                        "如对上述处罚有异议，根据《中华人民共和国行政处罚法》第三十一条和第三十二条的规定，你（单位）有权向",
//                        fontChineseNormalsimfang12));
//                phrase4.add(ChunkFactoryOld
//                        .underLine(book.getValue(8), 84, fontChineseNormalsimfang12));
//                phrase4.add(new Chunk("安全生产监督管理部门进行陈述和申辩。", fontChineseNormalsimfang12));
//
//                toMeasurefloat(phrase4);
//                paragraph3.add(phrase4);
//
//                document.add(paragraph3);
//                document.add(space1);
//
//                final Paragraph paragraph4 = new Paragraph();
//                paragraph4.setIndentationLeft(24f);
//                paragraph4.setLeading(24f);
//                paragraph4.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase5 = new Phrase();
//                phrase5.add(new Chunk("安全生产监督管理部门地址：", fontChineseNormalsimfang12));
//                phrase5.add(ChunkFactoryOld.underLine(book.getValue(9), 234,
//                        fontChineseNormalsimfang12));
//                phrase5.add("\n");
//                phrase5.add(new Chunk("联系人：", fontChineseNormalsimfang12));
//                phrase5.add(ChunkFactoryOld
//                        .underLine(book.getValue(10), 72, fontChineseNormalsimfang12));
//                phrase5.add(new Chunk("联系电话：", fontChineseNormalsimfang12));
//                phrase5.add(ChunkFactoryOld
//                        .underLine(book.getValue(11), 78, fontChineseNormalsimfang12));
//                phrase5.add(new Chunk("邮编：", fontChineseNormalsimfang12));
//                phrase5.add(ChunkFactoryOld
//                        .underLine(book.getValue(12), 72, fontChineseNormalsimfang12));
//
//                paragraph4.add(phrase5);
//                document.add(paragraph4);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//
//                final Paragraph paragraph5 = new Paragraph();
//                paragraph5.setFirstLineIndent(240f);
//                paragraph5.setLeading(24f);
//                paragraph4.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase6 = new Phrase();
//                phrase6.add(new Chunk("安全生产监督管理部门（公章）", fontChineseNormalsimfang12));
//                toMeasurefloat(phrase6);
//
//                paragraph5.add(phrase6);
//                document.add(paragraph5);
//                document.add(space2);
//
//                final Paragraph paragraph6 = new Paragraph();
//                paragraph6.setFirstLineIndent(264f);
//                paragraph6.setLeading(24f);
//                paragraph6.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase7 = new Phrase();
//                phrase7.add(ChunkFactoryOld.tablenounderLine(StringFactoryBuild.build().getTime(book.getValue(13), 0), 24,
//                        fontChineseNormalsimfang12));
//                phrase7.add(new Chunk("年", fontChineseNormalsimfang12));
//                phrase7.add(ChunkFactoryOld.tablenounderLine(StringFactoryBuild.build().getTime(book.getValue(13), 1), 12,
//                        fontChineseNormalsimfang12));
//                phrase7.add(new Chunk("月", fontChineseNormalsimfang12));
//                phrase7.add(ChunkFactoryOld.tablenounderLine(StringFactoryBuild.build().getTime(book.getValue(13), 2), 12,
//                        fontChineseNormalsimfang12));
//                phrase7.add(new Chunk("日", fontChineseNormalsimfang12));
//                toMeasurefloat(phrase7);
//
//                paragraph6.add(phrase7);
//                document.add(paragraph6);
//                document.add(space2);
//
//                final Paragraph bottomLine1 = new Paragraph(
//                        new Chunk(new LineSeparator()));// 加入一个换行
//                bottomLine1.setLeading(1f);
//                bottomLine1.setSpacingBefore(5f);
//
//                document.add(bottomLine1);
//
//                final Paragraph paragraph7 = new Paragraph();
//                Phrase phrase8 = new Phrase();
//                phrase8.add(new Chunk("本文书一式两份：一份由安全生产监督管理部门备案，一份交拟处罚当事人。",
//                        fontChineseNormalsimfang12));
//
//                paragraph7.add(phrase8);
//
//                document.add(paragraph7);
//                PdfContentByte canvas = dpfwPdfWriter.getDirectContent();
//
////                Phrase phrase18 = new Phrase();
////
////                phrase18.add(new Chunk("经查，你（单位）有", fontChineseNormalsimfang12));
////                ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phrase18,
////                        104, 620, 0);
////
////                Phrase phrase19 = new Phrase();
////
////                phrase19.add(new Chunk("以上行为违反了", fontChineseNormalsimfang12));
////                ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phrase19,
////                        104, 452, 0);
//                PdfContentByte canvas2 = dpfwPdfWriter.getDirectContent();
//                // 电子签章
//                Image img = ImageBuilder.getInstance(image);
//                if (img != null) {
//                    img.setAbsolutePosition(350, 140);
//                    canvas2.addImage(img);
//                }
//                document.newPage();// 结束保存
//            }
//        });
//
//    }
//
//    //当事人陈述申辩笔录
//    public void printerEntity_Book16(final Base_Entity book, final Object image) {
//        printFrameWork(book, image, new IPdfBackFrame() {
//            @Override
//            public void writeContent() throws Exception {
//                //此处写页面布局
//                document.add(space1);
//
//                final Paragraph title = new Paragraph("" + city + "安全生产行政执法文书", fontChineseBoldsimhei15);// Paragraph就是段落
//                title.setLeading(1f);// 段落距离
//                // title.setSpacingBefore(25f);//段落留白
//                title.setAlignment(Element.ALIGN_CENTER);// 居中
//                document.add(title);// 写入文档
//                final Paragraph titleLine1 = new Paragraph(new Chunk(new LineSeparator()));// 加入一个换行
//                titleLine1.setLeading(1f);
//                titleLine1.setSpacingBefore(5f);
//                document.add(titleLine1);
//                final Paragraph titleLine2 = new Paragraph(new Chunk(new LineSeparator()));
//                titleLine2.setLeading(1f);
//                titleLine2.setSpacingBefore(1f);
//                document.add(titleLine2);
//                final Paragraph title2 = new Paragraph("当事人陈述申辩笔录", fontChineseBoldsimhei15);
//
//                title2.setLeading(1f);
//                title2.setSpacingBefore(17f);
//                title2.setAlignment(Element.ALIGN_CENTER);
//
//                document.add(title2);
//                document.add(space1);
//
//                final Paragraph paragraph1 = new Paragraph();
//                paragraph1.setIndentationLeft(24f);
//                paragraph1.setLeading(24f);
//                paragraph1.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase1 = new Phrase();
//                phrase1.add(new Chunk("时间：", fontChineseNormalsimfang12));
//                phrase1.add(ChunkFactoryOld
//                        .underLine(StringFactoryBuild.build().getTime(book.getValue(3), 0), 30, fontChineseNormalsimfang12));
//                phrase1.add(new Chunk("年", fontChineseNormalsimfang12));
//                phrase1.add(ChunkFactoryOld
//                        .underLine(StringFactoryBuild.build().getTime(book.getValue(3), 1), 12, fontChineseNormalsimfang12));
//                phrase1.add(new Chunk("月", fontChineseNormalsimfang12));
//                phrase1.add(ChunkFactoryOld
//                        .underLine(StringFactoryBuild.build().getTime(book.getValue(3), 2), 12, fontChineseNormalsimfang12));
//                phrase1.add(new Chunk("日", fontChineseNormalsimfang12));
//                phrase1.add(ChunkFactoryOld
//                        .underLine(StringFactoryBuild.build().getTime(book.getValue(3), 3), 12, fontChineseNormalsimfang12));
//                phrase1.add(new Chunk("时", fontChineseNormalsimfang12));
//                phrase1.add(ChunkFactoryOld
//                        .underLine(StringFactoryBuild.build().getTime(book.getValue(3), 4), 12, fontChineseNormalsimfang12));
//                phrase1.add(new Chunk("分至", fontChineseNormalsimfang12));
//                phrase1.add(ChunkFactoryOld
//                        .underLine(StringFactoryBuild.build().getTime(book.getValue(4), 2), 12, fontChineseNormalsimfang12));
//                phrase1.add(new Chunk("日", fontChineseNormalsimfang12));
//                phrase1.add(ChunkFactoryOld
//                        .underLine(StringFactoryBuild.build().getTime(book.getValue(4), 3), 12, fontChineseNormalsimfang12));
//                phrase1.add(new Chunk("时", fontChineseNormalsimfang12));
//                phrase1.add(ChunkFactoryOld
//                        .underLine(StringFactoryBuild.build().getTime(book.getValue(4), 4), 12, fontChineseNormalsimfang12));
//                phrase1.add(new Chunk("分", fontChineseNormalsimfang12));
//                phrase1.add("\n");
//
//                Phrase phrase2 = new Phrase();
//                phrase2.add(new Chunk("地点：", fontChineseNormalsimfang12));
//                phrase2.add(ChunkFactoryOld.underLine(book.getValue(5), 354,
//                        fontChineseNormalsimfang12));
//
//                Phrase phrase3 = new Phrase();
//                phrase3.add(new Chunk("陈述申辩人：", fontChineseNormalsimfang12));
//                phrase3.add(ChunkFactoryOld.underLine(book.getValue(6), 84,
//                        fontChineseNormalsimfang12));
//                phrase3.add(new Chunk("性别：", fontChineseNormalsimfang12));
//                phrase3.add(ChunkFactoryOld
//                        .underLine(book.getValue(7), 42, fontChineseNormalsimfang12));
//                phrase3.add(new Chunk("职务：", fontChineseNormalsimfang12));
//                phrase3.add(ChunkFactoryOld.underLine(book.getValue(8), 96,
//                        fontChineseNormalsimfang12));
//                phrase3.add("\n");
//
//                Phrase phrase4 = new Phrase();
//                phrase4.add(new Chunk("工作单位：", fontChineseNormalsimfang12));
//                phrase4.add(ChunkFactoryOld.underLine(book.getValue(9), 190,
//                        fontChineseNormalsimfang12));
//                phrase4.add(new Chunk("电话：", fontChineseNormalsimfang12));
//                phrase4.add(ChunkFactoryOld.underLine(book.getValue(10), 96,
//                        fontChineseNormalsimfang12));
//                phrase4.add("\n");
//
//                Phrase phrase5 = new Phrase();
//                phrase5.add(new Chunk("联系地址：", fontChineseNormalsimfang12));
//                phrase5.add(ChunkFactoryOld.underLine(book.getValue(11), 190,
//                        fontChineseNormalsimfang12));
//                phrase5.add(new Chunk("邮编：", fontChineseNormalsimfang12));
//                phrase5.add(ChunkFactoryOld.underLine(book.getValue(12), 96,
//                        fontChineseNormalsimfang12));
//                phrase5.add("\n");
//
//                Phrase phrase6 = new Phrase();
//                phrase6.add(new Chunk("承办人：", fontChineseNormalsimfang12));
//                phrase6.add(ChunkFactoryOld.underLine(book.getValue(13), 198,
//                        fontChineseNormalsimfang12));
//                phrase6.add(new Chunk("记录人：", fontChineseNormalsimfang12));
//                phrase6.add(ChunkFactoryOld
//                        .underLine(book.getValue(14), 84, fontChineseNormalsimfang12));
//
//                paragraph1.add(phrase1);
//                paragraph1.add(phrase2);
//                paragraph1.add(phrase3);
//                paragraph1.add(phrase4);
//                paragraph1.add(phrase5);
//                paragraph1.add(phrase6);
//
//                document.add(paragraph1);
//
//                final Paragraph paragraph2 = new Paragraph();
//                paragraph2.setFirstLineIndent(24f);
//                paragraph2.setLeading(24f);
//                paragraph2.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase7 = new Phrase();
//                phrase7.add(new Chunk("我们是", fontChineseNormalsimfang12));
//                phrase7.add(ChunkFactoryOld
//                        .underLine(book.getValue(15), 60, fontChineseNormalsimfang12));
//                phrase7.add(new Chunk("安全生产监督管理局的执法人员", fontChineseNormalsimfang12));
//                phrase7.add(ChunkFactoryOld
//                        .underLine(book.getValue(16), 48, fontChineseNormalsimfang12));
//                phrase7.add(new Chunk("、", fontChineseNormalsimfang12));
//                phrase7.add(ChunkFactoryOld
//                        .underLine(book.getValue(17), 48, fontChineseNormalsimfang12));
//                phrase7.add(new Chunk("，", fontChineseNormalsimfang12));
//
//                Phrase phrase8 = new Phrase();
//                phrase8.add(new Chunk("证件号码为", fontChineseNormalsimfang12));
//                phrase8.add(ChunkFactoryOld
//                        .underLine(book.getValue(18), 60, fontChineseNormalsimfang12));
//                phrase8.add(new Chunk("、", fontChineseNormalsimfang12));
//                phrase8.add(ChunkFactoryOld
//                        .underLine(book.getValue(19), 60, fontChineseNormalsimfang12));
//                phrase8.add(new Chunk("，这是我们的证件（出示证件）。现对", fontChineseNormalsimfang12));
//
//                Phrase phrase9 = new Phrase();
//                phrase9.add(ChunkFactoryOld.underLine(book.getValue(20), 210,
//                        fontChineseNormalsimfang12));
//                phrase9.add(new Chunk("一案听取你（单位）的陈述申辩。", fontChineseNormalsimfang12));
//
//                paragraph2.add(phrase7);
//                paragraph2.add(phrase8);
//                paragraph2.add(phrase9);
//
//                document.add(paragraph2);
//
//                final Paragraph paragraph3 = new Paragraph();
//                paragraph3.setFirstLineIndent(24f);
//                paragraph3.setLeading(24f);
//                paragraph3.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase10 = new Phrase();
//                 phrase10.add(new Chunk("陈述申辩记录：", fontChineseNormalsimfang12));
//                phrase10.add(ChunkFactoryOld.underLine(book.getValue(21), 5494,
//                        fontChineseNormalsimfang12,108,430));
//
//                paragraph3.add(phrase10);
//                document.add(paragraph3);
//
//                final Paragraph paragraph4 = new Paragraph();
//                paragraph4.setIndentationLeft(24f);
//
//                Phrase phrase11 = new Phrase();
//                phrase11.add(new Chunk("陈述申辩人（签名）：", fontChineseNormalsimfang12));
//                phrase11.add(ChunkFactoryOld.underLine(book.getValue(22), 84,
//                        fontChineseNormalsimfang12));
//                phrase11.add(new Chunk("\n承办人（签名）：", fontChineseNormalsimfang12));
//                phrase11.add(ChunkFactoryOld.underLine(book.getValue(23), 102,
//                        fontChineseNormalsimfang12));
//                phrase11.add(new Chunk("\n记录人（签名）：", fontChineseNormalsimfang12));
//                phrase11.add(ChunkFactoryOld.underLine(book.getValue(24), 102,
//                        fontChineseNormalsimfang12));
//
//                Phrase phrase12 = new Phrase();
//                phrase12.add(ChunkFactoryOld.tablenounderLine("", 300,
//                        fontChineseNormalsimfang12));
//                phrase12.add(ChunkFactoryOld.tablenounderLine(StringFactoryBuild.build().getTime(book.getValue(25), 0), 180,
//                        fontChineseNormalsimfang12));
//                phrase12.add(new Chunk("年", fontChineseNormalsimfang12));
//                phrase12.add(ChunkFactoryOld.tablenounderLine(StringFactoryBuild.build().getTime(book.getValue(25), 1), 12,
//                        fontChineseNormalsimfang12));
//                phrase12.add(new Chunk("月", fontChineseNormalsimfang12));
//                phrase12.add(ChunkFactoryOld.tablenounderLine(StringFactoryBuild.build().getTime(book.getValue(25), 2), 12,
//                        fontChineseNormalsimfang12));
//                phrase12.add(new Chunk("日", fontChineseNormalsimfang12));
//
//                paragraph4.add(phrase11);
//                paragraph4.add(phrase12);
//                paragraph4.setLeading(24);
//                document.add(paragraph4);
//
//                final Paragraph bottomLine1 = new Paragraph(
//                        new Chunk(new LineSeparator()));// 加入一个换行
//                bottomLine1.setLeading(1f);
//                bottomLine1.setSpacingBefore(1f);
//
//                document.add(bottomLine1);
//                PdfContentByte canvas = dpfwPdfWriter.getDirectContent();
//
////                Phrase phrase18 = new Phrase();
////
////                phrase18.add(new Chunk("陈述申辩记录：", fontChineseNormalsimfang12));
////                ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phrase18,
////                        104, 468, 0);
//
//                PdfContentByte canvas2 = dpfwPdfWriter.getDirectContent();
//                // 电子签章
//                Image img = ImageBuilder.getInstance(image);
//                if (img != null) {
//                    img.setAbsolutePosition(350, 140);
//                    canvas2.addImage(img);
//                }
//
//                document.newPage();// 结束保存
//            }
//        });
//
//    }
//
//    //听证告知书
//    public void printerEntity_Book17(final Base_Entity book, final Object image) {
//        printFrameWork(book, image, new IPdfBackFrame() {
//            @Override
//            public void writeContent() throws Exception {
//                //此处写页面布局
//                final Paragraph title = new Paragraph("" + city + "安全生产行政执法文书", fontChineseBoldsimhei15);// Paragraph就是段落
//                title.setLeading(1f);// 段落距离
//                // title.setSpacingBefore(25f);//段落留白
//                title.setAlignment(Element.ALIGN_CENTER);// 居中
//                document.add(title);// 写入文档
//                final Paragraph titleLine1 = new Paragraph(new Chunk(new LineSeparator()));// 加入一个换行
//                titleLine1.setLeading(1f);
//                titleLine1.setSpacingBefore(5f);
//                document.add(titleLine1);
//                final Paragraph titleLine2 = new Paragraph(new Chunk(new LineSeparator()));
//                titleLine2.setLeading(1f);
//                titleLine2.setSpacingBefore(1f);
//                document.add(titleLine2);
//                final Paragraph title2 = new Paragraph("听证告知书", fontChineseBoldsimhei15);
//
//                title2.setLeading(1f);
//                title2.setSpacingBefore(17f);
//                title2.setAlignment(Element.ALIGN_CENTER);
//                document.add(title2);
//
//                final Paragraph title3 = new Paragraph("( " + book.getValue(0) + " )安监管听告〔" + book.getValue(1) + "〕"
//                        + book.getValue(2) + "号", fontChineseNormalsimfang12);
//                title3.setLeading(1f);
//                title3.setSpacingBefore(34f);
//                title3.setAlignment(Element.ALIGN_CENTER);
//                document.add(title3);
//
//                document.add(space1);
//
//                final Paragraph entParagraph = new Paragraph();
//                entParagraph.setLeading(24f);
//                entParagraph.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase1 = new Phrase();
//                phrase1.add((ChunkFactoryOld.underLine(book.getValue(3), 108,
//                        fontChineseNormalsimfang12)));
//                phrase1.add(new Chunk(":", fontChineseNormalsimfang12));
//                toMeasurefloat(phrase1);
//
//                entParagraph.add(phrase1);
//
//                document.add(entParagraph);
//
//                final Paragraph paragraph1 = new Paragraph();
//                paragraph1.setFirstLineIndent(24f);
//                paragraph1.setLeading(24f);
//                paragraph1.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase2 = new Phrase();
//                 phrase2.add(new Chunk("经查，你（单位）有",fontChineseNormalsimfang12));
//                phrase2.add(ChunkFactoryOld.underLine(book.getValue(4), 2846,
//                        fontChineseNormalsimfang12,134,430));
//                phrase2.add(new Chunk("行为。", fontChineseNormalsimfang12));
//                toMeasurefloat(phrase2);
//
//                paragraph1.add(phrase2);
//                document.add(paragraph1);
//
//                final Paragraph paragraph2 = new Paragraph();
//                paragraph2.setFirstLineIndent(24f);
//                paragraph2.setLeading(24f);
//                paragraph2.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase3 = new Phrase();
//
//                phrase3.add(new Chunk("以上行为违反了", fontChineseNormalsimfang12));
//                phrase3.add(ChunkFactoryOld.underLine(book.getValue(5), 248,
//                        fontChineseNormalsimfang12));
//                phrase3.add(new Chunk("的规定，依", fontChineseNormalsimfang12));
//                phrase3.add(new Chunk("据", fontChineseNormalsimfang12));
//                phrase3.add(ChunkFactoryOld.underLine(book.getValue(6), 402,
//                        fontChineseNormalsimfang12));
//                phrase3.add(new Chunk("，拟对你（单位）作出", fontChineseNormalsimfang12));
//                phrase3.add(ChunkFactoryOld.underLine(book.getValue(7), 294,
//                        fontChineseNormalsimfang12));
//                phrase3.add(new Chunk("的行政处罚。", fontChineseNormalsimfang12));
//                toMeasurefloat(phrase3);
//
//                paragraph2.add(phrase3);
//                document.add(paragraph2);
//
//                final Paragraph paragraph3 = new Paragraph();
//                paragraph3.setFirstLineIndent(24f);
//                paragraph3.setLeading(24f);
//                paragraph3.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase4 = new Phrase();
//                phrase4.add(new Chunk(
//                        "根据《中华人民共和国行政处罚法》第四十二条的规定，你（单位）有要求举行听证的权利。如你（单位）要求举行听证，请在接到本告知书之日起3日内向",
//                        fontChineseNormalsimfang12));
//                phrase4.add(ChunkFactoryOld
//                        .underLine(book.getValue(8), 84, fontChineseNormalsimfang12));
//                phrase4.add(new Chunk("安全生产监督管理部门提出书面听证申请。逾期不提出申请的，视为放弃听证权利。",
//                        fontChineseNormalsimfang12));
//
//                toMeasurefloat(phrase4);
//                paragraph3.add(phrase4);
//
//                document.add(paragraph3);
//
//                final Paragraph paragraph4 = new Paragraph(new Chunk("特此告知。",
//                        fontChineseNormalsimfang12));
//                paragraph4.setFirstLineIndent(24f);
//                paragraph4.setLeading(24f);
//                paragraph4.setAlignment(Element.ALIGN_LEFT);
//
//                document.add(paragraph4);
//                document.add(space1);
//
//                final Paragraph paragraph5 = new Paragraph();
//                paragraph5.setIndentationLeft(24f);
//                paragraph5.setLeading(24f);
//                paragraph5.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase5 = new Phrase();
//                phrase5.add(new Chunk("安全生产监督管理部门地址：", fontChineseNormalsimfang12));
//                phrase5.add(ChunkFactoryOld.underLine(book.getValue(9), 234,
//                        fontChineseNormalsimfang12));
//                phrase5.add("\n");
//                phrase5.add(new Chunk("联系人：", fontChineseNormalsimfang12));
//                phrase5.add(ChunkFactoryOld
//                        .underLine(book.getValue(10), 72, fontChineseNormalsimfang12));
//                phrase5.add(new Chunk("联系电话：", fontChineseNormalsimfang12));
//                phrase5.add(ChunkFactoryOld
//                        .underLine(book.getValue(11), 78, fontChineseNormalsimfang12));
//                phrase5.add(new Chunk("邮编：", fontChineseNormalsimfang12));
//                phrase5.add(ChunkFactoryOld
//                        .underLine(book.getValue(12), 72, fontChineseNormalsimfang12));
//
//                paragraph5.add(phrase5);
//
//                document.add(paragraph5);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//
//                final Paragraph paragraph6 = new Paragraph();
//                paragraph6.setFirstLineIndent(264f);
//                paragraph6.setLeading(24f);
//                paragraph6.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase6 = new Phrase();
//                phrase6.add(new Chunk("安全生产监督管理部门（公章）", fontChineseNormalsimfang12));
//                toMeasurefloat(phrase6);
//
//                paragraph6.add(phrase6);
//                document.add(paragraph6);
//
//                final Paragraph paragraph7 = new Paragraph();
//                paragraph7.setFirstLineIndent(264f);
//                paragraph7.setLeading(24f);
//                paragraph7.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase7 = new Phrase();
//                phrase7.add(ChunkFactoryOld.tablenounderLine(StringFactoryBuild.build().getTime(book.getValue(13), 0), 30,
//                        fontChineseNormalsimfang12));
//                phrase7.add(new Chunk("年", fontChineseNormalsimfang12));
//                phrase7.add(ChunkFactoryOld.tablenounderLine(StringFactoryBuild.build().getTime(book.getValue(13), 1), 12,
//                        fontChineseNormalsimfang12));
//                phrase7.add(new Chunk("月", fontChineseNormalsimfang12));
//                phrase7.add(ChunkFactoryOld.tablenounderLine(StringFactoryBuild.build().getTime(book.getValue(13), 2), 12,
//                        fontChineseNormalsimfang12));
//                phrase7.add(new Chunk("日", fontChineseNormalsimfang12));
//                toMeasurefloat(phrase7);
//
//                paragraph7.add(phrase7);
//                document.add(paragraph7);
//
//                final Paragraph bottomLine1 = new Paragraph(
//                        new Chunk(new LineSeparator()));// 加入一个换行
//                bottomLine1.setLeading(1f);
//                bottomLine1.setSpacingBefore(5f);
//
//                document.add(bottomLine1);
//
//                final Paragraph paragraph8 = new Paragraph();
//                Phrase phrase8 = new Phrase();
//                phrase8.add(new Chunk("本文书一式两份：一份由安全生产监督管理部门备案，一份交拟处罚当事人。",
//                        fontChineseNormalsimfang12));
//
//                paragraph8.add(phrase8);
//
//                document.add(paragraph8);
//                PdfContentByte canvas = dpfwPdfWriter.getDirectContent();
//
////                Phrase phrase18 = new Phrase();
////
////                phrase18.add(new Chunk("经查，你（单位）有：", fontChineseNormalsimfang12));
////                ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phrase18,
////                        104, 626, 0);
//                PdfContentByte canvas2 = dpfwPdfWriter.getDirectContent();
//                // 电子签章
//                Image img = ImageBuilder.getInstance(image);
//                if (img != null) {
//                    img.setAbsolutePosition(350, 140);
//                    canvas2.addImage(img);
//                }
//                document.newPage();// 结束保存
//            }
//        });
//
//    }
//
//    //听证会通知书
//    public void printerEntity_Book18(final Base_Entity book, final Object image) {
//        printFrameWork(book, image, new IPdfBackFrame() {
//            @Override
//            public void writeContent() throws Exception {
//                //此处写页面布局
//                final Paragraph title = new Paragraph("" + city + "安全生产行政执法文书", fontChineseBoldsimhei15);// Paragraph就是段落
//                title.setLeading(1f);// 段落距离
//                // title.setSpacingBefore(25f);//段落留白
//                title.setAlignment(Element.ALIGN_CENTER);// 居中
//                document.add(title);// 写入文档
//                final Paragraph titleLine1 = new Paragraph(new Chunk(new LineSeparator()));// 加入一个换行
//                titleLine1.setLeading(1f);
//                titleLine1.setSpacingBefore(5f);
//                document.add(titleLine1);
//                final Paragraph titleLine2 = new Paragraph(new Chunk(new LineSeparator()));
//                titleLine2.setLeading(1f);
//                titleLine2.setSpacingBefore(1f);
//                document.add(titleLine2);
//                final Paragraph title2 = new Paragraph("听证会通知书", fontChineseBoldsimhei15);
//
//                title2.setLeading(1f);
//                title2.setSpacingBefore(17f);
//                title2.setAlignment(Element.ALIGN_CENTER);
//                document.add(title2);
//
//                final Paragraph title3 = new Paragraph("( " + book.getValue(0) + " )安监管听通〔" + book.getValue(1) + "〕"
//                        + book.getValue(2) + "号", fontChineseNormalsimfang12);
//                title3.setLeading(1f);
//                title3.setSpacingBefore(34f);
//                title3.setAlignment(Element.ALIGN_CENTER);
//                document.add(title3);
//
//                final Paragraph entParagraph = new Paragraph();
//                entParagraph.setLeading(24f);
//                entParagraph.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase1 = new Phrase();
//                phrase1.add((ChunkFactoryOld.underLine(book.getValue(3), 108,
//                        fontChineseNormalsimfang12)));
//                phrase1.add(new Chunk(":", fontChineseNormalsimfang12));
//                toMeasurefloat(phrase1);
//
//                entParagraph.add(phrase1);
//
//                document.add(entParagraph);
//
//                final Paragraph paragraph1 = new Paragraph();
//                paragraph1.setFirstLineIndent(24f);
//                paragraph1.setLeading(24f);
//                paragraph1.setAlignment(Element.ALIGN_LEFT);
//
//                final Paragraph paragraph1_1 = new Paragraph();
//                paragraph1_1.setFirstLineIndent(24f);
//                paragraph1_1.setLeading(24f);
//                paragraph1_1.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase2 = new Phrase();
//                Phrase phrase2_1 = new Phrase();
//                phrase2.add(new Chunk("根据你（单位）申请，关于", fontChineseNormalsimfang12));
//                phrase2.add(ChunkFactoryOld.underLine(book.getValue(4), 206,
//                        fontChineseNormalsimfang12));
//                phrase2.add(new Chunk("一案，现定于", fontChineseNormalsimfang12));
//                 phrase2.add(ChunkFactoryOld.underLine("", 36,
//                         fontChineseNormalsimfang12));
//                 phrase2.add(new Chunk("年", fontChineseNormalsimfang12));
//                 phrase2.add(ChunkFactoryOld.underLine("", 24,
//                         fontChineseNormalsimfang12));
//                 phrase2.add(new Chunk("月", fontChineseNormalsimfang12));
//                 phrase2.add(ChunkFactoryOld.underLine("", 24,
//                         fontChineseNormalsimfang12));
//                 phrase2.add(new Chunk("日", fontChineseNormalsimfang12));
//                 phrase2.add(ChunkFactoryOld.underLine("", 24,
//                         fontChineseNormalsimfang12));
//                 phrase2.add(new Chunk("时", fontChineseNormalsimfang12));
//                 phrase2.add(ChunkFactoryOld.underLine("", 24,
//                         fontChineseNormalsimfang12));
//                 phrase2.add(new Chunk("分在", fontChineseNormalsimfang12));
//                phrase2.add(ChunkFactoryOld.underLine(book.getValue(6), 222,
//                        fontChineseNormalsimfang12,290,430));
//                phrase2.add(new Chunk("（公开、不公开）举行听证会议，请准时出席。", fontChineseNormalsimfang12));
//
//                paragraph1.add(phrase2);
////                paragraph1_1.add(phrase2_1);
//                document.add(paragraph1);
//                document.add(paragraph1_1);
//
//                final Paragraph paragraph2 = new Paragraph();
//                paragraph2.setIndentationLeft(24f);
//                paragraph2.setLeading(24f);
//                paragraph2.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase3 = new Phrase();
//                phrase3.add(new Chunk("听证主持人姓名：", fontChineseNormalsimfang12));
//                phrase3.add(ChunkFactoryOld
//                        .underLine(book.getValue(7), 84, fontChineseNormalsimfang12));
//                phrase3.add(new Chunk("职务：", fontChineseNormalsimfang12));
//                phrase3.add(ChunkFactoryOld.underLine(book.getValue(8), 168,
//                        fontChineseNormalsimfang12));
//                phrase3.add("\n");
//                phrase3.add(new Chunk("听证员姓名：", fontChineseNormalsimfang12));
//                phrase3.add(ChunkFactoryOld.underLine(book.getValue(9), 108,
//                        fontChineseNormalsimfang12));
//                phrase3.add(new Chunk("职务：", fontChineseNormalsimfang12));
//                phrase3.add(ChunkFactoryOld.underLine(book.getValue(10), 168,
//                        fontChineseNormalsimfang12));
//                phrase3.add("\n");
//                phrase3.add(new Chunk("听证员姓名：", fontChineseNormalsimfang12));
//                phrase3.add(ChunkFactoryOld.underLine(book.getValue(11), 108,
//                        fontChineseNormalsimfang12));
//                phrase3.add(new Chunk("职务：", fontChineseNormalsimfang12));
//                phrase3.add(ChunkFactoryOld.underLine(book.getValue(12), 168,
//                        fontChineseNormalsimfang12));
//                phrase3.add("\n");
//                phrase3.add(new Chunk("书记员姓名：", fontChineseNormalsimfang12));
//                phrase3.add(ChunkFactoryOld.underLine(book.getValue(13), 108,
//                        fontChineseNormalsimfang12));
//                phrase3.add(new Chunk("职务：", fontChineseNormalsimfang12));
//                phrase3.add(ChunkFactoryOld.underLine(book.getValue(14), 168,
//                        fontChineseNormalsimfang12));
//
//                paragraph2.add(phrase3);
//
//                document.add(paragraph2);
//
//                final Paragraph paragraph3 = new Paragraph();
//                paragraph3.setFirstLineIndent(24f);
//                paragraph3.setLeading(24f);
//                paragraph3.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase4 = new Phrase();
//                phrase4.add(new Chunk("根据《中华人民共和国行政处罚法》第四十二条规定，你（单位）可以申请听证主持人回避。",
//                        fontChineseNormalsimfang12));
//
//                paragraph3.add(phrase4);
//                document.add(paragraph3);
//
//                final Paragraph paragraph4 = new Paragraph();
//                paragraph4.setIndentationLeft(24f);
//                paragraph4.setLeading(24f);
//                paragraph4.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase5 = new Phrase();
//                phrase5.add(new Chunk("注意事项如下：", fontChineseNormalsimfang12));
//                phrase5.add("\n");
//                phrase5.add(new Chunk("1.请事先准备相关证据，通知证人和委托代理人准时参加。",
//                        fontChineseNormalsimfang12));
//                paragraph4.add(phrase5);
//
//                final Paragraph paragraph5 = new Paragraph();
//                paragraph5.setFirstLineIndent(24f);
//                paragraph5.setLeading(24f);
//                paragraph5.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase6 = new Phrase();
//                phrase6.add(new Chunk("2.委托代理人参加听证的，应当在听证会前向本行政机关提交授权委托书等有关证明。",
//                        fontChineseNormalsimfang12));
//                paragraph5.add(phrase6);
//
//                final Paragraph paragraph6 = new Paragraph();
//                paragraph6.setFirstLineIndent(24f);
//                paragraph6.setLeading(24f);
//                paragraph6.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase7 = new Phrase();
//                phrase7.add(new Chunk("3.申请延期举行的，应当在举行听证会前向本行政机关提出，由本行政机关决定是否延期。",
//                        fontChineseNormalsimfang12));
//                paragraph6.add(phrase7);
//
//                final Paragraph paragraph7 = new Paragraph();
//                paragraph7.setIndentationLeft(24f);
//                paragraph7.setLeading(24f);
//                paragraph7.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase8 = new Phrase();
//                phrase8.add(new Chunk("4.不按时参加听证会且未事先说明理由的，视为放弃听证权利。",
//                        fontChineseNormalsimfang12));
//                phrase8.add("\n");
//                phrase8.add(new Chunk("特此通知。", fontChineseNormalsimfang12));
//                paragraph7.add(phrase8);
//
//                document.add(paragraph4);
//                document.add(paragraph5);
//                document.add(paragraph6);
//                document.add(paragraph7);
//
//                final Paragraph paragraph8 = new Paragraph();
//                paragraph8.setFirstLineIndent(264f);
//                paragraph8.setLeading(24f);
//                paragraph8.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase9 = new Phrase();
//                phrase9.add(new Chunk("安全生产监督管理部门（公章）", fontChineseNormalsimfang12));
//                toMeasurefloat(phrase9);
//
//                paragraph8.add(phrase9);
//                document.add(paragraph8);
//
//                final Paragraph paragraph9 = new Paragraph();
//                paragraph9.setFirstLineIndent(264f);
//                paragraph9.setLeading(24f);
//                paragraph9.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase10 = new Phrase();
//                phrase10.add(ChunkFactoryOld.tablenounderLine(StringFactoryBuild.build().getTime(book.getValue(15), 0), 30,
//                        fontChineseNormalsimfang12));
//                phrase10.add(new Chunk("年", fontChineseNormalsimfang12));
//                phrase10.add(ChunkFactoryOld.tablenounderLine(StringFactoryBuild.build().getTime(book.getValue(15), 1), 12,
//                        fontChineseNormalsimfang12));
//                phrase10.add(new Chunk("月", fontChineseNormalsimfang12));
//                phrase10.add(ChunkFactoryOld.tablenounderLine(StringFactoryBuild.build().getTime(book.getValue(15), 2), 12,
//                        fontChineseNormalsimfang12));
//                phrase10.add(new Chunk("日", fontChineseNormalsimfang12));
//                toMeasurefloat(phrase10);
//
//                paragraph9.add(phrase10);
//                document.add(paragraph9);
//
//                final Paragraph paragraph10 = new Paragraph();
//                paragraph10.setIndentationLeft(24f);
//                paragraph10.setLeading(24f);
//                paragraph10.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase11 = new Phrase();
//                phrase11.add(new Chunk("安全生产监督管理部门地址：", fontChineseNormalsimfang12));
//                phrase11.add(ChunkFactoryOld.tablenounderLine(book.getValue(16), 240,
//                        fontChineseNormalsimfang12));
//                phrase11.add(new Chunk("\n邮 编：", fontChineseNormalsimfang12));
//                phrase11.add(ChunkFactoryOld.tablenounderLine(book.getValue(17), 336,
//                        fontChineseNormalsimfang12));
//                phrase11.add(new Chunk("\n联系人：", fontChineseNormalsimfang12));
//                phrase11.add(ChunkFactoryOld.tablenounderLine(book.getValue(18), 330,
//                        fontChineseNormalsimfang12));
//                phrase11.add(new Chunk("\n联系电话：", fontChineseNormalsimfang12));
//                phrase11.add(ChunkFactoryOld.tablenounderLine(book.getValue(19), 300,
//                        fontChineseNormalsimfang12));
//
//                paragraph10.add(phrase11);
//                document.add(paragraph10);
//
//                final Paragraph bottomLine1 = new Paragraph(
//                        new Chunk(new LineSeparator()));// 加入一个换行
//                bottomLine1.setLeading(1f);
//                bottomLine1.setSpacingBefore(5f);
//
//                document.add(bottomLine1);
//
//                final Paragraph paragraph11 = new Paragraph();
//                Phrase phrase12 = new Phrase();
//                phrase12.add(new Chunk("本文书一式两份：一份由安全生产监督管理部门备案，一份交申请听证人。",
//                        fontChineseNormalsimfang12));
//                paragraph11.add(phrase12);
//
//                document.add(paragraph11);
//                PdfContentByte canvas = dpfwPdfWriter.getDirectContent();
//
////                Phrase phrase18 = new Phrase();
////                phrase18.add(new Chunk("现定于", fontChineseNormalsimfang12));
////                phrase18.add(ChunkFactoryOld.underLine(StringFactoryBuild.build().getTime(book.getValue(5), 0), 60,
////                        fontChineseNormalsimfang12));
////                phrase18.add(new Chunk("年", fontChineseNormalsimfang12));
////                phrase18.add(ChunkFactoryOld.underLine(StringFactoryBuild.build().getTime(book.getValue(5), 1), 48,
////                        fontChineseNormalsimfang12));
////                phrase18.add(new Chunk("月", fontChineseNormalsimfang12));
////                phrase18.add(ChunkFactoryOld.underLine(StringFactoryBuild.build().getTime(book.getValue(5), 2), 48,
////                        fontChineseNormalsimfang12));
////                phrase18.add(new Chunk("日", fontChineseNormalsimfang12));
////                phrase18.add(ChunkFactoryOld.underLine(StringFactoryBuild.build().getTime(book.getValue(5), 3), 48,
////                        fontChineseNormalsimfang12));
////                phrase18.add(new Chunk("时", fontChineseNormalsimfang12));
////                phrase18.add(ChunkFactoryOld.underLine(StringFactoryBuild.build().getTime(book.getValue(5), 4), 48,
////                        fontChineseNormalsimfang12));
////                phrase18.add(new Chunk("分在", fontChineseNormalsimfang12));
////                ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phrase18,
////                        80, 608, 0);
//
//                PdfContentByte canvas2 = dpfwPdfWriter.getDirectContent();
//                // 电子签章
//                Image img = ImageBuilder.getInstance(image);
//                if (img != null) {
//                    img.setAbsolutePosition(350, 140);
//                    canvas2.addImage(img);
//                }
//                document.newPage();// 结束保存
//            }
//        });
//
//    }
//
//    //听证笔录
//    public void printerEntity_Book19(final Base_Entity book, final Object image) {
//        printFrameWork(book, image, new IPdfBackFrame() {
//            @Override
//            public void writeContent() throws Exception {
//                //此处写页面布局
//                final Paragraph title = new Paragraph("" + city + "安全生产行政执法文书", fontChineseBoldsimhei15);// Paragraph就是段落
//                title.setLeading(1f);// 段落距离
//                // title.setSpacingBefore(25f);//段落留白
//                title.setAlignment(Element.ALIGN_CENTER);// 居中
//                document.add(title);// 写入文档
//                final Paragraph titleLine1 = new Paragraph(new Chunk(new LineSeparator()));// 加入一个换行
//                titleLine1.setLeading(1f);
//                titleLine1.setSpacingBefore(5f);
//                document.add(titleLine1);
//                final Paragraph titleLine2 = new Paragraph(new Chunk(new LineSeparator()));
//                titleLine2.setLeading(1f);
//                titleLine2.setSpacingBefore(1f);
//                document.add(titleLine2);
//                final Paragraph title2 = new Paragraph("听证笔录", fontChineseBoldsimhei15);
//
//                title2.setLeading(1f);
//                title2.setSpacingBefore(17f);
//                title2.setAlignment(Element.ALIGN_CENTER);
//
//                document.add(title2);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//
//                final Paragraph paragraph1 = new Paragraph();
//                paragraph1.setIndentationLeft(24f);
//                paragraph1.setLeading(24f);
//                paragraph1.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase1 = new Phrase();
//                phrase1.add(new Chunk("案件名称：", fontChineseNormalsimfang12));
//                phrase1.add(ChunkFactoryOld.underLine(book.getValue(3), 330,
//                        fontChineseNormalsimfang12));
//                phrase1.add(new Chunk("主持听证机关：", fontChineseNormalsimfang12));
//                phrase1.add(ChunkFactoryOld
//                        .underLine(book.getValue(4), 96, fontChineseNormalsimfang12));
//                phrase1.add(new Chunk("地点：", fontChineseNormalsimfang12));
//                phrase1.add(ChunkFactoryOld.underLine(book.getValue(5), 162,
//                        fontChineseNormalsimfang12));
//                phrase1.add(new Chunk("听证时间：", fontChineseNormalsimfang12));
//                phrase1.add(ChunkFactoryOld
//                        .underLine(StringFactoryBuild.build().getTime(book.getValue(6), 0), 36, fontChineseNormalsimfang12));
//                phrase1.add(new Chunk("年", fontChineseNormalsimfang12));
//                phrase1.add(ChunkFactoryOld
//                        .underLine(StringFactoryBuild.build().getTime(book.getValue(6), 1), 12, fontChineseNormalsimfang12));
//                phrase1.add(new Chunk("月", fontChineseNormalsimfang12));
//                phrase1.add(ChunkFactoryOld
//                        .underLine(StringFactoryBuild.build().getTime(book.getValue(6), 2), 12, fontChineseNormalsimfang12));
//                phrase1.add(new Chunk("日", fontChineseNormalsimfang12));
//                phrase1.add(ChunkFactoryOld
//                        .underLine(StringFactoryBuild.build().getTime(book.getValue(6), 3), 12, fontChineseNormalsimfang12));
//                phrase1.add(new Chunk("时", fontChineseNormalsimfang12));
//                phrase1.add(ChunkFactoryOld
//                        .underLine(StringFactoryBuild.build().getTime(book.getValue(6), 4), 12, fontChineseNormalsimfang12));
//                phrase1.add(new Chunk("分至", fontChineseNormalsimfang12));
//                phrase1.add(ChunkFactoryOld
//                        .underLine(StringFactoryBuild.build().getTime(book.getValue(7), 2), 12, fontChineseNormalsimfang12));
//                phrase1.add(new Chunk("日", fontChineseNormalsimfang12));
//                phrase1.add(ChunkFactoryOld
//                        .underLine(StringFactoryBuild.build().getTime(book.getValue(7), 3), 12, fontChineseNormalsimfang12));
//                phrase1.add(new Chunk("时", fontChineseNormalsimfang12));
//                phrase1.add(ChunkFactoryOld
//                        .underLine(StringFactoryBuild.build().getTime(book.getValue(7), 4), 12, fontChineseNormalsimfang12));
//                phrase1.add(new Chunk("分", fontChineseNormalsimfang12));
//                phrase1.add("\n");
//
//                phrase1.add(new Chunk("听证主持人：", fontChineseNormalsimfang12));
//                phrase1.add(ChunkFactoryOld
//                        .underLine(book.getValue(8), 60, fontChineseNormalsimfang12));
//                phrase1.add(new Chunk("听证员：", fontChineseNormalsimfang12));
//                phrase1.add(ChunkFactoryOld.underLine(book.getValue(9), 108,
//                        fontChineseNormalsimfang12));
//                phrase1.add(new Chunk("书记员：", fontChineseNormalsimfang12));
//                phrase1.add(ChunkFactoryOld
//                        .underLine(book.getValue(10), 30, fontChineseNormalsimfang12));
//                phrase1.add("\n");
//
//                phrase1.add(new Chunk("调查人员：", fontChineseNormalsimfang12));
//                phrase1.add(ChunkFactoryOld
//                        .underLine(book.getValue(11), 36, fontChineseNormalsimfang12));
//                phrase1.add(new Chunk("证号：", fontChineseNormalsimfang12));
//                phrase1.add(ChunkFactoryOld
//                        .underLine(book.getValue(12), 36, fontChineseNormalsimfang12));
//                phrase1.add(new Chunk("调查人员：", fontChineseNormalsimfang12));
//                phrase1.add(ChunkFactoryOld
//                        .underLine(book.getValue(13), 60, fontChineseNormalsimfang12));
//                phrase1.add(new Chunk("证号：", fontChineseNormalsimfang12));
//                phrase1.add(ChunkFactoryOld
//                        .underLine(book.getValue(14), 30, fontChineseNormalsimfang12));
//
//                phrase1.add(new Chunk("申请听证单位法定代表人姓名：", fontChineseNormalsimfang12));
//                phrase1.add(ChunkFactoryOld
//                        .underLine(book.getValue(15), 66, fontChineseNormalsimfang12));
//                phrase1.add(new Chunk("性别：", fontChineseNormalsimfang12));
//                phrase1.add(ChunkFactoryOld
//                        .underLine(book.getValue(16), 42, fontChineseNormalsimfang12));
//                phrase1.add(new Chunk("年龄：", fontChineseNormalsimfang12));
//                phrase1.add(ChunkFactoryOld
//                        .underLine(book.getValue(17), 18, fontChineseNormalsimfang12));
//
//                phrase1.add(new Chunk("工作单位（职务）：", fontChineseNormalsimfang12));
//                phrase1.add(ChunkFactoryOld.underLine(book.getValue(12), 282,
//                        fontChineseNormalsimfang12));
//
//                phrase1.add(new Chunk("委托代理人：", fontChineseNormalsimfang12));
//                phrase1.add(ChunkFactoryOld
//                        .underLine(book.getValue(19), 36, fontChineseNormalsimfang12));
//                phrase1.add(new Chunk("性别：", fontChineseNormalsimfang12));
//                phrase1.add(ChunkFactoryOld
//                        .underLine(book.getValue(20), 18, fontChineseNormalsimfang12));
//                phrase1.add(new Chunk("年龄：", fontChineseNormalsimfang12));
//                phrase1.add(ChunkFactoryOld
//                        .underLine(book.getValue(21), 18, fontChineseNormalsimfang12));
//                phrase1.add(new Chunk("工作单位（职务）：", fontChineseNormalsimfang12));
//                phrase1.add(ChunkFactoryOld
//                        .underLine(book.getValue(22), 30, fontChineseNormalsimfang12));
//
//                phrase1.add(new Chunk("委托代理人：", fontChineseNormalsimfang12));
//                phrase1.add(ChunkFactoryOld
//                        .underLine(book.getValue(23), 36, fontChineseNormalsimfang12));
//                phrase1.add(new Chunk("性别：", fontChineseNormalsimfang12));
//                phrase1.add(ChunkFactoryOld
//                        .underLine(book.getValue(24), 18, fontChineseNormalsimfang12));
//                phrase1.add(new Chunk("年龄：", fontChineseNormalsimfang12));
//                phrase1.add(ChunkFactoryOld
//                        .underLine(book.getValue(25), 18, fontChineseNormalsimfang12));
//                phrase1.add(new Chunk("工作单位（职务）：", fontChineseNormalsimfang12));
//                phrase1.add(ChunkFactoryOld
//                        .underLine(book.getValue(26), 30, fontChineseNormalsimfang12));
//
//                phrase1.add(new Chunk("第三人：", fontChineseNormalsimfang12));
//                phrase1.add(ChunkFactoryOld.underLine(book.getValue(27), 342,
//                        fontChineseNormalsimfang12));
//                phrase1.add(new Chunk("其他参与人员：", fontChineseNormalsimfang12));
//                phrase1.add(ChunkFactoryOld.underLine(book.getValue(28), 306,
//                        fontChineseNormalsimfang12));
//
//                paragraph1.add(phrase1);
//                document.add(paragraph1);
//
//                final Paragraph paragraph2 = new Paragraph();
//                paragraph2.setFirstLineIndent(24f);
//                paragraph2.setLeading(24f);
//                paragraph2.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase2 = new Phrase();
//                 phrase2.add(new Chunk("听证记录：", fontChineseNormalsimfang12));
//                phrase2.add(ChunkFactoryOld.underLine(book.getValue(29), 3786,
//                        fontChineseNormalsimfang12,84,430));
//
//                paragraph2.add(phrase2);
//                document.add(paragraph2);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//
//                final Paragraph paragraph3 = new Paragraph();
//                paragraph3.setIndentationLeft(24f);
//                paragraph3.setLeading(24f);
//                paragraph3.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase3 = new Phrase();
//                phrase3.add(new Chunk("申请听证单位法定代表人或其委托代理人（签名）：", fontChineseNormalsimfang12));
//                phrase3.add(ChunkFactoryOld.tablenounderLine(book.getValue(30), 84,
//                        fontChineseNormalsimfang12));
//                phrase3.add("\n");
//
//                phrase3.add(new Chunk("听证主持人（签名）：", fontChineseNormalsimfang12));
//                phrase3.add(ChunkFactoryOld.tablenounderLine(book.getValue(31), 84,
//                        fontChineseNormalsimfang12));
//                phrase3.add(new Chunk("书记员（签名）：", fontChineseNormalsimfang12));
//                phrase3.add(ChunkFactoryOld.tablenounderLine(book.getValue(32), 72,
//                        fontChineseNormalsimfang12));
//
//                phrase3.add(ChunkFactoryOld.tablenounderLine("", 300,
//                        fontChineseNormalsimfang12));
//                phrase3.add(ChunkFactoryOld.tablenounderLine(StringFactoryBuild.build().getTime(book.getValue(33), 0), 12,
//                        fontChineseNormalsimfang12));
//                phrase3.add(new Chunk("年", fontChineseNormalsimfang12));
//                phrase3.add(ChunkFactoryOld.tablenounderLine(StringFactoryBuild.build().getTime(book.getValue(33), 1), 12,
//                        fontChineseNormalsimfang12));
//                phrase3.add(new Chunk("月", fontChineseNormalsimfang12));
//                phrase3.add(ChunkFactoryOld.tablenounderLine(StringFactoryBuild.build().getTime(book.getValue(33), 2), 12,
//                        fontChineseNormalsimfang12));
//                phrase3.add(new Chunk("日", fontChineseNormalsimfang12));
//
//                paragraph3.add(phrase3);
//                document.add(paragraph3);
//
//                final Paragraph bottomLine1 = new Paragraph(
//                        new Chunk(new LineSeparator()));// 加入一个换行
//                bottomLine1.setLeading(1f);
//                bottomLine1.setSpacingBefore(5f);
//
//                document.add(bottomLine1);
//
//                // final Paragraph paragraph5 = new Paragraph();
//                // Phrase phrase17 = new Phrase();
//
//                // phrase17.add(Help_Pdf_Help.tablenounderLine("", 72,
//                // fontChineseKNormal));
//                // phrase17.add(new Chunk("共",fontChineseKNormal));
//                // phrase17.add(Help_Pdf_Help.tablenounderLine("", 4,
//                // fontChineseKNormal));
//                // phrase17.add(new Chunk("页",fontChineseKNormal));
//                // phrase17.add(Help_Pdf_Help.tablenounderLine("", 5,
//                // fontChineseKNormal));
//                // phrase17.add(new Chunk("第",fontChineseKNormal));
//                // phrase17.add(Help_Pdf_Help.tablenounderLine("", 4,
//                // fontChineseKNormal));
//                // phrase17.add(new Chunk("页",fontChineseKNormal));
//                // paragraph5.add(phrase17);
//
//                // document.add(paragraph5);
//                PdfContentByte canvas = dpfwPdfWriter.getDirectContent();
//
////                Phrase phrase18 = new Phrase();
////
////                phrase18.add(new Chunk("听证记录：", fontChineseNormalsimfang12));
////                ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phrase18,
////                        104, 397, 0);
//                PdfContentByte canvas2 = dpfwPdfWriter.getDirectContent();
//                // 电子签章
//                Image img = ImageBuilder.getInstance(image);
//                if (img != null) {
//                    img.setAbsolutePosition(350, 140);
//                    canvas2.addImage(img);
//                }
//                document.newPage();// 结束保存
//            }
//        });
//
//    }
//
//    //听证会报告书
//    public void printerEntity_Book20(final Base_Entity book, final Object image) {
//        printFrameWork(book, image, new IPdfBackFrame() {
//            @Override
//            public void writeContent() throws Exception {
//                //此处写页面布局
//                final Paragraph title = new Paragraph("" + city + "安全生产行政执法文书", fontChineseBoldsimhei15);// Paragraph就是段落
//                title.setLeading(1f);// 段落距离
//                // title.setSpacingBefore(25f);//段落留白
//                title.setAlignment(Element.ALIGN_CENTER);// 居中
//                document.add(title);// 写入文档
//                final Paragraph titleLine1 = new Paragraph(new Chunk(new LineSeparator()));// 加入一个换行
//                titleLine1.setLeading(1f);
//                titleLine1.setSpacingBefore(5f);
//                document.add(titleLine1);
//                final Paragraph titleLine2 = new Paragraph(new Chunk(new LineSeparator()));
//                titleLine2.setLeading(1f);
//                titleLine2.setSpacingBefore(1f);
//                document.add(titleLine2);
//                final Paragraph title2 = new Paragraph("听证会报告书", fontChineseBoldsimhei15);
//
//                title2.setLeading(1f);
//                title2.setSpacingBefore(17f);
//                title2.setAlignment(Element.ALIGN_CENTER);
//                document.add(title2);
//                document.add(space2);
//
//                final Paragraph title3 = new Paragraph("( " + book.getValue(0) + " )安监管听报〔" + book.getValue(1) + "〕"
//                        + book.getValue(2) + "号", fontChineseNormalsimfang12);
//                title3.setLeading(1f);
//                title3.setSpacingBefore(34f);
//                title3.setAlignment(Element.ALIGN_CENTER);
//                document.add(title3);
//
//                document.add(space1);
//
//                final Paragraph paragraph1 = new Paragraph();
//                paragraph1.setLeading(24f);
//                paragraph1.setIndentationLeft(2f);
//                paragraph1.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase1 = new Phrase();
//                phrase1.add(new Chunk("案件名称:", fontChineseNormalsimfang12));
//                phrase1.add(ChunkFactoryOld.underLine(book.getValue(3), 360,
//                        fontChineseNormalsimfang12));
//
//                paragraph1.add(phrase1);
//                document.add(paragraph1);
//                document.add(space2);
//
//                // 表格start
//                PdfPTable table = new PdfPTable(1);
//                table.setWidthPercentage(100f);
//
//                PdfPCell lin01 = new PdfPCell();
//                final Paragraph lin01p0 = new Paragraph("听证\n主持人", fontChineseNormalsimfang12);
//                lin01p0.setAlignment(Element.ALIGN_CENTER);
//                lin01.addElement(lin01p0);
//
//                PdfPCell lin02 = new PdfPCell();
//                final Paragraph lin02p0 = new Paragraph();
//
//                Phrase phrase02p0 = new Phrase();
//                phrase02p0.add(ChunkFactoryOld.tablenounderLine(book.getValue(4), 90, fontChineseNormalsimfang12));
//                lin02p0.add(phrase02p0);
//
//
//                lin02.addElement(lin02p0);
//
//                PdfPCell lin03 = new PdfPCell();
//                final Paragraph lin03p0 = new Paragraph("听证员", fontChineseNormalsimfang12);
//                lin03p0.setAlignment(Element.ALIGN_CENTER);
//                lin03.addElement(lin03p0);
//
//                PdfPCell lin04 = new PdfPCell();
//                final Paragraph lin04p0 = new Paragraph();
//
//                Phrase phrase04p0 = new Phrase();
//                phrase04p0.add(ChunkFactoryOld.tablenounderLine(book.getValue(5), 90, fontChineseNormalsimfang12));
//                lin04p0.add(phrase04p0);
//
//                lin04.addElement(lin04p0);
//
//                PdfPCell lin05 = new PdfPCell();
//                final Paragraph lin05p0 = new Paragraph("书记员", fontChineseNormalsimfang12);
//                lin05p0.setAlignment(Element.ALIGN_CENTER);
//                lin05.addElement(lin05p0);
//
//                PdfPCell lin06 = new PdfPCell();
//                final Paragraph lin06p0 = new Paragraph();
//
//                Phrase phrase06p0 = new Phrase();
//                phrase06p0.add(ChunkFactoryOld.tablenounderLine(book.getValue(6), 90, fontChineseNormalsimfang12));
//                lin06p0.add(phrase06p0);
//
//                lin06.addElement(lin06p0);
//
//                PdfPTable celltable0 = new PdfPTable(6);
//                float[] celltable0float = new float[6];
//                celltable0float[0] = 2f;
//                celltable0float[1] = 4f;
//                celltable0float[2] = 2f;
//                celltable0float[3] = 4f;
//                celltable0float[4] = 2f;
//                celltable0float[5] = 3f;
//                celltable0.setTotalWidth(celltable0float);
//                celltable0.addCell(lin01);
//                celltable0.addCell(lin02);
//                celltable0.addCell(lin03);
//                celltable0.addCell(lin04);
//                celltable0.addCell(lin05);
//                celltable0.addCell(lin06);
//                PdfPCell row0 = new PdfPCell(celltable0);
//                row0.setFixedHeight(40f);
//                table.addCell(row0);
//                float[] celltable1float = new float[2];
//                celltable1float[0] = 2f;
//                celltable1float[1] = 20f;
//
//                PdfPCell lin21 = new PdfPCell();
//                final Paragraph lin21p0 = new Paragraph();
//                Phrase phrase2 = new Phrase();
//                phrase2.add(new Chunk("听证会基本情况摘要：（详见听证会笔录，笔录附后）",
//                        fontChineseNormalsimfang12));
//                phrase2.add("\n");
//                phrase2.add(ChunkFactoryOld.tablenounderLine(book.getValue(7), 2232,
//                        fontChineseNormalsimfang12));
//                lin21p0.add(phrase2);
//                lin21p0.setAlignment(Element.ALIGN_LEFT);
//                lin21.addElement(lin21p0);
//                PdfPTable cellTable2 = new PdfPTable(1);
//                cellTable2.setWidths(new float[]{100f});
//                cellTable2.addCell(lin21);
//                PdfPCell row2 = new PdfPCell(cellTable2);
//                row2.setFixedHeight(310f);
//                table.addCell(row2);
//
//                PdfPCell lin31 = new PdfPCell();
//                PdfPCell lin31_1 = new PdfPCell();
//                PdfPCell lin31_2 = new PdfPCell();
//                lin31_1.setFixedHeight(50f);
//                lin31_1.setBorder(0);
//                lin31_2.setBorder(0);
//                lin31_2.setFixedHeight(24f);
//                final Paragraph lin31p0 = new Paragraph("\n听证\n主持\n人意\n见  ",
//                        fontChineseNormalsimfang12);
//                lin31p0.setAlignment(Element.ALIGN_LEFT);
//                lin31.addElement(lin31p0);
//
//                final Paragraph lin32p0 = new Paragraph();
//                final Paragraph lin32p01 = new Paragraph();
//                lin32p0.setFirstLineIndent(23f);
//                lin32p0.setLeading(23f);
//                lin32p0.setAlignment(Element.ALIGN_LEFT);
//                Phrase phrase3 = new Phrase();
//                Phrase phrase3_1 = new Phrase();
//                phrase3.add(ChunkFactoryOld.tablenounderLine(book.getValue(8), 2832,
//                        fontChineseNormalsimfang12));
//                phrase3_1.add(ChunkFactoryOld.tablenounderLine("", 168,
//                        fontChineseNormalsimfang12));
//                phrase3_1.add(new Chunk("听证主持人（签名）：", fontChineseNormalsimfang12));
//                phrase3_1.add(ChunkFactoryOld.tablenounderLine(book.getValue(9), 176,
//                        fontChineseNormalsimfang12));
//                phrase3_1.add(ChunkFactoryOld.tablenounderLine("\u00a0",
//                        240, fontChineseNormalsimfang12));
//                phrase3_1.add(ChunkFactoryOld.tablenounderLine(StringFactoryBuild.build().getTime(book.getValue(10), 0), 12,
//                        fontChineseNormalsimfang12));
//                phrase3_1.add(new Chunk("年", fontChineseNormalsimfang12));
//                phrase3_1.add(ChunkFactoryOld.tablenounderLine(StringFactoryBuild.build().getTime(book.getValue(10), 1), 12,
//                        fontChineseNormalsimfang12));
//                phrase3_1.add(new Chunk("月", fontChineseNormalsimfang12));
//                phrase3_1.add(ChunkFactoryOld.tablenounderLine(StringFactoryBuild.build().getTime(book.getValue(10), 2), 12,
//                        fontChineseNormalsimfang12));
//                phrase3_1.add(new Chunk("日", fontChineseNormalsimfang12));
//                lin32p0.add(phrase3);
//                lin32p01.add(phrase3_1);
//                lin31_1.addElement(lin32p0);
//                lin31_2.addElement(phrase3_1);
//
//                PdfPTable cellTable3_2 = new PdfPTable(1);
//
//                cellTable3_2.addCell(lin31_1);
//                cellTable3_2.addCell(lin31_2);
//                PdfPCell lin32 = new PdfPCell(cellTable3_2);
//                PdfPTable cellTable3 = new PdfPTable(2);
//                cellTable3.setWidths(celltable1float);
//                cellTable3.addCell(lin31);
//                cellTable3.addCell(lin32);
//                PdfPCell row3 = new PdfPCell(cellTable3);
//                row3.setFixedHeight(95f);
//                table.addCell(row3);
//
//                PdfPCell lin41 = new PdfPCell();
//                PdfPCell lin41_1 = new PdfPCell();
//                PdfPCell lin41_2 = new PdfPCell();
//                lin41_1.setFixedHeight(50f);
//                lin41_1.setBorder(0);
//                lin41_2.setBorder(0);
//                lin41_2.setFixedHeight(24f);
//                final Paragraph lin41p0 = new Paragraph("\n负责\n人审\n核意\n见  ",
//                        fontChineseNormalsimfang12);
//                lin41p0.setAlignment(Element.ALIGN_LEFT);
//                lin41.addElement(lin41p0);
//
//                final Paragraph lin42p0 = new Paragraph();
//                final Paragraph lin42p01 = new Paragraph();
//                lin42p0.setFirstLineIndent(24f);
//                lin42p0.setLeading(24f);
//                lin42p0.setAlignment(Element.ALIGN_LEFT);
//                Phrase phrase4 = new Phrase();
//                Phrase phrase4_1 = new Phrase();
//                phrase4.add(ChunkFactoryOld.tablenounderLine(book.getValue(11), 2832,
//                        fontChineseNormalsimfang12));
//                phrase4_1.add(ChunkFactoryOld.tablenounderLine("", 168,
//                        fontChineseNormalsimfang12));
//                phrase4_1.add(new Chunk("负责人（签名）：", fontChineseNormalsimfang12));
//                phrase4_1.add(ChunkFactoryOld.tablenounderLine(book.getValue(12), 176,
//                        fontChineseNormalsimfang12));
//                phrase4_1.add(ChunkFactoryOld.tablenounderLine("\u00a0",
//                        240, fontChineseNormalsimfang12));
//                phrase4_1.add(ChunkFactoryOld.tablenounderLine(StringFactoryBuild.build().getTime(book.getValue(13), 0), 12,
//                        fontChineseNormalsimfang12));
//                phrase4_1.add(new Chunk("年", fontChineseNormalsimfang12));
//                phrase4_1.add(ChunkFactoryOld.tablenounderLine(StringFactoryBuild.build().getTime(book.getValue(13), 1), 12,
//                        fontChineseNormalsimfang12));
//                phrase4_1.add(new Chunk("月", fontChineseNormalsimfang12));
//                phrase4_1.add(ChunkFactoryOld.tablenounderLine(StringFactoryBuild.build().getTime(book.getValue(13), 2), 12,
//                        fontChineseNormalsimfang12));
//                phrase4_1.add(new Chunk("日", fontChineseNormalsimfang12));
//                lin42p0.add(phrase4);
//                lin42p01.add(phrase4_1);
//                lin41_1.addElement(lin42p0);
//                lin41_2.addElement(phrase4_1);
//
//                PdfPTable cellTable4_2 = new PdfPTable(1);
//
//                cellTable4_2.addCell(lin41_1);
//                cellTable4_2.addCell(lin41_2);
//                PdfPCell lin42 = new PdfPCell(cellTable4_2);
//                PdfPTable cellTable4 = new PdfPTable(2);
//                cellTable4.setWidths(celltable1float);
//                cellTable4.addCell(lin41);
//                cellTable4.addCell(lin42);
//                PdfPCell row4 = new PdfPCell(cellTable4);
//                row4.setFixedHeight(95f);
//                table.addCell(row4);
//
//                document.add(table);
//                document.add(space1);
//                // 表格end
//
//                PdfContentByte canvas2 = dpfwPdfWriter.getDirectContent();
//                // 电子签章
//                Image img = ImageBuilder.getInstance(image);
//                if (img != null) {
//                    img.setAbsolutePosition(350, 140);
//                    canvas2.addImage(img);
//                }
//                document.newPage();
//            }
//        });
//
//    }
//
//    //案件处理呈批表
//    public void printerEntity_Book21(final Base_Entity book, final Object image) {
//        printFrameWork(book, image, new IPdfBackFrame() {
//            @Override
//            public void writeContent() throws Exception {
//                //此处写页面布局
//                final Paragraph title = new Paragraph("" + city + "安全生产行政执法文书", fontChineseBoldsimhei15);// Paragraph就是段落
//                title.setLeading(1f);// 段落距离
//                // title.setSpacingBefore(25f);//段落留白
//                title.setAlignment(Element.ALIGN_CENTER);// 居中
//                document.add(title);// 写入文档
//                final Paragraph titleLine1 = new Paragraph(new Chunk(new LineSeparator()));// 加入一个换行
//                titleLine1.setLeading(1f);
//                titleLine1.setSpacingBefore(5f);
//                document.add(titleLine1);
//                final Paragraph titleLine2 = new Paragraph(new Chunk(new LineSeparator()));
//                titleLine2.setLeading(1f);
//                titleLine2.setSpacingBefore(1f);
//                document.add(titleLine2);
//                final Paragraph title2 = new Paragraph("案件处理呈批表", fontChineseBoldsimhei15);
//
//                title2.setLeading(1f);
//                title2.setSpacingBefore(17f);
//                title2.setAlignment(Element.ALIGN_CENTER);
//                document.add(title2);
//                document.add(space2);
//
//                final Paragraph title3 = new Paragraph("( " + book.getValue(0) + " )安监管处呈〔" + book.getValue(1) + "〕"
//                        + book.getValue(1) + "号", fontChineseNormalsimfang12);
//                title3.setLeading(1f);
//                title3.setSpacingBefore(34f);
//                title3.setAlignment(Element.ALIGN_CENTER);
//                document.add(title3);
//
//                document.add(space1);
//
//                final Paragraph paragraph1 = new Paragraph();
//                paragraph1.setLeading(24f);
//                paragraph1.setIndentationLeft(2f);
//                paragraph1.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase1 = new Phrase();
//                phrase1.add(new Chunk("案件名称:", fontChineseNormalsimfang12));
//                phrase1.add(ChunkFactoryOld.underLine(book.getValue(3), 366,
//                        fontChineseNormalsimfang12));
//
//                paragraph1.add(phrase1);
//                document.add(paragraph1);
//                document.add(space2);
//
//                // 表格start
//                PdfPTable table = new PdfPTable(1);
//                table.setWidthPercentage(100f);
//
//                PdfPCell lin01 = new PdfPCell();
//                final Paragraph lin01p0 = new Paragraph("\n当事\n人基\n本情\n况",
//                        fontChineseNormalsimfang12);
//                lin01p0.setAlignment(Element.ALIGN_CENTER);
//                lin01.addElement(lin01p0);
//
//                PdfPTable table1 = new PdfPTable(1);
//                PdfPCell lin02 = new PdfPCell(table1);
//                PdfPCell cell1 = new PdfPCell(new Phrase(new Chunk("被处罚单位",
//                        fontChineseNormalsimfang12)));
//                cell1.setFixedHeight(24f);
//                PdfPCell cell2 = new PdfPCell(new Phrase(new Chunk("法定代表人",
//                        fontChineseNormalsimfang12)));
//                cell2.setFixedHeight(24f);
//                PdfPCell cell3 = new PdfPCell(new Phrase(new Chunk("被处罚人",
//                        fontChineseNormalsimfang12)));
//                cell3.setFixedHeight(24f);
//                PdfPCell cell4 = new PdfPCell(new Phrase(new Chunk("所在单位",
//                        fontChineseNormalsimfang12)));
//                cell4.setFixedHeight(24f);
//                PdfPCell cell5 = new PdfPCell(new Phrase(new Chunk("家庭住址",
//                        fontChineseNormalsimfang12)));
//                cell5.setFixedHeight(24f);
//                table1.addCell(cell1);
//                table1.addCell(cell2);
//                table1.addCell(cell3);
//                table1.addCell(cell4);
//                table1.addCell(cell5);
//
//                PdfPTable table2 = new PdfPTable(1);
//                PdfPCell lin03 = new PdfPCell(table2);
//                PdfPCell cell11 = new PdfPCell(new Phrase(
//                        ChunkFactoryOld.tablenounderLine(book.getValue(4), 10,
//                                fontChineseNormalsimfang12)));
//                cell11.setFixedHeight(24f);
//                PdfPCell cell12 = new PdfPCell(new Phrase(
//                        ChunkFactoryOld.tablenounderLine(book.getValue(6), 10,
//                                fontChineseNormalsimfang12)));
//                cell12.setFixedHeight(24f);
//                PdfPCell cell13 = new PdfPCell(new Phrase(
//                        ChunkFactoryOld.tablenounderLine(book.getValue(9), 10,
//                                fontChineseNormalsimfang12)));
//                cell13.setFixedHeight(24f);
//                PdfPCell cell14 = new PdfPCell(new Phrase(
//                        ChunkFactoryOld.tablenounderLine(book.getValue(12), 10,
//                                fontChineseNormalsimfang12)));
//                cell14.setFixedHeight(24f);
//                PdfPCell cell15 = new PdfPCell(new Phrase(
//                        ChunkFactoryOld.tablenounderLine(book.getValue(14), 10,
//                                fontChineseNormalsimfang12)));
//                cell15.setFixedHeight(24f);
//                table2.addCell(cell11);
//                table2.addCell(cell12);
//                table2.addCell(cell13);
//                table2.addCell(cell14);
//                table2.addCell(cell15);
//
//                PdfPTable table3 = new PdfPTable(1);
//                PdfPCell lin04 = new PdfPCell(table3);
//                PdfPCell cell21 = new PdfPCell(new Phrase(new Chunk("地址",
//                        fontChineseNormalsimfang12)));
//                cell21.setFixedHeight(24f);
//                PdfPCell cell22 = new PdfPCell(new Phrase(new Chunk("职务",
//                        fontChineseNormalsimfang12)));
//                cell22.setFixedHeight(24f);
//                PdfPCell cell23 = new PdfPCell(new Phrase(new Chunk("年龄",
//                        fontChineseNormalsimfang12)));
//                cell23.setFixedHeight(24f);
//                PdfPCell cell24 = new PdfPCell(new Phrase(new Chunk("单位地址",
//                        fontChineseNormalsimfang12)));
//                cell24.setFixedHeight(24f);
//                PdfPCell cell25 = new PdfPCell(new Phrase(new Chunk("联系电话",
//                        fontChineseNormalsimfang12)));
//                cell25.setFixedHeight(24f);
//                table3.addCell(cell21);
//                table3.addCell(cell22);
//                table3.addCell(cell23);
//                table3.addCell(cell24);
//                table3.addCell(cell25);
//
//                PdfPTable table4 = new PdfPTable(1);
//                PdfPCell lin05 = new PdfPCell(table4);
//                PdfPCell cell31 = new PdfPCell(new Phrase(
//                        ChunkFactoryOld.tablenounderLine(book.getValue(5), 15,
//                                fontChineseNormalsimfang12)));
//                cell31.setFixedHeight(24f);
//
//                PdfPTable table41 = new PdfPTable(3);
//                PdfPCell cell32 = new PdfPCell(table41);
//                cell32.setFixedHeight(24f);
//                PdfPCell c1 = new PdfPCell(new Phrase(
//                        ChunkFactoryOld.tablenounderLine(book.getValue(7), 6,
//                                fontChineseNormalsimfang12)));
//                PdfPCell c2 = new PdfPCell(new Phrase(new Chunk("邮编",
//                        fontChineseNormalsimfang12)));
//                PdfPCell c3 = new PdfPCell(new Phrase(
//                        ChunkFactoryOld.tablenounderLine(book.getValue(16), 6,
//                                fontChineseNormalsimfang12)));
//                table41.addCell(c1);
//                table41.addCell(c2);
//                table41.addCell(c3);
//
//                PdfPTable table42 = new PdfPTable(3);
//                PdfPCell cell33 = new PdfPCell(table42);
//                cell33.setFixedHeight(24f);
//                PdfPCell a1 = new PdfPCell(new Phrase(
//                        ChunkFactoryOld.tablenounderLine(book.getValue(10), 6,
//                                fontChineseNormalsimfang12)));
//                PdfPCell a2 = new PdfPCell(new Phrase(new Chunk("性别",
//                        fontChineseNormalsimfang12)));
//                PdfPCell a3 = new PdfPCell(new Phrase(
//                        ChunkFactoryOld.tablenounderLine(book.getValue(11), 6,
//                                fontChineseNormalsimfang12)));
//                table42.addCell(a1);
//                table42.addCell(a2);
//                table42.addCell(a3);
//
//                PdfPTable table43 = new PdfPTable(1);
//                PdfPCell cell34 = new PdfPCell(new Phrase(
//                        ChunkFactoryOld.tablenounderLine(book.getValue(13), 15,
//                                fontChineseNormalsimfang12)));
//                cell34.setFixedHeight(24f);
//
//                PdfPTable table44 = new PdfPTable(3);
//                PdfPCell cell35 = new PdfPCell(table44);
//                cell35.setFixedHeight(24f);
//                PdfPCell b1 = new PdfPCell(new Phrase(
//                        ChunkFactoryOld.tablenounderLine(book.getValue(15), 6,
//                                fontChineseNormalsimfang12)));
//                PdfPCell b2 = new PdfPCell(new Phrase(new Chunk("邮编",
//                        fontChineseNormalsimfang12)));
//                PdfPCell b3 = new PdfPCell(new Phrase(
//                        ChunkFactoryOld.tablenounderLine(book.getValue(16), 6,
//                                fontChineseNormalsimfang12)));
//                table44.addCell(b1);
//                table44.addCell(b2);
//                table44.addCell(b3);
//
//                table4.addCell(cell31);
//                table4.addCell(cell32);
//                table4.addCell(cell33);
//                table4.addCell(cell34);
//                table4.addCell(cell35);
//
//                PdfPTable celltable0 = new PdfPTable(5);
//                float[] celltable0float = new float[5];
//                celltable0float[0] = 2f;
//                celltable0float[1] = 4f;
//                celltable0float[2] = 6f;
//                celltable0float[3] = 3f;
//                celltable0float[4] = 6f;
//                celltable0.setTotalWidth(celltable0float);
//                celltable0.addCell(lin01);
//                celltable0.addCell(lin02);
//                celltable0.addCell(lin03);
//                celltable0.addCell(lin04);
//                celltable0.addCell(lin05);
//                PdfPCell row0 = new PdfPCell(celltable0);
//                row0.setFixedHeight(120f);
//                table.addCell(row0);
//
//                PdfPCell lin21 = new PdfPCell();
//                final Paragraph lin21p0 = new Paragraph("违法\n事实\n及处\n罚依\n据\0",
//                        fontChineseNormalsimfang12);
//                lin21p0.setAlignment(Element.ALIGN_CENTER);
//                lin21.addElement(lin21p0);
//                PdfPCell lin22 = new PdfPCell();
//                final Paragraph lin22p0 = new Paragraph("", fontChineseNormalsimfang12);
//                lin22p0.setFirstLineIndent(24f);
//                lin22p0.setLeading(24f);
//                lin22p0.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase22p0 = new Phrase();
//                phrase22p0.add(ChunkFactoryOld.tablenounderLine(book.getValue(17), 1116, fontChineseNormalsimfang12));
//                lin22p0.add(phrase22p0);
//
//                lin22.addElement(lin22p0);
//                PdfPTable cellTable2 = new PdfPTable(2);
//                float[] celltable1float = new float[2];
//                celltable1float[0] = 2f;
//                celltable1float[1] = 19f;
//                cellTable2.setWidths(celltable1float);
//                cellTable2.addCell(lin21);
//                cellTable2.addCell(lin22);
//                PdfPCell row2 = new PdfPCell(cellTable2);
//                row2.setFixedHeight(104f);
//                table.addCell(row2);
//
//                PdfPCell lin31 = new PdfPCell();
//                final Paragraph lin31p0 = new Paragraph("当事\n人的\n申辩\n意见",
//                        fontChineseNormalsimfang12);
//                lin31p0.setAlignment(Element.ALIGN_CENTER);
//                lin31.addElement(lin31p0);
//                PdfPCell lin32 = new PdfPCell();
//                final Paragraph lin32p0 = new Paragraph("", fontChineseNormalsimfang12);
//                lin32p0.setFirstLineIndent(24f);
//                lin32p0.setLeading(24f);
//                lin32p0.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase32p0 = new Phrase();
//                phrase32p0.add(ChunkFactoryOld.tablenounderLine(book.getValue(18), 1116, fontChineseNormalsimfang12));
//                lin32p0.add(phrase32p0);
//
//                lin32.addElement(lin32p0);
//                PdfPTable cellTable3 = new PdfPTable(2);
//                cellTable3.setWidths(celltable1float);
//                cellTable3.addCell(lin31);
//                cellTable3.addCell(lin32);
//                PdfPCell row3 = new PdfPCell(cellTable3);
//                row3.setFixedHeight(102f);
//                table.addCell(row3);
//
//                PdfPCell lin41 = new PdfPCell();
//                final Paragraph lin41p0 = new Paragraph("\n承办\n人意\n件", fontChineseNormalsimfang12);
//                lin41p0.setAlignment(Element.ALIGN_CENTER);
//                lin41.addElement(lin41p0);
//                PdfPTable cellTable4_2 = new PdfPTable(1);
//                PdfPCell lin42_2 = new PdfPCell();
//                lin42_2.setBorder(0);
//                lin42_2.setFixedHeight(72f);
//                PdfPCell lin42_3 = new PdfPCell();
//                lin42_3.setBorder(0);
//                lin42_3.setFixedHeight(24f);
//                PdfPCell lin42 = new PdfPCell(cellTable4_2);
//                final Paragraph lin42p0 = new Paragraph("", fontChineseNormalsimfang12);
//                lin42p0.setFirstLineIndent(24f);
//                lin42p0.setLeading(24f);
//                lin42p0.setAlignment(Element.ALIGN_LEFT);
//
//                final Paragraph lin42p02 = new Paragraph("", fontChineseNormalsimfang12);
//                lin42p02.setFirstLineIndent(0f);
//                lin42p02.setLeading(24f);
//                lin42p02.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase2 = new Phrase();
//                Phrase phrase2_1 = new Phrase();
//                phrase2.add(ChunkFactoryOld.tablenounderLine(book.getValue(19), 1696,
//                        fontChineseNormalsimfang12));
//                phrase2_1.add(new Chunk("承办人（签名）：", fontChineseNormalsimfang12));
//                phrase2_1.add(ChunkFactoryOld.underLine(book.getValue(20), 48,
//                        fontChineseNormalsimfang12));
//                phrase2_1.add(ChunkFactoryOld.tablenounderLine("", 12,
//                        fontChineseNormalsimfang12));
//                phrase2_1.add(ChunkFactoryOld.underLine(book.getValue(21), 48,
//                        fontChineseNormalsimfang12));
//                phrase2_1.add(ChunkFactoryOld.tablenounderLine(StringFactoryBuild.build().getTime(book.getValue(22), 0), 36,
//                        fontChineseNormalsimfang12));
//                phrase2_1.add(new Chunk("年", fontChineseNormalsimfang12));
//                phrase2_1.add(ChunkFactoryOld.tablenounderLine(StringFactoryBuild.build().getTime(book.getValue(22), 1), 12,
//                        fontChineseNormalsimfang12));
//                phrase2_1.add(new Chunk("月", fontChineseNormalsimfang12));
//                phrase2_1.add(ChunkFactoryOld.tablenounderLine(StringFactoryBuild.build().getTime(book.getValue(22), 2), 12,
//                        fontChineseNormalsimfang12));
//                phrase2_1.add(new Chunk("日", fontChineseNormalsimfang12));
//
//                lin42p0.add(phrase2);
//                lin42p02.add(phrase2_1);
//                lin42_2.addElement(lin42p0);
//                lin42_3.addElement(lin42p02);
//                cellTable4_2.addCell(lin42_2);
//                cellTable4_2.addCell(lin42_3);
//
//                PdfPTable cellTable4 = new PdfPTable(2);
//                cellTable4.setWidths(celltable1float);
//                cellTable4.addCell(lin41);
//                cellTable4.addCell(lin42);
//                PdfPCell row4 = new PdfPCell(cellTable4);
//                row4.setFixedHeight(108f);
//                table.addCell(row4);
//
//                PdfPTable cellTable5 = new PdfPTable(4);
//                float[] celltable5float = new float[4];
//                celltable5float[0] = 2f;
//                celltable5float[1] = 8f;
//                celltable5float[2] = 2f;
//                celltable5float[3] = 9f;
//                cellTable5.setWidths(celltable5float);
//
//                PdfPCell lin51 = new PdfPCell();
//                final Paragraph lin51p0 = new Paragraph("\n审\n核\n意\n见",
//                        fontChineseNormalsimfang12);
//                lin51p0.setAlignment(Element.ALIGN_CENTER);
//                lin51.addElement(lin51p0);
//
//                PdfPTable cellTable5_2 = new PdfPTable(1);
//                PdfPCell lin52_1 = new PdfPCell();
//                PdfPCell lin52_2 = new PdfPCell();
//                lin52_1.setFixedHeight(50f);
//                lin52_1.setBorder(0);
//                lin52_2.setFixedHeight(24f);
//                lin52_2.setBorder(0);
//                PdfPCell lin52 = new PdfPCell(cellTable5_2);
//                final Paragraph lin52p0 = new Paragraph();
//                final Paragraph lin52p02 = new Paragraph();
//                lin52p0.setAlignment(Element.ALIGN_LEFT);
//                lin52p0.setIndentationLeft(24f);
//                lin52p0.setLeading(24f);
//
//                lin52p02.setAlignment(Element.ALIGN_LEFT);
//                lin52p02.setIndentationLeft(24f);
//                lin52p02.setLeading(24f);
//                Phrase phrase3 = new Phrase();
//                Phrase phrase3_1 = new Phrase();
//                phrase3.add(ChunkFactoryOld.tablenounderLine(book.getValue(23), 12,
//                        fontChineseNormalsimfang12));
//                phrase3_1.add(new Chunk("审核人（签名）:", fontChineseNormalsimfang12));
//                phrase3_1.add(ChunkFactoryOld.tablenounderLine(book.getValue(24), 120,
//                        fontChineseNormalsimfang12));
//                phrase3_1.add(ChunkFactoryOld.tablenounderLine(StringFactoryBuild.build().getTime(book.getValue(25), 0), 36,
//                        fontChineseNormalsimfang12));
//                phrase3_1.add(new Chunk("年", fontChineseNormalsimfang12));
//                phrase3_1.add(ChunkFactoryOld.tablenounderLine(StringFactoryBuild.build().getTime(book.getValue(25), 1), 6,
//                        fontChineseNormalsimfang12));
//                phrase3_1.add(new Chunk("月", fontChineseNormalsimfang12));
//                phrase3_1.add(ChunkFactoryOld.tablenounderLine(StringFactoryBuild.build().getTime(book.getValue(25), 2), 6,
//                        fontChineseNormalsimfang12));
//                phrase3_1.add(new Chunk("日", fontChineseNormalsimfang12));
//                lin52p0.add(phrase3);
//                lin52p02.add(phrase3_1);
//                lin52_1.addElement(lin52p0);
//                lin52_2.addElement(lin52p02);
//                cellTable5_2.addCell(lin52_1);
//                cellTable5_2.addCell(lin52_2);
//
//                PdfPCell lin53 = new PdfPCell();
//                final Paragraph lin53p0 = new Paragraph("\n审\n批\n意\n见",
//                        fontChineseNormalsimfang12);
//                lin53p0.setAlignment(Element.ALIGN_CENTER);
//                lin53.addElement(lin53p0);
//
//                PdfPTable cellTable5_4 = new PdfPTable(1);
//                PdfPCell lin54_1 = new PdfPCell();
//                PdfPCell lin54_2 = new PdfPCell();
//                lin54_1.setFixedHeight(50f);
//                lin54_1.setBorder(0);
//                lin54_2.setFixedHeight(24f);
//                lin54_2.setBorder(0);
//                PdfPCell lin54 = new PdfPCell(cellTable5_4);
//                final Paragraph lin54p0 = new Paragraph();
//                final Paragraph lin54p02 = new Paragraph();
//                lin54p0.setAlignment(Element.ALIGN_LEFT);
//                lin54p0.setIndentationLeft(24f);
//                lin54p0.setLeading(24f);
//
//                lin54p02.setAlignment(Element.ALIGN_LEFT);
//                lin54p02.setIndentationLeft(24f);
//                lin54p02.setLeading(24f);
//                Phrase phrase4 = new Phrase();
//                Phrase phrase4_1 = new Phrase();
//                phrase4.add(ChunkFactoryOld.tablenounderLine(book.getValue(26), 12,
//                        fontChineseNormalsimfang12));
//                phrase4_1.add(new Chunk("审批人（签名）:", fontChineseNormalsimfang12));
//                phrase4_1.add(ChunkFactoryOld.tablenounderLine(book.getValue(27), 120,
//                        fontChineseNormalsimfang12));
//                phrase4_1.add(ChunkFactoryOld.tablenounderLine(StringFactoryBuild.build().getTime(book.getValue(28), 0), 36,
//                        fontChineseNormalsimfang12));
//                phrase4_1.add(new Chunk("年", fontChineseNormalsimfang12));
//                phrase4_1.add(ChunkFactoryOld.tablenounderLine(StringFactoryBuild.build().getTime(book.getValue(28), 1), 6,
//                        fontChineseNormalsimfang12));
//                phrase4_1.add(new Chunk("月", fontChineseNormalsimfang12));
//                phrase4_1.add(ChunkFactoryOld.tablenounderLine(StringFactoryBuild.build().getTime(book.getValue(28), 2), 6,
//                        fontChineseNormalsimfang12));
//                phrase4_1.add(new Chunk("日", fontChineseNormalsimfang12));
//                lin54p0.add(phrase4);
//                lin54p02.add(phrase4_1);
//                lin54_1.addElement(lin54p0);
//                lin54_2.addElement(lin54p02);
//                cellTable5_4.addCell(lin54_1);
//                cellTable5_4.addCell(lin54_2);
//
//                cellTable5.addCell(lin51);
//                cellTable5.addCell(lin52);
//                cellTable5.addCell(lin53);
//                cellTable5.addCell(lin54);
//
//                PdfPCell row5 = new PdfPCell(cellTable5);
//                row5.setFixedHeight(112f);
//                table.addCell(row5);
//
//                document.add(table);
//                document.add(space1);
//                // 表格end
//
//                PdfContentByte canvas2 = dpfwPdfWriter.getDirectContent();
//                // 电子签章
//                Image img = ImageBuilder.getInstance(image);
//                if (img != null) {
//                    img.setAbsolutePosition(350, 140);
//                    canvas2.addImage(img);
//                }
//
//                document.newPage();
//            }
//        });
//
//    }
//
//    //行政处罚集体讨论记录
//    public void printerEntity_Book22(final Base_Entity book, final Object image) {
//        printFrameWork(book, image, new IPdfBackFrame() {
//            @Override
//            public void writeContent() throws Exception {
//                //此处写页面布局
//                final Paragraph title = new Paragraph("" + city + "安全生产行政执法文书", fontChineseBoldsimhei15);// Paragraph就是段落
//                title.setLeading(1f);// 段落距离
//                // title.setSpacingBefore(25f);//段落留白
//                title.setAlignment(Element.ALIGN_CENTER);// 居中
//                document.add(title);// 写入文档
//                final Paragraph titleLine1 = new Paragraph(new Chunk(new LineSeparator()));// 加入一个换行
//                titleLine1.setLeading(1f);
//                titleLine1.setSpacingBefore(5f);
//                document.add(titleLine1);
//                final Paragraph titleLine2 = new Paragraph(new Chunk(new LineSeparator()));
//                titleLine2.setLeading(1f);
//                titleLine2.setSpacingBefore(1f);
//                document.add(titleLine2);
//                final Paragraph title2 = new Paragraph("行政处罚集体讨论记录", fontChineseBoldsimhei15);
//
//                title2.setLeading(1f);
//                title2.setSpacingBefore(17f);
//                title2.setAlignment(Element.ALIGN_CENTER);
//
//                document.add(title2);
//                document.add(space1);
//
//                final Paragraph paragraph1 = new Paragraph();
//                paragraph1.setIndentationLeft(24f);
//                paragraph1.setLeading(24f);
//                paragraph1.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase1 = new Phrase();
//                phrase1.add(new Chunk("案件名称：", fontChineseNormalsimfang12));
//                phrase1.add(ChunkFactoryOld.underLine(book.getValue(3), 330,
//                        fontChineseNormalsimfang12));
//                phrase1.add(new Chunk("讨论时间：", fontChineseNormalsimfang12));
//                phrase1.add(ChunkFactoryOld
//                        .underLine(StringFactoryBuild.build().getTime(book.getValue(4), 0), 36, fontChineseNormalsimfang12));
//                phrase1.add(new Chunk("年", fontChineseNormalsimfang12));
//                phrase1.add(ChunkFactoryOld
//                        .underLine(StringFactoryBuild.build().getTime(book.getValue(4), 1), 12, fontChineseNormalsimfang12));
//                phrase1.add(new Chunk("月", fontChineseNormalsimfang12));
//                phrase1.add(ChunkFactoryOld
//                        .underLine(StringFactoryBuild.build().getTime(book.getValue(4), 2), 12, fontChineseNormalsimfang12));
//                phrase1.add(new Chunk("日", fontChineseNormalsimfang12));
//                phrase1.add(ChunkFactoryOld
//                        .underLine(StringFactoryBuild.build().getTime(book.getValue(4), 3), 12, fontChineseNormalsimfang12));
//                phrase1.add(new Chunk("时", fontChineseNormalsimfang12));
//                phrase1.add(ChunkFactoryOld
//                        .underLine(StringFactoryBuild.build().getTime(book.getValue(4), 4), 12, fontChineseNormalsimfang12));
//                phrase1.add(new Chunk("分至", fontChineseNormalsimfang12));
//                phrase1.add(ChunkFactoryOld
//                        .underLine(StringFactoryBuild.build().getTime(book.getValue(5), 2), 12, fontChineseNormalsimfang12));
//                phrase1.add(new Chunk("日", fontChineseNormalsimfang12));
//                phrase1.add(ChunkFactoryOld
//                        .underLine(StringFactoryBuild.build().getTime(book.getValue(5), 3), 12, fontChineseNormalsimfang12));
//                phrase1.add(new Chunk("时", fontChineseNormalsimfang12));
//                phrase1.add(ChunkFactoryOld
//                        .underLine(StringFactoryBuild.build().getTime(book.getValue(5), 4), 12, fontChineseNormalsimfang12));
//                phrase1.add(new Chunk("分", fontChineseNormalsimfang12));
//                phrase1.add("\n");
//                phrase1.add(new Chunk("地点：", fontChineseNormalsimfang12));
//                phrase1.add(ChunkFactoryOld.underLine(book.getValue(6), 354,
//                        fontChineseNormalsimfang12));
//
//                phrase1.add(new Chunk("主持人：", fontChineseNormalsimfang12));
//                phrase1.add(ChunkFactoryOld
//                        .underLine(book.getValue(7), 72, fontChineseNormalsimfang12));
//                phrase1.add(new Chunk("汇报人：", fontChineseNormalsimfang12));
//                phrase1.add(ChunkFactoryOld
//                        .underLine(book.getValue(8), 78, fontChineseNormalsimfang12));
//                phrase1.add(new Chunk("记录人：", fontChineseNormalsimfang12));
//                phrase1.add(ChunkFactoryOld
//                        .underLine(book.getValue(9), 72, fontChineseNormalsimfang12));
//                phrase1.add("\n");
//                phrase1.add(new Chunk("出席人员姓名及职务：", fontChineseNormalsimfang12));
//
//                paragraph1.add(phrase1);
//                document.add(paragraph1);
//
//                final Paragraph paragraph2 = new Paragraph();
//                paragraph2.setLeading(15f);
//                paragraph2.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase2 = new Phrase();
//                phrase2.add(ChunkFactoryOld.underLine(book.getValue(10), 2144,
//                        fontChineseNormalsimfang12,0,430));
//
//                paragraph2.add(phrase2);
//                document.add(paragraph2);
//
//                final Paragraph paragraph3 = new Paragraph();
//                paragraph3.setFirstLineIndent(24f);
//                paragraph3.setLeading(15f);
//                paragraph3.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase3 = new Phrase();
//                 phrase3.add(new Chunk("讨论内容：", fontChineseNormalsimfang12));
//                phrase3.add(ChunkFactoryOld.underLine(book.getValue(11), 2494,
//                        fontChineseNormalsimfang12,84,430));
//
//                paragraph3.add(phrase3);
//                document.add(paragraph3);
//
//                final Paragraph paragraph4 = new Paragraph();
//                paragraph4.setFirstLineIndent(24f);
//                paragraph4.setLeading(15f);
//                paragraph4.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase4 = new Phrase();
//                 phrase4.add(new Chunk("讨论记录：", fontChineseNormalsimfang12));
//                phrase4.add(ChunkFactoryOld.underLine(book.getValue(12), 5946,
//                        fontChineseNormalsimfang12,84,430));
//
//                paragraph4.add(phrase4);
//                document.add(paragraph4);
//
//                final Paragraph paragraph5 = new Paragraph();
//                paragraph5.setFirstLineIndent(24f);
//                paragraph5.setLeading(15f);
//                paragraph5.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase5 = new Phrase();
//                 phrase5.add(new Chunk("结论性意见：", fontChineseNormalsimfang12));
//                phrase5.add(ChunkFactoryOld.underLine(book.getValue(13), 1618,
//                        fontChineseNormalsimfang12,96,430));
//
//                paragraph5.add(phrase5);
//                document.add(paragraph5);
//
//                final Paragraph paragraph6 = new Paragraph();
//                paragraph6.setFirstLineIndent(24f);
//                paragraph6.setLeading(15f);
//                paragraph6.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase6 = new Phrase();
//                 phrase6.add(new Chunk("出席人员签名：", fontChineseNormalsimfang12));
//                phrase6.add(ChunkFactoryOld.underLine(book.getValue(14), 1174,
//                        fontChineseNormalsimfang12,108,430));
//
//                paragraph6.add(phrase6);
//                document.add(paragraph6);
//                PdfContentByte canvas = dpfwPdfWriter.getDirectContent();
//
////                Phrase phrase18 = new Phrase();
////
////                phrase18.add(new Chunk("讨论内容：", fontChineseNormalsimfang12));
////                ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phrase18,
////                        104, 498, 0);
////
////                Phrase phrase181 = new Phrase();
////
////                phrase181.add(new Chunk("讨论记录：", fontChineseNormalsimfang12));
////                ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phrase181,
////                        104, 409, 0);
////                Phrase phrase182 = new Phrase();
////
////                phrase182.add(new Chunk("结论性意见：", fontChineseNormalsimfang12));
////                ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phrase182,
////                        104, 199, 0);
////                Phrase phrase183 = new Phrase();
////
////                phrase183.add(new Chunk("出席人员签名：", fontChineseNormalsimfang12));
////                ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phrase183,
////                        104, 138, 0);
//                PdfContentByte canvas2 = dpfwPdfWriter.getDirectContent();
//                // 电子签章
//                Image img = ImageBuilder.getInstance(image);
//                if (img != null) {
//                    img.setAbsolutePosition(350, 140);
//                    canvas2.addImage(img);
//                }
//                document.newPage();// 结束保存
//            }
//        });
//
//    }
//
//    //行政（当场）处罚决定书（单位）
//    public void printerEntity_Book23(final Base_Entity book, final Object image) {
//        printFrameWork(book, image, new IPdfBackFrame() {
//            @Override
//            public void writeContent() throws Exception {
//                //此处写页面布局
//                final Paragraph title = new Paragraph("" + city + "安全生产行政执法文书", fontChineseBoldsimhei15);// Paragraph就是段落
//                title.setLeading(1f);// 段落距离
//                // title.setSpacingBefore(25f);//段落留白
//                title.setAlignment(Element.ALIGN_CENTER);// 居中
//                document.add(title);// 写入文档
//                final Paragraph titleLine1 = new Paragraph(new Chunk(new LineSeparator()));// 加入一个换行
//                titleLine1.setLeading(1f);
//                titleLine1.setSpacingBefore(5f);
//                document.add(titleLine1);
//                final Paragraph titleLine2 = new Paragraph(new Chunk(new LineSeparator()));
//                titleLine2.setLeading(1f);
//                titleLine2.setSpacingBefore(1f);
//                document.add(titleLine2);
//                final Paragraph title2 = new Paragraph("行政（当场）处罚决定书（单位）",
//                        fontChineseBoldsimhei15);
//
//                title2.setLeading(1f);
//                title2.setSpacingBefore(17f);
//                title2.setAlignment(Element.ALIGN_CENTER);
//
//                document.add(title2);
//
//                final Paragraph title3 = new Paragraph("( " + book.getValue(0) + " )安监管罚当〔" + book.getValue(1) + "〕"
//                        + book.getValue(2) + "号", fontChineseNormalsimfang12);
//                title3.setLeading(1f);
//                title3.setSpacingBefore(30f);
//                title3.setAlignment(Element.ALIGN_CENTER);
//                document.add(title3);
//
//                final Paragraph paragraph1 = new Paragraph();
//                paragraph1.setIndentationLeft(24f);
//                paragraph1.setLeading(24f);
//                paragraph1.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase1 = new Phrase();
//                phrase1.add(new Chunk("被处罚单位：", fontChineseNormalsimfang12));
//                phrase1.add(ChunkFactoryOld.underLine(book.getValue(3), 318,
//                        fontChineseNormalsimfang12));
//
//                Phrase phrase2 = new Phrase();
//                phrase2.add(new Chunk("地 址：", fontChineseNormalsimfang12));
//                phrase2.add(ChunkFactoryOld.underLine(book.getValue(4), 204,
//                        fontChineseNormalsimfang12));
//                phrase2.add(new Chunk("邮编：", fontChineseNormalsimfang12));
//                phrase2.add(ChunkFactoryOld.underLine(book.getValue(5), 96,
//                        fontChineseNormalsimfang12));
//
//                Phrase phrase3 = new Phrase();
//                phrase3.add(new Chunk("法定代表人（主要负责人）:", fontChineseNormalsimfang12));
//                phrase3.add(ChunkFactoryOld
//                        .underLine(book.getValue(6), 42, fontChineseNormalsimfang12));
//                phrase3.add(new Chunk("职务:", fontChineseNormalsimfang12));
//                phrase3.add(ChunkFactoryOld
//                        .underLine(book.getValue(6), 42, fontChineseNormalsimfang12));
//                phrase3.add(new Chunk("联系电话:", fontChineseNormalsimfang12));
//                phrase3.add(ChunkFactoryOld
//                        .underLine(book.getValue(8), 54, fontChineseNormalsimfang12));
//
//                paragraph1.add(phrase1);
//                paragraph1.add(phrase2);
//                paragraph1.add(phrase3);
//
//                document.add(paragraph1);
//
//                final Paragraph paragraph2 = new Paragraph();
//                paragraph2.setFirstLineIndent(24f);
//                paragraph2.setLeading(24f);
//                paragraph2.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase4 = new Phrase();
//                 phrase4.add(new Chunk("违法事实及证据", fontChineseNormalsimfang12));
//                phrase4.add(ChunkFactoryOld.underLine(book.getValue(9), 2336,
//                        fontChineseNormalsimfang12,108,430));
//                phrase4.add(new Chunk("（此栏不够，可另附页）", fontChineseNormalsimfang12));
//
//                paragraph2.add(phrase4);
//
//                document.add(paragraph2);
//
//                final Paragraph paragraph3 = new Paragraph();
//                paragraph3.setFirstLineIndent(24f);
//                paragraph3.setLeading(24f);
//                paragraph3.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase5 = new Phrase();
//                phrase5.add(new Chunk("以上事实违反了", fontChineseNormalsimfang12));
//                phrase5.add(ChunkFactoryOld.underLine(book.getValue(10), 306,
//                        fontChineseNormalsimfang12));
//                phrase5.add(new Chunk("的规定，依据", fontChineseNormalsimfang12));
//                phrase5.add(ChunkFactoryOld.underLine(book.getValue(11), 246,
//                        fontChineseNormalsimfang12));
//                phrase5.add(new Chunk("的规定，决定给予", fontChineseNormalsimfang12));
//                phrase5.add(ChunkFactoryOld.underLine(book.getValue(12), 312,
//                        fontChineseNormalsimfang12));
//                phrase5.add(new Chunk("的行政处罚。", fontChineseNormalsimfang12));
//
//                paragraph3.add(phrase5);
//                document.add(paragraph3);
//
//                final Paragraph paragraph4 = new Paragraph("罚款的履行方式和期限（见打√处）：",
//                        fontChineseNormalsimfang12);
//                paragraph4.setAlignment(Element.ALIGN_LEFT);
//                paragraph4.setLeading(24f);
//
//                document.add(paragraph4);
//
//                final Paragraph paragraph5 = new Paragraph("当场缴纳", fontChineseNormalsimfang12);
//                paragraph5.setAlignment(Element.ALIGN_LEFT);
//                paragraph5.setIndentationLeft(36f);
//                paragraph5.setLeading(24f);
//
//                document.add(paragraph5);
//
//                final Paragraph paragraph6 = new Paragraph();
//                paragraph6.setAlignment(Element.ALIGN_LEFT);
//                paragraph6.setFirstLineIndent(36f);
//                paragraph6.setLeading(24f);
//
//                Phrase phrase6 = new Phrase();
//                phrase6.add(new Chunk("自收到本决定书之日起15日内缴至", fontChineseNormalsimfang12));
//                phrase6.add(ChunkFactoryOld.underLine(book.getValue(14), 180,
//                        fontChineseNormalsimfang12));
//                phrase6.add(new Chunk("，账号", fontChineseNormalsimfang12));
//                phrase6.add(ChunkFactoryOld.underLine(book.getValue(15), 152,
//                        fontChineseNormalsimfang12));
//                phrase6.add(new Chunk("，到期不缴每日按罚款款数额的3%加处罚款。", fontChineseNormalsimfang12));
//
//                paragraph6.add(phrase6);
//                document.add(paragraph6);
//
//                final Paragraph paragraph7 = new Paragraph();
//                paragraph7.setAlignment(Element.ALIGN_LEFT);
//                paragraph7.setFirstLineIndent(24f);
//                paragraph7.setLeading(24f);
//
//                Phrase phrase7 = new Phrase();
//                phrase7.add(new Chunk("如果不服本决定，可以依法在60日内向", fontChineseNormalsimfang12));
//                phrase7.add(ChunkFactoryOld.underLine(book.getValue(16), 120,
//                        fontChineseNormalsimfang12));
//                phrase7.add(new Chunk("人民政府或者", fontChineseNormalsimfang12));
//                phrase7.add(ChunkFactoryOld
//                        .underLine(book.getValue(17), 96, fontChineseNormalsimfang12));
//                phrase7.add(new Chunk("申请行政复议，或者在三个月内依法向", fontChineseNormalsimfang12));
//                phrase7.add(ChunkFactoryOld
//                        .underLine(book.getValue(18), 84, fontChineseNormalsimfang12));
//                phrase7.add(new Chunk(
//                        "人民法院提起行政诉讼，但本决定不停止执行，法律另有规定的除外。逾期不申请行政复议、不提起行政诉讼又不履行的，本机关将依法申请人民法院强制执行或者依照有关规定强制执行。",
//                        fontChineseNormalsimfang12));
//
//                paragraph7.add(phrase7);
//                document.add(paragraph7);
//
//                final Paragraph paragraph8 = new Paragraph();
//                paragraph8.setIndentationLeft(24f);
//
//                Phrase phrase8 = new Phrase();
//                phrase8.add(new Chunk("安全生产监管执法人员（签名）：", fontChineseNormalsimfang12));
//                phrase8.add(ChunkFactoryOld
//                        .underLine(book.getValue(19), 72, fontChineseNormalsimfang12));
//                phrase8.add(new Chunk("、", fontChineseNormalsimfang12));
//                phrase8.add(ChunkFactoryOld
//                        .underLine(book.getValue(20), 72, fontChineseNormalsimfang12));
//                phrase8.add("\n");
//                phrase8.add(new Chunk("当事人或委托代理人（签名）：", fontChineseNormalsimfang12));
//                phrase8.add(ChunkFactoryOld
//                        .underLine(book.getValue(21), 72, fontChineseNormalsimfang12));
//                phrase8.add("\n");
//
//                paragraph8.add(phrase8);
//                paragraph8.setLeading(26);
//                document.add(paragraph8);
//
//                final Paragraph paragraph9 = new Paragraph();
//                paragraph9.setFirstLineIndent(264f);
//                paragraph9.setLeading(24f);
//                paragraph9.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase10 = new Phrase();
//                phrase10.add(new Chunk("安全生产监督管理部门（公章）", fontChineseNormalsimfang12));
//                toMeasurefloat(phrase10);
//
//                paragraph9.add(phrase10);
//                document.add(paragraph9);
//
//                final Paragraph paragraph10 = new Paragraph();
//                paragraph10.setFirstLineIndent(264f);
//                paragraph10.setLeading(24f);
//                paragraph10.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase11 = new Phrase();
//                phrase11.add(ChunkFactoryOld.tablenounderLine(StringFactoryBuild.build().getTime(book.getValue(22), 0), 36,
//                        fontChineseNormalsimfang12));
//                phrase11.add(new Chunk("年", fontChineseNormalsimfang12));
//                phrase11.add(ChunkFactoryOld.tablenounderLine(StringFactoryBuild.build().getTime(book.getValue(22), 1), 12,
//                        fontChineseNormalsimfang12));
//                phrase11.add(new Chunk("月", fontChineseNormalsimfang12));
//                phrase11.add(ChunkFactoryOld.tablenounderLine(StringFactoryBuild.build().getTime(book.getValue(22), 2), 12,
//                        fontChineseNormalsimfang12));
//                phrase11.add(new Chunk("日", fontChineseNormalsimfang12));
//                toMeasurefloat(phrase11);
//
//                paragraph10.add(phrase11);
//                document.add(paragraph10);
//
//                final Paragraph bottomLine1 = new Paragraph(
//                        new Chunk(new LineSeparator()));// 加入一个换行
//                bottomLine1.setLeading(1f);
//                bottomLine1.setSpacingBefore(5f);
//
//                document.add(bottomLine1);
//
//                final Paragraph paragraph11 = new Paragraph();
//                Phrase phrase12 = new Phrase();
//                phrase12.add(new Chunk("本文书一式两份：一份由安全生产监督管理部门备案，一份交被处罚单位。",
//                        fontChineseNormalsimfang12));
//
//                paragraph11.add(phrase12);
//
//                document.add(paragraph11);
//
//                // checkbox start
//                PdfContentByte cb = dpfwPdfWriter.getDirectContent();
//                RadioCheckField bt = new RadioCheckField(dpfwPdfWriter,
//                        ChunkFactoryOld.setCheckBoxArea(105, 347, 10), "Yes436",
//                        ChunkFactoryOld.getCheck(book.getValue(13), 1));
//                bt.setCheckType(RadioCheckField.TYPE_CHECK);
//                bt.setBorderWidth(BaseField.BORDER_WIDTH_THIN);
//                bt.setBorderColor(BaseColor.BLACK);
//                bt.setChecked(true);
//                PdfFormField ck = bt.getCheckField();
//                dpfwPdfWriter.addAnnotation(ck);
//
//                RadioCheckField bt2 = new RadioCheckField(dpfwPdfWriter,
//                        ChunkFactoryOld.setCheckBoxArea(105, 323, 10), "Yes486",
//                        ChunkFactoryOld.getCheck(book.getValue(13), 2));
//                bt2.setCheckType(RadioCheckField.TYPE_CHECK);
//                bt2.setBorderWidth(BaseField.BORDER_WIDTH_THIN);
//                bt2.setBorderColor(BaseColor.BLACK);
//                bt2.setChecked(true);
//                PdfFormField ck2 = bt2.getCheckField();
//                dpfwPdfWriter.addAnnotation(ck2);
//
//                // checkbox end
//                PdfContentByte canvas = dpfwPdfWriter.getDirectContent();
//
////                Phrase phrase18 = new Phrase();
////
////                phrase18.add(new Chunk("违法事实及证据：", fontChineseNormalsimfang12));
////                ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phrase18,
////                        104, 588, 0);
//
//                PdfContentByte canvas2 = dpfwPdfWriter.getDirectContent();
//                // 电子签章
//                Image img = ImageBuilder.getInstance(image);
//                if (img != null) {
//                    img.setAbsolutePosition(350, 140);
//                    canvas2.addImage(img);
//                }
//                document.newPage();// 结束保存
//            }
//        });
//
//    }
//
//    //行政（当场）处罚决定书（个人）
//    public void printerEntity_Book24(final Base_Entity book, final Object image) {
//        printFrameWork(book, image, new IPdfBackFrame() {
//            @Override
//            public void writeContent() throws Exception {
//                //此处写页面布局
//                final Paragraph title = new Paragraph("" + city + "安全生产行政执法文书", fontChineseBoldsimhei15);// Paragraph就是段落
//                title.setLeading(1f);// 段落距离
//                // title.setSpacingBefore(25f);//段落留白
//                title.setAlignment(Element.ALIGN_CENTER);// 居中
//                document.add(title);// 写入文档
//                final Paragraph titleLine1 = new Paragraph(new Chunk(new LineSeparator()));// 加入一个换行
//                titleLine1.setLeading(1f);
//                titleLine1.setSpacingBefore(5f);
//                document.add(titleLine1);
//                final Paragraph titleLine2 = new Paragraph(new Chunk(new LineSeparator()));
//                titleLine2.setLeading(1f);
//                titleLine2.setSpacingBefore(1f);
//                document.add(titleLine2);
//                final Paragraph title2 = new Paragraph("行政（当场）处罚决定书（个人）",
//                        fontChineseBoldsimhei15);
//
//                title2.setLeading(1f);
//                title2.setSpacingBefore(17f);
//                title2.setAlignment(Element.ALIGN_CENTER);
//
//                document.add(title2);
//
//                final Paragraph title3 = new Paragraph("( " + book.getValue(0) + " )安监管罚当〔" + book.getValue(1) + "〕"
//                        + book.getValue(2) + "号", fontChineseNormalsimfang12);
//                title3.setLeading(1f);
//                title3.setSpacingBefore(30f);
//                title3.setAlignment(Element.ALIGN_CENTER);
//                document.add(title3);
//
//                final Paragraph paragraph1 = new Paragraph();
//                paragraph1.setIndentationLeft(24f);
//                paragraph1.setLeading(24f);
//                paragraph1.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase1 = new Phrase();
//                phrase1.add(new Chunk("被处罚人：", fontChineseNormalsimfang12));
//                phrase1.add(ChunkFactoryOld
//                        .underLine(book.getValue(3), 48, fontChineseNormalsimfang12));
//                phrase1.add(new Chunk("性别：", fontChineseNormalsimfang12));
//                phrase1.add(ChunkFactoryOld
//                        .underLine(book.getValue(4), 24, fontChineseNormalsimfang12));
//                phrase1.add(new Chunk("年龄：", fontChineseNormalsimfang12));
//                phrase1.add(ChunkFactoryOld
//                        .underLine(book.getValue(5), 24, fontChineseNormalsimfang12));
//                phrase1.add(new Chunk("身份证号：", fontChineseNormalsimfang12));
//                phrase1.add(ChunkFactoryOld.underLine(book.getValue(6), 66,
//                        fontChineseNormalsimfang12));
//
//                Phrase phrase2 = new Phrase();
//                phrase2.add(new Chunk("家庭住址：", fontChineseNormalsimfang12));
//                phrase2.add(ChunkFactoryOld.underLine(book.getValue(7), 144,
//                        fontChineseNormalsimfang12));
//                phrase2.add(new Chunk("所在单位：", fontChineseNormalsimfang12));
//                phrase2.add(ChunkFactoryOld.underLine(book.getValue(8), 114,
//                        fontChineseNormalsimfang12));
//
//                Phrase phrase3 = new Phrase();
//                phrase3.add(new Chunk("职务:", fontChineseNormalsimfang12));
//                phrase3.add(ChunkFactoryOld
//                        .underLine(book.getValue(9), 78, fontChineseNormalsimfang12));
//                phrase3.add(new Chunk("单位地址:", fontChineseNormalsimfang12));
//                phrase3.add(ChunkFactoryOld
//                        .underLine(book.getValue(10), 78, fontChineseNormalsimfang12));
//                phrase3.add(new Chunk("联系电话:", fontChineseNormalsimfang12));
//                phrase3.add(ChunkFactoryOld
//                        .underLine(book.getValue(11), 78, fontChineseNormalsimfang12));
//
//                paragraph1.add(phrase1);
//                paragraph1.add(phrase2);
//                paragraph1.add(phrase3);
//
//                document.add(paragraph1);
//
//                final Paragraph paragraph2 = new Paragraph();
//                paragraph2.setFirstLineIndent(24f);
//                paragraph2.setLeading(24f);
//                paragraph2.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase4 = new Phrase();
//                 phrase4.add(new Chunk("违法事实及证据", fontChineseNormalsimfang12));
//                phrase4.add(ChunkFactoryOld.underLine(book.getValue(12), 2328,
//                        fontChineseNormalsimfang12,108,430));
//                phrase4.add(new Chunk("（此栏不够，可另附页）", fontChineseNormalsimfang12));
//
//                paragraph2.add(phrase4);
//
//                document.add(paragraph2);
//
//                final Paragraph paragraph3 = new Paragraph();
//                paragraph3.setFirstLineIndent(24f);
//                paragraph3.setLeading(24f);
//                paragraph3.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase5 = new Phrase();
//                phrase5.add(new Chunk("以上事实违反了", fontChineseNormalsimfang12));
//                phrase5.add(ChunkFactoryOld.underLine(book.getValue(13), 306,
//                        fontChineseNormalsimfang12));
//                phrase5.add(new Chunk("的规定，依据", fontChineseNormalsimfang12));
//                phrase5.add(ChunkFactoryOld.underLine(book.getValue(14), 248,
//                        fontChineseNormalsimfang12));
//                phrase5.add(new Chunk("的规定，决定给予", fontChineseNormalsimfang12));
//                phrase5.add(ChunkFactoryOld.underLine(book.getValue(15), 330,
//                        fontChineseNormalsimfang12));
//                phrase5.add(new Chunk("的行政处罚。", fontChineseNormalsimfang12));
//
//                paragraph3.add(phrase5);
//                document.add(paragraph3);
//
//                final Paragraph paragraph4 = new Paragraph("罚款的履行方式和期限（见打√处）：",
//                        fontChineseNormalsimfang12);
//                paragraph4.setAlignment(Element.ALIGN_LEFT);
//                paragraph4.setLeading(24f);
//
//                document.add(paragraph4);
//
//                final Paragraph paragraph5 = new Paragraph("当场缴纳", fontChineseNormalsimfang12);
//                paragraph5.setAlignment(Element.ALIGN_LEFT);
//                paragraph5.setIndentationLeft(36f);
//                paragraph5.setLeading(24f);
//
//                document.add(paragraph5);
//
//                final Paragraph paragraph6 = new Paragraph();
//                paragraph6.setAlignment(Element.ALIGN_LEFT);
//                paragraph6.setFirstLineIndent(36f);
//                paragraph6.setLeading(24f);
//
//                Phrase phrase6 = new Phrase();
//                phrase6.add(new Chunk("自收到本决定书之日起15日内缴至", fontChineseNormalsimfang12));
//                phrase6.add(ChunkFactoryOld.underLine(book.getValue(17), 180,
//                        fontChineseNormalsimfang12));
//                phrase6.add(new Chunk("，账号", fontChineseNormalsimfang12));
//                phrase6.add(ChunkFactoryOld.underLine(book.getValue(18), 162,
//                        fontChineseNormalsimfang12));
//                phrase6.add(new Chunk("，到期不缴每日按罚款款数额的3%加处罚款。", fontChineseNormalsimfang12));
//
//                paragraph6.add(phrase6);
//                document.add(paragraph6);
//
//                final Paragraph paragraph7 = new Paragraph();
//                paragraph7.setAlignment(Element.ALIGN_LEFT);
//                paragraph7.setFirstLineIndent(24f);
//                paragraph7.setLeading(24f);
//
//                Phrase phrase7 = new Phrase();
//                phrase7.add(new Chunk("如果不服本决定，可以依法在60日内向", fontChineseNormalsimfang12));
//                phrase7.add(ChunkFactoryOld.underLine(book.getValue(19), 120,
//                        fontChineseNormalsimfang12));
//                phrase7.add(new Chunk("人民政府或者", fontChineseNormalsimfang12));
//                phrase7.add(ChunkFactoryOld
//                        .underLine(book.getValue(20), 96, fontChineseNormalsimfang12));
//                phrase7.add(new Chunk("申请行政复议，或者在三个月内依法向", fontChineseNormalsimfang12));
//                phrase7.add(ChunkFactoryOld
//                        .underLine(book.getValue(21), 84, fontChineseNormalsimfang12));
//                phrase7.add(new Chunk(
//                        "人民法院提起行政诉讼，但本决定不停止执行，法律另有规定的除外。逾期不申请行政复议、不提起行政诉讼又不履行的，本机关将依法申请人民法院强制执行或者依照有关规定强制执行。",
//                        fontChineseNormalsimfang12));
//
//                paragraph7.add(phrase7);
//                document.add(paragraph7);
//
//                final Paragraph paragraph8 = new Paragraph();
//                paragraph8.setIndentationLeft(24f);
//
//                Phrase phrase8 = new Phrase();
//                phrase8.add(new Chunk("安全生产监管执法人员（签名）：", fontChineseNormalsimfang12));
//                phrase8.add(ChunkFactoryOld
//                        .underLine(book.getValue(22), 72, fontChineseNormalsimfang12));
//                phrase8.add(new Chunk("、", fontChineseNormalsimfang12));
//                phrase8.add(ChunkFactoryOld
//                        .underLine(book.getValue(23), 72, fontChineseNormalsimfang12));
//                phrase8.add("\n");
//                phrase8.add(new Chunk("当事人或委托代理人（签名）：", fontChineseNormalsimfang12));
//                phrase8.add(ChunkFactoryOld
//                        .underLine(book.getValue(24), 72, fontChineseNormalsimfang12));
//                phrase8.add("\n");
//
//                paragraph8.add(phrase8);
//                paragraph8.setLeading(26);
//                document.add(paragraph8);
//
//                final Paragraph paragraph9 = new Paragraph();
//                paragraph9.setFirstLineIndent(264f);
//                paragraph9.setLeading(24f);
//                paragraph9.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase10 = new Phrase();
//                phrase10.add(new Chunk("安全生产监督管理部门（公章）", fontChineseNormalsimfang12));
//                toMeasurefloat(phrase10);
//
//                paragraph9.add(phrase10);
//                document.add(paragraph9);
//
//                final Paragraph paragraph10 = new Paragraph();
//                paragraph10.setFirstLineIndent(264f);
//                paragraph10.setLeading(24f);
//                paragraph10.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase11 = new Phrase();
//                phrase11.add(ChunkFactoryOld.tablenounderLine(StringFactoryBuild.build().getTime(book.getValue(25), 0), 36,
//                        fontChineseNormalsimfang12));
//                phrase11.add(new Chunk("年", fontChineseNormalsimfang12));
//                phrase11.add(ChunkFactoryOld.tablenounderLine(StringFactoryBuild.build().getTime(book.getValue(25), 1), 12,
//                        fontChineseNormalsimfang12));
//                phrase11.add(new Chunk("月", fontChineseNormalsimfang12));
//                phrase11.add(ChunkFactoryOld.tablenounderLine(StringFactoryBuild.build().getTime(book.getValue(25), 2), 12,
//                        fontChineseNormalsimfang12));
//                phrase11.add(new Chunk("日", fontChineseNormalsimfang12));
//                toMeasurefloat(phrase11);
//
//                paragraph10.add(phrase11);
//                document.add(paragraph10);
//
//                final Paragraph bottomLine1 = new Paragraph(
//                        new Chunk(new LineSeparator()));// 加入一个换行
//                bottomLine1.setLeading(1f);
//                bottomLine1.setSpacingBefore(5f);
//
//                document.add(bottomLine1);
//
//                final Paragraph paragraph11 = new Paragraph();
//                Phrase phrase12 = new Phrase();
//                phrase12.add(new Chunk("本文书一式两份：一份由安全生产监督管理部门备案，一份交被处罚单位。",
//                        fontChineseNormalsimfang12));
//
//                paragraph11.add(phrase12);
//
//                document.add(paragraph11);
//
//                // checkbox start
//                PdfContentByte cb = dpfwPdfWriter.getDirectContent();
//                RadioCheckField bt = new RadioCheckField(dpfwPdfWriter,
//                        ChunkFactoryOld.setCheckBoxArea(105, 347, 10), "Yes274",
//                        ChunkFactoryOld.getCheck(book.getValue(16), 1));
//                bt.setCheckType(RadioCheckField.TYPE_CHECK);
//                bt.setBorderWidth(BaseField.BORDER_WIDTH_THIN);
//                bt.setBorderColor(BaseColor.BLACK);
//                bt.setChecked(true);
//                PdfFormField ck = bt.getCheckField();
//                dpfwPdfWriter.addAnnotation(ck);
//
//                RadioCheckField bt2 = new RadioCheckField(dpfwPdfWriter,
//                        ChunkFactoryOld.setCheckBoxArea(105, 323, 10), "Yes470",
//                        ChunkFactoryOld.getCheck(book.getValue(16), 2));
//                bt2.setCheckType(RadioCheckField.TYPE_CHECK);
//                bt2.setBorderWidth(BaseField.BORDER_WIDTH_THIN);
//                bt2.setBorderColor(BaseColor.BLACK);
//                bt2.setChecked(true);
//                PdfFormField ck2 = bt2.getCheckField();
//                dpfwPdfWriter.addAnnotation(ck2);
//
//                // checkbox end
//                PdfContentByte canvas = dpfwPdfWriter.getDirectContent();
//
////                Phrase phrase18 = new Phrase();
////
////                phrase18.add(new Chunk("违法事实及证据：", fontChineseNormalsimfang12));
////                ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phrase18,
////                        104, 588, 0);
//
//                PdfContentByte canvas2 = dpfwPdfWriter.getDirectContent();
//                // 电子签章
//                Image img = ImageBuilder.getInstance(image);
//                if (img != null) {
//                    img.setAbsolutePosition(350, 140);
//                    canvas2.addImage(img);
//                }
//                document.newPage();// 结束保存
//            }
//        });
//
//    }
//
//    //行政处罚决定书（单位）
//    public void printerEntity_Book25(final Base_Entity book, final Object image) {
//        printFrameWork(book, image, new IPdfBackFrame() {
//            @Override
//            public void writeContent() throws Exception {
//                //此处写页面布局
//                final Paragraph title = new Paragraph("" + city + "安全生产行政执法文书", fontChineseBoldsimhei15);// Paragraph就是段落
//                title.setLeading(1f);// 段落距离
//                // title.setSpacingBefore(25f);//段落留白
//                title.setAlignment(Element.ALIGN_CENTER);// 居中
//                document.add(title);// 写入文档
//                final Paragraph titleLine1 = new Paragraph(new Chunk(new LineSeparator()));// 加入一个换行
//                titleLine1.setLeading(1f);
//                titleLine1.setSpacingBefore(5f);
//                document.add(titleLine1);
//                final Paragraph titleLine2 = new Paragraph(new Chunk(new LineSeparator()));
//                titleLine2.setLeading(1f);
//                titleLine2.setSpacingBefore(1f);
//                document.add(titleLine2);
//                final Paragraph title2 = new Paragraph("行政处罚决定书（单位）", fontChineseBoldsimhei15);
//
//                title2.setLeading(1f);
//                title2.setSpacingBefore(17f);
//                title2.setAlignment(Element.ALIGN_CENTER);
//
//                document.add(title2);
//
//                final Paragraph title3 = new Paragraph("( " + book.getValue(0) + " )安监管罚〔" + book.getValue(1) + "〕"
//                        + book.getValue(2) + "号", fontChineseNormalsimfang12);
//                title3.setLeading(1f);
//                title3.setSpacingBefore(30f);
//                title3.setAlignment(Element.ALIGN_CENTER);
//                document.add(title3);
//
//                final Paragraph paragraph1 = new Paragraph();
//                paragraph1.setIndentationLeft(24f);
//                paragraph1.setLeading(24f);
//                paragraph1.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase1 = new Phrase();
//                phrase1.add(new Chunk("被处罚单位：", fontChineseNormalsimfang12));
//                phrase1.add(ChunkFactoryOld.underLine(book.getValue(3), 318,
//                        fontChineseNormalsimfang12));
//
//                Phrase phrase2 = new Phrase();
//                phrase2.add(new Chunk("地 址：", fontChineseNormalsimfang12));
//                phrase2.add(ChunkFactoryOld.underLine(book.getValue(4), 216,
//                        fontChineseNormalsimfang12));
//                phrase2.add(new Chunk("邮编：", fontChineseNormalsimfang12));
//                phrase2.add(ChunkFactoryOld.underLine(book.getValue(5), 84,
//                        fontChineseNormalsimfang12));
//
//                Phrase phrase3 = new Phrase();
//                phrase3.add(new Chunk("法定代表人（主要负责人）:", fontChineseNormalsimfang12));
//                phrase3.add(ChunkFactoryOld
//                        .underLine(book.getValue(6), 42, fontChineseNormalsimfang12));
//                phrase3.add(new Chunk("职务:", fontChineseNormalsimfang12));
//                phrase3.add(ChunkFactoryOld
//                        .underLine(book.getValue(7), 48, fontChineseNormalsimfang12));
//                phrase3.add(new Chunk("联系电话:", fontChineseNormalsimfang12));
//                phrase3.add(ChunkFactoryOld
//                        .underLine(book.getValue(8), 48, fontChineseNormalsimfang12));
//
//                paragraph1.add(phrase1);
//                paragraph1.add(phrase2);
//                paragraph1.add(phrase3);
//
//                document.add(paragraph1);
//
//                final Paragraph paragraph2 = new Paragraph();
//                paragraph2.setFirstLineIndent(24f);
//                paragraph2.setLeading(24f);
//                paragraph2.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase4 = new Phrase();
//                 phrase4.add(new Chunk("违法事实及证据", fontChineseNormalsimfang12));
//                phrase4.add(ChunkFactoryOld.underLine(book.getValue(9), 2772,
//                        fontChineseNormalsimfang12,106,430));
//                phrase4.add(new Chunk("（此栏不够，可另附页）", fontChineseNormalsimfang12));
//
//                paragraph2.add(phrase4);
//
//                document.add(paragraph2);
//
//                final Paragraph paragraph3 = new Paragraph();
//                paragraph3.setFirstLineIndent(24f);
//                paragraph3.setLeading(24f);
//                paragraph3.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase5 = new Phrase();
//                phrase5.add(new Chunk("以上事实违反了", fontChineseNormalsimfang12));
//                phrase5.add(ChunkFactoryOld.underLine(book.getValue(10), 306,
//                        fontChineseNormalsimfang12));
//                phrase5.add(new Chunk("的规定，依据", fontChineseNormalsimfang12));
//                phrase5.add(ChunkFactoryOld.underLine(book.getValue(11), 248,
//                        fontChineseNormalsimfang12));
//                phrase5.add(new Chunk("的规定，决定给予", fontChineseNormalsimfang12));
//                phrase5.add(ChunkFactoryOld.underLine(book.getValue(12), 330,
//                        fontChineseNormalsimfang12));
//                phrase5.add(new Chunk("的行政处罚。", fontChineseNormalsimfang12));
//
//                paragraph3.add(phrase5);
//                document.add(paragraph3);
//
//                final Paragraph paragraph6 = new Paragraph();
//                paragraph6.setAlignment(Element.ALIGN_LEFT);
//                paragraph6.setFirstLineIndent(22f);
//                paragraph6.setLeading(24f);
//
//                Phrase phrase6 = new Phrase();
//                phrase6.add(new Chunk("处以罚款的，罚款自收到本决定书之日起15日内缴至",
//                        fontChineseNormalsimfang12));
//                phrase6.add(ChunkFactoryOld.underLine(book.getValue(13), 120,
//                        fontChineseNormalsimfang12));
//                phrase6.add(new Chunk("，账号", fontChineseNormalsimfang12));
//                phrase6.add(ChunkFactoryOld.underLine(book.getValue(14), 120,
//                        fontChineseNormalsimfang12));
//                phrase6.add(new Chunk("，到期不缴每日按罚款款数额的3%加处罚款。", fontChineseNormalsimfang12));
//
//                paragraph6.add(phrase6);
//                document.add(paragraph6);
//
//                final Paragraph paragraph7 = new Paragraph();
//                paragraph7.setAlignment(Element.ALIGN_LEFT);
//                paragraph7.setFirstLineIndent(24f);
//                paragraph7.setLeading(24f);
//
//                Phrase phrase7 = new Phrase();
//                phrase7.add(new Chunk("如果不服本决定，可以依法在60日内向", fontChineseNormalsimfang12));
//                phrase7.add(ChunkFactoryOld.underLine(book.getValue(15), 120,
//                        fontChineseNormalsimfang12));
//                phrase7.add(new Chunk("人民政府或者", fontChineseNormalsimfang12));
//                phrase7.add(ChunkFactoryOld
//                        .underLine(book.getValue(16), 96, fontChineseNormalsimfang12));
//                phrase7.add(new Chunk("申请行政复议，或者在三个月内依法向", fontChineseNormalsimfang12));
//                phrase7.add(ChunkFactoryOld
//                        .underLine(book.getValue(17), 84, fontChineseNormalsimfang12));
//                phrase7.add(new Chunk(
//                        "人民法院提起行政诉讼，但本决定不停止执行，法律另有规定的除外。逾期不申请行政复议、不提起行政诉讼又不履行的，本机关将依法申请人民法院强制执行或者依照有关规定强制执行。",
//                        fontChineseNormalsimfang12));
//
//                paragraph7.add(phrase7);
//                document.add(paragraph7);
//                document.add(space1);
//                document.add(space1);
//                document.add(space2);
//                document.add(space2);
//                document.add(space2);
//                document.add(space2);
//                document.add(space2);
//
//                final Paragraph paragraph9 = new Paragraph();
//                paragraph9.setFirstLineIndent(264f);
//                paragraph9.setLeading(24f);
//                paragraph9.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase10 = new Phrase();
//                phrase10.add(new Chunk("安全生产监督管理部门（公章）", fontChineseNormalsimfang12));
//                toMeasurefloat(phrase10);
//
//                paragraph9.add(phrase10);
//                document.add(paragraph9);
//
//                final Paragraph paragraph10 = new Paragraph();
//                paragraph10.setFirstLineIndent(264f);
//                paragraph10.setLeading(24f);
//                paragraph10.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase11 = new Phrase();
//                phrase11.add(ChunkFactoryOld.tablenounderLine(StringFactoryBuild.build().getTime(book.getValue(18), 0), 36,
//                        fontChineseNormalsimfang12));
//                phrase11.add(new Chunk("年", fontChineseNormalsimfang12));
//                phrase11.add(ChunkFactoryOld.tablenounderLine(StringFactoryBuild.build().getTime(book.getValue(18), 1), 12,
//                        fontChineseNormalsimfang12));
//                phrase11.add(new Chunk("月", fontChineseNormalsimfang12));
//                phrase11.add(ChunkFactoryOld.tablenounderLine(StringFactoryBuild.build().getTime(book.getValue(18), 2), 12,
//                        fontChineseNormalsimfang12));
//                phrase11.add(new Chunk("日", fontChineseNormalsimfang12));
//                toMeasurefloat(phrase11);
//
//                paragraph10.add(phrase11);
//                document.add(paragraph10);
//
//                final Paragraph bottomLine1 = new Paragraph(
//                        new Chunk(new LineSeparator()));// 加入一个换行
//                bottomLine1.setLeading(1f);
//                bottomLine1.setSpacingBefore(5f);
//
//                document.add(bottomLine1);
//
//                final Paragraph paragraph11 = new Paragraph();
//                Phrase phrase12 = new Phrase();
//                phrase12.add(new Chunk("本文书一式两份：一份由安全生产监督管理部门备案，一份交被处罚单位。",
//                        fontChineseNormalsimfang12));
//
//                paragraph11.add(phrase12);
//
//                document.add(paragraph11);
//                PdfContentByte canvas = dpfwPdfWriter.getDirectContent();
//
////                Phrase phrase18 = new Phrase();
////
////                phrase18.add(new Chunk("违法事实及证据：", fontChineseNormalsimfang12));
////                ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phrase18,
////                        104, 588, 0);
//
//                PdfContentByte canvas2 = dpfwPdfWriter.getDirectContent();
//                // 电子签章
//                Image img = ImageBuilder.getInstance(image);
//                if (img != null) {
//                    img.setAbsolutePosition(350, 140);
//                    canvas2.addImage(img);
//                }
//                document.newPage();// 结束保存
//            }
//        });
//
//    }
//
//    //行政处罚决定书（个人）
//    public void printerEntity_Book26(final Base_Entity book, final Object image) {
//        printFrameWork(book, image, new IPdfBackFrame() {
//            @Override
//            public void writeContent() throws Exception {
//                //此处写页面布局
//                final Paragraph title = new Paragraph("" + city + "安全生产行政执法文书", fontChineseBoldsimhei15);// Paragraph就是段落
//                title.setLeading(1f);// 段落距离
//                // title.setSpacingBefore(25f);//段落留白
//                title.setAlignment(Element.ALIGN_CENTER);// 居中
//                document.add(title);// 写入文档
//                final Paragraph titleLine1 = new Paragraph(new Chunk(new LineSeparator()));// 加入一个换行
//                titleLine1.setLeading(1f);
//                titleLine1.setSpacingBefore(5f);
//                document.add(titleLine1);
//                final Paragraph titleLine2 = new Paragraph(new Chunk(new LineSeparator()));
//                titleLine2.setLeading(1f);
//                titleLine2.setSpacingBefore(1f);
//                document.add(titleLine2);
//                final Paragraph title2 = new Paragraph("行政处罚决定书（个人）", fontChineseBoldsimhei15);
//
//                title2.setLeading(1f);
//                title2.setSpacingBefore(17f);
//                title2.setAlignment(Element.ALIGN_CENTER);
//
//                document.add(title2);
//
//                final Paragraph title3 = new Paragraph("( " + book.getValue(0) + " )安监管罚〔" + book.getValue(1) + "〕"
//                        + book.getValue(2) + "号", fontChineseNormalsimfang12);
//                title3.setLeading(1f);
//                title3.setSpacingBefore(30f);
//                title3.setAlignment(Element.ALIGN_CENTER);
//                document.add(title3);
//
//                final Paragraph paragraph1 = new Paragraph();
//                paragraph1.setIndentationLeft(24f);
//                paragraph1.setLeading(24f);
//                paragraph1.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase1 = new Phrase();
//                phrase1.add(new Chunk("被处罚人：", fontChineseNormalsimfang12));
//                phrase1.add(ChunkFactoryOld
//                        .underLine(book.getValue(3), 60, fontChineseNormalsimfang12));
//                phrase1.add(new Chunk("性别：", fontChineseNormalsimfang12));
//                phrase1.add(ChunkFactoryOld
//                        .underLine(book.getValue(4), 24, fontChineseNormalsimfang12));
//                phrase1.add(new Chunk("年龄：", fontChineseNormalsimfang12));
//                phrase1.add(ChunkFactoryOld
//                        .underLine(book.getValue(5), 24, fontChineseNormalsimfang12));
//                phrase1.add(new Chunk("联系电话：", fontChineseNormalsimfang12));
//                phrase1.add(ChunkFactoryOld.underLine(book.getValue(6), 54,
//                        fontChineseNormalsimfang12));
//
//                Phrase phrase2 = new Phrase();
//                phrase2.add(new Chunk("家庭住址：", fontChineseNormalsimfang12));
//                phrase2.add(ChunkFactoryOld.underLine(book.getValue(7), 144,
//                        fontChineseNormalsimfang12));
//                phrase2.add(new Chunk("所在单位：", fontChineseNormalsimfang12));
//                phrase2.add(ChunkFactoryOld.underLine(book.getValue(8), 114,
//                        fontChineseNormalsimfang12));
//
//                Phrase phrase3 = new Phrase();
//                phrase3.add(new Chunk("职务:", fontChineseNormalsimfang12));
//                phrase3.add(ChunkFactoryOld
//                        .underLine(book.getValue(9), 96, fontChineseNormalsimfang12));
//                phrase3.add(new Chunk("单位地址:", fontChineseNormalsimfang12));
//                phrase3.add(ChunkFactoryOld
//                        .underLine(book.getValue(10), 96, fontChineseNormalsimfang12));
//                phrase3.add(new Chunk("邮编:", fontChineseNormalsimfang12));
//                phrase3.add(ChunkFactoryOld
//                        .underLine(book.getValue(11), 66, fontChineseNormalsimfang12));
//
//                paragraph1.add(phrase1);
//                paragraph1.add(phrase2);
//                paragraph1.add(phrase3);
//
//                document.add(paragraph1);
//
//                final Paragraph paragraph2 = new Paragraph();
//                paragraph2.setFirstLineIndent(24f);
//                paragraph2.setLeading(24f);
//                paragraph2.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase4 = new Phrase();
//                 phrase4.add(new Chunk("违法事实及证据", fontChineseNormalsimfang12));
//                phrase4.add(ChunkFactoryOld.underLine(book.getValue(12), 2772,
//                        fontChineseNormalsimfang12,108,430));
//                phrase4.add(new Chunk("（此栏不够，可另附页）", fontChineseNormalsimfang12));
//
//                paragraph2.add(phrase4);
//
//                document.add(paragraph2);
//
//                final Paragraph paragraph3 = new Paragraph();
//                paragraph3.setFirstLineIndent(24f);
//                paragraph3.setLeading(24f);
//                paragraph3.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase5 = new Phrase();
//                phrase5.add(new Chunk("以上事实违反了", fontChineseNormalsimfang12));
//                phrase5.add(ChunkFactoryOld.underLine(book.getValue(13), 312,
//                        fontChineseNormalsimfang12));
//                phrase5.add(new Chunk("的规定，依据", fontChineseNormalsimfang12));
//                phrase5.add(ChunkFactoryOld.underLine(book.getValue(14), 252,
//                        fontChineseNormalsimfang12));
//                phrase5.add(new Chunk("的规定，决定给予", fontChineseNormalsimfang12));
//                phrase5.add(ChunkFactoryOld.underLine(book.getValue(15), 330,
//                        fontChineseNormalsimfang12));
//                phrase5.add(new Chunk("的行政处罚。", fontChineseNormalsimfang12));
//
//                paragraph3.add(phrase5);
//                document.add(paragraph3);
//
//                final Paragraph paragraph6 = new Paragraph();
//                paragraph6.setAlignment(Element.ALIGN_LEFT);
//                paragraph6.setFirstLineIndent(22f);
//                paragraph6.setLeading(24f);
//
//                Phrase phrase6 = new Phrase();
//                phrase6.add(new Chunk("处以罚款的，罚款自收到本决定书之日起15日内缴至",
//                        fontChineseNormalsimfang12));
//                phrase6.add(ChunkFactoryOld.underLine(book.getValue(16), 120,
//                        fontChineseNormalsimfang12));
//                phrase6.add(new Chunk("，账号", fontChineseNormalsimfang12));
//                phrase6.add(ChunkFactoryOld.underLine(book.getValue(17), 120,
//                        fontChineseNormalsimfang12));
//                phrase6.add(new Chunk("，到期不缴每日按罚款款数额的3%加处罚款。", fontChineseNormalsimfang12));
//
//                paragraph6.add(phrase6);
//                document.add(paragraph6);
//
//                final Paragraph paragraph7 = new Paragraph();
//                paragraph7.setAlignment(Element.ALIGN_LEFT);
//                paragraph7.setFirstLineIndent(24f);
//                paragraph7.setLeading(24f);
//
//                Phrase phrase7 = new Phrase();
//                phrase7.add(new Chunk("如果不服本决定，可以依法在60日内向", fontChineseNormalsimfang12));
//                phrase7.add(ChunkFactoryOld.underLine(book.getValue(18), 120,
//                        fontChineseNormalsimfang12));
//                phrase7.add(new Chunk("人民政府或者", fontChineseNormalsimfang12));
//                phrase7.add(ChunkFactoryOld
//                        .underLine(book.getValue(19), 96, fontChineseNormalsimfang12));
//                phrase7.add(new Chunk("申请行政复议，或者在三个月内依法向", fontChineseNormalsimfang12));
//                phrase7.add(ChunkFactoryOld
//                        .underLine(book.getValue(20), 84, fontChineseNormalsimfang12));
//                phrase7.add(new Chunk(
//                        "人民法院提起行政诉讼，但本决定不停止执行，法律另有规定的除外。逾期不申请行政复议、不提起行政诉讼又不履行的，本机关将依法申请人民法院强制执行或者依照有关规定强制执行。",
//                        fontChineseNormalsimfang12));
//
//                paragraph7.add(phrase7);
//                document.add(paragraph7);
//                document.add(space1);
//                document.add(space1);
//                document.add(space2);
//                document.add(space2);
//                document.add(space2);
//                document.add(space2);
//                document.add(space2);
//
//                final Paragraph paragraph9 = new Paragraph();
//                paragraph9.setFirstLineIndent(264f);
//                paragraph9.setLeading(24f);
//                paragraph9.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase10 = new Phrase();
//                phrase10.add(new Chunk("安全生产监督管理部门（公章）", fontChineseNormalsimfang12));
//                toMeasurefloat(phrase10);
//
//                paragraph9.add(phrase10);
//                document.add(paragraph9);
//
//                final Paragraph paragraph10 = new Paragraph();
//                paragraph10.setFirstLineIndent(264f);
//                paragraph10.setLeading(24f);
//                paragraph10.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase11 = new Phrase();
//                phrase11.add(ChunkFactoryOld.tablenounderLine(StringFactoryBuild.build().getTime(book.getValue(21), 0), 36,
//                        fontChineseNormalsimfang12));
//                phrase11.add(new Chunk("年", fontChineseNormalsimfang12));
//                phrase11.add(ChunkFactoryOld.tablenounderLine(StringFactoryBuild.build().getTime(book.getValue(21), 1), 12,
//                        fontChineseNormalsimfang12));
//                phrase11.add(new Chunk("月", fontChineseNormalsimfang12));
//                phrase11.add(ChunkFactoryOld.tablenounderLine(StringFactoryBuild.build().getTime(book.getValue(21), 2), 12,
//                        fontChineseNormalsimfang12));
//                phrase11.add(new Chunk("日", fontChineseNormalsimfang12));
//                toMeasurefloat(phrase11);
//
//                paragraph10.add(phrase11);
//                document.add(paragraph10);
//
//                final Paragraph bottomLine1 = new Paragraph(
//                        new Chunk(new LineSeparator()));// 加入一个换行
//                bottomLine1.setLeading(1f);
//                bottomLine1.setSpacingBefore(5f);
//
//                document.add(bottomLine1);
//
//                final Paragraph paragraph11 = new Paragraph();
//                Phrase phrase12 = new Phrase();
//                phrase12.add(new Chunk("本文书一式两份：一份由安全生产监督管理部门备案，一份交被处罚单位。",
//                        fontChineseNormalsimfang12));
//
//                paragraph11.add(phrase12);
//
//                document.add(paragraph11);
//                PdfContentByte canvas = dpfwPdfWriter.getDirectContent();
//
////                Phrase phrase18 = new Phrase();
////
////                phrase18.add(new Chunk("违法事实及证据：", fontChineseNormalsimfang12));
////                ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phrase18,
////                        104, 588, 0);
//
//                PdfContentByte canvas2 = dpfwPdfWriter.getDirectContent();
//                // 电子签章
//                Image img = ImageBuilder.getInstance(image);
//                if (img != null) {
//                    img.setAbsolutePosition(350, 140);
//                    canvas2.addImage(img);
//                }
//                document.newPage();// 结束保存
//            }
//        });
//
//    }
//
//    //罚款催缴通知书
//    public void printerEntity_Book27(final Base_Entity book, final Object image) {
//        printFrameWork(book, image, new IPdfBackFrame() {
//            @Override
//            public void writeContent() throws Exception {
//                //此处写页面布局
//                final Paragraph title = new Paragraph("" + city + "安全生产行政执法文书", fontChineseBoldsimhei15);// Paragraph就是段落
//                title.setLeading(1f);// 段落距离
//                // title.setSpacingBefore(25f);//段落留白
//                title.setAlignment(Element.ALIGN_CENTER);// 居中
//                document.add(title);// 写入文档
//                final Paragraph titleLine1 = new Paragraph(new Chunk(new LineSeparator()));// 加入一个换行
//                titleLine1.setLeading(1f);
//                titleLine1.setSpacingBefore(5f);
//                document.add(titleLine1);
//                final Paragraph titleLine2 = new Paragraph(new Chunk(new LineSeparator()));
//                titleLine2.setLeading(1f);
//                titleLine2.setSpacingBefore(1f);
//                document.add(titleLine2);
//                final Paragraph title2 = new Paragraph("罚款催缴通知书", fontChineseBoldsimhei15);
//
//                title2.setLeading(1f);
//                title2.setSpacingBefore(17f);
//                title2.setAlignment(Element.ALIGN_CENTER);
//                document.add(title2);
//
//                final Paragraph title3 = new Paragraph("( " + book.getValue(0) + " )安监管催〔" + book.getValue(1) + "〕"
//                        + book.getValue(2) + "号", fontChineseNormalsimfang12);
//                title3.setLeading(1f);
//                title3.setSpacingBefore(30f);
//                title3.setAlignment(Element.ALIGN_CENTER);
//                document.add(title3);
//
//                document.add(space2);
//                document.add(space2);
//                document.add(space2);
//                document.add(space2);
//
//                final Paragraph entParagraph = new Paragraph();
//                entParagraph.setLeading(24f);
//                entParagraph.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase1 = new Phrase();
//                phrase1.add((ChunkFactoryOld.underLine(book.getValue(3), 216,
//                        fontChineseNormalsimfang12)));
//                phrase1.add(new Chunk(":", fontChineseNormalsimfang12));
//                toMeasurefloat(phrase1);
//
//                entParagraph.add(phrase1);
//
//                document.add(entParagraph);
//                document.add(space1);
//                document.add(space2);
//                document.add(space2);
//                document.add(space2);
//
//                final Paragraph paragraph1 = new Paragraph();
//                paragraph1.setFirstLineIndent(24f);
//                paragraph1.setLeading(24f);
//                paragraph1.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase2 = new Phrase();
//                phrase2.add(new Chunk("本机关于", fontChineseNormalsimfang12));
//                phrase2.add(ChunkFactoryOld
//                        .underLine(StringFactoryBuild.build().getTime(book.getValue(4), 0), 24, fontChineseNormalsimfang12));
//                phrase2.add(new Chunk("年", fontChineseNormalsimfang12));
//                phrase2.add(ChunkFactoryOld
//                        .underLine(StringFactoryBuild.build().getTime(book.getValue(4), 1), 24, fontChineseNormalsimfang12));
//                phrase2.add(new Chunk("月", fontChineseNormalsimfang12));
//                phrase2.add(ChunkFactoryOld
//                        .underLine(StringFactoryBuild.build().getTime(book.getValue(4), 2), 24, fontChineseNormalsimfang12));
//                phrase2.add(new Chunk("日发出", fontChineseNormalsimfang12));
//                phrase2.add(ChunkFactoryOld.underLine(book.getValue(5), 132,
//                        fontChineseNormalsimfang12));
//                phrase2.add(new Chunk("号行政处罚决定书，要求你（单位）于", fontChineseNormalsimfang12));
//                phrase2.add(ChunkFactoryOld
//                        .underLine(StringFactoryBuild.build().getTime(book.getValue(6), 0), 60, fontChineseNormalsimfang12));
//                phrase2.add(new Chunk("年", fontChineseNormalsimfang12));
//                phrase2.add(ChunkFactoryOld
//                        .underLine(StringFactoryBuild.build().getTime(book.getValue(6), 1), 42, fontChineseNormalsimfang12));
//                phrase2.add(new Chunk("月", fontChineseNormalsimfang12));
//                phrase2.add(ChunkFactoryOld
//                        .underLine(StringFactoryBuild.build().getTime(book.getValue(6), 2), 42, fontChineseNormalsimfang12));
//                phrase2.add(new Chunk("日前将罚款缴至", fontChineseNormalsimfang12));
//                phrase2.add(ChunkFactoryOld.underLine(book.getValue(7), 144,
//                        fontChineseNormalsimfang12));
//                phrase2.add(new Chunk(
//                        "。因你（单位）至今未履行该处罚决定，现要求你（单位）立即缴纳罚款，并根据《中华人民共和国行政处罚法》第五十一条第（一）项的规定，每日按罚款数额的3%加处罚款。加处的罚款由代收机构直接收缴。",
//                        fontChineseNormalsimfang12));
//
//                paragraph1.add(phrase2);
//                document.add(paragraph1);
//
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//
//                final Paragraph paragraph3 = new Paragraph();
//                paragraph3.setFirstLineIndent(264f);
//                paragraph3.setLeading(24f);
//                paragraph3.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase4 = new Phrase();
//                phrase4.add(new Chunk("安全生产监督管理部门（公章）", fontChineseNormalsimfang12));
//                toMeasurefloat(phrase4);
//
//                paragraph3.add(phrase4);
//                document.add(paragraph3);
//
//                final Paragraph paragraph4 = new Paragraph();
//                paragraph4.setFirstLineIndent(264f);
//                paragraph4.setLeading(24f);
//                paragraph4.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase5 = new Phrase();
//                phrase5.add(ChunkFactoryOld.tablenounderLine(StringFactoryBuild.build().getTime(book.getValue(8), 0), 36,
//                        fontChineseNormalsimfang12));
//                phrase5.add(new Chunk("年", fontChineseNormalsimfang12));
//                phrase5.add(ChunkFactoryOld.tablenounderLine(StringFactoryBuild.build().getTime(book.getValue(8), 1), 12,
//                        fontChineseNormalsimfang12));
//                phrase5.add(new Chunk("月", fontChineseNormalsimfang12));
//                phrase5.add(ChunkFactoryOld.tablenounderLine(StringFactoryBuild.build().getTime(book.getValue(8), 2), 12,
//                        fontChineseNormalsimfang12));
//                phrase5.add(new Chunk("日", fontChineseNormalsimfang12));
//                toMeasurefloat(phrase5);
//
//                paragraph4.add(phrase5);
//                document.add(paragraph4);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                final Paragraph bottomLine1 = new Paragraph(
//                        new Chunk(new LineSeparator()));// 加入一个换行
//                bottomLine1.setLeading(1f);
//                bottomLine1.setSpacingBefore(10f);
//
//                document.add(bottomLine1);
//
//                final Paragraph paragraph9 = new Paragraph();
//                Phrase phrase14 = new Phrase();
//                phrase14.add(new Chunk("本文书一式两份：一份由安全生产监督管理部门备案，一份交被通知当事人。",
//                        fontChineseNormalsimfang12));
//                paragraph9.add(phrase14);
//
//                document.add(paragraph9);
//
//                PdfContentByte canvas2 = dpfwPdfWriter.getDirectContent();
//                // 电子签章
//                Image img = ImageBuilder.getInstance(image);
//                if (img != null) {
//                    img.setAbsolutePosition(350, 140);
//                    canvas2.addImage(img);
//                }
//                document.newPage();// 结束保存
//            }
//        });
//
//    }
//
//    //延期（分期）缴纳罚款审批表
//    public void printerEntity_Book28(final Base_Entity book, final Object image) {
//        printFrameWork(book, image, new IPdfBackFrame() {
//            @Override
//            public void writeContent() throws Exception {
//                //此处写页面布局
//                final Paragraph title = new Paragraph("" + city + "安全生产行政执法文书", fontChineseBoldsimhei15);// Paragraph就是段落
//                title.setLeading(1f);// 段落距离
//                // title.setSpacingBefore(25f);//段落留白
//                title.setAlignment(Element.ALIGN_CENTER);// 居中
//                document.add(title);// 写入文档
//                final Paragraph titleLine1 = new Paragraph(new Chunk(new LineSeparator()));// 加入一个换行
//                titleLine1.setLeading(1f);
//                titleLine1.setSpacingBefore(5f);
//                document.add(titleLine1);
//                final Paragraph titleLine2 = new Paragraph(new Chunk(new LineSeparator()));
//                titleLine2.setLeading(1f);
//                titleLine2.setSpacingBefore(1f);
//                document.add(titleLine2);
//                final Paragraph title2 = new Paragraph("延期（分期）缴纳罚款审批表", fontChineseBoldsimhei15);
//
//                title2.setLeading(1f);
//                title2.setSpacingBefore(17f);
//                title2.setAlignment(Element.ALIGN_CENTER);
//                document.add(title2);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//
//                PdfPTable table = new PdfPTable(1);
//                table.setWidthPercentage(100f);
//
//                PdfPCell cell01 = new PdfPCell();
//                final Paragraph cell01p = new Paragraph("案件名称", fontChineseNormalsimfang12);
//                cell01p.setAlignment(Element.ALIGN_CENTER);
//                cell01p.setLeading(24f);
//                cell01.addElement(cell01p);
//                PdfPCell cell02 = new PdfPCell();
//                final Paragraph cell02p = new Paragraph();
//                Phrase phrase02p = new Phrase();
//                phrase02p.add(ChunkFactoryOld.tablenounderLine(book.getValue(3), 272, fontChineseNormalsimfang12));
//                cell02p.add(phrase02p);
//                cell02p.setLeading(24f);
//                cell02.addElement(cell02p);
//                PdfPTable table1 = new PdfPTable(2);
//                float[] tablewidths = new float[2];
//                tablewidths[0] = 3f;
//                tablewidths[1] = 14f;
//                table1.setWidths(tablewidths);
//                table1.addCell(cell01);
//                table1.addCell(cell02);
//                PdfPCell row0 = new PdfPCell(table1);
//                row0.setFixedHeight(34f);
//                table.addCell(row0);
//
//                PdfPCell cell11 = new PdfPCell();
//                final Paragraph cell11p = new Paragraph("处罚决定书\n文号", fontChineseNormalsimfang12);
//                cell11p.setAlignment(Element.ALIGN_CENTER);
//                cell11p.setLeading(24f);
//                cell11.addElement(cell11p);
//                PdfPCell cell12 = new PdfPCell();
//                final Paragraph cell12p = new Paragraph();
//
//                Phrase phrase12p = new Phrase();
//                phrase12p.add(ChunkFactoryOld.tablenounderLine(book.getValue(4), 744, fontChineseNormalsimfang12));
//                cell12p.add(phrase12p);
//
//                cell12p.setLeading(24f);
//                cell12.addElement(cell12p);
//                PdfPTable table2 = new PdfPTable(2);
//                table2.setWidths(tablewidths);
//                table2.addCell(cell11);
//                table2.addCell(cell12);
//                PdfPCell row1 = new PdfPCell(table2);
//                row1.setFixedHeight(60f);
//                table.addCell(row1);
//
//                PdfPCell cell31 = new PdfPCell();
//                final Paragraph cell31p = new Paragraph("当事人", fontChineseNormalsimfang12);
//                cell31p.setAlignment(Element.ALIGN_CENTER);
//                cell31p.setLeading(24f);
//                cell31.addElement(cell31p);
//                PdfPCell cell32 = new PdfPCell();
//                final Paragraph cell32p = new Paragraph();
//
//                Phrase phrase32p = new Phrase();
//                phrase32p.add(ChunkFactoryOld.tablenounderLine(book.getValue(5), 124, fontChineseNormalsimfang12));
//                cell32p.add(phrase32p);
//
//                cell32p.setLeading(24f);
//                cell32.addElement(cell32p);
//                PdfPCell cell33 = new PdfPCell();
//                final Paragraph cell33p = new Paragraph("地址", fontChineseNormalsimfang12);
//                cell33p.setAlignment(Element.ALIGN_CENTER);
//                cell33p.setLeading(24f);
//                cell33.addElement(cell33p);
//                PdfPCell cell34 = new PdfPCell();
//                final Paragraph cell34p = new Paragraph();
//
//                Phrase phrase34p = new Phrase();
//                phrase34p.add(ChunkFactoryOld.tablenounderLine(book.getValue(6), 124, fontChineseNormalsimfang12));
//                cell34p.add(phrase34p);
//
//                cell34p.setLeading(24f);
//                cell34.addElement(cell34p);
//                PdfPTable table3 = new PdfPTable(4);
//                float[] tablewidths2 = new float[4];
//                tablewidths2[0] = 3f;
//                tablewidths2[1] = 6f;
//                tablewidths2[2] = 2f;
//                tablewidths2[3] = 6f;
//                table3.setWidths(tablewidths2);
//                table3.addCell(cell31);
//                table3.addCell(cell32);
//                table3.addCell(cell33);
//                table3.addCell(cell34);
//                PdfPCell row2 = new PdfPCell(table3);
//                row2.setFixedHeight(32f);
//                table.addCell(row2);
//
//                PdfPCell cell41 = new PdfPCell();
//                final Paragraph cell41p = new Paragraph("\n\n违法事实\n及处罚决定",
//                        fontChineseNormalsimfang12);
//                cell41p.setAlignment(Element.ALIGN_CENTER);
//                cell41p.setLeading(24f);
//                cell41.addElement(cell41p);
//                PdfPCell cell42 = new PdfPCell();
//                final Paragraph cell42p = new Paragraph();
//
//                Phrase phrase42p = new Phrase();
//                phrase42p.add(ChunkFactoryOld.tablenounderLine(book.getValue(7), 1488, fontChineseNormalsimfang12));
//                cell42p.add(phrase42p);
//
//
//                cell42p.setLeading(24f);
//                cell42.addElement(cell42p);
//                PdfPTable table4 = new PdfPTable(2);
//                table4.setWidths(tablewidths);
//                table4.addCell(cell41);
//                table4.addCell(cell42);
//                PdfPCell row3 = new PdfPCell(table4);
//                row3.setFixedHeight(140f);
//                table.addCell(row3);
//
//                PdfPCell cell51 = new PdfPCell();
//                final Paragraph cell51p = new Paragraph("当事人申请\n延期（分期）\n缴纳罚款的\n理由",
//                        fontChineseNormalsimfang12);
//                cell51p.setAlignment(Element.ALIGN_CENTER);
//                cell51p.setLeading(24f);
//                cell51.addElement(cell51p);
//                PdfPCell cell52 = new PdfPCell();
//                final Paragraph cell52p = new Paragraph();
//
//                Phrase phrase52p = new Phrase();
//                phrase52p.add(ChunkFactoryOld.tablenounderLine(book.getValue(8), 1488, fontChineseNormalsimfang12));
//                cell52p.add(phrase52p);
//
//                cell52p.setLeading(24f);
//                cell52.addElement(cell52p);
//                PdfPTable table5 = new PdfPTable(2);
//                table5.setWidths(tablewidths);
//                table5.addCell(cell51);
//                table5.addCell(cell52);
//                PdfPCell row4 = new PdfPCell(table5);
//                row4.setFixedHeight(110f);
//                table.addCell(row4);
//
//                PdfPCell cell61 = new PdfPCell();
//                final Paragraph cell61p = new Paragraph("\n承办人意见", fontChineseNormalsimfang12);
//                cell61p.setAlignment(Element.ALIGN_CENTER);
//                cell61p.setLeading(24f);
//                PdfPTable table62 = new PdfPTable(1);
//                cell61.addElement(cell61p);
//                PdfPCell cell62 = new PdfPCell(table62);
//                PdfPCell cell62_1 = new PdfPCell();
//                PdfPCell cell62_2 = new PdfPCell();
//                final Paragraph cell62p = new Paragraph();
//                cell62p.setAlignment(Element.ALIGN_LEFT);
//                cell62p.setLeading(18f);
//                cell62_1.setBorder(0);
//                cell62_1.setFixedHeight(30f);
//                cell62_2.setBorder(0);
//                cell62_2.setFixedHeight(30f);
//                final Paragraph cell62p1 = new Paragraph();
//                cell62p1.setAlignment(Element.ALIGN_LEFT);
//                cell62p1.setLeading(18f);
//
//                Phrase phrase1 = new Phrase();
//                Phrase phrase1_1 = new Phrase();
//                phrase1.add(ChunkFactoryOld.tablenounderLine(book.getValue(9), 332,
//                        fontChineseNormalsimfang12));
//                phrase1_1.add(new Chunk("承办人（签名）：", fontChineseNormalsimfang12));
//                phrase1_1.add(ChunkFactoryOld.underLine(book.getValue(10), 60,
//                        fontChineseNormalsimfang12));
//                phrase1_1.add(ChunkFactoryOld.tablenounderLine("", 24,
//                        fontChineseNormalsimfang12));
//                phrase1_1.add(ChunkFactoryOld.underLine(book.getValue(11), 60,
//                        fontChineseNormalsimfang12));
//                phrase1_1.add(ChunkFactoryOld.tablenounderLine("", 1050,
//                        fontChineseNormalsimfang12));
//                phrase1_1.add(ChunkFactoryOld.tablenounderLine(StringFactoryBuild.build().getTime(book.getValue(12), 0), 36,
//                        fontChineseNormalsimfang12));
//                phrase1_1.add(new Chunk("年", fontChineseNormalsimfang12));
//                phrase1_1.add(ChunkFactoryOld.tablenounderLine(StringFactoryBuild.build().getTime(book.getValue(12), 1), 6,
//                        fontChineseNormalsimfang12));
//                phrase1_1.add(new Chunk("月", fontChineseNormalsimfang12));
//                phrase1_1.add(ChunkFactoryOld.tablenounderLine(StringFactoryBuild.build().getTime(book.getValue(12), 2), 6,
//                        fontChineseNormalsimfang12));
//                phrase1_1.add(new Chunk("日", fontChineseNormalsimfang12));
//                cell62p.add(phrase1);
//                cell62p1.add(phrase1_1);
//                cell62_1.addElement(cell62p);
//                cell62_2.addElement(cell62p1);
//                table62.addCell(cell62_1);
//                table62.addCell(cell62_2);
//                PdfPTable table6 = new PdfPTable(2);
//                table6.setWidths(tablewidths);
//                table6.addCell(cell61);
//                table6.addCell(cell62);
//                PdfPCell row5 = new PdfPCell(table6);
//                row5.setFixedHeight(92f);
//                table.addCell(row5);
//
//                PdfPCell cell71 = new PdfPCell();
//                final Paragraph cell71p = new Paragraph("\n审核意见", fontChineseNormalsimfang12);
//                cell71p.setAlignment(Element.ALIGN_CENTER);
//                cell71p.setLeading(24f);
//                cell71.addElement(cell71p);
//                PdfPTable table7_1 = new PdfPTable(1);
//
//                PdfPCell cell72 = new PdfPCell(table7_1);
//                PdfPCell cell72_1 = new PdfPCell();
//                PdfPCell cell72_2 = new PdfPCell();
//                cell72_1.setBorder(0);
//                cell72_1.setFixedHeight(50f);
//                cell72_2.setBorder(0);
//                cell72_2.setFixedHeight(10f);
//                final Paragraph cell72p = new Paragraph("", fontChineseNormalsimfang12);
//                cell72p.setAlignment(Element.ALIGN_LEFT);
//                cell72p.setLeading(14f);
//                cell72p.setIndentationLeft(18f);
//                Phrase phrase2 = new Phrase();
//                final Paragraph cell72p1 = new Paragraph("", fontChineseNormalsimfang12);
//                cell72p1.setAlignment(Element.ALIGN_LEFT);
//                cell72p1.setLeading(14f);
//                cell72p1.setIndentationLeft(18f);
//                Phrase phrase21 = new Phrase();
//                phrase2.add(ChunkFactoryOld.tablenounderLine(book.getValue(13), 864,
//                        fontChineseNormalsimfang12));
//                phrase21.add(new Chunk("审核人（签名）：", fontChineseNormalsimfang12));
//                phrase21.add(ChunkFactoryOld.tablenounderLine(book.getValue(14), 108,
//                        fontChineseNormalsimfang12));
//                phrase21.add(ChunkFactoryOld.tablenounderLine(StringFactoryBuild.build().getTime(book.getValue(15), 0), 36,
//                        fontChineseNormalsimfang12));
//                phrase21.add(new Chunk("年", fontChineseNormalsimfang12));
//                phrase21.add(ChunkFactoryOld.tablenounderLine(StringFactoryBuild.build().getTime(book.getValue(15), 1), 6,
//                        fontChineseNormalsimfang12));
//                phrase21.add(new Chunk("月", fontChineseNormalsimfang12));
//                phrase21.add(ChunkFactoryOld.tablenounderLine(StringFactoryBuild.build().getTime(book.getValue(15), 2), 6,
//                        fontChineseNormalsimfang12));
//                phrase21.add(new Chunk("日", fontChineseNormalsimfang12));
//                cell72p.add(phrase2);
//                cell72p1.add(phrase21);
//                cell72_1.addElement(cell72p);
//                cell72_2.addElement(cell72p1);
//                table7_1.addCell(cell72_1);
//                table7_1.addCell(cell72_2);
//                PdfPTable table7 = new PdfPTable(2);
//                table7.setWidths(tablewidths);
//                table7.addCell(cell71);
//                table7.addCell(cell72);
//                PdfPCell row6 = new PdfPCell(table7);
//                row6.setFixedHeight(76f);
//                table.addCell(row6);
//
//                PdfPCell cell81 = new PdfPCell();
//                final Paragraph cell81p = new Paragraph("\n审批意见", fontChineseNormalsimfang12);
//                cell81p.setAlignment(Element.ALIGN_CENTER);
//                cell81p.setLeading(24f);
//                cell81.addElement(cell81p);
//                PdfPTable table8_1 = new PdfPTable(1);
//
//                PdfPCell cell82 = new PdfPCell(table8_1);
//                PdfPCell cell82_1 = new PdfPCell();
//                PdfPCell cell82_2 = new PdfPCell();
//                cell82_1.setBorder(0);
//                cell82_1.setFixedHeight(50f);
//                cell82_2.setBorder(0);
//                cell82_2.setFixedHeight(10f);
//                final Paragraph cell82p = new Paragraph("", fontChineseNormalsimfang12);
//                cell82p.setAlignment(Element.ALIGN_LEFT);
//                cell82p.setLeading(14f);
//                cell82p.setIndentationLeft(18f);
//                Phrase phrase82 = new Phrase();
//                final Paragraph cell82p1 = new Paragraph("", fontChineseNormalsimfang12);
//                cell82p1.setAlignment(Element.ALIGN_LEFT);
//                cell82p1.setLeading(14f);
//                cell82p1.setIndentationLeft(18f);
//                Phrase phrase821 = new Phrase();
//                phrase82.add(ChunkFactoryOld.tablenounderLine(book.getValue(16), 884,
//                        fontChineseNormalsimfang12));
//                phrase821.add(new Chunk("审批人（签名）：", fontChineseNormalsimfang12));
//                phrase821.add(ChunkFactoryOld.tablenounderLine(book.getValue(17), 108,
//                        fontChineseNormalsimfang12));
//                phrase821.add(ChunkFactoryOld.tablenounderLine(StringFactoryBuild.build().getTime(book.getValue(17), 0), 36,
//                        fontChineseNormalsimfang12));
//                phrase821.add(new Chunk("年", fontChineseNormalsimfang12));
//                phrase821.add(ChunkFactoryOld.tablenounderLine(StringFactoryBuild.build().getTime(book.getValue(17), 1), 6,
//                        fontChineseNormalsimfang12));
//                phrase821.add(new Chunk("月", fontChineseNormalsimfang12));
//                phrase821.add(ChunkFactoryOld.tablenounderLine(StringFactoryBuild.build().getTime(book.getValue(17), 2), 6,
//                        fontChineseNormalsimfang12));
//                phrase821.add(new Chunk("日", fontChineseNormalsimfang12));
//                cell82p.add(phrase82);
//                cell82p1.add(phrase821);
//                cell82_1.addElement(cell82p);
//                cell82_2.addElement(cell82p1);
//                table8_1.addCell(cell82_1);
//                table8_1.addCell(cell82_2);
//                PdfPTable table8 = new PdfPTable(2);
//                table8.setWidths(tablewidths);
//                table8.addCell(cell81);
//                table8.addCell(cell82);
//                PdfPCell row7 = new PdfPCell(table8);
//                row7.setFixedHeight(86f);
//                table.addCell(row7);
//
//                document.add(table);
//
//                PdfContentByte canvas2 = dpfwPdfWriter.getDirectContent();
//                // 电子签章
//                Image img = ImageBuilder.getInstance(image);
//                if (img != null) {
//                    img.setAbsolutePosition(350, 140);
//                    canvas2.addImage(img);
//                }
//
//                document.newPage();// 结束保存
//            }
//        });
//
//    }
//
//    //延期（分期）缴纳罚款批准书
//    public void printerEntity_Book29(final Base_Entity book, final Object image) {
//        printFrameWork(book, image, new IPdfBackFrame() {
//            @Override
//            public void writeContent() throws Exception {
//                //此处写页面布局
//                final Paragraph title = new Paragraph("" + city + "安全生产行政执法文书", fontChineseBoldsimhei15);// Paragraph就是段落
//                title.setLeading(1f);// 段落距离
//                // title.setSpacingBefore(25f);//段落留白
//                title.setAlignment(Element.ALIGN_CENTER);// 居中
//                document.add(title);// 写入文档
//                final Paragraph titleLine1 = new Paragraph(new Chunk(new LineSeparator()));// 加入一个换行
//                titleLine1.setLeading(1f);
//                titleLine1.setSpacingBefore(5f);
//                document.add(titleLine1);
//                final Paragraph titleLine2 = new Paragraph(new Chunk(new LineSeparator()));
//                titleLine2.setLeading(1f);
//                titleLine2.setSpacingBefore(1f);
//                document.add(titleLine2);
//                final Paragraph title2 = new Paragraph("延期（分期）缴纳罚款批准书", fontChineseBoldsimhei15);
//
//                title2.setLeading(1f);
//                title2.setSpacingBefore(17f);
//                title2.setAlignment(Element.ALIGN_CENTER);
//                document.add(title2);
//
//                final Paragraph title3 = new Paragraph("( " + book.getValue(0) + " )安监管缴批〔" + book.getValue(1) + "〕"
//                        + book.getValue(2) + "号", fontChineseNormalsimfang12);
//                title3.setLeading(1f);
//                title3.setSpacingBefore(25f);
//                title3.setAlignment(Element.ALIGN_CENTER);
//                document.add(title3);
//
//                final Paragraph entParagraph = new Paragraph();
//                entParagraph.setLeading(24f);
//                entParagraph.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase1 = new Phrase();
//                phrase1.add((ChunkFactoryOld.underLine(book.getValue(3), 216,
//                        fontChineseNormalsimfang12)));
//                phrase1.add(new Chunk(":", fontChineseNormalsimfang12));
//                toMeasurefloat(phrase1);
//
//                entParagraph.add(phrase1);
//
//                document.add(entParagraph);
//
//                final Paragraph paragraph1 = new Paragraph();
//                paragraph1.setFirstLineIndent(24f);
//                paragraph1.setLeading(24f);
//                paragraph1.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase2 = new Phrase();
//                phrase2.add(ChunkFactoryOld
//                        .underLine(StringFactoryBuild.build().getTime(book.getValue(4), 0), 24, fontChineseNormalsimfang12));
//                phrase2.add(new Chunk("年", fontChineseNormalsimfang12));
//                phrase2.add(ChunkFactoryOld
//                        .underLine(StringFactoryBuild.build().getTime(book.getValue(4), 1), 12, fontChineseNormalsimfang12));
//                phrase2.add(new Chunk("月", fontChineseNormalsimfang12));
//                phrase2.add(ChunkFactoryOld
//                        .underLine(StringFactoryBuild.build().getTime(book.getValue(4), 2), 12, fontChineseNormalsimfang12));
//                phrase2.add(new Chunk("日，本机关对你（单位）发出", fontChineseNormalsimfang12));
//                phrase2.add(ChunkFactoryOld.underLine(book.getValue(5), 126,
//                        fontChineseNormalsimfang12));
//                phrase2.add(new Chunk("号《行政处罚决定书》，作出了对你（单位）罚款", fontChineseNormalsimfang12));
//                phrase2.add(ChunkFactoryOld.underLine(book.getValue(6), 264,
//                        fontChineseNormalsimfang12,266,430));
//                phrase2.add(new Chunk(
//                        "（大写）的决定，现根据你（单位）的申请，本机关依据《中华人民共和国行政处罚法》第五十二条的规定，同意你（单位）：",
//                        fontChineseNormalsimfang12));
//
//                paragraph1.add(phrase2);
//
//                document.add(paragraph1);
//
//                final Paragraph paragraph2 = new Paragraph();
//                paragraph2.setIndentationLeft(36f);
//                paragraph2.setLeading(24f);
//                paragraph2.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase3 = new Phrase();
//                phrase3.add(new Chunk("延期缴纳罚款。延长至", fontChineseNormalsimfang12));
//                phrase3.add(ChunkFactoryOld
//                        .underLine(StringFactoryBuild.build().getTime(book.getValue(8), 0), 18, fontChineseNormalsimfang12));
//                phrase3.add(new Chunk("年", fontChineseNormalsimfang12));
//                phrase3.add(ChunkFactoryOld
//                        .underLine(StringFactoryBuild.build().getTime(book.getValue(8), 1), 18, fontChineseNormalsimfang12));
//                phrase3.add(new Chunk("月", fontChineseNormalsimfang12));
//                phrase3.add(ChunkFactoryOld
//                        .underLine(StringFactoryBuild.build().getTime(book.getValue(8), 2), 18, fontChineseNormalsimfang12));
//                phrase3.add(new Chunk("日（大写）止。", fontChineseNormalsimfang12));
//
//                paragraph2.add(phrase3);
//
//                document.add(paragraph2);
//
//                final Paragraph paragraph3 = new Paragraph();
//                paragraph3.setFirstLineIndent(36f);
//                paragraph3.setLeading(24f);
//                paragraph3.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase4 = new Phrase();
//                phrase4.add(new Chunk("分期缴纳罚款。第", fontChineseNormalsimfang12));
//                phrase4.add(ChunkFactoryOld
//                        .underLine(book.getValue(9), 36, fontChineseNormalsimfang12));
//                phrase4.add(new Chunk("期至", fontChineseNormalsimfang12));
//                phrase4.add(ChunkFactoryOld
//                        .underLine(StringFactoryBuild.build().getTime(book.getValue(10), 0), 18, fontChineseNormalsimfang12));
//                phrase4.add(new Chunk("年", fontChineseNormalsimfang12));
//                phrase4.add(ChunkFactoryOld
//                        .underLine(StringFactoryBuild.build().getTime(book.getValue(10), 1), 18, fontChineseNormalsimfang12));
//                phrase4.add(new Chunk("月", fontChineseNormalsimfang12));
//                phrase4.add(ChunkFactoryOld
//                        .underLine(StringFactoryBuild.build().getTime(book.getValue(10), 2), 18, fontChineseNormalsimfang12));
//                phrase4.add(new Chunk("日（大写）前，缴纳罚款", fontChineseNormalsimfang12));
//                phrase4.add(ChunkFactoryOld.underLine(book.getValue(11), 120,
//                        fontChineseNormalsimfang12));
//                phrase4.add(new Chunk("元（大写）（每期均应当单独开具本文书）。此外，尚有未缴纳的罚款",
//                        fontChineseNormalsimfang12));
//                phrase4.add(ChunkFactoryOld.underLine(book.getValue(12), 120,
//                        fontChineseNormalsimfang12));
//                phrase4.add(new Chunk("元（大写）。", fontChineseNormalsimfang12));
//
//                paragraph3.add(phrase4);
//
//                document.add(paragraph3);
//
//                final Paragraph paragraph4 = new Paragraph("代收机构以本批准书为据，办理收款手续。",
//                        fontChineseNormalsimfang12);
//                paragraph4.setFirstLineIndent(24f);
//                paragraph4.setLeading(24f);
//                paragraph4.setAlignment(Element.ALIGN_LEFT);
//                document.add(paragraph4);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//
//                final Paragraph paragraph5 = new Paragraph();
//                paragraph5.setFirstLineIndent(24f);
//                paragraph5.setLeading(24f);
//                paragraph5.setAlignment(Element.ALIGN_LEFT);
//                Phrase phrase5 = new Phrase();
//                phrase5.add(new Chunk(
//                        "逾期缴纳罚款的，依据《中华人民共和国行政处罚法》第五十一条第（一）项的规定，每日按罚款数额的3%加处罚款。加处的罚款由代收机构直接收缴。",
//                        fontChineseNormalsimfang12));
//
//                paragraph5.add(phrase5);
//                document.add(paragraph5);
//
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//
//                final Paragraph paragraph7 = new Paragraph();
//                paragraph7.setFirstLineIndent(264f);
//                paragraph7.setLeading(24f);
//                paragraph7.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase12 = new Phrase();
//                phrase12.add(new Chunk("安全生产监督管理部门（公章）", fontChineseNormalsimfang12));
//                toMeasurefloat(phrase12);
//
//                paragraph7.add(phrase12);
//                document.add(paragraph7);
//
//                final Paragraph paragraph8 = new Paragraph();
//                paragraph8.setFirstLineIndent(264f);
//                paragraph8.setLeading(24f);
//                paragraph8.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase13 = new Phrase();
//                phrase13.add(ChunkFactoryOld.tablenounderLine(StringFactoryBuild.build().getTime(book.getValue(13), 0), 36,
//                        fontChineseNormalsimfang12));
//                phrase13.add(new Chunk("年", fontChineseNormalsimfang12));
//                phrase13.add(ChunkFactoryOld.tablenounderLine(StringFactoryBuild.build().getTime(book.getValue(13), 1), 12,
//                        fontChineseNormalsimfang12));
//                phrase13.add(new Chunk("月", fontChineseNormalsimfang12));
//                phrase13.add(ChunkFactoryOld.tablenounderLine(StringFactoryBuild.build().getTime(book.getValue(13), 2), 12,
//                        fontChineseNormalsimfang12));
//                phrase13.add(new Chunk("日", fontChineseNormalsimfang12));
//                toMeasurefloat(phrase13);
//
//                paragraph8.add(phrase13);
//                document.add(paragraph8);
//                document.add(space1);
//                document.add(space1);
//
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//
//                final Paragraph bottomLine1 = new Paragraph(
//                        new Chunk(new LineSeparator()));// 加入一个换行
//                bottomLine1.setLeading(1f);
//                bottomLine1.setSpacingBefore(5f);
//
//                document.add(bottomLine1);
//
//                final Paragraph paragraph9 = new Paragraph();
//                Phrase phrase14 = new Phrase();
//                phrase14.add(new Chunk("本文书一式两份：一份由安全生产监督管理部门备案，一份交申请人。",
//                        fontChineseNormalsimfang12));
//                paragraph9.add(phrase14);
//
//                document.add(paragraph9);
//
//                // checkbox start
//                PdfContentByte cb = dpfwPdfWriter.getDirectContent();
//                RadioCheckField bt = new RadioCheckField(dpfwPdfWriter,
//                        ChunkFactoryOld.setCheckBoxArea(104, 543, 10), "Yes380",
//                        ChunkFactoryOld.getCheck(book.getValue(7), 1));
//                bt.setCheckType(RadioCheckField.TYPE_CHECK);
//                bt.setBorderWidth(BaseField.BORDER_WIDTH_THIN);
//                bt.setBorderColor(BaseColor.BLACK);
//                bt.setChecked(true);
//                PdfFormField ck = bt.getCheckField();
//                dpfwPdfWriter.addAnnotation(ck);
//
//                RadioCheckField bt2 = new RadioCheckField(dpfwPdfWriter,
//                        ChunkFactoryOld.setCheckBoxArea(104, 520, 10), "Yes303",
//                        ChunkFactoryOld.getCheck(book.getValue(7), 2));
//                bt2.setCheckType(RadioCheckField.TYPE_CHECK);
//                bt2.setBorderWidth(BaseField.BORDER_WIDTH_THIN);
//                bt2.setBorderColor(BaseColor.BLACK);
//                bt2.setChecked(true);
//                PdfFormField ck2 = bt2.getCheckField();
//                dpfwPdfWriter.addAnnotation(ck2);
//
//                // checkbox end
//
//                PdfContentByte canvas2 = dpfwPdfWriter.getDirectContent();
//                // 电子签章
//                Image img = ImageBuilder.getInstance(image);
//                if (img != null) {
//                    img.setAbsolutePosition(350, 140);
//                    canvas2.addImage(img);
//                }
//                document.newPage();// 结束保存
//            }
//        });
//
//    }
//
//    //文书送达回执
//    public void printerEntity_Book30(final Base_Entity book, final Object image) {
//        printFrameWork(book, image, new IPdfBackFrame() {
//            @Override
//            public void writeContent() throws Exception {
//                //此处写页面布局
//                final Paragraph title = new Paragraph("" + city + "安全生产行政执法文书", fontChineseBoldsimhei15);// Paragraph就是段落
//                title.setLeading(1f);// 段落距离
//                // title.setSpacingBefore(25f);//段落留白
//                title.setAlignment(Element.ALIGN_CENTER);// 居中
//                document.add(title);// 写入文档
//                final Paragraph titleLine1 = new Paragraph(new Chunk(new LineSeparator()));// 加入一个换行
//                titleLine1.setLeading(1f);
//                titleLine1.setSpacingBefore(5f);
//                document.add(titleLine1);
//                final Paragraph titleLine2 = new Paragraph(new Chunk(new LineSeparator()));
//                titleLine2.setLeading(1f);
//                titleLine2.setSpacingBefore(1f);
//                document.add(titleLine2);
//                final Paragraph title2 = new Paragraph("文书送达回执", fontChineseBoldsimhei15);
//
//                title2.setLeading(1f);
//                title2.setSpacingBefore(17f);
//                title2.setAlignment(Element.ALIGN_CENTER);
//                document.add(title2);
//
//                final Paragraph title3 = new Paragraph("( " + book.getValue(0) + " )安监管回〔" + book.getValue(1) + "〕"
//                        + book.getValue(2) + "号", fontChineseNormalsimfang12);
//                title3.setLeading(1f);
//                title3.setSpacingBefore(30f);
//                title3.setAlignment(Element.ALIGN_CENTER);
//                document.add(title3);
//
//                final Paragraph paragraph1 = new Paragraph();
//                paragraph1.setLeading(24f);
//                paragraph1.setIndentationLeft(2f);
//                paragraph1.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase1 = new Phrase();
//                phrase1.add(new Chunk("案件名称:", fontChineseNormalsimfang12));
//                phrase1.add(ChunkFactoryOld.underLine(book.getValue(3), 360,
//                        fontChineseNormalsimfang12));
//
//                paragraph1.add(phrase1);
//                document.add(paragraph1);
//                document.add(space2);
//
//                // 表格start
//                PdfPTable table = new PdfPTable(1);
//                table.setWidthPercentage(100f);
//
//                PdfPTable table1 = new PdfPTable(2);
//                float[] tablewidths = new float[2];
//                tablewidths[0] = 7f;
//                tablewidths[1] = 18f;
//                table1.setWidths(tablewidths);
//                PdfPCell cell01 = new PdfPCell();
//                final Paragraph cell01p = new Paragraph();
//                cell01p.setAlignment(Element.ALIGN_CENTER);
//                cell01p.add(new Chunk("受送达单位（个人）", fontChineseNormalsimfang12));
//                cell01.addElement(cell01p);
//                PdfPCell cell02 = new PdfPCell();
//                final Paragraph cell02p = new Paragraph();
//                cell02p.setAlignment(Element.ALIGN_LEFT);
//                Phrase phrase02p = new Phrase();
//                phrase02p.add(ChunkFactoryOld.tablenounderLine(book.getValue(4), 200, fontChineseNormalsimfang12));
//                cell02p.add(phrase02p);
//                cell02.addElement(cell02p);
//                table1.addCell(cell01);
//                table1.addCell(cell02);
//                PdfPCell row1 = new PdfPCell(table1);
//                row1.setFixedHeight(20f);
//                table.addCell(row1);
//
//                PdfPTable table2 = new PdfPTable(6);
//                float[] tablewidths2 = new float[6];
//                tablewidths2[0] = 7f;
//                tablewidths2[1] = 4f;
//                tablewidths2[2] = 4f;
//                tablewidths2[3] = 3f;
//                tablewidths2[4] = 3f;
//                tablewidths2[5] = 4f;
//                table2.setWidths(tablewidths2);
//                PdfPCell cell11 = new PdfPCell();
//                final Paragraph cell11p = new Paragraph();
//                cell11p.setAlignment(Element.ALIGN_CENTER);
//                cell11p.setLeading(11f);
//                cell11p.add(new Chunk("\n送达文书名称、文号", fontChineseNormalsimfang12));
//                cell11.addElement(cell11p);
//                PdfPCell cell12 = new PdfPCell();
//                final Paragraph cell12p = new Paragraph();
//                cell12p.setAlignment(Element.ALIGN_CENTER);
//                cell12p.add(new Chunk("收件人签名\n或者盖章", fontChineseNormalsimfang12));
//                cell12.addElement(cell12p);
//                PdfPCell cell13 = new PdfPCell();
//                final Paragraph cell13p = new Paragraph();
//                cell13p.setAlignment(Element.ALIGN_CENTER);
//                cell13p.add(new Chunk("送达\n地点", fontChineseNormalsimfang12));
//                cell13.addElement(cell13p);
//                PdfPCell cell14 = new PdfPCell();
//                final Paragraph cell14p = new Paragraph();
//                cell14p.setAlignment(Element.ALIGN_CENTER);
//                cell14p.add(new Chunk("送达\n日期", fontChineseNormalsimfang12));
//                cell14.addElement(cell14p);
//                PdfPCell cell15 = new PdfPCell();
//                final Paragraph cell15p = new Paragraph();
//                cell15p.setAlignment(Element.ALIGN_CENTER);
//                cell15p.add(new Chunk("送达\n方式", fontChineseNormalsimfang12));
//                cell15.addElement(cell15p);
//                PdfPCell cell16 = new PdfPCell();
//                final Paragraph cell16p = new Paragraph();
//                cell16p.setAlignment(Element.ALIGN_CENTER);
//                cell16p.setLeading(11f);
//                cell16p.add(new Chunk("\n送达人", fontChineseNormalsimfang12));
//                cell16.addElement(cell16p);
//                table2.addCell(cell11);
//                table2.addCell(cell12);
//                table2.addCell(cell13);
//                table2.addCell(cell14);
//                table2.addCell(cell15);
//                table2.addCell(cell16);
//                PdfPCell row2 = new PdfPCell(table2);
//                row2.setFixedHeight(40f);
//                table.addCell(row2);
//
//                for (int i = 0; i < 12; i++) {
//                    PdfPTable table14 = new PdfPTable(6);
//                    table14.setWidths(tablewidths2);
//                    PdfPCell cell131 = new PdfPCell();
//                    final Paragraph cell131p = new Paragraph();
//                    cell131p.setAlignment(Element.ALIGN_CENTER);
//                    cell131p.setLeading(11f);
//                    cell131p.add(new Chunk(getListItemValue(book.getValue(5), i, 0), fontChineseNormalsimfang12));
//                    cell131.addElement(cell131p);
//                    PdfPCell cell132 = new PdfPCell();
//                    final Paragraph cell132p = new Paragraph();
//                    cell132p.setAlignment(Element.ALIGN_CENTER);
//                    cell132p.add(new Chunk(getListItemValue(book.getValue(5), i, 1), fontChineseNormalsimfang12));
//                    cell132.addElement(cell132p);
//                    PdfPCell cell133 = new PdfPCell();
//                    final Paragraph cell133p = new Paragraph();
//                    cell133p.setAlignment(Element.ALIGN_CENTER);
//                    cell133p.add(new Chunk(getListItemValue(book.getValue(5), i, 2), fontChineseNormalsimfang12));
//                    cell133.addElement(cell133p);
//                    PdfPCell cell134 = new PdfPCell();
//                    final Paragraph cell134p = new Paragraph();
//                    cell134p.setAlignment(Element.ALIGN_CENTER);
//                    cell134p.add(new Chunk(getListItemValue(book.getValue(5), i, 3), fontChineseNormalsimfang12));
//                    cell134.addElement(cell134p);
//                    PdfPCell cell135 = new PdfPCell();
//                    final Paragraph cell135p = new Paragraph();
//                    cell135p.setAlignment(Element.ALIGN_CENTER);
//                    cell135p.add(new Chunk(getListItemValue(book.getValue(5), i, 4), fontChineseNormalsimfang12));
//                    cell135.addElement(cell135p);
//                    PdfPCell cell136 = new PdfPCell();
//                    final Paragraph cell136p = new Paragraph();
//                    cell136p.setAlignment(Element.ALIGN_CENTER);
//                    cell136p.setLeading(11f);
//                    cell136p.add(new Chunk(getListItemValue(book.getValue(5), i, 5), fontChineseNormalsimfang12));
//                    cell136.addElement(cell136p);
//                    table14.addCell(cell131);
//                    table14.addCell(cell132);
//                    table14.addCell(cell133);
//                    table14.addCell(cell134);
//                    table14.addCell(cell135);
//                    table14.addCell(cell136);
//                    PdfPCell row14 = new PdfPCell(table14);
//                    row14.setFixedHeight(25f);
//                    table.addCell(row14);
//                }
//
//
//                PdfPCell row15 = new PdfPCell();
//                final Paragraph paragraph2 = new Paragraph();
//                paragraph2.setAlignment(Element.ALIGN_CENTER);
//                paragraph2.add("\n");
//                paragraph2.add(ChunkFactoryOld.tablenounderLine("", 210,
//                        fontChineseNormalsimfang12));
//                paragraph2.add(new Chunk("安全生产监督管理部门（公章）", fontChineseNormalsimfang12));
//                row15.addElement(paragraph2);
//                row15.setFixedHeight(50f);
//                table.addCell(row15);
//
//                PdfPCell row16 = new PdfPCell();
//                final Paragraph paragraph3 = new Paragraph();
//                paragraph3.setAlignment(Element.ALIGN_LEFT);
//                paragraph3.add(new Chunk("备注：", fontChineseNormalsimfang12));
//                paragraph3.add(ChunkFactoryOld.tablenounderLine(book.getValue(6), 60,
//                        fontChineseNormalsimfang12));
//                row16.addElement(paragraph3);
//                row16.setFixedHeight(80f);
//                table.addCell(row16);
//
//                document.add(table);
//                // 表格end
//
//                final Paragraph paragraph4 = new Paragraph("注：1.一个案件各类文书的送达，统一使用一份送达回执。",
//                        fontChineseNormalsimfang12);
//                paragraph4.setLeading(24f);
//                paragraph4.setIndentationLeft(6f);
//                paragraph4.setAlignment(Element.ALIGN_LEFT);
//
//                final Paragraph paragraph5 = new Paragraph("2.各类文书送达参照民事诉讼法有关送达的规定执行。",
//                        fontChineseNormalsimfang12);
//                paragraph5.setLeading(20f);
//                paragraph5.setIndentationLeft(30f);
//                paragraph5.setAlignment(Element.ALIGN_LEFT);
//
//                final Paragraph paragraph6 = new Paragraph(
//                        "3.他人代收的，由代收人在收件人栏内签名，并在备注栏内注明与被送达人的关系；留置送达的，在备注栏说明情况，并由签名人签名。",
//                        fontChineseNormalsimfang12);
//                paragraph6.setLeading(20f);
//                paragraph6.setIndentationLeft(30f);
//                paragraph6.setAlignment(Element.ALIGN_LEFT);
//
//                document.add(paragraph4);
//                document.add(paragraph5);
//                document.add(paragraph6);
//                PdfContentByte canvas2 = dpfwPdfWriter.getDirectContent();
//                // 电子签章
//                Image img = ImageBuilder.getInstance(image);
//                if (img != null) {
//                    img.setAbsolutePosition(350, 140);
//                    canvas2.addImage(img);
//                }
//                document.newPage();
//            }
//        });
//
//    }
//
//    //强制执行申请书
//    public void printerEntity_Book31(final Base_Entity book, final Object image) {
//        printFrameWork(book, image, new IPdfBackFrame() {
//            @Override
//            public void writeContent() throws Exception {
//                //此处写页面布局
//                final Paragraph title = new Paragraph("" + city + "安全生产行政执法文书", fontChineseBoldsimhei15);// Paragraph就是段落
//                title.setLeading(1f);// 段落距离
//                // title.setSpacingBefore(25f);//段落留白
//                title.setAlignment(Element.ALIGN_CENTER);// 居中
//                document.add(title);// 写入文档
//                final Paragraph titleLine1 = new Paragraph(new Chunk(new LineSeparator()));// 加入一个换行
//                titleLine1.setLeading(1f);
//                titleLine1.setSpacingBefore(5f);
//                document.add(titleLine1);
//                final Paragraph titleLine2 = new Paragraph(new Chunk(new LineSeparator()));
//                titleLine2.setLeading(1f);
//                titleLine2.setSpacingBefore(1f);
//                document.add(titleLine2);
//                final Paragraph title2 = new Paragraph("强制执行申请书", fontChineseBoldsimhei15);
//
//                title2.setLeading(1f);
//                title2.setSpacingBefore(17f);
//                title2.setAlignment(Element.ALIGN_CENTER);
//                document.add(title2);
//
//                final Paragraph title3 = new Paragraph("( " + book.getValue(0) + " )安监管强执〔" + book.getValue(1) + "〕"
//                        + book.getValue(2) + "号", fontChineseNormalsimfang12);
//                title3.setLeading(1f);
//                title3.setSpacingBefore(30f);
//                title3.setAlignment(Element.ALIGN_CENTER);
//                document.add(title3);
//
//                document.add(space2);
//                document.add(space2);
//                document.add(space2);
//
//                final Paragraph entParagraph = new Paragraph();
//                entParagraph.setLeading(24f);
//                entParagraph.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase1 = new Phrase();
//                phrase1.add((ChunkFactoryOld.underLine(book.getValue(3), 120,
//                        fontChineseNormalsimfang12)));
//                phrase1.add(new Chunk("人民法院:", fontChineseNormalsimfang12));
//                toMeasurefloat(phrase1);
//
//                entParagraph.add(phrase1);
//
//                document.add(entParagraph);
//                document.add(space1);
//
//                final Paragraph paragraph1 = new Paragraph();
//                paragraph1.setFirstLineIndent(24f);
//                paragraph1.setLeading(24f);
//                paragraph1.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase2 = new Phrase();
//                phrase2.add(new Chunk("本行政机关于", fontChineseNormalsimfang12));
//                phrase2.add(ChunkFactoryOld
//                        .underLine(StringFactoryBuild.build().getTime(book.getValue(4), 0), 24, fontChineseNormalsimfang12));
//                phrase2.add(new Chunk("年", fontChineseNormalsimfang12));
//                phrase2.add(ChunkFactoryOld
//                        .underLine(StringFactoryBuild.build().getTime(book.getValue(4), 1), 12, fontChineseNormalsimfang12));
//                phrase2.add(new Chunk("月", fontChineseNormalsimfang12));
//                phrase2.add(ChunkFactoryOld
//                        .underLine(StringFactoryBuild.build().getTime(book.getValue(4), 2), 12, fontChineseNormalsimfang12));
//                phrase2.add(new Chunk("日对被申请执行人", fontChineseNormalsimfang12));
//                phrase2.add(ChunkFactoryOld
//                        .underLine(book.getValue(5), 90, fontChineseNormalsimfang12));
//                phrase2.add(new Chunk("作出了", fontChineseNormalsimfang12));
//                phrase2.add(ChunkFactoryOld.underLine(book.getValue(6), 294,
//                        fontChineseNormalsimfang12));
//                phrase2.add(new Chunk("的行政处罚决定（文号：", fontChineseNormalsimfang12));
//                phrase2.add(ChunkFactoryOld.tablenounderLine(book.getValue(7), 204,
//                        fontChineseNormalsimfang12));
//                phrase2.add(new Chunk(
//                        "），被申请执行人在法定的期限内未履行该行政处罚决定。根据《中华人民共和国行政处罚法》第五十一条的规定，特申请贵院强制执行。",
//                        fontChineseNormalsimfang12));
//
//                paragraph1.add(phrase2);
//                document.add(paragraph1);
//
////                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//
//                final Paragraph paragraph = new Paragraph();
//                paragraph.setFirstLineIndent(24f);
//                paragraph.setLeading(24f);
//                paragraph.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase = new Phrase();
//                phrase.add(new Chunk("附有关材料：", fontChineseNormalsimfang12));
//                toMeasurefloat(phrase);
//
//                Phrase phrase12 = new Phrase();
//                phrase12.add(ChunkFactoryOld.tablenounderLine(book.getValue(8), 4000, fontChineseNormalsimfang12));
//                toMeasurefloat(phrase12);
//
//                paragraph.add(phrase);
//                paragraph.add(phrase12);
//                document.add(paragraph);
//
//
//                final Paragraph paragraph3 = new Paragraph();
//                paragraph3.setFirstLineIndent(264f);
//                paragraph3.setLeading(24f);
//                paragraph3.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase4 = new Phrase();
//                phrase4.add(new Chunk("安全生产监督管理部门（公章）", fontChineseNormalsimfang12));
//                toMeasurefloat(phrase4);
//
//                paragraph3.add(phrase4);
//                document.add(paragraph3);
//
//                final Paragraph paragraph4 = new Paragraph();
//                paragraph4.setFirstLineIndent(264f);
//                paragraph4.setLeading(24f);
//                paragraph4.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase5 = new Phrase();
//                phrase5.add(ChunkFactoryOld.tablenounderLine(StringFactoryBuild.build().getTime(book.getValue(9), 0), 30,
//                        fontChineseNormalsimfang12));
//                phrase5.add(new Chunk("年", fontChineseNormalsimfang12));
//                phrase5.add(ChunkFactoryOld.tablenounderLine(StringFactoryBuild.build().getTime(book.getValue(9), 1), 12,
//                        fontChineseNormalsimfang12));
//                phrase5.add(new Chunk("月", fontChineseNormalsimfang12));
//                phrase5.add(ChunkFactoryOld.tablenounderLine(StringFactoryBuild.build().getTime(book.getValue(9), 2), 12,
//                        fontChineseNormalsimfang12));
//                phrase5.add(new Chunk("日", fontChineseNormalsimfang12));
//                toMeasurefloat(phrase5);
//
//                paragraph4.add(phrase5);
//                document.add(paragraph4);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//
////                document.add(space1);
//
//                final Paragraph paragraph5 = new Paragraph();
//                paragraph5.setAlignment(Element.ALIGN_LEFT);
//                paragraph5.setIndentationLeft(24f);
//                paragraph5.setLeading(20f);
//
//                Phrase phrase6 = new Phrase();
//                phrase6.add(new Chunk("联系人：", fontChineseNormalsimfang12));
//                phrase6.add(ChunkFactoryOld.tablenounderLine(book.getValue(10), 156,
//                        fontChineseNormalsimfang12));
//                phrase6.add(new Chunk("联系电话：", fontChineseNormalsimfang12));
//                phrase6.add(ChunkFactoryOld.tablenounderLine(book.getValue(11), 156,
//                        fontChineseNormalsimfang12));
//                toMeasurefloat(phrase6);
//                paragraph5.add(phrase6);
//
//                document.add(paragraph5);
//
//                PdfContentByte canvas2 = dpfwPdfWriter.getDirectContent();
//                // 电子签章
//                Image img = ImageBuilder.getInstance(image);
//                if (img != null) {
//                    img.setAbsolutePosition(350, 140);
//                    canvas2.addImage(img);
//                }
//                document.newPage();// 结束保存
//            }
//        });
//
//    }
//
//    //结案审批表
//    public void printerEntity_Book32(final Base_Entity book, final Object image) {
//        printFrameWork(book, image, new IPdfBackFrame() {
//            @Override
//            public void writeContent() throws Exception {
//                //此处写页面布局
//                final Paragraph title = new Paragraph("" + city + "安全生产行政执法文书", fontChineseBoldsimhei15);// Paragraph就是段落
//                title.setLeading(1f);// 段落距离
//                // title.setSpacingBefore(25f);//段落留白
//                title.setAlignment(Element.ALIGN_CENTER);// 居中
//                document.add(title);// 写入文档
//                final Paragraph titleLine1 = new Paragraph(new Chunk(new LineSeparator()));// 加入一个换行
//                titleLine1.setLeading(1f);
//                titleLine1.setSpacingBefore(5f);
//                document.add(titleLine1);
//                final Paragraph titleLine2 = new Paragraph(new Chunk(new LineSeparator()));
//                titleLine2.setLeading(1f);
//                titleLine2.setSpacingBefore(1f);
//                document.add(titleLine2);
//                final Paragraph title2 = new Paragraph("结案审批表", fontChineseBoldsimhei15);
//
//                title2.setLeading(1f);
//                title2.setSpacingBefore(17f);
//                title2.setAlignment(Element.ALIGN_CENTER);
//                document.add(title2);
//                document.add(space2);
//
//                final Paragraph title3 = new Paragraph("( " + book.getValue(0) + " )安监管处呈〔" + book.getValue(1) + "〕"
//                        + book.getValue(2) + "号", fontChineseNormalsimfang12);
//                title3.setLeading(1f);
//                title3.setSpacingBefore(34f);
//                title3.setAlignment(Element.ALIGN_CENTER);
//                document.add(title3);
//
//                document.add(space1);
//
//                final Paragraph paragraph1 = new Paragraph();
//                paragraph1.setLeading(24f);
//                paragraph1.setIndentationLeft(2f);
//                paragraph1.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase1 = new Phrase();
//                phrase1.add(new Chunk("案件名称:", fontChineseNormalsimfang12));
//                phrase1.add(ChunkFactoryOld.underLine(book.getValue(3), 360,
//                        fontChineseNormalsimfang12));
//
//                paragraph1.add(phrase1);
//                document.add(paragraph1);
//                document.add(space2);
//
//                // 表格start
//                PdfPTable table = new PdfPTable(1);
//                table.setWidthPercentage(100f);
//
//                PdfPCell lin01 = new PdfPCell();
//                final Paragraph lin01p0 = new Paragraph("\n当事\n人基\n本情\n况",
//                        fontChineseNormalsimfang12);
//                lin01p0.setAlignment(Element.ALIGN_CENTER);
//                lin01.addElement(lin01p0);
//
//                PdfPTable table1 = new PdfPTable(1);
//                PdfPCell lin02 = new PdfPCell(table1);
//                PdfPCell cell1 = new PdfPCell(new Phrase(new Chunk("被处罚单位",
//                        fontChineseNormalsimfang12)));
//                cell1.setFixedHeight(24f);
//                PdfPCell cell2 = new PdfPCell(new Phrase(new Chunk("法定代表人",
//                        fontChineseNormalsimfang12)));
//                cell2.setFixedHeight(24f);
//                PdfPCell cell3 = new PdfPCell(new Phrase(new Chunk("被处罚人",
//                        fontChineseNormalsimfang12)));
//                cell3.setFixedHeight(24f);
//                PdfPCell cell4 = new PdfPCell(new Phrase(new Chunk("所在单位",
//                        fontChineseNormalsimfang12)));
//                cell4.setFixedHeight(24f);
//                PdfPCell cell5 = new PdfPCell(new Phrase(new Chunk("家庭住址",
//                        fontChineseNormalsimfang12)));
//                cell5.setFixedHeight(24f);
//                table1.addCell(cell1);
//                table1.addCell(cell2);
//                table1.addCell(cell3);
//                table1.addCell(cell4);
//                table1.addCell(cell5);
//
//                PdfPTable table2 = new PdfPTable(1);
//                PdfPCell lin03 = new PdfPCell(table2);
//                PdfPCell cell11 = new PdfPCell(new Phrase(
//                        ChunkFactoryOld.tablenounderLine(book.getValue(4), 10,
//                                fontChineseNormalsimfang12)));
//                cell11.setFixedHeight(24f);
//                PdfPCell cell12 = new PdfPCell(new Phrase(
//                        ChunkFactoryOld.tablenounderLine(book.getValue(6), 10,
//                                fontChineseNormalsimfang12)));
//                cell12.setFixedHeight(24f);
//                PdfPCell cell13 = new PdfPCell(new Phrase(
//                        ChunkFactoryOld.tablenounderLine(book.getValue(9), 10,
//                                fontChineseNormalsimfang12)));
//                cell13.setFixedHeight(24f);
//                PdfPCell cell14 = new PdfPCell(new Phrase(
//                        ChunkFactoryOld.tablenounderLine(book.getValue(12), 10,
//                                fontChineseNormalsimfang12)));
//                cell14.setFixedHeight(24f);
//                PdfPCell cell15 = new PdfPCell(new Phrase(
//                        ChunkFactoryOld.tablenounderLine(book.getValue(14), 10,
//                                fontChineseNormalsimfang12)));
//                cell15.setFixedHeight(24f);
//                table2.addCell(cell11);
//                table2.addCell(cell12);
//                table2.addCell(cell13);
//                table2.addCell(cell14);
//                table2.addCell(cell15);
//
//                PdfPTable table3 = new PdfPTable(1);
//                PdfPCell lin04 = new PdfPCell(table3);
//                PdfPCell cell21 = new PdfPCell(new Phrase(new Chunk("地址",
//                        fontChineseNormalsimfang12)));
//                cell21.setFixedHeight(24f);
//                PdfPCell cell22 = new PdfPCell(new Phrase(new Chunk("职务",
//                        fontChineseNormalsimfang12)));
//                cell22.setFixedHeight(24f);
//                PdfPCell cell23 = new PdfPCell(new Phrase(new Chunk("年龄",
//                        fontChineseNormalsimfang12)));
//                cell23.setFixedHeight(24f);
//                PdfPCell cell24 = new PdfPCell(new Phrase(new Chunk("单位地址",
//                        fontChineseNormalsimfang12)));
//                cell24.setFixedHeight(24f);
//                PdfPCell cell25 = new PdfPCell(new Phrase(new Chunk("联系电话",
//                        fontChineseNormalsimfang12)));
//                cell25.setFixedHeight(24f);
//                table3.addCell(cell21);
//                table3.addCell(cell22);
//                table3.addCell(cell23);
//                table3.addCell(cell24);
//                table3.addCell(cell25);
//
//                PdfPTable table4 = new PdfPTable(1);
//                PdfPCell lin05 = new PdfPCell(table4);
//                PdfPCell cell31 = new PdfPCell(new Phrase(
//                        ChunkFactoryOld.tablenounderLine(book.getValue(5), 15,
//                                fontChineseNormalsimfang12)));
//                cell31.setFixedHeight(24f);
//
//                PdfPTable table41 = new PdfPTable(3);
//                PdfPCell cell32 = new PdfPCell(table41);
//                cell32.setFixedHeight(24f);
//                PdfPCell c1 = new PdfPCell(new Phrase(
//                        ChunkFactoryOld.tablenounderLine(book.getValue(7), 6,
//                                fontChineseNormalsimfang12)));
//                PdfPCell c2 = new PdfPCell(new Phrase(new Chunk("邮编",
//                        fontChineseNormalsimfang12)));
//                PdfPCell c3 = new PdfPCell(new Phrase(
//                        ChunkFactoryOld.tablenounderLine(book.getValue(8), 6,
//                                fontChineseNormalsimfang12)));
//                table41.addCell(c1);
//                table41.addCell(c2);
//                table41.addCell(c3);
//
//                PdfPTable table42 = new PdfPTable(3);
//                PdfPCell cell33 = new PdfPCell(table42);
//                cell33.setFixedHeight(24f);
//                PdfPCell a1 = new PdfPCell(new Phrase(
//                        ChunkFactoryOld.tablenounderLine(book.getValue(10), 6,
//                                fontChineseNormalsimfang12)));
//                PdfPCell a2 = new PdfPCell(new Phrase(new Chunk("性别",
//                        fontChineseNormalsimfang12)));
//                PdfPCell a3 = new PdfPCell(new Phrase(
//                        ChunkFactoryOld.tablenounderLine(book.getValue(11), 6,
//                                fontChineseNormalsimfang12)));
//                table42.addCell(a1);
//                table42.addCell(a2);
//                table42.addCell(a3);
//
//                PdfPTable table43 = new PdfPTable(1);
//                PdfPCell cell34 = new PdfPCell(new Phrase(
//                        ChunkFactoryOld.tablenounderLine(book.getValue(13), 15,
//                                fontChineseNormalsimfang12)));
//                cell34.setFixedHeight(24f);
//
//                PdfPTable table44 = new PdfPTable(3);
//                PdfPCell cell35 = new PdfPCell(table44);
//                cell35.setFixedHeight(24f);
//                PdfPCell b1 = new PdfPCell(new Phrase(
//                        ChunkFactoryOld.tablenounderLine(book.getValue(15), 6,
//                                fontChineseNormalsimfang12)));
//                PdfPCell b2 = new PdfPCell(new Phrase(new Chunk("邮编",
//                        fontChineseNormalsimfang12)));
//                PdfPCell b3 = new PdfPCell(new Phrase(
//                        ChunkFactoryOld.tablenounderLine(book.getValue(16), 6,
//                                fontChineseNormalsimfang12)));
//                table44.addCell(b1);
//                table44.addCell(b2);
//                table44.addCell(b3);
//
//                table4.addCell(cell31);
//                table4.addCell(cell32);
//                table4.addCell(cell33);
//                table4.addCell(cell34);
//                table4.addCell(cell35);
//
//                PdfPTable celltable0 = new PdfPTable(5);
//                float[] celltable0float = new float[5];
//                celltable0float[0] = 2f;
//                celltable0float[1] = 4f;
//                celltable0float[2] = 6f;
//                celltable0float[3] = 3f;
//                celltable0float[4] = 6f;
//                celltable0.setTotalWidth(celltable0float);
//                celltable0.addCell(lin01);
//                celltable0.addCell(lin02);
//                celltable0.addCell(lin03);
//                celltable0.addCell(lin04);
//                celltable0.addCell(lin05);
//                PdfPCell row0 = new PdfPCell(celltable0);
//                row0.setFixedHeight(120f);
//                table.addCell(row0);
//
//                PdfPCell lin21 = new PdfPCell();
//                final Paragraph lin21p0 = new Paragraph("\n\n处\n理\n结\n果",
//                        fontChineseNormalsimfang12);
//                lin21p0.setAlignment(Element.ALIGN_CENTER);
//                lin21.addElement(lin21p0);
//                PdfPCell lin22 = new PdfPCell();
//                final Paragraph lin22p0 = new Paragraph();
//                lin22p0.setFirstLineIndent(24f);
//                lin22p0.setLeading(24f);
//                Phrase phrase22p0 = new Phrase();
//                phrase22p0.add(ChunkFactoryOld.tablenounderLine(book.getValue(17), 1488, fontChineseNormalsimfang12));
//                lin22p0.add(phrase22p0);
//                lin22.addElement(lin22p0);
//                PdfPTable cellTable2 = new PdfPTable(2);
//                float[] celltable1float = new float[2];
//                celltable1float[0] = 2f;
//                celltable1float[1] = 19f;
//                cellTable2.setWidths(celltable1float);
//                cellTable2.addCell(lin21);
//                cellTable2.addCell(lin22);
//                PdfPCell row2 = new PdfPCell(cellTable2);
//                row2.setFixedHeight(180f);
//                table.addCell(row2);
//
//                PdfPCell lin41 = new PdfPCell();
//                final Paragraph lin41p0 = new Paragraph("\n执行\n情况\n", fontChineseNormalsimfang12);
//                lin41p0.setAlignment(Element.ALIGN_CENTER);
//                lin41.addElement(lin41p0);
//                PdfPTable cellTable4_2 = new PdfPTable(1);
//                PdfPCell lin42_2 = new PdfPCell();
//                lin42_2.setBorder(0);
//                lin42_2.setFixedHeight(72f);
//                PdfPCell lin42_3 = new PdfPCell();
//                lin42_3.setBorder(0);
//                lin42_3.setFixedHeight(24f);
//                PdfPCell lin42 = new PdfPCell(cellTable4_2);
//                final Paragraph lin42p0 = new Paragraph("", fontChineseNormalsimfang12);
//                lin42p0.setFirstLineIndent(24f);
//                lin42p0.setLeading(24f);
//                lin42p0.setAlignment(Element.ALIGN_LEFT);
//
//                final Paragraph lin42p02 = new Paragraph("", fontChineseNormalsimfang12);
//                lin42p02.setFirstLineIndent(0f);
//                lin42p02.setLeading(24f);
//                lin42p02.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase2 = new Phrase();
//                Phrase phrase2_1 = new Phrase();
//                phrase2.add(ChunkFactoryOld.tablenounderLine(book.getValue(18), 1696,
//                        fontChineseNormalsimfang12));
//                phrase2_1.add(new Chunk("承办人（签名）：", fontChineseNormalsimfang12));
//                phrase2_1.add(ChunkFactoryOld.underLine(book.getValue(19), 48,
//                        fontChineseNormalsimfang12));
//                phrase2_1.add(ChunkFactoryOld.tablenounderLine("", 12,
//                        fontChineseNormalsimfang12));
//                phrase2_1.add(ChunkFactoryOld.underLine(book.getValue(20), 48,
//                        fontChineseNormalsimfang12));
//                phrase2_1.add(ChunkFactoryOld.tablenounderLine(StringFactoryBuild.build().getTime(book.getValue(21), 0), 36,
//                        fontChineseNormalsimfang12));
//                phrase2_1.add(new Chunk("年", fontChineseNormalsimfang12));
//                phrase2_1.add(ChunkFactoryOld.tablenounderLine(StringFactoryBuild.build().getTime(book.getValue(21), 1), 12,
//                        fontChineseNormalsimfang12));
//                phrase2_1.add(new Chunk("月", fontChineseNormalsimfang12));
//                phrase2_1.add(ChunkFactoryOld.tablenounderLine(StringFactoryBuild.build().getTime(book.getValue(21), 2), 12,
//                        fontChineseNormalsimfang12));
//                phrase2_1.add(new Chunk("日", fontChineseNormalsimfang12));
//
//                lin42p0.add(phrase2);
//                lin42p02.add(phrase2_1);
//                lin42_2.addElement(lin42p0);
//                lin42_3.addElement(lin42p02);
//                cellTable4_2.addCell(lin42_2);
//                cellTable4_2.addCell(lin42_3);
//
//                PdfPTable cellTable4 = new PdfPTable(2);
//                cellTable4.setWidths(celltable1float);
//                cellTable4.addCell(lin41);
//                cellTable4.addCell(lin42);
//                PdfPCell row4 = new PdfPCell(cellTable4);
//                row4.setFixedHeight(108f);
//                table.addCell(row4);
//
//                PdfPTable cellTable5 = new PdfPTable(4);
//                float[] celltable5float = new float[4];
//                celltable5float[0] = 2f;
//                celltable5float[1] = 8f;
//                celltable5float[2] = 2f;
//                celltable5float[3] = 9f;
//                cellTable5.setWidths(celltable5float);
//
//                PdfPCell lin51 = new PdfPCell();
//                final Paragraph lin51p0 = new Paragraph("\n审\n核\n意\n见",
//                        fontChineseNormalsimfang12);
//                lin51p0.setAlignment(Element.ALIGN_CENTER);
//                lin51.addElement(lin51p0);
//
//                PdfPTable cellTable5_2 = new PdfPTable(1);
//                PdfPCell lin52_1 = new PdfPCell();
//                PdfPCell lin52_2 = new PdfPCell();
//                lin52_1.setFixedHeight(80f);
//                lin52_1.setBorder(0);
//                lin52_2.setFixedHeight(24f);
//                lin52_2.setBorder(0);
//                PdfPCell lin52 = new PdfPCell(cellTable5_2);
//                final Paragraph lin52p0 = new Paragraph();
//                final Paragraph lin52p02 = new Paragraph();
//                lin52p0.setAlignment(Element.ALIGN_LEFT);
//                lin52p0.setIndentationLeft(24f);
//                lin52p0.setLeading(24f);
//
//                lin52p02.setAlignment(Element.ALIGN_LEFT);
//                lin52p02.setIndentationLeft(0f);
//                lin52p02.setLeading(24f);
//                Phrase phrase3 = new Phrase();
//                Phrase phrase3_1 = new Phrase();
//                phrase3.add(ChunkFactoryOld.tablenounderLine(book.getValue(22), 288,
//                        fontChineseNormalsimfang12));
//                phrase3_1.add(new Chunk("审核人（签名）:", fontChineseNormalsimfang12));
//                phrase3_1.add(ChunkFactoryOld.tablenounderLine(book.getValue(23), 144,
//                        fontChineseNormalsimfang12));
//                phrase3_1.add(ChunkFactoryOld.tablenounderLine("", 12,
//                        fontChineseNormalsimfang12));
//                phrase3_1.add(ChunkFactoryOld.tablenounderLine(StringFactoryBuild.build().getTime(book.getValue(24), 0), 24,
//                        fontChineseNormalsimfang12));
//                phrase3_1.add(new Chunk("年", fontChineseNormalsimfang12));
//                phrase3_1.add(ChunkFactoryOld.tablenounderLine(StringFactoryBuild.build().getTime(book.getValue(24), 1), 12,
//                        fontChineseNormalsimfang12));
//                phrase3_1.add(new Chunk("月", fontChineseNormalsimfang12));
//                phrase3_1.add(ChunkFactoryOld.tablenounderLine(StringFactoryBuild.build().getTime(book.getValue(24), 2), 12,
//                        fontChineseNormalsimfang12));
//                phrase3_1.add(new Chunk("日", fontChineseNormalsimfang12));
//                lin52p0.add(phrase3);
//                lin52p02.add(phrase3_1);
//                lin52_1.addElement(lin52p0);
//                lin52_2.addElement(lin52p02);
//                cellTable5_2.addCell(lin52_1);
//                cellTable5_2.addCell(lin52_2);
//
//                PdfPCell lin53 = new PdfPCell();
//                final Paragraph lin53p0 = new Paragraph("\n审\n批\n意\n见",
//                        fontChineseNormalsimfang12);
//                lin53p0.setAlignment(Element.ALIGN_CENTER);
//                lin53.addElement(lin53p0);
//
//                PdfPTable cellTable5_4 = new PdfPTable(1);
//                PdfPCell lin54_1 = new PdfPCell();
//                PdfPCell lin54_2 = new PdfPCell();
//                lin54_1.setFixedHeight(80f);
//                lin54_1.setBorder(0);
//                lin54_2.setFixedHeight(24f);
//                lin54_2.setBorder(0);
//                PdfPCell lin54 = new PdfPCell(cellTable5_4);
//                final Paragraph lin54p0 = new Paragraph();
//                final Paragraph lin54p02 = new Paragraph();
//                lin54p0.setAlignment(Element.ALIGN_LEFT);
//                lin54p0.setIndentationLeft(24f);
//                lin54p0.setLeading(24f);
//
//                lin54p02.setAlignment(Element.ALIGN_LEFT);
//                lin54p02.setIndentationLeft(0f);
//                lin54p02.setLeading(24f);
//                Phrase phrase4 = new Phrase();
//                Phrase phrase4_1 = new Phrase();
//                phrase4.add(ChunkFactoryOld.tablenounderLine(book.getValue(25), 288,
//                        fontChineseNormalsimfang12));
//                phrase4_1.add(new Chunk("审批人（签名）:", fontChineseNormalsimfang12));
//                phrase4_1.add(ChunkFactoryOld.tablenounderLine(book.getValue(26), 144,
//                        fontChineseNormalsimfang12));
//                phrase4_1.add(ChunkFactoryOld.tablenounderLine("", 12,
//                        fontChineseNormalsimfang12));
//                phrase4_1.add(ChunkFactoryOld.tablenounderLine(StringFactoryBuild.build().getTime(book.getValue(27), 0), 36,
//                        fontChineseNormalsimfang12));
//                phrase4_1.add(new Chunk("年", fontChineseNormalsimfang12));
//                phrase4_1.add(ChunkFactoryOld.tablenounderLine(StringFactoryBuild.build().getTime(book.getValue(27), 1), 12,
//                        fontChineseNormalsimfang12));
//                phrase4_1.add(new Chunk("月", fontChineseNormalsimfang12));
//                phrase4_1.add(ChunkFactoryOld.tablenounderLine(StringFactoryBuild.build().getTime(book.getValue(27), 2), 12,
//                        fontChineseNormalsimfang12));
//                phrase4_1.add(new Chunk("日", fontChineseNormalsimfang12));
//                lin54p0.add(phrase4);
//                lin54p02.add(phrase4_1);
//                lin54_1.addElement(lin54p0);
//                lin54_2.addElement(lin54p02);
//                cellTable5_4.addCell(lin54_1);
//                cellTable5_4.addCell(lin54_2);
//
//                cellTable5.addCell(lin51);
//                cellTable5.addCell(lin52);
//                cellTable5.addCell(lin53);
//                cellTable5.addCell(lin54);
//
//                PdfPCell row5 = new PdfPCell(cellTable5);
//                row5.setFixedHeight(150f);
//                table.addCell(row5);
//
//                document.add(table);
//                document.add(space1);
//                // 表格end
//
//                PdfContentByte canvas2 = dpfwPdfWriter.getDirectContent();
//                // 电子签章
//                Image img = ImageBuilder.getInstance(image);
//                if (img != null) {
//                    img.setAbsolutePosition(350, 140);
//                    canvas2.addImage(img);
//                }
//                document.newPage();
//            }
//        });
//
//    }
//
//    //案件移送审批表
//    public void printerEntity_Book33(final Base_Entity book, final Object image) {
//        printFrameWork(book, image, new IPdfBackFrame() {
//            @Override
//            public void writeContent() throws Exception {
//                //此处写页面布局
//                final Paragraph title = new Paragraph("" + city + "安全生产行政执法文书", fontChineseBoldsimhei15);// Paragraph就是段落
//                title.setLeading(1f);// 段落距离
//                // title.setSpacingBefore(25f);//段落留白
//                title.setAlignment(Element.ALIGN_CENTER);// 居中
//                document.add(title);// 写入文档
//                final Paragraph titleLine1 = new Paragraph(new Chunk(new LineSeparator()));// 加入一个换行
//                titleLine1.setLeading(1f);
//                titleLine1.setSpacingBefore(5f);
//                document.add(titleLine1);
//                final Paragraph titleLine2 = new Paragraph(new Chunk(new LineSeparator()));
//                titleLine2.setLeading(1f);
//                titleLine2.setSpacingBefore(1f);
//                document.add(titleLine2);
//                final Paragraph title2 = new Paragraph("案件移送审批表", fontChineseBoldsimhei15);
//
//                title2.setLeading(1f);
//                title2.setSpacingBefore(17f);
//                title2.setAlignment(Element.ALIGN_CENTER);
//                document.add(title2);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//
//                // 表格start
//                PdfPTable table = new PdfPTable(1);
//                table.setWidthPercentage(100f);
//
//                PdfPCell lin1 = new PdfPCell();
//                final Paragraph lin1p0 = new Paragraph("案件名称", fontChineseNormalsimfang12);
//                lin1p0.setAlignment(Element.ALIGN_CENTER);
//                lin1.addElement(lin1p0);
//
//                PdfPCell lin2 = new PdfPCell();
//                final Paragraph lin2p0 = new Paragraph(new Chunk(book.getValue(3), fontChineseNormalsimfang12));
//                lin2p0.setAlignment(Element.ALIGN_CENTER);
//                lin2.addElement(lin2p0);
//
//                PdfPTable table1 = new PdfPTable(2);
//                float[] celltable1float = new float[2];
//                celltable1float[0] = 4f;
//                celltable1float[1] = 19f;
//                table1.setWidths(celltable1float);
//                table1.addCell(lin1);
//                table1.addCell(lin2);
//                PdfPCell row1 = new PdfPCell(table1);
//                row1.setFixedHeight(35f);
//                table.addCell(row1);
//
//                PdfPCell lin3 = new PdfPCell();
//                final Paragraph lin3p0 = new Paragraph("当事人", fontChineseNormalsimfang12);
//                lin3p0.setAlignment(Element.ALIGN_CENTER);
//                lin3.addElement(lin3p0);
//
//                PdfPCell lin4 = new PdfPCell();
//                final Paragraph lin4p0 = new Paragraph(new Chunk(book.getValue(4), fontChineseNormalsimfang12));
//                lin4p0.setAlignment(Element.ALIGN_CENTER);
//                lin4.addElement(lin4p0);
//
//                PdfPTable table2 = new PdfPTable(2);
//                table2.setWidths(celltable1float);
//                table2.addCell(lin3);
//                table2.addCell(lin4);
//                PdfPCell row11 = new PdfPCell(table2);
//                row11.setFixedHeight(35f);
//                table.addCell(row11);
//
//                PdfPCell lin5 = new PdfPCell();
//                final Paragraph lin5p0 = new Paragraph("地址", fontChineseNormalsimfang12);
//                lin5p0.setAlignment(Element.ALIGN_CENTER);
//                lin5.addElement(lin5p0);
//
//                PdfPCell lin6 = new PdfPCell();
//                final Paragraph lin6p0 = new Paragraph(new Chunk(book.getValue(5), fontChineseNormalsimfang12));
//                lin6p0.setAlignment(Element.ALIGN_CENTER);
//                lin6.addElement(lin6p0);
//
//                PdfPTable table3 = new PdfPTable(2);
//                table3.setWidths(celltable1float);
//                table3.addCell(lin5);
//                table3.addCell(lin6);
//                PdfPCell row12 = new PdfPCell(table3);
//                row12.setFixedHeight(35f);
//                table.addCell(row12);
//
//                PdfPCell lin7 = new PdfPCell();
//                final Paragraph lin7p0 = new Paragraph("受移送机关", fontChineseNormalsimfang12);
//                lin7p0.setAlignment(Element.ALIGN_CENTER);
//                lin7.addElement(lin7p0);
//
//                PdfPCell lin8 = new PdfPCell();
//                final Paragraph lin8p0 = new Paragraph(new Chunk(book.getValue(6), fontChineseNormalsimfang12));
//                lin8p0.setAlignment(Element.ALIGN_CENTER);
//                lin8.addElement(lin8p0);
//
//                PdfPTable table4 = new PdfPTable(2);
//                table4.setWidths(celltable1float);
//                table4.addCell(lin7);
//                table4.addCell(lin8);
//                PdfPCell row13 = new PdfPCell(table4);
//                row13.setFixedHeight(35f);
//                table.addCell(row13);
//
//                PdfPCell lin21 = new PdfPCell();
//                final Paragraph lin21p0 = new Paragraph("\n\n案情简介", fontChineseNormalsimfang12);
//                lin21p0.setAlignment(Element.ALIGN_CENTER);
//                lin21.addElement(lin21p0);
//                PdfPCell lin22 = new PdfPCell();
//                final Paragraph lin22p0 = new Paragraph(book.getValue(7), fontChineseNormalsimfang12);
//                lin22p0.setFirstLineIndent(24f);
//                lin22p0.setLeading(24f);
//                lin22p0.setAlignment(Element.ALIGN_LEFT);
//                lin22.addElement(lin22p0);
//                PdfPTable cellTable2 = new PdfPTable(2);
//                cellTable2.setWidths(celltable1float);
//                cellTable2.addCell(lin21);
//                cellTable2.addCell(lin22);
//                PdfPCell row2 = new PdfPCell(cellTable2);
//                row2.setFixedHeight(100f);
//                table.addCell(row2);
//
//                PdfPCell lin31 = new PdfPCell();
//                final Paragraph lin31p0 = new Paragraph("\n移送理由", fontChineseNormalsimfang12);
//                lin31p0.setAlignment(Element.ALIGN_CENTER);
//                lin31.addElement(lin31p0);
//                PdfPCell lin32 = new PdfPCell();
//                final Paragraph lin32p0 = new Paragraph(book.getValue(8), fontChineseNormalsimfang12);
//                lin32p0.setFirstLineIndent(24f);
//                lin32p0.setLeading(24f);
//                lin32p0.setAlignment(Element.ALIGN_LEFT);
//                lin32.addElement(lin32p0);
//                PdfPTable cellTable3 = new PdfPTable(2);
//                cellTable3.setWidths(celltable1float);
//                cellTable3.addCell(lin31);
//                cellTable3.addCell(lin32);
//                PdfPCell row3 = new PdfPCell(cellTable3);
//                row3.setFixedHeight(90f);
//                table.addCell(row3);
//
//                PdfPCell lin41 = new PdfPCell();
//                final Paragraph lin41p0 = new Paragraph("\n承办人员\n拟办意见",
//                        fontChineseNormalsimfang12);
//                lin41p0.setAlignment(Element.ALIGN_CENTER);
//                lin41.addElement(lin41p0);
//                PdfPTable cellTable4_1 = new PdfPTable(1);
//                PdfPCell lin42 = new PdfPCell(cellTable4_1);
//                PdfPCell lin42_1 = new PdfPCell();
//                lin42_1.setBorder(0);
//                lin42_1.setFixedHeight(50f);
//
//                PdfPCell lin42_2 = new PdfPCell();
//                lin42_2.setBorder(0);
//                lin42_2.setFixedHeight(20f);
//                final Paragraph lin42p0 = new Paragraph();
//                lin42p0.setFirstLineIndent(24f);
//                lin42p0.setLeading(24f);
//                lin42p0.setAlignment(Element.ALIGN_LEFT);
//                final Paragraph lin42p01 = new Paragraph();
//                lin42p01.setFirstLineIndent(0f);
//                lin42p01.setLeading(24f);
//                lin42p01.setAlignment(Element.ALIGN_LEFT);
//                Phrase phrase2 = new Phrase();
//                Phrase phrase2_1 = new Phrase();
//                phrase2.add(ChunkFactoryOld.tablenounderLine(book.getValue(9), 1296,
//                        fontChineseNormalsimfang12));
//                phrase2_1.add(new Chunk("承办人（签名）：", fontChineseNormalsimfang12));
//                phrase2_1.add(ChunkFactoryOld.underLine(book.getValue(10), 48,
//                        fontChineseNormalsimfang12));
//                phrase2_1.add(ChunkFactoryOld.tablenounderLine("", 12,
//                        fontChineseNormalsimfang12));
//                phrase2_1.add(ChunkFactoryOld.underLine(book.getValue(11), 48,
//                        fontChineseNormalsimfang12));
//                phrase2_1.add(ChunkFactoryOld.tablenounderLine(StringFactoryBuild.build().getTime(book.getValue(12), 0), 24,
//                        fontChineseNormalsimfang12));
//                phrase2_1.add(new Chunk("年", fontChineseNormalsimfang12));
//                phrase2_1.add(ChunkFactoryOld.tablenounderLine(StringFactoryBuild.build().getTime(book.getValue(12), 1), 6,
//                        fontChineseNormalsimfang12));
//                phrase2_1.add(new Chunk("月", fontChineseNormalsimfang12));
//                phrase2_1.add(ChunkFactoryOld.tablenounderLine(StringFactoryBuild.build().getTime(book.getValue(12), 2), 6,
//                        fontChineseNormalsimfang12));
//                phrase2_1.add(new Chunk("日", fontChineseNormalsimfang12));
//
//                lin42p0.add(phrase2);
//                lin42p01.add(phrase2_1);
//                lin42_1.addElement(lin42p0);
//                lin42_2.addElement(lin42p01);
//                cellTable4_1.addCell(lin42_1);
//                cellTable4_1.addCell(lin42_2);
//                PdfPTable cellTable4 = new PdfPTable(2);
//                cellTable4.setWidths(celltable1float);
//                cellTable4.addCell(lin41);
//                cellTable4.addCell(lin42);
//                PdfPCell row4 = new PdfPCell(cellTable4);
//                row4.setFixedHeight(90f);
//                table.addCell(row4);
//
//                PdfPCell cell1 = new PdfPCell();
//                final Paragraph cell1p = new Paragraph(new Chunk("\n部门负责人\n审核意见",
//                        fontChineseNormalsimfang12));
//                cell1p.setAlignment(Element.ALIGN_CENTER);
//                cell1.addElement(cell1p);
//                PdfPTable cellTable5_1 = new PdfPTable(1);
//
//                PdfPCell cell2 = new PdfPCell(cellTable5_1);
//                PdfPCell cell2_1 = new PdfPCell();
//                PdfPCell cell2_2 = new PdfPCell();
//                cell2_1.setBorder(0);
//                cell2_1.setFixedHeight(30f);
//                cell2_2.setBorder(0);
//                cell2_2.setFixedHeight(45f);
//                final Paragraph cell2p = new Paragraph();
//                cell2p.setAlignment(Element.ALIGN_LEFT);
//                cell2p.setIndentationLeft(24f);
//                cell2p.setLeading(24f);
//
//                Phrase phrase3 = new Phrase();
//
//                final Paragraph cell2p1 = new Paragraph();
//                cell2p1.setAlignment(Element.ALIGN_LEFT);
//                cell2p1.setIndentationLeft(24f);
//                cell2p1.setLeading(24f);
//
//                Phrase phrase31 = new Phrase();
//
//                phrase3.add(ChunkFactoryOld.tablenounderLine(book.getValue(13), 150,
//                        fontChineseNormalsimfang12));
//                phrase31.add(ChunkFactoryOld.tablenounderLine("", 150,
//                        fontChineseNormalsimfang12));
//                phrase31.add(new Chunk("审核人（签名）：", fontChineseNormalsimfang12));
//                phrase31.add(ChunkFactoryOld.tablenounderLine(book.getValue(14), 96,
//                        fontChineseNormalsimfang12));
//                phrase31.add(ChunkFactoryOld.tablenounderLine("", 180,
//                        fontChineseNormalsimfang12));
////                phrase31.add(ChunkFactoryOld.tablenounderLine("", 150,
////                        fontChineseNormalsimfang12));
////                phrase31.add(ChunkFactoryOld.tablenounderLine("", 150,
////                        fontChineseNormalsimfang12));
//                phrase31.add(ChunkFactoryOld.tablenounderLine(StringFactoryBuild.build().getTime(book.getValue(15), 0), 36,
//                        fontChineseNormalsimfang12));
//                phrase31.add(new Chunk("年", fontChineseNormalsimfang12));
//                phrase31.add(ChunkFactoryOld.tablenounderLine(StringFactoryBuild.build().getTime(book.getValue(15), 1), 6,
//                        fontChineseNormalsimfang12));
//                phrase31.add(new Chunk("月", fontChineseNormalsimfang12));
//                phrase31.add(ChunkFactoryOld.tablenounderLine(StringFactoryBuild.build().getTime(book.getValue(15), 2), 6,
//                        fontChineseNormalsimfang12));
//                phrase31.add(new Chunk("日", fontChineseNormalsimfang12));
//                cell2p.add(phrase3);
//                cell2p1.add(phrase31);
//                cell2_1.addElement(cell2p);
//                cell2_2.addElement(cell2p1);
//                cellTable5_1.addCell(cell2_1);
//                cellTable5_1.addCell(cell2_2);
//                PdfPTable cellTable5 = new PdfPTable(2);
//                cellTable5.setWidths(celltable1float);
//                cellTable5.addCell(cell1);
//                cellTable5.addCell(cell2);
//                PdfPCell row5 = new PdfPCell(cellTable5);
//                row5.setFixedHeight(90f);
//                table.addCell(row5);
//
//                PdfPCell cell3 = new PdfPCell();
//                final Paragraph cell3p = new Paragraph(new Chunk("\n机关负责人\n审批意见",
//                        fontChineseNormalsimfang12));
//                cell3p.setAlignment(Element.ALIGN_CENTER);
//                cell3.addElement(cell3p);
//                PdfPTable cellTable6_1 = new PdfPTable(1);
//
//                PdfPCell cell4 = new PdfPCell(cellTable6_1);
//                PdfPCell cell4_1 = new PdfPCell();
//                PdfPCell cell4_2 = new PdfPCell();
//                cell4_1.setBorder(0);
//                cell4_1.setFixedHeight(30f);
//                cell4_2.setBorder(0);
//                cell4_2.setFixedHeight(45f);
//                final Paragraph cell4p = new Paragraph();
//                cell4p.setAlignment(Element.ALIGN_LEFT);
//                cell4p.setIndentationLeft(24f);
//                cell4p.setLeading(24f);
//
//                Phrase phrase4 = new Phrase();
//
//                final Paragraph cell4p1 = new Paragraph();
//                cell4p1.setAlignment(Element.ALIGN_LEFT);
//                cell4p1.setIndentationLeft(24f);
//                cell4p1.setLeading(24f);
//
//                Phrase phrase41 = new Phrase();
//                phrase4.add(ChunkFactoryOld.tablenounderLine(book.getValue(16), 150,
//                        fontChineseNormalsimfang12));
//                phrase41.add(ChunkFactoryOld.tablenounderLine("", 150,
//                        fontChineseNormalsimfang12));
//                phrase41.add(new Chunk("审批人（签名）：", fontChineseNormalsimfang12));
//                phrase41.add(ChunkFactoryOld.tablenounderLine(book.getValue(17), 96,
//                        fontChineseNormalsimfang12));
//                phrase41.add(ChunkFactoryOld.tablenounderLine("", 180,
//                        fontChineseNormalsimfang12));
////                phrase41.add(ChunkFactoryOld.tablenounderLine("", 150,
////                        fontChineseNormalsimfang12));
////                phrase41.add(ChunkFactoryOld.tablenounderLine("", 36,
////                        fontChineseNormalsimfang12));
//                phrase41.add(ChunkFactoryOld.tablenounderLine(StringFactoryBuild.build().getTime(book.getValue(18), 0), 36,
//                        fontChineseNormalsimfang12));
//                phrase41.add(new Chunk("年", fontChineseNormalsimfang12));
//                phrase41.add(ChunkFactoryOld.tablenounderLine(StringFactoryBuild.build().getTime(book.getValue(18), 1), 6,
//                        fontChineseNormalsimfang12));
//                phrase41.add(new Chunk("月", fontChineseNormalsimfang12));
//                phrase41.add(ChunkFactoryOld.tablenounderLine(StringFactoryBuild.build().getTime(book.getValue(18), 2), 6,
//                        fontChineseNormalsimfang12));
//                phrase41.add(new Chunk("日", fontChineseNormalsimfang12));
//                cell4p.add(phrase4);
//                cell4p1.add(phrase41);
//                cell4_1.addElement(cell4p);
//
//                cell4_2.addElement(cell4p1);
//                cellTable6_1.addCell(cell4_1);
//                cellTable6_1.addCell(cell4_2);
//                PdfPTable cellTable6 = new PdfPTable(2);
//                cellTable6.setWidths(celltable1float);
//                cellTable6.addCell(cell3);
//                cellTable6.addCell(cell4);
//                PdfPCell row6 = new PdfPCell(cellTable6);
//                row6.setFixedHeight(90f);
//                table.addCell(row6);
//
//                document.add(table);
//                document.add(space1);
//                // 表格end
//
//                PdfContentByte canvas2 = dpfwPdfWriter.getDirectContent();
//                // 电子签章
//                Image img = ImageBuilder.getInstance(image);
//                if (img != null) {
//                    img.setAbsolutePosition(350, 140);
//                    canvas2.addImage(img);
//                }
//                document.newPage();
//            }
//        });
//
//    }
//
//    //案件移送书
//    public void printerEntity_Book34(final Base_Entity book, final Object image) {
//        printFrameWork(book, image, new IPdfBackFrame() {
//            @Override
//            public void writeContent() throws Exception {
//                //此处写页面布局
//                final Paragraph title = new Paragraph("" + city + "安全生产行政执法文书", fontChineseBoldsimhei15);// Paragraph就是段落
//                title.setLeading(1f);// 段落距离
//                // title.setSpacingBefore(25f);//段落留白
//                title.setAlignment(Element.ALIGN_CENTER);// 居中
//                document.add(title);// 写入文档
//                final Paragraph titleLine1 = new Paragraph(new Chunk(new LineSeparator()));// 加入一个换行
//                titleLine1.setLeading(1f);
//                titleLine1.setSpacingBefore(5f);
//                document.add(titleLine1);
//                final Paragraph titleLine2 = new Paragraph(new Chunk(new LineSeparator()));
//                titleLine2.setLeading(1f);
//                titleLine2.setSpacingBefore(1f);
//                document.add(titleLine2);
//                final Paragraph title2 = new Paragraph("案件移送书", fontChineseBoldsimhei15);
//
//                title2.setLeading(1f);
//                title2.setSpacingBefore(17f);
//                title2.setAlignment(Element.ALIGN_CENTER);
//                document.add(title2);
//
//                final Paragraph title3 = new Paragraph("( " + book.getValue(0) + " )安监管移〔" + book.getValue(1) + "〕"
//                        + book.getValue(2) + "号", fontChineseNormalsimfang12);
//                title3.setLeading(1f);
//                title3.setSpacingBefore(30f);
//                title3.setAlignment(Element.ALIGN_CENTER);
//                document.add(title3);
//
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//
//                final Paragraph entParagraph = new Paragraph();
//                entParagraph.setLeading(24f);
//                entParagraph.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase1 = new Phrase();
//                phrase1.add((ChunkFactoryOld.underLine(book.getValue(3), 192,
//                        fontChineseNormalsimfang12)));
//                phrase1.add(new Chunk(":", fontChineseNormalsimfang12));
//                toMeasurefloat(phrase1);
//
//                entParagraph.add(phrase1);
//
//                document.add(entParagraph);
//
//                final Paragraph paragraph1 = new Paragraph();
//                paragraph1.setFirstLineIndent(24f);
//                paragraph1.setLeading(24f);
//                paragraph1.setAlignment(Element.ALIGN_LEFT);
//
////                final Paragraph paragraph1_1 = new Paragraph();
////                paragraph1_1.setFirstLineIndent(24f);
////                paragraph1_1.setLeading(24f);
////                paragraph1_1.setAlignment(Element.ALIGN_LEFT);
//
//                final Paragraph paragraph1_2 = new Paragraph();
//                paragraph1_2.setFirstLineIndent(0f);
//                paragraph1_2.setLeading(24f);
//                paragraph1_2.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase2 = new Phrase();
//                Phrase phrase2_1 = new Phrase();
//                Phrase phrase2_2 = new Phrase();
//                phrase2.add(new Chunk("本机关于", fontChineseNormalsimfang12));
//                phrase2.add(ChunkFactoryOld
//                        .underLine(StringFactoryBuild.build().getTime(book.getValue(4), 0), 24, fontChineseNormalsimfang12));
//                phrase2.add(new Chunk("年", fontChineseNormalsimfang12));
//                phrase2.add(ChunkFactoryOld
//                        .underLine(StringFactoryBuild.build().getTime(book.getValue(4), 1), 24, fontChineseNormalsimfang12));
//                phrase2.add(new Chunk("月", fontChineseNormalsimfang12));
//                phrase2.add(ChunkFactoryOld
//                        .underLine(StringFactoryBuild.build().getTime(book.getValue(4), 2), 24, fontChineseNormalsimfang12));
//                phrase2.add(new Chunk("日对", fontChineseNormalsimfang12));
//                phrase2.add(ChunkFactoryOld.underLine(book.getValue(5), 186,
//                        fontChineseNormalsimfang12));
//                 phrase2.add(new Chunk("一案立案调查，因在调查中发现", fontChineseNormalsimfang12));
//                phrase2.add(ChunkFactoryOld.underLine(book.getValue(6), 2840,
//                        fontChineseNormalsimfang12,168,430));
//                 phrase2.add(new Chunk("，故此案已超过本行行政机关管辖范围，根据",
//                         fontChineseNormalsimfang12));
//                phrase2.add(ChunkFactoryOld.underLine(book.getValue(7), 606,
//                        fontChineseNormalsimfang12,240,430));
//                phrase2_2
//                        .add(new Chunk("的规定，现将该案件移送你单位，请依法处理。", fontChineseNormalsimfang12));
//
//                paragraph1.add(phrase2);
//
////                paragraph1_1.add(phrase2_1);
//                paragraph1_2.add(phrase2_2);
//                document.add(paragraph1);
////                document.add(paragraph1_1);
//                document.add(paragraph1_2);
//
//                final Paragraph paragraph2 = new Paragraph();
//                paragraph2.setFirstLineIndent(24f);
//                paragraph2.setLeading(24f);
//                paragraph2.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase3 = new Phrase();
//                 phrase3.add(new Chunk("附该案件有关材料：", fontChineseNormalsimfang12));
//                phrase3.add(ChunkFactoryOld.underLine(book.getValue(8), 1578,
//                        fontChineseNormalsimfang12,132,430));
//                phrase3.add(new Chunk("共", fontChineseNormalsimfang12));
//                phrase3.add(ChunkFactoryOld.underLine(book.getValue(9), 36,
//                        fontChineseNormalsimfang12));
//                phrase3.add(new Chunk("份", fontChineseNormalsimfang12));
//                phrase3.add(ChunkFactoryOld.underLine(book.getValue(10), 36,
//                        fontChineseNormalsimfang12));
//                phrase3.add(new Chunk("页。", fontChineseNormalsimfang12));
//                toMeasurefloat(phrase3);
//
//                paragraph2.add(phrase3);
//
//                document.add(paragraph2);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//
//                final Paragraph paragraph7 = new Paragraph();
//                paragraph7.setFirstLineIndent(264f);
//                paragraph7.setLeading(24f);
//                paragraph7.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase12 = new Phrase();
//                phrase12.add(new Chunk("安全生产监督管理部门（公章）", fontChineseNormalsimfang12));
//                toMeasurefloat(phrase12);
//
//                paragraph7.add(phrase12);
//                document.add(paragraph7);
//
//                final Paragraph paragraph8 = new Paragraph();
//                paragraph8.setFirstLineIndent(264f);
//                paragraph8.setLeading(24f);
//                paragraph8.setAlignment(Element.ALIGN_LEFT);
//
//                Phrase phrase13 = new Phrase();
//                phrase13.add(ChunkFactoryOld.tablenounderLine(StringFactoryBuild.build().getTime(book.getValue(11), 0), 36,
//                        fontChineseNormalsimfang12));
//                phrase13.add(new Chunk("年", fontChineseNormalsimfang12));
//                phrase13.add(ChunkFactoryOld.tablenounderLine(StringFactoryBuild.build().getTime(book.getValue(11), 1), 6,
//                        fontChineseNormalsimfang12));
//                phrase13.add(new Chunk("月", fontChineseNormalsimfang12));
//                phrase13.add(ChunkFactoryOld.tablenounderLine(StringFactoryBuild.build().getTime(book.getValue(11), 2), 6,
//                        fontChineseNormalsimfang12));
//                phrase13.add(new Chunk("日", fontChineseNormalsimfang12));
//                toMeasurefloat(phrase13);
//
//                paragraph8.add(phrase13);
//                document.add(paragraph8);
//                document.add(space1);
//                document.add(space1);
//                document.add(space1);
//                final Paragraph bottomLine1 = new Paragraph(
//                        new Chunk(new LineSeparator()));// 加入一个换行
//                bottomLine1.setLeading(1f);
//                bottomLine1.setSpacingBefore(5f);
//
//                document.add(bottomLine1);
//
//                final Paragraph paragraph9 = new Paragraph();
//                Phrase phrase14 = new Phrase();
//                phrase14.add(new Chunk("本文书一式两份：一份由安全生产监督管理部门备案，一份交被移送单位。",
//                        fontChineseNormalsimfang12));
//                paragraph9.add(phrase14);
//
//                document.add(paragraph9);
//                PdfContentByte canvas = dpfwPdfWriter.getDirectContent();
//
//                Phrase phrase18 = new Phrase();
//
////                phrase18.add(new Chunk("一案立案调查，因在调查中发现：", fontChineseNormalsimfang12));
////                ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phrase18,
////                        80, 594, 0);
////
////                Phrase phrase19 = new Phrase();
////
////                phrase19.add(new Chunk("故此案已超出本行政机关管辖范围，根据：", fontChineseNormalsimfang12));
////                ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phrase19,
////                        80, 425, 0);
////
////                Phrase phrase20 = new Phrase();
////
////                phrase20.add(new Chunk("附该案件有关材料：", fontChineseNormalsimfang12));
////                ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phrase20,
////                        104, 354, 0);
//                PdfContentByte canvas2 = dpfwPdfWriter.getDirectContent();
//                // 电子签章
//                Image img = ImageBuilder.getInstance(image);
//                if (img != null) {
//                    img.setAbsolutePosition(350, 140);
//                    canvas2.addImage(img);
//                }
//                document.newPage();// 结束保存
//            }
//        });
//
//    }
//
//    //案卷首页
//    public void printerEntity_Book35(final Base_Entity book, final Object image) {
//        printFrameWork(book, image, new IPdfBackFrame() {
//            @Override
//            public void writeContent() throws Exception {
//                //此处写页面布局
//                document.add(space1);
//
//                final Paragraph title = new Paragraph();// Paragraph就是段落
//                title.setLeading(1f);// 段落距离
//                title.setSpacingBefore(25f);// 段落留白
//                title.setAlignment(Element.ALIGN_CENTER);// 居中
//                Phrase titlePhrase = new Phrase();
//                titlePhrase.add(ChunkFactoryOld.underLine(book.getValue(3), 72,
//                        fontChineseNormalsimfang12));
//                titlePhrase.add(new Chunk("安全生产监督管理局", fontChineseBoldsimhei20));
//                title.add(titlePhrase);
//
//                document.add(title);// 写入文档
//                document.add(space2);
//                final Paragraph title2 = new Paragraph("安全生产违法案件", fontChineseBoldsimfang16);
//                title2.setLeading(1f);
//                title2.setSpacingBefore(15f);
//                title2.setAlignment(Element.ALIGN_CENTER);
//                document.add(title2);
//                document.add(space2);
//                final Paragraph title3 = new Paragraph("案卷（首页）", fontChineseBoldsimfang16);
//                title3.setLeading(1f);
//                title3.setSpacingBefore(15f);
//                title3.setAlignment(Element.ALIGN_CENTER);
//                document.add(title3);
//                document.add(space2);
//                document.add(space2);
//
//                final Paragraph title4 = new Paragraph("( " + book.getValue(0) + " )安监管案〔" + book.getValue(1) + "〕"
//                        + book.getValue(2) + "号", fontChineseNormalsimfang12);
//                title4.setLeading(1f);
//                title4.setSpacingBefore(25f);
//                title4.setAlignment(Element.ALIGN_CENTER);
//                document.add(title4);
//                document.add(space2);
//                document.add(space2);
//
//                final Paragraph paragraph1 = new Paragraph();
//                paragraph1.setAlignment(Element.ALIGN_LEFT);
//                paragraph1.setFirstLineIndent(2f);
//                Phrase phrase1 = new Phrase();
//                phrase1.add(new Chunk("案件名称：", fontChineseNormalsimfang12));
//                phrase1.add(ChunkFactoryOld.underLine(book.getValue(4), 360,
//                        fontChineseNormalsimfang12));
//                paragraph1.add(phrase1);
//
//                document.add(paragraph1);
//                document.add(space2);
//
//                PdfPTable table = new PdfPTable(1);
//                table.setWidthPercentage(100f);
//
//                PdfPCell cell1 = new PdfPCell();
//                final Paragraph cell1p = new Paragraph("\n\n案\n\n由", fontChineseBoldsimfang16);
//                cell1p.setAlignment(Element.ALIGN_CENTER);
//                cell1.addElement(cell1p);
//
//                PdfPCell cell2 = new PdfPCell();
//                final Paragraph cell2p = new Paragraph();
//                cell2p.setAlignment(Element.ALIGN_LEFT);
//                cell2p.setFirstLineIndent(24f);
//                cell2p.setLeading(24f);
//                Phrase phrase2 = new Phrase();
//                phrase2.add(ChunkFactoryOld.tablenounderLine(book.getValue(5), 200,
//                        fontChineseNormalsimfang12));
//                cell2p.add(phrase2);
//                cell2.addElement(cell2p);
//
//                PdfPTable cellTable1 = new PdfPTable(2);
//                float[] tablewidth = new float[]{2f, 18f};
//                cellTable1.setWidths(tablewidth);
//                cellTable1.addCell(cell1);
//                cellTable1.addCell(cell2);
//
//                PdfPCell row1 = new PdfPCell(cellTable1);
//                row1.setFixedHeight(180f);
//                table.addCell(row1);
//
//                PdfPCell cell3 = new PdfPCell();
//                final Paragraph cell3p = new Paragraph("\n处\n理\n结\n果", fontChineseBoldsimfang16);
//                cell3p.setAlignment(Element.ALIGN_CENTER);
//                cell3.addElement(cell3p);
//
//                PdfPCell cell4 = new PdfPCell();
//                final Paragraph cell4p = new Paragraph();
//                cell4p.setAlignment(Element.ALIGN_LEFT);
//                cell4p.setFirstLineIndent(24f);
//                cell4p.setLeading(24f);
//                Phrase phrase3 = new Phrase();
//                phrase3.add(ChunkFactoryOld.tablenounderLine(book.getValue(6), 200,
//                        fontChineseNormalsimfang12));
//                cell4p.add(phrase3);
//                cell4.addElement(cell4p);
//
//                PdfPTable cellTable2 = new PdfPTable(2);
//                cellTable2.setWidths(tablewidth);
//                cellTable2.addCell(cell3);
//                cellTable2.addCell(cell4);
//
//                PdfPCell row2 = new PdfPCell(cellTable2);
//                row2.setFixedHeight(180f);
//                table.addCell(row2);
//
//                document.add(table);
//                document.add(space1);
//
//                final Paragraph paragraph2 = new Paragraph();
//                paragraph2.setAlignment(Element.ALIGN_LEFT);
//                paragraph2.setIndentationLeft(24f);
//                paragraph2.setLeading(24f);
//
//                Phrase phrase4 = new Phrase();
//                phrase4.add(new Chunk("立案：", fontChineseNormalsimfang12));
//                phrase4.add(ChunkFactoryOld
//                        .underLine(StringFactoryBuild.build().getTime(book.getValue(7), 0), 36, fontChineseNormalsimfang12));
//                phrase4.add(new Chunk("年", fontChineseNormalsimfang12));
//                phrase4.add(ChunkFactoryOld
//                        .underLine(StringFactoryBuild.build().getTime(book.getValue(7), 1), 36, fontChineseNormalsimfang12));
//                phrase4.add(new Chunk("月", fontChineseNormalsimfang12));
//                phrase4.add(ChunkFactoryOld
//                        .underLine(StringFactoryBuild.build().getTime(book.getValue(7), 2), 36, fontChineseNormalsimfang12));
//                phrase4.add(new Chunk("日", fontChineseNormalsimfang12));
//                phrase4.add("\n");
//                phrase4.add(new Chunk("结案：", fontChineseNormalsimfang12));
//                phrase4.add(ChunkFactoryOld
//                        .underLine(StringFactoryBuild.build().getTime(book.getValue(8), 0), 36, fontChineseNormalsimfang12));
//                phrase4.add(new Chunk("年", fontChineseNormalsimfang12));
//                phrase4.add(ChunkFactoryOld
//                        .underLine(StringFactoryBuild.build().getTime(book.getValue(8), 1), 36, fontChineseNormalsimfang12));
//                phrase4.add(new Chunk("月", fontChineseNormalsimfang12));
//                phrase4.add(ChunkFactoryOld
//                        .underLine(StringFactoryBuild.build().getTime(book.getValue(8), 2), 36, fontChineseNormalsimfang12));
//                phrase4.add(new Chunk("日", fontChineseNormalsimfang12));
//                phrase4.add("\n");
//
//                phrase4.add(new Chunk("承办人：", fontChineseNormalsimfang12));
//                phrase4.add(ChunkFactoryOld
//                        .underLine(book.getValue(9), 72, fontChineseNormalsimfang12));
//                phrase4.add(ChunkFactoryOld.tablenounderLine("", 12,
//                        fontChineseNormalsimfang12));
//                phrase4.add(ChunkFactoryOld
//                        .underLine(book.getValue(10), 72, fontChineseNormalsimfang12));
//                phrase4.add("\n");
//
//                phrase4.add(new Chunk("归档日期：", fontChineseNormalsimfang12));
//                phrase4.add(ChunkFactoryOld
//                        .underLine(StringFactoryBuild.build().getTime(book.getValue(11), 0), 36, fontChineseNormalsimfang12));
//                phrase4.add(new Chunk("年", fontChineseNormalsimfang12));
//                phrase4.add(ChunkFactoryOld
//                        .underLine(StringFactoryBuild.build().getTime(book.getValue(11), 1), 36, fontChineseNormalsimfang12));
//                phrase4.add(new Chunk("月", fontChineseNormalsimfang12));
//                phrase4.add(ChunkFactoryOld
//                        .underLine(StringFactoryBuild.build().getTime(book.getValue(11), 2), 36, fontChineseNormalsimfang12));
//                phrase4.add(new Chunk("日", fontChineseNormalsimfang12));
//                phrase4.add("\n");
//
//                phrase4.add(new Chunk("归档号：", fontChineseNormalsimfang12));
//                phrase4.add(ChunkFactoryOld
//                        .underLine(book.getValue(12), 84, fontChineseNormalsimfang12));
//
//                phrase4.add("\n");
//
//                phrase4.add(new Chunk("保存期限：", fontChineseNormalsimfang12));
//                phrase4.add(ChunkFactoryOld
//                        .underLine(book.getValue(13), 72, fontChineseNormalsimfang12));
//                paragraph2.add(phrase4);
//
//                document.add(paragraph2);
//                PdfContentByte canvas2 = dpfwPdfWriter.getDirectContent();
//                // 电子签章
//                Image img = ImageBuilder.getInstance(image);
//                if (img != null) {
//                    img.setAbsolutePosition(350, 140);
//                    canvas2.addImage(img);
//                }
//                document.newPage();// 结束保存
//            }
//        });
//
//    }
//
//    //卷内目录
//    public void printerEntity_Book36(final Base_Entity book, final Object image) {
//        printFrameWork(book, image, new IPdfBackFrame() {
//            @Override
//            public void writeContent() throws Exception {
//                //此处写页面布局
//                final Paragraph title = new Paragraph();
//                title.setAlignment(Element.ALIGN_CENTER);
//                title.add(new Chunk("卷 内 目 录", fontChineseBoldsimhei20));
//                document.add(title);
//                PdfPTable table = new PdfPTable(1);
//                table.setSpacingBefore(40f);// 设置表格上面空白宽度
//                table.setWidthPercentage(100f);
//
//                PdfPCell lin01 = new PdfPCell();
//                final Paragraph lin01p0 = new Paragraph("序号", fontChineseNormalsimfang12);
//                lin01p0.setAlignment(Element.ALIGN_CENTER);
//                lin01.addElement(lin01p0);
//                PdfPCell lin02 = new PdfPCell();
//                final Paragraph lin02p0 = new Paragraph("文件名称及编号", fontChineseNormalsimfang12);
//                lin02p0.setAlignment(Element.ALIGN_CENTER);
//                lin02.addElement(lin02p0);
//                PdfPCell lin03 = new PdfPCell();
//                final Paragraph lin03p0 = new Paragraph("日期", fontChineseNormalsimfang12);
//                lin03p0.setAlignment(Element.ALIGN_CENTER);
//                lin03.addElement(lin03p0);
//                PdfPCell lin04 = new PdfPCell();
//                final Paragraph lin04p0 = new Paragraph("页号", fontChineseNormalsimfang12);
//                lin04p0.setAlignment(Element.ALIGN_CENTER);
//                lin04.addElement(lin04p0);
//                PdfPCell lin05 = new PdfPCell();
//                final Paragraph lin05p0 = new Paragraph("备注", fontChineseNormalsimfang12);
//                lin05p0.setAlignment(Element.ALIGN_CENTER);
//                lin05.addElement(lin05p0);
//                PdfPTable celltable0 = new PdfPTable(5);
//                float[] celltable0float = new float[5];
//                celltable0float[0] = 2f;
//                celltable0float[1] = 5f;
//                celltable0float[2] = 2f;
//                celltable0float[3] = 2f;
//                celltable0float[4] = 2f;
//                celltable0.setTotalWidth(celltable0float);
//                celltable0.addCell(lin01);
//                celltable0.addCell(lin02);
//                celltable0.addCell(lin03);
//                celltable0.addCell(lin04);
//                celltable0.addCell(lin05);
//                PdfPCell row0 = new PdfPCell(celltable0);
//                row0.setFixedHeight(35f);
//                table.addCell(row0);
//
//                for (int i = 0; i < 17; i++) {
//                    PdfPCell lin171 = new PdfPCell();
//                    final Paragraph lin171p0 = new Paragraph(getListItemValue(book.getValue(3), i, 0), fontChineseNormalsimfang12);
//                    lin171p0.setAlignment(Element.ALIGN_CENTER);
//                    lin171.addElement(lin171p0);
//                    PdfPCell lin172 = new PdfPCell();
//                    final Paragraph lin172p0 = new Paragraph(getListItemValue(book.getValue(3), i, 1), fontChineseNormalsimfang12);
//                    lin172p0.setAlignment(Element.ALIGN_CENTER);
//                    lin172.addElement(lin172p0);
//                    PdfPCell lin173 = new PdfPCell();
//                    final Paragraph lin173p0 = new Paragraph(getListItemValue(book.getValue(3), i, 2), fontChineseNormalsimfang12);
//                    lin173p0.setAlignment(Element.ALIGN_CENTER);
//                    lin173.addElement(lin173p0);
//                    PdfPCell lin174 = new PdfPCell();
//                    final Paragraph lin174p0 = new Paragraph(getListItemValue(book.getValue(3), i, 3), fontChineseNormalsimfang12);
//                    lin174p0.setAlignment(Element.ALIGN_CENTER);
//                    lin174.addElement(lin174p0);
//                    PdfPCell lin175 = new PdfPCell();
//                    final Paragraph lin175p0 = new Paragraph(getListItemValue(book.getValue(3), i, 4), fontChineseNormalsimfang12);
//                    lin175p0.setAlignment(Element.ALIGN_CENTER);
//                    lin175.addElement(lin175p0);
//                    PdfPTable celltable17 = new PdfPTable(5);
//                    float[] celltable17float = new float[5];
//                    celltable17float[0] = 2f;
//                    celltable17float[1] = 5f;
//                    celltable17float[2] = 2f;
//                    celltable17float[3] = 2f;
//                    celltable17float[4] = 2f;
//                    celltable17.setTotalWidth(celltable17float);
//                    celltable17.addCell(lin171);
//                    celltable17.addCell(lin172);
//                    celltable17.addCell(lin173);
//                    celltable17.addCell(lin174);
//                    celltable17.addCell(lin175);
//                    PdfPCell row17 = new PdfPCell(celltable17);
//                    row17.setFixedHeight(35f);
//                    table.addCell(row17);
//                }
//
//
//                // img.scaleToFit(72, 72);//大小
//
//                document.add(table);
//                PdfContentByte canvas2 = dpfwPdfWriter.getDirectContent();
//                // 电子签章
//                Image img = ImageBuilder.getInstance(image);
//                if (img != null) {
//                    img.setAbsolutePosition(350, 140);
//                    canvas2.addImage(img);
//                }
//                document.newPage();
//            }
//        });
//
//    }
//
//}
