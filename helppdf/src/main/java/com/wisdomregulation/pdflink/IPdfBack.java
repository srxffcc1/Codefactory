package com.wisdomregulation.pdflink;

/**
 * Created by King6rf on 2017/2/17.
 * 常规文书回调
 */
public interface IPdfBack {
    public void writeError();
    public void writeStart();
    public void writeEnd();
}
