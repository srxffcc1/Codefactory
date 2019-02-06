package com.wisdomregulation.pdflink;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

import java.io.IOException;

/**
 * ClassName:PdfReportM1HeaderFooter <br/> Function: TODO ADD FUNCTION. <br/> Reason: TODO ADD REASON. <br/> Date: 2013-9-13 上午08:59:00 <br/>
 *
 * @author 落雨
 * @version 394263788(QQ) 共几页第几页
 * @since JDK 1.5
 */
public class PdfReportM1HeaderFooter extends PdfPageEventHelper {

    /**
     * 页眉
     */
    public String header = "";

    /**
     * 文档字体大小，页脚页眉最好和文本大小一致
     */
    public float presentFontSize = 10.5f;

    /**
     * 文档页面大小，最好前面传入，否则默认为A4纸张
     */
    public Rectangle pageSize = PageSize.A4;

    // 模板
    public PdfTemplate total;

    // 基础字体对象
    public BaseFont bf = null;

    // 利用基础字体生成的字体对象，一般用于生成中文文字
    public Font fontDetail = null;

    /**
     *
     * Creates a new instance of PdfReportM1HeaderFooter 无参构造方法.
     *
     */
    public PdfReportM1HeaderFooter() {

    }
    String simdir;
    public PdfReportM1HeaderFooter(String simdir) {
        this.simdir=simdir;
    }

    /**
     *
     * Creates a new instance of PdfReportM1HeaderFooter 构造方法.
     *
     * @param yeMei
     *            页眉字符串
     * @param presentFontSize
     *            数据体字体大小
     * @param pageSize
     *            页面文档大小，A4，A5，A6横转翻转等Rectangle对象
     */
    public PdfReportM1HeaderFooter(String yeMei, int presentFontSize, Rectangle pageSize) {
        this.header = yeMei;
        this.presentFontSize = presentFontSize;
        this.pageSize = pageSize;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public void setPresentFontSize(int presentFontSize) {
        this.presentFontSize = presentFontSize;
    }

    /**
     *
     * TODO 文档打开时创建模板
     *
     * @see PdfPageEventHelper#onOpenDocument(PdfWriter, Document)
     */
    public void onOpenDocument(PdfWriter writer, Document document) {
        total = writer.getDirectContent().createTemplate(50, 50);// 共 页 的矩形的长宽高
        total.setBoundingBox(new Rectangle(-20, -20, 100, 100));
    }

    /**
     *
     * TODO 关闭每页的时候，写入页眉，写入'共页第页'这几个字。
     *
     * @see PdfPageEventHelper#onEndPage(PdfWriter, Document)
     */
    public void onEndPage(PdfWriter writer, Document document) {

        try {
            if (bf == null) {
                bf = BaseFont.createFont(simdir+"/simfang2312.ttf",BaseFont.IDENTITY_H,BaseFont.NOT_EMBEDDED);
            }
            if (fontDetail == null) {
                fontDetail = new Font(bf, presentFontSize, Font.NORMAL);// 数据体字体
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 1.写入页眉
        ColumnText.showTextAligned(writer.getDirectContent(), Element.ALIGN_LEFT, new Phrase(header, fontDetail), document.left(), document.top() + 20, 0);

        // 2.写入前半部分的 第 X页/共
        int pageS = writer.getPageNumber();
        String foot1 = "第 " + pageS + " 页";
        Phrase footer = new Phrase(foot1, fontDetail);

        // 3.计算前半部分的foot1的长度，后面好定位最后一部分的'Y页'这俩字的x轴坐标，字体长度也要计算进去 = len
        float len = bf.getWidthPoint(foot1, presentFontSize);

        // 4.拿到当前的PdfContentBytelen
        PdfContentByte cb = writer.getDirectContent();

        // 5.写入页脚1 原始数据如果页脚1和页脚2不对right进行修改的话都是“第几页共几页” 修改之后变成“共几页 第几页”
        ColumnText.showTextAligned(cb, Element.ALIGN_RIGHT, footer, document.right(), document.bottom(), 0);

        // 6.写入页脚2 如果不设置位置的话 就是直接跟在页脚1的后面 因为上面页脚1已经到达了页面边缘 所以 页脚2只要 减去一个自身减去一个len减去一个20空格就进入页边距范围了 此处自身我们用len代替误差也不大
        cb.addTemplate(total, document.right()-len-len-20, document.bottom()); // 调节模版显示的位置
    }

    /**
     *
     * TODO 关闭文档时，替换模板，完成整个页眉页脚组件
     *
     * @see PdfPageEventHelper#onCloseDocument(PdfWriter, Document)
     */
    public void onCloseDocument(PdfWriter writer, Document document) {
        // 7.最后一步了，就是关闭文档的时候，将模板替换成实际的 Y 值,至此，page x of y 制作完毕，完美兼容各种文档size。
        total.beginText();
        total.setFontAndSize(bf, presentFontSize);// 生成的模版的字体、颜色
        String foot2 = "共 " + (writer.getPageNumber() - 1) + " 页";
        total.showText(foot2);// 模版显示的内容
        total.endText();
        total.closePath();
    }
}
