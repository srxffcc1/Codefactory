package com.wisdomregulation.test;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;

/**
 * Created by King6rf on 2017/4/3.
 */
public class PdfFormatTable {
    public SimpleTableCell[][] array;
    public SimpleTableCell[][] arrayvale;

    public PdfFormatTable() {

    }

    public PdfFormatTable setArray(SimpleTableCell[][] array) {
        this.array = array;
        return this;
    }

    public PdfFormatTable setArrayValue(SimpleTableCell[][] arrayvale) {
        this.arrayvale = arrayvale;
        return this;
    }

    public PdfPTable build() {
        PdfPTable table = null;
        try {
            table = new PdfPTable(1);//新建一个
            table.setWidthPercentage(100f);
            for (int i = 0; i < array.length; i++) {
                PdfPTable rowtable = new PdfPTable(array[i].length);//新建一个
                rowtable.setWidths(getWidth(array[i]));
                for (int j = 0; j < array[i].length; j++) {
                    PdfPCell rowcell = new PdfPCell(rowtable);
                    rowcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    if (array[i][j].child == null) {
                        PdfPCell cell = new PdfPCell();
                        if(array[i][j].rowspan!=-1){
                            cell.setRowspan(array[i][j].rowspan);
                        }
                        if(array[i][j].colspan!=-1){
                            cell.setColspan(array[i][j].colspan);
                        }
                        if(array[i][j].height>0){
                            cell.setFixedHeight(array[i][j].height);
                        }else{
                            cell.setFixedHeight(getHeight(array[i]));
                        }
                        if (arrayvale != null && arrayvale[i][j].element != null) {
                            cell.addElement(arrayvale[i][j].element);
                        }
                        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        rowtable.addCell(cell);
                    } else {
                        PdfPCell cell = new PdfPCell(new PdfFormatTable().setArray(array[i][j].child).setArrayValue(array[i][j].childvalue).build());
                        if(array[i][j].rowspan!=-1){
                            cell.setRowspan(array[i][j].rowspan);
                        }
                        if(array[i][j].colspan!=-1){
                            cell.setColspan(array[i][j].colspan);
                        }
                        if(array[i][j].height>0){
                            cell.setFixedHeight(array[i][j].height);
                        }else{
                            cell.setFixedHeight(getHeight(array[i]));
                        }

                        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        rowtable.addCell(cell);
                    }
                    table.addCell(rowcell);
                }

            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return table;
    }

    float getHeight(SimpleTableCell[] array) {
            if (array[array.length-1].height > 0) {
                return array[array.length-1].height;
            }
        return -1;
    }

    float[] getWidth(SimpleTableCell[] array) {
        float[] result = new float[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = array[i].width;
        }
        return result;
    }

    public static void main(String[] args) {

    }

}
