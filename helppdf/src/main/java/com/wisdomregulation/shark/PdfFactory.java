package com.wisdomregulation.shark;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.*;
import com.itextpdf.text.pdf.draw.LineSeparator;
import com.wisdomregulation.pdflink.DownLoaderTask;
import com.wisdomregulation.data.entitybase.Base_Entity;
import com.wisdomregulation.pdflink.*;
import com.wisdomregulation.staticlib.Static_BookLib;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * 2017年新文书模板绘制 属于基本实现 如果需要特殊处理的请自己继承并重写 PdfFactoryOverTemp是参考类
 * 一页高度大概695按695算 宽度大概409.5左右 一般即78个单字符 39个中文 409.5/10.5=39  所以设置length尽量用5.25的倍数
 * ps:一行的最大长度为79个数字 即414.75个单位 但是因为中文大小的关系 一行只能放39个单位的中文 一般为409.5个单位
 * 页边距 分别为 84 84 72 72 A4纸
 */
public abstract class PdfFactory {
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
    /**
     * 楷体_GB2312一，一等于26
     */
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
    /**
     * @param foottype  设置页脚方式是 /0为共几页第几页 1为第几页共几页
     * @return
     */
    protected int foottype = 0;//0为共几页第几页 1为第几页共几页

    /**
     * 临时保存用的文书list用来支持批量
     */
    protected List<Base_Entity> tmpbooklist = new ArrayList<Base_Entity>();
    protected boolean firstPrint = true;

    public PdfFactory setFoottype(int foottype) {
        this.foottype = foottype;
        return this;
    }

    /**
     * 公章抬头 可以自行set修改
     */
    public String postmark="安全生产监督管理部门（公章）";

    public String getPostmark() {
        return postmark;
    }

    public PdfFactory setPostmark(String postmark) {
        this.postmark = postmark;

        return this;
    }

    protected abstract PdfFactory getFactory();

    protected static String getCity() {
        return city;
    }

    public PdfFactory setCity(String city) {
        PdfFactory.city = city;
        return this;
    }

    /**
     * 为后续设计进行考虑将成员包裹传递出去解放当前类的负担
     *
     * @return
     */
    public PdfFactoryEntity getFactoryEntity() {
        return new PdfFactoryEntity(dpfwPdfWriter, pdfout, fileout, canprinter, document, space1, space2, space3, space4, rect, ttfiscomplete, timeout, listener, oldopentime, simdir, simkai2312_z1, simhei_z1, simzhongsong_zx2, simzhongsong_z2, simfang2312_zx3, simfang2312_z3, simfang2312_z5, simfang_zx4, foottype, tmpbooklist, firstPrint);
    }

    /**
     * 获得输出路径
     *
     * @return
     */
    public String getFileout() {
        return fileout;
    }

    public PdfFactory setFileout(String fileout) {
        this.fileout = fileout;
        try {
            this.pdfout = new FileOutputStream(fileout);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return this;
    }

    public PdfFactory setPdfout(OutputStream pdfout) {
        this.pdfout = pdfout;

        return this;
    }

    public PdfFactory setTimeout(long timeout) {
        this.timeout = timeout;
        return this;
    }

    public PdfFactory() {
    }

    public PdfFactory setListener(DownLoaderTask.DownLoaderListener listener) {
        this.listener = listener;
        return this;
    }

    /**
     * 设置pdf字体路径
     *
     * @param simdir
     * @return
     */
    public PdfFactory setTTFpath(String simdir) {
        this.simdir = simdir;
        try {
            if (simfang_zx4 == null) {

                long kaishishijian = System.currentTimeMillis();

                if (!"".equals(simdir)) {
                    if(!simdir.endsWith("/")){
                        simdir = simdir + "/";
                    }
                    if (new File(simdir + "simfang.ttf").exists()
                            && new File(simdir + "simfang2312.ttf").exists()
                            && new File(simdir + "simhei.ttf").exists()
                            && new File(simdir + "simkai2312.ttf").exists()
                            && new File(simdir + "simzhongsong.ttf").exists()) {
                    } else {
                        DownLoaderTask.getInstance().setListener(listener).downloadFileandcompression( "Font.zip", simdir);
                    }
                }
//                PdfFactoryLog.println("耗时:" + (System.currentTimeMillis() - kaishishijian));
                listener = null;
                //仿宋小四，小四等于10.5
                simfang_zx4 = FontFactory.getFont(simdir + "simfang.ttf", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED, 12f, Font.NORMAL,
                        BaseColor.BLACK);
                //仿宋_GB2312小三，小三等于15
                simfang2312_zx3 = FontFactory.getFont(simdir + "simfang2312.ttf", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED, 15f, Font.NORMAL,
                        BaseColor.BLACK);
                //仿宋_GB2312三，小三等于16
                simfang2312_z3 = FontFactory.getFont(simdir + "simfang2312.ttf", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED, 16f, Font.NORMAL,
                        BaseColor.BLACK);
                //仿宋_GB2312五号，五号等于10.5
                simfang2312_z5 = FontFactory.getFont(simdir + "simfang2312.ttf", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED, 10.5f, Font.NORMAL,
                        BaseColor.BLACK);
                //黑体一，一等于26
                simhei_z1 = FontFactory.getFont(simdir + "simhei.ttf", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED, 26f, Font.NORMAL,
                        BaseColor.BLACK);
                //楷体_GB2312一，一等于26
                simkai2312_z1 = FontFactory.getFont(simdir + "simkai2312.ttf", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED, 26f, Font.BOLD,
                        BaseColor.BLACK);
                //华文中宋小二，小二等于18
                simzhongsong_zx2 = FontFactory.getFont(simdir + "simzhongsong.ttf", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED, 18f, Font.BOLD,
                        BaseColor.BLACK);
                //华文中宋二，二等于22
                simzhongsong_z2 = FontFactory.getFont(simdir + "simzhongsong.ttf", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED, 22f, Font.BOLD,
                        BaseColor.BLACK);

            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return this;

    }

    boolean isopening = false;
    boolean iscloseing = false;
    protected float left=84f;
    protected float right=84f;
    protected float top=72f;
    protected float bottom=72f;
    protected PdfFactory setPageSize(float left,float right,float top,float bottom){
        this.left=left;
        this.right=right;
        this.top=top;
        this.bottom=bottom;
        return this;
    }

    protected PdfFactory openImp() {
        if (isopening) {
            return this;
        }
        isopening = true;
        oldopentime = System.currentTimeMillis();
        try {
            tmpbooklist.clear();
            document = new Document(PageSize.A4, left, right, top, bottom);
            dpfwPdfWriter = PdfWriter.getInstance(document,
                    pdfout);
            // 改为全局打开
            PdfPageEventHelper headerFooter=null;
//            System.out.println("页脚参数"+foottype);
            if (foottype == 0) {
                headerFooter = new PdfReportM1HeaderFooter(simdir);//页码自动
            } else {
                headerFooter = new PdfReportM2HeaderFooter(simdir);//页码自动
            }
            dpfwPdfWriter.setPageEvent(headerFooter);
            document.open();

            canprinter = true;
        } catch (DocumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return this;
    }

    public PdfFactory openNoFooter() {
        if (oldopentime == 0) {
            oldopentime = System.currentTimeMillis();
            return openImp2();
        } else {
            long sub = System.currentTimeMillis() - oldopentime;
            if (sub > timeout) {
                return openImp2();
            } else {

            }
            return this;
        }
    }

    protected PdfFactory openImp2() {
        if (isopening) {
            return this;
        }
        isopening = true;
        oldopentime = System.currentTimeMillis();
        try {
            tmpbooklist.clear();
            document = new Document(PageSize.A4, left, right, top, bottom);
            dpfwPdfWriter = PdfWriter.getInstance(document,
                    pdfout);
            // 改为全局打开
//            PdfReportM1HeaderFooter headerFooter = new PdfReportM1HeaderFooter(simdir);//页码自动
//            dpfwPdfWriter.setPageEvent(headerFooter);
            document.open();

            canprinter = true;
        } catch (DocumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return this;
    }

    /**
     * 打开pdf文件开始写入
     *
     * @return
     */

    public PdfFactory open() {
        if (oldopentime == 0) {
            oldopentime = System.currentTimeMillis();
            return openImp();
        } else {
            long sub = System.currentTimeMillis() - oldopentime;
            if (sub > timeout) {
                return openImp();
            } else {

            }
            return this;
        }
    }

    public PdfFactory close() {
        return close(null);
    }

    public PdfFactory closeOnMainThread(final IPdfBack back) {
        if (!isopening) {
            if (back != null) {
                back.writeError();
            }
            return this;
        }
        if (iscloseing) {
            if (back != null) {
                back.writeError();
            }
            return this;
        }
        iscloseing = true;
        try {
            if (back != null) {
                back.writeStart();
            }
            for (int i = 0; i < tmpbooklist.size(); i++) {
                Base_Entity book = tmpbooklist.get(i);
                Object image = tmpbooklist.get(i).getExtraSeal();
                try {
                    book.resetKey();
                    Method printm = getFactory().getClass().getDeclaredMethod("printer" + book.getClass().getSimpleName(), Base_Entity.class, Object.class);
                    printm.setAccessible(true);
                    printm.invoke(getFactory(), book, image);
                    book.resetKey();
                } catch (Exception e) {
                    try {
                        book.resetKey();
                        Method printm = getFactory().getClass().getSuperclass().getDeclaredMethod("printer" + book.getClass().getSimpleName(), Base_Entity.class, Object.class);
                        printm.setAccessible(true);
                        printm.invoke(getFactory(), book, image);
                        book.resetKey();
                    } catch (NoSuchMethodException e1) {
                        e1.printStackTrace();
                    } catch (SecurityException e1) {
                        e1.printStackTrace();
                    } catch (IllegalAccessException e1) {
                        e1.printStackTrace();
                    } catch (IllegalArgumentException e1) {
                        e1.printStackTrace();
                    } catch (InvocationTargetException e1) {
                        e1.printStackTrace();
                    }
                }
            }

            try {
                document.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (back != null) {
                back.writeEnd();
            }
            isopening = false;
            iscloseing = false;
            canprinter = false;

        } catch (Exception e) {

        }
        return this;
    }

    /**
     * 写完之后关闭pdf文件
     *
     * @return
     */
    public PdfFactory close(final IPdfBack back) {
        if (!isopening) {
            if (back != null) {
                back.writeError();
            }
            return this;
        }
        if (iscloseing) {
            if (back != null) {
                back.writeError();
            }
            return this;
        }
        iscloseing = true;
        try {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    if (back != null) {
                        back.writeStart();
                    }
                    for (int i = 0; i < tmpbooklist.size(); i++) {
                        Base_Entity book = tmpbooklist.get(i);
                        Object image = tmpbooklist.get(i).getExtraSeal();
                        try {
                            book.resetKey();
                            Method printm = getFactory().getClass().getDeclaredMethod("printer" + book.getClass().getSimpleName(), Base_Entity.class, Object.class);
                            printm.setAccessible(true);
                            printm.invoke(getFactory(), book, image);
                            book.resetKey();
                        } catch (Exception e) {
                            try {
                                book.resetKey();
                                Method printm = getFactory().getClass().getSuperclass().getDeclaredMethod("printer" + book.getClass().getSimpleName(), Base_Entity.class, Object.class);
                                printm.setAccessible(true);
                                printm.invoke(getFactory(), book, image);
                                book.resetKey();
                            } catch (NoSuchMethodException e1) {
                                e1.printStackTrace();
                            } catch (SecurityException e1) {
                                e1.printStackTrace();
                            } catch (IllegalAccessException e1) {
                                e1.printStackTrace();
                            } catch (IllegalArgumentException e1) {
                                e1.printStackTrace();
                            } catch (InvocationTargetException e1) {
                                e1.printStackTrace();
                            }
                        }
                    }

                    try {
                        document.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    if (back != null) {
                        back.writeEnd();
                    }
                    isopening = false;
                    iscloseing = false;
                    canprinter = false;
                }
            }).start();

        } catch (Exception e) {

        }
        return this;
    }


    /**
     * 输出成pdf的管理方法 带签章
     *
     * @param book
     * @param postmaskimage
     * @return
     */
    public PdfFactory printerMaster(final Base_Entity book, final Object postmaskimage) {
        if (!canprinter) {
            return this;
        } else {
            tmpbooklist.add(book.setExtraSeal(postmaskimage));
            return this;
        }
    }

    public PdfFactory printerMasterTest(Base_Entity book) {
        if (!canprinter) {
            return this;
        } else {
            for (int i = 0; i < book.size(); i++) {
                book.put(i, i + "");
            }
            tmpbooklist.add(book.setExtraSeal(null));
            return this;
        }

    }

    /**
     * 输出成pdf的管理方法
     *
     * @param book
     * @return
     */

    public PdfFactory printerMaster(Base_Entity book) {
        if (!canprinter) {
            return this;
        } else {
            tmpbooklist.add(book.setExtraSeal(null));
            return this;
        }

    }

    /**
     * 测量长度
     *
     * @param phrase1
     */
    public static float toMeasurefloat(Chunk phrase1) {
        float result = 0;
        List<Chunk> mArrayList1 = phrase1.getChunks();
        for (int i = 0; i < mArrayList1.size(); i++) {
            float everyblock = ((Chunk) (mArrayList1.get(i))).getWidthPoint();
            result = result + everyblock;
        }
        //PdfFactoryLog.println(result);//PdfFactoryLog.println(result);
        return result;

    }

    /**
     * 测量长度
     *
     * @param phrase1
     */
    public static float toMeasurefloat(Phrase phrase1) {
        float result = 0;
        List<Chunk> mArrayList1 = phrase1.getChunks();
        for (int i = 0; i < mArrayList1.size(); i++) {
            float everyblock = ((Chunk) (mArrayList1.get(i))).getWidthPoint();
            result = result + everyblock;
        }
        //PdfFactoryLog.println(result);
        return result;
    }

    /**
     * 测量长度
     *
     * @param paragraph
     */
    public static float toMeasurefloat(Paragraph paragraph) {
        float result = 0;
        List<Chunk> mArrayList1 = paragraph.getChunks();
        for (int i = 0; i < mArrayList1.size(); i++) {
            float everyblock = ((Chunk) (mArrayList1.get(i))).getWidthPoint();
            result = result + everyblock;
        }
        return result;
    }


    /**
     * 获得文书类型
     *
     * @param booktypename
     * @return
     */
    public static Base_Entity getEneityBook(String booktypename) {
        int typeid = -1;
        Base_Entity bookeneity = null;
        for (int i = 1; i < Static_BookLib.BOOKNAMELIST2017.length; i++) {
            if (booktypename.equals(Static_BookLib.BOOKNAMELIST2017[i])) {
                typeid = i - 1;
                break;
            }
        }
        if (typeid != -1) {
            try {
                bookeneity = (Base_Entity) (Class.forName("com.wisdomregulation.data.entitybook2017." + "Entity_Book" + (typeid)).newInstance());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return bookeneity;
    }
    public static int getListItemSize(String orgliststring) {
        if(orgliststring.matches("(.*)@(.*)")){
            return orgliststring.split("@").length;
        }else{
            return 1;
        }
    }
    /**
     * 将用@符号和#号进行分割   xxx#xxx@xxx#xxx@
     *
     * @param orgliststring
     * @param listindex
     * @param itemindex
     * @return
     */
    public static String getListItemValue(String orgliststring, int listindex, int itemindex) {
        String[] listitem = null;
        String[] listitemitem = null;
        if (orgliststring != null && orgliststring.matches("(.*)@(.*)")) {
            listitem = orgliststring.split("@");
            if (listitem != null && listitem.length >= listindex + 1) {
                listitemitem = listitem[listindex].split("#");
                if (listitemitem != null && listitemitem.length >= itemindex + 1) {
                    return listitemitem[itemindex].trim();
                } else {
                    return "";
                }
            } else {
                return "";
            }
        } else {
            if (orgliststring != null && orgliststring.matches("(.*)#(.*)")) {
                if (listindex == 0) {//没有@符号的只能认为第一条
                    listitem = orgliststring.split("@");
                    listitemitem = listitem[listindex].split("#");
                    if (listitemitem != null && listitemitem.length >= itemindex + 1) {
                        return listitemitem[itemindex].trim();
                    } else {
                        return "";
                    }
                }

            }
            return "";
        }

    }

    /**
     * 设置每页的附件数量
     * @param collectSize
     * @return
     */
    public PdfFactory setCollectSize(int collectSize) {
        this.collectSize = collectSize;
        return this;
    }

    public int collectSize = 2;//设置每页的图片数量

    /**
     * 打印附件用
     *
     * @param book    文书实体
     * @param collect PdfImage 数组
     */

    protected void printerCollect(Base_Entity book, Object[] collect) {

        try {
            PdfPTable table = new PdfPTable(1);
            table.setWidthPercentage(100f);
            PdfPCell cell = null;
            Image img = null;
            boolean loop = true;
            float imageheight = (680 - collectSize * 100) / collectSize;
            int willfindsize = 0;
            willfindsize = (collect.length >= collectSize) ? collectSize : collect.length;
            loop = (collect.length >= collectSize) ? true : false;
            for (int i = 0; i < willfindsize; i++) {
                img = new ImageBuilder().getInstance(((PdfImageCopy) collect[i]).getImage());
                cell = new PdfPCell(img, true);
                img.setScaleToFitHeight(true);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setBorder(0);
                cell.setFixedHeight(imageheight);
                table.addCell(cell);
                cell = new PdfPCell(new Paragraph(20, ((PdfImageCopy) collect[i]).getInfo(), simfang2312_z5));
                cell.setBorder(0);
                cell.setFixedHeight(100f);
//                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);
            }
            document.add(table);
            document.newPage();// 结束保存
            if (loop) {
                Object[] tmpcollect = new Object[collect.length - collectSize];
                for (int i = 0; i < collect.length - collectSize; i++) {
                    tmpcollect[i] = collect[i + collectSize];
                }
                collect = tmpcollect;
                printerCollect(book, collect);
            } else {

            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    /**
     * 年    月    日
     * -----------------------------------------------------------
     * 共   页   第  页
     *
     * @param book
     */
    protected void printerFrameWorkDate(Base_Entity book) {
        try {
            document.add(space2);
            document.add(space2);
            document.add(space2);
            document.add(space2);
            document.add(space2);
            document.add(space2);
            document.add(space2);
            document.add(space1);
            final Paragraph paragraph10 = new ParagraphBuilder();
            paragraph10.setLeading(24f);
            paragraph10.setAlignment(Element.ALIGN_RIGHT);
            Phrase phrase11 = new Phrase();
            phrase11.add(ChunkFactory.tablenounderLine(book.pushneedcheck(), 0, 36,
                    simfang2312_z5));
            phrase11.add(new Chunk("年", simfang2312_z5));
            phrase11.add(ChunkFactory.tablenounderLine(book.pushneedcheck(), 1, 36,
                    simfang2312_z5));
            phrase11.add(new Chunk("月", simfang2312_z5));
            phrase11.add(ChunkFactory.tablenounderLine(book.push(true), 2, 36,
                    simfang2312_z5));
            phrase11.add(new Chunk("日", simfang2312_z5));
            //toMeasurefloat(phrase11);
            paragraph10.add(phrase11);
            document.add(paragraph10);
            final Paragraph bottomLine1 = new ParagraphBuilder(
                    new Chunk(new LineSeparator()));// 加入一个换行
            bottomLine1.setLeading(1f);
            bottomLine1.setSpacingBefore(5f);
            document.add(space2);
            document.add(space1);
            document.add(bottomLine1);
            final Paragraph paragraph11 = new ParagraphBuilder();
//            Phrase phrase12 = new Phrase();
//            phrase12.add(ChunkFactory.tablenounderLine("", 300,
//                    simfang2312_z5));
//            phrase12.add(new Chunk("共", simfang2312_z5));
//            phrase12.add(ChunkFactory.tablenounderLine("", 21,
//                    simfang2312_z5));
//            phrase12.add(new Chunk("页", simfang2312_z5));
//            phrase12.add(ChunkFactory.tablenounderLine("", 21,
//                    simfang2312_z5));
//            phrase12.add(new Chunk("第", simfang2312_z5));
//            phrase12.add(ChunkFactory.tablenounderLine("", 21,
//                    simfang2312_z5));
//            phrase12.add(new Chunk("页", simfang2312_z5));
//            paragraph11.add(phrase12);
            document.add(paragraph11);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 年    月    日
     * -----------------------------------------------------------
     * 共   页   第  页
     * <p>
     * //     * @param book
     */
    protected void printerFrameWorkDate(String date) {
        try {
            document.add(space2);
            document.add(space2);
            document.add(space2);
            document.add(space2);
            document.add(space2);
            document.add(space2);
            document.add(space2);
            document.add(space1);
            final Paragraph paragraph10 = new ParagraphBuilder();
            paragraph10.setLeading(24f);
            paragraph10.setAlignment(Element.ALIGN_RIGHT);
            Phrase phrase11 = new Phrase();
            phrase11.add(ChunkFactory.tablenounderLine(date, 0, 36,
                    simfang2312_z5));
            phrase11.add(new Chunk("年", simfang2312_z5));
            phrase11.add(ChunkFactory.tablenounderLine(date, 1, 36,
                    simfang2312_z5));
            phrase11.add(new Chunk("月", simfang2312_z5));
            phrase11.add(ChunkFactory.tablenounderLine(date, 2, 36,
                    simfang2312_z5));
            phrase11.add(new Chunk("日", simfang2312_z5));
            //toMeasurefloat(phrase11);
            paragraph10.add(phrase11);
            document.add(paragraph10);
            final Paragraph bottomLine1 = new ParagraphBuilder(
                    new Chunk(new LineSeparator()));// 加入一个换行
            bottomLine1.setLeading(1f);
            bottomLine1.setSpacingBefore(5f);
            document.add(space2);
            document.add(space1);
            document.add(bottomLine1);
            final Paragraph paragraph11 = new ParagraphBuilder();
//            Phrase phrase12 = new Phrase();
//            phrase12.add(ChunkFactory.tablenounderLine("", 300,
//                    simfang2312_z5));
//            phrase12.add(new Chunk("共", simfang2312_z5));
//            phrase12.add(ChunkFactory.tablenounderLine("", 21,
//                    simfang2312_z5));
//            phrase12.add(new Chunk("页", simfang2312_z5));
//            phrase12.add(ChunkFactory.tablenounderLine("", 21,
//                    simfang2312_z5));
//            phrase12.add(new Chunk("第", simfang2312_z5));
//            phrase12.add(ChunkFactory.tablenounderLine("", 21,
//                    simfang2312_z5));
//            phrase12.add(new Chunk("页", simfang2312_z5));
//            paragraph11.add(phrase12);
            document.add(paragraph11);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 安全生产监督管理部门（印章）
     * 年    月    日
     * -----------------------------------------------------------------
     * 本文书一式两份：一份由安全生产监督管理部门备案，一份交被检查单位。
     * <p>
     * 共   页  第  页
     *
     * @param book
     */
    protected void printerFrameWorkG1(Base_Entity book) {
        try {
            document.add(space2);
            document.add(space2);
            document.add(space2);
            document.add(space2);
            document.add(space2);
            final Paragraph paragraph9 = new ParagraphBuilder();
            paragraph9.setLeading(24f);
            paragraph9.setAlignment(Element.ALIGN_RIGHT);
            Phrase phrase10 = new Phrase();
            phrase10.add(new Chunk(getPostmark(), simfang2312_z5));
            //toMeasurefloat(phrase10);
            paragraph9.add(phrase10);
            document.add(paragraph9);
            final Paragraph paragraph10 = new ParagraphBuilder();
            paragraph10.setLeading(24f);
            paragraph10.setAlignment(Element.ALIGN_RIGHT);
            Phrase phrase11 = new Phrase();
            phrase11.add(ChunkFactory.tablenounderLine(book.pushneedcheck(), 0, 36,
                    simfang2312_z5));
            phrase11.add(new Chunk("年", simfang2312_z5));
            phrase11.add(ChunkFactory.tablenounderLine(book.pushneedcheck(), 1, 36,
                    simfang2312_z5));
            phrase11.add(new Chunk("月", simfang2312_z5));
            phrase11.add(ChunkFactory.tablenounderLine(book.push(true), 2, 36,
                    simfang2312_z5));
            phrase11.add(new Chunk("日", simfang2312_z5));
            //toMeasurefloat(phrase11);
            paragraph10.add(phrase11);
            document.add(space2);
            document.add(paragraph10);
            document.add(space2);
            document.add(space2);
            final Paragraph bottomLine1 = new ParagraphBuilder(
                    new Chunk(new LineSeparator()));// 加入一个换行
            bottomLine1.setLeading(1f);
            bottomLine1.setSpacingBefore(5f);
            document.add(bottomLine1);
            final Paragraph paragraph11 = new ParagraphBuilder();
//            Phrase phrase12 = new Phrase();
//            phrase12.add(ChunkFactory.tablenounderLine("", 298,
//                    simfang2312_z5));
//            phrase12.add(new Chunk("共", simfang2312_z5));
//            phrase12.add(ChunkFactory.tablenounderLine("", 21,
//                    simfang2312_z5));
//            phrase12.add(new Chunk("页", simfang2312_z5));
//            phrase12.add(ChunkFactory.tablenounderLine("", 21,
//                    simfang2312_z5));
//            phrase12.add(new Chunk("第", simfang2312_z5));
//            phrase12.add(ChunkFactory.tablenounderLine("", 21,
//                    simfang2312_z5));
//            phrase12.add(new Chunk("页", simfang2312_z5));
//            paragraph11.add(phrase12);
            document.add(paragraph11);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 安全生产监督管理部门（印章）
     * 年  月  日
     *
     * @param book
     */
    protected void printerFrameWorkG2(Base_Entity book) {
        try {
            document.add(space2);
            document.add(space2);
            document.add(space2);
            document.add(space2);
            document.add(space2);
            final Paragraph paragraph9 = new ParagraphBuilder();
            paragraph9.setLeading(24f);
            paragraph9.setAlignment(Element.ALIGN_RIGHT);
            Phrase phrase10 = new Phrase();
            phrase10.add(new Chunk(getPostmark(), simfang2312_z5));
            //toMeasurefloat(phrase10);
            paragraph9.add(phrase10);
            document.add(paragraph9);
            final Paragraph paragraph10 = new ParagraphBuilder();
            paragraph10.setLeading(24f);
            paragraph10.setAlignment(Element.ALIGN_RIGHT);
            Phrase phrase11 = new Phrase();
            phrase11.add(ChunkFactory.tablenounderLine(book.pushneedcheck(), 0, 36,
                    simfang2312_z5));
            phrase11.add(new Chunk("年", simfang2312_z5));
            phrase11.add(ChunkFactory.tablenounderLine(book.pushneedcheck(), 1, 36,
                    simfang2312_z5));
            phrase11.add(new Chunk("月", simfang2312_z5));
            phrase11.add(ChunkFactory.tablenounderLine(book.push(true), 2, 36,
                    simfang2312_z5));
            phrase11.add(new Chunk("日", simfang2312_z5));
            //toMeasurefloat(phrase11);
            paragraph10.add(phrase11);
            document.add(paragraph10);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * ------------------------------------------------------------------------
     * 本文书一式两份：一份由安全生产监督管理部门备案，一份交被取证人（单位）。
     *
     * @param book
     */
    protected void printerFrameWorkG3(Base_Entity book) {
        try {
            document.add(space2);

            final Paragraph paragraph10 = new ParagraphBuilder();
            paragraph10.setLeading(24f);
            paragraph10.setAlignment(Element.ALIGN_RIGHT);
            document.add(paragraph10);
            final Paragraph bottomLine1 = new ParagraphBuilder(
                    new Chunk(new LineSeparator()));// 加入一个换行
            bottomLine1.setLeading(1f);
            bottomLine1.setSpacingBefore(5f);

            document.add(bottomLine1);

            final Paragraph paragraph11 = new ParagraphBuilder();
            Phrase phrase12 = new Phrase();
            phrase12.add(new Chunk("本文书一式两份：一份由安全生产监督管理部门备案，一份交被复查单位。",
                    simfang2312_z5));
            paragraph11.add(phrase12);

            document.add(paragraph11);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     *      * 年    月    日
     *      * -----------------------------------------------------------------
     * @param book
     */
    protected void printerFrameWorkG4(Base_Entity book) {
        try {
//            document.add(space2);
//            document.add(space2);
//            document.add(space2);
//            document.add(space2);
//            document.add(space2);
            final Paragraph paragraph9 = new ParagraphBuilder();
            paragraph9.setFirstLineIndent(264f);
            paragraph9.setLeading(24f);
            paragraph9.setAlignment(Element.ALIGN_LEFT);
            final Paragraph paragraph10 = new ParagraphBuilder();
            paragraph10.setLeading(24f);
            paragraph10.setAlignment(Element.ALIGN_RIGHT);

            Phrase phrase11 = new Phrase();
            phrase11.add(ChunkFactory.tablenounderLine(book.pushneedcheck(), 0, 36,
                    simfang2312_z5));
            phrase11.add(new Chunk("年", simfang2312_z5));
            phrase11.add(ChunkFactory.tablenounderLine(book.pushneedcheck(), 1, 36,
                    simfang2312_z5));
            phrase11.add(new Chunk("月", simfang2312_z5));
            phrase11.add(ChunkFactory.tablenounderLine(book.push(true), 2, 36,
                    simfang2312_z5));
            phrase11.add(new Chunk("日", simfang2312_z5));
            //toMeasurefloat(phrase11);
            paragraph10.add(phrase11);
            document.add(paragraph10);
            final Paragraph bottomLine1 = new ParagraphBuilder(
                    new Chunk(new LineSeparator()));// 加入一个换行
            bottomLine1.setLeading(1f);
            bottomLine1.setSpacingBefore(5f);
            document.add(bottomLine1);
            final Paragraph paragraph11 = new ParagraphBuilder();
            Phrase phrase12 = new Phrase();
//            phrase12.add(new Chunk("本文书一式两份：一份由安全生产监督管理部门备案，一份交被复查单位。",
//                    simfang2312_z5));
//            phrase12.add(ChunkFactory.tablenounderLine("", 300,
//                    simfang2312_z5));
//            phrase12.add(new Chunk("共", simfang2312_z5));
//            phrase12.add(ChunkFactory.tablenounderLine("", 21,
//                    simfang2312_z5));
//            phrase12.add(new Chunk("页", simfang2312_z5));
//            phrase12.add(ChunkFactory.tablenounderLine("", 21,
//                    simfang2312_z5));
//            phrase12.add(new Chunk("第", simfang2312_z5));
//            phrase12.add(ChunkFactory.tablenounderLine("", 21,
//                    simfang2312_z5));
//            phrase12.add(new Chunk("页", simfang2312_z5));

//            paragraph11.add(phrase12);

            document.add(paragraph11);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //打印电子签章到固定位置
    protected void printerFrameWorkPic(Object postmaskimage) {
        PdfContentByte canvas2 = dpfwPdfWriter.getDirectContent();
        // 电子签章
        Image img;
        if(postmaskimage instanceof PdfImageCopy){
            img = ImageBuilder.getInstance((PdfImageCopy)((PdfImageCopy) postmaskimage).getImage());
        }else{
            img = ImageBuilder.getInstance(postmaskimage);
        }

        if (img != null) {
            img.setAbsolutePosition(350, 140);
            try {
                canvas2.addImage(img);
            } catch (DocumentException e) {
                e.printStackTrace();
            }
        }
    }

    //打印电子签章到设定位置
    protected void printerFrameWorkPic(Object postmaskimage, int x, int y) {
        PdfContentByte canvas2 = dpfwPdfWriter.getDirectContent();
        // 电子签章
        Image img;
        if(postmaskimage instanceof PdfImageCopy){
            img = ImageBuilder.getInstance((PdfImageCopy)((PdfImageCopy) postmaskimage).getImage());
        }else{
            img = ImageBuilder.getInstance(postmaskimage);
        }
        if (img != null) {
            img.setAbsolutePosition(x, y);
            try {
                canvas2.addImage(img);
            } catch (DocumentException e) {
                e.printStackTrace();
            }
        }
    }

    //特殊标题样式
    protected void printerFrameWorkTitleSpecial(Base_Entity book, String title1text, String title2text, String title3text) {
        String one = book.getValue(0);
        String two = book.getValue(1);
        String three = book.getValue(2);
        String four = book.getValue(3);
        try {
            final Paragraph title = new ParagraphBuilder(city + title1text, simzhongsong_zx2);// Paragraph就是段落
            title.setLeading(90f);// 标题定值
            title.setAlignment(Element.ALIGN_CENTER);// 居中
            document.add(title);// 写入文档

            final Paragraph titleLine1 = new ParagraphBuilder(new Chunk(new LineSeparator()));// 加入一个换行
            titleLine1.setLeading(12f);
            document.add(titleLine1);
            final Paragraph titleLine2 = new ParagraphBuilder(new Chunk(new LineSeparator()));
            titleLine2.setLeading(2f);
            try {
                document.add(titleLine2);
            } catch (DocumentException e) {
                e.printStackTrace();
            }
            final Paragraph title2 = new ParagraphBuilder(title2text, simzhongsong_zx2);
            title2.setLeading(18f);
            title2.setAlignment(Element.ALIGN_CENTER);
            document.add(title2);

            final Paragraph title3 = new ParagraphBuilder("（" + one
                    + " ）" + title3text + "〔" + two + "〕" + three
                    + "号            签发人：" + four + "", simfang2312_zx3);
            title3.setLeading(30f);
//                title3.setAlignmentS(Element.ALIGN_CENTER);
            document.add(title3);


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //标题样式没有下面的字号 为续页服务
    protected void printerFrameWorkTitleNOCode(Base_Entity book, String title1text, String title2text, String title3text) {
        String one = book.getValue(0);
        String two = book.getValue(1);
        String three = book.getValue(2);
        try {
            final Paragraph title = new ParagraphBuilder(city + title1text, simzhongsong_zx2);// Paragraph就是段落
            title.setLeading(90f);// 标题定值
            title.setAlignment(Element.ALIGN_CENTER);// 居中
            document.add(title);// 写入文档
            if (title2text.equals("") && title3text.equals("")) {

            } else if (!title2text.equals("") && title3text.equals("") && !title1text.equals("")) {
                final Paragraph titleLine1 = new ParagraphBuilder(new Chunk(new LineSeparator()));// 加入一个换行
                titleLine1.setLeading(12f);
                document.add(titleLine1);
                final Paragraph titleLine2 = new ParagraphBuilder(new Chunk(new LineSeparator()));
                titleLine2.setLeading(2f);
                try {
                    document.add(titleLine2);
                } catch (DocumentException e) {
                    e.printStackTrace();
                }
                final Paragraph title2 = new ParagraphBuilder(title2text, simzhongsong_zx2);
                title2.setLeading(18f);
                title2.setAlignment(Element.ALIGN_CENTER);
                document.add(title2);
            } else if (!title2text.equals("") && title3text.equals("") && title1text.equals("")) {
                final Paragraph title2 = new ParagraphBuilder(title2text, simzhongsong_zx2);
                title2.setLeading(18f);
                title2.setAlignment(Element.ALIGN_CENTER);
                document.add(title2);
            } else {
                final Paragraph titleLine1 = new ParagraphBuilder(new Chunk(new LineSeparator()));// 加入一个换行
                titleLine1.setLeading(12f);
                document.add(titleLine1);
                final Paragraph titleLine2 = new ParagraphBuilder(new Chunk(new LineSeparator()));
                titleLine2.setLeading(2f);
                try {
                    document.add(titleLine2);
                } catch (DocumentException e) {
                    e.printStackTrace();
                }
                final Paragraph title2 = new ParagraphBuilder(title2text, simzhongsong_zx2);
                title2.setLeading(18f);
                title2.setAlignment(Element.ALIGN_CENTER);
                document.add(title2);

                final Paragraph title3 = new ParagraphBuilder("（" + one
                        + " ）" + title3text + "〔" + two + "〕" + three + (book.getExtraObj() != null ? "-" + book.getExtraObj() : "")
                        + "号", simfang2312_zx3);
                title3.setLeading(30f);
                title3.setAlignment(Element.ALIGN_CENTER);
//                document.add(title3);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //打印标题栏 字号
    protected void printerFrameWorkTitle(Base_Entity book, String title1text, String title2text, String title3text) {
        String one = book.getValue(0);
        String two = book.getValue(1);
        String three = book.getValue(2);
        try {
            final Paragraph title = new ParagraphBuilder(city + title1text, simzhongsong_zx2);// Paragraph就是段落
            title.setLeading(90f);// 标题定值
            title.setAlignment(Element.ALIGN_CENTER);// 居中
            document.add(title);// 写入文档
            if (title2text.equals("") && title3text.equals("")) {

            } else if (!title2text.equals("") && title3text.equals("") && !title1text.equals("")) {
                final Paragraph titleLine1 = new ParagraphBuilder(new Chunk(new LineSeparator()));// 加入一个换行
                titleLine1.setLeading(12f);
                document.add(titleLine1);
                final Paragraph titleLine2 = new ParagraphBuilder(new Chunk(new LineSeparator()));
                titleLine2.setLeading(2f);
                try {
                    document.add(titleLine2);
                } catch (DocumentException e) {
                    e.printStackTrace();
                }
                final Paragraph title2 = new ParagraphBuilder(title2text, simzhongsong_zx2);
                title2.setLeading(18f);
                title2.setAlignment(Element.ALIGN_CENTER);
                document.add(title2);
            } else if (!title2text.equals("") && title3text.equals("") && title1text.equals("")) {
                final Paragraph title2 = new ParagraphBuilder(title2text, simzhongsong_zx2);
                title2.setLeading(18f);
                title2.setAlignment(Element.ALIGN_CENTER);
                document.add(title2);
            } else {
                final Paragraph titleLine1 = new ParagraphBuilder(new Chunk(new LineSeparator()));// 加入一个换行
                titleLine1.setLeading(12f);
                document.add(titleLine1);
                final Paragraph titleLine2 = new ParagraphBuilder(new Chunk(new LineSeparator()));
                titleLine2.setLeading(2f);
                try {
                    document.add(titleLine2);
                } catch (DocumentException e) {
                    e.printStackTrace();
                }
                final Paragraph title2 = new ParagraphBuilder(title2text, simzhongsong_zx2);
                title2.setLeading(18f);
                title2.setAlignment(Element.ALIGN_CENTER);
                document.add(title2);

                final Paragraph title3 = new ParagraphBuilder("（" + one
                        + " ）" + title3text + "〔" + two + "〕" + three + (book.getExtraObj() != null&&!"".equals(book.getExtraObj()) ? "-" + book.getExtraObj() : "")
                        + "号", simfang2312_zx3);
                title3.setLeading(30f);
                title3.setAlignment(Element.ALIGN_CENTER);
                document.add(title3);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 打印的框架头
     *
     * @param book
     * @param postmaskimage
     * @param pdf_backframe
     */
    protected void printerFrameWork(Base_Entity book, Object postmaskimage, IPdfBackFrame pdf_backframe) {
        try {
            if (space1 == null) {
                space1 = new ParagraphBuilder("  ");
                space1.setLeading(1f);// 自定义空格
            }
            if (space2 == null) {
                space2 = new ParagraphBuilder("  ");
                space2.setLeading(5f);// 自定义空格
            }
            if (space3 == null) {
                space3 = new ParagraphBuilder("  ");
                space3.setLeading(10f);// 自定义空格
            }
            if (space4 == null) {
                space4 = new ParagraphBuilder("  ");
                space4.setLeading(20f);// 自定义空格
            }
            if (rect == null) {
                rect = new Rectangle(36, 54, 559, 788);
                rect.setBorderColor(BaseColor.BLACK);
            }
            pdf_backframe.writeContent();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 传统续页
     *
     * @param book
     * @param postmaskimage
     * @param pdf_back
     * @param newpagelength
     */
    protected void printerContinue(final Base_Entity book, final Object postmaskimage, final IPdfBack pdf_back, final int newpagelength) {
        printerFrameWork(book, postmaskimage, new IPdfBackFrame() {
            @Override
            public void writeContent() throws Exception {
                Paragraph title = new ParagraphBuilder("续页", simfang_zx4);// Paragraph就是段落
                title.setLeading(1f);// 段落距离
                // title.setSpacingBefore(25f);//段落留白
                title.setAlignment(Element.ALIGN_RIGHT);// 居中
                document.add(title);// 写入文档
                Paragraph titleLine1 = new ParagraphBuilder(new Chunk(new LineSeparator()));// 加入一个换行
                titleLine1.setLeading(1f);
                titleLine1.setSpacingBefore(5f);
                document.add(titleLine1);
                Paragraph titleLine2 = new ParagraphBuilder(new Chunk(new LineSeparator()));
                titleLine2.setLeading(1f);
                titleLine2.setSpacingBefore(1f);
                document.add(titleLine2);
                Paragraph paragraph5 = new ParagraphBuilder();
                paragraph5.setAlignment(Element.ALIGN_LEFT);
                paragraph5.setLeading(20f);
                Phrase phrase6 = new Phrase();
                String[] xuyearray=StringFactoryBuild.build().stringFormatIdentifyLnAndKeepLn(book.getValue("续页"),newpagelength,simfang2312_z5,0,-1);
                phrase6.add(ChunkFactory.tableunderLine(xuyearray[0], newpagelength, simfang2312_z5));
                //toMeasurefloat(phrase6);
                paragraph5.add(phrase6);
                document.add(paragraph5);
                if (pdf_back != null) {
                    pdf_back.writeEnd();
                }
                printerFrameWorkPic(postmaskimage);
                document.newPage();// 结束保存
                if(!"".equals(xuyearray[1])){
                    book.put("续页",xuyearray[1]);
                    printerContinue(book,postmaskimage,pdf_back,newpagelength);
                }
            }
        });

    }

    /**
     * 测试方法
     *
     * @param book
     * @param postmaskimage
     */
    public void printerTest(final Base_Entity book, final Object postmaskimage) {
        printerFrameWork(book, postmaskimage, new IPdfBackFrame() {
            @Override
            public void writeContent() throws Exception {
                //此处写页面布局
                Paragraph paragraph12 = new ParagraphBuilder();
                paragraph12.setLeading(simfang2312_z5.getSize() * 2f);
                Phrase phrase12 = new Phrase();
//                PdfFactoryLog.println(StringFactoryBuild.build().getStringLength(" ",simfang2312_z5));
                phrase12.add(ChunkFactory.nounderLine("", "承办人（签名）：", simfang2312_z5));
                paragraph12.add(phrase12);
                document.add(paragraph12);
                document.newPage();// 结束保存

            }
        });

    }

    //立案审批表
    protected void printerEntity_Book_2017_0(final Base_Entity book, final Object postmaskimage) {
        printerFrameWork(book, postmaskimage, new IPdfBackFrame() {
            @Override
            public void writeContent() throws Exception {
                //此处写页面布局
                book.push();
                book.push();
                book.push();
                printerFrameWorkTitle(book, "安全生产行政执法文书", "立案审批表", "安监立");
                document.add(space3);
                document.add(space2);
                Paragraph paragraph1 = new ParagraphBuilder();
                paragraph1.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph1.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase1 = new Phrase();
                phrase1.add(new Chunk("案由", simfang2312_z5));
                phrase1.add(ChunkFactory.underLine(book.push(), 346.5f, simfang2312_z5));
                paragraph1.add(phrase1);
                document.add(paragraph1);
                Paragraph paragraph2 = new ParagraphBuilder();
                paragraph2.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph2.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase2 = new Phrase();
                phrase2.add(new Chunk("案件来源", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.push(), 178.5f, simfang2312_z5));
                phrase2.add(new Chunk("时间", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.push(), 126.0f, simfang2312_z5));
                paragraph2.add(phrase2);
                document.add(paragraph2);
                Paragraph paragraph3 = new ParagraphBuilder();
                paragraph3.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph3.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase3 = new Phrase();
                phrase3.add(new Chunk("案件名称", simfang2312_z5));
                phrase3.add(ChunkFactory.underLine(book.push(), 325.5f, simfang2312_z5));
                paragraph3.add(phrase3);
                document.add(paragraph3);
                Paragraph paragraph4 = new ParagraphBuilder();
                paragraph4.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph4.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase4 = new Phrase();
                phrase4.add(new Chunk("当事人", simfang2312_z5));
                phrase4.add(ChunkFactory.underLine(book.push(), 189.0f, simfang2312_z5));
                phrase4.add(new Chunk("电话", simfang2312_z5));
                phrase4.add(ChunkFactory.underLine(book.push(), 126.0f, simfang2312_z5));
                paragraph4.add(phrase4);
                document.add(paragraph4);
                Paragraph paragraph5 = new ParagraphBuilder();
                paragraph5.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph5.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase5 = new Phrase();
                phrase5.add(new Chunk("法定代表人/负责人", simfang2312_z5));
                phrase5.add(ChunkFactory.underLine(book.push(), 278.25f, simfang2312_z5));
                paragraph5.add(phrase5);
                document.add(paragraph5);
                Paragraph paragraph6 = new ParagraphBuilder();
                paragraph6.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph6.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase6 = new Phrase();
                phrase6.add(new Chunk("当事人地址", simfang2312_z5));
                phrase6.add(ChunkFactory.underLine(book.push(), 168.0f, simfang2312_z5));
                phrase6.add(new Chunk("邮政编码", simfang2312_z5));
                phrase6.add(ChunkFactory.underLine(book.push(), 105.0f, simfang2312_z5));
                paragraph6.add(phrase6);
                document.add(paragraph6);
                document.add(space3);
                document.add(space3);
                PdfPTable table = null;
                float[] widths = new float[2];
                widths[0] = 1f;
                widths[1] = 1f;
                widths[0] = 4248.0f;
                widths[1] = 4248.0f;
                table = new PdfPTable(2);
                table.setWidthPercentage(100f);
                table.setWidths(widths);
                Paragraph paragraph7 = new ParagraphBuilder();
                paragraph7.setLeading(simfang2312_z5.getSize() * 1.5f);
                Phrase phrase7 = new Phrase();
                phrase7.add(new Chunk("案件基本情况：", simfang2312_z5));
                phrase7.add(ChunkFactory.tablenounderLine(book.push(), 1107.75f, simfang2312_z5, "案件基本情况：", "案件基本情况：妈妈经常批评我做事不讲效率但我却是“意见接受行动照旧”。所以总不见"));
                paragraph7.add(phrase7);
                PdfPCell cell_0 = new PdfPCellBuilder();
                cell_0.addElement(paragraph7);
                cell_0.setColspan(2);
                cell_0.setFixedHeight(87.27273f);
                table.addCell(cell_0);

                Paragraph paragraph10 = new ParagraphBuilder();
                paragraph10.setLeading(simfang2312_z5.getSize() * 1.5f);
                Phrase phrase10 = new Phrase();
                phrase10.add(new Chunk("承办人意见：", simfang2312_z5));
                phrase10.add(ChunkFactory.tablenounderLine(book.push(), 330.75f * 3.8f, simfang2312_z5,"承办人意见：","承办人意见：妈妈经常批评我做事不讲效率但我却是妈妈经常批评我做事不讲效率但我却是"));
                paragraph10.add(phrase10);
                Paragraph paragraph11 = new ParagraphBuilder();
                paragraph11.setLeading(simfang2312_z5.getSize() * 1.5f);
                Phrase phrase11 = new Phrase();
                phrase11.add(new Chunk("承办人（签名）：", simfang2312_z5));
                phrase11.add(ChunkFactory.underLine(book.push(), 52.5f, simfang2312_z5));
                phrase11.add(new Chunk("证号：\u00a0", simfang2312_z5));
                phrase11.add(ChunkFactory.underLine(book.push(), 52.5f, simfang2312_z5));
                phrase11.add(new Chunk("\u00a0", simfang2312_z5));
                paragraph11.add(phrase11);
                Paragraph paragraph12 = new ParagraphBuilder();
                paragraph12.setLeading(simfang2312_z5.getSize() * 2f);
                Phrase phrase12 = new Phrase();
                phrase12.add(ChunkFactory.nounderLine("", "承办人（签名）：", simfang2312_z5));
//                phrase12.add(new Chunk("\u00a0",simfang2312_z5));
                phrase12.add(ChunkFactory.underLine(book.push(), 52.5f, simfang2312_z5));
                phrase12.add(new Chunk("\u00a0", simfang2312_z5));
                phrase12.add(new Chunk("证号：\u00a0", simfang2312_z5));
                phrase12.add(ChunkFactory.underLine(book.push(), 52.5f, simfang2312_z5));
                phrase12.add(ChunkFactory.nounderLine("", 47.5f, simfang2312_z5));
                phrase12.add(ChunkFactory.nounderLine(book.pushneedcheck(), 0, 42.0f, simfang2312_z5));
                phrase12.add(new Chunk("年", simfang2312_z5));
                phrase12.add(ChunkFactory.nounderLine(book.pushneedcheck(), 1, 21.0f, simfang2312_z5));
                phrase12.add(new Chunk("月", simfang2312_z5));
                phrase12.add(ChunkFactory.nounderLine(book.push(true), 2, 21.0f, simfang2312_z5));
                phrase12.add(new Chunk("日", simfang2312_z5));
                paragraph12.add(phrase12);
                PdfPCell cell_1 = new PdfPCellBuilder();
                cell_1.addElement(paragraph10);
                cell_1.addElement(paragraph11);
                cell_1.addElement(paragraph12);
                cell_1.setColspan(2);
                cell_1.setFixedHeight(108.43434f);
                table.addCell(cell_1);




                Paragraph paragraph13 = new ParagraphBuilder();
//                paragraph13.setLeading(simfang2312_z5.getSize()*2f);
                Phrase phrase13 = new Phrase();
                phrase13.add(new Chunk("审核意见：", simfang2312_z5));
                phrase13.add(ChunkFactory.tablenounderLine(book.push(), 10.5f*50, simfang2312_z5, "审核意见：", "审核意见：妈妈经常批评我做事不讲效率但"));
                paragraph13.add(phrase13);
                Paragraph paragraph15 = new ParagraphBuilder();
//                paragraph15.setLeading(simfang2312_z5.getSize()*2f);
                Phrase phrase15 = new Phrase();
                phrase15.add(new Chunk("审核人（签名）：", simfang2312_z5));
                phrase15.add(ChunkFactory.tablenounderLine(book.push(), 110.25f, simfang2312_z5));
                paragraph15.add(phrase15);
                Paragraph paragraph16 = new ParagraphBuilder();
//                paragraph16.setLeading(simfang2312_z5.getSize()*2f);
                Phrase phrase16 = new Phrase();
                phrase16.add(ChunkFactory.nounderLine("", 80.25f, simfang2312_z5));
                phrase16.add(ChunkFactory.nounderLine(book.pushneedcheck(), 0, 42.0f, simfang2312_z5));
                phrase16.add(new Chunk("年", simfang2312_z5));
                phrase16.add(ChunkFactory.nounderLine(book.pushneedcheck(), 1, 21.0f, simfang2312_z5));
                phrase16.add(new Chunk("月", simfang2312_z5));
                phrase16.add(ChunkFactory.nounderLine(book.push(true), 2, 21.0f, simfang2312_z5));
                phrase16.add(new Chunk("日", simfang2312_z5));
                paragraph16.add(phrase16);
                PdfPCell cell_2 = new PdfPCellBuilder();
                cell_2.addElement(paragraph13);
//                cell_2.addElement(paragraph14);
                cell_2.addElement(paragraph15);
                cell_2.addElement(paragraph16);
                cell_2.setFixedHeight(94.89899f);
                table.addCell(cell_2);
                Paragraph paragraph17 = new ParagraphBuilder();
//                paragraph17.setLeading(simfang2312_z5.getSize()*2f);
                Phrase phrase17 = new Phrase();
                phrase17.add(new Chunk("审批意见：", simfang2312_z5));
                phrase17.add(ChunkFactory.tablenounderLine(book.push(), 10.5f*50, simfang2312_z5, "审批意见：", "审核意见：妈妈经常批评我做事不讲效率但"));
                paragraph17.add(phrase17);
                Paragraph paragraph19 = new ParagraphBuilder();
//                paragraph19.setLeading(simfang2312_z5.getSize()*2f);
                Phrase phrase19 = new Phrase();
                phrase19.add(new Chunk("审批人（签名）：", simfang2312_z5));
                phrase19.add(ChunkFactory.tablenounderLine(book.push(), 105.0f, simfang2312_z5));
                paragraph19.add(phrase19);
                Paragraph paragraph20 = new ParagraphBuilder();
//                paragraph20.setLeading(simfang2312_z5.getSize()*2f);
                Phrase phrase20 = new Phrase();
                phrase20.add(ChunkFactory.nounderLine("", 80.25f, simfang2312_z5));
                phrase20.add(ChunkFactory.nounderLine(book.pushneedcheck(), 0, 42.0f, simfang2312_z5));
                phrase20.add(new Chunk("年", simfang2312_z5));
                phrase20.add(ChunkFactory.nounderLine(book.pushneedcheck(), 1, 21.0f, simfang2312_z5));
                phrase20.add(new Chunk("月", simfang2312_z5));
                phrase20.add(ChunkFactory.nounderLine(book.push(true), 2, 21.0f, simfang2312_z5));
                phrase20.add(new Chunk("日", simfang2312_z5));
                paragraph20.add(phrase20);
                PdfPCell cell_3 = new PdfPCellBuilder();
                cell_3.addElement(paragraph17);
//                cell_3.addElement(paragraph18);
                cell_3.addElement(paragraph19);
                cell_3.addElement(paragraph20);
                cell_3.setFixedHeight(94.89899f);
                table.addCell(cell_3);




                document.add(table);
                printerFrameWorkPic(postmaskimage);
                document.newPage();// 结束保存
            }
        });

    }

    //现场检查方案
    protected void printerEntity_Book_2017_1(final Base_Entity book, final Object postmaskimage) {
        printerFrameWork(book, postmaskimage, new IPdfBackFrame() {
            @Override
            public void writeContent() throws Exception {
                //此处写页面布局
                book.push();
                book.push();
                book.push();
                printerFrameWorkTitle(book, "安全生产行政执法文书", "现场检查方案", "安监检查");
                document.add(space4);
                document.add(space4);
                PdfPTable table = null;
                float[] widths = new float[6];
                widths[0] = 136f;
                widths[1] = 231f;
                widths[2] = 54f;
                widths[3] = 85f;
                widths[4] = 34f;
                widths[5] = 200f;
                table = new PdfPTable(6);
                table.setWidthPercentage(100f);
                table.setWidths(widths);
                PdfPCell cell_0 = new PdfPCellBuilder(new ParagraphBuilder("被检查单位", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_0.setFixedHeight(32f);
                table.addCell(cell_0);
                PdfPCell cell_1 = new PdfPCellBuilder((new Phrase(ChunkFactory.nounderLine(book.push(), -1f, simfang2312_z5, 0, 335))));
                cell_1.setColspan(5);
                cell_1.setFixedHeight(32f);
                table.addCell(cell_1);
                PdfPCell cell_2 = new PdfPCellBuilder(new ParagraphBuilder("地址", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_2.setFixedHeight(32f);
                table.addCell(cell_2);
                PdfPCell cell_3 = new PdfPCellBuilder((new Phrase(ChunkFactory.nounderLine(book.push(), -1f, simfang2312_z5, 0, 335))));
                cell_3.setColspan(5);
                cell_3.setFixedHeight(32f);
                table.addCell(cell_3);
                PdfPCell cell_4 = new PdfPCellBuilder(new ParagraphBuilder("联系人", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_4.setFixedHeight(32f);
                table.addCell(cell_4);
                PdfPCell cell_5 = new PdfPCellBuilder((new Phrase(ChunkFactory.nounderLine(book.push(), -1f, simfang2312_z5))));
                cell_5.setColspan(2);
                cell_5.setFixedHeight(32f);
                table.addCell(cell_5);
                PdfPCell cell_6 = new PdfPCellBuilder(new ParagraphBuilder("所属行业", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_6.setColspan(2);
                cell_6.setFixedHeight(32f);
                table.addCell(cell_6);
                PdfPCell cell_7 = new PdfPCellBuilder(new Phrase(ChunkFactory.nounderLine(book.push(), -1f, simfang2312_z5)));
                cell_7.setFixedHeight(32f);
                table.addCell(cell_7);
                PdfPCell cell_8 = new PdfPCellBuilder(new ParagraphBuilder("检查时间", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_8.setFixedHeight(32f);
                table.addCell(cell_8);
                PdfPCell cell_9 = new PdfPCellBuilder(new Phrase(ChunkFactory.nounderLine(book.push(), -1f, simfang2312_z5, 0, 335)));
                cell_9.setColspan(5);
                cell_9.setFixedHeight(32f);
                table.addCell(cell_9);
                PdfPCell cell_10 = new PdfPCellBuilder(new ParagraphBuilder("行政执法人员", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_10.setFixedHeight(32f);
                table.addCell(cell_10);
                PdfPCell cell_11 = new PdfPCellBuilder(new Phrase(ChunkFactory.nounderLine(book.push(), -1f, simfang2312_z5)));
                cell_11.setColspan(5);
                cell_11.setFixedHeight(32f);
                table.addCell(cell_11);
                PdfPCell cell_12 = new PdfPCellBuilder(new ParagraphBuilder("检查内容", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_12.setFixedHeight(150f);
                table.addCell(cell_12);
                //6*400 2400
                String[] array = StringFactoryBuild.build().stringFormatIdentifyLnAndKeepLn(book.push(), 4800, simfang2312_z5, 0, 335);
                PdfPCell cell_13 = new PdfPCellBuilder(new Phrase(ChunkFactory.nounderLine(array[0], -1f, simfang2312_z5, 0, 335)));
                cell_13.setColspan(5);
                cell_13.setFixedHeight(150f);
                table.addCell(cell_13);
                PdfPCell cell_14 = new PdfPCellBuilder(new ParagraphBuilder("检查方式", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_14.setFixedHeight(48.18182f);
                table.addCell(cell_14);
                PdfPCell cell_15 = new PdfPCellBuilder(new Phrase(ChunkFactory.nounderLine(book.push(), -1f, simfang2312_z5, 0, 335)));
                cell_15.setColspan(5);
                cell_15.setFixedHeight(48.18182f);
                table.addCell(cell_15);
                PdfPCell cell_16 = new PdfPCellBuilder(new ParagraphBuilder("审核意见", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_16.setFixedHeight(77.323235f);
                table.addCell(cell_16);
                Paragraph paragraph13 = new ParagraphBuilder();
                paragraph13.setLeading(simfang2312_z5.getSize() * 1f);
                Phrase phrase13 = new Phrase();
                phrase13.add(ChunkFactory.tablenounderLine(book.push(), 115.5f * 4, simfang2312_z5, 0f, 115.5f));
                paragraph13.add(phrase13);
                Paragraph paragraph15 = new ParagraphBuilder();
//                paragraph15.setLeading(simfang2312_z5.getSize()*2f);
                Phrase phrase15 = new Phrase();
                phrase15.add(new Chunk("审核人（签名）：", simfang2312_z5));
                phrase15.add(ChunkFactory.tablenounderLine(book.push(), "测试人人", simfang2312_z5));
                paragraph15.add(phrase15);
                Paragraph paragraph16 = new ParagraphBuilder();
//                paragraph16.setLeading(simfang2312_z5.getSize()*2f);
                Phrase phrase16 = new Phrase();
                phrase16.add(ChunkFactory.nounderLine("", 10.0f, simfang2312_z5));
                phrase16.add(ChunkFactory.nounderLine(book.pushneedcheck(), 0, 42.0f, simfang2312_z5));
                phrase16.add(new Chunk("年", simfang2312_z5));
                phrase16.add(ChunkFactory.nounderLine(book.pushneedcheck(), 1, 21.0f, simfang2312_z5));
                phrase16.add(new Chunk("月", simfang2312_z5));
                phrase16.add(ChunkFactory.nounderLine(book.push(true), 2, 21.0f, simfang2312_z5));
                phrase16.add(new Chunk("日", simfang2312_z5));
                paragraph16.add(phrase16);
                PdfPCell cell_17 = new PdfPCellBuilder();
                cell_17.addElement(paragraph13);
//                cell_17.addElement(paragraph14);
                cell_17.addElement(paragraph15);
                cell_17.addElement(paragraph16);
                cell_17.setFixedHeight(77.323235f);
                table.addCell(cell_17);
                PdfPCell cell_18 = new PdfPCellBuilder(new ParagraphBuilder("审批意见", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_18.setColspan(2);
                cell_18.setFixedHeight(77.323235f);
                table.addCell(cell_18);
                Paragraph paragraph17 = new ParagraphBuilder();
                paragraph17.setLeading(simfang2312_z5.getSize() * 1f);
                Phrase phrase17 = new Phrase();
                phrase17.add(ChunkFactory.tablenounderLine(book.push(), 115.5f * 4, simfang2312_z5, 0f, 115.5f));
                paragraph17.add(phrase17);
                Paragraph paragraph19 = new ParagraphBuilder();
//                paragraph19.setLeading(simfang2312_z5.getSize()*2f);
                Phrase phrase19 = new Phrase();
                phrase19.add(new Chunk("审批人（签名）：", simfang2312_z5));
                phrase19.add(ChunkFactory.tablenounderLine(book.push(), "测试人人", simfang2312_z5));
                paragraph19.add(phrase19);
                Paragraph paragraph20 = new ParagraphBuilder();
//                paragraph20.setLeading(simfang2312_z5.getSize()*2f);
                Phrase phrase20 = new Phrase();
                phrase20.add(ChunkFactory.nounderLine("", 10.0f, simfang2312_z5));
                phrase20.add(ChunkFactory.nounderLine(book.pushneedcheck(), 0, 42.0f, simfang2312_z5));
                phrase20.add(new Chunk("年", simfang2312_z5));
                phrase20.add(ChunkFactory.nounderLine(book.pushneedcheck(), 1, 21.0f, simfang2312_z5));
                phrase20.add(new Chunk("月", simfang2312_z5));
                phrase20.add(ChunkFactory.nounderLine(book.push(true), 2, 21.0f, simfang2312_z5));
                phrase20.add(new Chunk("日", simfang2312_z5));
                paragraph20.add(phrase20);
                PdfPCell cell_19 = new PdfPCellBuilder();
                cell_19.addElement(paragraph17);
//                cell_19.addElement(paragraph18);
                cell_19.addElement(paragraph19);
                cell_19.addElement(paragraph20);
                cell_19.setColspan(2);
                cell_19.setFixedHeight(77.323235f);
                table.addCell(cell_19);
                PdfPCell cell_20 = new PdfPCellBuilder(new ParagraphBuilder("备注", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_20.setFixedHeight(61.464645f);
                table.addCell(cell_20);
                PdfPCell cell_21 = new PdfPCellBuilder(new Phrase(ChunkFactory.nounderLine(book.push(), -1f, simfang2312_z5, 0, 335)));
                cell_21.setColspan(5);
                cell_21.setFixedHeight(61.464645f);
                table.addCell(cell_21);
                document.add(table);
                printerFrameWorkPic(postmaskimage);
                document.newPage();// 结束保存
                if (!"".equals(array[1])) {
                    Base_Entity tmp = book.copy();
                    tmp.put("检查内容", array[1]);
                    printerEntity_Book_2017_1(tmp, postmaskimage);//打印第二页
                }
            }
        });

    }

    //现场检查记录
    protected void printerEntity_Book_2017_2(final Base_Entity book, final Object postmaskimage) {
        printerFrameWork(book, postmaskimage, new IPdfBackFrame() {
            @Override
            public void writeContent() throws Exception {
                //此处写页面布局
                book.push();
                book.push();
                book.push();
                printerFrameWorkTitle(book, "安全生产行政执法文书", "现场检查记录", "安监检记");
                Paragraph paragraph1 = new ParagraphBuilder();
                paragraph1.setLeading(simfang2312_z5.getSize() * 2f);
                Phrase phrase1 = new Phrase();
                phrase1.add(new Chunk("被检查单位", simfang2312_z5));
                phrase1.add(ChunkFactory.underLine(book.push(), 351.75f, simfang2312_z5));
                paragraph1.add(phrase1);
                document.add(paragraph1);
                Paragraph paragraph2 = new ParagraphBuilder();
                paragraph2.setLeading(simfang2312_z5.getSize() * 2f);
                Phrase phrase2 = new Phrase();
                phrase2.add(new Chunk("地址", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.push(), 378.0f, simfang2312_z5));
                paragraph2.add(phrase2);
                document.add(paragraph2);
                Paragraph paragraph3 = new ParagraphBuilder();
                paragraph3.setLeading(simfang2312_z5.getSize() * 2f);
                Phrase phrase3 = new Phrase();
                phrase3.add(new Chunk("法定代表人（负责人）", simfang2312_z5));
                phrase3.add(ChunkFactory.underLine(book.push(), 63.0f, simfang2312_z5));
                phrase3.add(new Chunk("职务", simfang2312_z5));
                phrase3.add(ChunkFactory.underLine(book.push(), 52.5f, simfang2312_z5));
                phrase3.add(new Chunk("联系电话", simfang2312_z5));
                phrase3.add(ChunkFactory.underLine(book.push(), 105.0f, simfang2312_z5));
                paragraph3.add(phrase3);
                document.add(paragraph3);
                Paragraph paragraph4 = new ParagraphBuilder();
                paragraph4.setLeading(simfang2312_z5.getSize() * 2f);
                Phrase phrase4 = new Phrase();
                phrase4.add(new Chunk("检查场所", simfang2312_z5));
                phrase4.add(ChunkFactory.underLine(book.push(), 357.0f, simfang2312_z5));
                paragraph4.add(phrase4);
                document.add(paragraph4);
                Paragraph paragraph5 = new ParagraphBuilder();
                paragraph5.setLeading(simfang2312_z5.getSize() * 2f);
                Phrase phrase5 = new Phrase();
                phrase5.add(new Chunk("检查时间", simfang2312_z5));
                phrase5.add(ChunkFactory.underLine(book.pushneedcheck(), 0, 57.75f, simfang2312_z5));
                phrase5.add(new Chunk("年", simfang2312_z5));
                phrase5.add(ChunkFactory.underLine(book.pushneedcheck(), 1, 21.0f, simfang2312_z5));
                phrase5.add(new Chunk("月", simfang2312_z5));
                phrase5.add(ChunkFactory.underLine(book.pushneedcheck(), 2, 21.0f, simfang2312_z5));
                phrase5.add(new Chunk("日", simfang2312_z5));
                phrase5.add(ChunkFactory.underLine(book.pushneedcheck(), 3, 15.75f, simfang2312_z5));
                phrase5.add(new Chunk("时", simfang2312_z5));
                phrase5.add(ChunkFactory.underLine(book.push(true), 4, 21.0f, simfang2312_z5));
                phrase5.add(new Chunk("分至", simfang2312_z5));
                phrase5.add(ChunkFactory.underLine(book.pushneedcheck(), 1, 21.0f, simfang2312_z5));
                phrase5.add(new Chunk("月", simfang2312_z5));
                phrase5.add(ChunkFactory.underLine(book.pushneedcheck(), 2, 15.75f, simfang2312_z5));
                phrase5.add(new Chunk("日", simfang2312_z5));
                phrase5.add(ChunkFactory.underLine(book.pushneedcheck(), 3, 15.75f, simfang2312_z5));
                phrase5.add(new Chunk("时", simfang2312_z5));
                phrase5.add(ChunkFactory.underLine(book.push(true), 4, 21.0f, simfang2312_z5));
                phrase5.add(new Chunk("分", simfang2312_z5));
                paragraph5.add(phrase5);
                document.add(paragraph5);
                Paragraph paragraph6 = new ParagraphBuilder();
                paragraph6.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph6.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase6 = new Phrase();
                phrase6.add(new Chunk("我们是", simfang2312_z5));
                phrase6.add(ChunkFactory.underLine(book.push(), 73.5f, simfang2312_z5));
                phrase6.add(new Chunk("安全生产监督管理局行政执法人员", simfang2312_z5));
                phrase6.add(ChunkFactory.underLine(book.push(), 57.75f, simfang2312_z5));
                phrase6.add(new Chunk("、", simfang2312_z5));
                phrase6.add(ChunkFactory.underLine(book.push(), 57.75f, simfang2312_z5));
                phrase6.add(new Chunk("\u00a0，\n", simfang2312_z5));
                phrase6.add(new Chunk("证件号码为", simfang2312_z5));
                phrase6.add(ChunkFactory.underLine(book.push(), 115.5f, simfang2312_z5));
                phrase6.add(new Chunk("、", simfang2312_z5));
                phrase6.add(ChunkFactory.underLine(book.push(), 115.5f, simfang2312_z5));
                phrase6.add(new Chunk("，这是我们的证件（出示证件\u00a0）\u00a0。", simfang2312_z5));
                phrase6.add(new Chunk("现依法对你单位进行现场检查，请予以配合。", simfang2312_z5));
                paragraph6.add(phrase6);
                document.add(paragraph6);
                Paragraph paragraph7 = new ParagraphBuilder();
                paragraph7.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph7.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase7 = new Phrase();
                String[] array = StringFactoryBuild.build().stringFormatIdentifyLnAndKeepLn(book.push(), 2688f, simfang2312_z5, 7 * simfang2312_z5.getSize(), -1);
                phrase7.add(new Chunk("检查情况：", simfang2312_z5));
                phrase7.add(ChunkFactory.underLine(array[0], 2688f, simfang2312_z5, 7 * simfang2312_z5.getSize(), -1));
                paragraph7.add(phrase7);
                document.add(paragraph7);
                final Paragraph paragraph14 = new ParagraphBuilder();
                paragraph14.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph14.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase14 = new Phrase();
                phrase14.add(new Chunk("检查人员（签名）：", simfang2312_z5));
                phrase14.add(ChunkFactory.underLine(book.push(), 76f, simfang2312_z5));
                phrase14.add(ChunkFactory.nounderLine("", 5.25f, simfang2312_z5));
                phrase14.add(ChunkFactory.underLine(book.push(), 76f, simfang2312_z5));
                paragraph14.add(phrase14);
                document.add(paragraph14);
                final Paragraph paragraph16 = new ParagraphBuilder();
                paragraph16.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph16.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase16 = new Phrase();
                phrase16.add(new Chunk("被检查单位现场负责人（签名）：", simfang2312_z5));
                phrase16.add(ChunkFactory.underLine(book.push(), 89.25f, simfang2312_z5));
                paragraph16.add(phrase16);
                document.add(paragraph16);
//                printerFrameWorkDate(book);
                printerFrameWorkDate(book.getValue("出表日期"));
                printerFrameWorkPic(postmaskimage);
                document.newPage();// 结束保存

                String str = array[1];
//                StringBuilder sb = new StringBuilder();
//                for (String s : array) {
//                    sb.append(s);
//                }
                book.put("续页", str);
                if (!book.getValue("续页").equals("")) {
                    printerContinue(book, postmaskimage, new IPdfBackAdapter() {
                        @Override
                        public void writeEnd() {
                            try {
                                document.add(paragraph14);
                                document.add(paragraph16);
                                printerFrameWorkDate(book.getValue("出表日期"));
                            } catch (DocumentException e) {
                                e.printStackTrace();
                            }
                        }
                    }, 11000);
                }
            }
        });

    }

    //现场处理措施决定书
    protected void printerEntity_Book_2017_3(final Base_Entity book, final Object postmaskimage) {
        printerFrameWork(book, postmaskimage, new IPdfBackFrame() {
            @Override
            public void writeContent() throws Exception {
                //此处写页面布局
                book.push();
                book.push();
                book.push();
                printerFrameWorkTitle(book, "安全生产行政执法文书", "现场处理措施决定书", "安监现决");
                Paragraph paragraph1 = new ParagraphBuilder();
                paragraph1.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph1.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase1 = new Phrase();
                phrase1.add(ChunkFactory.underLine(book.push(), 231.25f, simfang2312_z5));
                phrase1.add(new Chunk("：", simfang2312_z5));
                paragraph1.add(phrase1);
                document.add(paragraph1);
                Paragraph paragraph2 = new ParagraphBuilder();
                paragraph2.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph2.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase2 = new Phrase();
                phrase2.add(new Chunk("本机关于", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.pushneedcheck(), 0, 42.0f, simfang2312_z5));
                phrase2.add(new Chunk("年", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.pushneedcheck(), 1, 26.25f, simfang2312_z5));
                phrase2.add(new Chunk("月", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.push(true), 2, 21.0f, simfang2312_z5));
                phrase2.add(new Chunk("日现场检查时，发现你单位有下列违法违规行为和事故隐患：", simfang2312_z5));
                paragraph2.add(phrase2);
                document.add(paragraph2);
                Paragraph paragraph3 = new ParagraphBuilder();
                paragraph3.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph3.setFirstLineIndent(0);
                Phrase phrase3 = new Phrase();
                phrase3.add(new Chunk("", simfang2312_z5));
                book.push();
                String chuliyiju = "";
                String chuliyiju2 = "";

                String faxianyinhuan = "";
                String chulijueding = "";
                String faxianyinhuan2 = "";
                String chulijueding2 = "";
                String chuliyijuorg = book.getValue("处理依据");
                String[] array1 = StringFactoryBuild.build().stringFormatIdentifyLnAndKeepLn(book.getValue("发现隐患"), 1628f, simfang2312_z5, 0, -1);
                String[] array2 = StringFactoryBuild.build().stringFormatIdentifyLnAndKeepLn(book.getValue("处理决定"), 1628f, simfang2312_z5, 0, -1);
                int chuliyijuindextmp = 0;
                if (array1[0].equals("") || array2[0].equals("")) {
                    faxianyinhuan = array1[0];
                    faxianyinhuan2 = array1[1];
                    chulijueding = array2[0];
                    chulijueding2 = array2[1];
                    chuliyiju = "";
                    chuliyiju2 = "";
                } else {
                    if (array1[0].split("\n").length >= array2[0].split("\n").length) {
                        chulijueding = array2[0];
                        chulijueding2 = array2[1];
                        String[] tmp1 = array1[0].split("\n");
                        String[] tmp2 = array2[0].split("\n");
                        String[] tmp3 = chuliyijuorg.split(";");
                        chuliyijuindextmp = tmp2.length;
                        for (int i = 0; i < tmp2.length; i++) {
                            faxianyinhuan += tmp1[i] + "\n";
                        }
                        for (int i = tmp2.length; i < tmp1.length; i++) {
                            faxianyinhuan2 += tmp1[i] + "\n";
                        }
                        faxianyinhuan2 = faxianyinhuan2 + array1[1];
                    } else {
                        faxianyinhuan = array1[0];
                        faxianyinhuan2 = array1[1];
                        String[] tmp1 = array1[0].split("\n");
                        String[] tmp2 = array2[0].split("\n");
                        chuliyijuindextmp = tmp1.length;
                        for (int i = 0; i < tmp1.length; i++) {
                            chulijueding += tmp2[i] + "\n";
                        }
                        for (int i = tmp1.length; i < tmp2.length; i++) {
                            chulijueding2 += tmp2[i] + "\n";
                        }
                        chulijueding2 = chulijueding2 + array2[1];
                    }
                }
                String[] tmp3 = chuliyijuorg.split(";");
                for (int i = 0; i < chuliyijuindextmp; i++) {
                    chuliyiju += tmp3[i] + ";";
                }
                for (int i = chuliyijuindextmp; i < tmp3.length; i++) {
                    chuliyiju2 += tmp3[i] + ";";
                }

//                PdfFactoryLog.println("1:\n"+faxianyinhuan);
//                PdfFactoryLog.println("2:\n"+chulijueding);
//                PdfFactoryLog.println("3:\n"+faxianyinhuan2);
//                PdfFactoryLog.println("4:\n"+chulijueding2);

                phrase3.add(ChunkFactory.underLine(faxianyinhuan, 1628f, simfang2312_z5, 0, -1));
                paragraph3.add(phrase3);
                document.add(paragraph3);
//                Paragraph paragraph3 = new ParagraphBuilder();
//                paragraph3.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph3.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
//                Phrase phrase3 = new Phrase();
//                phrase3.add(new Chunk("1．", simfang2312_z5));
//                phrase3.add(ChunkFactory.underLine(book.pushloop(), 372.75f, simfang2312_z5));
//                phrase3.add(new Chunk("；", simfang2312_z5));
//                paragraph3.add(phrase3);
//                document.add(paragraph3);
//                Paragraph paragraph4 = new ParagraphBuilder();
//                paragraph4.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph4.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
//                Phrase phrase4 = new Phrase();
//                phrase4.add(new Chunk("2．", simfang2312_z5));
//                phrase4.add(ChunkFactory.underLine(book.pushloop(), 372.75f, simfang2312_z5));
//                phrase4.add(new Chunk("；", simfang2312_z5));
//                paragraph4.add(phrase4);
//                document.add(paragraph4);
//                Paragraph paragraph5 = new ParagraphBuilder();
//                paragraph5.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph5.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
//                Phrase phrase5 = new Phrase();
//                phrase5.add(new Chunk("3．", simfang2312_z5));
//                phrase5.add(ChunkFactory.underLine(book.push(), 262.5f, simfang2312_z5));
//                phrase5.add(new Chunk("。（此栏不够，可另附页）", simfang2312_z5));
//                paragraph5.add(phrase5);
//                document.add(paragraph5);
                Paragraph paragraph6 = new ParagraphBuilder();
                paragraph6.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph6.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase6 = new Phrase();
                phrase6.add(new Chunk("以上存在的问题无法保证安全生产，依据", simfang2312_z5));


                book.push();
                phrase6.add(ChunkFactory.underLine(chuliyiju, 420f, simfang2312_z5, 20 * simfang2312_z5.getSize(), -1));
                phrase6.add(new Chunk("的规定，现作出如下现场处理决定：", simfang2312_z5));
                paragraph6.add(phrase6);
                document.add(paragraph6);
                Paragraph paragraph8 = new ParagraphBuilder();
                paragraph8.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph8.setFirstLineIndent(0);
                Phrase phrase8 = new Phrase();
                phrase8.add(new Chunk("", simfang2312_z5));
                book.push();
                phrase8.add(ChunkFactory.underLine(chulijueding, 1628f, simfang2312_z5, 0, -1));
                paragraph8.add(phrase8);
                document.add(paragraph8);
//                Paragraph paragraph8 = new ParagraphBuilder();
//                paragraph8.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph8.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
//                Phrase phrase8 = new Phrase();
//                phrase8.add(new Chunk("1．", simfang2312_z5));
//                phrase8.add(ChunkFactory.underLine(book.pushloop(), 372.75f, simfang2312_z5));
//                phrase8.add(new Chunk("；", simfang2312_z5));
//                paragraph8.add(phrase8);
//                document.add(paragraph8);
//                Paragraph paragraph9 = new ParagraphBuilder();
//                paragraph9.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph9.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
//                Phrase phrase9 = new Phrase();
//                phrase9.add(new Chunk("2．", simfang2312_z5));
//                phrase9.add(ChunkFactory.underLine(book.pushloop(), 372.75f, simfang2312_z5));
//                phrase9.add(new Chunk("；", simfang2312_z5));
//                paragraph9.add(phrase9);
//                document.add(paragraph9);
//                Paragraph paragraph10 = new ParagraphBuilder();
//                paragraph10.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph10.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
//                Phrase phrase10 = new Phrase();
//                phrase10.add(new Chunk("3．", simfang2312_z5));
//                phrase10.add(ChunkFactory.underLine(book.push(), 262.5f, simfang2312_z5));
//                phrase10.add(new Chunk("。（此栏不够，可另附页）", simfang2312_z5));
//                paragraph10.add(phrase10);
//                document.add(paragraph10);
                Paragraph paragraph11 = new ParagraphBuilder();
                paragraph11.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph11.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase11 = new Phrase();
                phrase11.add(new Chunk("如果不服本决定，可以依法在60日内向", simfang2312_z5));
                phrase11.add(ChunkFactory.underLine(book.push(), 168.0f, simfang2312_z5));
                phrase11.add(new Chunk("人民政府或者", simfang2312_z5));
                phrase11.add(ChunkFactory.underLine(book.push(), 130.25f, simfang2312_z5));
                phrase11.add(new Chunk("申请行政复议，或者在6个月内依法向", simfang2312_z5));
                phrase11.add(ChunkFactory.underLine(book.push(), 89.25f, simfang2312_z5));
                phrase11.add(new Chunk("人民法院提起行政诉讼，但本决定不停止执行，法律另有规定的除外。", simfang2312_z5));
                paragraph11.add(phrase11);
                document.add(paragraph11);
                Paragraph paragraph12 = new ParagraphBuilder();
                paragraph12.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph12.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase12 = new Phrase();
                phrase12.add(new Chunk("安全生产监管行政执法人员（签名）：", simfang2312_z5));
                phrase12.add(ChunkFactory.underLine(book.push(), 89.25f, simfang2312_z5));
                phrase12.add(new Chunk("证号：", simfang2312_z5));
                phrase12.add(ChunkFactory.underLine(book.push(), 78.75f, simfang2312_z5));
                paragraph12.add(phrase12);
                document.add(paragraph12);
                Paragraph paragraph13 = new ParagraphBuilder();
                paragraph13.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph13.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase13 = new Phrase();
                phrase13.add(ChunkFactory.nounderLine("", 188.0f, simfang2312_z5));
                phrase13.add(ChunkFactory.underLine(book.push(), 84.0f, simfang2312_z5));
                phrase13.add(new Chunk("证号：", simfang2312_z5));
                phrase13.add(ChunkFactory.underLine(book.push(), 78.75f, simfang2312_z5));
                paragraph13.add(phrase13);
                document.add(paragraph13);
                Paragraph paragraph14 = new ParagraphBuilder();
                paragraph14.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph14.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase14 = new Phrase();
                phrase14.add(new Chunk("被检查单位负责人（签名）：", simfang2312_z5));
                phrase14.add(ChunkFactory.underLine(book.push(), 89.25f, simfang2312_z5));
                paragraph14.add(phrase14);
                document.add(paragraph14);
                printerFrameWorkG1(book);
                // 电子签章
                printerFrameWorkPic(postmaskimage);
                document.newPage();// 结束保存
                if (!"".equals(chulijueding2) || !"".equals(faxianyinhuan2)) {
                    Base_Entity extra = book.copy();
                    extra.put("发现隐患", faxianyinhuan2);
                    extra.put("处理决定", chulijueding2);
                    extra.put("处理依据", chuliyiju2);
                    printerEntity_Book_2017_3(extra, postmaskimage);

                }

            }
        });
    }

    //责令限期整改指令书
    protected void printerEntity_Book_2017_4(final Base_Entity book, final Object postmaskimage) {
        printerFrameWork(book, postmaskimage, new IPdfBackFrame() {
            @Override
            public void writeContent() throws Exception {
                //此处写页面布局
                book.push();
                book.push();
                book.push();
                printerFrameWorkTitle(book, "安全生产行政执法文书", "责令限期整改指令书", "安监责改");
                Paragraph paragraph1 = new ParagraphBuilder();
                paragraph1.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph1.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase1 = new Phrase();
                phrase1.add(ChunkFactory.underLine(book.push(), 173.25f, simfang2312_z5));
                phrase1.add(new Chunk("：", simfang2312_z5));
                paragraph1.add(phrase1);
                document.add(paragraph1);
                Paragraph paragraph2 = new ParagraphBuilder();
                paragraph2.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph2.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase2 = new Phrase();
                phrase2.add(new Chunk("经查，你单位存在下列问题：", simfang2312_z5));
                paragraph2.add(phrase2);
                document.add(paragraph2);
                Paragraph paragraph3 = new ParagraphBuilder();
                paragraph3.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph3.setFirstLineIndent(0);
                Phrase phrase3 = new Phrase();
                phrase3.add(new Chunk("", simfang2312_z5));
                book.push();
                String[] array = StringFactoryBuild.build().stringFormatIdentifyLnAndKeepLn(book.getValue("存在问题"), 1628f, simfang2312_z5, 0, -1);
                String findQuestion1 = array[0];
                String findQuestion2 = array[1];
                phrase3.add(ChunkFactory.underLine(findQuestion1, 1628f, simfang2312_z5, 0, -1));
                paragraph3.add(phrase3);
                document.add(paragraph3);
//                Paragraph paragraph3 = new ParagraphBuilder();
//                paragraph3.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph3.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
//                Phrase phrase3 = new Phrase();
//                phrase3.add(new Chunk("1．", simfang2312_z5));
//                phrase3.add(ChunkFactory.underLine(book.pushloop(), 388.5f, simfang2312_z5));
//                paragraph3.add(phrase3);
//                document.add(paragraph3);
//                Paragraph paragraph4 = new ParagraphBuilder();
//                paragraph4.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph4.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
//                Phrase phrase4 = new Phrase();
//                phrase4.add(new Chunk("2．", simfang2312_z5));
//                phrase4.add(ChunkFactory.underLine(book.pushloop(), 383.25f, simfang2312_z5));
//                paragraph4.add(phrase4);
//                document.add(paragraph4);
//                Paragraph paragraph5 = new ParagraphBuilder();
//                paragraph5.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph5.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
//                Phrase phrase5 = new Phrase();
//                phrase5.add(new Chunk("3．", simfang2312_z5));
//                phrase5.add(ChunkFactory.underLine(book.push(), 651f, simfang2312_z5, StringFactoryBuild.build().getStringLength("空格3．", simfang2312_z5), -1));
//                phrase5.add(new Chunk("（此栏不够，可另附页）。", simfang2312_z5));
//                paragraph5.add(phrase5);
//                document.add(paragraph5);
                Paragraph paragraph7 = new ParagraphBuilder();
                paragraph7.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph7.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase7 = new Phrase();
                phrase7.add(new Chunk("现责令你单位对上述第", simfang2312_z5));
                book.push();
                phrase7.add(ChunkFactory.underLine(array[2], 36.75f, simfang2312_z5));//手动判断第几项 要期限内
                phrase7.add(new Chunk("项问题于", simfang2312_z5));
                phrase7.add(ChunkFactory.underLine(book.pushneedcheck(), 0, 42.0f, simfang2312_z5));
                phrase7.add(new Chunk("年", simfang2312_z5));
                phrase7.add(ChunkFactory.underLine(book.pushneedcheck(), 1, 15.75f, simfang2312_z5));
                phrase7.add(new Chunk("月", simfang2312_z5));
                phrase7.add(ChunkFactory.underLine(book.push(true), 2, 15.75f, simfang2312_z5));
                phrase7.add(new Chunk("日前整改完毕，达到有关法律法规规章和标准规定的要求。由此造成事故的，依法追究有关人员的责任。", simfang2312_z5));
                paragraph7.add(phrase7);
                document.add(paragraph7);
                Paragraph paragraph8 = new ParagraphBuilder();
                paragraph8.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph8.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase8 = new Phrase();
                phrase8.add(new Chunk("整改期间，你单位应当采取措施，确保安全生产。对安全生产违法行为，将依法予以行政处罚。", simfang2312_z5));
                paragraph8.add(phrase8);
                document.add(paragraph8);
                Paragraph paragraph9 = new ParagraphBuilder();
                paragraph9.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph9.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase9 = new Phrase();
                phrase9.add(new Chunk("如果不服本指令，可以依法在60日内向", simfang2312_z5));
                phrase9.add(ChunkFactory.underLine(book.push(), 57.75f, simfang2312_z5));
                phrase9.add(new Chunk("人民政府或者", simfang2312_z5));
                phrase9.add(ChunkFactory.underLine(book.push(), 183.75f, simfang2312_z5, StringFactoryBuild.build().getStringLength("空格如果不服本指令，可以依法在60日内向人民政府或者", simfang2312_z5) + 57.75f, -1));
                phrase9.add(new Chunk("申请行政复议，或者在6个月内依法向", simfang2312_z5));
                phrase9.add(ChunkFactory.underLine(book.push(), 57.75f, simfang2312_z5));
                phrase9.add(new Chunk("人民法院提起行政诉讼，但本指令不停止执行，法律另有规定的除外。", simfang2312_z5));
                paragraph9.add(phrase9);
                document.add(paragraph9);
                Paragraph paragraph11 = new ParagraphBuilder();
                paragraph11.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph11.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase11 = new Phrase();
                phrase11.add(new Chunk("安全生产监管行政执法人员（签名）：", simfang2312_z5));
                phrase11.add(ChunkFactory.underLine(book.push(), 89.25f, simfang2312_z5));
                phrase11.add(new Chunk("证号：", simfang2312_z5));
                phrase11.add(ChunkFactory.underLine(book.push(), 57.75f, simfang2312_z5));
                paragraph11.add(phrase11);
                document.add(paragraph11);
                Paragraph paragraph12 = new ParagraphBuilder();
                paragraph12.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph12.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase12 = new Phrase();
                phrase12.add(ChunkFactory.nounderLine("", 180f, simfang2312_z5));
                phrase12.add(ChunkFactory.underLine(book.push(), 89.25f, simfang2312_z5));
                phrase12.add(new Chunk("证号：", simfang2312_z5));
                phrase12.add(ChunkFactory.underLine(book.push(), 57.75f, simfang2312_z5));
                paragraph12.add(phrase12);
                document.add(paragraph12);
                Paragraph paragraph13 = new ParagraphBuilder();
                paragraph13.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph13.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase13 = new Phrase();
                phrase13.add(new Chunk("被检查单位负责人（签名）：", simfang2312_z5));
                phrase13.add(ChunkFactory.underLine(book.push(), 89.25f, simfang2312_z5));
                paragraph13.add(phrase13);
                document.add(paragraph13);
                printerFrameWorkG1(book);
                // 电子签章
                printerFrameWorkPic(postmaskimage);
                document.newPage();// 结束保存

                if (!"".equals(findQuestion2)) {
                    Base_Entity extra = book.copy();
                    extra.put("存在问题", findQuestion2);
                    printerEntity_Book_2017_4(extra, postmaskimage);
                }
            }
        });

    }

    //整改复查意见书
    protected void printerEntity_Book_2017_5(final Base_Entity book, final Object postmaskimage) {
        printerFrameWork(book, postmaskimage, new IPdfBackFrame() {
            @Override
            public void writeContent() throws Exception {
                //此处写页面布局
                book.push();
                book.push();
                book.push();
                document.add(space2);
                document.add(space2);
                printerFrameWorkTitle(book, "安全生产行政执法文书", "整改复查意见书", "安监复查");
                Paragraph paragraph1 = new ParagraphBuilder();
                paragraph1.setLeading(simfang2312_z5.getSize() * 2.5f);
                paragraph1.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase1 = new Phrase();
                phrase1.add(ChunkFactory.underLine(book.push(), 152.25f, simfang2312_z5));
                phrase1.add(new Chunk("：", simfang2312_z5));
                paragraph1.add(phrase1);
                document.add(paragraph1);
                Paragraph paragraph2 = new ParagraphBuilder();
                paragraph2.setLeading(simfang2312_z5.getSize() * 2.5f);
                paragraph2.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase2 = new Phrase();
                phrase2.add(new Chunk("本机关于", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.pushneedcheck(), 0, 42.0f, simfang2312_z5));
                phrase2.add(new Chunk("年", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.pushneedcheck(), 1, 21.0f, simfang2312_z5));
                phrase2.add(new Chunk("月", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.push(true), 2, 21.0f, simfang2312_z5));
                phrase2.add(new Chunk("日作出了", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.push(), 211.0f, simfang2312_z5));
                phrase2.add(new Chunk("的决定[(", simfang2312_z5));
                phrase2.add(ChunkFactory.nounderLine(book.push(), 15.75f, simfang2312_z5));
                phrase2.add(new Chunk(")安监", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.push(), 21.0f, simfang2312_z5));
                phrase2.add(new Chunk("〔", simfang2312_z5));
                phrase2.add(ChunkFactory.nounderLine(book.push(), 30f, simfang2312_z5));
                phrase2.add(new Chunk("〕(", simfang2312_z5));
                phrase2.add(ChunkFactory.nounderLine(book.push(), 21f, simfang2312_z5));
                phrase2.add(new Chunk(")号],经对你单位整改情况进行复查，提出如下意见：\n", simfang2312_z5));
                book.push();
                String[] array = StringFactoryBuild.build().stringFormatIdentifyLnAndKeepLn(book.push(), 2040f, simfang2312_z5, 0, -1);
                String suggestion1 = array[0];
                String suggestion2 = array[1];
                phrase2.add(ChunkFactory.underLine(suggestion1, 2040f, simfang2312_z5));
                phrase2.add(new Chunk("。", simfang2312_z5));
                paragraph2.add(phrase2);
                document.add(paragraph2);
                Paragraph paragraph9 = new ParagraphBuilder();
                paragraph9.setLeading(simfang2312_z5.getSize() * 2.5f);
                paragraph9.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase9 = new Phrase();
                paragraph9.add(phrase9);
                document.add(paragraph9);
                document.add(space4);
                document.add(space4);
                Paragraph paragraph10 = new ParagraphBuilder();
                paragraph10.setLeading(simfang2312_z5.getSize() * 2.5f);
//                paragraph10.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase10 = new Phrase();
                phrase10.add(new Chunk("被复查单位负责人（签名）：", simfang2312_z5));
                phrase10.add(ChunkFactory.underLine(book.push(), 52.5f, simfang2312_z5));
                paragraph10.add(phrase10);
                document.add(paragraph10);
                Paragraph paragraph11 = new ParagraphBuilder();
                paragraph11.setLeading(simfang2312_z5.getSize() * 3f);
//                paragraph11.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase11 = new Phrase();
                phrase11.add(new Chunk("安全生产监管行政执法人员（签名）：", simfang2312_z5));
                phrase11.add(ChunkFactory.underLine(book.push(), 73.5f, simfang2312_z5));
                phrase11.add(new Chunk("证号：", simfang2312_z5));
                phrase11.add(ChunkFactory.underLine(book.push(), 57.75f, simfang2312_z5));
                paragraph11.add(phrase11);
                document.add(paragraph11);
                Paragraph paragraph12 = new ParagraphBuilder();
                paragraph12.setLeading(simfang2312_z5.getSize() * 2.5f);
//                paragraph12.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase12 = new Phrase();
                phrase12.add(ChunkFactory.nounderLine("", "安全生产监管行政执法人员（签名）：", simfang2312_z5));
                phrase12.add(ChunkFactory.underLine(book.push(), 73.5f, simfang2312_z5));
                phrase12.add(new Chunk("证号：", simfang2312_z5));
                phrase12.add(ChunkFactory.underLine(book.push(), 57.75f, simfang2312_z5));
                paragraph12.add(phrase12);
                document.add(paragraph12);
                document.add(space4);
                printerFrameWorkG1(book);
                // 电子签章
                printerFrameWorkPic(postmaskimage);
                document.newPage();// 结束保存

                if (!"".equals(suggestion2)) {
                    Base_Entity extra = book.copy();
                    extra.put("复查意见", suggestion2);
                    printerEntity_Book_2017_5(extra, postmaskimage);
                }
            }
        });

    }

    //行政强制审批表
    protected void printerEntity_Book_2017_6(final Base_Entity book, final Object postmaskimage) {
        printerFrameWork(book, postmaskimage, new IPdfBackFrame() {
            @Override
            public void writeContent() throws Exception {
                //此处写页面布局
                book.push();
                book.push();
                book.push();
                printerFrameWorkTitle(book, "安全生产行政执法文书", "行政强制审批表", "安监强审");
                document.add(space4);
                PdfPTable table = null;
                float[] widths = new float[6];
                widths[0] = 1f;
                widths[1] = 1f;
                widths[2] = 1f;
                widths[3] = 1f;
                widths[4] = 1f;
                widths[5] = 1f;
                widths[0] = 1668.0f;
                widths[1] = 1275.0f;
                widths[2] = 1418.0f;
                widths[3] = 1417.0f;
                widths[4] = 1418.0f;
                widths[5] = 1340.0f;
                table = new PdfPTable(6);
                table.setWidthPercentage(100f);
                table.setWidths(widths);
                PdfPCell cell_0 = new PdfPCellBuilder(new ParagraphBuilder("案件名称", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_0.setFixedHeight(37.626263f);
                table.addCell(cell_0);
                PdfPCell cell_1 = new PdfPCellBuilder((new Phrase(ChunkFactory.nounderLine(book.push(), -1f, simfang2312_z5, 0, 335))));
                cell_1.setColspan(5);
                cell_1.setFixedHeight(37.626263f);
                table.addCell(cell_1);
                PdfPCell cell_2 = new PdfPCellBuilder(new ParagraphBuilder("当事人", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_2.setRowspan(5);
                cell_2.setFixedHeight(32.575756f);
                table.addCell(cell_2);
                PdfPCell cell_3 = new PdfPCellBuilder(new ParagraphBuilder("公民", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_3.setRowspan(3);
                cell_3.setFixedHeight(32.575756f);
                table.addCell(cell_3);
                PdfPCell cell_4 = new PdfPCellBuilder(new ParagraphBuilder("姓名", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_4.setFixedHeight(32.575756f);
                table.addCell(cell_4);
                PdfPCell cell_5 = new PdfPCellBuilder((new Phrase(ChunkFactory.nounderLine(book.push(), -1f, simfang2312_z5, 0, 335))));
                cell_5.setFixedHeight(32.575756f);
                table.addCell(cell_5);
                PdfPCell cell_6 = new PdfPCellBuilder(new ParagraphBuilder("性别", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_6.setFixedHeight(32.575756f);
                table.addCell(cell_6);
                PdfPCell cell_7 = new PdfPCellBuilder((new Phrase(ChunkFactory.nounderLine(book.push(), -1f, simfang2312_z5, 0, 335))));
                cell_7.setFixedHeight(32.575756f);
                table.addCell(cell_7);
                PdfPCell cell_8 = new PdfPCellBuilder(new ParagraphBuilder("出生年月", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_8.setFixedHeight(32.575756f);
                table.addCell(cell_8);
                PdfPCell cell_9 = new PdfPCellBuilder((new Phrase(ChunkFactory.nounderLine(book.push(), -1f, simfang2312_z5, 0, 335))));
                cell_9.setFixedHeight(32.575756f);
                table.addCell(cell_9);
                PdfPCell cell_10 = new PdfPCellBuilder(new ParagraphBuilder("联系电话", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_10.setFixedHeight(32.575756f);
                table.addCell(cell_10);
                PdfPCell cell_11 = new PdfPCellBuilder((new Phrase(ChunkFactory.nounderLine(book.push(), -1f, simfang2312_z5, 0, 335))));
                cell_11.setFixedHeight(32.575756f);
                table.addCell(cell_11);
                PdfPCell cell_12 = new PdfPCellBuilder(new ParagraphBuilder("住址", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_12.setFixedHeight(32.575756f);
                table.addCell(cell_12);
                PdfPCell cell_13 = new PdfPCellBuilder((new Phrase(ChunkFactory.nounderLine(book.push(), -1f, simfang2312_z5, 0, 335))));
                cell_13.setColspan(3);
                cell_13.setFixedHeight(32.575756f);
                table.addCell(cell_13);
                PdfPCell cell_14 = new PdfPCellBuilder(new ParagraphBuilder("法人或者其他组织", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_14.setRowspan(2);
                cell_14.setFixedHeight(49.545456f);
                table.addCell(cell_14);
                PdfPCell cell_15 = new PdfPCellBuilder(new ParagraphBuilder("名称", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_15.setFixedHeight(49.545456f);
                table.addCell(cell_15);
                PdfPCell cell_16 = new PdfPCellBuilder((new Phrase(ChunkFactory.nounderLine(book.push(), -1f, simfang2312_z5, 0, 335))));
                cell_16.setFixedHeight(49.545456f);
                table.addCell(cell_16);
                PdfPCell cell_17 = new PdfPCellBuilder(new ParagraphBuilder("法定代表人或者负责人", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_17.setFixedHeight(49.545456f);
                table.addCell(cell_17);
                PdfPCell cell_18 = new PdfPCellBuilder((new Phrase(ChunkFactory.nounderLine(book.push(), -1f, simfang2312_z5, 0, 335))));
                cell_18.setFixedHeight(49.545456f);
                table.addCell(cell_18);
                PdfPCell cell_19 = new PdfPCellBuilder(new ParagraphBuilder("地址", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_19.setFixedHeight(32.575756f);
                table.addCell(cell_19);
                PdfPCell cell_20 = new PdfPCellBuilder((new Phrase(ChunkFactory.nounderLine(book.push(), -1f, simfang2312_z5, 0, 335))));
                cell_20.setFixedHeight(32.575756f);
                table.addCell(cell_20);
                PdfPCell cell_21 = new PdfPCellBuilder(new ParagraphBuilder("联系电话", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_21.setFixedHeight(32.575756f);
                table.addCell(cell_21);
                PdfPCell cell_22 = new PdfPCellBuilder((new Phrase(ChunkFactory.nounderLine(book.push(), -1f, simfang2312_z5, 0, 335))));
                cell_22.setFixedHeight(32.575756f);
                table.addCell(cell_22);
                PdfPCell cell_23 = new PdfPCellBuilder(new ParagraphBuilder("案件基本情况", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_23.setFixedHeight(41.464645f);
                table.addCell(cell_23);
                PdfPCell cell_24 = new PdfPCellBuilder((new Phrase(ChunkFactory.nounderLine(book.push(), -1f, simfang2312_z5, 0, 335))));
                cell_24.setColspan(5);
                cell_24.setFixedHeight(41.464645f);
                table.addCell(cell_24);
                PdfPCell cell_25 = new PdfPCellBuilder(new ParagraphBuilder("报请审批的行政强制事项及其理由、依据、种类及期限等", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_25.setFixedHeight(134.39394f);
                table.addCell(cell_25);
                Paragraph paragraph1 = new ParagraphBuilder();
                paragraph1.setLeading(simfang2312_z5.getSize() * 1.2f);
//                paragraph1.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase1 = new Phrase();
                phrase1.add(ChunkFactory.tablenounderLine(book.push(), StringFactoryBuild.build().getStringLength("                                                               ", simfang2312_z5) * 5, simfang2312_z5, 0, StringFactoryBuild.build().getStringLength("                                                               ", simfang2312_z5)));
                paragraph1.add(phrase1);
                Paragraph paragraph4 = new ParagraphBuilder();
                paragraph4.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph4.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase4 = new Phrase();
                phrase4.add(new Chunk("承办人（签名）:", simfang2312_z5));
                phrase4.add(ChunkFactory.tableunderLine(book.push(), 73.5f, simfang2312_z5));
                phrase4.add(new Chunk("证号：", simfang2312_z5));
                phrase4.add(ChunkFactory.tableunderLine(book.push(), 57.75f, simfang2312_z5));
                paragraph4.add(phrase4);
                Paragraph paragraph5 = new ParagraphBuilder();
                paragraph5.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph5.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase5 = new Phrase();
                phrase5.add(ChunkFactory.tablenounderLine("", "承办人（签名）:", simfang2312_z5));
                phrase5.add(ChunkFactory.tableunderLine(book.push(), 73.5f, simfang2312_z5));
                phrase5.add(new Chunk("证号：", simfang2312_z5));
                phrase5.add(ChunkFactory.tableunderLine(book.push(), 57.75f, simfang2312_z5));
                paragraph5.add(phrase5);
                Paragraph paragraph6 = new ParagraphBuilder();
                paragraph6.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph6.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase6 = new Phrase();
                phrase6.add(ChunkFactory.nounderLine("", 180f, simfang2312_z5));
                phrase6.add(ChunkFactory.underLine(book.pushneedcheck(), 0, 42f, simfang2312_z5));
                phrase6.add(new Chunk("年", simfang2312_z5));
                phrase6.add(ChunkFactory.underLine(book.pushneedcheck(), 1, 21f, simfang2312_z5));
                phrase6.add(new Chunk("月", simfang2312_z5));
                phrase6.add(ChunkFactory.underLine(book.push(true), 2, 21f, simfang2312_z5));
                phrase6.add(new Chunk("日", simfang2312_z5));
                paragraph6.add(phrase6);
                PdfPCell cell_26 = new PdfPCellBuilder();
                cell_26.addElement(paragraph1);
//                cell_26.addElement(paragraph2);
//                cell_26.addElement(paragraph3);
                cell_26.addElement(paragraph4);
                cell_26.addElement(paragraph5);
                cell_26.addElement(paragraph6);
                cell_26.setColspan(5);
                cell_26.setFixedHeight(134.39394f);
                table.addCell(cell_26);
                PdfPCell cell_27 = new PdfPCellBuilder(new ParagraphBuilder("审核意见", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_27.setFixedHeight(59.19192f);
                table.addCell(cell_27);
                Paragraph paragraph7 = new ParagraphBuilder();
                paragraph7.setLeading(simfang2312_z5.getSize() * 1.2f);
//                paragraph7.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase7 = new Phrase();
                phrase7.add(ChunkFactory.tablenounderLine(book.push(), StringFactoryBuild.build().getStringLength("                                                               ", simfang2312_z5) * 3, simfang2312_z5, 0, StringFactoryBuild.build().getStringLength("                                                               ", simfang2312_z5)));
//                phrase7.add(ChunkFactory.nounderLine("7678687686876",400f,simfang2312_z5));
                paragraph7.add(phrase7);
                Paragraph paragraph8 = new ParagraphBuilder();
                paragraph8.setLeading(simfang2312_z5.getSize() * 1.5f);
//                paragraph8.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase8 = new Phrase();
                phrase8.add(new Chunk("审核人（签名）：", simfang2312_z5));
                phrase8.add(ChunkFactory.nounderLine(book.push(), "人人人人测试人人", simfang2312_z5));
                phrase8.add(ChunkFactory.nounderLine("", "人人", simfang2312_z5));
                phrase8.add(ChunkFactory.underLine(book.pushneedcheck(), 0, 42f, simfang2312_z5));
                phrase8.add(new Chunk("年", simfang2312_z5));
                phrase8.add(ChunkFactory.underLine(book.pushneedcheck(), 1, 21f, simfang2312_z5));
                phrase8.add(new Chunk("月", simfang2312_z5));
                phrase8.add(ChunkFactory.underLine(book.push(true), 2, 21f, simfang2312_z5));
                phrase8.add(new Chunk("日", simfang2312_z5));
                paragraph8.add(phrase8);
                PdfPCell cell_28 = new PdfPCellBuilder();
                cell_28.addElement(paragraph7);
                cell_28.addElement(paragraph8);
                cell_28.setColspan(5);
                cell_28.setFixedHeight(59.19192f);
                table.addCell(cell_28);
                PdfPCell cell_29 = new PdfPCellBuilder(new ParagraphBuilder("审批意见", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_29.setFixedHeight(59.19192f);
                table.addCell(cell_29);
                Paragraph paragraph9 = new ParagraphBuilder();
                paragraph9.setLeading(simfang2312_z5.getSize() * 1.2f);
//                paragraph9.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase9 = new Phrase();
                phrase9.add(ChunkFactory.tablenounderLine(book.push(), StringFactoryBuild.build().getStringLength("                                                               ", simfang2312_z5) * 3, simfang2312_z5, 0, StringFactoryBuild.build().getStringLength("                                                               ", simfang2312_z5)));
//                phrase9.add(ChunkFactory.tableunderLine(book.push(),300f,simfang2312_z5,0,StringFactoryBuild.build().getStringLength("                                                                 ",simfang2312_z5)));
                paragraph9.add(phrase9);
                Paragraph paragraph10 = new ParagraphBuilder();
                paragraph10.setLeading(simfang2312_z5.getSize() * 1.5f);
//                paragraph10.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase10 = new Phrase();
                phrase10.add(new Chunk("审批人（签名）：", simfang2312_z5));
                phrase10.add(ChunkFactory.nounderLine(book.push(), "人人人人测试人人", simfang2312_z5));
                phrase10.add(ChunkFactory.nounderLine("", "人人", simfang2312_z5));
                phrase10.add(ChunkFactory.underLine(book.pushneedcheck(), 0, 42f, simfang2312_z5));
                phrase10.add(new Chunk("年", simfang2312_z5));
                phrase10.add(ChunkFactory.underLine(book.pushneedcheck(), 1, 21f, simfang2312_z5));
                phrase10.add(new Chunk("月", simfang2312_z5));
                phrase10.add(ChunkFactory.underLine(book.push(true), 2, 21f, simfang2312_z5));
                phrase10.add(new Chunk("日", simfang2312_z5));
                paragraph10.add(phrase10);
                PdfPCell cell_30 = new PdfPCellBuilder();
                cell_30.addElement(paragraph9);
                cell_30.addElement(paragraph10);
                cell_30.setColspan(5);
                cell_30.setFixedHeight(59.19192f);
                table.addCell(cell_30);
                document.add(table);
                printerFrameWorkPic(postmaskimage);
                document.newPage();// 结束保存
            }
        });

    }

    //查封扣押决定书
    protected void printerEntity_Book_2017_7(final Base_Entity book, final Object postmaskimage) {
        printerFrameWork(book, postmaskimage, new IPdfBackFrame() {
            @Override
            public void writeContent() throws Exception {
                //此处写页面布局
                book.push();
                book.push();
                book.push();
                printerFrameWorkTitle(book, "安全生产行政执法文书", "查封扣押决定书", "安监查扣");
                Paragraph paragraph1 = new ParagraphBuilder();
                paragraph1.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph1.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase1 = new Phrase();
                phrase1.add(ChunkFactory.underLine(book.push(), 141.75f, simfang2312_z5));
                phrase1.add(new Chunk("：", simfang2312_z5));
                paragraph1.add(phrase1);
                document.add(paragraph1);
                Paragraph paragraph2 = new ParagraphBuilder();
                paragraph2.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph2.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase2 = new Phrase();
                phrase2.add(new Chunk("本机关在现场检查时，发现你（单位）（现场）存在下列问题：", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.push(), 961.75f, simfang2312_z5, StringFactoryBuild.build().getStringLength("空格本机关在现场检查时，发现你（单位）（现场）存在下列问题：", simfang2312_z5), -1));
                paragraph2.add(phrase2);
                document.add(paragraph2);
                Paragraph paragraph5 = new ParagraphBuilder();
                paragraph5.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph5.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase5 = new Phrase();
                phrase5.add(new Chunk("以上存在的问题无法保障安全生产，依据", simfang2312_z5));
                phrase5.add(ChunkFactory.underLine(book.push(), 178.5f, simfang2312_z5));
                phrase5.add(new Chunk("，决定采取以下行政强制措施：", simfang2312_z5));
                phrase5.add(ChunkFactory.underLine(book.push(), 1159f, simfang2312_z5, StringFactoryBuild.build().getStringLength("采取以下行政强制措施：", simfang2312_z5), -1));
                paragraph5.add(phrase5);
                document.add(paragraph5);
                Paragraph paragraph8 = new ParagraphBuilder();
                paragraph8.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph8.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase8 = new Phrase();
                phrase8.add(new Chunk("实施以上行政强制措施的期限自", simfang2312_z5));
                phrase8.add(ChunkFactory.underLine(book.pushneedcheck(), 0, 26.25f, simfang2312_z5));
                phrase8.add(new Chunk("年", simfang2312_z5));
                phrase8.add(ChunkFactory.underLine(book.pushneedcheck(), 1, 15.75f, simfang2312_z5));
                phrase8.add(new Chunk("月", simfang2312_z5));
                phrase8.add(ChunkFactory.underLine(book.push(true), 2, 15.75f, simfang2312_z5));
                phrase8.add(new Chunk("日至", simfang2312_z5));
                phrase8.add(ChunkFactory.underLine(book.pushneedcheck(), 0, 26.25f, simfang2312_z5));
                phrase8.add(new Chunk("年", simfang2312_z5));
                phrase8.add(ChunkFactory.underLine(book.pushneedcheck(), 1, 15.75f, simfang2312_z5));
                phrase8.add(new Chunk("月", simfang2312_z5));
                phrase8.add(ChunkFactory.underLine(book.push(true), 2, 15.75f, simfang2312_z5));
                phrase8.add(new Chunk("日。查封扣押清单见附件。", simfang2312_z5));
                paragraph8.add(phrase8);
                document.add(paragraph8);
                Paragraph paragraph9 = new ParagraphBuilder();
                paragraph9.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph9.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase9 = new Phrase();
                phrase9.add(new Chunk("如果不服本决定，可以依法在60日内向", simfang2312_z5));
                phrase9.add(ChunkFactory.underLine(book.push(), 183.75f, simfang2312_z5));
                phrase9.add(new Chunk("人民政府", simfang2312_z5));
                phrase9.add(new Chunk("或者", simfang2312_z5));
                phrase9.add(ChunkFactory.underLine(book.push(), 231.0f, simfang2312_z5));
                phrase9.add(new Chunk("申请行政复议，或者在6个月内依法向", simfang2312_z5));
                phrase9.add(ChunkFactory.underLine(book.push(), 94.5f, simfang2312_z5));
                phrase9.add(new Chunk("人民法院提起行政诉讼，但本决定不停止执行，法律另有规定的除外。", simfang2312_z5));
                paragraph9.add(phrase9);
                document.add(paragraph9);
                Paragraph paragraph10 = new ParagraphBuilder();
                paragraph10.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph10.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase10 = new Phrase();
                phrase10.add(new Chunk("附件：《查封扣押（场所、设施、财物）清单》第", simfang2312_z5));
                phrase10.add(ChunkFactory.underLine(book.push(), 36.75f, simfang2312_z5));
                phrase10.add(new Chunk("号", simfang2312_z5));
                paragraph10.add(phrase10);
                document.add(paragraph10);
                printerFrameWorkG1(book);
                printerFrameWorkPic(postmaskimage);
                document.newPage();
            }
        });

    }

    //查封扣押（场所、设施、财物）清单
    protected void printerEntity_Book_2017_8(final Base_Entity book, final Object postmaskimage) {
        printerFrameWork(book, postmaskimage, new IPdfBackFrame() {
            @Override
            public void writeContent() throws Exception {
                //此处写页面布局
                book.push();
                book.push();
                printerFrameWorkTitle(book, "查封扣押（场所、设施、财物）清单", "", "");
                Paragraph paragraph0 = new ParagraphBuilder();
                paragraph0.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph0.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase0 = new Phrase();
                phrase0.add(ChunkFactory.nounderLine("", 350f, simfang2312_z5));
                phrase0.add(new Chunk("第", simfang2312_z5));
                phrase0.add(ChunkFactory.underLine(book.push(), 26.25f, simfang2312_z5));
                phrase0.add(new Chunk("号", simfang2312_z5));
                paragraph0.add(phrase0);
                document.add(paragraph0);
                document.add(space3);
                PdfPTable table = null;
                float[] widths = new float[6];
                widths[0] = 1f;
                widths[1] = 1f;
                widths[2] = 1f;
                widths[3] = 1f;
                widths[4] = 1f;
                widths[5] = 1f;
                widths[0] = 814.0f;
                widths[1] = 1418.0f;
                widths[2] = 3118.0f;
                widths[3] = 709.0f;
                widths[4] = 1701.0f;
                widths[5] = 762.0f;
                table = new PdfPTable(6);
                table.setWidthPercentage(100f);
                table.setWidths(widths);
                PdfPCell cell_0 = new PdfPCellBuilder(new ParagraphBuilder("编号", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_0.setFixedHeight(28.030304f);
                table.addCell(cell_0);
                PdfPCell cell_1 = new PdfPCellBuilder(new ParagraphBuilder("名称", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_1.setFixedHeight(28.030304f);
                table.addCell(cell_1);
                PdfPCell cell_2 = new PdfPCellBuilder(new ParagraphBuilder("规格（型号）或者地址", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_2.setFixedHeight(28.030304f);
                table.addCell(cell_2);
                PdfPCell cell_3 = new PdfPCellBuilder(new ParagraphBuilder("单位", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_3.setFixedHeight(28.030304f);
                table.addCell(cell_3);
                PdfPCell cell_4 = new PdfPCellBuilder(new ParagraphBuilder("数量或者面积", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_4.setFixedHeight(28.030304f);
                table.addCell(cell_4);
                PdfPCell cell_5 = new PdfPCellBuilder(new ParagraphBuilder("备注", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_5.setFixedHeight(28.030304f);
                table.addCell(cell_5);
                for (int i = 0; i < 10; i++) {
                    int j = 0;
                    PdfPCell cell_6 = new PdfPCellBuilder(new ParagraphBuilder(getListItemValue(book.pushneedcheck(), i, j++), simfang2312_z5));
                    cell_6.setFixedHeight(28.030304f);
                    table.addCell(cell_6);
                    PdfPCell cell_7 = new PdfPCellBuilder(new ParagraphBuilder(getListItemValue(book.pushneedcheck(), i, j++), simfang2312_z5));
                    cell_7.setFixedHeight(28.030304f);
                    table.addCell(cell_7);
                    PdfPCell cell_8 = new PdfPCellBuilder(new ParagraphBuilder(getListItemValue(book.pushneedcheck(), i, j++), simfang2312_z5));
                    cell_8.setFixedHeight(28.030304f);
                    table.addCell(cell_8);
                    PdfPCell cell_9 = new PdfPCellBuilder(new ParagraphBuilder(getListItemValue(book.pushneedcheck(), i, j++), simfang2312_z5));
                    cell_9.setFixedHeight(28.030304f);
                    table.addCell(cell_9);
                    PdfPCell cell_10 = new PdfPCellBuilder(new ParagraphBuilder(getListItemValue(book.pushneedcheck(), i, j++), simfang2312_z5));
                    cell_10.setFixedHeight(28.030304f);
                    table.addCell(cell_10);
                    PdfPCell cell_11 = new PdfPCellBuilder(new ParagraphBuilder(getListItemValue(book.pushneedcheck(), i, j++), simfang2312_z5));
                    cell_11.setFixedHeight(28.030304f);
                    table.addCell(cell_11);
                    j = 0;
                }
                book.push(true);
                document.add(table);
                Paragraph paragraph5 = new ParagraphBuilder();
                paragraph5.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph5.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase5 = new Phrase();
                phrase5.add(ChunkFactory.nounderLine("", 260f, simfang2312_z5));
                phrase5.add(new Chunk("（此页不够，可另附页）", simfang2312_z5));
                paragraph5.add(phrase5);
                document.add(paragraph5);

                Paragraph paragraph1 = new ParagraphBuilder();
                paragraph1.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph1.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase1 = new Phrase();
                phrase1.add(new Chunk("当事人（签名或者盖章）：", simfang2312_z5));
                phrase1.add(ChunkFactory.underLine(book.push(), 84f, simfang2312_z5));
                phrase1.add(ChunkFactory.nounderLine(book.pushneedcheck(), 0, 42f, simfang2312_z5));
                phrase1.add(new Chunk("年", simfang2312_z5));
                phrase1.add(ChunkFactory.nounderLine(book.pushneedcheck(), 1, 21f, simfang2312_z5));
                phrase1.add(new Chunk("月", simfang2312_z5));
                phrase1.add(ChunkFactory.nounderLine(book.push(true), 2, 21f, simfang2312_z5));
                phrase1.add(new Chunk("日", simfang2312_z5));
                paragraph1.add(phrase1);
                document.add(paragraph1);
                Paragraph paragraph2 = new ParagraphBuilder();
                paragraph2.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph2.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase2 = new Phrase();
                paragraph2.add(phrase2);
                document.add(paragraph2);
                Paragraph paragraph3 = new ParagraphBuilder();
                paragraph3.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph3.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase3 = new Phrase();
                phrase3.add(new Chunk("安全生产监管行政执法人员（签名", simfang2312_z5));
                phrase3.add(ChunkFactory.underLine("", 5.25f, simfang2312_z5));
                phrase3.add(new Chunk("）：", simfang2312_z5));
                phrase3.add(ChunkFactory.underLine(book.push(), 57.75f, simfang2312_z5));
                phrase3.add(new Chunk("证号：", simfang2312_z5));
                phrase3.add(ChunkFactory.underLine(book.push(), 70f, simfang2312_z5));
                phrase3.add(ChunkFactory.nounderLine(book.pushneedcheck(), 0, 21f, simfang2312_z5));
                phrase3.add(new Chunk("年", simfang2312_z5));
                phrase3.add(ChunkFactory.nounderLine(book.pushneedcheck(), 1, 10.5f, simfang2312_z5));
                phrase3.add(new Chunk("月", simfang2312_z5));
                phrase3.add(ChunkFactory.nounderLine(book.push(true), 2, 10.5f, simfang2312_z5));
                phrase3.add(new Chunk("日", simfang2312_z5));
                paragraph3.add(phrase3);
                document.add(paragraph3);
                Paragraph paragraph4 = new ParagraphBuilder();
                paragraph4.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph4.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase4 = new Phrase();
                phrase4.add(ChunkFactory.nounderLine("", 162.75f, simfang2312_z5));
                phrase4.add(ChunkFactory.underLine(book.push(), 57.75f, simfang2312_z5));
                phrase4.add(new Chunk("证号：", simfang2312_z5));
                phrase4.add(ChunkFactory.underLine(book.push(), 70f, simfang2312_z5));
                phrase4.add(ChunkFactory.nounderLine(book.pushneedcheck(), 0, 21f, simfang2312_z5));
                phrase4.add(new Chunk("年", simfang2312_z5));
                phrase4.add(ChunkFactory.nounderLine(book.pushneedcheck(), 1, 10.5f, simfang2312_z5));
                phrase4.add(new Chunk("月", simfang2312_z5));
                phrase4.add(ChunkFactory.nounderLine(book.push(true), 2, 10.5f, simfang2312_z5));
                phrase4.add(new Chunk("日", simfang2312_z5));
                paragraph4.add(phrase4);
                document.add(paragraph4);
                printerFrameWorkPic(postmaskimage);
                document.newPage();
            }
        });


    }

    //延长查封扣押期限决定书
    protected void printerEntity_Book_2017_9(final Base_Entity book, final Object postmaskimage) {
        printerFrameWork(book, postmaskimage, new IPdfBackFrame() {
            @Override
            public void writeContent() throws Exception {
                //此处写页面布局
                book.push();
                book.push();
                book.push();
                printerFrameWorkTitle(book, "安全生产行政执法文书", "延长查封扣押期限决定书", "安监查扣延期");
                Paragraph paragraph1 = new ParagraphBuilder();
                paragraph1.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph1.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase1 = new Phrase();
                phrase1.add(ChunkFactory.underLine(book.push(), 115.5f, simfang2312_z5));
                phrase1.add(new Chunk("：", simfang2312_z5));
                paragraph1.add(phrase1);
                document.add(paragraph1);
                Paragraph paragraph2 = new ParagraphBuilder();
                paragraph2.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph2.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase2 = new Phrase();
                phrase2.add(new Chunk("本机关于", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.pushneedcheck(), 0, 15.75f, simfang2312_z5));
                phrase2.add(new Chunk("年", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.pushneedcheck(), 1, 10.5f, simfang2312_z5));
                phrase2.add(new Chunk("月", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.push(true), 2, 10.5f, simfang2312_z5));
                phrase2.add(new Chunk("日根据《查封扣押决定书》［（", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.push(), 15.75f, simfang2312_z5));
                phrase2.add(new Chunk("）安监查扣〔", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.push(), 21.0f, simfang2312_z5));
                phrase2.add(new Chunk("〕", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.push(), 21.0f, simfang2312_z5));
                phrase2.add(new Chunk("号\u00a0］\n对你（单位）的", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.push(), 52.5f, simfang2312_z5));
                phrase2.add(new Chunk("作出了", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.push(), 31.5f, simfang2312_z5));
                phrase2.add(new Chunk("的行政强制措施。因", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.push(), 120.75f, simfang2312_z5));
                phrase2.add(new Chunk("，依据《中华人民共和国行政强制法》第二十五条的规定，决定将以上行政强制措施的期限延长至", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.pushneedcheck(), 0, 31.5f, simfang2312_z5));
                phrase2.add(new Chunk("年", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.pushneedcheck(), 1, 21.0f, simfang2312_z5));
                phrase2.add(new Chunk("月", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.push(true), 2, 15.75f, simfang2312_z5));
                phrase2.add(new Chunk("日。", simfang2312_z5));
                paragraph2.add(phrase2);
                document.add(paragraph2);
                Paragraph paragraph3 = new ParagraphBuilder();
                paragraph3.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph3.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase3 = new Phrase();
                phrase3.add(new Chunk("附件：《查封扣押（场所、设施、财物）清单》第", simfang2312_z5));
                phrase3.add(ChunkFactory.underLine(book.push(), 15.75f, simfang2312_z5));
                phrase3.add(new Chunk("号", simfang2312_z5));
                paragraph3.add(phrase3);
                document.add(paragraph3);
                Paragraph paragraph4 = new ParagraphBuilder();
                paragraph4.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph4.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase4 = new Phrase();
                phrase4.add(new Chunk("如果不服本决定，可以依法在60日内向", simfang2312_z5));
                phrase4.add(ChunkFactory.underLine(book.push(), 176.5f, simfang2312_z5));
                phrase4.add(new Chunk("人民政府或者", simfang2312_z5));
                phrase4.add(ChunkFactory.underLine(book.push(), 115.5f, simfang2312_z5));
                phrase4.add(new Chunk("申请行政复议，或者在6个月内依法向", simfang2312_z5));
                phrase4.add(ChunkFactory.underLine(book.push(), 42.0f, simfang2312_z5));
                phrase4.add(new Chunk("人民法院提起行政诉讼，但本决定不停止执行，法律另有规定的除外。", simfang2312_z5));
                paragraph4.add(phrase4);
                document.add(paragraph4);
                document.add(space4);
                document.add(space4);
                document.add(space4);
                document.add(space4);
                printerFrameWorkG1(book);
                printerFrameWorkPic(postmaskimage);
                document.newPage();

            }
        });

    }

    //查封扣押处理决定书
    protected void printerEntity_Book_2017_10(final Base_Entity book, final Object postmaskimage) {
        printerFrameWork(book, postmaskimage, new IPdfBackFrame() {
            @Override
            public void writeContent() throws Exception {
                //此处写页面布局
                book.push();
                book.push();
                book.push();
                printerFrameWorkTitle(book, "安全生产行政执法文书", "查封扣押处理决定书", "安监查扣处");
                Paragraph paragraph1 = new ParagraphBuilder();
                paragraph1.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph1.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase1 = new Phrase();
                phrase1.add(ChunkFactory.underLine(book.push(), 105.0f, simfang2312_z5));
                phrase1.add(new Chunk("：", simfang2312_z5));
                paragraph1.add(phrase1);
                document.add(paragraph1);
                Paragraph paragraph2 = new ParagraphBuilder();
                paragraph2.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph2.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase2 = new Phrase();
                phrase2.add(new Chunk("本机关于", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.pushneedcheck(), 0, 31.5f, simfang2312_z5));
                phrase2.add(new Chunk("年", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.pushneedcheck(), 1, 21.0f, simfang2312_z5));
                phrase2.add(new Chunk("月", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.push(true), 2, 21.0f, simfang2312_z5));
                phrase2.add(new Chunk("日根据《查封扣押决定书》［（", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.push(), 70f, simfang2312_z5));
                phrase2.add(new Chunk("）安监查扣〔", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.push(), 31.5f, simfang2312_z5));
                phrase2.add(new Chunk("〕", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.push(), 26.25f, simfang2312_z5));
                phrase2.add(new Chunk("号］，对你（单位）的", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.push(), 89.25f, simfang2312_z5));
                phrase2.add(new Chunk("作出了", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.push(), 118.25f, simfang2312_z5));
                paragraph2.add(phrase2);
                document.add(paragraph2);
                Paragraph paragraph3 = new ParagraphBuilder();
                paragraph3.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph3.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase3 = new Phrase();
                phrase3.add(new Chunk("的行政强制措施。依据", simfang2312_z5));
                phrase3.add(ChunkFactory.underLine(book.push(), 204.25f, simfang2312_z5));
                phrase3.add(new Chunk("的规定，现作出以下处理决定：", simfang2312_z5));
                phrase3.add(ChunkFactory.underLine(book.push(), 262.5f, simfang2312_z5));
                phrase3.add(new Chunk("。", simfang2312_z5));
                paragraph3.add(phrase3);
                document.add(paragraph3);
                Paragraph paragraph4 = new ParagraphBuilder();
                paragraph4.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph4.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase4 = new Phrase();
                phrase4.add(new Chunk("如果不服本决定，可以依法在60日内向", simfang2312_z5));
                phrase4.add(ChunkFactory.underLine(book.push(), 183.5f, simfang2312_z5));
                phrase4.add(new Chunk("人民政府或者", simfang2312_z5));
                phrase4.add(ChunkFactory.underLine(book.push(), 72.75f, simfang2312_z5));
                phrase4.add(new Chunk("申请行政复议，或者在6个月内依法向", simfang2312_z5));
                phrase4.add(ChunkFactory.underLine(book.push(), 72.75f, simfang2312_z5));
                phrase4.add(new Chunk("人民法院提起行政诉讼，但本决定不停止执行，法律另有规定的除外。", simfang2312_z5));
                paragraph4.add(phrase4);
                document.add(paragraph4);
                document.add(space4);
                document.add(space4);
                document.add(space4);
                document.add(space4);
                document.add(space4);
                printerFrameWorkG1(book);
                printerFrameWorkPic(postmaskimage);
                document.newPage();

            }
        });

    }

    //停止供电（供应民用爆炸物品）通知书
    protected void printerEntity_Book_2017_11(final Base_Entity book, final Object postmaskimage) {
        printerFrameWork(book, postmaskimage, new IPdfBackFrame() {
            @Override
            public void writeContent() throws Exception {
                book.push();
                book.push();
                book.push();
                printerFrameWorkTitle(book, "安全生产行政执法文书", "停止供电（供应民用爆炸物品）通知书", "安监停供通");
                Paragraph paragraph1 = new ParagraphBuilder();
                paragraph1.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph1.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase1 = new Phrase();
                phrase1.add(ChunkFactory.underLine(book.push(), 120.75f, simfang2312_z5));
                phrase1.add(new Chunk("：", simfang2312_z5));
                paragraph1.add(phrase1);
                document.add(paragraph1);
                Paragraph paragraph2 = new ParagraphBuilder();
                paragraph2.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph2.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase2 = new Phrase();
                phrase2.add(new Chunk("因", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.push(), 105.0f, simfang2312_z5));
                phrase2.add(new Chunk("存在重大生产安全事故隐患，本机关于", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.pushneedcheck(), 0, 26.25f, simfang2312_z5));
                phrase2.add(new Chunk("年", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.pushneedcheck(), 1, 21.0f, simfang2312_z5));
                phrase2.add(new Chunk("月", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.push(true), 2, 15.75f, simfang2312_z5));
                phrase2.add(new Chunk("日依法对该单位作出了", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.push(), 89.25f, simfang2312_z5));
                phrase2.add(new Chunk("的决定，该单位未执行以上决定，没有及时消除事故隐患，存在发生生产安全事故现实危险。为保障安全生产，依据《中华人民共和国安全生产法》第六十七条第一款的规定，本机关决定对该单位采取", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.push(), 73.5f, simfang2312_z5));
                phrase2.add(new Chunk("措施，强制其履行决定。请你单位于", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.pushneedcheck(), 0, 26.25f, simfang2312_z5));
                phrase2.add(new Chunk("年", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.pushneedcheck(), 1, 10.5f, simfang2312_z5));
                phrase2.add(new Chunk("月", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.pushneedcheck(), 2, 10.5f, simfang2312_z5));
                phrase2.add(new Chunk("日", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.pushneedcheck(), 3, 10.5f, simfang2312_z5));
                phrase2.add(new Chunk("时", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.push(true), 4, 10.5f, simfang2312_z5));
                phrase2.add(new Chunk("分对该单位", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.push(), 160.75f, simfang2312_z5));
                phrase2.add(new Chunk("，请给予配合。", simfang2312_z5));
                paragraph2.add(phrase2);
                document.add(paragraph2);
                Paragraph paragraph3 = new ParagraphBuilder();
                paragraph3.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph3.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase3 = new Phrase();
                phrase3.add(new Chunk("该单位依法履行行政决定、采取相应措施消除事故隐患的，本机关将及时通知你单位解除有关措施。", simfang2312_z5));
                paragraph3.add(phrase3);
                document.add(paragraph3);
                document.add(space4);
                document.add(space4);
                document.add(space4);
                document.add(space4);
                document.add(space4);
                printerFrameWorkG1(book);
                printerFrameWorkPic(postmaskimage);
                document.newPage();

            }
        });

    }

    //停止供电（供应民用爆炸物品）决定书
    protected void printerEntity_Book_2017_12(final Base_Entity book, final Object postmaskimage) {
        printerFrameWork(book, postmaskimage, new IPdfBackFrame() {
            @Override
            public void writeContent() throws Exception {
                book.push();
                book.push();
                book.push();
                printerFrameWorkTitle(book, "安全生产行政执法文书", "停止供电（供应民用爆炸物品）决定书", "安监停供决");
                Paragraph paragraph1 = new ParagraphBuilder();
                paragraph1.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph1.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase1 = new Phrase();
                phrase1.add(ChunkFactory.underLine(book.push(), 126.0f, simfang2312_z5));
                phrase1.add(new Chunk(":", simfang2312_z5));
                paragraph1.add(phrase1);
                document.add(paragraph1);
                Paragraph paragraph2 = new ParagraphBuilder();
                paragraph2.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph2.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase2 = new Phrase();
                phrase2.add(new Chunk("因你单位存在重大生产安全事故隐患，本机关于", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.pushneedcheck(), 0, 31.5f, simfang2312_z5));
                phrase2.add(new Chunk("年", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.pushneedcheck(), 1, 21.0f, simfang2312_z5));
                phrase2.add(new Chunk("月", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.push(true), 2, 15.75f, simfang2312_z5));
                phrase2.add(new Chunk("日依法对你单位作出了", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.push(), 215.25f, simfang2312_z5));
                phrase2.add(new Chunk("的决定，你单位未执行以上决定，没有及时消除事故隐患，存在发生生产安全事故现实危险。为保障安全生产，依据《中华人民共和国安全生产法》第六十七条第一款的规定，本机关决定自", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.pushneedcheck(), 0, 31.5f, simfang2312_z5));
                phrase2.add(new Chunk("年", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.pushneedcheck(), 1, 15.75f, simfang2312_z5));
                phrase2.add(new Chunk("月", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.pushneedcheck(), 2, 15.75f, simfang2312_z5));
                phrase2.add(new Chunk("日", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.pushneedcheck(), 3, 15.75f, simfang2312_z5));
                phrase2.add(new Chunk("时", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.push(true), 4, 15.75f, simfang2312_z5));
                phrase2.add(new Chunk("分起，对你单位采取", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.push(), 168.0f, simfang2312_z5));
                phrase2.add(new Chunk("措施，强制你单位履行决定。", simfang2312_z5));
                paragraph2.add(phrase2);
                document.add(paragraph2);
                Paragraph paragraph3 = new ParagraphBuilder();
                paragraph3.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph3.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase3 = new Phrase();
                phrase3.add(new Chunk("你单位依法履行行政决定、采取相应措施消除事故隐患的，本机关将及时通知有关单位解除上述有关措施。", simfang2312_z5));
                paragraph3.add(phrase3);
                document.add(paragraph3);
                Paragraph paragraph4 = new ParagraphBuilder();
                paragraph4.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph4.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase4 = new Phrase();
                phrase4.add(new Chunk("如果不服本决定，可以依法在60日内向", simfang2312_z5));
                phrase4.add(ChunkFactory.underLine(book.push(), 189.0f, simfang2312_z5));
                phrase4.add(new Chunk("人民政府或者", simfang2312_z5));
                phrase4.add(ChunkFactory.underLine(book.push(), 84.0f, simfang2312_z5));
                phrase4.add(new Chunk("申请行政复议，或者在6个月内依法向", simfang2312_z5));
                phrase4.add(ChunkFactory.underLine(book.push(), 89.25f, simfang2312_z5));
                phrase4.add(new Chunk("人民法院提起行政诉讼，但本决定不停止执行，法律另有规定的除外。", simfang2312_z5));
                paragraph4.add(phrase4);
                document.add(paragraph4);
                document.add(space4);
                document.add(space4);
                document.add(space4);
                document.add(space4);
                document.add(space4);
                printerFrameWorkG1(book);
                printerFrameWorkPic(postmaskimage);
                document.newPage();

            }
        });

    }

    //恢复供电（供应民用爆炸物品）通知书
    protected void printerEntity_Book_2017_13(final Base_Entity book, final Object postmaskimage) {
        printerFrameWork(book, postmaskimage, new IPdfBackFrame() {
            @Override
            public void writeContent() throws Exception {
                book.push();
                book.push();
                book.push();
                printerFrameWorkTitle(book, "安全生产行政执法文书", "恢复供电（供应民用爆炸物品）通知书", "安监恢复通");
                Paragraph paragraph1 = new ParagraphBuilder();
                paragraph1.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph1.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase1 = new Phrase();
                phrase1.add(ChunkFactory.underLine(book.push(), 115.5f, simfang2312_z5));
                phrase1.add(new Chunk("：", simfang2312_z5));
                paragraph1.add(phrase1);
                document.add(paragraph1);
                Paragraph paragraph2 = new ParagraphBuilder();
                paragraph2.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph2.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase2 = new Phrase();
                phrase2.add(new Chunk("本机关于", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.pushneedcheck(), 0, 31.5f, simfang2312_z5));
                phrase2.add(new Chunk("年", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.pushneedcheck(), 1, 15.75f, simfang2312_z5));
                phrase2.add(new Chunk("月", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.push(true), 2, 15.75f, simfang2312_z5));
                phrase2.add(new Chunk("日依法对", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.push(), 183.75f, simfang2312_z5));
                phrase2.add(new Chunk("作出了停止", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.push(), 94.5f, simfang2312_z5));
                phrase2.add(new Chunk("的措施，该单位已于", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.pushneedcheck(), 0, 26.25f, simfang2312_z5));
                phrase2.add(new Chunk("年", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.pushneedcheck(), 1, 15.75f, simfang2312_z5));
                phrase2.add(new Chunk("月", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.push(true), 2, 15.75f, simfang2312_z5));
                phrase2.add(new Chunk("日依法履行了相关行政决定、采取相应措施消除事故隐患，依据《中华人民共和国安全生产法》第六十七条第二款的规定，本机关决定对该单位解除", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.push(), 84.0f, simfang2312_z5));
                phrase2.add(new Chunk("措施。请你单位于", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.pushneedcheck(), 0, 26.25f, simfang2312_z5));
                phrase2.add(new Chunk("年", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.pushneedcheck(), 1, 15.75f, simfang2312_z5));
                phrase2.add(new Chunk("月", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.pushneedcheck(), 2, 15.75f, simfang2312_z5));
                phrase2.add(new Chunk("日", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.pushneedcheck(), 3, 15.75f, simfang2312_z5));
                phrase2.add(new Chunk("时", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.push(true), 4, 15.75f, simfang2312_z5));
                phrase2.add(new Chunk("分对该单位给予恢复", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.push(), 73.5f, simfang2312_z5));
                phrase2.add(new Chunk("，请给予配合。", simfang2312_z5));
                paragraph2.add(phrase2);
                document.add(paragraph2);
                document.add(space4);
                document.add(space4);
                document.add(space4);
                document.add(space4);
                document.add(space4);
                document.add(space4);
                document.add(space4);
                document.add(space4);
                document.add(space4);
                document.add(space4);
                printerFrameWorkG1(book);
                printerFrameWorkPic(postmaskimage);
                document.newPage();

            }
        });

    }

    //询问通知书
    protected void printerEntity_Book_2017_14(final Base_Entity book, final Object postmaskimage) {
        printerFrameWork(book, postmaskimage, new IPdfBackFrame() {
            @Override
            public void writeContent() throws Exception {
                book.push();
                book.push();
                book.push();
                printerFrameWorkTitle(book, "安全生产行政执法文书", "询问通知书", "安监询");
                Paragraph paragraph1 = new ParagraphBuilder();
                paragraph1.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph1.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase1 = new Phrase();
                phrase1.add(ChunkFactory.underLine(book.push(), 147.0f, simfang2312_z5));
                phrase1.add(new Chunk("：", simfang2312_z5));
                paragraph1.add(phrase1);
                document.add(paragraph1);
                Paragraph paragraph2 = new ParagraphBuilder();
                paragraph2.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph2.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase2 = new Phrase();
                phrase2.add(new Chunk("因", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.push(), 170.5f, simfang2312_z5));
                phrase2.add(new Chunk("，请你（单位）于", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.pushneedcheck(), 0, 26.25f, simfang2312_z5));
                phrase2.add(new Chunk("年", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.pushneedcheck(), 1, 21.0f, simfang2312_z5));
                phrase2.add(new Chunk("月", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.pushneedcheck(), 2, 21.0f, simfang2312_z5));
                phrase2.add(new Chunk("日", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.push(true), 3, 26.25f, simfang2312_z5));
                phrase2.add(new Chunk("时到", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.push(), 115.5f, simfang2312_z5));
                phrase2.add(new Chunk("接受询问调查，来时请携带下列证件材料（见打√处）：", simfang2312_z5));
                paragraph2.add(phrase2);
                document.add(paragraph2);
                Paragraph paragraph3 = new ParagraphBuilder();
                paragraph3.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph3.setFirstLineIndent(simfang2312_z5.getSize() * 3f);
                Phrase phrase3 = new Phrase();
                phrase3.add(new Chunk("身份证", simfang2312_z5));
                paragraph3.add(phrase3);
                document.add(paragraph3);
                Paragraph paragraph4 = new ParagraphBuilder();
                paragraph4.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph4.setFirstLineIndent(simfang2312_z5.getSize() * 3f);
                Phrase phrase4 = new Phrase();
                phrase4.add(new Chunk("营业执照", simfang2312_z5));
                paragraph4.add(phrase4);
                document.add(paragraph4);
                Paragraph paragraph5 = new ParagraphBuilder();
                paragraph5.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph5.setFirstLineIndent(simfang2312_z5.getSize() * 3f);
                Phrase phrase5 = new Phrase();
                phrase5.add(new Chunk("法定代表人身份证明或者委托书", simfang2312_z5));
                paragraph5.add(phrase5);
                document.add(paragraph5);

                book.push();
                RadioCheckField bt3 = new RadioCheckField(dpfwPdfWriter,
                        ChunkFactory.setCheckBoxArea(105, 532, 10), "Yes0c2ab59361cb418abf085838d5c88c57",
                        ChunkFactory.getCheck(book.getValue(7), 1));
                bt3.setCheckType(RadioCheckField.TYPE_CHECK);
                bt3.setBorderWidth(BaseField.BORDER_WIDTH_THIN);
                bt3.setBorderColor(BaseColor.BLACK);
                bt3.setChecked(true);
                PdfFormField ck3 = bt3.getCheckField();
                dpfwPdfWriter.addAnnotation(ck3);
                RadioCheckField bt4 = new RadioCheckField(dpfwPdfWriter,
                        ChunkFactory.setCheckBoxArea(105, 511, 10), "Yes41288ee94e92497ba3bc3ecb9544d5c9",
                        ChunkFactory.getCheck(book.getValue(7), 2));
                bt4.setCheckType(RadioCheckField.TYPE_CHECK);
                bt4.setBorderWidth(BaseField.BORDER_WIDTH_THIN);
                bt4.setBorderColor(BaseColor.BLACK);
                bt4.setChecked(true);
                PdfFormField ck4 = bt4.getCheckField();
                dpfwPdfWriter.addAnnotation(ck4);
                RadioCheckField bt5 = new RadioCheckField(dpfwPdfWriter,
                        ChunkFactory.setCheckBoxArea(105, 490, 10), "Yes0cd1dc556c5e4127b8e1f58fa51196cf",
                        ChunkFactory.getCheck(book.getValue(7), 3));
                bt5.setCheckType(RadioCheckField.TYPE_CHECK);
                bt5.setBorderWidth(BaseField.BORDER_WIDTH_THIN);
                bt5.setBorderColor(BaseColor.BLACK);
                bt5.setChecked(true);
                PdfFormField ck5 = bt5.getCheckField();
                dpfwPdfWriter.addAnnotation(ck5);
                RadioCheckField bt6 = new RadioCheckField(dpfwPdfWriter,
                        ChunkFactory.setCheckBoxArea(105, 471, 10), "Yesc409942fdeb34fb6ba427350cfcd0ead",
                        ChunkFactory.getCheck(book.getValue(7), 4));
                bt6.setCheckType(RadioCheckField.TYPE_CHECK);
                bt6.setBorderWidth(BaseField.BORDER_WIDTH_THIN);
                bt6.setBorderColor(BaseColor.BLACK);
                bt6.setChecked(true);
                PdfFormField ck6 = bt6.getCheckField();
                dpfwPdfWriter.addAnnotation(ck6);


                Paragraph paragraph6 = new ParagraphBuilder();
                paragraph6.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph6.setIndentationLeft(simfang2312_z5.getSize() * 2f);
                paragraph6.setFirstLineIndent(simfang2312_z5.getSize() * 1f);
                Phrase phrase6 = new Phrase();
                phrase6.add(ChunkFactory.underLine(book.push(), 1467.5f, simfang2312_z5, simfang2312_z5.getSize(), StringFactoryBuild.build().pagewidthorg - simfang2312_z5.getSize() * 3));
                paragraph6.add(phrase6);
                document.add(paragraph6);
//                Paragraph paragraph7 = new ParagraphBuilder();
//                paragraph7.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph7.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
//                Phrase phrase7 = new Phrase();
//                phrase7.add(ChunkFactory.underLine(book.push(), 378.0f, simfang2312_z5));
//                paragraph7.add(phrase7);
//                document.add(paragraph7);
//                Paragraph paragraph8 = new ParagraphBuilder();
//                paragraph8.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph8.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
//                Phrase phrase8 = new Phrase();
//                phrase8.add(ChunkFactory.underLine(book.push(), 378.0f, simfang2312_z5));
//                paragraph8.add(phrase8);
//                document.add(paragraph8);
//                Paragraph paragraph9 = new ParagraphBuilder();
//                paragraph9.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph9.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
//                Phrase phrase9 = new Phrase();
//                phrase9.add(ChunkFactory.underLine(book.push(), 378.0f, simfang2312_z5));
//                paragraph9.add(phrase9);
//                document.add(paragraph9);
                Paragraph paragraph10 = new ParagraphBuilder();
                paragraph10.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph10.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase10 = new Phrase();
                phrase10.add(new Chunk("如无法按时前来，请及时联系。", simfang2312_z5));
                paragraph10.add(phrase10);
                document.add(paragraph10);
                Paragraph paragraph11 = new ParagraphBuilder();
                paragraph11.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph11.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase11 = new Phrase();
                paragraph11.add(phrase11);
                document.add(paragraph11);
                Paragraph paragraph12 = new ParagraphBuilder();
                paragraph12.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph12.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase12 = new Phrase();
                phrase12.add(new Chunk("安全生产监督管理部门地址：", simfang2312_z5));
                phrase12.add(ChunkFactory.underLine(book.push(), 262.5f, simfang2312_z5));
                paragraph12.add(phrase12);
                document.add(paragraph12);
                Paragraph paragraph13 = new ParagraphBuilder();
                paragraph13.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph13.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase13 = new Phrase();
                phrase13.add(new Chunk("联系人：", simfang2312_z5));
                phrase13.add(ChunkFactory.underLine(book.push(), 89.25f, simfang2312_z5));
                phrase13.add(new Chunk("联系电话：", simfang2312_z5));
                phrase13.add(ChunkFactory.underLine(book.push(), 215.25f, simfang2312_z5));
                paragraph13.add(phrase13);
                document.add(paragraph13);
                printerFrameWorkG1(book);
                printerFrameWorkPic(postmaskimage);
                document.newPage();// 结束保存

            }
        });

    }

    //询问笔录
    protected void printerEntity_Book_2017_15(final Base_Entity book, final Object postmaskimage) {
        printerFrameWork(book, postmaskimage, new IPdfBackFrame() {
            @Override
            public void writeContent() throws Exception {
                //此处写页面布局
                book.push();
                book.push();
                book.push();
                printerFrameWorkTitle(book, "安全生产行政执法文书", "询问笔录", "");
                Paragraph paragraph1 = new ParagraphBuilder();
                paragraph1.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph1.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase1 = new Phrase();
                phrase1.add(new Chunk("询问时间", simfang2312_z5));
                phrase1.add(ChunkFactory.underLine(book.pushneedcheck(), 0, 31.5f, simfang2312_z5));
                phrase1.add(new Chunk("年", simfang2312_z5));
                phrase1.add(ChunkFactory.underLine(book.pushneedcheck(), 1, 15.75f, simfang2312_z5));
                phrase1.add(new Chunk("月", simfang2312_z5));
                phrase1.add(ChunkFactory.underLine(book.pushneedcheck(), 2, 10.5f, simfang2312_z5));
                phrase1.add(new Chunk("日", simfang2312_z5));
                phrase1.add(ChunkFactory.underLine(book.pushneedcheck(), 3, 10.5f, simfang2312_z5));
                phrase1.add(new Chunk("时", simfang2312_z5));
                phrase1.add(ChunkFactory.underLine(book.push(true), 4, 10.5f, simfang2312_z5));
                phrase1.add(new Chunk("分至", simfang2312_z5));
                phrase1.add(ChunkFactory.underLine(book.pushneedcheck(), 1, 15.75f, simfang2312_z5));
                phrase1.add(new Chunk("月", simfang2312_z5));
                phrase1.add(ChunkFactory.underLine(book.pushneedcheck(), 2, 10.5f, simfang2312_z5));
                phrase1.add(new Chunk("日", simfang2312_z5));
                phrase1.add(ChunkFactory.underLine(book.pushneedcheck(), 3, 10.5f, simfang2312_z5));
                phrase1.add(new Chunk("时", simfang2312_z5));
                phrase1.add(ChunkFactory.underLine(book.push(true), 4, 10.5f, simfang2312_z5));
                phrase1.add(new Chunk("分", simfang2312_z5));
                phrase1.add(ChunkFactory.nounderLine("", 68.25f, simfang2312_z5));
                phrase1.add(new Chunk("第", simfang2312_z5));
                phrase1.add(ChunkFactory.underLine(book.push(), 26.25f, simfang2312_z5));
                phrase1.add(new Chunk("次询问", simfang2312_z5));
                paragraph1.add(phrase1);
                document.add(paragraph1);
                Paragraph paragraph2 = new ParagraphBuilder();
                paragraph2.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph2.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase2 = new Phrase();
                phrase2.add(new Chunk("询问地点", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.push(), 378.0f, simfang2312_z5));
                paragraph2.add(phrase2);
                document.add(paragraph2);
                Paragraph paragraph3 = new ParagraphBuilder();
                paragraph3.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph3.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase3 = new Phrase();
                phrase3.add(new Chunk("被询问人姓名", simfang2312_z5));
                phrase3.add(ChunkFactory.underLine(book.push(), 105.0f, simfang2312_z5));
                phrase3.add(new Chunk("性别", simfang2312_z5));
                phrase3.add(ChunkFactory.underLine(book.push(), 26.25f, simfang2312_z5));
                phrase3.add(new Chunk("年龄", simfang2312_z5));
                phrase3.add(ChunkFactory.underLine(book.push(), 31.5f, simfang2312_z5));
                phrase3.add(new Chunk("身份证号", simfang2312_z5));
                phrase3.add(ChunkFactory.underLine(book.push(), 110.25f, simfang2312_z5));
                paragraph3.add(phrase3);
                document.add(paragraph3);
                Paragraph paragraph4 = new ParagraphBuilder();
                paragraph4.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph4.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase4 = new Phrase();
                phrase4.add(new Chunk("工作单位", simfang2312_z5));
                phrase4.add(ChunkFactory.underLine(book.push(), 278.25f, simfang2312_z5));
                phrase4.add(new Chunk("职务", simfang2312_z5));
                phrase4.add(ChunkFactory.underLine(book.push(), 68.25f, simfang2312_z5));
                paragraph4.add(phrase4);
                document.add(paragraph4);
                Paragraph paragraph5 = new ParagraphBuilder();
                paragraph5.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph5.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase5 = new Phrase();
                phrase5.add(new Chunk("住址", simfang2312_z5));
                phrase5.add(ChunkFactory.underLine(book.push(), 299.25f, simfang2312_z5));
                phrase5.add(new Chunk("电话", simfang2312_z5));
                phrase5.add(ChunkFactory.underLine(book.push(), 68.25f, simfang2312_z5));
                paragraph5.add(phrase5);
                document.add(paragraph5);
                Paragraph paragraph6 = new ParagraphBuilder();
                paragraph6.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph6.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase6 = new Phrase();
                phrase6.add(new Chunk("询问人", simfang2312_z5));
                phrase6.add(ChunkFactory.underLine(book.push(), 73.5f, simfang2312_z5));
                phrase6.add(new Chunk("单位及职务", simfang2312_z5));
                phrase6.add(ChunkFactory.underLine(book.push(), 262.5f, simfang2312_z5));
                paragraph6.add(phrase6);
                document.add(paragraph6);
                Paragraph paragraph7 = new ParagraphBuilder();
                paragraph7.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph7.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase7 = new Phrase();
                phrase7.add(new Chunk("记录人", simfang2312_z5));
                phrase7.add(ChunkFactory.underLine(book.push(), 73.5f, simfang2312_z5));
                phrase7.add(new Chunk("单位及职务", simfang2312_z5));
                phrase7.add(ChunkFactory.underLine(book.push(), 262.5f, simfang2312_z5));
                paragraph7.add(phrase7);
                document.add(paragraph7);
                Paragraph paragraph8 = new ParagraphBuilder();
                paragraph8.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph8.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase8 = new Phrase();
                phrase8.add(new Chunk("在场人", simfang2312_z5));
                phrase8.add(ChunkFactory.underLine(book.push(), 388.5f, simfang2312_z5));
                paragraph8.add(phrase8);
                document.add(paragraph8);
                Paragraph paragraph9 = new ParagraphBuilder();
                paragraph9.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph9.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase9 = new Phrase();
                phrase9.add(new Chunk("我们是", simfang2312_z5));
                phrase9.add(ChunkFactory.underLine(book.push(), 36.75f, simfang2312_z5));
                phrase9.add(new Chunk("安全生产监督管理局的行政执法人员", simfang2312_z5));
                phrase9.add(ChunkFactory.underLine(book.push(), 47.25f, simfang2312_z5));
                phrase9.add(new Chunk("、", simfang2312_z5));
                phrase9.add(ChunkFactory.underLine(book.push(), 47.25f, simfang2312_z5));
                phrase9.add(new Chunk("，证件号码为\n", simfang2312_z5));
                phrase9.add(ChunkFactory.underLine(book.push(), 77.75f, simfang2312_z5));
                phrase9.add(new Chunk("、", simfang2312_z5));
                phrase9.add(ChunkFactory.underLine(book.push(), 77.75f, simfang2312_z5));
                phrase9.add(new Chunk("，这是我们的证件（出示证件）。我们依法就", simfang2312_z5));
                phrase9.add(ChunkFactory.underLine(book.push(), StringFactoryBuild.build().getStringLength("                                                                              ", simfang2312_z5), simfang2312_z5, StringFactoryBuild.build().getStringLength("                               ，这是我们的证件（出示证件）。我们依", simfang2312_z5), -1));
                phrase9.add(new Chunk("的有关问题向您了解情况，您有如实回答问题的义务，也有陈述、申辩和申请回避的权利。您听清楚了吗？", simfang2312_z5));
                paragraph9.add(phrase9);
                document.add(paragraph9);
                Paragraph paragraph11 = new ParagraphBuilder();
                paragraph11.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph11.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase11 = new Phrase();
                phrase11.add(new Chunk("询问记录：", simfang2312_z5));
                String[] xunwenorgarray=StringFactoryBuild.build().stringFormatIdentifyLnAndKeepLn(book.push(),4108f,simfang2312_z5,StringFactoryBuild.build().getStringLength("空格询问记录：", simfang2312_z5),-1);
                phrase11.add(ChunkFactory.underLine(xunwenorgarray[0], 4108f, simfang2312_z5, StringFactoryBuild.build().getStringLength("空格询问记录：", simfang2312_z5), -1));
                paragraph11.add(phrase11);
                document.add(paragraph11);
                final Paragraph paragraph16 = new ParagraphBuilder();
                paragraph16.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph16.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                final Phrase phrase16 = new Phrase();
                phrase16.add(new Chunk("询问人（签名）：", simfang2312_z5));
                phrase16.add(ChunkFactory.nounderLine(book.push(), 141.75f, simfang2312_z5));
                phrase16.add(new Chunk("记录人（签名）：", simfang2312_z5));
                phrase16.add(ChunkFactory.nounderLine(book.push(), 68.25f, simfang2312_z5));
                paragraph16.add(phrase16);
                document.add(paragraph16);
                final Paragraph paragraph17 = new ParagraphBuilder();
                paragraph17.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph17.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase17 = new Phrase();
                paragraph17.add(phrase17);
                document.add(paragraph17);
                final Paragraph paragraph18 = new ParagraphBuilder();
                paragraph18.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph18.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase18 = new Phrase();
                phrase18.add(new Chunk("被询问人（签名）：", simfang2312_z5));
                phrase18.add(ChunkFactory.nounderLine(book.push(), 68.25f, simfang2312_z5));
                paragraph18.add(phrase18);
                document.add(paragraph18);
                printerFrameWorkG4(book);
                printerFrameWorkPic(postmaskimage);
                document.newPage();// 结束保存
                String str = xunwenorgarray[1];
//                StringBuilder sb = new StringBuilder();
//                for (String s : array) {
//                    sb.append(s);
//                }
                book.put("续页", str);
                if (!book.getValue("续页").equals("")) {
                    printerContinue(book, postmaskimage, new IPdfBackAdapter() {

                        @Override
                        public void writeEnd() {
                            try {
                                document.add(paragraph16);
                                document.add(paragraph17);
                                document.add(paragraph18);
                                printerFrameWorkDate(book.getValue("出表日期"));
                            } catch (DocumentException e) {
                                e.printStackTrace();
                            }
                        }
                    }, 11000);
                }
            }
        });

    }

    //勘验笔录
    protected void printerEntity_Book_2017_16(final Base_Entity book, final Object postmaskimage) {
        printerFrameWork(book, postmaskimage, new IPdfBackFrame() {
            @Override
            public void writeContent() throws Exception {
                //此处写页面布局
                book.push();
                book.push();
                book.push();
                printerFrameWorkTitle(book, "安全生产行政执法文书", "勘验笔录", "安监勘");
                Paragraph paragraph1 = new ParagraphBuilder();
                paragraph1.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph1.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase1 = new Phrase();
                phrase1.add(new Chunk("勘验时间", simfang2312_z5));
                phrase1.add(ChunkFactory.underLine(book.pushneedcheck(), 0, 36.75f, simfang2312_z5));
                phrase1.add(new Chunk("年", simfang2312_z5));
                phrase1.add(ChunkFactory.underLine(book.pushneedcheck(), 1, 21.0f, simfang2312_z5));
                phrase1.add(new Chunk("月", simfang2312_z5));
                phrase1.add(ChunkFactory.underLine(book.pushneedcheck(), 2, 21.0f, simfang2312_z5));
                phrase1.add(new Chunk("日", simfang2312_z5));
                phrase1.add(ChunkFactory.underLine(book.pushneedcheck(), 3, 21.0f, simfang2312_z5));
                phrase1.add(new Chunk("时", simfang2312_z5));
                phrase1.add(ChunkFactory.underLine(book.push(true), 4, 21.0f, simfang2312_z5));
                phrase1.add(new Chunk("分至", simfang2312_z5));
                phrase1.add(ChunkFactory.underLine(book.pushneedcheck(), 1, 21.0f, simfang2312_z5));
                phrase1.add(new Chunk("月", simfang2312_z5));
                phrase1.add(ChunkFactory.underLine(book.pushneedcheck(), 2, 21.0f, simfang2312_z5));
                phrase1.add(new Chunk("日", simfang2312_z5));
                phrase1.add(ChunkFactory.underLine(book.pushneedcheck(), 3, 21.0f, simfang2312_z5));
                phrase1.add(new Chunk("时", simfang2312_z5));
                phrase1.add(ChunkFactory.underLine(book.push(true), 4, 26.25f, simfang2312_z5));
                phrase1.add(new Chunk("分", simfang2312_z5));
//                phrase1.add(ChunkFactory.underLine("", 0.0f, simfang2312_z5));
                paragraph1.add(phrase1);
                document.add(paragraph1);
                Paragraph paragraph2 = new ParagraphBuilder();
                paragraph2.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph2.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase2 = new Phrase();
                phrase2.add(new Chunk("勘验场所", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.push(), 220.5f, simfang2312_z5));
                phrase2.add(new Chunk("天气情况", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.push(), 115.5f, simfang2312_z5));
                paragraph2.add(phrase2);
                document.add(paragraph2);
                Paragraph paragraph3 = new ParagraphBuilder();
                paragraph3.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph3.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase3 = new Phrase();
                phrase3.add(new Chunk("勘验人", simfang2312_z5));
                phrase3.add(ChunkFactory.underLine(book.push(), 115.5f, simfang2312_z5));
                phrase3.add(new Chunk("单位及职务", simfang2312_z5));
                phrase3.add(ChunkFactory.underLine(book.push(), 215.25f, simfang2312_z5));
                paragraph3.add(phrase3);
                document.add(paragraph3);
                Paragraph paragraph4 = new ParagraphBuilder();
                paragraph4.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph4.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase4 = new Phrase();
                phrase4.add(new Chunk("勘验人", simfang2312_z5));
                phrase4.add(ChunkFactory.underLine(book.push(), 115.5f, simfang2312_z5));
                phrase4.add(new Chunk("单位及职务", simfang2312_z5));
                phrase4.add(ChunkFactory.underLine(book.push(), 215.25f, simfang2312_z5));
                paragraph4.add(phrase4);
                document.add(paragraph4);
                Paragraph paragraph5 = new ParagraphBuilder();
                paragraph5.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph5.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase5 = new Phrase();
                phrase5.add(new Chunk("当事人", simfang2312_z5));
                phrase5.add(ChunkFactory.underLine(book.push(), 115.5f, simfang2312_z5));
                phrase5.add(new Chunk("单位及职务", simfang2312_z5));
                phrase5.add(ChunkFactory.underLine(book.push(), 215.25f, simfang2312_z5));
                paragraph5.add(phrase5);
                document.add(paragraph5);
                Paragraph paragraph6 = new ParagraphBuilder();
                paragraph6.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph6.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase6 = new Phrase();
                phrase6.add(new Chunk("当事人", simfang2312_z5));
                phrase6.add(ChunkFactory.underLine(book.push(), 115.5f, simfang2312_z5));
                phrase6.add(new Chunk("单位及职务", simfang2312_z5));
                phrase6.add(ChunkFactory.underLine(book.push(), 215.25f, simfang2312_z5));
                paragraph6.add(phrase6);
                document.add(paragraph6);
                Paragraph paragraph7 = new ParagraphBuilder();
                paragraph7.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph7.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase7 = new Phrase();
                phrase7.add(new Chunk("被邀请人", simfang2312_z5));
                phrase7.add(ChunkFactory.underLine(book.push(), 105.0f, simfang2312_z5));
                phrase7.add(new Chunk("单位及职务", simfang2312_z5));
                phrase7.add(ChunkFactory.underLine(book.push(), 215.25f, simfang2312_z5));
                paragraph7.add(phrase7);
                document.add(paragraph7);
                Paragraph paragraph8 = new ParagraphBuilder();
                paragraph8.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph8.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase8 = new Phrase();
                phrase8.add(new Chunk("记录人", simfang2312_z5));
                phrase8.add(ChunkFactory.underLine(book.push(), 115.5f, simfang2312_z5));
                phrase8.add(new Chunk("单位及职务", simfang2312_z5));
                phrase8.add(ChunkFactory.underLine(book.push(), 215.25f, simfang2312_z5));
                paragraph8.add(phrase8);
                document.add(paragraph8);
                Paragraph paragraph9 = new ParagraphBuilder();
                paragraph9.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph9.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase9 = new Phrase();
                phrase9.add(new Chunk("我们是", simfang2312_z5));
                phrase9.add(ChunkFactory.underLine(book.push(), 36.75f, simfang2312_z5));
                phrase9.add(new Chunk("安全生产监督管理局的行政执法人员", simfang2312_z5));
                phrase9.add(ChunkFactory.underLine(book.push(), 47.25f, simfang2312_z5));
                phrase9.add(new Chunk("、", simfang2312_z5));
                phrase9.add(ChunkFactory.underLine(book.push(), 52.5f, simfang2312_z5));
                phrase9.add(new Chunk("，证件号码为", simfang2312_z5));
                phrase9.add(ChunkFactory.underLine(book.push(), 57.75f, simfang2312_z5));
                phrase9.add(new Chunk("、", simfang2312_z5));
                phrase9.add(ChunkFactory.underLine(book.push(), 57.75f, simfang2312_z5));
                phrase9.add(new Chunk("，这是我们的证件（出示证件）。现依法进行勘验检查，请予以配合。", simfang2312_z5));
                paragraph9.add(phrase9);
                document.add(paragraph9);
                Paragraph paragraph10 = new ParagraphBuilder();
                paragraph10.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph10.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase10 = new Phrase();
                phrase10.add(new Chunk("勘验情况：", simfang2312_z5));
                phrase10.add(ChunkFactory.underLine(book.push(), 1675f, simfang2312_z5, StringFactoryBuild.build().getStringLength("空格勘验情况：", simfang2312_z5), -1));
                paragraph10.add(phrase10);
                document.add(paragraph10);
                Paragraph paragraph14 = new ParagraphBuilder();
                paragraph14.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph14.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase14 = new Phrase();
                phrase14.add(new Chunk("勘验人（签名）：", simfang2312_z5));
                phrase14.add(ChunkFactory.underLine(book.push(), 120.75f, simfang2312_z5));
                phrase14.add(new Chunk("勘验人（签名）：", simfang2312_z5));
                phrase14.add(ChunkFactory.underLine(book.push(), 89.25f, simfang2312_z5));
                paragraph14.add(phrase14);
                document.add(paragraph14);
                Paragraph paragraph15 = new ParagraphBuilder();
                paragraph15.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph15.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase15 = new Phrase();
                phrase15.add(new Chunk("当事人（签名）：", simfang2312_z5));
                phrase15.add(ChunkFactory.underLine(book.push(), 120.75f, simfang2312_z5));
                phrase15.add(new Chunk("联系方式：", simfang2312_z5));
                phrase15.add(ChunkFactory.underLine(book.push(), 115.5f, simfang2312_z5));
                paragraph15.add(phrase15);
                document.add(paragraph15);
                Paragraph paragraph16 = new ParagraphBuilder();
                paragraph16.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph16.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase16 = new Phrase();
                phrase16.add(new Chunk("当事人（签名）：", simfang2312_z5));
                phrase16.add(ChunkFactory.underLine(book.push(), 120.75f, simfang2312_z5));
                phrase16.add(new Chunk("联系方式：", simfang2312_z5));
                phrase16.add(ChunkFactory.underLine(book.push(), 115.5f, simfang2312_z5));
                paragraph16.add(phrase16);
                document.add(paragraph16);
                Paragraph paragraph17 = new ParagraphBuilder();
                paragraph17.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph17.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase17 = new Phrase();
                phrase17.add(new Chunk("被邀请人（签名）：", simfang2312_z5));
                phrase17.add(ChunkFactory.underLine(book.push(), 110.25f, simfang2312_z5));
                phrase17.add(new Chunk("记录人（签名）：", simfang2312_z5));
                phrase17.add(ChunkFactory.underLine(book.push(), 89.25f, simfang2312_z5));
                paragraph17.add(phrase17);
                document.add(paragraph17);
                printerFrameWorkPic(postmaskimage);
                document.newPage();
            }
        });

    }

    //抽样取证凭证
    protected void printerEntity_Book_2017_17(final Base_Entity book, final Object postmaskimage) {
        printerFrameWork(book, postmaskimage, new IPdfBackFrame() {
            @Override
            public void writeContent() throws Exception {
                //此处写页面布局
                book.push();
                book.push();
                book.push();
                printerFrameWorkTitle(book, "安全生产行政执法文书", "抽样取证凭证", "安监抽");
                Paragraph paragraph1 = new ParagraphBuilder();
                paragraph1.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph1.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase1 = new Phrase();
                phrase1.add(new Chunk("被抽样取证人（单位）", simfang2312_z5));
                phrase1.add(ChunkFactory.underLine(book.push(), 153.25f, simfang2312_z5));
                phrase1.add(new Chunk("现场负责人", simfang2312_z5));
                phrase1.add(ChunkFactory.underLine(book.push(), 115.5f, simfang2312_z5));
                paragraph1.add(phrase1);
                document.add(paragraph1);
                Paragraph paragraph2 = new ParagraphBuilder();
                paragraph2.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph2.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase2 = new Phrase();
                phrase2.add(new Chunk("地址", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.push(), 178.5f, simfang2312_z5));
                phrase2.add(new Chunk("联系电话", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.push(), 63.0f, simfang2312_z5));
                phrase2.add(new Chunk("邮编", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.push(), 89.25f, simfang2312_z5));
                paragraph2.add(phrase2);
                document.add(paragraph2);
                Paragraph paragraph3 = new ParagraphBuilder();
                paragraph3.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph3.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase3 = new Phrase();
                phrase3.add(new Chunk("抽样取证时间", simfang2312_z5));
                phrase3.add(ChunkFactory.underLine(book.pushneedcheck(), 0, 36.75f, simfang2312_z5));
                phrase3.add(new Chunk("年", simfang2312_z5));
                phrase3.add(ChunkFactory.underLine(book.pushneedcheck(), 1, 21.0f, simfang2312_z5));
                phrase3.add(new Chunk("月", simfang2312_z5));
                phrase3.add(ChunkFactory.underLine(book.pushneedcheck(), 2, 21.0f, simfang2312_z5));
                phrase3.add(new Chunk("日", simfang2312_z5));
                phrase3.add(ChunkFactory.underLine(book.pushneedcheck(), 3, 21.0f, simfang2312_z5));
                phrase3.add(new Chunk("时", simfang2312_z5));
                phrase3.add(ChunkFactory.underLine(book.push(true), 4, 21.0f, simfang2312_z5));
                phrase3.add(new Chunk("分至", simfang2312_z5));
                phrase3.add(ChunkFactory.underLine(book.pushneedcheck(), 1, 21.0f, simfang2312_z5));
                phrase3.add(new Chunk("月", simfang2312_z5));
                phrase3.add(ChunkFactory.underLine(book.pushneedcheck(), 2, 15.75f, simfang2312_z5));
                phrase3.add(new Chunk("日", simfang2312_z5));
                phrase3.add(ChunkFactory.underLine(book.pushneedcheck(), 3, 15.75f, simfang2312_z5));
                phrase3.add(new Chunk("时", simfang2312_z5));
                phrase3.add(ChunkFactory.underLine(book.push(true), 4, 21.0f, simfang2312_z5));
                phrase3.add(new Chunk("分", simfang2312_z5));
//                phrase3.add(ChunkFactory.nounderLine("", 0.0f, simfang2312_z5));
                paragraph3.add(phrase3);
                document.add(paragraph3);
                Paragraph paragraph4 = new ParagraphBuilder();
                paragraph4.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph4.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase4 = new Phrase();
                phrase4.add(new Chunk("抽样地点", simfang2312_z5));
                phrase4.add(ChunkFactory.underLine(book.push(), 383.25f, simfang2312_z5));
                paragraph4.add(phrase4);
                document.add(paragraph4);
                Paragraph paragraph5 = new ParagraphBuilder();
                paragraph5.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph5.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase5 = new Phrase();
                phrase5.add(new Chunk("依据《中华人民共和国行政处罚法》第三十七条第二款的规定，对你（单位）的下列物品进行抽样取证。", simfang2312_z5));
                paragraph5.add(phrase5);
                document.add(paragraph5);
                document.add(space2);
                PdfPTable table = null;
                float[] widths = new float[4];
                widths[0] = 1f;
                widths[1] = 1f;
                widths[2] = 1f;
                widths[3] = 1f;
                widths[0] = 742.0f;
                widths[1] = 4093.0f;
                widths[2] = 2671.0f;
                widths[3] = 754.0f;
                table = new PdfPTable(4);
                table.setWidthPercentage(100f);
                table.setWidths(widths);
                PdfPCell cell_0 = new PdfPCellBuilder(new ParagraphBuilder("序号", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setVerticalAlignmentS(Element.ALIGN_MIDDLE).setHorizontalAlignmentS(Element.ALIGN_CENTER);
                cell_0.setFixedHeight(28f);
                table.addCell(cell_0);
                PdfPCell cell_1 = new PdfPCellBuilder(new ParagraphBuilder("证据物品名称", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setVerticalAlignmentS(Element.ALIGN_MIDDLE).setHorizontalAlignmentS(Element.ALIGN_CENTER);
                cell_1.setFixedHeight(28f);
                table.addCell(cell_1);
                PdfPCell cell_2 = new PdfPCellBuilder(new ParagraphBuilder("规格及批号", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setVerticalAlignmentS(Element.ALIGN_MIDDLE).setHorizontalAlignmentS(Element.ALIGN_CENTER);
                cell_2.setFixedHeight(28f);
                table.addCell(cell_2);
                PdfPCell cell_3 = new PdfPCellBuilder(new ParagraphBuilder("数量", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setVerticalAlignmentS(Element.ALIGN_MIDDLE).setHorizontalAlignmentS(Element.ALIGN_CENTER);
                cell_3.setFixedHeight(28f);
                table.addCell(cell_3);
                for (int i = 0; i < 6; i++) {
                    int j = 0;
                    PdfPCell cell_4 = new PdfPCellBuilder(new ParagraphBuilder(getListItemValue(book.pushneedcheck(), i, j++), simfang2312_z5));
                    cell_4.setFixedHeight(28f);
                    table.addCell(cell_4);
                    PdfPCell cell_5 = new PdfPCellBuilder(new ParagraphBuilder(getListItemValue(book.pushneedcheck(), i, j++), simfang2312_z5));
                    cell_5.setFixedHeight(28f);
                    table.addCell(cell_5);
                    PdfPCell cell_6 = new PdfPCellBuilder(new ParagraphBuilder(getListItemValue(book.pushneedcheck(), i, j++), simfang2312_z5));
                    cell_6.setFixedHeight(28f);
                    table.addCell(cell_6);
                    PdfPCell cell_7 = new PdfPCellBuilder(new ParagraphBuilder(getListItemValue(book.pushneedcheck(), i, j++), simfang2312_z5));
                    cell_7.setFixedHeight(28f);
                    table.addCell(cell_7);
                    j = 0;
                }
                book.push(true);
                document.add(table);
                Paragraph paragraph6 = new ParagraphBuilder();
                paragraph6.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph6.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase6 = new Phrase();
                phrase6.add(new Chunk("现场负责人（签名）：", simfang2312_z5));
                phrase6.add(ChunkFactory.underLine(book.push(), 68.25f, simfang2312_z5));
                paragraph6.add(phrase6);
                document.add(paragraph6);
                Paragraph paragraph7 = new ParagraphBuilder();
                paragraph7.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph7.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase7 = new Phrase();
                phrase7.add(new Chunk("安全生产监管行政执法人员（签名）：", simfang2312_z5));
                phrase7.add(ChunkFactory.underLine(book.push(), 78.75f, simfang2312_z5));
                phrase7.add(new Chunk("证号：", simfang2312_z5));
                phrase7.add(ChunkFactory.underLine(book.push(), 68.25f, simfang2312_z5));
                paragraph7.add(phrase7);
                document.add(paragraph7);
                Paragraph paragraph8 = new ParagraphBuilder();
                paragraph8.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph8.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase8 = new Phrase();
                phrase8.add(ChunkFactory.nounderLine("", StringFactoryBuild.build().getStringLength("安全生产监管行政执法人员（签名）：", simfang2312_z5), simfang2312_z5));
                phrase8.add(ChunkFactory.underLine(book.push(), 78.75f, simfang2312_z5));
                phrase8.add(new Chunk("证号：", simfang2312_z5));
                phrase8.add(ChunkFactory.underLine(book.push(), 68.25f, simfang2312_z5));
                paragraph8.add(phrase8);
                document.add(paragraph8);
                printerFrameWorkG1(book);
                printerFrameWorkPic(postmaskimage);
                document.newPage();
            }
        });

    }

    //先行登记保存证据审批表
    protected void printerEntity_Book_2017_18(final Base_Entity book, final Object postmaskimage) {
        printerFrameWork(book, postmaskimage, new IPdfBackFrame() {
            @Override
            public void writeContent() throws Exception {
                //此处写页面布局
                book.push();
                book.push();
                book.push();
                printerFrameWorkTitle(book, "安全生产行政执法文书", "先行登记保存证据审批表", "安监先保审");
                Paragraph paragraph1 = new ParagraphBuilder();
                paragraph1.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph1.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase1 = new Phrase();
                phrase1.add(new Chunk("案件名称：", simfang2312_z5));
                phrase1.add(ChunkFactory.underLine(book.push(), 357.0f, simfang2312_z5));
                paragraph1.add(phrase1);
                document.add(paragraph1);
                document.add(space3);
                PdfPTable table = null;
                float[] widths = new float[2];
                widths[0] = 1f;
                widths[1] = 1f;
                widths[0] = 1908.0f;
                widths[1] = 6614.0f;
                table = new PdfPTable(2);
                table.setWidthPercentage(100f);
                table.setWidths(widths);
                PdfPCell cell_0 = new PdfPCellBuilder(new ParagraphBuilder("当事人\n" +
                        "及基本情况\n", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_0.setFixedHeight(44.848484f);
                table.addCell(cell_0);
                PdfPCell cell_1 = new PdfPCellBuilder(new ParagraphBuilder(book.push(), simfang2312_z5));
                cell_1.setFixedHeight(44.848484f);
                table.addCell(cell_1);
                PdfPCell cell_2 = new PdfPCellBuilder(new ParagraphBuilder("案件基本情况", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_2.setFixedHeight(43.333332f);
                table.addCell(cell_2);
                PdfPCell cell_3 = new PdfPCellBuilder(new ParagraphBuilder(book.push(), simfang2312_z5));
                cell_3.setFixedHeight(43.333332f);
                table.addCell(cell_3);
                PdfPCell cell_4 = new PdfPCellBuilder(new ParagraphBuilder("证据名称及数量", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_4.setFixedHeight(41.81818f);
                table.addCell(cell_4);
                PdfPCell cell_5 = new PdfPCellBuilder(new ParagraphBuilder(book.push(), simfang2312_z5));
                cell_5.setFixedHeight(41.81818f);
                table.addCell(cell_5);
                PdfPCell cell_6 = new PdfPCellBuilder(new ParagraphBuilder("提请理由及依据", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_6.setFixedHeight(43.333332f);
                table.addCell(cell_6);
                PdfPCell cell_7 = new PdfPCellBuilder(new ParagraphBuilder(book.push(), simfang2312_z5));
                cell_7.setFixedHeight(43.333332f);
                table.addCell(cell_7);
                PdfPCell cell_8 = new PdfPCellBuilder(new ParagraphBuilder("保存方式", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_8.setFixedHeight(55.959595f);
                table.addCell(cell_8);
                PdfPCell cell_9 = new PdfPCellBuilder(new ParagraphBuilder(book.push(), simfang2312_z5));
                cell_9.setFixedHeight(55.959595f);
                table.addCell(cell_9);
                Paragraph paragraph2 = new ParagraphBuilder();
                paragraph2.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph2.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase2 = new Phrase();
                phrase2.add(new Chunk("承办人意见：", simfang2312_z5));
                phrase2.add(ChunkFactory.nounderLine(book.push(), StringFactoryBuild.build().getStringLength("                                                                 ", simfang2312_z5), simfang2312_z5));
                paragraph2.add(phrase2);
                Paragraph paragraph3 = new ParagraphBuilder();
                paragraph3.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph3.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase3 = new Phrase();
                phrase3.add(new Chunk("承办人（签名）：", simfang2312_z5));
                phrase3.add(ChunkFactory.nounderLine("", StringFactoryBuild.build().getStringLength("　", simfang2312_z5), simfang2312_z5));
                phrase3.add(ChunkFactory.underLine(book.push(), StringFactoryBuild.build().getStringLength("            ", simfang2312_z5), simfang2312_z5));
                phrase3.add(ChunkFactory.nounderLine("", StringFactoryBuild.build().getStringLength("　", simfang2312_z5), simfang2312_z5));
                phrase3.add(ChunkFactory.underLine(book.push(), StringFactoryBuild.build().getStringLength("            ", simfang2312_z5), simfang2312_z5));
                phrase3.add(ChunkFactory.nounderLine("", StringFactoryBuild.build().getStringLength("            ", simfang2312_z5), simfang2312_z5));
                phrase3.add(ChunkFactory.nounderLine(book.pushneedcheck(), 0, 42.0f, simfang2312_z5));
                phrase3.add(new Chunk("年", simfang2312_z5));
                phrase3.add(ChunkFactory.nounderLine(book.pushneedcheck(), 1, 21.0f, simfang2312_z5));
                phrase3.add(new Chunk("月", simfang2312_z5));
                phrase3.add(ChunkFactory.nounderLine(book.push(true), 2, 21.0f, simfang2312_z5));
                phrase3.add(new Chunk("日", simfang2312_z5));
                paragraph3.add(phrase3);
                PdfPCell cell_10 = new PdfPCellBuilder();
                cell_10.addElement(paragraph2);
                cell_10.addElement(paragraph3);
                cell_10.setColspan(2);
                cell_10.setFixedHeight(57.121212f);
                table.addCell(cell_10);
                Paragraph paragraph4 = new ParagraphBuilder();
                paragraph4.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph4.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase4 = new Phrase();
                phrase4.add(new Chunk("承办机构意见：", simfang2312_z5));
                phrase4.add(ChunkFactory.nounderLine(book.push(), StringFactoryBuild.build().getStringLength("                                                                 ", simfang2312_z5), simfang2312_z5));
                paragraph4.add(phrase4);
                Paragraph paragraph5 = new ParagraphBuilder();
                paragraph5.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph5.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase5 = new Phrase();
                phrase5.add(new Chunk("承办机构负责人（签名）：", simfang2312_z5));
                phrase5.add(ChunkFactory.nounderLine(book.push(), StringFactoryBuild.build().getStringLength("　　　                           ", simfang2312_z5), simfang2312_z5));
                phrase5.add(ChunkFactory.nounderLine(book.pushneedcheck(), 0, 42.0f, simfang2312_z5));
                phrase5.add(new Chunk("年", simfang2312_z5));
                phrase5.add(ChunkFactory.nounderLine(book.pushneedcheck(), 1, 21.0f, simfang2312_z5));
                phrase5.add(new Chunk("月", simfang2312_z5));
                phrase5.add(ChunkFactory.nounderLine(book.push(true), 2, 21.0f, simfang2312_z5));
                phrase5.add(new Chunk("日", simfang2312_z5));
                paragraph5.add(phrase5);
                PdfPCell cell_11 = new PdfPCellBuilder();
                cell_11.addElement(paragraph4);
                cell_11.addElement(paragraph5);
                cell_11.setColspan(2);
                cell_11.setFixedHeight(56.515152f);
                table.addCell(cell_11);
                Paragraph paragraph6 = new ParagraphBuilder();
                paragraph6.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph6.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase6 = new Phrase();
                phrase6.add(new Chunk("审核意见：", simfang2312_z5));
                phrase6.add(ChunkFactory.nounderLine(book.push(), StringFactoryBuild.build().getStringLength("                                                                 ", simfang2312_z5), simfang2312_z5));
                paragraph6.add(phrase6);
                Paragraph paragraph7 = new ParagraphBuilder();
                paragraph7.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph7.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase7 = new Phrase();
                phrase7.add(new Chunk("审核人（签名）：", simfang2312_z5));
                phrase7.add(ChunkFactory.nounderLine(book.push(), StringFactoryBuild.build().getStringLength("　　　                                   ", simfang2312_z5), simfang2312_z5));
                phrase7.add(ChunkFactory.nounderLine(book.pushneedcheck(), 0, 42.0f, simfang2312_z5));
                phrase7.add(new Chunk("年", simfang2312_z5));
                phrase7.add(ChunkFactory.nounderLine(book.pushneedcheck(), 1, 21.0f, simfang2312_z5));
                phrase7.add(new Chunk("月", simfang2312_z5));
                phrase7.add(ChunkFactory.nounderLine(book.push(true), 2, 21.0f, simfang2312_z5));
                phrase7.add(new Chunk("日", simfang2312_z5));
                paragraph7.add(phrase7);
                PdfPCell cell_12 = new PdfPCellBuilder();
                cell_12.addElement(paragraph6);
                cell_12.addElement(paragraph7);
                cell_12.setColspan(2);
                cell_12.setFixedHeight(56.61616f);
                table.addCell(cell_12);
                Paragraph paragraph8 = new ParagraphBuilder();
                paragraph8.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph8.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase8 = new Phrase();
                phrase8.add(new Chunk("审批意见：", simfang2312_z5));
                phrase8.add(ChunkFactory.nounderLine(book.push(), StringFactoryBuild.build().getStringLength("                                                                 ", simfang2312_z5), simfang2312_z5));
                paragraph8.add(phrase8);
                Paragraph paragraph9 = new ParagraphBuilder();
                paragraph9.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph9.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase9 = new Phrase();
                phrase9.add(new Chunk("审批人（签名）：", simfang2312_z5));
                phrase9.add(ChunkFactory.nounderLine(book.push(), StringFactoryBuild.build().getStringLength("　　　                                   ", simfang2312_z5), simfang2312_z5));
                phrase9.add(ChunkFactory.nounderLine(book.pushneedcheck(), 0, 42.0f, simfang2312_z5));
                phrase9.add(new Chunk("年", simfang2312_z5));
                phrase9.add(ChunkFactory.nounderLine(book.pushneedcheck(), 1, 21.0f, simfang2312_z5));
                phrase9.add(new Chunk("月", simfang2312_z5));
                phrase9.add(ChunkFactory.nounderLine(book.push(true), 2, 21.0f, simfang2312_z5));
                phrase9.add(new Chunk("日", simfang2312_z5));
                paragraph9.add(phrase9);
                PdfPCell cell_13 = new PdfPCellBuilder();
                cell_13.addElement(paragraph8);
                cell_13.addElement(paragraph9);
                cell_13.setColspan(2);
                cell_13.setFixedHeight(71.36364f);
                table.addCell(cell_13);
                document.add(table);
                printerFrameWorkPic(postmaskimage);
                document.newPage();
            }
        });

    }

    //先行登记保存证据通知书
    protected void printerEntity_Book_2017_19(final Base_Entity book, final Object postmaskimage) {
        printerFrameWork(book, postmaskimage, new IPdfBackFrame() {
            @Override
            public void writeContent() throws Exception {
                //此处写页面布局
                book.push();
                book.push();
                book.push();
                printerFrameWorkTitle(book, "安全生产行政执法文书", "先行登记保存证据通知书", "安监先保通");
                Paragraph paragraph1 = new ParagraphBuilder();
                paragraph1.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph1.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase1 = new Phrase();
                phrase1.add(ChunkFactory.underLine(book.push(), 78.75f, simfang2312_z5));
                phrase1.add(new Chunk("：", simfang2312_z5));
                paragraph1.add(phrase1);
                document.add(paragraph1);
                Paragraph paragraph2 = new ParagraphBuilder();
                paragraph2.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph2.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase2 = new Phrase();
                phrase2.add(new Chunk("你（单位）涉嫌", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.push(), 84.0f, simfang2312_z5));
                phrase2.add(new Chunk("行为。为确保调查取证工作，依据《中华人民共和国行政处罚法》第三十七条第二款的规定，本机关决定对你（单位）的有关证据（证据名称、数量等详见附后清单）采取先行登记保存措施。", simfang2312_z5));
                paragraph2.add(phrase2);
                document.add(paragraph2);
                Paragraph paragraph3 = new ParagraphBuilder();
                paragraph3.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph3.setFirstLineIndent(simfang2312_z5.getSize() * 1f);
                Phrase phrase3 = new Phrase();
                phrase3.add(new Chunk("注意事项：", simfang2312_z5));
                paragraph3.add(phrase3);
                document.add(paragraph3);
                Paragraph paragraph4 = new ParagraphBuilder();
                paragraph4.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph4.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase4 = new Phrase();
                phrase4.add(new Chunk("1.对先行登记保存的证据，本机关将在七日内依法作出处理决定。请你（单位）于", simfang2312_z5));
                phrase4.add(ChunkFactory.underLine(book.pushneedcheck(), 0, 15.75f, simfang2312_z5));
                phrase4.add(new Chunk("年", simfang2312_z5));
                phrase4.add(ChunkFactory.underLine(book.pushneedcheck(), 1, 15.75f, simfang2312_z5));
                phrase4.add(new Chunk("月", simfang2312_z5));
                phrase4.add(ChunkFactory.underLine(book.push(true), 2, 10.5f, simfang2312_z5));
                phrase4.add(new Chunk("日到", simfang2312_z5));
                phrase4.add(ChunkFactory.underLine(book.push(), 364.25f, simfang2312_z5));
                paragraph4.add(phrase4);
                document.add(paragraph4);
                Paragraph paragraph5 = new ParagraphBuilder();
                paragraph5.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph5.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase5 = new Phrase();
                phrase5.add(new Chunk("接受对先行登记保存证据的处理决定。", simfang2312_z5));
                paragraph5.add(phrase5);
                document.add(paragraph5);
                Paragraph paragraph6 = new ParagraphBuilder();
                paragraph6.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph6.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase6 = new Phrase();
                phrase6.add(new Chunk("2.对就地先行登记保存的证据，在本机关作出处理决定前，你（单位）负有妥善保管的义务，不得有短缺、灭失、损毁或者擅自移动等改变证据物品的任何行为。", simfang2312_z5));
                paragraph6.add(phrase6);
                document.add(paragraph6);
                Paragraph paragraph7 = new ParagraphBuilder();
                paragraph7.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph7.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase7 = new Phrase();
                phrase7.add(new Chunk("3.请核对证据清单后，签字确认。", simfang2312_z5));
                paragraph7.add(phrase7);
                document.add(paragraph7);
                printerFrameWorkG2(book);
                Paragraph paragraph8 = new ParagraphBuilder();
                paragraph8.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph8.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase8 = new Phrase();
                phrase8.add(new Chunk("被通知人或者被通知单位负责人（签名）：", simfang2312_z5));
                phrase8.add(ChunkFactory.underLine(book.push(), 78.75f, simfang2312_z5));
                paragraph8.add(phrase8);
                document.add(paragraph8);
                printerFrameWorkG3(book);
                printerFrameWorkPic(postmaskimage);
                document.newPage();// 结束保存
            }
        });

    }

    //先行登记保存证据处理审批表
    protected void printerEntity_Book_2017_20(final Base_Entity book, final Object postmaskimage) {
        printerFrameWork(book, postmaskimage, new IPdfBackFrame() {
            @Override
            public void writeContent() throws Exception {
                //此处写页面布局
                book.push();
                book.push();
                book.push();
                printerFrameWorkTitle(book, "安全生产行政执法文书", "先行登记保存证据处理审批表", "安监先保处审");
                Paragraph paragraph1 = new ParagraphBuilder();
                paragraph1.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph1.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase1 = new Phrase();
                phrase1.add(new Chunk("案件名称：", simfang2312_z5));
                phrase1.add(ChunkFactory.underLine(book.push(), 357.0f, simfang2312_z5));
                paragraph1.add(phrase1);
                document.add(paragraph1);
                document.add(space3);
                PdfPTable table = null;
                float[] widths = new float[2];
                widths[0] = 1f;
                widths[1] = 1f;
                widths[0] = 1908.0f;
                widths[1] = 6614.0f;
                table = new PdfPTable(2);
                table.setWidthPercentage(100f);
                table.setWidths(widths);
                PdfPCell cell_0 = new PdfPCellBuilder(new ParagraphBuilder("当事人\n" +
                        "及基本情况\n", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_0.setFixedHeight(44.848484f);
                table.addCell(cell_0);
                PdfPCell cell_1 = new PdfPCellBuilder(new ParagraphBuilder(book.push(), simfang2312_z5));
                cell_1.setFixedHeight(44.848484f);
                table.addCell(cell_1);
                PdfPCell cell_2 = new PdfPCellBuilder(new ParagraphBuilder("案件基本情况", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_2.setFixedHeight(63.333332f);
                table.addCell(cell_2);
                PdfPCell cell_3 = new PdfPCellBuilder(new ParagraphBuilder(book.push(), simfang2312_z5));
                cell_3.setFixedHeight(63.333332f);
                table.addCell(cell_3);
                PdfPCell cell_4 = new PdfPCellBuilder(new ParagraphBuilder("证据名称及数量", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_4.setFixedHeight(63.81818f);
                table.addCell(cell_4);
                PdfPCell cell_5 = new PdfPCellBuilder(new ParagraphBuilder(book.push(), simfang2312_z5));
                cell_5.setFixedHeight(63.81818f);
                table.addCell(cell_5);
                PdfPCell cell_6 = new PdfPCellBuilder(new ParagraphBuilder("提请理由及依据", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_6.setFixedHeight(63.333332f);
                table.addCell(cell_6);
                PdfPCell cell_7 = new PdfPCellBuilder(new ParagraphBuilder(book.push(), simfang2312_z5));
                cell_7.setFixedHeight(63.333332f);
                table.addCell(cell_7);
                Paragraph paragraph2 = new ParagraphBuilder();
                paragraph2.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph2.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase2 = new Phrase();
                phrase2.add(new Chunk("承办人意见：", simfang2312_z5));
                phrase2.add(ChunkFactory.nounderLine(book.push(), StringFactoryBuild.build().getStringLength("                                                                 ", simfang2312_z5), simfang2312_z5));
                paragraph2.add(phrase2);
                Paragraph paragraph3 = new ParagraphBuilder();
                paragraph3.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph3.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase3 = new Phrase();
                phrase3.add(new Chunk("承办人（签名）：", simfang2312_z5));
                phrase3.add(ChunkFactory.nounderLine("", StringFactoryBuild.build().getStringLength("　", simfang2312_z5), simfang2312_z5));
                phrase3.add(ChunkFactory.underLine(book.push(), StringFactoryBuild.build().getStringLength("            ", simfang2312_z5), simfang2312_z5));
                phrase3.add(ChunkFactory.nounderLine("", StringFactoryBuild.build().getStringLength("　", simfang2312_z5), simfang2312_z5));
                phrase3.add(ChunkFactory.underLine(book.push(), StringFactoryBuild.build().getStringLength("            ", simfang2312_z5), simfang2312_z5));
                phrase3.add(ChunkFactory.nounderLine("", StringFactoryBuild.build().getStringLength("            ", simfang2312_z5), simfang2312_z5));
                phrase3.add(ChunkFactory.nounderLine(book.pushneedcheck(), 0, 42.0f, simfang2312_z5));
                phrase3.add(new Chunk("年", simfang2312_z5));
                phrase3.add(ChunkFactory.nounderLine(book.pushneedcheck(), 1, 21.0f, simfang2312_z5));
                phrase3.add(new Chunk("月", simfang2312_z5));
                phrase3.add(ChunkFactory.nounderLine(book.push(true), 2, 21.0f, simfang2312_z5));
                phrase3.add(new Chunk("日", simfang2312_z5));
                paragraph3.add(phrase3);
                PdfPCell cell_10 = new PdfPCellBuilder();
                cell_10.addElement(paragraph2);
                cell_10.addElement(paragraph3);
                cell_10.setColspan(2);
                cell_10.setFixedHeight(57.121212f);
                table.addCell(cell_10);
                Paragraph paragraph4 = new ParagraphBuilder();
                paragraph4.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph4.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase4 = new Phrase();
                phrase4.add(new Chunk("承办机构意见：", simfang2312_z5));
                phrase4.add(ChunkFactory.nounderLine(book.push(), StringFactoryBuild.build().getStringLength("                                                                 ", simfang2312_z5), simfang2312_z5));
                paragraph4.add(phrase4);
                Paragraph paragraph5 = new ParagraphBuilder();
                paragraph5.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph5.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase5 = new Phrase();
                phrase5.add(new Chunk("承办机构负责人（签名）：", simfang2312_z5));
                phrase5.add(ChunkFactory.nounderLine(book.push(), StringFactoryBuild.build().getStringLength("　　　                          ", simfang2312_z5), simfang2312_z5));
                phrase5.add(ChunkFactory.nounderLine(book.pushneedcheck(), 0, 42.0f, simfang2312_z5));
                phrase5.add(new Chunk("年", simfang2312_z5));
                phrase5.add(ChunkFactory.nounderLine(book.pushneedcheck(), 1, 21.0f, simfang2312_z5));
                phrase5.add(new Chunk("月", simfang2312_z5));
                phrase5.add(ChunkFactory.nounderLine(book.push(true), 2, 21.0f, simfang2312_z5));
                phrase5.add(new Chunk("日", simfang2312_z5));
                paragraph5.add(phrase5);
                PdfPCell cell_11 = new PdfPCellBuilder();
                cell_11.addElement(paragraph4);
                cell_11.addElement(paragraph5);
                cell_11.setColspan(2);
                cell_11.setFixedHeight(56.515152f);
                table.addCell(cell_11);
                Paragraph paragraph6 = new ParagraphBuilder();
                paragraph6.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph6.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase6 = new Phrase();
                phrase6.add(new Chunk("审核意见：", simfang2312_z5));
                phrase6.add(ChunkFactory.nounderLine(book.push(), StringFactoryBuild.build().getStringLength("                                                                 ", simfang2312_z5), simfang2312_z5));
                paragraph6.add(phrase6);
                Paragraph paragraph7 = new ParagraphBuilder();
                paragraph7.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph7.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase7 = new Phrase();
                phrase7.add(new Chunk("审核人（签名）：", simfang2312_z5));
                phrase7.add(ChunkFactory.nounderLine(book.push(), StringFactoryBuild.build().getStringLength("　　　                                  ", simfang2312_z5), simfang2312_z5));
                phrase7.add(ChunkFactory.nounderLine(book.pushneedcheck(), 0, 42.0f, simfang2312_z5));
                phrase7.add(new Chunk("年", simfang2312_z5));
                phrase7.add(ChunkFactory.nounderLine(book.pushneedcheck(), 1, 21.0f, simfang2312_z5));
                phrase7.add(new Chunk("月", simfang2312_z5));
                phrase7.add(ChunkFactory.nounderLine(book.push(true), 2, 21.0f, simfang2312_z5));
                phrase7.add(new Chunk("日", simfang2312_z5));
                paragraph7.add(phrase7);
                PdfPCell cell_12 = new PdfPCellBuilder();
                cell_12.addElement(paragraph6);
                cell_12.addElement(paragraph7);
                cell_12.setColspan(2);
                cell_12.setFixedHeight(56.61616f);
                table.addCell(cell_12);
                Paragraph paragraph8 = new ParagraphBuilder();
                paragraph8.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph8.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase8 = new Phrase();
                phrase8.add(new Chunk("审批意见：", simfang2312_z5));
                phrase8.add(ChunkFactory.nounderLine(book.push(), StringFactoryBuild.build().getStringLength("                                                                 ", simfang2312_z5), simfang2312_z5));
                paragraph8.add(phrase8);
                Paragraph paragraph9 = new ParagraphBuilder();
                paragraph9.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph9.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase9 = new Phrase();
                phrase9.add(new Chunk("审批人（签名）：", simfang2312_z5));
                phrase9.add(ChunkFactory.nounderLine(book.push(), StringFactoryBuild.build().getStringLength("　　　                                  ", simfang2312_z5), simfang2312_z5));
                phrase9.add(ChunkFactory.nounderLine(book.pushneedcheck(), 0, 42.0f, simfang2312_z5));
                phrase9.add(new Chunk("年", simfang2312_z5));
                phrase9.add(ChunkFactory.nounderLine(book.pushneedcheck(), 1, 21.0f, simfang2312_z5));
                phrase9.add(new Chunk("月", simfang2312_z5));
                phrase9.add(ChunkFactory.nounderLine(book.push(true), 2, 21.0f, simfang2312_z5));
                phrase9.add(new Chunk("日", simfang2312_z5));
                paragraph9.add(phrase9);
                PdfPCell cell_13 = new PdfPCellBuilder();
                cell_13.addElement(paragraph8);
                cell_13.addElement(paragraph9);
                cell_13.setColspan(2);
                cell_13.setFixedHeight(71.36364f);
                table.addCell(cell_13);
                document.add(table);
                printerFrameWorkPic(postmaskimage);
                document.newPage();
            }
        });

    }

    //先行登记保存证据处理决定书
    protected void printerEntity_Book_2017_21(final Base_Entity book, final Object postmaskimage) {
        printerFrameWork(book, postmaskimage, new IPdfBackFrame() {
            @Override
            public void writeContent() throws Exception {
                //此处写页面布局
                book.push();
                book.push();
                book.push();
                printerFrameWorkTitle(book, "安全生产行政执法文书", "先行登记保存证据处理决定书", "安监先保处");
                Paragraph paragraph1 = new ParagraphBuilder();
                paragraph1.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph1.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase1 = new Phrase();
                phrase1.add(ChunkFactory.underLine(book.push(), 94.5f, simfang2312_z5));
                phrase1.add(new Chunk("：", simfang2312_z5));
                paragraph1.add(phrase1);
                document.add(paragraph1);
                Paragraph paragraph2 = new ParagraphBuilder();
                paragraph2.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph2.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase2 = new Phrase();
                phrase2.add(new Chunk("本机关于", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.pushneedcheck(), 0, 26.25f, simfang2312_z5));
                phrase2.add(new Chunk("年", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.pushneedcheck(), 1, 21f, simfang2312_z5));
                phrase2.add(new Chunk("月", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.push(true), 2, 21f, simfang2312_z5));
                phrase2.add(new Chunk("日对你（单位）的", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.push(), 603f, simfang2312_z5, StringFactoryBuild.build().getStringLength("空格本机关于       年  月  日对你（单位）的", simfang2312_z5), -1));
                phrase2.add(new Chunk("等物品进行了先行登记保存[文号：（", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.push(), 15.75f, simfang2312_z5));
                phrase2.add(new Chunk("）安监先保通〔", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.push(), 15.75f, simfang2312_z5));
                phrase2.add(new Chunk("〕", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.push(), 15.5f, simfang2312_z5));
                phrase2.add(new Chunk("号]。现依法对上述物品作出如下处理决定：", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.push(), 2496f, simfang2312_z5, StringFactoryBuild.build().getStringLength("出如下处理决定：", simfang2312_z5), -1));
                paragraph2.add(phrase2);
                document.add(paragraph2);
                Paragraph paragraph10 = new ParagraphBuilder();
                paragraph10.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph10.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase10 = new Phrase();
                phrase10.add(new Chunk("如果不服本决定，可以依法在60日内向", simfang2312_z5));
                phrase10.add(ChunkFactory.underLine(book.push(), 42.0f, simfang2312_z5));
                phrase10.add(new Chunk("人民政府或者", simfang2312_z5));
                phrase10.add(ChunkFactory.underLine(book.push(), 63.0f, simfang2312_z5));
                phrase10.add(new Chunk("申请行政复议，或者在6个月内依法向", simfang2312_z5));
                phrase10.add(ChunkFactory.underLine(book.push(), 36.75f, simfang2312_z5));
                phrase10.add(new Chunk("人民法院提起行政诉讼，但本决定不停止执行，法律另有规定的除外。", simfang2312_z5));
                paragraph10.add(phrase10);
                document.add(paragraph10);
                printerFrameWorkG2(book);
                printerFrameWorkG3(book);
                printerFrameWorkPic(postmaskimage);
                document.newPage();// 结束保存
            }
        });

    }

    //鉴定委托书
    protected void printerEntity_Book_2017_22(final Base_Entity book, final Object postmaskimage) {
        printerFrameWork(book, postmaskimage, new IPdfBackFrame() {
            @Override
            public void writeContent() throws Exception {
                //此处写页面布局
                book.push();
                book.push();
                book.push();
                printerFrameWorkTitle(book, "安全生产行政执法文书", "鉴定委托书", "安监鉴");
                Paragraph paragraph1 = new ParagraphBuilder();
                paragraph1.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph1.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase1 = new Phrase();
                phrase1.add(ChunkFactory.underLine(book.push(), 162.75f, simfang2312_z5));
                phrase1.add(new Chunk("：", simfang2312_z5));
                paragraph1.add(phrase1);
                document.add(paragraph1);
                Paragraph paragraph2 = new ParagraphBuilder();
                paragraph2.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph2.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase2 = new Phrase();
                phrase2.add(new Chunk("因调查有关安全生产违法案件的需要，本行政机关现委托你单位对下列物品进行鉴定。", simfang2312_z5));
                paragraph2.add(phrase2);
                document.add(paragraph2);
                document.add(space4);
                PdfPTable table = null;
                float[] widths = new float[4];
                widths[0] = 1f;
                widths[1] = 1f;
                widths[2] = 1f;
                widths[3] = 1f;
                widths[0] = 2628.0f;
                widths[1] = 2700.0f;
                widths[2] = 844.0f;
                widths[3] = 2198.0f;
                table = new PdfPTable(4);
                table.setWidthPercentage(100f);
                table.setWidths(widths);
                PdfPCell cell_0 = new PdfPCellBuilder(new ParagraphBuilder("物品名称", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_0.setFixedHeight(28f);
                table.addCell(cell_0);
                PdfPCell cell_1 = new PdfPCellBuilder(new ParagraphBuilder("规格型号", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_1.setFixedHeight(28f);
                table.addCell(cell_1);
                PdfPCell cell_2 = new PdfPCellBuilder(new ParagraphBuilder("数量", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_2.setFixedHeight(28f);
                table.addCell(cell_2);
                PdfPCell cell_3 = new PdfPCellBuilder(new ParagraphBuilder("备注", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_3.setFixedHeight(28f);
                table.addCell(cell_3);
                for (int i = 0; i < 3; i++) {
                    int j = 0;
                    PdfPCell cell_4 = new PdfPCellBuilder(new ParagraphBuilder(getListItemValue(book.pushneedcheck(), i, j++), simfang2312_z5));
                    cell_4.setFixedHeight(28f);
                    table.addCell(cell_4);
                    PdfPCell cell_5 = new PdfPCellBuilder(new ParagraphBuilder(getListItemValue(book.pushneedcheck(), i, j++), simfang2312_z5));
                    cell_5.setFixedHeight(28f);
                    table.addCell(cell_5);
                    PdfPCell cell_6 = new PdfPCellBuilder(new ParagraphBuilder(getListItemValue(book.pushneedcheck(), i, j++), simfang2312_z5));
                    cell_6.setFixedHeight(28f);
                    table.addCell(cell_6);
                    PdfPCell cell_7 = new PdfPCellBuilder(new ParagraphBuilder(getListItemValue(book.pushneedcheck(), i, j++), simfang2312_z5));
                    cell_7.setFixedHeight(28f);
                    table.addCell(cell_7);
                    j = 0;
                }
                book.push(true);
                document.add(table);
                Paragraph paragraph3 = new ParagraphBuilder();
                paragraph3.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph3.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase3 = new Phrase();
                phrase3.add(new Chunk("鉴定要求：", simfang2312_z5));
                phrase3.add(ChunkFactory.underLine(book.push(), 1590f, simfang2312_z5, StringFactoryBuild.build().getStringLength("空格鉴定要求：", simfang2312_z5), -1));
                paragraph3.add(phrase3);
                document.add(paragraph3);
                Paragraph paragraph7 = new ParagraphBuilder();
                paragraph7.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph7.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase7 = new Phrase();
                phrase7.add(new Chunk("请于", simfang2312_z5));
                phrase7.add(ChunkFactory.underLine(book.pushneedcheck(), 0, 42.0f, simfang2312_z5));
                phrase7.add(new Chunk("年", simfang2312_z5));
                phrase7.add(ChunkFactory.underLine(book.pushneedcheck(), 1, 15.75f, simfang2312_z5));
                phrase7.add(new Chunk("月", simfang2312_z5));
                phrase7.add(ChunkFactory.underLine(book.push(true), 15.75f, simfang2312_z5));
                phrase7.add(new Chunk("日前向本行政机关提交鉴定结果。", simfang2312_z5));
                paragraph7.add(phrase7);
                document.add(paragraph7);
                Paragraph paragraph8 = new ParagraphBuilder();
                paragraph8.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph8.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase8 = new Phrase();
                phrase8.add(new Chunk("联系人：", simfang2312_z5));
                phrase8.add(ChunkFactory.underLine(book.push(), 63.0f, simfang2312_z5));
                phrase8.add(new Chunk("联系电话：", simfang2312_z5));
                phrase8.add(ChunkFactory.underLine(book.push(), 78.75f, simfang2312_z5));
                paragraph8.add(phrase8);
                document.add(paragraph8);
                printerFrameWorkG1(book);
                printerFrameWorkPic(postmaskimage);
                document.newPage();// 结束保存
            }
        });

    }

    //行政处罚告知书
    protected void printerEntity_Book_2017_23(final Base_Entity book, final Object postmaskimage) {
        printerFrameWork(book, postmaskimage, new IPdfBackFrame() {
            @Override
            public void writeContent() throws Exception {
                //此处写页面布局
                book.push();
                book.push();
                book.push();
                printerFrameWorkTitle(book, "安全生产行政执法文书", "行政处罚告知书", "安监罚告");
                Paragraph paragraph1 = new ParagraphBuilder();
                paragraph1.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph1.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase1 = new Phrase();
                phrase1.add(ChunkFactory.underLine(book.push(), 94.5f, simfang2312_z5));
                phrase1.add(new Chunk("：", simfang2312_z5));
                paragraph1.add(phrase1);
                document.add(paragraph1);
                Paragraph paragraph2 = new ParagraphBuilder();
                paragraph2.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph2.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase2 = new Phrase();
                phrase2.add(new Chunk("现查明，你（单位）存在下列行为：", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.push(), 646.75f, simfang2312_z5, StringFactoryBuild.build().getStringLength("空格现查明，你（单位）存在下列行为：", simfang2312_z5), -1));
                paragraph2.add(phrase2);
                document.add(paragraph2);
                Paragraph paragraph5 = new ParagraphBuilder();
                paragraph5.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph5.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase5 = new Phrase();
                phrase5.add(new Chunk("以上事实主要证据如下：", simfang2312_z5));
                phrase5.add(ChunkFactory.underLine(book.push(), 672.75f, simfang2312_z5, StringFactoryBuild.build().getStringLength("空格以上事实主要证据如下：", simfang2312_z5), -1));
                paragraph5.add(phrase5);
                document.add(paragraph5);
                Paragraph paragraph7 = new ParagraphBuilder();
                paragraph7.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph7.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase7 = new Phrase();
                phrase7.add(new Chunk("以上行为违反了", simfang2312_z5));
                phrase7.add(ChunkFactory.underLine(book.push(), 320.25f, simfang2312_z5));
                paragraph7.add(phrase7);
                document.add(paragraph7);
                Paragraph paragraph8 = new ParagraphBuilder();
                paragraph8.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph8.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase8 = new Phrase();
                phrase8.add(new Chunk("的规定，依据", simfang2312_z5));
                phrase8.add(ChunkFactory.underLine(book.push(), 351.75f, simfang2312_z5));
                phrase8.add(new Chunk("的规定，拟对你（单位）作出", simfang2312_z5));
                phrase8.add(ChunkFactory.underLine(book.push(), 225.75f, simfang2312_z5));
                phrase8.add(new Chunk("的行政处罚。", simfang2312_z5));
                paragraph8.add(phrase8);
                document.add(paragraph8);
                Paragraph paragraph9 = new ParagraphBuilder();
                paragraph9.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph9.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase9 = new Phrase();
                phrase9.add(new Chunk("如对上述处罚有异议，根据《中华人民共和国行政处罚法》第三十一条和第三十二条的规定，你（单位）有权在收到本告知书之日起3日内向", simfang2312_z5));
                phrase9.add(ChunkFactory.underLine(book.push(), 57.75f, simfang2312_z5));
                phrase9.add(new Chunk("安全生产监督管理部门进行陈述和申辩，逾期不提出申请的，视为放弃上述权利。", simfang2312_z5));
                paragraph9.add(phrase9);
                document.add(paragraph9);
                Paragraph paragraph10 = new ParagraphBuilder();
                paragraph10.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph10.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase10 = new Phrase();
                paragraph10.add(phrase10);
                document.add(paragraph10);
                Paragraph paragraph11 = new ParagraphBuilder();
                paragraph11.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph11.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase11 = new Phrase();
                phrase11.add(new Chunk("安全生产监督管理部门地址：", simfang2312_z5));
                phrase11.add(ChunkFactory.underLine(book.push(), 225.75f, simfang2312_z5));
                paragraph11.add(phrase11);
                document.add(paragraph11);
                Paragraph paragraph12 = new ParagraphBuilder();
                paragraph12.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph12.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase12 = new Phrase();
                phrase12.add(new Chunk("联系人：", simfang2312_z5));
                phrase12.add(ChunkFactory.underLine(book.push(), 78.75f, simfang2312_z5));
                phrase12.add(new Chunk("联系电话：", simfang2312_z5));
                phrase12.add(ChunkFactory.underLine(book.push(), 63.0f, simfang2312_z5));
                phrase12.add(new Chunk("邮政编码：", simfang2312_z5));
                phrase12.add(ChunkFactory.underLine(book.push(), 73.5f, simfang2312_z5));
                paragraph12.add(phrase12);
                document.add(paragraph12);
                printerFrameWorkG2(book);
                printerFrameWorkG3(book);
                printerFrameWorkPic(postmaskimage);
                document.newPage();// 结束保存
            }
        });

    }

    //当事人陈述申辩笔录
    protected void printerEntity_Book_2017_24(final Base_Entity book, final Object postmaskimage) {
        printerFrameWork(book, postmaskimage, new IPdfBackFrame() {
            @Override
            public void writeContent() throws Exception {
                //此处写页面布局
                book.push();
                book.push();
                book.push();
                printerFrameWorkTitle(book, "安全生产行政执法文书", "当事人陈述申辩笔录", "");
                Paragraph paragraph1 = new ParagraphBuilder();
                paragraph1.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph1.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase1 = new Phrase();
                phrase1.add(new Chunk("时间", simfang2312_z5));
                phrase1.add(ChunkFactory.underLine(book.pushneedcheck(), 0, 31.5f, simfang2312_z5));
                phrase1.add(new Chunk("年", simfang2312_z5));
                phrase1.add(ChunkFactory.underLine(book.pushneedcheck(), 1, 15.75f, simfang2312_z5));
                phrase1.add(new Chunk("月", simfang2312_z5));
                phrase1.add(ChunkFactory.underLine(book.pushneedcheck(), 2, 21.0f, simfang2312_z5));
                phrase1.add(new Chunk("日", simfang2312_z5));
                phrase1.add(ChunkFactory.underLine(book.pushneedcheck(), 3, 21.0f, simfang2312_z5));
                phrase1.add(new Chunk("时", simfang2312_z5));
                phrase1.add(ChunkFactory.underLine(book.push(true), 4, 21.0f, simfang2312_z5));
                phrase1.add(new Chunk("分至", simfang2312_z5));
                phrase1.add(ChunkFactory.underLine(book.pushneedcheck(), 1, 26.25f, simfang2312_z5));
                phrase1.add(new Chunk("月", simfang2312_z5));
                phrase1.add(ChunkFactory.underLine(book.pushneedcheck(), 2, 26.25f, simfang2312_z5));
                phrase1.add(new Chunk("日", simfang2312_z5));
                phrase1.add(ChunkFactory.underLine(book.pushneedcheck(), 3, 21.0f, simfang2312_z5));
                phrase1.add(new Chunk("时", simfang2312_z5));
                phrase1.add(ChunkFactory.underLine(book.push(true), 4, 21.0f, simfang2312_z5));
                phrase1.add(new Chunk("分", simfang2312_z5));
                paragraph1.add(phrase1);
                document.add(paragraph1);
                Paragraph paragraph2 = new ParagraphBuilder();
                paragraph2.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph2.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase2 = new Phrase();
                phrase2.add(new Chunk("地点", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.push(), 393.75f, simfang2312_z5));
                paragraph2.add(phrase2);
                document.add(paragraph2);
                Paragraph paragraph3 = new ParagraphBuilder();
                paragraph3.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph3.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase3 = new Phrase();
                phrase3.add(new Chunk("陈述申辩人", simfang2312_z5));
                phrase3.add(ChunkFactory.underLine(book.push(), 89.25f, simfang2312_z5));
                phrase3.add(new Chunk("性别", simfang2312_z5));
                phrase3.add(ChunkFactory.underLine(book.push(), 52.5f, simfang2312_z5));
                phrase3.add(new Chunk("职务", simfang2312_z5));
                phrase3.add(ChunkFactory.underLine(book.push(), 178.5f, simfang2312_z5));
                paragraph3.add(phrase3);
                document.add(paragraph3);
                Paragraph paragraph4 = new ParagraphBuilder();
                paragraph4.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph4.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase4 = new Phrase();
                phrase4.add(new Chunk("工作单位", simfang2312_z5));
                phrase4.add(ChunkFactory.underLine(book.push(), 173.25f, simfang2312_z5));
                phrase4.add(new Chunk("电话", simfang2312_z5));
                phrase4.add(ChunkFactory.underLine(book.push(), 178.5f, simfang2312_z5));
                paragraph4.add(phrase4);
                document.add(paragraph4);
                Paragraph paragraph5 = new ParagraphBuilder();
                paragraph5.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph5.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase5 = new Phrase();
                phrase5.add(new Chunk("联系地址", simfang2312_z5));
                phrase5.add(ChunkFactory.underLine(book.push(), 178.5f, simfang2312_z5));
                phrase5.add(new Chunk("邮编", simfang2312_z5));
                phrase5.add(ChunkFactory.underLine(book.push(), 178.5f, simfang2312_z5));
                paragraph5.add(phrase5);
                document.add(paragraph5);
                Paragraph paragraph6 = new ParagraphBuilder();
                paragraph6.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph6.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase6 = new Phrase();
                phrase6.add(new Chunk("承办人", simfang2312_z5));
                phrase6.add(ChunkFactory.underLine(book.push(), 189.0f, simfang2312_z5));
                phrase6.add(new Chunk("记录人", simfang2312_z5));
                phrase6.add(ChunkFactory.underLine(book.push(), 162.75f, simfang2312_z5));
                paragraph6.add(phrase6);
                document.add(paragraph6);
                Paragraph paragraph7 = new ParagraphBuilder();
                paragraph7.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph7.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase7 = new Phrase();
                phrase7.add(new Chunk("我们是", simfang2312_z5));
                phrase7.add(ChunkFactory.underLine(book.push(), 42.0f, simfang2312_z5));
                phrase7.add(new Chunk("安全生产监督管理局的行政执法人员", simfang2312_z5));
                phrase7.add(ChunkFactory.underLine(book.push(), 47.25f, simfang2312_z5));
                phrase7.add(new Chunk("、", simfang2312_z5));
                phrase7.add(ChunkFactory.underLine(book.push(), 47.25f, simfang2312_z5));
                phrase7.add(new Chunk("，证件号码为", simfang2312_z5));
                phrase7.add(ChunkFactory.underLine(book.push(), 52.5f, simfang2312_z5));
                phrase7.add(new Chunk("、", simfang2312_z5));
                phrase7.add(ChunkFactory.underLine(book.push(), 52.5f, simfang2312_z5));
                phrase7.add(new Chunk("，这是我们的证件（出示证件）。现对", simfang2312_z5));
                phrase7.add(ChunkFactory.underLine(book.push(), 320f, simfang2312_z5, "为          、          ，这是我们的证件（出示证件）。现对", -1));
                phrase7.add(new Chunk("一案听取你（单位）的陈述申辩。", simfang2312_z5));
                paragraph7.add(phrase7);
                document.add(paragraph7);
                Paragraph paragraph9 = new ParagraphBuilder();
                paragraph9.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph9.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase9 = new Phrase();
                phrase9.add(new Chunk("陈述申辩记录:", simfang2312_z5));
                phrase9.add(ChunkFactory.underLine(book.push(), 2320.25f, simfang2312_z5, StringFactoryBuild.build().getStringLength("空格陈述申辩记录:", simfang2312_z5), -1));
                paragraph9.add(phrase9);
                document.add(paragraph9);
                Paragraph paragraph13 = new ParagraphBuilder();
                paragraph13.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph13.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase13 = new Phrase();
                phrase13.add(new Chunk("陈述申辩人（签名）：", simfang2312_z5));
                phrase13.add(ChunkFactory.underLine(book.push(), "                ", simfang2312_z5));
                paragraph13.add(phrase13);
                document.add(paragraph13);
                Paragraph paragraph14 = new ParagraphBuilder();
                paragraph14.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph14.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase14 = new Phrase();
                phrase14.add(new Chunk("承办人（签名）：", simfang2312_z5));
                phrase14.add(ChunkFactory.underLine(book.push(), "             ", simfang2312_z5));
                phrase14.add(ChunkFactory.nounderLine("", "   ", simfang2312_z5));
                phrase14.add(ChunkFactory.underLine(book.push(), "             ", simfang2312_z5));
                paragraph14.add(phrase14);
                document.add(paragraph14);
                Paragraph paragraph15 = new ParagraphBuilder();
                paragraph15.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph15.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase15 = new Phrase();
                phrase15.add(new Chunk("记录人（签名）：", simfang2312_z5));
                phrase15.add(ChunkFactory.underLine(book.push(), "             ", simfang2312_z5));
                paragraph15.add(phrase15);
                document.add(paragraph15);
                printerFrameWorkG4(book);
                printerFrameWorkPic(postmaskimage);
                document.newPage();// 结束保存
            }
        });

    }

    //行政处罚听证告知书
    protected void printerEntity_Book_2017_25(final Base_Entity book, final Object postmaskimage) {
        printerFrameWork(book, postmaskimage, new IPdfBackFrame() {
            @Override
            public void writeContent() throws Exception {
                //此处写页面布局
                book.push();
                book.push();
                book.push();
                printerFrameWorkTitle(book, "安全生产行政执法文书", "行政处罚听证告知书", "安监听告");
                Paragraph paragraph1 = new ParagraphBuilder();
                paragraph1.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph1.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase1 = new Phrase();
                phrase1.add(ChunkFactory.underLine(book.push(), 84.0f, simfang2312_z5));
                phrase1.add(new Chunk("：", simfang2312_z5));
                paragraph1.add(phrase1);
                document.add(paragraph1);
                Paragraph paragraph2 = new ParagraphBuilder();
                paragraph2.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph2.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase2 = new Phrase();
                phrase2.add(new Chunk("现查明，你（单位）存在下列行为：", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.push(), 700f, simfang2312_z5, "空格现查明，你（单位）存在下列行为：", -1));
                paragraph2.add(phrase2);
                document.add(paragraph2);

                Paragraph paragraph5 = new ParagraphBuilder();
                paragraph5.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph5.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase5 = new Phrase();
                phrase5.add(new Chunk("以上事实主要证据如下：", simfang2312_z5));
                phrase5.add(ChunkFactory.underLine(book.push(), 572.75f, simfang2312_z5, "空格以上事实主要证据如下：", -1));
                paragraph5.add(phrase5);
                document.add(paragraph5);

                Paragraph paragraph7 = new ParagraphBuilder();
                paragraph7.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph7.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase7 = new Phrase();
                phrase7.add(new Chunk("以上行为违反了", simfang2312_z5));
                phrase7.add(ChunkFactory.underLine(book.push(), 734.5f, simfang2312_z5, "空格以上行为违反了", -1));
                phrase7.add(new Chunk("的规定，依据", simfang2312_z5));
                phrase7.add(ChunkFactory.underLine(book.push(), 236.25f, simfang2312_z5));
                phrase7.add(new Chunk("的规定，拟对你（单位）作出", simfang2312_z5));
                phrase7.add(ChunkFactory.underLine(book.push(), 283.5f, simfang2312_z5));
                phrase7.add(new Chunk("的行政处罚。", simfang2312_z5));
                paragraph7.add(phrase7);
                document.add(paragraph7);

                Paragraph paragraph10 = new ParagraphBuilder();
                paragraph10.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph10.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase10 = new Phrase();
                phrase10.add(new Chunk("根据《中华人民共和国行政处罚法》第四十二条的规定，你（单位）有要求举行听证的权利。如你（单位）要求举行听证，请在接到本告知书之日起3日内向", simfang2312_z5));
                phrase10.add(ChunkFactory.underLine(book.push(), 57.75f, simfang2312_z5));
                phrase10.add(new Chunk("安全生产监督管理部门提出书面听证申请。逾期不提出申请的，视为放弃听证权利。", simfang2312_z5));
                paragraph10.add(phrase10);
                document.add(paragraph10);
                Paragraph paragraph11 = new ParagraphBuilder();
                paragraph11.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph11.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase11 = new Phrase();
                phrase11.add(new Chunk("特此告知。", simfang2312_z5));
                paragraph11.add(phrase11);
                document.add(paragraph11);
                Paragraph paragraph12 = new ParagraphBuilder();
                paragraph12.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph12.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase12 = new Phrase();
                paragraph12.add(phrase12);
                document.add(paragraph12);
                Paragraph paragraph13 = new ParagraphBuilder();
                paragraph13.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph13.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase13 = new Phrase();
                paragraph13.add(phrase13);
                document.add(paragraph13);
                Paragraph paragraph14 = new ParagraphBuilder();
                paragraph14.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph14.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase14 = new Phrase();
                paragraph14.add(phrase14);
                document.add(paragraph14);
                Paragraph paragraph15 = new ParagraphBuilder();
                paragraph15.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph15.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase15 = new Phrase();
                phrase15.add(new Chunk("安全生产监督管理部门地址：", simfang2312_z5));
                phrase15.add(ChunkFactory.underLine(book.push(), 231.0f, simfang2312_z5));
                paragraph15.add(phrase15);
                document.add(paragraph15);
                Paragraph paragraph16 = new ParagraphBuilder();
                paragraph16.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph16.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase16 = new Phrase();
                phrase16.add(new Chunk("联系人：", simfang2312_z5));
                phrase16.add(ChunkFactory.underLine(book.push(), 78.75f, simfang2312_z5));
                phrase16.add(new Chunk("联系电话：", simfang2312_z5));
                phrase16.add(ChunkFactory.underLine(book.push(), 63.0f, simfang2312_z5));
                phrase16.add(new Chunk("邮政编码：", simfang2312_z5));
                phrase16.add(ChunkFactory.underLine(book.push(), 78.75f, simfang2312_z5));
                paragraph16.add(phrase16);
                document.add(paragraph16);
                printerFrameWorkG1(book);
                printerFrameWorkPic(postmaskimage);
                document.newPage();// 结束保存

            }
        });

    }

    //行政处罚听证会通知书
    protected void printerEntity_Book_2017_26(final Base_Entity book, final Object postmaskimage) {
        printerFrameWork(book, postmaskimage, new IPdfBackFrame() {
            @Override
            public void writeContent() throws Exception {
                //此处写页面布局
                book.push();
                book.push();
                book.push();
                printerFrameWorkTitle(book, "安全生产行政执法文书", "行政处罚听证会通知书", "安监听通");
                Paragraph paragraph1 = new ParagraphBuilder();
                paragraph1.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph1.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase1 = new Phrase();
                phrase1.add(ChunkFactory.underLine(book.push(), 94.5f, simfang2312_z5));
                phrase1.add(new Chunk("：", simfang2312_z5));
                paragraph1.add(phrase1);
                document.add(paragraph1);
                Paragraph paragraph2 = new ParagraphBuilder();
                paragraph2.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph2.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase2 = new Phrase();
                phrase2.add(new Chunk("根据你（单位）申请，关于", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.push(), 236.25f, simfang2312_z5));
                phrase2.add(new Chunk("一案，现定于", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.pushneedcheck(), 0, 31.5f, simfang2312_z5));
                phrase2.add(new Chunk("年", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.pushneedcheck(), 1, 26.25f, simfang2312_z5));
                phrase2.add(new Chunk("月", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.pushneedcheck(), 2, 21.0f, simfang2312_z5));
                phrase2.add(new Chunk("日", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.pushneedcheck(), 3, 21.0f, simfang2312_z5));
                phrase2.add(new Chunk("时", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.push(true), 4, 15.75f, simfang2312_z5));
                phrase2.add(new Chunk("分在", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.push(), 141.75f, simfang2312_z5));
                phrase2.add(new Chunk("（公开、不公开）举行听证会议，请准时出席。", simfang2312_z5));
                paragraph2.add(phrase2);
                document.add(paragraph2);
                Paragraph paragraph3 = new ParagraphBuilder();
                paragraph3.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph3.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase3 = new Phrase();
                phrase3.add(new Chunk("听证主持人姓名", simfang2312_z5));
                phrase3.add(ChunkFactory.underLine(book.push(), 47.25f, simfang2312_z5));
                phrase3.add(new Chunk("职务", simfang2312_z5));
                phrase3.add(ChunkFactory.underLine(book.push(), 267.75f, simfang2312_z5));
                paragraph3.add(phrase3);
                document.add(paragraph3);
                Paragraph paragraph4 = new ParagraphBuilder();
                paragraph4.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph4.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase4 = new Phrase();
                phrase4.add(new Chunk("听证员姓名", simfang2312_z5));
                phrase4.add(ChunkFactory.underLine(book.push(), 68.25f, simfang2312_z5));
                phrase4.add(new Chunk("职务", simfang2312_z5));
                phrase4.add(ChunkFactory.underLine(book.push(), 267.75f, simfang2312_z5));
                paragraph4.add(phrase4);
                document.add(paragraph4);
                Paragraph paragraph5 = new ParagraphBuilder();
                paragraph5.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph5.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase5 = new Phrase();
                phrase5.add(new Chunk("听证员姓名", simfang2312_z5));
                phrase5.add(ChunkFactory.underLine(book.push(), 68.25f, simfang2312_z5));
                phrase5.add(new Chunk("职务", simfang2312_z5));
                phrase5.add(ChunkFactory.underLine(book.push(), 267.75f, simfang2312_z5));
                paragraph5.add(phrase5);
                document.add(paragraph5);
                Paragraph paragraph6 = new ParagraphBuilder();
                paragraph6.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph6.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase6 = new Phrase();
                phrase6.add(new Chunk("书记员姓名", simfang2312_z5));
                phrase6.add(ChunkFactory.underLine(book.push(), 68.25f, simfang2312_z5));
                phrase6.add(new Chunk("职务", simfang2312_z5));
                phrase6.add(ChunkFactory.underLine(book.push(), 267.75f, simfang2312_z5));
                paragraph6.add(phrase6);
                document.add(paragraph6);
                Paragraph paragraph7 = new ParagraphBuilder();
                paragraph7.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph7.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase7 = new Phrase();
                phrase7.add(new Chunk("根据《中华人民共和国行政处罚法》第四十二条的规定，你（单位）可以申请听证主持人回避。", simfang2312_z5));
                paragraph7.add(phrase7);
                document.add(paragraph7);
                Paragraph paragraph8 = new ParagraphBuilder();
                paragraph8.setLeading(simfang2312_z5.getSize() * 1.5f);
                paragraph8.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase8 = new Phrase();
                phrase8.add(new Chunk("注意事项：", simfang2312_z5));
                paragraph8.add(phrase8);
                document.add(paragraph8);
                Paragraph paragraph9 = new ParagraphBuilder();
                paragraph9.setLeading(simfang2312_z5.getSize() * 1.5f);
                paragraph9.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase9 = new Phrase();
                phrase9.add(new Chunk("1.请事先准备相关证据，通知证人和委托代理人准时参加。", simfang2312_z5));
                paragraph9.add(phrase9);
                document.add(paragraph9);
                Paragraph paragraph10 = new ParagraphBuilder();
                paragraph10.setLeading(simfang2312_z5.getSize() * 1.5f);
                paragraph10.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase10 = new Phrase();
                phrase10.add(new Chunk("2.委托代理人参加听证的，应当在听证会前向本机关提交授权委托书等有关证明。", simfang2312_z5));
                paragraph10.add(phrase10);
                document.add(paragraph10);
                Paragraph paragraph11 = new ParagraphBuilder();
                paragraph11.setLeading(simfang2312_z5.getSize() * 1.5f);
                paragraph11.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase11 = new Phrase();
                phrase11.add(new Chunk("3.申请延期举行的，应当在举行听证会前向本机关提出，由本机关决定是否延期。", simfang2312_z5));
                paragraph11.add(phrase11);
                document.add(paragraph11);
                Paragraph paragraph12 = new ParagraphBuilder();
                paragraph12.setLeading(simfang2312_z5.getSize() * 1.5f);
                paragraph12.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase12 = new Phrase();
                phrase12.add(new Chunk("4.不按时参加听证会且未事先说明理由的，视为放弃听证权利。", simfang2312_z5));
                paragraph12.add(phrase12);
                document.add(paragraph12);
                Paragraph paragraph13 = new ParagraphBuilder();
                paragraph13.setLeading(simfang2312_z5.getSize() * 1.5f);
                paragraph13.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase13 = new Phrase();
                phrase13.add(new Chunk("特此通知。", simfang2312_z5));
                paragraph13.add(phrase13);
                document.add(paragraph13);
                printerFrameWorkG2(book);
                Paragraph paragraph14 = new ParagraphBuilder();
                paragraph14.setLeading(simfang2312_z5.getSize() * 1.5f);
//                paragraph14.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase14 = new Phrase();
                phrase14.add(new Chunk("安全生产监督管理部门地址：", simfang2312_z5));
                phrase14.add(ChunkFactory.nounderLine(book.push(), 257.25f, simfang2312_z5));
                paragraph14.add(phrase14);
                document.add(paragraph14);
                Paragraph paragraph15 = new ParagraphBuilder();
                paragraph15.setLeading(simfang2312_z5.getSize() * 1.5f);
//                paragraph15.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase15 = new Phrase();
                phrase15.add(new Chunk("邮政编码：", simfang2312_z5));
                phrase15.add(ChunkFactory.nounderLine(book.push(), 341.25f, simfang2312_z5));
                paragraph15.add(phrase15);
                document.add(paragraph15);
                Paragraph paragraph16 = new ParagraphBuilder();
                paragraph16.setLeading(simfang2312_z5.getSize() * 1.5f);
//                paragraph16.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase16 = new Phrase();
                phrase16.add(new Chunk("联系人：", simfang2312_z5));
                phrase16.add(ChunkFactory.nounderLine(book.push(), 351.75f, simfang2312_z5));
                paragraph16.add(phrase16);
                document.add(paragraph16);
                Paragraph paragraph17 = new ParagraphBuilder();
                paragraph17.setLeading(simfang2312_z5.getSize() * 1.5f);
//                paragraph17.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase17 = new Phrase();
                phrase17.add(new Chunk("联系电话：", simfang2312_z5));
                phrase17.add(ChunkFactory.nounderLine(book.push(), 341.25f, simfang2312_z5));
                paragraph17.add(phrase17);
                document.add(paragraph17);
                printerFrameWorkG3(book);
                printerFrameWorkPic(postmaskimage);
                document.newPage();// 结束保存
            }
        });

    }

    //听证笔录
    protected void printerEntity_Book_2017_27(final Base_Entity book, final Object postmaskimage) {
        printerFrameWork(book, postmaskimage, new IPdfBackFrame() {
            @Override
            public void writeContent() throws Exception {
                //此处写页面布局
                book.push();
                book.push();
                book.push();
                printerFrameWorkTitle(book, "安全生产行政执法文书", "听证笔录", "");
                Paragraph paragraph1 = new ParagraphBuilder();
                paragraph1.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph1.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase1 = new Phrase();
                phrase1.add(new Chunk("案件名称", simfang2312_z5));
                phrase1.add(ChunkFactory.underLine(book.push(), 372.75f, simfang2312_z5));
                paragraph1.add(phrase1);
                document.add(paragraph1);
                Paragraph paragraph2 = new ParagraphBuilder();
                paragraph2.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph2.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase2 = new Phrase();
                phrase2.add(new Chunk("主持听证机关", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.push(), 105.0f, simfang2312_z5));
                phrase2.add(new Chunk("地点", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.push(), 220.5f, simfang2312_z5));
                paragraph2.add(phrase2);
                document.add(paragraph2);
                Paragraph paragraph3 = new ParagraphBuilder();
                paragraph3.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph3.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase3 = new Phrase();
                phrase3.add(new Chunk("听证时间", simfang2312_z5));
                phrase3.add(ChunkFactory.underLine(book.pushneedcheck(), 0, 36.75f, simfang2312_z5));
                phrase3.add(new Chunk("年", simfang2312_z5));
                phrase3.add(ChunkFactory.underLine(book.pushneedcheck(), 1, 10.5f, simfang2312_z5));
                phrase3.add(new Chunk("月", simfang2312_z5));
                phrase3.add(ChunkFactory.underLine(book.pushneedcheck(), 2, 15.75f, simfang2312_z5));
                phrase3.add(new Chunk("日", simfang2312_z5));
                phrase3.add(ChunkFactory.underLine(book.pushneedcheck(), 3, 15.75f, simfang2312_z5));
                phrase3.add(new Chunk("时", simfang2312_z5));
                phrase3.add(ChunkFactory.underLine(book.push(true), 4, 15.75f, simfang2312_z5));
                phrase3.add(new Chunk("分至", simfang2312_z5));
                phrase3.add(ChunkFactory.underLine(book.pushneedcheck(), 0, 26.25f, simfang2312_z5));
                phrase3.add(new Chunk("年", simfang2312_z5));
                phrase3.add(ChunkFactory.underLine(book.pushneedcheck(), 1, 10.5f, simfang2312_z5));
                phrase3.add(new Chunk("月", simfang2312_z5));
                phrase3.add(ChunkFactory.underLine(book.pushneedcheck(), 2, 15.75f, simfang2312_z5));
                phrase3.add(new Chunk("日", simfang2312_z5));
                phrase3.add(ChunkFactory.underLine(book.pushneedcheck(), 3, 15.75f, simfang2312_z5));
                phrase3.add(new Chunk("时", simfang2312_z5));
                phrase3.add(ChunkFactory.underLine(book.push(true), 4, 15.75f, simfang2312_z5));
                phrase3.add(new Chunk("分", simfang2312_z5));
                paragraph3.add(phrase3);
                document.add(paragraph3);
                Paragraph paragraph4 = new ParagraphBuilder();
                paragraph4.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph4.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase4 = new Phrase();
                phrase4.add(new Chunk("主持人", simfang2312_z5));
                phrase4.add(ChunkFactory.underLine(book.push(), 84.0f, simfang2312_z5));
                phrase4.add(new Chunk("听证员", simfang2312_z5));
                phrase4.add(ChunkFactory.underLine(book.push(), 115.5f, simfang2312_z5));
                phrase4.add(new Chunk("书记员", simfang2312_z5));
                phrase4.add(ChunkFactory.underLine(book.push(), 110.25f, simfang2312_z5));
                paragraph4.add(phrase4);
                document.add(paragraph4);
                Paragraph paragraph5 = new ParagraphBuilder();
                paragraph5.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph5.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase5 = new Phrase();
                phrase5.add(new Chunk("调查人员", simfang2312_z5));
                phrase5.add(ChunkFactory.underLine(book.push(), 57.75f, simfang2312_z5));
                phrase5.add(new Chunk("证号", simfang2312_z5));
                phrase5.add(ChunkFactory.underLine(book.push(), 57.75f, simfang2312_z5));
                phrase5.add(new Chunk("调查人员", simfang2312_z5));
                phrase5.add(ChunkFactory.underLine(book.push(), 68.25f, simfang2312_z5));
                phrase5.add(new Chunk("证号", simfang2312_z5));
                phrase5.add(ChunkFactory.underLine(book.push(), "13304214650", simfang2312_z5));
                paragraph5.add(phrase5);
                document.add(paragraph5);
                Paragraph paragraph6 = new ParagraphBuilder();
                paragraph6.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph6.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase6 = new Phrase();
                phrase6.add(new Chunk("申请听证人（个人）姓名", simfang2312_z5));
                phrase6.add(ChunkFactory.underLine(book.push(), "测试人人", simfang2312_z5));
                phrase6.add(new Chunk("性别", simfang2312_z5));
                phrase6.add(ChunkFactory.underLine(book.push(), 36.75f, simfang2312_z5));
                phrase6.add(new Chunk("年龄", simfang2312_z5));
                phrase6.add(ChunkFactory.underLine(book.push(), 26.25f, simfang2312_z5));
                phrase6.add(new Chunk("工作单位（职务）", simfang2312_z5));
                phrase6.add(ChunkFactory.underLine(book.push(), "安全保护人员", simfang2312_z5));
                paragraph6.add(phrase6);
                document.add(paragraph6);
                Paragraph paragraph7 = new ParagraphBuilder();
                paragraph7.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph7.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase7 = new Phrase();
                phrase7.add(new Chunk("申请听证人（单位）名称", simfang2312_z5));
                phrase7.add(ChunkFactory.underLine(book.push(), 294.0f, simfang2312_z5));
                paragraph7.add(phrase7);
                document.add(paragraph7);
                Paragraph paragraph8 = new ParagraphBuilder();
                paragraph8.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph8.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase8 = new Phrase();
                phrase8.add(new Chunk("法定代表人/负责人", simfang2312_z5));
                phrase8.add(ChunkFactory.underLine(book.push(), 36.75f, simfang2312_z5));
                phrase8.add(new Chunk("性别", simfang2312_z5));
                phrase8.add(ChunkFactory.underLine(book.push(), 26.25f, simfang2312_z5));
                phrase8.add(new Chunk("年龄", simfang2312_z5));
                phrase8.add(ChunkFactory.underLine(book.push(), 26.25f, simfang2312_z5));
                phrase8.add(new Chunk("职务", simfang2312_z5));
                phrase8.add(ChunkFactory.underLine(book.push(), 36.75f, simfang2312_z5));
                paragraph8.add(phrase8);
                document.add(paragraph8);
                Paragraph paragraph9 = new ParagraphBuilder();
                paragraph9.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph9.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase9 = new Phrase();
                phrase9.add(new Chunk("委托代理人", simfang2312_z5));
                phrase9.add(ChunkFactory.underLine(book.push(), 36.75f, simfang2312_z5));
                phrase9.add(new Chunk("性别", simfang2312_z5));
                phrase9.add(ChunkFactory.underLine(book.push(), 21.0f, simfang2312_z5));
                phrase9.add(new Chunk("年龄", simfang2312_z5));
                phrase9.add(ChunkFactory.underLine(book.push(), 21.0f, simfang2312_z5));
                phrase9.add(new Chunk("工作单位（职务）", simfang2312_z5));
                phrase9.add(ChunkFactory.underLine(book.push(), 147.0f, simfang2312_z5));
                paragraph9.add(phrase9);
                document.add(paragraph9);
                Paragraph paragraph10 = new ParagraphBuilder();
                paragraph10.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph10.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase10 = new Phrase();
                phrase10.add(new Chunk("委托代理人", simfang2312_z5));
                phrase10.add(ChunkFactory.underLine(book.push(), 36.75f, simfang2312_z5));
                phrase10.add(new Chunk("性别", simfang2312_z5));
                phrase10.add(ChunkFactory.underLine(book.push(), 21.0f, simfang2312_z5));
                phrase10.add(new Chunk("年龄", simfang2312_z5));
                phrase10.add(ChunkFactory.underLine(book.push(), 21.0f, simfang2312_z5));
                phrase10.add(new Chunk("工作单位（职务）", simfang2312_z5));
                phrase10.add(ChunkFactory.underLine(book.push(), 147.0f, simfang2312_z5));
                paragraph10.add(phrase10);
                document.add(paragraph10);
                Paragraph paragraph11 = new ParagraphBuilder();
                paragraph11.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph11.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase11 = new Phrase();
                phrase11.add(new Chunk("第三人", simfang2312_z5));
                phrase11.add(ChunkFactory.underLine(book.push(), 372.75f, simfang2312_z5));
                paragraph11.add(phrase11);
                document.add(paragraph11);
                Paragraph paragraph12 = new ParagraphBuilder();
                paragraph12.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph12.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase12 = new Phrase();
                phrase12.add(new Chunk("其他参与人员", simfang2312_z5));
                phrase12.add(ChunkFactory.underLine(book.push(), 341.25f, simfang2312_z5));
                paragraph12.add(phrase12);
                document.add(paragraph12);
                Paragraph paragraph13 = new ParagraphBuilder();
                paragraph13.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph13.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase13 = new Phrase();
                phrase13.add(new Chunk("听证记录：", simfang2312_z5));
                phrase13.add(ChunkFactory.underLine(book.push(), 130.75f + 430 * 3, simfang2312_z5, "空格听证记录：", -1));
                paragraph13.add(phrase13);
                document.add(paragraph13);
                Paragraph paragraph19 = new ParagraphBuilder();
                paragraph19.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph19.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase19 = new Phrase();
                phrase19.add(new Chunk("申请听证人或者其委托代理人（签名）：", simfang2312_z5));
                phrase19.add(ChunkFactory.nounderLine(book.push(), 42.0f, simfang2312_z5));
                paragraph19.add(phrase19);
                document.add(paragraph19);
                Paragraph paragraph20 = new ParagraphBuilder();
                paragraph20.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph20.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase20 = new Phrase();
                phrase20.add(new Chunk("主持人（签名）：", simfang2312_z5));
                phrase20.add(ChunkFactory.nounderLine(book.push(), 42.0f, simfang2312_z5));
                phrase20.add(new Chunk("听证员（签名）：", simfang2312_z5));
                phrase20.add(ChunkFactory.nounderLine(book.push(), 47.25f, simfang2312_z5));
                phrase20.add(new Chunk("书记员（签名）：", simfang2312_z5));
                phrase20.add(ChunkFactory.nounderLine(book.push(), 78.75f, simfang2312_z5));
                paragraph20.add(phrase20);
                document.add(paragraph20);
                printerFrameWorkG3(book);
                printerFrameWorkPic(postmaskimage);
                document.newPage();// 结束保存
            }
        });

    }

    //听证会报告书
    protected void printerEntity_Book_2017_28(final Base_Entity book, final Object postmaskimage) {
        printerFrameWork(book, postmaskimage, new IPdfBackFrame() {
            @Override
            public void writeContent() throws Exception {
                //此处写页面布局
                book.push();
                book.push();
                book.push();
                printerFrameWorkTitle(book, "安全生产行政执法文书", "听证会报告书", "安监听报");
                Paragraph paragraph1 = new ParagraphBuilder();
                paragraph1.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph1.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase1 = new Phrase();
                phrase1.add(new Chunk("案件名称：", simfang2312_z5));
                phrase1.add(ChunkFactory.underLine(book.push(), 357.0f, simfang2312_z5));
                paragraph1.add(phrase1);
                document.add(paragraph1);
                document.add(space3);
                PdfPTable table = null;
                float[] widths = new float[6];
                widths[0] = 1f;
                widths[1] = 1f;
                widths[2] = 1f;
                widths[3] = 1f;
                widths[4] = 1f;
                widths[5] = 1f;
                widths[0] = 1262.0f;
                widths[1] = 1006.0f;
                widths[2] = 1080.0f;
                widths[3] = 2880.0f;
                widths[4] = 1080.0f;
                widths[5] = 1260.0f;
                table = new PdfPTable(6);
                table.setWidthPercentage(100f);
                table.setWidths(widths);
                PdfPCell cell_0 = new PdfPCellBuilder(new ParagraphBuilder("主持人", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_0.setFixedHeight(28.838385f);
                table.addCell(cell_0);
                PdfPCell cell_1 = new PdfPCellBuilder(new ParagraphBuilder(book.push(), simfang2312_z5));
                cell_1.setFixedHeight(28.838385f);
                table.addCell(cell_1);
                PdfPCell cell_2 = new PdfPCellBuilder(new ParagraphBuilder("听证员", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_2.setFixedHeight(28.838385f);
                table.addCell(cell_2);
                PdfPCell cell_3 = new PdfPCellBuilder(new ParagraphBuilder(book.push(), simfang2312_z5));
                cell_3.setFixedHeight(28.838385f);
                table.addCell(cell_3);
                PdfPCell cell_4 = new PdfPCellBuilder(new ParagraphBuilder("书记员", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_4.setFixedHeight(28.838385f);
                table.addCell(cell_4);
                PdfPCell cell_5 = new PdfPCellBuilder(new ParagraphBuilder(book.push(), simfang2312_z5));
                cell_5.setFixedHeight(28.838385f);
                table.addCell(cell_5);
                Paragraph paragraph2 = new ParagraphBuilder();
                paragraph2.setLeading(simfang2312_z5.getSize() * 1.5f);
//                paragraph2.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase2 = new Phrase();
                phrase2.add(new Chunk("听证会基本情况摘要：（详见听证会笔录，笔录附后）", simfang2312_z5));
                phrase2.add(ChunkFactory.tablenounderLine(book.push(), StringFactoryBuild.build().getStringLength("                                                                               ", simfang2312_z5) * 5, simfang2312_z5, "听证会基本情况摘要：（详见听证会笔录，笔录附后）", "                                                                               "));
                paragraph2.add(phrase2);
                PdfPCell cell_6 = new PdfPCellBuilder();
                cell_6.addElement(paragraph2);
                cell_6.setColspan(6);
                cell_6.setFixedHeight(204.89899f);
                table.addCell(cell_6);
                PdfPCell cell_7 = new PdfPCellBuilder(new ParagraphBuilder("主持人\n" +
                        "意见\n", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_7.setFixedHeight(88.93939f);
                table.addCell(cell_7);
                Paragraph paragraph3 = new ParagraphBuilder();
                paragraph3.setLeading(simfang2312_z5.getSize() * 1.5f);
//                paragraph3.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase3 = new Phrase();
                phrase3.add(ChunkFactory.tablenounderLine(book.push(), 810.0f, simfang2312_z5, "", "                                                                   "));
                paragraph3.add(phrase3);
                Paragraph paragraph7 = new ParagraphBuilder();
                paragraph7.setLeading(simfang2312_z5.getSize() * 1.5f);
//                paragraph7.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase7 = new Phrase();
                phrase7.add(ChunkFactory.tablenounderLine("", 210.0f, simfang2312_z5));
                phrase7.add(new Chunk("主持人（签名）：", simfang2312_z5));
                phrase7.add(ChunkFactory.tablenounderLine(book.push(), 60.75f - 15.75f, simfang2312_z5));
                paragraph7.add(phrase7);
                Paragraph paragraph8 = new ParagraphBuilder();
                paragraph8.setLeading(simfang2312_z5.getSize() * 1.5f);
//                paragraph8.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase8 = new Phrase();
                phrase8.add(ChunkFactory.tablenounderLine("", 288.75f - 15.75f, simfang2312_z5));
                phrase8.add(ChunkFactory.tablenounderLine(book.pushneedcheck(), 0, 15.75f, simfang2312_z5));
                phrase8.add(new Chunk("年", simfang2312_z5));
                phrase8.add(ChunkFactory.tablenounderLine(book.pushneedcheck(), 1, 15.75f, simfang2312_z5));
                phrase8.add(new Chunk("月", simfang2312_z5));
                phrase8.add(ChunkFactory.tablenounderLine(book.push(true), 2, 15.75f, simfang2312_z5));
                phrase8.add(new Chunk("日", simfang2312_z5));
                paragraph8.add(phrase8);
                PdfPCell cell_8 = new PdfPCellBuilder();
                cell_8.addElement(paragraph3);
                cell_8.addElement(paragraph7);
                cell_8.addElement(paragraph8);
                cell_8.setColspan(5);
                cell_8.setFixedHeight(88.93939f);
                table.addCell(cell_8);
                PdfPCell cell_9 = new PdfPCellBuilder(new ParagraphBuilder("负责人\n" +
                        "审核意见\n", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_9.setFixedHeight(88.969696f);
                table.addCell(cell_9);
                Paragraph paragraph9 = new ParagraphBuilder();
                paragraph9.setLeading(simfang2312_z5.getSize() * 1.5f);
//                paragraph9.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase9 = new Phrase();
                phrase9.add(ChunkFactory.tablenounderLine(book.push(), 810.0f, simfang2312_z5, "", "                                                                   "));
                paragraph9.add(phrase9);
                Paragraph paragraph14 = new ParagraphBuilder();
                paragraph14.setLeading(simfang2312_z5.getSize() * 1.5f);
//                paragraph14.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase14 = new Phrase();
                phrase14.add(ChunkFactory.tablenounderLine("", 210.0f, simfang2312_z5));
                phrase14.add(new Chunk("负责人（签名）：", simfang2312_z5));
                phrase14.add(ChunkFactory.tablenounderLine(book.push(), 60.75f - 15.75f, simfang2312_z5));
                paragraph14.add(phrase14);
                Paragraph paragraph15 = new ParagraphBuilder();
                paragraph15.setLeading(simfang2312_z5.getSize() * 1.5f);
//                paragraph15.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase15 = new Phrase();
                phrase15.add(ChunkFactory.tablenounderLine("", 288.75f - 15.75f, simfang2312_z5));
                phrase15.add(ChunkFactory.tablenounderLine(book.pushneedcheck(), 0, 15.75f, simfang2312_z5));
                phrase15.add(new Chunk("年", simfang2312_z5));
                phrase15.add(ChunkFactory.tablenounderLine(book.pushneedcheck(), 1, 15.75f, simfang2312_z5));
                phrase15.add(new Chunk("月", simfang2312_z5));
                phrase15.add(ChunkFactory.tablenounderLine(book.push(true), 2, 15.75f, simfang2312_z5));
                phrase15.add(new Chunk("日", simfang2312_z5));
                paragraph15.add(phrase15);
                PdfPCell cell_10 = new PdfPCellBuilder();
                cell_10.addElement(paragraph9);
                cell_10.addElement(paragraph14);
                cell_10.addElement(paragraph15);
                cell_10.setColspan(5);
                cell_10.setFixedHeight(88.969696f);
                table.addCell(cell_10);
                document.add(table);
                printerFrameWorkPic(postmaskimage);
                document.newPage();
            }
        });

    }

    //案件处理呈批表
    protected void printerEntity_Book_2017_29(final Base_Entity book, final Object postmaskimage) {
        printerFrameWork(book, postmaskimage, new IPdfBackFrame() {
            @Override
            public void writeContent() throws Exception {
                //此处写页面布局
                book.push();
                book.push();
                book.push();
                printerFrameWorkTitle(book, "安全生产行政执法文书", "案件处理呈批表", "安监处呈");
                Paragraph paragraph1 = new ParagraphBuilder();
                paragraph1.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph1.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase1 = new Phrase();
                phrase1.add(new Chunk("案件名称：", simfang2312_z5));
                phrase1.add(ChunkFactory.underLine(book.push(), 362.25f, simfang2312_z5));
                paragraph1.add(phrase1);
                document.add(paragraph1);
                document.add(space3);
                PdfPTable table = null;
                float[] widths = new float[9];
                widths[0] = 42f;
                widths[1] = 114f;
                widths[2] = 90f;
                widths[3] = 23f;
                widths[4] = 23f;
                widths[5] = 46f;
                widths[6] = 76f;
                widths[7] = 42f;
                widths[8] = 65f;
                table = new PdfPTable(9);
                table.setWidthPercentage(100f);
                table.setWidths(widths);
                PdfPCell cell_0 = new PdfPCellBuilder(new ParagraphBuilder("当事人基本情况", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_0.setRowspan(5);
                cell_0.setFixedHeight(28f);
                table.addCell(cell_0);
                PdfPCell cell_1 = new PdfPCellBuilder(new ParagraphBuilder("被处罚单位", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_1.setFixedHeight(28f);
                table.addCell(cell_1);
                PdfPCell cell_2 = new PdfPCellBuilder(new ParagraphBuilder(book.push(), simfang2312_z5));
                cell_2.setColspan(2);
                cell_2.setFixedHeight(28f);
                table.addCell(cell_2);
                PdfPCell cell_3 = new PdfPCellBuilder(new ParagraphBuilder("地址", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_3.setColspan(2);
                cell_3.setFixedHeight(28f);
                table.addCell(cell_3);
                PdfPCell cell_4 = new PdfPCellBuilder(new ParagraphBuilder(book.push(), simfang2312_z5));
                cell_4.setColspan(3);
                cell_4.setFixedHeight(28f);
                table.addCell(cell_4);
                PdfPCell cell_5 = new PdfPCellBuilder(new ParagraphBuilder("法定代表人/负责人", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_5.setFixedHeight(28f);
                table.addCell(cell_5);
                PdfPCell cell_6 = new PdfPCellBuilder(new ParagraphBuilder(book.push(), simfang2312_z5));
                cell_6.setColspan(2);
                cell_6.setFixedHeight(28f);
                table.addCell(cell_6);
                PdfPCell cell_7 = new PdfPCellBuilder(new ParagraphBuilder("职务", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_7.setColspan(2);
                cell_7.setFixedHeight(28f);
                table.addCell(cell_7);
                PdfPCell cell_8 = new PdfPCellBuilder(new ParagraphBuilder(book.push(), simfang2312_z5));
                cell_8.setFixedHeight(28f);
                table.addCell(cell_8);
                PdfPCell cell_9 = new PdfPCellBuilder(new ParagraphBuilder("邮编", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_9.setFixedHeight(28f);
                table.addCell(cell_9);
                PdfPCell cell_10 = new PdfPCellBuilder(new ParagraphBuilder(book.push(), simfang2312_z5));
                cell_10.setFixedHeight(28f);
                table.addCell(cell_10);
                PdfPCell cell_11 = new PdfPCellBuilder(new ParagraphBuilder("被处罚人", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_11.setFixedHeight(28f);
                table.addCell(cell_11);
                PdfPCell cell_12 = new PdfPCellBuilder(new ParagraphBuilder(book.push(), simfang2312_z5));
                cell_12.setColspan(2);
                cell_12.setFixedHeight(28f);
                table.addCell(cell_12);
                PdfPCell cell_13 = new PdfPCellBuilder(new ParagraphBuilder("年龄", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_13.setColspan(2);
                cell_13.setFixedHeight(28f);
                table.addCell(cell_13);
                PdfPCell cell_14 = new PdfPCellBuilder(new ParagraphBuilder(book.push(), simfang2312_z5));
                cell_14.setFixedHeight(28f);
                table.addCell(cell_14);
                PdfPCell cell_15 = new PdfPCellBuilder(new ParagraphBuilder("性别", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_15.setFixedHeight(28f);
                table.addCell(cell_15);
                PdfPCell cell_16 = new PdfPCellBuilder(new ParagraphBuilder(book.push(), simfang2312_z5));
                cell_16.setFixedHeight(28f);
                table.addCell(cell_16);
                PdfPCell cell_17 = new PdfPCellBuilder(new ParagraphBuilder("所在单位", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_17.setFixedHeight(28f);
                table.addCell(cell_17);
                PdfPCell cell_18 = new PdfPCellBuilder(new ParagraphBuilder(book.push(), simfang2312_z5));
                cell_18.setColspan(2);
                cell_18.setFixedHeight(28f);
                table.addCell(cell_18);
                PdfPCell cell_19 = new PdfPCellBuilder(new ParagraphBuilder("单位地址", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_19.setColspan(2);
                cell_19.setFixedHeight(28f);
                table.addCell(cell_19);
                PdfPCell cell_20 = new PdfPCellBuilder(new ParagraphBuilder(book.push(), simfang2312_z5));
                cell_20.setColspan(3);
                cell_20.setFixedHeight(28f);
                table.addCell(cell_20);
                PdfPCell cell_21 = new PdfPCellBuilder(new ParagraphBuilder("家庭住址", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_21.setFixedHeight(28f);
                table.addCell(cell_21);
                PdfPCell cell_22 = new PdfPCellBuilder(new ParagraphBuilder(book.push(), simfang2312_z5));
                cell_22.setColspan(2);
                cell_22.setFixedHeight(28f);
                table.addCell(cell_22);
                PdfPCell cell_23 = new PdfPCellBuilder(new ParagraphBuilder("联系电话", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_23.setColspan(2);
                cell_23.setFixedHeight(28f);
                table.addCell(cell_23);
                PdfPCell cell_24 = new PdfPCellBuilder(new ParagraphBuilder(book.push(), simfang2312_z5));
                cell_24.setFixedHeight(28f);
                table.addCell(cell_24);
                PdfPCell cell_25 = new PdfPCellBuilder(new ParagraphBuilder("邮编", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_25.setFixedHeight(28f);
                table.addCell(cell_25);
                PdfPCell cell_26 = new PdfPCellBuilder(new ParagraphBuilder(book.push(), simfang2312_z5));
                cell_26.setFixedHeight(28f);
                table.addCell(cell_26);
                PdfPCell cell_27 = new PdfPCellBuilder(new ParagraphBuilder("违法事实及处罚依据", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_27.setFixedHeight(84.19192f);
                table.addCell(cell_27);
                PdfPCell cell_28 = new PdfPCellBuilder(new ParagraphBuilder(book.push(), simfang2312_z5));
                cell_28.setColspan(8);
                cell_28.setFixedHeight(84.19192f);
                table.addCell(cell_28);
                PdfPCell cell_29 = new PdfPCellBuilder(new ParagraphBuilder("当事人的申辩意见", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_29.setFixedHeight(73.383835f);
                table.addCell(cell_29);
                PdfPCell cell_30 = new PdfPCellBuilder(new ParagraphBuilder(book.push(), simfang2312_z5));
                cell_30.setColspan(8);
                cell_30.setFixedHeight(73.383835f);
                table.addCell(cell_30);
                PdfPCell cell_31 = new PdfPCellBuilder(new ParagraphBuilder("承办人意见", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_31.setFixedHeight(73.83839f);
                table.addCell(cell_31);
                Paragraph paragraph2 = new ParagraphBuilder();
                paragraph2.setLeading(simfang2312_z5.getSize() * 1.5f);
//                paragraph2.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase2 = new Phrase();
                phrase2.add(ChunkFactory.tablenounderLine(book.push(), StringFactoryBuild.build().getStringLength("                                                                        ", simfang2312_z5) * 2, simfang2312_z5, "", "                                                                        "));
                paragraph2.add(phrase2);
                Paragraph paragraph4 = new ParagraphBuilder();
                paragraph4.setLeading(simfang2312_z5.getSize() * 1.5f);
//                paragraph4.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase4 = new Phrase();
                phrase4.add(new Chunk("承办人（签名）：", simfang2312_z5));
                phrase4.add(ChunkFactory.tableunderLine(book.push(), "         ", simfang2312_z5));
                phrase4.add(ChunkFactory.tablenounderLine("", "   ", simfang2312_z5));
                phrase4.add(ChunkFactory.tableunderLine(book.push(), "         ", simfang2312_z5));
                phrase4.add(ChunkFactory.tablenounderLine(book.pushneedcheck(), 0, "      ", simfang2312_z5));
                phrase4.add(new Chunk("年", simfang2312_z5));
                phrase4.add(ChunkFactory.tablenounderLine(book.pushneedcheck(), 1, "      ", simfang2312_z5));
                phrase4.add(new Chunk("月", simfang2312_z5));
                phrase4.add(ChunkFactory.tablenounderLine(book.push(true), 2, "      ", simfang2312_z5));
                phrase4.add(new Chunk("日", simfang2312_z5));
                paragraph4.add(phrase4);
//                document.add(paragraph4);
                PdfPCell cell_32 = new PdfPCellBuilder();
                cell_32.addElement(paragraph2);
                cell_32.addElement(paragraph4);
                cell_32.setColspan(8);
                cell_32.setFixedHeight(73.83839f);
                table.addCell(cell_32);




                PdfPCell cell_33 = new PdfPCellBuilder(new ParagraphBuilder("审核\n" +
                        "意见\n", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_33.setFixedHeight(80.959595f);
                table.addCell(cell_33);
                Paragraph paragraph5 = new ParagraphBuilder();
                paragraph5.setLeading(simfang2312_z5.getSize() * 1.2f);
                Phrase phrase5 = new Phrase();
                phrase5.add(ChunkFactory.tablenounderLine(book.push(), 10.5f*50, simfang2312_z5, "", "妈妈经常批评我做事不讲效率但我"));
                paragraph5.add(phrase5);
                Paragraph paragraph7 = new ParagraphBuilder();
                paragraph7.setLeading(simfang2312_z5.getSize() * 1.5f);
                Phrase phrase7 = new Phrase();
                phrase7.add(ChunkFactory.nounderLine("", 27.25f, simfang2312_z5));
                phrase7.add(new Chunk("审核人（签名）：", simfang2312_z5));
                phrase7.add(ChunkFactory.nounderLine(book.push(), "测试人人", simfang2312_z5));
                paragraph7.add(phrase7);
                Paragraph paragraph8 = new ParagraphBuilder();
                paragraph8.setLeading(simfang2312_z5.getSize() * 1.5f);
                Phrase phrase8 = new Phrase();
                phrase8.add(ChunkFactory.nounderLine("", 60f, simfang2312_z5));
                phrase8.add(ChunkFactory.nounderLine(book.pushneedcheck(), 0, 31f, simfang2312_z5));
                phrase8.add(new Chunk("年", simfang2312_z5));
                phrase8.add(ChunkFactory.nounderLine(book.pushneedcheck(), 1, 15.75f, simfang2312_z5));
                phrase8.add(new Chunk("月", simfang2312_z5));
                phrase8.add(ChunkFactory.nounderLine(book.push(true), 2, 15.75f, simfang2312_z5));
                phrase8.add(new Chunk("日", simfang2312_z5));
                paragraph8.add(phrase8);
                PdfPCell cell_34 = new PdfPCellBuilder();
                cell_34.addElement(paragraph5);
                cell_34.addElement(paragraph7);
                cell_34.addElement(paragraph8);
                cell_34.setColspan(2);
                cell_34.setFixedHeight(90.959595f);
                table.addCell(cell_34);



                PdfPCell cell_35 = new PdfPCellBuilder(new ParagraphBuilder("审批\n" +
                        "意见\n", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_35.setColspan(2);
                cell_35.setFixedHeight(80.959595f);
                table.addCell(cell_35);
                Paragraph paragraph9 = new ParagraphBuilder();
                paragraph9.setLeading(simfang2312_z5.getSize() * 1.2f);
//                paragraph9.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase9 = new Phrase();
                phrase9.add(ChunkFactory.tablenounderLine(book.push(), 10.5f*60, simfang2312_z5, "", "妈妈经常批评我做事不讲效率但我但我"));
                paragraph9.add(phrase9);
                Paragraph paragraph11 = new ParagraphBuilder();
                paragraph11.setLeading(simfang2312_z5.getSize() * 1.5f);
//                paragraph11.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase11 = new Phrase();
                phrase11.add(ChunkFactory.nounderLine("", 27.25f, simfang2312_z5));
                phrase11.add(new Chunk("审批人（签名）：", simfang2312_z5));
                phrase11.add(ChunkFactory.nounderLine(book.push(), "测试人人", simfang2312_z5));
                paragraph11.add(phrase11);
                Paragraph paragraph12 = new ParagraphBuilder();
                paragraph12.setLeading(simfang2312_z5.getSize() * 1.5f);
//                paragraph12.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase12 = new Phrase();
                phrase12.add(ChunkFactory.nounderLine("", 74f, simfang2312_z5));
                phrase12.add(ChunkFactory.nounderLine(book.pushneedcheck(), 0, 31f, simfang2312_z5));
                phrase12.add(new Chunk("年", simfang2312_z5));
                phrase12.add(ChunkFactory.nounderLine(book.pushneedcheck(), 1, 15.75f, simfang2312_z5));
                phrase12.add(new Chunk("月", simfang2312_z5));
                phrase12.add(ChunkFactory.nounderLine(book.push(true), 2, 15.75f, simfang2312_z5));
                phrase12.add(new Chunk("日", simfang2312_z5));
                paragraph12.add(phrase12);
                PdfPCell cell_36 = new PdfPCellBuilder();
                cell_36.addElement(paragraph9);
                cell_36.addElement(paragraph11);
                cell_36.addElement(paragraph12);
                cell_36.setColspan(4);
                cell_36.setFixedHeight(90.959595f);
                table.addCell(cell_36);




                document.add(table);
                printerFrameWorkPic(postmaskimage);
                document.newPage();
            }
        });

    }

    //行政处罚集体讨论记录
    protected void printerEntity_Book_2017_30(final Base_Entity book, final Object postmaskimage) {
        printerFrameWork(book, postmaskimage, new IPdfBackFrame() {
            @Override
            public void writeContent() throws Exception {
                //此处写页面布局
                book.push();
                book.push();
                book.push();
                printerFrameWorkTitle(book, "安全生产行政执法文书", "行政处罚集体讨论记录", "安监罚集");
                Paragraph paragraph1 = new ParagraphBuilder();
                paragraph1.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph1.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase1 = new Phrase();
                phrase1.add(new Chunk("案件名称", simfang2312_z5));
                phrase1.add(ChunkFactory.underLine(book.push(), 367.5f, simfang2312_z5));
                paragraph1.add(phrase1);
                document.add(paragraph1);
                Paragraph paragraph2 = new ParagraphBuilder();
                paragraph2.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph2.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase2 = new Phrase();
                phrase2.add(new Chunk("讨论时间", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.pushneedcheck(), 0, 26.25f, simfang2312_z5));
                phrase2.add(new Chunk("年", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.pushneedcheck(), 1, 15.75f, simfang2312_z5));
                phrase2.add(new Chunk("月", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.pushneedcheck(), 2, 15.75f, simfang2312_z5));
                phrase2.add(new Chunk("日", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.pushneedcheck(), 3, 15.75f, simfang2312_z5));
                phrase2.add(new Chunk("时", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.push(true), 4, 15.75f, simfang2312_z5));
                phrase2.add(new Chunk("分至", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.pushneedcheck(), 0, 42.0f, simfang2312_z5));
                phrase2.add(new Chunk("年", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.pushneedcheck(), 1, 15.75f, simfang2312_z5));
                phrase2.add(new Chunk("月", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.pushneedcheck(), 2, 15.75f, simfang2312_z5));
                phrase2.add(new Chunk("日", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.pushneedcheck(), 3, 21.0f, simfang2312_z5));
                phrase2.add(new Chunk("时", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.push(true), 4, 15.75f, simfang2312_z5));
                phrase2.add(new Chunk("分", simfang2312_z5));
                paragraph2.add(phrase2);
                document.add(paragraph2);
                Paragraph paragraph3 = new ParagraphBuilder();
                paragraph3.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph3.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase3 = new Phrase();
                phrase3.add(new Chunk("地点", simfang2312_z5));
                phrase3.add(ChunkFactory.underLine(book.push(), 393.75f, simfang2312_z5));
                paragraph3.add(phrase3);
                document.add(paragraph3);
                Paragraph paragraph4 = new ParagraphBuilder();
                paragraph4.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph4.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase4 = new Phrase();
                phrase4.add(new Chunk("主持人", simfang2312_z5));
                phrase4.add(ChunkFactory.underLine(book.push(), 78.75f, simfang2312_z5));
                phrase4.add(new Chunk("汇报人", simfang2312_z5));
                phrase4.add(ChunkFactory.underLine(book.push(), 89.25f, simfang2312_z5));
                phrase4.add(new Chunk("记录人", simfang2312_z5));
                phrase4.add(ChunkFactory.underLine(book.push(), 115.5f, simfang2312_z5));
                paragraph4.add(phrase4);
                document.add(paragraph4);
                Paragraph paragraph5 = new ParagraphBuilder();
                paragraph5.setLeading(simfang2312_z5.getSize() * 1.5f);
//                paragraph5.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase5 = new Phrase();
                phrase5.add(new Chunk("出席人员姓名及职务：", simfang2312_z5));
                phrase5.add(ChunkFactory.underLine(book.push(), 1772.75f, simfang2312_z5, "出席人员姓名及职务：", -1));
                paragraph5.add(phrase5);
                document.add(paragraph5);
                Paragraph paragraph11 = new ParagraphBuilder();
                paragraph11.setLeading(simfang2312_z5.getSize() * 1.5f);
//                paragraph11.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase11 = new Phrase();
                phrase11.add(new Chunk("讨论内容：", simfang2312_z5));
                phrase11.add(ChunkFactory.underLine(book.push(), 1772.75f, simfang2312_z5, "讨论内容：", -1));
                paragraph11.add(phrase11);
                document.add(paragraph11);
                Paragraph paragraph15 = new ParagraphBuilder();
                paragraph15.setLeading(simfang2312_z5.getSize() * 1.5f);
//                paragraph15.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase15 = new Phrase();
                phrase15.add(new Chunk("讨论记录：", simfang2312_z5));
                phrase15.add(ChunkFactory.underLine(book.push(), 1715.0f, simfang2312_z5, "讨论记录：", -1));
                paragraph15.add(phrase15);
                document.add(paragraph15);
                Paragraph paragraph23 = new ParagraphBuilder();
                paragraph23.setLeading(simfang2312_z5.getSize() * 1.5f);
//                paragraph23.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase23 = new Phrase();
                phrase23.add(new Chunk("结论性意见：", simfang2312_z5));
                phrase23.add(ChunkFactory.underLine(book.push(), 1799.0f, simfang2312_z5, "结论性意见：", -1));
                paragraph23.add(phrase23);
                document.add(paragraph23);
                Paragraph paragraph27 = new ParagraphBuilder();
                paragraph27.setLeading(simfang2312_z5.getSize() * 1.5f);
//                paragraph27.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase27 = new Phrase();
                phrase27.add(new Chunk("出席人员签名：", simfang2312_z5));
                phrase27.add(ChunkFactory.underLine(book.push(), 1746.5f, simfang2312_z5, "结论性意见：", -1));
                paragraph27.add(phrase27);
                document.add(paragraph27);
                printerFrameWorkPic(postmaskimage);
                document.newPage();// 结束保存
            }
        });

    }

    //行政（当场）处罚决定书（单位）
    protected void printerEntity_Book_2017_31(final Base_Entity book, final Object postmaskimage) {
        printerFrameWork(book, postmaskimage, new IPdfBackFrame() {
            @Override
            public void writeContent() throws Exception {
                //此处写页面布局
                book.push();
                book.push();
                book.push();
                printerFrameWorkTitle(book, "安全生产行政执法文书", "行政（当场）处罚决定书（单位）", "安监罚当");
                Paragraph paragraph1 = new ParagraphBuilder();
                paragraph1.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph1.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase1 = new Phrase();
                phrase1.add(new Chunk("被处罚单位：", simfang2312_z5));
                phrase1.add(ChunkFactory.underLine(book.push(), 346.5f, simfang2312_z5));
                paragraph1.add(phrase1);
                document.add(paragraph1);
                Paragraph paragraph2 = new ParagraphBuilder();
                paragraph2.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph2.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase2 = new Phrase();
                phrase2.add(new Chunk("地址：", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.push(), 231.0f, simfang2312_z5));
                phrase2.add(new Chunk("邮政编码：", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.push(), 94.5f, simfang2312_z5));
                paragraph2.add(phrase2);
                document.add(paragraph2);
                Paragraph paragraph3 = new ParagraphBuilder();
                paragraph3.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph3.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase3 = new Phrase();
                phrase3.add(new Chunk("法定代表人（负责人）：", simfang2312_z5));
                phrase3.add(ChunkFactory.underLine(book.push(), 68.25f, simfang2312_z5));
                phrase3.add(new Chunk("职务：", simfang2312_z5));
                phrase3.add(ChunkFactory.underLine(book.push(), 78.75f, simfang2312_z5));
                phrase3.add(new Chunk("联系电话：", simfang2312_z5));
                phrase3.add(ChunkFactory.underLine(book.push(), 68.25f, simfang2312_z5));
                paragraph3.add(phrase3);
                document.add(paragraph3);
                Paragraph paragraph4 = new ParagraphBuilder();
                paragraph4.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph4.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase4 = new Phrase();
                phrase4.add(new Chunk("违法事实及证据：", simfang2312_z5));
                phrase4.add(ChunkFactory.underLine(book.push(), 555.5f, simfang2312_z5, "空格违法事实及证据：", -1));
                phrase4.add(new Chunk("（此栏不够，可另附页）", simfang2312_z5));
                paragraph4.add(phrase4);
                document.add(paragraph4);

                Paragraph paragraph7 = new ParagraphBuilder();
                paragraph7.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph7.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase7 = new Phrase();
                phrase7.add(new Chunk("以上事实违反了", simfang2312_z5));
                phrase7.add(ChunkFactory.underLine(book.push(), 315.0f, simfang2312_z5));
                paragraph7.add(phrase7);
                document.add(paragraph7);
                Paragraph paragraph8 = new ParagraphBuilder();
                paragraph8.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph8.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase8 = new Phrase();
                phrase8.add(new Chunk("的规定，依据", simfang2312_z5));
                phrase8.add(ChunkFactory.underLine(book.push(), 288.75f, simfang2312_z5));
                phrase8.add(new Chunk("的规定，决定给予", simfang2312_z5));
                phrase8.add(ChunkFactory.underLine(book.push(), 336.0f, simfang2312_z5));
                phrase8.add(new Chunk("的行政处罚。", simfang2312_z5));
                paragraph8.add(phrase8);
                document.add(paragraph8);
                Paragraph paragraph9 = new ParagraphBuilder();
                paragraph9.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph9.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase9 = new Phrase();
                phrase9.add(new Chunk("罚款的履行方式和期限（见打√处）：", simfang2312_z5));
                paragraph9.add(phrase9);
                document.add(paragraph9);
                Paragraph paragraph10 = new ParagraphBuilder();
                paragraph10.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph10.setFirstLineIndent(simfang2312_z5.getSize() * 3f);
                Phrase phrase10 = new Phrase();

                phrase10.add(new Chunk("当场缴纳", simfang2312_z5));
                paragraph10.add(phrase10);
                document.add(paragraph10);
                Paragraph paragraph11 = new ParagraphBuilder();
                paragraph11.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph11.setFirstLineIndent(simfang2312_z5.getSize() * 3f);
                Phrase phrase11 = new Phrase();

                book.push();
                RadioCheckField bt10 = new RadioCheckField(dpfwPdfWriter,
                        ChunkFactory.setCheckBoxArea(105, 408, 10), "Yes0db298f77760414bb6d386f989b105ac",
                        ChunkFactory.getCheck(book.getValue(13), 1));
                bt10.setCheckType(RadioCheckField.TYPE_CHECK);
                bt10.setBorderWidth(BaseField.BORDER_WIDTH_THIN);
                bt10.setBorderColor(BaseColor.BLACK);
                bt10.setChecked(true);
                PdfFormField ck10 = bt10.getCheckField();
                dpfwPdfWriter.addAnnotation(ck10);
                RadioCheckField bt11 = new RadioCheckField(dpfwPdfWriter,
                        ChunkFactory.setCheckBoxArea(105, 385, 10), "Yesf440958418a14abb8e0a74e500d463ce",
                        ChunkFactory.getCheck(book.getValue(13), 2));
                bt11.setCheckType(RadioCheckField.TYPE_CHECK);
                bt11.setBorderWidth(BaseField.BORDER_WIDTH_THIN);
                bt11.setBorderColor(BaseColor.BLACK);
                bt11.setChecked(true);
                PdfFormField ck11 = bt11.getCheckField();
                dpfwPdfWriter.addAnnotation(ck11);


                phrase11.add(new Chunk("自收到本决定书之日起15日内缴至", simfang2312_z5));
                phrase11.add(ChunkFactory.underLine(book.push(), 210.0f, simfang2312_z5));
                phrase11.add(new Chunk("，账号", simfang2312_z5));
                phrase11.add(ChunkFactory.underLine(book.push(), 147.0f, simfang2312_z5));
                phrase11.add(new Chunk("，到期不缴每日按罚款数额的3%加处罚款。", simfang2312_z5));
                paragraph11.add(phrase11);
                document.add(paragraph11);
                Paragraph paragraph12 = new ParagraphBuilder();
                paragraph12.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph12.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase12 = new Phrase();
                phrase12.add(new Chunk("如果不服本处罚决定，可以依法在60日内向", simfang2312_z5));
                phrase12.add(ChunkFactory.underLine(book.push(), 168.0f, simfang2312_z5));
                phrase12.add(new Chunk("人民政府或者", simfang2312_z5));
                phrase12.add(ChunkFactory.underLine(book.push(), 204.75f, simfang2312_z5));
                phrase12.add(new Chunk("申请行政复议，或者在6个月内依法向", simfang2312_z5));
                phrase12.add(ChunkFactory.underLine(book.push(), 147.0f, simfang2312_z5));
                phrase12.add(new Chunk("人民法院提起行政诉讼，但本决定不停止执行，法律另有规定的除外。逾期不申请行政复议、不提起行政诉讼又不履行的，本机关将依法申请人民法院强制执行或者依照有关规定强制执行。", simfang2312_z5));
                paragraph12.add(phrase12);
                document.add(paragraph12);
                Paragraph paragraph13 = new ParagraphBuilder();
                paragraph13.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph13.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase13 = new Phrase();
                phrase13.add(new Chunk("安全生产监管行政执法人员（签名）：", simfang2312_z5));
                phrase13.add(ChunkFactory.underLine(book.push(), "            ", simfang2312_z5));
                phrase13.add(ChunkFactory.nounderLine("", "  ", simfang2312_z5));
                phrase13.add(ChunkFactory.underLine(book.push(), "            ", simfang2312_z5));
                paragraph13.add(phrase13);
                document.add(paragraph13);
                Paragraph paragraph14 = new ParagraphBuilder();
                paragraph14.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph14.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase14 = new Phrase();
                phrase14.add(new Chunk("当事人或者委托代理人（签名）：", simfang2312_z5));
                phrase14.add(ChunkFactory.underLine(book.push(), 63.0f, simfang2312_z5));
                paragraph14.add(phrase14);
                document.add(paragraph14);
                printerFrameWorkG2(book);
                printerFrameWorkG3(book);
                printerFrameWorkPic(postmaskimage);

                document.newPage();// 结束保存
            }
        });

    }

    //行政（当场）处罚决定书（个人）
    protected void printerEntity_Book_2017_32(final Base_Entity book, final Object postmaskimage) {
        printerFrameWork(book, postmaskimage, new IPdfBackFrame() {
            @Override
            public void writeContent() throws Exception {
                //此处写页面布局
                book.push();
                book.push();
                book.push();
                printerFrameWorkTitle(book, "安全生产行政执法文书", "行政（当场）处罚决定书（个人）", "安监罚当");
                Paragraph paragraph1 = new ParagraphBuilder();
                paragraph1.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph1.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase1 = new Phrase();
                phrase1.add(new Chunk("被处罚人：", simfang2312_z5));
                phrase1.add(ChunkFactory.underLine(book.push(), 99.75f, simfang2312_z5));
                phrase1.add(new Chunk("性别：", simfang2312_z5));
                phrase1.add(ChunkFactory.underLine(book.push(), 21.0f, simfang2312_z5));
                phrase1.add(new Chunk("年龄：", simfang2312_z5));
                phrase1.add(ChunkFactory.underLine(book.push(), 31.5f, simfang2312_z5));
                phrase1.add(new Chunk("身份证号：", simfang2312_z5));
                phrase1.add(ChunkFactory.underLine(book.push(), 105.0f, simfang2312_z5));
                paragraph1.add(phrase1);
                document.add(paragraph1);
                Paragraph paragraph2 = new ParagraphBuilder();
                paragraph2.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph2.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase2 = new Phrase();
                phrase2.add(new Chunk("家庭住址：", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.push(), 162.75f, simfang2312_z5));
                phrase2.add(new Chunk("所在单位：", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.push(), 147.0f, simfang2312_z5));
                paragraph2.add(phrase2);
                document.add(paragraph2);
                Paragraph paragraph3 = new ParagraphBuilder();
                paragraph3.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph3.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase3 = new Phrase();
                phrase3.add(new Chunk("职务：", simfang2312_z5));
                phrase3.add(ChunkFactory.underLine(book.push(), 42.0f, simfang2312_z5));
                phrase3.add(new Chunk("单位地址：", simfang2312_z5));
                phrase3.add(ChunkFactory.underLine(book.push(), 131.25f, simfang2312_z5));
                phrase3.add(new Chunk("联系电话：", simfang2312_z5));
                phrase3.add(ChunkFactory.underLine(book.push(), 105.0f, simfang2312_z5));
                paragraph3.add(phrase3);
                document.add(paragraph3);
                Paragraph paragraph4 = new ParagraphBuilder();
                paragraph4.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph4.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase4 = new Phrase();
                phrase4.add(new Chunk("违法事实及证据：", simfang2312_z5));
                phrase4.add(ChunkFactory.underLine(book.push(), 556.5f, simfang2312_z5, "空格违法事实及证据：", -1));
                phrase4.add(new Chunk("（此栏不够，可另附页）", simfang2312_z5));
                paragraph4.add(phrase4);
                document.add(paragraph4);

                Paragraph paragraph7 = new ParagraphBuilder();
                paragraph7.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph7.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase7 = new Phrase();
                phrase7.add(new Chunk("以上事实违反了", simfang2312_z5));
                phrase7.add(ChunkFactory.underLine(book.push(), 278.25f, simfang2312_z5));
                phrase7.add(new Chunk("的规定，依据", simfang2312_z5));
                phrase7.add(ChunkFactory.underLine(book.push(), 336.0f, simfang2312_z5));
                phrase7.add(new Chunk("的规定，决定给予", simfang2312_z5));
                phrase7.add(ChunkFactory.underLine(book.push(), 304.5f, simfang2312_z5));
                phrase7.add(new Chunk("的行政处罚。", simfang2312_z5));
                paragraph7.add(phrase7);
                document.add(paragraph7);
                Paragraph paragraph8 = new ParagraphBuilder();
                paragraph8.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph8.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase8 = new Phrase();
                phrase8.add(new Chunk("罚款的履行方式和期限（见打√处）：", simfang2312_z5));
                paragraph8.add(phrase8);
                document.add(paragraph8);
                Paragraph paragraph9 = new ParagraphBuilder();
                paragraph9.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph9.setFirstLineIndent(simfang2312_z5.getSize() * 3f);
                Phrase phrase9 = new Phrase();
                phrase9.add(new Chunk("当场缴纳", simfang2312_z5));
                paragraph9.add(phrase9);
                document.add(paragraph9);
                Paragraph paragraph10 = new ParagraphBuilder();
                paragraph10.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph10.setFirstLineIndent(simfang2312_z5.getSize() * 3f);
                Phrase phrase10 = new Phrase();

                book.push();
                RadioCheckField bt9 = new RadioCheckField(dpfwPdfWriter,
                        ChunkFactory.setCheckBoxArea(105, 407, 10), "Yesde2eb24db6904a34b669976ed9b6958f",
                        ChunkFactory.getCheck(book.getValue(16), 1));
                bt9.setCheckType(RadioCheckField.TYPE_CHECK);
                bt9.setBorderWidth(BaseField.BORDER_WIDTH_THIN);
                bt9.setBorderColor(BaseColor.BLACK);
                bt9.setChecked(true);
                PdfFormField ck9 = bt9.getCheckField();
                dpfwPdfWriter.addAnnotation(ck9);
                RadioCheckField bt10 = new RadioCheckField(dpfwPdfWriter,
                        ChunkFactory.setCheckBoxArea(105, 384, 10), "Yes084a0f669a3c43278437ac71cac3a754",
                        ChunkFactory.getCheck(book.getValue(16), 2));
                bt10.setCheckType(RadioCheckField.TYPE_CHECK);
                bt10.setBorderWidth(BaseField.BORDER_WIDTH_THIN);
                bt10.setBorderColor(BaseColor.BLACK);
                bt10.setChecked(true);
                PdfFormField ck10 = bt10.getCheckField();
                dpfwPdfWriter.addAnnotation(ck10);


                phrase10.add(new Chunk("自收到本决定书之日起15日内缴至", simfang2312_z5));
                phrase10.add(ChunkFactory.underLine(book.push(), 199.5f, simfang2312_z5));
                phrase10.add(new Chunk("，账号", simfang2312_z5));
                phrase10.add(ChunkFactory.underLine(book.push(), 147.0f, simfang2312_z5));
                phrase10.add(new Chunk("，到期不缴每日按罚款数额的3%加处罚款。", simfang2312_z5));
                paragraph10.add(phrase10);
                document.add(paragraph10);
                Paragraph paragraph11 = new ParagraphBuilder();
                paragraph11.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph11.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase11 = new Phrase();
                phrase11.add(new Chunk("如果不服本处罚决定，可以依法在60日内向", simfang2312_z5));
                phrase11.add(ChunkFactory.underLine(book.push(), 168.0f, simfang2312_z5));
                phrase11.add(new Chunk("人民政府或者", simfang2312_z5));
                phrase11.add(ChunkFactory.underLine(book.push(), 204.75f, simfang2312_z5));
                phrase11.add(new Chunk("申请行政复议，或者在6个月内依法向", simfang2312_z5));
                phrase11.add(ChunkFactory.underLine(book.push(), 183.75f, simfang2312_z5));
                phrase11.add(new Chunk("人民法院提起行政诉讼，但本决定不停止执行，法律另有规定的除外。逾期不申请行政复议、不提起行政诉讼又不履行的，本机关将依法申请人民法院强制执行或者依照有关规定强制执行。", simfang2312_z5));
                paragraph11.add(phrase11);
                document.add(paragraph11);
                Paragraph paragraph12 = new ParagraphBuilder();
                paragraph12.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph12.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase12 = new Phrase();
                phrase12.add(new Chunk("安全生产监管行政执法人员（签名）：", simfang2312_z5));
                phrase12.add(ChunkFactory.underLine(book.push(), "            ", simfang2312_z5));
                phrase12.add(ChunkFactory.nounderLine("", "  ", simfang2312_z5));
                phrase12.add(ChunkFactory.underLine(book.push(), "            ", simfang2312_z5));
                paragraph12.add(phrase12);
                document.add(paragraph12);
                Paragraph paragraph13 = new ParagraphBuilder();
                paragraph13.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph13.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase13 = new Phrase();
                phrase13.add(new Chunk("当事人或者委托代理人（签名）：", simfang2312_z5));
                phrase13.add(ChunkFactory.underLine(book.push(), 63.0f, simfang2312_z5));
                paragraph13.add(phrase13);
                document.add(paragraph13);
                printerFrameWorkG1(book);
                printerFrameWorkPic(postmaskimage);
                document.newPage();// 结束保存
            }
        });

    }

    //行政处罚决定书（单位）
    protected void printerEntity_Book_2017_33(final Base_Entity book, final Object postmaskimage) {
        printerFrameWork(book, postmaskimage, new IPdfBackFrame() {
            @Override
            public void writeContent() throws Exception {
                //此处写页面布局
                book.push();
                book.push();
                book.push();
                printerFrameWorkTitle(book, "安全生产行政执法文书", "行政处罚决定书（单位）", "安监罚");
                Paragraph paragraph1 = new ParagraphBuilder();
                paragraph1.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph1.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase1 = new Phrase();
                phrase1.add(new Chunk("被处罚单位：", simfang2312_z5));
                phrase1.add(ChunkFactory.underLine(book.push(), 357.0f, simfang2312_z5));
                paragraph1.add(phrase1);
                document.add(paragraph1);
                Paragraph paragraph2 = new ParagraphBuilder();
                paragraph2.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph2.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase2 = new Phrase();
                phrase2.add(new Chunk("地 址：", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.push(), 246.75f, simfang2312_z5));
                phrase2.add(new Chunk("邮政编码：", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.push(), 84.0f, simfang2312_z5));
                paragraph2.add(phrase2);
                document.add(paragraph2);
                Paragraph paragraph3 = new ParagraphBuilder();
                paragraph3.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph3.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase3 = new Phrase();
                phrase3.add(new Chunk("法定代表人（负责人）：", simfang2312_z5));
                phrase3.add(ChunkFactory.underLine(book.push(), 73.5f, simfang2312_z5));
                phrase3.add(new Chunk("职务：", simfang2312_z5));
                phrase3.add(ChunkFactory.underLine(book.push(), 84.0f, simfang2312_z5));
                phrase3.add(new Chunk("联系电话", simfang2312_z5));
                phrase3.add(ChunkFactory.underLine(book.push(), 73.5f, simfang2312_z5));
                paragraph3.add(phrase3);
                document.add(paragraph3);
                Paragraph paragraph4 = new ParagraphBuilder();
                paragraph4.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph4.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase4 = new Phrase();
                phrase4.add(new Chunk("违法事实及证据：", simfang2312_z5));
                phrase4.add(ChunkFactory.underLine(book.push(), 1412f, simfang2312_z5, "空格违法事实及证据：", -1));
                phrase4.add(new Chunk("（此栏不够，可另附页）", simfang2312_z5));
                paragraph4.add(phrase4);
                document.add(paragraph4);
                Paragraph paragraph8 = new ParagraphBuilder();
                paragraph8.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph8.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase8 = new Phrase();
                phrase8.add(new Chunk("以上事实违反了", simfang2312_z5));
                phrase8.add(ChunkFactory.underLine(book.push(), 283.5f, simfang2312_z5));
                phrase8.add(new Chunk("的规定，", simfang2312_z5));
                phrase8.add(ChunkFactory.nounderLine("", 5.25f, simfang2312_z5));
                phrase8.add(new Chunk("依据", simfang2312_z5));
                phrase8.add(ChunkFactory.underLine(book.push(), 330.75f, simfang2312_z5));
                phrase8.add(new Chunk("的规定，决定给予", simfang2312_z5));
                phrase8.add(ChunkFactory.underLine(book.push(), 283.5f, simfang2312_z5));
                phrase8.add(new Chunk("的行政处罚。", simfang2312_z5));
                paragraph8.add(phrase8);
                document.add(paragraph8);
                Paragraph paragraph9 = new ParagraphBuilder();
                paragraph9.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph9.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase9 = new Phrase();
                phrase9.add(new Chunk("处以罚款的，罚款自收到本决定书之日起15日内缴至", simfang2312_z5));
                phrase9.add(ChunkFactory.underLine(book.push(), 136.5f, simfang2312_z5));
                phrase9.add(new Chunk("，账号", simfang2312_z5));
                phrase9.add(ChunkFactory.underLine(book.push(), 78.75f, simfang2312_z5));
                phrase9.add(new Chunk("，到期不缴每日按罚款数额的3%加处罚款。", simfang2312_z5));
                paragraph9.add(phrase9);
                document.add(paragraph9);
                Paragraph paragraph10 = new ParagraphBuilder();
                paragraph10.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph10.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase10 = new Phrase();
                phrase10.add(new Chunk("如果不服本处罚决定，可以依法在60日内向", simfang2312_z5));
                phrase10.add(ChunkFactory.underLine(book.push(), 168.0f, simfang2312_z5));
                phrase10.add(new Chunk("人民政府或者", simfang2312_z5));
                phrase10.add(ChunkFactory.underLine(book.push(), 99.75f, simfang2312_z5));
                phrase10.add(new Chunk("申请行政复议，或者在6个月内依法向", simfang2312_z5));
                phrase10.add(ChunkFactory.underLine(book.push(), 57.75f, simfang2312_z5));
                phrase10.add(new Chunk("人民法院提起行政诉讼，但本决定不停止执行，法律另有规定的除外。逾期不申请行政复议、不提起行政诉讼又不履行的，本机关将依法申请人民法院强制执行或者依照有关规定强制执行。", simfang2312_z5));
                paragraph10.add(phrase10);
                document.add(paragraph10);
                printerFrameWorkG1(book);
                printerFrameWorkPic(postmaskimage);
                document.newPage();// 结束保存
            }
        });

    }

    //行政处罚决定书（个人）
    protected void printerEntity_Book_2017_34(final Base_Entity book, final Object postmaskimage) {
        printerFrameWork(book, postmaskimage, new IPdfBackFrame() {
            @Override
            public void writeContent() throws Exception {
                //此处写页面布局
                book.push();
                book.push();
                book.push();
                printerFrameWorkTitle(book, "安全生产行政执法文书", "行政处罚决定书（个人）", "安监罚");
                Paragraph paragraph1 = new ParagraphBuilder();
                paragraph1.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph1.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase1 = new Phrase();
                phrase1.add(new Chunk("被处罚人：", simfang2312_z5));
                phrase1.add(ChunkFactory.underLine(book.push(), 36.75f, simfang2312_z5));
                phrase1.add(new Chunk("性别：", simfang2312_z5));
                phrase1.add(ChunkFactory.underLine(book.push(), 21.0f, simfang2312_z5));
                phrase1.add(new Chunk("年龄：", simfang2312_z5));
                phrase1.add(ChunkFactory.underLine(book.push(), 36.75f, simfang2312_z5));
                phrase1.add(new Chunk("身份证号：\u00a0", simfang2312_z5));
                phrase1.add(ChunkFactory.underLine(book.push(), 160.0f, simfang2312_z5));
                paragraph1.add(phrase1);
                document.add(paragraph1);
                Paragraph paragraph2 = new ParagraphBuilder();
                paragraph2.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph2.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase2 = new Phrase();
                phrase2.add(new Chunk("家庭住址：", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.push(), 110.25f, simfang2312_z5));
                phrase2.add(new Chunk("所在单位：", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.push(), 200.5f, simfang2312_z5));
                paragraph2.add(phrase2);
                document.add(paragraph2);
                Paragraph paragraph3 = new ParagraphBuilder();
                paragraph3.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph3.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase3 = new Phrase();
                phrase3.add(new Chunk("职务：", simfang2312_z5));
                phrase3.add(ChunkFactory.underLine(book.push(), 57.75f, simfang2312_z5));
                phrase3.add(new Chunk("单位地址：", simfang2312_z5));
                phrase3.add(ChunkFactory.underLine(book.push(), 168.0f, simfang2312_z5));
                phrase3.add(new Chunk("邮政编码：", simfang2312_z5));
                phrase3.add(ChunkFactory.underLine(book.push(), 52.5f, simfang2312_z5));
                paragraph3.add(phrase3);
                document.add(paragraph3);
                Paragraph paragraph4 = new ParagraphBuilder();
                paragraph4.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph4.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase4 = new Phrase();
                phrase4.add(new Chunk("违法事实及证据：", simfang2312_z5));
                phrase4.add(ChunkFactory.underLine(book.push(), 1412f, simfang2312_z5, "空格违法事实及证据：", -1));
                phrase4.add(new Chunk("（此栏不够，可另附页）", simfang2312_z5));
                paragraph4.add(phrase4);
                document.add(paragraph4);
                Paragraph paragraph8 = new ParagraphBuilder();
                paragraph8.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph8.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase8 = new Phrase();
                phrase8.add(new Chunk("以上事实违反了", simfang2312_z5));
                phrase8.add(ChunkFactory.underLine(book.push(), 283.5f, simfang2312_z5));
                phrase8.add(new Chunk("的规定，依据", simfang2312_z5));
                phrase8.add(ChunkFactory.underLine(book.push(), 330.75f, simfang2312_z5));
                phrase8.add(new Chunk("的规定，决定给予", simfang2312_z5));
                phrase8.add(ChunkFactory.underLine(book.push(), 283.5f, simfang2312_z5));
                phrase8.add(new Chunk("的行政处罚。", simfang2312_z5));
                paragraph8.add(phrase8);
                document.add(paragraph8);
                Paragraph paragraph9 = new ParagraphBuilder();
                paragraph9.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph9.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase9 = new Phrase();
                phrase9.add(new Chunk("处以罚款的，罚款自收到本决定书之日起15日内缴至", simfang2312_z5));
                phrase9.add(ChunkFactory.underLine(book.push(), 136.5f, simfang2312_z5));
                phrase9.add(new Chunk("，账号", simfang2312_z5));
                phrase9.add(ChunkFactory.underLine(book.push(), 152.25f, simfang2312_z5));
                phrase9.add(new Chunk("，到期不缴每日按罚款数额的3%加处罚款。", simfang2312_z5));
                paragraph9.add(phrase9);
                document.add(paragraph9);
                Paragraph paragraph10 = new ParagraphBuilder();
                paragraph10.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph10.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase10 = new Phrase();
                phrase10.add(new Chunk("如果不服本处罚决定，可以依法在60日内向", simfang2312_z5));
                phrase10.add(ChunkFactory.underLine(book.push(), 168.0f, simfang2312_z5));
                phrase10.add(new Chunk("人民政府或者", simfang2312_z5));
                phrase10.add(ChunkFactory.underLine(book.push(), 225.75f, simfang2312_z5));
                phrase10.add(new Chunk("申请行政复议，或者在6个月内依法向", simfang2312_z5));
                phrase10.add(ChunkFactory.underLine(book.push(), 99.75f, simfang2312_z5));
                phrase10.add(new Chunk("人民法院提起行政诉讼，但本决定不停止执行，法律另有规定的除外。逾期不申请行政复议、不提起行政诉讼又不履行的，本机关将依法申请人民法院强制执行或者依照有关规定强制执行。", simfang2312_z5));
                paragraph10.add(phrase10);
                document.add(paragraph10);
                printerFrameWorkG1(book);
                printerFrameWorkPic(postmaskimage);
                document.newPage();// 结束保存
            }
        });

    }

    //缴纳罚款催告书
    protected void printerEntity_Book_2017_35(final Base_Entity book, final Object postmaskimage) {
        printerFrameWork(book, postmaskimage, new IPdfBackFrame() {
            @Override
            public void writeContent() throws Exception {
                //此处写页面布局
                book.push();
                book.push();
                book.push();
                printerFrameWorkTitle(book, "安全生产行政执法文书", "缴纳罚款催告书", "安监催");
                Paragraph paragraph1 = new ParagraphBuilder();
                paragraph1.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph1.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase1 = new Phrase();
                phrase1.add(ChunkFactory.underLine(book.push(), 168.0f, simfang2312_z5));
                phrase1.add(new Chunk("：", simfang2312_z5));
                paragraph1.add(phrase1);
                document.add(paragraph1);
                Paragraph paragraph2 = new ParagraphBuilder();
                paragraph2.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph2.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase2 = new Phrase();
                phrase2.add(new Chunk("本机关于", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.pushneedcheck(), 0, 26.25f, simfang2312_z5));
                phrase2.add(new Chunk("年", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.pushneedcheck(), 1, 21.0f, simfang2312_z5));
                phrase2.add(new Chunk("月", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.push(true), 2, 15.75f, simfang2312_z5));
                phrase2.add(new Chunk("日发出", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.push(), 52.5f, simfang2312_z5));
                phrase2.add(new Chunk("号《行政处罚决定书》，要求你（单位）于", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.pushneedcheck(), 0, 42.0f, simfang2312_z5));
                phrase2.add(new Chunk("年", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.pushneedcheck(), 1, 15.75f, simfang2312_z5));
                phrase2.add(new Chunk("月", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.push(true), 2, 15.75f, simfang2312_z5));
                phrase2.add(new Chunk("日前将罚款缴至", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.push(), 57.75f, simfang2312_z5));
                phrase2.add(new Chunk("。因你（单位）至今未履行该处罚决定，依据《中华人民共和国行政强制法》第三十五条的规定，现催告你（单位）履行以上决定，本机关将依据《中华人民共和国行政处罚法》第五十一条第一项、《中华人民共和国行政强制法》第四十五条的规定，每日按罚款数额的3％加处罚款。", simfang2312_z5));
                paragraph2.add(phrase2);
                document.add(paragraph2);
                Paragraph paragraph3 = new ParagraphBuilder();
                paragraph3.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph3.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase3 = new Phrase();
                phrase3.add(new Chunk("如有异议，依据《中华人民共和国行政强制法》第三十六条的规定，你（单位）有权在收到本催告书之日起3日内向本机关提出陈述和申辩，逾期未提出的，视为放弃此权利。", simfang2312_z5));
                paragraph3.add(phrase3);
                document.add(paragraph3);
                Paragraph paragraph4 = new ParagraphBuilder();
                paragraph4.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph4.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase4 = new Phrase();
                phrase4.add(new Chunk("地址：", simfang2312_z5));
                phrase4.add(ChunkFactory.underLine(book.push(), 341.25f, simfang2312_z5));
                paragraph4.add(phrase4);
                document.add(paragraph4);
                Paragraph paragraph5 = new ParagraphBuilder();
                paragraph5.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph5.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase5 = new Phrase();
                phrase5.add(new Chunk("联系人：", simfang2312_z5));
                phrase5.add(ChunkFactory.underLine(book.push(), 126.0f, simfang2312_z5));
                phrase5.add(new Chunk("联系电话：", simfang2312_z5));
                phrase5.add(ChunkFactory.underLine(book.push(), 147.0f, simfang2312_z5));
                paragraph5.add(phrase5);
                document.add(paragraph5);
                document.add(space4);
                document.add(space4);
                document.add(space4);
                document.add(space4);
                printerFrameWorkG1(book);
                printerFrameWorkPic(postmaskimage);
                document.newPage();// 结束保存
            }
        });

    }

    //加处罚款决定书
    protected void printerEntity_Book_2017_36(final Base_Entity book, final Object postmaskimage) {
        printerFrameWork(book, postmaskimage, new IPdfBackFrame() {
            @Override
            public void writeContent() throws Exception {
                //此处写页面布局
                book.push();
                book.push();
                book.push();
                printerFrameWorkTitle(book, "安全生产行政执法文书", "加处罚款决定书", "安监加罚");
                Paragraph paragraph1 = new ParagraphBuilder();
                paragraph1.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph1.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase1 = new Phrase();
                phrase1.add(ChunkFactory.underLine(book.push(), 94.5f, simfang2312_z5));
                phrase1.add(new Chunk("：", simfang2312_z5));
                paragraph1.add(phrase1);
                document.add(paragraph1);
                Paragraph paragraph2 = new ParagraphBuilder();
                paragraph2.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph2.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase2 = new Phrase();
                phrase2.add(new Chunk("本机关于", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.pushneedcheck(), 0, 31.5f, simfang2312_z5));
                phrase2.add(new Chunk("年", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.pushneedcheck(), 1, 31.5f, simfang2312_z5));
                phrase2.add(new Chunk("月", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.push(true), 2, 31.5f, simfang2312_z5));
                phrase2.add(new Chunk("日发出", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.push(), 31.5f, simfang2312_z5));
                phrase2.add(new Chunk("号《行政处罚决定书》，对你（单位）罚款", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.push(), 52.5f, simfang2312_z5));
                phrase2.add(new Chunk("，要求于", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.pushneedcheck(), 0, 42.0f, simfang2312_z5));
                phrase2.add(new Chunk("年", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.pushneedcheck(), 1, 21.0f, simfang2312_z5));
                phrase2.add(new Chunk("月", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.push(true), 2, 21.0f, simfang2312_z5));
                phrase2.add(new Chunk("日前履行。经催告，你（单位）截至", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.pushneedcheck(), 0, 26.25f, simfang2312_z5));
                phrase2.add(new Chunk("年", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.pushneedcheck(), 1, 21.0f, simfang2312_z5));
                phrase2.add(new Chunk("月", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.push(true), 2, 21.0f, simfang2312_z5));
                phrase2.add(new Chunk("日仍未履行该行政处罚决定，根据《中华人民共和国行政处罚法》第五十一条第一项、《中华人民共和国行政强制法》第四十五条的规定，本机关决定对你（单位）加处罚款", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.push(), 31.5f, simfang2312_z5));
                phrase2.add(new Chunk("（大写）。现要求你（单位）立即向", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.push(), 99.75f, simfang2312_z5));
                phrase2.add(new Chunk("缴纳依法加处的罚款。", simfang2312_z5));
                paragraph2.add(phrase2);
                document.add(paragraph2);
                Paragraph paragraph3 = new ParagraphBuilder();
                paragraph3.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph3.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase3 = new Phrase();
                phrase3.add(new Chunk("如果不服本决定，可以依法在60日内向", simfang2312_z5));
                phrase3.add(ChunkFactory.underLine(book.push(), 57.75f, simfang2312_z5));
                phrase3.add(new Chunk("人民政府或者", simfang2312_z5));
                phrase3.add(ChunkFactory.underLine(book.push(), 73.5f, simfang2312_z5));
                phrase3.add(new Chunk("申请行政复议，或者在6个月内依法向", simfang2312_z5));
                phrase3.add(ChunkFactory.underLine(book.push(), 57.75f, simfang2312_z5));
                phrase3.add(new Chunk("人民法院提起行政诉讼，但本决定不停止执行，法律另有规定的除外。逾期不申请行政复议、不提起行政诉讼又不履行的，本机关将依法申请人民法院强制执行。", simfang2312_z5));
                paragraph3.add(phrase3);
                document.add(paragraph3);
                printerFrameWorkG1(book);
                printerFrameWorkPic(postmaskimage);
                document.newPage();// 结束保存
            }
        });

    }

    //延期（分期）缴纳罚款审批表
    protected void printerEntity_Book_2017_37(final Base_Entity book, final Object postmaskimage) {
        printerFrameWork(book, postmaskimage, new IPdfBackFrame() {
            @Override
            public void writeContent() throws Exception {
                //此处写页面布局
                book.push();
                book.push();
                book.push();
                printerFrameWorkTitle(book, "安全生产行政执法文书", "延期（分期）缴纳罚款审批表", "安监缴审");
                document.add(space3);
                PdfPTable table = null;
                float[] widths = new float[4];
                widths[0] = 1f;
                widths[1] = 1f;
                widths[2] = 1f;
                widths[3] = 1f;
                widths[0] = 1620.0f;
                widths[1] = 2880.0f;
                widths[2] = 900.0f;
                widths[3] = 3240.0f;
                table = new PdfPTable(4);
                table.setWidthPercentage(100f);
                table.setWidths(widths);
                PdfPCell cell_0 = new PdfPCellBuilder(new ParagraphBuilder("案件名称", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setVerticalAlignmentS(Element.ALIGN_MIDDLE).setHorizontalAlignmentS(Element.ALIGN_CENTER);
                cell_0.setFixedHeight(26.515152f);
                table.addCell(cell_0);
                PdfPCell cell_1 = new PdfPCellBuilder(new ParagraphBuilder(book.push(), simfang2312_z5));
                cell_1.setColspan(3);
                cell_1.setFixedHeight(26.515152f);
                table.addCell(cell_1);
                PdfPCell cell_2 = new PdfPCellBuilder(new ParagraphBuilder("处罚决定书\n" +
                        "文号\n", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setVerticalAlignmentS(Element.ALIGN_MIDDLE).setHorizontalAlignmentS(Element.ALIGN_CENTER);
                cell_2.setFixedHeight(41.919193f);
                table.addCell(cell_2);
                PdfPCell cell_3 = new PdfPCellBuilder(new ParagraphBuilder(book.push(), simfang2312_z5));
                cell_3.setColspan(3);
                cell_3.setFixedHeight(41.919193f);
                table.addCell(cell_3);
                PdfPCell cell_4 = new PdfPCellBuilder(new ParagraphBuilder("当事人", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setVerticalAlignmentS(Element.ALIGN_MIDDLE).setHorizontalAlignmentS(Element.ALIGN_CENTER);
                cell_4.setFixedHeight(29.848484f);
                table.addCell(cell_4);
                PdfPCell cell_5 = new PdfPCellBuilder(new ParagraphBuilder(book.push(), simfang2312_z5));
                cell_5.setFixedHeight(29.848484f);
                table.addCell(cell_5);
                PdfPCell cell_6 = new PdfPCellBuilder(new ParagraphBuilder("地址", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setVerticalAlignmentS(Element.ALIGN_MIDDLE).setHorizontalAlignmentS(Element.ALIGN_CENTER);
                cell_6.setFixedHeight(29.848484f);
                table.addCell(cell_6);
                PdfPCell cell_7 = new PdfPCellBuilder(new ParagraphBuilder(book.push(), simfang2312_z5));
                cell_7.setFixedHeight(29.848484f);
                table.addCell(cell_7);
                PdfPCell cell_8 = new PdfPCellBuilder(new ParagraphBuilder("违法事实\n" +
                        "及处罚决定\n", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setVerticalAlignmentS(Element.ALIGN_MIDDLE).setHorizontalAlignmentS(Element.ALIGN_CENTER);
                cell_8.setFixedHeight(115.252525f);
                table.addCell(cell_8);
                PdfPCell cell_9 = new PdfPCellBuilder(new ParagraphBuilder(book.push(), simfang2312_z5));
                cell_9.setColspan(3);
                cell_9.setFixedHeight(115.252525f);
                table.addCell(cell_9);
                PdfPCell cell_10 = new PdfPCellBuilder(new ParagraphBuilder("当事人申请延期（分期）缴纳罚款的理由", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setVerticalAlignmentS(Element.ALIGN_MIDDLE).setHorizontalAlignmentS(Element.ALIGN_CENTER);
                cell_10.setFixedHeight(100.0f);
                table.addCell(cell_10);
                PdfPCell cell_11 = new PdfPCellBuilder(new ParagraphBuilder(book.push(), simfang2312_z5));
                cell_11.setColspan(3);
                cell_11.setFixedHeight(100.0f);
                table.addCell(cell_11);
                PdfPCell cell_12 = new PdfPCellBuilder(new ParagraphBuilder("承办人意见", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setVerticalAlignmentS(Element.ALIGN_MIDDLE).setHorizontalAlignmentS(Element.ALIGN_CENTER);
                cell_12.setFixedHeight(72.676765f);
                table.addCell(cell_12);
                Paragraph paragraph1 = new ParagraphBuilder();
                paragraph1.setLeading(simfang2312_z5.getSize() * 1.5f);
//                paragraph1.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase1 = new Phrase();
                phrase1.add(ChunkFactory.tablenounderLine(book.push(), "                                                              ", simfang2312_z5, 0, StringFactoryBuild.build().getStringLength("                                                               ", simfang2312_z5)));
                paragraph1.add(phrase1);
                Paragraph paragraph4 = new ParagraphBuilder();
                paragraph4.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph4.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase4 = new Phrase();
                phrase4.add(new Chunk("承办人（签名）:", simfang2312_z5));
                phrase4.add(ChunkFactory.tableunderLine(book.push(), 73.5f, simfang2312_z5));
                phrase4.add(new Chunk(" ", simfang2312_z5));
                phrase4.add(ChunkFactory.tableunderLine(book.push(), 57.75f, simfang2312_z5));
                paragraph4.add(phrase4);
                Paragraph paragraph6 = new ParagraphBuilder();
                paragraph6.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph6.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase6 = new Phrase();
                phrase6.add(ChunkFactory.nounderLine("", 200f, simfang2312_z5));
                phrase6.add(ChunkFactory.tablenounderLine(book.pushneedcheck(), 0, 42f, simfang2312_z5));
                phrase6.add(new Chunk("年", simfang2312_z5));
                phrase6.add(ChunkFactory.tablenounderLine(book.pushneedcheck(), 1, 21f, simfang2312_z5));
                phrase6.add(new Chunk("月", simfang2312_z5));
                phrase6.add(ChunkFactory.tablenounderLine(book.push(true), 2, 21f, simfang2312_z5));
                phrase6.add(new Chunk("日", simfang2312_z5));
                paragraph6.add(phrase6);
                PdfPCell cell_13 = new PdfPCellBuilder();
                cell_13.addElement(paragraph1);
                cell_13.addElement(paragraph4);
                cell_13.addElement(paragraph6);
                cell_13.setColspan(3);
                cell_13.setFixedHeight(72.676765f);
                table.addCell(cell_13);
                PdfPCell cell_14 = new PdfPCellBuilder(new ParagraphBuilder("审核意见", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setVerticalAlignmentS(Element.ALIGN_MIDDLE).setHorizontalAlignmentS(Element.ALIGN_CENTER);
                cell_14.setFixedHeight(56);
                table.addCell(cell_14);

                Paragraph paragraph7 = new ParagraphBuilder();
                paragraph7.setLeading(simfang2312_z5.getSize() * 1.5f);
//                paragraph7.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase7 = new Phrase();
                phrase7.add(ChunkFactory.tablenounderLine(book.push(), StringFactoryBuild.build().getStringLength("                                                               ", simfang2312_z5) * 1, simfang2312_z5, 0, StringFactoryBuild.build().getStringLength("                                                               ", simfang2312_z5)));
//                phrase7.add(ChunkFactory.nounderLine("7678687686876",400f,simfang2312_z5));
                paragraph7.add(phrase7);
                Paragraph paragraph8 = new ParagraphBuilder();
                paragraph8.setLeading(simfang2312_z5.getSize() * 1.5f);
//                paragraph8.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase8 = new Phrase();
                phrase8.add(new Chunk("审核人（签名）：", simfang2312_z5));
                phrase8.add(ChunkFactory.nounderLine(book.push(), 140f, simfang2312_z5));
                phrase8.add(ChunkFactory.tablenounderLine(book.pushneedcheck(), 0, 42f, simfang2312_z5));
                phrase8.add(new Chunk("年", simfang2312_z5));
                phrase8.add(ChunkFactory.tablenounderLine(book.pushneedcheck(), 1, 21f, simfang2312_z5));
                phrase8.add(new Chunk("月", simfang2312_z5));
                phrase8.add(ChunkFactory.tablenounderLine(book.push(true), 2, 21f, simfang2312_z5));
                phrase8.add(new Chunk("日", simfang2312_z5));
                paragraph8.add(phrase8);
                PdfPCell cell_15 = new PdfPCellBuilder();
                cell_15.addElement(paragraph7);
                cell_15.addElement(paragraph8);
                cell_15.setColspan(3);
                cell_15.setFixedHeight(56);
                table.addCell(cell_15);
                PdfPCell cell_16 = new PdfPCellBuilder(new ParagraphBuilder("审批意见", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setVerticalAlignmentS(Element.ALIGN_MIDDLE).setHorizontalAlignmentS(Element.ALIGN_CENTER);
                cell_16.setFixedHeight(56);
                table.addCell(cell_16);
                Paragraph paragraph9 = new ParagraphBuilder();
                paragraph9.setLeading(simfang2312_z5.getSize() * 1.5f);
//                paragraph9.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase9 = new Phrase();
                phrase9.add(ChunkFactory.tablenounderLine(book.push(), StringFactoryBuild.build().getStringLength("                                                               ", simfang2312_z5) * 1, simfang2312_z5, 0, StringFactoryBuild.build().getStringLength("                                                               ", simfang2312_z5)));
//                phrase9.add(ChunkFactory.tableunderLine(book.push(),300f,simfang2312_z5,0,StringFactoryBuild.build().getStringLength("                                                                 ",simfang2312_z5)));
                paragraph9.add(phrase9);
                Paragraph paragraph10 = new ParagraphBuilder();
                paragraph10.setLeading(simfang2312_z5.getSize() * 1.5f);
//                paragraph10.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase10 = new Phrase();
                phrase10.add(new Chunk("审批人（签名）：", simfang2312_z5));
                phrase10.add(ChunkFactory.nounderLine(book.push(), 140f, simfang2312_z5));
                phrase10.add(ChunkFactory.tablenounderLine(book.pushneedcheck(), 0, 42f, simfang2312_z5));
                phrase10.add(new Chunk("年", simfang2312_z5));
                phrase10.add(ChunkFactory.tablenounderLine(book.pushneedcheck(), 1, 21f, simfang2312_z5));
                phrase10.add(new Chunk("月", simfang2312_z5));
                phrase10.add(ChunkFactory.tablenounderLine(book.push(true), 2, 21f, simfang2312_z5));
                phrase10.add(new Chunk("日", simfang2312_z5));
                paragraph10.add(phrase10);
                PdfPCell cell_17 = new PdfPCellBuilder();
                cell_17.addElement(paragraph9);
                cell_17.addElement(paragraph10);
                cell_17.setColspan(3);
                cell_17.setFixedHeight(56);
                table.addCell(cell_17);
                document.add(table);
                printerFrameWorkPic(postmaskimage);
                document.newPage();// 结束保存
            }
        });

    }

    //延期（分期）缴纳罚款批准书
    protected void printerEntity_Book_2017_38(final Base_Entity book, final Object postmaskimage) {
        printerFrameWork(book, postmaskimage, new IPdfBackFrame() {
            @Override
            public void writeContent() throws Exception {
                //此处写页面布局
                book.push();
                book.push();
                book.push();
                printerFrameWorkTitle(book, "安全生产行政执法文书", "延期（分期）缴纳罚款批准书", "安监缴批");
                Paragraph paragraph1 = new ParagraphBuilder();
                paragraph1.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph1.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase1 = new Phrase();
                phrase1.add(ChunkFactory.underLine(book.push(), 141.75f, simfang2312_z5));
                phrase1.add(new Chunk("：", simfang2312_z5));
                paragraph1.add(phrase1);
                document.add(paragraph1);
                Paragraph paragraph2 = new ParagraphBuilder();
                paragraph2.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph2.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase2 = new Phrase();
                phrase2.add(ChunkFactory.underLine(book.pushneedcheck(), 0, 26.25f, simfang2312_z5));
                phrase2.add(new Chunk("年", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.pushneedcheck(), 1, 21.0f, simfang2312_z5));
                phrase2.add(new Chunk("月", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.push(true), 2, 21.0f, simfang2312_z5));
                phrase2.add(new Chunk("日，本机关对你（单位）发出", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.push(), "                                ", simfang2312_z5));
                paragraph2.add(phrase2);
                document.add(paragraph2);
                Paragraph paragraph3 = new ParagraphBuilder();
                paragraph3.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph3.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase3 = new Phrase();
                phrase3.add(new Chunk("号《行政处罚决定书》，作出了对你（单位）罚款", simfang2312_z5));
                phrase3.add(ChunkFactory.underLine(book.push(), "                                                        ", simfang2312_z5, "号《行政处罚决定书》，作出了对你（单位）罚款", -1));
                phrase3.add(new Chunk("（大写）的决定，现根据你（单位）的申请，本机关依据《中华人民共和国行政处罚法》第五十二条的规定，同意你（单位）：", simfang2312_z5));
                phrase3.add(ChunkFactory.nounderLine("", 199.5f, simfang2312_z5));
                paragraph3.add(phrase3);
                document.add(paragraph3);
                Paragraph paragraph5 = new ParagraphBuilder();
                paragraph5.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph5.setFirstLineIndent(simfang2312_z5.getSize() * 3f);

                book.push();
                RadioCheckField bt5 = new RadioCheckField(dpfwPdfWriter,
                        ChunkFactory.setCheckBoxArea(105, 471, 10), "Yes2e03f24dbe5343b296ed8260420a62d1",
                        ChunkFactory.getCheck(book.getValue(7), 1));
                bt5.setCheckType(RadioCheckField.TYPE_CHECK);
                bt5.setBorderWidth(BaseField.BORDER_WIDTH_THIN);
                bt5.setBorderColor(BaseColor.BLACK);
                bt5.setChecked(true);
                PdfFormField ck5 = bt5.getCheckField();
                dpfwPdfWriter.addAnnotation(ck5);
                RadioCheckField bt6 = new RadioCheckField(dpfwPdfWriter,
                        ChunkFactory.setCheckBoxArea(105, 451, 10), "Yes81b3322808f0490d902a0dceb6598161",
                        ChunkFactory.getCheck(book.getValue(7), 2));
                bt6.setCheckType(RadioCheckField.TYPE_CHECK);
                bt6.setBorderWidth(BaseField.BORDER_WIDTH_THIN);
                bt6.setBorderColor(BaseColor.BLACK);
                bt6.setChecked(true);
                PdfFormField ck6 = bt6.getCheckField();
                dpfwPdfWriter.addAnnotation(ck6);

                Phrase phrase5 = new Phrase();
                phrase5.add(new Chunk("延期缴纳罚款。延长至", simfang2312_z5));
                phrase5.add(ChunkFactory.underLine(book.pushneedcheck(), 0, 36.75f, simfang2312_z5));
                phrase5.add(new Chunk("年", simfang2312_z5));
                phrase5.add(ChunkFactory.underLine(book.pushneedcheck(), 1, 26.25f, simfang2312_z5));
                phrase5.add(new Chunk("月", simfang2312_z5));
                phrase5.add(ChunkFactory.underLine(book.push(true), 2, 26.25f, simfang2312_z5));
                phrase5.add(new Chunk("日（大写）止。", simfang2312_z5));
                paragraph5.add(phrase5);
                document.add(paragraph5);
                Paragraph paragraph6 = new ParagraphBuilder();
                paragraph6.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph6.setFirstLineIndent(simfang2312_z5.getSize() * 3f);
                Phrase phrase6 = new Phrase();

                phrase6.add(new Chunk("分期缴纳罚款。第", simfang2312_z5));
                phrase6.add(ChunkFactory.underLine(book.push(), 21.0f, simfang2312_z5));
                phrase6.add(new Chunk("期至", simfang2312_z5));
                phrase6.add(ChunkFactory.underLine(book.pushneedcheck(), 0, 31.5f, simfang2312_z5));
                phrase6.add(new Chunk("年", simfang2312_z5));
                phrase6.add(ChunkFactory.underLine(book.pushneedcheck(), 1, 26.25f, simfang2312_z5));
                phrase6.add(new Chunk("月", simfang2312_z5));
                phrase6.add(ChunkFactory.underLine(book.push(true), 2, 21.0f, simfang2312_z5));
                phrase6.add(new Chunk("日（大写）前，缴纳罚款", simfang2312_z5));
                phrase6.add(ChunkFactory.underLine(book.push(), 94.5f, simfang2312_z5, "一空格分期缴纳罚款。第    期至      年     月    日（大写）前，缴纳罚款", -1));
                phrase6.add(new Chunk("元（大写）（每期均应当单独开具本文书）。此外，尚有未缴纳的罚款", simfang2312_z5));
                phrase6.add(ChunkFactory.underLine(book.push(), 94.5f, simfang2312_z5, "1234567890元（大写）（每期均应当单独开具本文书）。此外，尚有未缴纳的罚款", -1));
                phrase6.add(new Chunk("元（大写）。", simfang2312_z5));
                paragraph6.add(phrase6);
                document.add(paragraph6);
                Paragraph paragraph7 = new ParagraphBuilder();
                paragraph7.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph7.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase7 = new Phrase();
                phrase7.add(new Chunk("代收机构以本批准书为据，办理收款手续。", simfang2312_z5));
                paragraph7.add(phrase7);
                document.add(paragraph7);
                Paragraph paragraph8 = new ParagraphBuilder();
                paragraph8.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph8.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase8 = new Phrase();
                phrase8.add(new Chunk("逾期缴纳罚款的，依据《中华人民共和国行政处罚法》第五十一条第一项的规定，每日按罚款数额的3%加处罚款。", simfang2312_z5));
                paragraph8.add(phrase8);
                document.add(paragraph8);
                printerFrameWorkG1(book);
                printerFrameWorkPic(postmaskimage);
                document.newPage();// 结束保存
            }
        });

    }

    //文书送达回执
    protected void printerEntity_Book_2017_39(final Base_Entity book, final Object postmaskimage) {
        printerFrameWork(book, postmaskimage, new IPdfBackFrame() {
            @Override
            public void writeContent() throws Exception {
                //此处写页面布局
                book.push();
                book.push();
                book.push();
                printerFrameWorkTitle(book, "安全生产行政执法文书", "文书送达回执", "安监回");
                Paragraph paragraph1 = new ParagraphBuilder();
                paragraph1.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph1.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase1 = new Phrase();
                phrase1.add(new Chunk("案件名称：", simfang2312_z5));
                phrase1.add(ChunkFactory.underLine(book.push(), 315.0f, simfang2312_z5));
                paragraph1.add(phrase1);
                document.add(paragraph1);
                document.add(space3);
                PdfPTable table = null;
                float[] widths = new float[6];
                widths[0] = 1f;
                widths[1] = 1f;
                widths[2] = 1f;
                widths[3] = 1f;
                widths[4] = 1f;
                widths[5] = 1f;
                widths[0] = 2520.0f;
                widths[1] = 1440.0f;
                widths[2] = 1440.0f;
                widths[3] = 1080.0f;
                widths[4] = 1080.0f;
                widths[5] = 1080.0f;
                table = new PdfPTable(6);
                table.setWidthPercentage(100f);
                table.setWidths(widths);
                PdfPCell cell_0 = new PdfPCellBuilder(new ParagraphBuilder("受送达单位（个人）", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_0.setFixedHeight(36.21212f);
                table.addCell(cell_0);
                PdfPCell cell_1 = new PdfPCellBuilder(new ParagraphBuilder(book.push(), simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_1.setColspan(5);
                cell_1.setFixedHeight(36.21212f);
                table.addCell(cell_1);
                PdfPCell cell_2 = new PdfPCellBuilder(new ParagraphBuilder("送达文书名称、文号", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_2.setFixedHeight(42.424244f);
                table.addCell(cell_2);
                PdfPCell cell_3 = new PdfPCellBuilder(new ParagraphBuilder("收件人签名\n" +
                        "或者盖章\n", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_3.setFixedHeight(42.424244f);
                table.addCell(cell_3);
                PdfPCell cell_4 = new PdfPCellBuilder(new ParagraphBuilder("送达\n" +
                        "地点\n", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_4.setFixedHeight(42.424244f);
                table.addCell(cell_4);
                PdfPCell cell_5 = new PdfPCellBuilder(new ParagraphBuilder("送达\n" +
                        "日期\n", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_5.setFixedHeight(42.424244f);
                table.addCell(cell_5);
                PdfPCell cell_6 = new PdfPCellBuilder(new ParagraphBuilder("送达\n" +
                        "方式\n", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_6.setFixedHeight(42.424244f);
                table.addCell(cell_6);
                PdfPCell cell_7 = new PdfPCellBuilder(new ParagraphBuilder("送达人", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_7.setFixedHeight(42.424244f);
                table.addCell(cell_7);
                for (int i = 0; i < 5; i++) {
                    int j = 0;
                    PdfPCell cell_8 = new PdfPCellBuilder(new ParagraphBuilder(getListItemValue(book.pushneedcheck(), i, j++), simfang2312_z5));
                    cell_8.setRowspan(2);
                    cell_8.setFixedHeight(28.686869f);
                    table.addCell(cell_8);
                    PdfPCell cell_9 = new PdfPCellBuilder(new ParagraphBuilder(getListItemValue(book.pushneedcheck(), i, j++), simfang2312_z5));
                    cell_9.setRowspan(2);
                    cell_9.setFixedHeight(28.686869f);
                    table.addCell(cell_9);
                    PdfPCell cell_10 = new PdfPCellBuilder(new ParagraphBuilder(getListItemValue(book.pushneedcheck(), i, j++), simfang2312_z5));
                    cell_10.setRowspan(2);
                    cell_10.setFixedHeight(28.686869f);
                    table.addCell(cell_10);
                    PdfPCell cell_11 = new PdfPCellBuilder(new ParagraphBuilder(getListItemValue(book.pushneedcheck(), i, j++), simfang2312_z5));
                    cell_11.setRowspan(2);
                    cell_11.setFixedHeight(28.686869f);
                    table.addCell(cell_11);
                    PdfPCell cell_12 = new PdfPCellBuilder(new ParagraphBuilder(getListItemValue(book.pushneedcheck(), i, j++), simfang2312_z5));
                    cell_12.setRowspan(2);
                    cell_12.setFixedHeight(28.686869f);
                    table.addCell(cell_12);
                    PdfPCell cell_13 = new PdfPCellBuilder(new ParagraphBuilder(getListItemValue(book.pushneedcheck(), i, j++), simfang2312_z5));
                    cell_13.setFixedHeight(28.686869f);
                    table.addCell(cell_13);
                    PdfPCell cell_14 = new PdfPCellBuilder(new ParagraphBuilder(getListItemValue(book.pushneedcheck(), i, j++), simfang2312_z5));
                    cell_14.setFixedHeight(27.676767f);
                    table.addCell(cell_14);
                    j = 0;
                }
                book.push(true);
                PdfPCell cell_43 = new PdfPCellBuilder(new ParagraphBuilder(getPostmark()+"           ", simfang2312_z5).setAlignmentS(Element.ALIGN_RIGHT)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_43.setColspan(6);
                cell_43.setFixedHeight(35.555557f);
                table.addCell(cell_43);
                PdfPCell cell_44 = new PdfPCellBuilder(new ParagraphBuilder("备注：" + book.push(), simfang2312_z5));
                cell_44.setColspan(6);
                cell_44.setFixedHeight(21.313131f);
                table.addCell(cell_44);
                document.add(table);
                Paragraph paragraph2 = new ParagraphBuilder();
                paragraph2.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph2.setFirstLineIndent(simfang2312_z5.getSize() * 1f);
                Phrase phrase2 = new Phrase();
                phrase2.add(new Chunk("注：1.一个案件各类文书的送达，统一使用一份送达回执。", simfang2312_z5));
                paragraph2.add(phrase2);
                document.add(paragraph2);
                Paragraph paragraph3 = new ParagraphBuilder();
                paragraph3.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph3.setFirstLineIndent(simfang2312_z5.getSize() * 3f);
                Phrase phrase3 = new Phrase();
                phrase3.add(new Chunk("2.各类文书送达参照民事诉讼法有关送达的规定执行。", simfang2312_z5));
                paragraph3.add(phrase3);
                document.add(paragraph3);
                Paragraph paragraph4 = new ParagraphBuilder();
                paragraph4.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph4.setFirstLineIndent(simfang2312_z5.getSize() * 3f);
                Phrase phrase4 = new Phrase();
                phrase4.add(new Chunk("3.他人代收的，由代收人在收件人栏内签名或者盖章，并在备注栏内注明与被送达人的关系；留置送达的，在备注栏说明情况，并由证明人签字。", simfang2312_z5));
                paragraph4.add(phrase4);
                document.add(paragraph4);
                printerFrameWorkPic(postmaskimage);
                document.newPage();
            }
        });

    }

    //行政强制执行事先催告书
    protected void printerEntity_Book_2017_40(final Base_Entity book, final Object postmaskimage) {
        printerFrameWork(book, postmaskimage, new IPdfBackFrame() {
            @Override
            public void writeContent() throws Exception {
                //此处写页面布局
                book.push();
                book.push();
                book.push();
                printerFrameWorkTitle(book, "安全生产行政执法文书", "行政强制执行事先催告书", "安监执行催告");
                Paragraph paragraph1 = new ParagraphBuilder();
                paragraph1.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph1.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase1 = new Phrase();
                phrase1.add(ChunkFactory.underLine(book.push(), 115.5f, simfang2312_z5));
                phrase1.add(new Chunk("：", simfang2312_z5));
                paragraph1.add(phrase1);
                document.add(paragraph1);
                Paragraph paragraph2 = new ParagraphBuilder();
                paragraph2.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph2.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase2 = new Phrase();
                phrase2.add(new Chunk("本机关于", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.pushneedcheck(), 0, 26.25f, simfang2312_z5));
                phrase2.add(new Chunk("年", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.pushneedcheck(), 1, 15.75f, simfang2312_z5));
                phrase2.add(new Chunk("月", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.push(true), 2, 15.75f, simfang2312_z5));
                phrase2.add(new Chunk("日对你（单位）作出的", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.push(), 63.0f, simfang2312_z5));
                phrase2.add(new Chunk("尚未履行，你（单位）在法定期限内未申请行政复议或者提起行政诉讼。依据《中华人民共和国行政强制法》第五十三条、第五十四条的规定，请你（单位）：", simfang2312_z5));
                paragraph2.add(phrase2);
                document.add(paragraph2);

                book.push();
                RadioCheckField bt3 = new RadioCheckField(dpfwPdfWriter,
                        ChunkFactory.setCheckBoxArea(105, 513, 10), "Yesad20339842674a0589e931ef558e5779",
                        ChunkFactory.getCheck(book.getValue(11), 1));
                bt3.setCheckType(RadioCheckField.TYPE_CHECK);
                bt3.setBorderWidth(BaseField.BORDER_WIDTH_THIN);
                bt3.setBorderColor(BaseColor.BLACK);
                bt3.setChecked(true);
                PdfFormField ck3 = bt3.getCheckField();
                dpfwPdfWriter.addAnnotation(ck3);
                RadioCheckField bt4 = new RadioCheckField(dpfwPdfWriter,
                        ChunkFactory.setCheckBoxArea(105, 469, 10), "Yes9028bc431441417982c522acb853cd20",
                        ChunkFactory.getCheck(book.getValue(11), 2));
                bt4.setCheckType(RadioCheckField.TYPE_CHECK);
                bt4.setBorderWidth(BaseField.BORDER_WIDTH_THIN);
                bt4.setBorderColor(BaseColor.BLACK);
                bt4.setChecked(true);
                PdfFormField ck4 = bt4.getCheckField();
                dpfwPdfWriter.addAnnotation(ck4);

                Paragraph paragraph3 = new ParagraphBuilder();
                paragraph3.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph3.setFirstLineIndent(simfang2312_z5.getSize() * 3f);
                Phrase phrase3 = new Phrase();
                phrase3.add(new Chunk("于", simfang2312_z5));
                phrase3.add(ChunkFactory.underLine(book.pushneedcheck(), 0, 31.5f, simfang2312_z5));
                phrase3.add(new Chunk("年", simfang2312_z5));
                phrase3.add(ChunkFactory.underLine(book.pushneedcheck(), 1, 21.0f, simfang2312_z5));
                phrase3.add(new Chunk("月", simfang2312_z5));
                phrase3.add(ChunkFactory.underLine(book.push(true), 2, 21.0f, simfang2312_z5));
                phrase3.add(new Chunk("日前将罚款", simfang2312_z5));
                phrase3.add(ChunkFactory.underLine(book.push(), 63.0f, simfang2312_z5));
                phrase3.add(new Chunk("元（大写），加处罚款", simfang2312_z5));
                phrase3.add(ChunkFactory.underLine(book.push(), 31.5f, simfang2312_z5));
                phrase3.add(new Chunk("元（大写），（合计：", simfang2312_z5));
                phrase3.add(ChunkFactory.underLine(book.push(), 31.5f, simfang2312_z5));
                phrase3.add(new Chunk("元）缴至", simfang2312_z5));
                phrase3.add(ChunkFactory.underLine(book.push(), 57.75f, simfang2312_z5));
                phrase3.add(new Chunk("。", simfang2312_z5));
                paragraph3.add(phrase3);
                document.add(paragraph3);
                Paragraph paragraph4 = new ParagraphBuilder();
                paragraph4.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph4.setFirstLineIndent(simfang2312_z5.getSize() * 3f);
                Phrase phrase4 = new Phrase();

                phrase4.add(new Chunk("立即履行以下行政决定：", simfang2312_z5));
                phrase4.add(ChunkFactory.underLine(book.push(), 215.25f, simfang2312_z5));
                phrase4.add(new Chunk("。", simfang2312_z5));
                paragraph4.add(phrase4);
                document.add(paragraph4);
                Paragraph paragraph5 = new ParagraphBuilder();
                paragraph5.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph5.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase5 = new Phrase();
                phrase5.add(new Chunk("如你（单位）不履行上述义务，本机关将依据《中华人民共和国行政强制法》第五十三条、五十四条的规定，申请人民法院强制执行。", simfang2312_z5));
                paragraph5.add(phrase5);
                document.add(paragraph5);
                printerFrameWorkG1(book);
                printerFrameWorkPic(postmaskimage);
                document.newPage();// 结束保存
            }
        });

    }

    //强制执行申请书
    protected void printerEntity_Book_2017_41(final Base_Entity book, final Object postmaskimage) {
        printerFrameWork(book, postmaskimage, new IPdfBackFrame() {
            @Override
            public void writeContent() throws Exception {
                //此处写页面布局
                book.push();
                book.push();
                book.push();
                printerFrameWorkTitleSpecial(book, "安全生产行政执法文书", "强制执行申请书", "安监强执");


                Paragraph paragraph1 = new ParagraphBuilder();
                paragraph1.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph1.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase1 = new Phrase();
                phrase1.add(ChunkFactory.underLine(book.push(), 89.25f, simfang2312_z5));
                phrase1.add(new Chunk("人民法院：", simfang2312_z5));
                paragraph1.add(phrase1);
                document.add(paragraph1);
                Paragraph paragraph2 = new ParagraphBuilder();
                paragraph2.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph2.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase2 = new Phrase();
                phrase2.add(new Chunk("本行政机关于", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.pushneedcheck(), 0, 26.25f, simfang2312_z5));
                phrase2.add(new Chunk("年", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.pushneedcheck(), 1, 15.75f, simfang2312_z5));
                phrase2.add(new Chunk("月", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.push(true), 2, 15.75f, simfang2312_z5));
                phrase2.add(new Chunk("日对被申请执行人", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.push(), 141.75f, simfang2312_z5));
                phrase2.add(new Chunk("作出了", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.push(), 136.5f, simfang2312_z5));
                phrase2.add(new Chunk("的行政决定（文号：", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.push(), 89.25f, simfang2312_z5));
                phrase2.add(new Chunk("），被申请执行人在法定的期限内未履行该行政决定。根据《中华人民共和国行政处罚法》第五十一条及《中华人民共和国行政强制法》第五十三条、五十四条的规定，特申请贵院强制执行。", simfang2312_z5));
                paragraph2.add(phrase2);
                document.add(paragraph2);
                Paragraph paragraph3 = new ParagraphBuilder();
                paragraph3.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph3.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase3 = new Phrase();
                phrase3.add(new Chunk("附有关材料：", simfang2312_z5));
                phrase3.add(ChunkFactory.nounderLine(book.push(), 4800f, simfang2312_z5, "空格附有关材料：", -1));
                paragraph3.add(phrase3);
                document.add(paragraph3);
                printerFrameWorkG2(book);
                Paragraph paragraph4 = new ParagraphBuilder();
                paragraph4.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph4.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase4 = new Phrase();
                phrase4.add(new Chunk("联系人：", simfang2312_z5));
                phrase4.add(ChunkFactory.nounderLine(book.push(), 99.75f, simfang2312_z5));
                phrase4.add(new Chunk("联系电话：", simfang2312_z5));
                phrase4.add(ChunkFactory.nounderLine(book.push(), 147.0f, simfang2312_z5));
                paragraph4.add(phrase4);
                document.add(paragraph4);
                printerFrameWorkPic(postmaskimage);
                document.newPage();// 结束保存
            }
        });

    }

    //案件移送审批表
    protected void printerEntity_Book_2017_42(final Base_Entity book, final Object postmaskimage) {
        printerFrameWork(book, postmaskimage, new IPdfBackFrame() {
            @Override
            public void writeContent() throws Exception {
                //此处写页面布局
                book.push();
                book.push();
                book.push();
                printerFrameWorkTitle(book, "安全生产行政执法文书", "案件移送审批表", "安监移审");
                document.add(space4);
                PdfPTable table = null;
                float[] widths = new float[2];
                widths[0] = 1f;
                widths[1] = 1f;
                widths[0] = 1620.0f;
                widths[1] = 7200.0f;
                table = new PdfPTable(2);
                table.setWidthPercentage(100f);
                table.setWidths(widths);
                PdfPCell cell_0 = new PdfPCellBuilder(new ParagraphBuilder("案由", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setVerticalAlignmentS(Element.ALIGN_MIDDLE).setHorizontalAlignmentS(Element.ALIGN_CENTER);
                cell_0.setFixedHeight(28f);
                table.addCell(cell_0);
                PdfPCell cell_1 = new PdfPCellBuilder(new ParagraphBuilder(book.push(), simfang2312_z5));
                cell_1.setFixedHeight(28f);
                table.addCell(cell_1);
                PdfPCell cell_2 = new PdfPCellBuilder(new ParagraphBuilder("当事人", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setVerticalAlignmentS(Element.ALIGN_MIDDLE).setHorizontalAlignmentS(Element.ALIGN_CENTER);
                cell_2.setFixedHeight(28f);
                table.addCell(cell_2);
                PdfPCell cell_3 = new PdfPCellBuilder(new ParagraphBuilder(book.push(), simfang2312_z5));
                cell_3.setFixedHeight(28f);
                table.addCell(cell_3);
                PdfPCell cell_4 = new PdfPCellBuilder(new ParagraphBuilder("地址", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setVerticalAlignmentS(Element.ALIGN_MIDDLE).setHorizontalAlignmentS(Element.ALIGN_CENTER);
                cell_4.setFixedHeight(28f);
                table.addCell(cell_4);
                PdfPCell cell_5 = new PdfPCellBuilder(new ParagraphBuilder(book.push(), simfang2312_z5));
                cell_5.setFixedHeight(28f);
                table.addCell(cell_5);
                PdfPCell cell_6 = new PdfPCellBuilder(new ParagraphBuilder("受移送机关", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setVerticalAlignmentS(Element.ALIGN_MIDDLE).setHorizontalAlignmentS(Element.ALIGN_CENTER);
                cell_6.setFixedHeight(28f);
                table.addCell(cell_6);
                PdfPCell cell_7 = new PdfPCellBuilder(new ParagraphBuilder(book.push(), simfang2312_z5));
                cell_7.setFixedHeight(28f);
                table.addCell(cell_7);
                PdfPCell cell_8 = new PdfPCellBuilder(new ParagraphBuilder("案情简介", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setVerticalAlignmentS(Element.ALIGN_MIDDLE).setHorizontalAlignmentS(Element.ALIGN_CENTER);
                cell_8.setFixedHeight(50.454544f);
                table.addCell(cell_8);
                PdfPCell cell_9 = new PdfPCellBuilder(new ParagraphBuilder(book.push(), simfang2312_z5));
                cell_9.setFixedHeight(50.454544f);
                table.addCell(cell_9);
                PdfPCell cell_10 = new PdfPCellBuilder(new ParagraphBuilder("移送理由", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setVerticalAlignmentS(Element.ALIGN_MIDDLE).setHorizontalAlignmentS(Element.ALIGN_CENTER);
                cell_10.setFixedHeight(56.11111f);
                table.addCell(cell_10);
                PdfPCell cell_11 = new PdfPCellBuilder(new ParagraphBuilder(book.push(), simfang2312_z5));
                cell_11.setFixedHeight(56.11111f);
                table.addCell(cell_11);
                PdfPCell cell_12 = new PdfPCellBuilder(new ParagraphBuilder("承办人员\n" +
                        "拟办意见\n", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setVerticalAlignmentS(Element.ALIGN_MIDDLE).setHorizontalAlignmentS(Element.ALIGN_CENTER);
                cell_12.setFixedHeight(91.91919f);
                table.addCell(cell_12);
                Paragraph paragraph1 = new ParagraphBuilder();
                paragraph1.setLeading(simfang2312_z5.getSize() * 1.5f);
//                paragraph1.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase1 = new Phrase();
                phrase1.add(ChunkFactory.tablenounderLine(book.push(), "                                                                                                                            ", simfang2312_z5, 0, StringFactoryBuild.build().getStringLength("                                                               ", simfang2312_z5)));
                paragraph1.add(phrase1);
                Paragraph paragraph4 = new ParagraphBuilder();
                paragraph4.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph4.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase4 = new Phrase();
                phrase4.add(new Chunk("承办人（签名）:", simfang2312_z5));
                phrase4.add(ChunkFactory.tableunderLine(book.push(), 73.5f, simfang2312_z5));
                phrase4.add(new Chunk(" ", simfang2312_z5));
                phrase4.add(ChunkFactory.tableunderLine(book.push(), 57.75f, simfang2312_z5));
                paragraph4.add(phrase4);
                Paragraph paragraph6 = new ParagraphBuilder();
                paragraph6.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph6.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase6 = new Phrase();
                phrase6.add(ChunkFactory.nounderLine(book.push(), 200f, simfang2312_z5));
                phrase6.add(ChunkFactory.tablenounderLine(book.pushneedcheck(), 0, 42f, simfang2312_z5));
                phrase6.add(new Chunk("年", simfang2312_z5));
                phrase6.add(ChunkFactory.tablenounderLine(book.pushneedcheck(), 1, 21f, simfang2312_z5));
                phrase6.add(new Chunk("月", simfang2312_z5));
                phrase6.add(ChunkFactory.tablenounderLine(book.push(true), 2, 21f, simfang2312_z5));
                phrase6.add(new Chunk("日", simfang2312_z5));
                paragraph6.add(phrase6);
                PdfPCell cell_13 = new PdfPCellBuilder();
                cell_13.addElement(paragraph1);
                cell_13.addElement(paragraph4);
                cell_13.addElement(paragraph6);
                cell_13.setFixedHeight(91.91919f);
                table.addCell(cell_13);
                PdfPCell cell_14 = new PdfPCellBuilder(new ParagraphBuilder("审核意见", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setVerticalAlignmentS(Element.ALIGN_MIDDLE).setHorizontalAlignmentS(Element.ALIGN_CENTER);
                cell_14.setFixedHeight(85.454544f);
                table.addCell(cell_14);
                Paragraph paragraph7 = new ParagraphBuilder();
                paragraph7.setLeading(simfang2312_z5.getSize() * 1.5f);
//                paragraph7.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase7 = new Phrase();
                phrase7.add(ChunkFactory.tablenounderLine(book.push(), StringFactoryBuild.build().getStringLength("                                                                                                                                                                                             ", simfang2312_z5) * 1, simfang2312_z5, 0, StringFactoryBuild.build().getStringLength("                                                               ", simfang2312_z5)));
//                phrase7.add(ChunkFactory.nounderLine("7678687686876",400f,simfang2312_z5));
                paragraph7.add(phrase7);
                Paragraph paragraph8 = new ParagraphBuilder();
                paragraph8.setLeading(simfang2312_z5.getSize() * 1.5f);
//                paragraph8.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase8 = new Phrase();
                phrase8.add(new Chunk("审核人（签名）：", simfang2312_z5));
                phrase8.add(ChunkFactory.nounderLine(book.push(), 140f, simfang2312_z5));
                phrase8.add(ChunkFactory.tablenounderLine(book.pushneedcheck(), 0, 42f, simfang2312_z5));
                phrase8.add(new Chunk("年", simfang2312_z5));
                phrase8.add(ChunkFactory.tablenounderLine(book.pushneedcheck(), 1, 21f, simfang2312_z5));
                phrase8.add(new Chunk("月", simfang2312_z5));
                phrase8.add(ChunkFactory.tablenounderLine(book.push(true), 2, 21f, simfang2312_z5));
                phrase8.add(new Chunk("日", simfang2312_z5));
                paragraph8.add(phrase8);
                PdfPCell cell_15 = new PdfPCellBuilder();
                cell_15.addElement(paragraph7);
                cell_15.addElement(paragraph8);
                cell_15.setFixedHeight(85.454544f);
                table.addCell(cell_15);
                PdfPCell cell_16 = new PdfPCellBuilder(new ParagraphBuilder("审批意见", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setVerticalAlignmentS(Element.ALIGN_MIDDLE).setHorizontalAlignmentS(Element.ALIGN_CENTER);
                cell_16.setFixedHeight(85.454544f);
                table.addCell(cell_16);
                Paragraph paragraph9 = new ParagraphBuilder();
                paragraph9.setLeading(simfang2312_z5.getSize() * 1.5f);
//                paragraph9.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase9 = new Phrase();
                phrase9.add(ChunkFactory.tablenounderLine(book.push(), StringFactoryBuild.build().getStringLength("                                                                                                                                                                                             ", simfang2312_z5) * 1, simfang2312_z5, 0, StringFactoryBuild.build().getStringLength("                                                               ", simfang2312_z5)));
//                phrase9.add(ChunkFactory.tableunderLine(book.push(),300f,simfang2312_z5,0,StringFactoryBuild.build().getStringLength("                                                                 ",simfang2312_z5)));
                paragraph9.add(phrase9);
                Paragraph paragraph10 = new ParagraphBuilder();
                paragraph10.setLeading(simfang2312_z5.getSize() * 1.5f);
//                paragraph10.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase10 = new Phrase();
                phrase10.add(new Chunk("审批人（签名）：", simfang2312_z5));
                phrase10.add(ChunkFactory.nounderLine(book.push(), 140f, simfang2312_z5));
                phrase10.add(ChunkFactory.tablenounderLine(book.pushneedcheck(), 0, 42f, simfang2312_z5));
                phrase10.add(new Chunk("年", simfang2312_z5));
                phrase10.add(ChunkFactory.tablenounderLine(book.pushneedcheck(), 1, 21f, simfang2312_z5));
                phrase10.add(new Chunk("月", simfang2312_z5));
                phrase10.add(ChunkFactory.tablenounderLine(book.push(true), 2, 21f, simfang2312_z5));
                phrase10.add(new Chunk("日", simfang2312_z5));
                paragraph10.add(phrase10);
                PdfPCell cell_17 = new PdfPCellBuilder();
                cell_17.addElement(paragraph9);
                cell_17.addElement(paragraph10);
                cell_17.setFixedHeight(85.454544f);
                table.addCell(cell_17);
                document.add(table);
                printerFrameWorkPic(postmaskimage);
                document.newPage();
            }
        });

    }

    //案件移送书
    protected void printerEntity_Book_2017_43(final Base_Entity book, final Object postmaskimage) {
        printerFrameWork(book, postmaskimage, new IPdfBackFrame() {
            @Override
            public void writeContent() throws Exception {
                //此处写页面布局
                book.push();
                book.push();
                book.push();
                printerFrameWorkTitle(book, "安全生产行政执法文书", "案件移送书", "安监移");
                Paragraph paragraph1 = new ParagraphBuilder();
                paragraph1.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph1.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase1 = new Phrase();
                phrase1.add(ChunkFactory.underLine(book.push(), 120.75f, simfang2312_z5));
                phrase1.add(new Chunk("：", simfang2312_z5));
                paragraph1.add(phrase1);
                document.add(paragraph1);
                Paragraph paragraph2 = new ParagraphBuilder();
                paragraph2.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph2.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase2 = new Phrase();
                phrase2.add(new Chunk("本行政机关于", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.pushneedcheck(), 0, 42.0f, simfang2312_z5));
                phrase2.add(new Chunk("年", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.pushneedcheck(), 1, 26.25f, simfang2312_z5));
                phrase2.add(new Chunk("月", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.push(true), 2, 21.0f, simfang2312_z5));
                phrase2.add(new Chunk("日对", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.push(), 230.25f, simfang2312_z5));
                phrase2.add(new Chunk("一案立案调查，因在调查中发现", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.push(), 1000f, simfang2312_z5, "一案立案调查，因在调查中发现", -1));
                phrase2.add(new Chunk("，故此案已超出本行政机关管辖范围，根据", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.push(), 288.75f, simfang2312_z5));
                phrase2.add(new Chunk("的规定，移送你单位对该案件进一步审理，依法追究责任。", simfang2312_z5));
                paragraph2.add(phrase2);
                document.add(paragraph2);
                Paragraph paragraph7 = new ParagraphBuilder();
                paragraph7.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph7.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase7 = new Phrase();
                phrase7.add(new Chunk("附该案件有关材料：", simfang2312_z5));
                phrase7.add(ChunkFactory.underLine(book.push(), 1800f, simfang2312_z5, "空格附该案件有关材料：", -1));
                paragraph7.add(phrase7);
                document.add(paragraph7);
                Paragraph paragraph8 = new ParagraphBuilder();
                paragraph8.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph8.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase8 = new Phrase();
                phrase8.add(new Chunk("共", simfang2312_z5));
                phrase8.add(ChunkFactory.underLine(book.push(), 26.25f, simfang2312_z5));
                phrase8.add(new Chunk("份", simfang2312_z5));
                phrase8.add(ChunkFactory.underLine(book.push(), 26.25f, simfang2312_z5));
                phrase8.add(new Chunk("页。", simfang2312_z5));
                paragraph8.add(phrase8);
                document.add(paragraph8);
                printerFrameWorkG1(book);
                printerFrameWorkPic(postmaskimage);
                document.newPage();// 结束保存
            }
        });

    }

    //案件延期审批表
    protected void printerEntity_Book_2017_44(final Base_Entity book, final Object postmaskimage) {
        printerFrameWork(book, postmaskimage, new IPdfBackFrame() {
            @Override
            public void writeContent() throws Exception {
                //此处写页面布局
                book.push();
                book.push();
                book.push();
                printerFrameWorkTitle(book, "安全生产行政执法文书", "案件延期审批表", "安监案延");
                Paragraph paragraph1 = new ParagraphBuilder();
                paragraph1.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph1.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase1 = new Phrase();
                phrase1.add(new Chunk("案件名称：", simfang2312_z5));
                phrase1.add(ChunkFactory.underLine(book.push(), 309.75f, simfang2312_z5));
                paragraph1.add(phrase1);
                document.add(paragraph1);
                document.add(space3);
                PdfPTable table = null;
                float[] widths = new float[7];
                widths[0] = 1f;
                widths[1] = 1f;
                widths[2] = 1f;
                widths[3] = 1f;
                widths[4] = 1f;
                widths[5] = 1f;
                widths[6] = 1f;
                widths[0] = 817.0f;
                widths[1] = 1286.0f;
                widths[2] = 1287.0f;
                widths[3] = 1286.0f;
                widths[4] = 1287.0f;
                widths[5] = 1286.0f;
                widths[6] = 1287.0f;
                table = new PdfPTable(7);
                table.setWidthPercentage(100f);
                table.setWidths(widths);
                PdfPCell cell_0 = new PdfPCellBuilder(new ParagraphBuilder("当事\n人基\n本情况", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_0.setRowspan(5);
                cell_0.setFixedHeight(41.81818f);
                table.addCell(cell_0);
                PdfPCell cell_1 = new PdfPCellBuilder(new ParagraphBuilder("单位名称", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_1.setFixedHeight(41.81818f);
                table.addCell(cell_1);
                PdfPCell cell_2 = new PdfPCellBuilder(new ParagraphBuilder(book.push(), simfang2312_z5));
                cell_2.setFixedHeight(41.81818f);
                table.addCell(cell_2);
                PdfPCell cell_3 = new PdfPCellBuilder(new ParagraphBuilder("法定\n" +
                        "代表人\n", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_3.setFixedHeight(41.81818f);
                table.addCell(cell_3);
                PdfPCell cell_4 = new PdfPCellBuilder(new ParagraphBuilder(book.push(), simfang2312_z5));
                cell_4.setFixedHeight(41.81818f);
                table.addCell(cell_4);
                PdfPCell cell_5 = new PdfPCellBuilder(new ParagraphBuilder("联系电话", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_5.setFixedHeight(41.81818f);
                table.addCell(cell_5);
                PdfPCell cell_6 = new PdfPCellBuilder(new ParagraphBuilder(book.push(), simfang2312_z5));
                cell_6.setFixedHeight(41.81818f);
                table.addCell(cell_6);
                PdfPCell cell_7 = new PdfPCellBuilder(new ParagraphBuilder("地址", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_7.setFixedHeight(41.81818f);
                table.addCell(cell_7);
                PdfPCell cell_8 = new PdfPCellBuilder(new ParagraphBuilder(book.push(), simfang2312_z5));
                cell_8.setColspan(3);
                cell_8.setFixedHeight(41.81818f);
                table.addCell(cell_8);
                PdfPCell cell_9 = new PdfPCellBuilder(new ParagraphBuilder("邮政编码", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_9.setFixedHeight(41.81818f);
                table.addCell(cell_9);
                PdfPCell cell_10 = new PdfPCellBuilder(new ParagraphBuilder(book.push(), simfang2312_z5));
                cell_10.setFixedHeight(41.81818f);
                table.addCell(cell_10);
                PdfPCell cell_11 = new PdfPCellBuilder(new ParagraphBuilder("个人姓名", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_11.setFixedHeight(41.81818f);
                table.addCell(cell_11);
                PdfPCell cell_12 = new PdfPCellBuilder(new ParagraphBuilder(book.push(), simfang2312_z5));
                cell_12.setFixedHeight(41.81818f);
                table.addCell(cell_12);
                PdfPCell cell_13 = new PdfPCellBuilder(new ParagraphBuilder("出生年月", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_13.setFixedHeight(41.81818f);
                table.addCell(cell_13);
                PdfPCell cell_14 = new PdfPCellBuilder(new ParagraphBuilder(book.push(), simfang2312_z5));
                cell_14.setFixedHeight(41.81818f);
                table.addCell(cell_14);
                PdfPCell cell_15 = new PdfPCellBuilder(new ParagraphBuilder("性别", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_15.setFixedHeight(41.81818f);
                table.addCell(cell_15);
                PdfPCell cell_16 = new PdfPCellBuilder(new ParagraphBuilder(book.push(), simfang2312_z5));
                cell_16.setFixedHeight(41.81818f);
                table.addCell(cell_16);
                PdfPCell cell_17 = new PdfPCellBuilder(new ParagraphBuilder("所在单位", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_17.setFixedHeight(41.81818f);
                table.addCell(cell_17);
                PdfPCell cell_18 = new PdfPCellBuilder(new ParagraphBuilder(book.push(), simfang2312_z5));
                cell_18.setFixedHeight(41.81818f);
                table.addCell(cell_18);
                PdfPCell cell_19 = new PdfPCellBuilder(new ParagraphBuilder("单位地址", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_19.setFixedHeight(41.81818f);
                table.addCell(cell_19);
                PdfPCell cell_20 = new PdfPCellBuilder(new ParagraphBuilder(book.push(), simfang2312_z5));
                cell_20.setColspan(3);
                cell_20.setFixedHeight(41.81818f);
                table.addCell(cell_20);
                PdfPCell cell_21 = new PdfPCellBuilder(new ParagraphBuilder("家庭住址", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_21.setFixedHeight(41.81818f);
                table.addCell(cell_21);
                PdfPCell cell_22 = new PdfPCellBuilder(new ParagraphBuilder(book.push(), simfang2312_z5));
                cell_22.setFixedHeight(41.81818f);
                table.addCell(cell_22);
                PdfPCell cell_23 = new PdfPCellBuilder(new ParagraphBuilder("联系电话", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_23.setFixedHeight(41.81818f);
                table.addCell(cell_23);
                PdfPCell cell_24 = new PdfPCellBuilder(new ParagraphBuilder(book.push(), simfang2312_z5));
                cell_24.setFixedHeight(41.81818f);
                table.addCell(cell_24);
                PdfPCell cell_25 = new PdfPCellBuilder(new ParagraphBuilder("邮编", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_25.setFixedHeight(41.81818f);
                table.addCell(cell_25);
                PdfPCell cell_26 = new PdfPCellBuilder(new ParagraphBuilder(book.push(), simfang2312_z5));
                cell_26.setFixedHeight(41.81818f);
                table.addCell(cell_26);
                PdfPCell cell_27 = new PdfPCellBuilder(new ParagraphBuilder("案件\n延期\n" +
                        "理由\n", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_27.setFixedHeight(96.464645f);
                table.addCell(cell_27);

                Paragraph paragraph2 = new ParagraphBuilder();
                paragraph2.setLeading(simfang2312_z5.getSize() * 1.5f);
//                paragraph1.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase2 = new Phrase();
                phrase2.add(ChunkFactory.tablenounderLine(book.push(), 1000, simfang2312_z5, 0, StringFactoryBuild.build().getStringLength("                                                               ", simfang2312_z5)));
                paragraph2.add(phrase2);


                Paragraph paragraph4 = new ParagraphBuilder();
                paragraph4.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph4.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase4 = new Phrase();
                phrase4.add(new Chunk("承办人（签名）:", simfang2312_z5));
                phrase4.add(ChunkFactory.tableunderLine(book.push(), 73.5f, simfang2312_z5));
                phrase4.add(new Chunk(" ", simfang2312_z5));
                phrase4.add(ChunkFactory.tableunderLine(book.push(), 57.75f, simfang2312_z5));
                paragraph4.add(phrase4);


                Paragraph paragraph6 = new ParagraphBuilder();
                paragraph6.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph6.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase6 = new Phrase();
                phrase6.add(ChunkFactory.nounderLine("", 200f, simfang2312_z5));
                phrase6.add(ChunkFactory.tablenounderLine(book.pushneedcheck(), 0, 42f, simfang2312_z5));
                phrase6.add(new Chunk("年", simfang2312_z5));
                phrase6.add(ChunkFactory.tablenounderLine(book.pushneedcheck(), 1, 21f, simfang2312_z5));
                phrase6.add(new Chunk("月", simfang2312_z5));
                phrase6.add(ChunkFactory.tablenounderLine(book.push(true), 2, 21f, simfang2312_z5));
                phrase6.add(new Chunk("日", simfang2312_z5));
                paragraph6.add(phrase6);


                PdfPCell cell_28 = new PdfPCellBuilder();
                cell_28.addElement(paragraph2);
                cell_28.addElement(paragraph4);
                cell_28.addElement(paragraph6);
                cell_28.setColspan(6);
                cell_28.setFixedHeight(96.464645f);
                table.addCell(cell_28);
                PdfPCell cell_29 = new PdfPCellBuilder(new ParagraphBuilder("审核\n意见", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_29.setFixedHeight(81.71717f);
                table.addCell(cell_29);


                Paragraph paragraph7 = new ParagraphBuilder();
                paragraph7.setLeading(simfang2312_z5.getSize() * 1.5f);
//                paragraph7.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase7 = new Phrase();
                phrase7.add(ChunkFactory.tablenounderLine(book.push(), StringFactoryBuild.build().getStringLength("                                                                                                                                                                                             ", simfang2312_z5) * 1, simfang2312_z5, 0, StringFactoryBuild.build().getStringLength("                                                               ", simfang2312_z5)));
//                phrase7.add(ChunkFactory.nounderLine("7678687686876",400f,simfang2312_z5));
                paragraph7.add(phrase7);

                Paragraph paragraph8 = new ParagraphBuilder();
                paragraph8.setLeading(simfang2312_z5.getSize() * 1.5f);
//                paragraph8.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase8 = new Phrase();
                phrase8.add(new Chunk("审核人（签名）：", simfang2312_z5));
                phrase8.add(ChunkFactory.nounderLine(book.push(), 140f, simfang2312_z5));
                phrase8.add(ChunkFactory.tablenounderLine(book.pushneedcheck(), 0, 42f, simfang2312_z5));
                phrase8.add(new Chunk("年", simfang2312_z5));
                phrase8.add(ChunkFactory.tablenounderLine(book.pushneedcheck(), 1, 21f, simfang2312_z5));
                phrase8.add(new Chunk("月", simfang2312_z5));
                phrase8.add(ChunkFactory.tablenounderLine(book.push(true), 2, 21f, simfang2312_z5));
                phrase8.add(new Chunk("日", simfang2312_z5));
                paragraph8.add(phrase8);


                PdfPCell cell_30 = new PdfPCellBuilder();
                cell_30.addElement(paragraph7);
                cell_30.addElement(paragraph8);
                cell_30.setColspan(6);
                cell_30.setFixedHeight(81.71717f);
                table.addCell(cell_30);
                PdfPCell cell_31 = new PdfPCellBuilder(new ParagraphBuilder("审批\n意见", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_31.setFixedHeight(81.71717f);
                table.addCell(cell_31);

                Paragraph paragraph9 = new ParagraphBuilder();
                paragraph9.setLeading(simfang2312_z5.getSize() * 1.5f);
//                paragraph9.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase9 = new Phrase();
                phrase9.add(ChunkFactory.tablenounderLine(book.push(), StringFactoryBuild.build().getStringLength("                                                                                                                                                                                             ", simfang2312_z5) * 1, simfang2312_z5, 0, StringFactoryBuild.build().getStringLength("                                                               ", simfang2312_z5)));
//                phrase9.add(ChunkFactory.tableunderLine(book.push(),300f,simfang2312_z5,0,StringFactoryBuild.build().getStringLength("                                                                 ",simfang2312_z5)));
                paragraph9.add(phrase9);

                Paragraph paragraph10 = new ParagraphBuilder();
                paragraph10.setLeading(simfang2312_z5.getSize() * 1.5f);
//                paragraph10.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase10 = new Phrase();
                phrase10.add(new Chunk("审批人（签名）：", simfang2312_z5));
                phrase10.add(ChunkFactory.nounderLine(book.push(), 140f, simfang2312_z5));
                phrase10.add(ChunkFactory.tablenounderLine(book.pushneedcheck(), 0, 42f, simfang2312_z5));
                phrase10.add(new Chunk("年", simfang2312_z5));
                phrase10.add(ChunkFactory.tablenounderLine(book.pushneedcheck(), 1, 21f, simfang2312_z5));
                phrase10.add(new Chunk("月", simfang2312_z5));
                phrase10.add(ChunkFactory.tablenounderLine(book.push(true), 2, 21f, simfang2312_z5));
                phrase10.add(new Chunk("日", simfang2312_z5));
                paragraph10.add(phrase10);


                PdfPCell cell_32 = new PdfPCellBuilder();
                cell_32.addElement(paragraph9);
                cell_32.addElement(paragraph10);
                cell_32.setColspan(6);
                cell_32.setFixedHeight(81.71717f);
                table.addCell(cell_32);
                document.add(table);
                printerFrameWorkPic(postmaskimage);
                document.newPage();
            }
        });

    }

    //结案审批表
    protected void printerEntity_Book_2017_45(final Base_Entity book, final Object postmaskimage) {
        printerFrameWork(book, postmaskimage, new IPdfBackFrame() {
            @Override
            public void writeContent() throws Exception {
                //此处写页面布局
                book.push();
                book.push();
                book.push();
                printerFrameWorkTitle(book, "安全生产行政执法文书", "结案审批表", "安监结");
                Paragraph paragraph1 = new ParagraphBuilder();
                paragraph1.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph1.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase1 = new Phrase();
                phrase1.add(new Chunk("案件名称：", simfang2312_z5));
                phrase1.add(ChunkFactory.underLine(book.push(), 336.0f, simfang2312_z5));
                paragraph1.add(phrase1);
                document.add(paragraph1);
                document.add(space3);
                PdfPTable table = null;
                float[] widths = new float[9];
                widths[0] = 53f;
                widths[1] = 72f;
                widths[2] = 115f;
                widths[3] = 36f;
                widths[4] = 40f;
                widths[5] = 8f;
                widths[6] = 94f;
                widths[7] = 58f;
                widths[8] = 104f;
                table = new PdfPTable(9);
                table.setWidthPercentage(100f);
                table.setWidths(widths);
                PdfPCell cell_0 = new PdfPCellBuilder(new ParagraphBuilder("当事\n人基\n本情\n况", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_0.setRowspan(5);
                cell_0.setFixedHeight(32f);
                table.addCell(cell_0);
                PdfPCell cell_1 = new PdfPCellBuilder(new ParagraphBuilder("被处罚人\n（单位）", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_1.setFixedHeight(32f);
                table.addCell(cell_1);
                PdfPCell cell_2 = new PdfPCellBuilder(new ParagraphBuilder(book.push(), simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                table.addCell(cell_2);
                PdfPCell cell_3 = new PdfPCellBuilder(new ParagraphBuilder("地址", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_3.setColspan(2);
                cell_3.setFixedHeight(32f);
                table.addCell(cell_3);
                PdfPCell cell_4 = new PdfPCellBuilder(new ParagraphBuilder(book.push(), simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_4.setColspan(4);
                cell_4.setFixedHeight(32f);
                table.addCell(cell_4);
                PdfPCell cell_5 = new PdfPCellBuilder(new ParagraphBuilder("法定\n" +
                        "代表人\n", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_5.setFixedHeight(32f);
                table.addCell(cell_5);
                PdfPCell cell_6 = new PdfPCellBuilder(new ParagraphBuilder(book.push(), simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_6.setFixedHeight(32f);
                table.addCell(cell_6);
                PdfPCell cell_7 = new PdfPCellBuilder(new ParagraphBuilder("职务", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_7.setColspan(2);
                cell_7.setFixedHeight(32f);
                table.addCell(cell_7);
                PdfPCell cell_8 = new PdfPCellBuilder(new ParagraphBuilder(book.push(), simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_8.setColspan(2);
                cell_8.setFixedHeight(32f);
                table.addCell(cell_8);
                PdfPCell cell_9 = new PdfPCellBuilder(new ParagraphBuilder("邮编", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_9.setFixedHeight(32f);
                table.addCell(cell_9);
                PdfPCell cell_10 = new PdfPCellBuilder(new ParagraphBuilder(book.push(), simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_10.setFixedHeight(32f);
                table.addCell(cell_10);
                PdfPCell cell_11 = new PdfPCellBuilder(new ParagraphBuilder("被处罚人\n（个人）", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_11.setFixedHeight(32f);
                table.addCell(cell_11);
                PdfPCell cell_12 = new PdfPCellBuilder(new ParagraphBuilder(book.push(), simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_12.setFixedHeight(32f);
                table.addCell(cell_12);
                PdfPCell cell_13 = new PdfPCellBuilder(new ParagraphBuilder("年龄", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_13.setColspan(2);
                cell_13.setFixedHeight(32f);
                table.addCell(cell_13);
                PdfPCell cell_14 = new PdfPCellBuilder(new ParagraphBuilder(book.push(), simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_14.setColspan(2);
                cell_14.setFixedHeight(32f);
                table.addCell(cell_14);
                PdfPCell cell_15 = new PdfPCellBuilder(new ParagraphBuilder("性别", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_15.setFixedHeight(32f);
                table.addCell(cell_15);
                PdfPCell cell_16 = new PdfPCellBuilder(new ParagraphBuilder(book.push(), simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_16.setFixedHeight(32f);
                table.addCell(cell_16);
                PdfPCell cell_17 = new PdfPCellBuilder(new ParagraphBuilder("所在单位", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_17.setFixedHeight(32f);
                table.addCell(cell_17);
                PdfPCell cell_18 = new PdfPCellBuilder(new ParagraphBuilder(book.push(), simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_18.setFixedHeight(32f);
                table.addCell(cell_18);
                PdfPCell cell_19 = new PdfPCellBuilder(new ParagraphBuilder("单位地址", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_19.setColspan(2);
                cell_19.setFixedHeight(32f);
                table.addCell(cell_19);
                PdfPCell cell_20 = new PdfPCellBuilder(new ParagraphBuilder(book.push(), simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_20.setColspan(4);
                cell_20.setFixedHeight(32f);
                table.addCell(cell_20);
                PdfPCell cell_21 = new PdfPCellBuilder(new ParagraphBuilder("家庭住址", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_21.setFixedHeight(32f);
                table.addCell(cell_21);
                PdfPCell cell_22 = new PdfPCellBuilder(new ParagraphBuilder(book.push(), simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_22.setFixedHeight(32f);
                table.addCell(cell_22);
                PdfPCell cell_23 = new PdfPCellBuilder(new ParagraphBuilder("联系电话", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_23.setColspan(2);
                cell_23.setFixedHeight(32f);
                table.addCell(cell_23);
                PdfPCell cell_24 = new PdfPCellBuilder(new ParagraphBuilder(book.push(), simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_24.setColspan(2);
                cell_24.setFixedHeight(32f);
                table.addCell(cell_24);
                PdfPCell cell_25 = new PdfPCellBuilder(new ParagraphBuilder("邮编", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_25.setFixedHeight(32f);
                table.addCell(cell_25);
                PdfPCell cell_26 = new PdfPCellBuilder(new ParagraphBuilder(book.push(), simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_26.setFixedHeight(32f);
                table.addCell(cell_26);
                PdfPCell cell_27 = new PdfPCellBuilder(new ParagraphBuilder("处理\n" +
                        "结果\n", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_27.setFixedHeight(91f);
                table.addCell(cell_27);
                PdfPCell cell_28 = new PdfPCellBuilder(new ParagraphBuilder(book.push(), simfang2312_z5));
                cell_28.setColspan(8);
                cell_28.setFixedHeight(91f);
                table.addCell(cell_28);
                PdfPCell cell_29 = new PdfPCellBuilder(new ParagraphBuilder("执行\n" +
                        "情况\n", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_29.setFixedHeight(91f);
                table.addCell(cell_29);

                Paragraph paragraph2 = new ParagraphBuilder();
                paragraph2.setLeading(simfang2312_z5.getSize() * 1.5f);
//                paragraph1.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase2 = new Phrase();
                phrase2.add(ChunkFactory.tablenounderLine(book.push(), 1000, simfang2312_z5,"","妈妈经常批评我做事不讲效率但我却是妈妈经常批评我做事不讲效率但我却是妈妈"));
                paragraph2.add(phrase2);
                Paragraph paragraph4 = new ParagraphBuilder();
                paragraph4.setLeading(simfang2312_z5.getSize() * 2f);
//                paragraph4.setFirstLineIndent(simfang2312_z5.getSize()*2f);
                Phrase phrase4 = new Phrase();
                phrase4.add(new Chunk("承办人（签名）:", simfang2312_z5));
                phrase4.add(ChunkFactory.tableunderLine(book.push(), 73.5f, simfang2312_z5));
                phrase4.add(new Chunk(" ", simfang2312_z5));
                phrase4.add(ChunkFactory.tableunderLine(book.push(), 57.75f, simfang2312_z5));
                phrase4.add(ChunkFactory.nounderLine(book.pushneedcheck(), 0, 80f, simfang2312_z5));
                phrase4.add(new Chunk("年", simfang2312_z5));
                phrase4.add(ChunkFactory.tablenounderLine(book.pushneedcheck(), 1, 21f, simfang2312_z5));
                phrase4.add(new Chunk("月", simfang2312_z5));
                phrase4.add(ChunkFactory.tablenounderLine(book.push(true), 2, 21f, simfang2312_z5));
                phrase4.add(new Chunk("日", simfang2312_z5));
                paragraph4.add(phrase4);
                PdfPCell cell_30 = new PdfPCellBuilder();
                cell_30.addElement(paragraph2);
                cell_30.addElement(paragraph4);
//                cell_30.addElement(paragraph6);
                cell_30.setColspan(8);
                cell_30.setFixedHeight(91f);
                table.addCell(cell_30);




                PdfPCell cell_31 = new PdfPCellBuilder(new ParagraphBuilder("审核\n" +
                        "意见\n", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_31.setFixedHeight(91f);
                table.addCell(cell_31);


                Paragraph paragraph13 = new ParagraphBuilder();
                paragraph13.setLeading(simfang2312_z5.getSize() * 1.2f);
                Phrase phrase13 = new Phrase();
                phrase13.add(ChunkFactory.tablenounderLine(book.push(), 10.5f*50, simfang2312_z5, "", "妈妈经常批评我做事不讲效率但我"));
                paragraph13.add(phrase13);


                Paragraph paragraph15 = new ParagraphBuilder();
                paragraph15.setLeading(simfang2312_z5.getSize() * 1.2f);
                Phrase phrase15 = new Phrase();
                phrase15.add(new Chunk("审核人（签名）：", simfang2312_z5));
                phrase15.add(ChunkFactory.tablenounderLine(book.push(), "测试人人", simfang2312_z5));
                paragraph15.add(phrase15);

                Paragraph paragraph16 = new ParagraphBuilder();
                paragraph16.setLeading(simfang2312_z5.getSize() * 1.2f);
                Phrase phrase16 = new Phrase();
                phrase16.add(ChunkFactory.nounderLine("", 25f, simfang2312_z5));
                phrase16.add(ChunkFactory.nounderLine(book.pushneedcheck(), 0, 42.0f, simfang2312_z5));
                phrase16.add(new Chunk("年", simfang2312_z5));
                phrase16.add(ChunkFactory.nounderLine(book.pushneedcheck(), 1, 21.0f, simfang2312_z5));
                phrase16.add(new Chunk("月", simfang2312_z5));
                phrase16.add(ChunkFactory.nounderLine(book.push(true), 2, 21.0f, simfang2312_z5));
                phrase16.add(new Chunk("日", simfang2312_z5));
                paragraph16.add(phrase16);


                PdfPCell cell_32 = new PdfPCellBuilder();
                cell_32.addElement(paragraph13);
                cell_32.addElement(paragraph15);
                cell_32.addElement(paragraph16);
                cell_32.setColspan(3);
                cell_32.setFixedHeight(91f);
                table.addCell(cell_32);
                PdfPCell cell_33 = new PdfPCellBuilder(new ParagraphBuilder("审批\n" +
                        "意见\n", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_33.setColspan(2);
                cell_33.setFixedHeight(91f);
                table.addCell(cell_33);
                Paragraph paragraph17 = new ParagraphBuilder();
                paragraph17.setLeading(simfang2312_z5.getSize() * 1.2f);
                Phrase phrase17 = new Phrase();
                phrase17.add(ChunkFactory.tablenounderLine(book.push(), 10.5f*60, simfang2312_z5, "", "妈妈经常批评我做事不讲效率但我却是"));
                paragraph17.add(phrase17);


                Paragraph paragraph19 = new ParagraphBuilder();
                paragraph19.setLeading(simfang2312_z5.getSize() * 1.2f);
                Phrase phrase19 = new Phrase();
                phrase19.add(new Chunk("审批人（签名）：", simfang2312_z5));
                phrase19.add(ChunkFactory.tablenounderLine(book.push(), "测试人人", simfang2312_z5));
                paragraph19.add(phrase19);
                Paragraph paragraph20 = new ParagraphBuilder();
                paragraph20.setLeading(simfang2312_z5.getSize() * 1.2f);
                Phrase phrase20 = new Phrase();
                phrase20.add(ChunkFactory.nounderLine("", 25f, simfang2312_z5));
                phrase20.add(ChunkFactory.nounderLine(book.pushneedcheck(), 0, 42.0f, simfang2312_z5));
                phrase20.add(new Chunk("年", simfang2312_z5));
                phrase20.add(ChunkFactory.nounderLine(book.pushneedcheck(), 1, 21.0f, simfang2312_z5));
                phrase20.add(new Chunk("月", simfang2312_z5));
                phrase20.add(ChunkFactory.nounderLine(book.push(true), 2, 21.0f, simfang2312_z5));
                phrase20.add(new Chunk("日", simfang2312_z5));
                paragraph20.add(phrase20);
                PdfPCell cell_34 = new PdfPCellBuilder();
                cell_34.addElement(paragraph17);
                cell_34.addElement(paragraph19);
                cell_34.addElement(paragraph20);
                cell_34.setColspan(3);
                cell_34.setFixedHeight(91f);
                table.addCell(cell_34);


                document.add(table);
                printerFrameWorkPic(postmaskimage);
                document.newPage();
            }
        });

    }

    //案卷（首页）
    protected void printerEntity_Book_2017_46(final Base_Entity book, final Object postmaskimage) {
        printerFrameWork(book, postmaskimage, new IPdfBackFrame() {
            @Override
            public void writeContent() throws Exception {
                document.add(space1);

                final Paragraph title = new ParagraphBuilder();// Paragraph就是段落
                title.setLeading(1f);// 段落距离
                title.setSpacingBefore(25f);// 段落留白
                title.setAlignment(Element.ALIGN_CENTER);// 居中
                Phrase titlePhrase = new Phrase();
                titlePhrase.add(ChunkFactory.underLine(book.push(), "呼和浩特", simhei_z1));
                titlePhrase.add(new Chunk("安全生产监督管理局", simhei_z1));
                title.add(titlePhrase);
                document.add(title);// 写入文档
                document.add(space2);
                document.add(space1);
                document.add(space2);
                document.add(space2);
                final Paragraph title2 = new ParagraphBuilder("安全生产违法案件", simkai2312_z1);
                title2.setLeading(1f);
                title2.setSpacingBefore(15f);
                title2.setAlignment(Element.ALIGN_CENTER);
                document.add(title2);
                document.add(space2);
                document.add(space1);
                document.add(space2);
                document.add(space2);
                final Paragraph title3 = new ParagraphBuilder("案卷（首页）", simkai2312_z1);
                title3.setLeading(1f);
                title3.setSpacingBefore(15f);
                title3.setAlignment(Element.ALIGN_CENTER);
                document.add(title3);
                document.add(space2);
                document.add(space2);
                final Paragraph title4 = new ParagraphBuilder("(   " + book.push() + " )安监案〔  " + book.push() + "〕"
                        + book.push() + "号", simfang2312_z3);
                title4.setLeading(1f);
                title4.setSpacingBefore(25f);
                title4.setAlignment(Element.ALIGN_CENTER);
                document.add(title4);
                document.add(space2);
                document.add(space2);
                document.add(space2);
                document.add(space2);
                document.add(space2);
                document.add(space2);
                document.add(space2);
                document.add(space2);
                final Paragraph paragraph1 = new ParagraphBuilder();
                paragraph1.setAlignment(Element.ALIGN_LEFT);
//                paragraph1.setFirstLineIndent(2f);
                Phrase phrase1 = new Phrase();
                phrase1.add(new Chunk("案件名称：", simfang2312_z3));
                phrase1.add(ChunkFactory.underLine(book.push(), 335, simfang2312_z3,"案件名称：", -1, 9f));
                paragraph1.add(phrase1);
                document.add(paragraph1);
                document.add(space2);
                document.add(space2);
                document.add(space2);
                PdfPTable table = null;
                float[] widths = new float[2];
                widths[0] = 1f;
                widths[1] = 1f;
                widths[0] = 817.0f;
                widths[1] = 8129.0f;
                table = new PdfPTable(2);
                table.setWidthPercentage(100f);
                table.setWidths(widths);
                PdfPCell cell_0 = new PdfPCellBuilder(new ParagraphBuilder("案\n由", simfang2312_z3).setAlignmentS(Element.ALIGN_CENTER)).setVerticalAlignmentS(Element.ALIGN_MIDDLE).setHorizontalAlignmentS(Element.ALIGN_CENTER);
                cell_0.setFixedHeight(107.57576f);
                table.addCell(cell_0);
                PdfPCell cell_1 = new PdfPCellBuilder(new ParagraphBuilder(book.push(), simfang2312_z3));
                cell_1.setFixedHeight(107.57576f);
                table.addCell(cell_1);
                PdfPCell cell_2 = new PdfPCellBuilder(new ParagraphBuilder("处\n理\n" +
                        "结\n果\n", simfang2312_z3).setAlignmentS(Element.ALIGN_CENTER)).setVerticalAlignmentS(Element.ALIGN_MIDDLE).setHorizontalAlignmentS(Element.ALIGN_CENTER);
                cell_2.setFixedHeight(128.38383f);
                table.addCell(cell_2);
                PdfPCell cell_3 = new PdfPCellBuilder(new ParagraphBuilder(book.push(), simfang2312_z3));
                cell_3.setFixedHeight(128.38383f);
                table.addCell(cell_3);
                document.add(table);
                document.add(space1);
                final Paragraph paragraph2 = new ParagraphBuilder();
                paragraph2.setAlignment(Element.ALIGN_LEFT);
//                paragraph2.setIndentationLeft(24f);
                paragraph2.setLeading(24f);
                Phrase phrase4 = new Phrase();
                phrase4.add(new Chunk("立案：", simfang2312_z3));
                phrase4.add(ChunkFactory
                        .underLine(book.pushneedcheck(), 0, 36, simfang2312_z3));
                phrase4.add(new Chunk("年", simfang2312_z3));
                phrase4.add(ChunkFactory
                        .underLine(book.pushneedcheck(), 1, 36, simfang2312_z3));
                phrase4.add(new Chunk("月", simfang2312_z3));
                phrase4.add(ChunkFactory
                        .underLine(book.push(true), 2, 36, simfang2312_z3));
                phrase4.add(new Chunk("日", simfang2312_z3));
                phrase4.add("\n");
                phrase4.add(new Chunk("结案：", simfang2312_z3));
                phrase4.add(ChunkFactory
                        .underLine(book.pushneedcheck(), 0, 36, simfang2312_z3));
                phrase4.add(new Chunk("年", simfang2312_z3));
                phrase4.add(ChunkFactory
                        .underLine(book.pushneedcheck(), 1, 36, simfang2312_z3));
                phrase4.add(new Chunk("月", simfang2312_z3));
                phrase4.add(ChunkFactory
                        .underLine(book.push(true), 2, 36, simfang2312_z3));
                phrase4.add(new Chunk("日", simfang2312_z3));
                phrase4.add("\n");
                phrase4.add(new Chunk("承办人：", simfang2312_z3));
                phrase4.add(ChunkFactory
                        .underLine(book.push(), 84, simfang2312_z3));
                phrase4.add(ChunkFactory.tablenounderLine("", 24,
                        simfang2312_z3));
                phrase4.add(ChunkFactory
                        .underLine(book.push(), 84, simfang2312_z3));
                phrase4.add("\n");
                phrase4.add(new Chunk("归档日期：", simfang2312_z3));
                phrase4.add(ChunkFactory
                        .underLine(book.pushneedcheck(), 0, 36, simfang2312_z3));
                phrase4.add(new Chunk("年", simfang2312_z3));
                phrase4.add(ChunkFactory
                        .underLine(book.pushneedcheck(), 1, 36, simfang2312_z3));
                phrase4.add(new Chunk("月", simfang2312_z3));
                phrase4.add(ChunkFactory
                        .underLine(book.push(true), 2, 36, simfang2312_z3));
                phrase4.add(new Chunk("日", simfang2312_z3));
                phrase4.add("\n");
                phrase4.add(new Chunk("归档号：", simfang2312_z3));
                phrase4.add(ChunkFactory
                        .underLine(book.push(), 84, simfang2312_z3));
                phrase4.add("\n");
                phrase4.add(new Chunk("保存期限：", simfang2312_z3));
                phrase4.add(ChunkFactory
                        .underLine(book.push(), 84, simfang2312_z3));
                paragraph2.add(phrase4);
                document.add(paragraph2);
                printerFrameWorkPic(postmaskimage);
                document.newPage();// 结束保存
            }
        });

    }

    //卷内目录
    protected void printerEntity_Book_2017_47(final Base_Entity book, final Object postmaskimage) {
        printerFrameWork(book, postmaskimage, new IPdfBackFrame() {
            @Override
            public void writeContent() throws Exception {
                final Paragraph title = new ParagraphBuilder();
                title.setAlignment(Element.ALIGN_CENTER);
                title.add(new Chunk("卷 内 目 录", simzhongsong_z2));
                document.add(title);
                document.add(space4);
                document.add(space4);
                PdfFactoryLog.println(book.push());
                PdfFactoryLog.println(book.push());
                PdfFactoryLog.println(book.push());
                PdfPTable table = null;
                Integer extraIndex= (Integer) book.getExtraObj();
                int extraInt=0;
                if(extraIndex!=null){
                    extraInt=extraIndex;
//                    System.out.println(extraIndex);
                }
                float[] widths = new float[5];
                widths[0] = 1f;
                widths[1] = 1f;
                widths[2] = 1f;
                widths[3] = 1f;
                widths[4] = 1f;
                widths[0] = 936.0f;
                widths[1] = 4305.0f;
                widths[2] = 1263.0f;
                widths[3] = 1036.0f;
                widths[4] = 1611.0f;
                table = new PdfPTable(5);
                table.setWidthPercentage(100f);
                table.setWidths(widths);
                PdfPCell cell_0 = new PdfPCellBuilder(new ParagraphBuilder("序号", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_0.setFixedHeight(35.757576f);
                table.addCell(cell_0);
                PdfPCell cell_1 = new PdfPCellBuilder(new ParagraphBuilder("文件名称及编号", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_1.setFixedHeight(35.757576f);
                table.addCell(cell_1);
                PdfPCell cell_2 = new PdfPCellBuilder(new ParagraphBuilder("日期", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_2.setFixedHeight(35.757576f);
                table.addCell(cell_2);
                PdfPCell cell_3 = new PdfPCellBuilder(new ParagraphBuilder("页号", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_3.setFixedHeight(35.757576f);
                table.addCell(cell_3);
                PdfPCell cell_4 = new PdfPCellBuilder(new ParagraphBuilder("备注", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_4.setFixedHeight(35.757576f);
                table.addCell(cell_4);
                int otherindex=-1;
//                System.out.println(extraInt+":"+getListItemSize(book.pushneedcheck()));
                for (int i = extraInt; i < extraInt+14+1; i++) {//如果新起一页只有多出来的几条 不需要 把空格项目补全 就把extraInt+14+1替换成getListItemSize(book.pushneedcheck())
                    if(i<extraInt+14){
                        int j = 0;
                        PdfPCell cell_5 = new PdfPCellBuilder(new ParagraphBuilder(getListItemValue(book.pushneedcheck(), i, j++), simfang2312_z5));
                        cell_5.setFixedHeight(34.343433f);
                        table.addCell(cell_5);
                        PdfPCell cell_6 = new PdfPCellBuilder(new ParagraphBuilder(getListItemValue(book.pushneedcheck(), i, j++), simfang2312_z5));
                        cell_6.setFixedHeight(34.343433f);
                        table.addCell(cell_6);
                        PdfPCell cell_7 = new PdfPCellBuilder(new ParagraphBuilder(getListItemValue(book.pushneedcheck(), i, j++), simfang2312_z5));
                        cell_7.setFixedHeight(34.343433f);
                        table.addCell(cell_7);
                        PdfPCell cell_8 = new PdfPCellBuilder(new ParagraphBuilder(getListItemValue(book.pushneedcheck(), i, j++), simfang2312_z5));
                        cell_8.setFixedHeight(34.343433f);
                        table.addCell(cell_8);
                        PdfPCell cell_9 = new PdfPCellBuilder(new ParagraphBuilder(getListItemValue(book.pushneedcheck(), i, j++), simfang2312_z5));
                        cell_9.setFixedHeight(34.343433f);
                        table.addCell(cell_9);
                        j = 0;
                    }else{
                        if(otherindex==-1&&i<getListItemSize(book.pushneedcheck())){
                            otherindex=i;
//                            System.out.println(otherindex);
                            break;
                        }
                    }

                }
                book.push(true);
                document.add(table);
                printerFrameWorkPic(postmaskimage);
                document.newPage();
                if(otherindex!=-1){
                    book.resetKey();
                    book.setExtraObj(otherindex);
//                    System.out.println(otherindex);
                    printerEntity_Book_2017_47(book,postmaskimage);
                }

            }
        });
    }

    //先 行 登 记 保 存 证 据 清 单
    protected void printerEntity_Book_2017_48(final Base_Entity book, final Object postmaskimage) {
        printerFrameWork(book, postmaskimage, new IPdfBackFrame() {
            @Override
            public void writeContent() throws Exception {
                book.push();
                book.push();
                book.push();
                printerFrameWorkTitle(book, "", "先 行 登 记 保 存 证 据 清 单", "");
                document.add(space4);
                PdfPTable table = null;
                float[] widths = new float[9];
                widths[0] = 1f;
                widths[1] = 1f;
                widths[2] = 1f;
                widths[3] = 1f;
                widths[4] = 1f;
                widths[5] = 1f;
                widths[6] = 1f;
                widths[7] = 1f;
                widths[8] = 1f;
                widths[0] = 815.0f;
                widths[1] = 1559.0f;
                widths[2] = 1426.0f;
                widths[3] = 1268.0f;
                widths[4] = 1134.0f;
                widths[5] = 737.0f;
                widths[6] = 745.0f;
                widths[7] = 821.0f;
                widths[8] = 709.0f;
                table = new PdfPTable(9);
                table.setWidthPercentage(100f);
                table.setWidths(widths);
                PdfPCell cell_0 = new PdfPCellBuilder(new ParagraphBuilder("序号", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_0.setFixedHeight(54.141415f);
                table.addCell(cell_0);
                PdfPCell cell_1 = new PdfPCellBuilder(new ParagraphBuilder("证据名称", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_1.setFixedHeight(54.141415f);
                table.addCell(cell_1);
                PdfPCell cell_2 = new PdfPCellBuilder(new ParagraphBuilder("规格型号", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_2.setFixedHeight(54.141415f);
                table.addCell(cell_2);
                PdfPCell cell_3 = new PdfPCellBuilder(new ParagraphBuilder("产地", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_3.setFixedHeight(54.141415f);
                table.addCell(cell_3);
                PdfPCell cell_4 = new PdfPCellBuilder(new ParagraphBuilder("成色\n" +
                        "（品级）\n", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_4.setFixedHeight(54.141415f);
                table.addCell(cell_4);
                PdfPCell cell_5 = new PdfPCellBuilder(new ParagraphBuilder("单位", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_5.setFixedHeight(54.141415f);
                table.addCell(cell_5);
                PdfPCell cell_6 = new PdfPCellBuilder(new ParagraphBuilder("价格", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_6.setFixedHeight(54.141415f);
                table.addCell(cell_6);
                PdfPCell cell_7 = new PdfPCellBuilder(new ParagraphBuilder("数量", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_7.setFixedHeight(54.141415f);
                table.addCell(cell_7);
                PdfPCell cell_8 = new PdfPCellBuilder(new ParagraphBuilder("备注", simfang2312_z5).setAlignmentS(Element.ALIGN_CENTER)).setHorizontalAlignmentS(Element.ALIGN_CENTER).setVerticalAlignmentS(Element.ALIGN_MIDDLE);
                cell_8.setFixedHeight(54.141415f);
                table.addCell(cell_8);
                for (int i = 0; i < 10; i++) {
                    int j = 0;
                    PdfPCell cell_9 = new PdfPCellBuilder(new ParagraphBuilder(getListItemValue(book.pushneedcheck(), i, j++), simfang2312_z5));
                    cell_9.setFixedHeight(37.77778f);
                    table.addCell(cell_9);
                    PdfPCell cell_10 = new PdfPCellBuilder(new ParagraphBuilder(getListItemValue(book.pushneedcheck(), i, j++), simfang2312_z5));
                    cell_10.setFixedHeight(37.77778f);
                    table.addCell(cell_10);
                    PdfPCell cell_11 = new PdfPCellBuilder(new ParagraphBuilder(getListItemValue(book.pushneedcheck(), i, j++), simfang2312_z5));
                    cell_11.setFixedHeight(37.77778f);
                    table.addCell(cell_11);
                    PdfPCell cell_12 = new PdfPCellBuilder(new ParagraphBuilder(getListItemValue(book.pushneedcheck(), i, j++), simfang2312_z5));
                    cell_12.setFixedHeight(37.77778f);
                    table.addCell(cell_12);
                    PdfPCell cell_13 = new PdfPCellBuilder(new ParagraphBuilder(getListItemValue(book.pushneedcheck(), i, j++), simfang2312_z5));
                    cell_13.setFixedHeight(37.77778f);
                    table.addCell(cell_13);
                    PdfPCell cell_14 = new PdfPCellBuilder(new ParagraphBuilder(getListItemValue(book.pushneedcheck(), i, j++), simfang2312_z5));
                    cell_14.setFixedHeight(37.77778f);
                    table.addCell(cell_14);
                    PdfPCell cell_15 = new PdfPCellBuilder(new ParagraphBuilder(getListItemValue(book.pushneedcheck(), i, j++), simfang2312_z5));
                    cell_15.setFixedHeight(37.77778f);
                    table.addCell(cell_15);
                    PdfPCell cell_16 = new PdfPCellBuilder(new ParagraphBuilder(getListItemValue(book.pushneedcheck(), i, j++), simfang2312_z5));
                    cell_16.setFixedHeight(37.77778f);
                    table.addCell(cell_16);
                    PdfPCell cell_17 = new PdfPCellBuilder(new ParagraphBuilder(getListItemValue(book.pushneedcheck(), i, j++), simfang2312_z5));
                    cell_17.setFixedHeight(37.77778f);
                    table.addCell(cell_17);
                    j = 0;
                }
                book.push(true);
                document.add(table);
                Paragraph paragraph1 = new ParagraphBuilder();
                paragraph1.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph1.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase1 = new Phrase();
                phrase1.add(new Chunk("上述物品经核无误。", simfang2312_z5));
                paragraph1.add(phrase1);
                document.add(paragraph1);
                Paragraph paragraph2 = new ParagraphBuilder();
                paragraph2.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph2.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase2 = new Phrase();
                phrase2.add(new Chunk("被通知人或者被通知单位负责人（签名）：", simfang2312_z5));
                phrase2.add(ChunkFactory.underLine(book.push(), 68.25f, simfang2312_z5));
                paragraph2.add(phrase2);
                document.add(paragraph2);
                Paragraph paragraph3 = new ParagraphBuilder();
                paragraph3.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph3.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase3 = new Phrase();
                phrase3.add(new Chunk("承办人（签名）：", simfang2312_z5));
                phrase3.add(ChunkFactory.underLine(book.push(), 89.25f, simfang2312_z5));
                paragraph3.add(phrase3);
                document.add(paragraph3);
                Paragraph paragraph4 = new ParagraphBuilder();
                paragraph4.setLeading(simfang2312_z5.getSize() * 2f);
                paragraph4.setFirstLineIndent(simfang2312_z5.getSize() * 2f);
                Phrase phrase4 = new Phrase();
                phrase4.add(new Chunk("承办人（签名）：", simfang2312_z5));
                phrase4.add(ChunkFactory.underLine(book.push(), 89.25f, simfang2312_z5));
                paragraph4.add(phrase4);
                document.add(paragraph4);
                printerFrameWorkPic(postmaskimage);
                document.newPage();
            }
        });

    }

}
