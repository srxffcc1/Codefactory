package com.ay.framework.core.pojo;

import com.ay.framework.annotation.ChineseName;

import java.io.Serializable;
import java.util.Date;

public class BaseBookPojo extends BasePojo {


    @ChineseName("版本号")
    public String version;

    @ChineseName("地方")
    public String pcode;
    @ChineseName("字")
    public String ycode;
    @ChineseName("号")
    public String ncode;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getPcode() {
        return pcode;
    }

    public void setPcode(String pcode) {
        this.pcode = pcode;
    }

    public String getYcode() {
        return ycode;
    }

    public void setYcode(String ycode) {
        this.ycode = ycode;
    }

    public String getNcode() {
        return ncode;
    }

    public void setNcode(String ncode) {
        this.ncode = ncode;
    }
}
