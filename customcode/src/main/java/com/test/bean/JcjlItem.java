package com.test.bean;


import com.ay.framework.annotation.ChineseName;
import com.ay.framework.core.pojo.BasePojo;

@ChineseName("检查记录详情;Detail")
public class JcjlItem extends BasePojo {

    @ChineseName("检查记录")
    private String jcjlItem;

    @ChineseName("检查记录id")
    private String jcjlId;

    @ChineseName("事项名称")
    private String sxmc;

    @ChineseName("现场检查结果;Spinner:string=合格,不合格;")
    private String xcjcjg;

    @ChineseName("隐患等级;Spinner:string=一般,重大;")
    private String yhdj;

    @ChineseName("子项状态")
    private String dqzt;

    public String getJcjlItem() {
        return jcjlItem;
    }

    public void setJcjlItem(String jcjlItem) {
        this.jcjlItem = jcjlItem;
    }

    public String getJcjlId() {
        return jcjlId;
    }

    public void setJcjlId(String jcjlId) {
        this.jcjlId = jcjlId;
    }

    public String getSxmc() {
        return sxmc;
    }

    public void setSxmc(String sxmc) {
        this.sxmc = sxmc;
    }

    public String getXcjcjg() {
        return xcjcjg;
    }

    public void setXcjcjg(String xcjcjg) {
        this.xcjcjg = xcjcjg;
    }

    public String getYhdj() {
        return yhdj;
    }

    public void setYhdj(String yhdj) {
        this.yhdj = yhdj;
    }

    public String getDqzt() {
        return dqzt;
    }

    public void setDqzt(String dqzt) {
        this.dqzt = dqzt;
    }
}
