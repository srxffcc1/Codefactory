package utils.bean;

import utils.UsedHelp;

public class ModeBean {
    /**
     * //业务模式 比如当前是某个list中的查看 还是修改 还是办理 还是其他
     * 举例 xxx-ck xxxx-lb-ck xxxxx-lb-xg 名字自己起的 用来标记业务流程阶段
     */
    public String mode;
    /**
     * //业务提交的url
     */
    public String url;
    /**
     * //业务如果是查看是 请实用getById返回的json举例
     *
     * {
     * 	"id": "7baa9eed94234c6cbde4983e6e9417a0",
     * 	"status": "1",
     * 	"created": "10a858e63dd3491086420e646482a690",
     * 	"createdDept": null,
     * 	"endSbsj": null,
     * 	"sfsb": null,
     * 	"shbmVal": "江阴化工区应救援中心",
     * 	"sfzdyh": null,
     * 	"lsjtAccount": null,
     * 	"qyid": "bf2e4b54fa23439fa5c66b6a0abf8ee0",
     * 	"ccsffxyh": null,
     * 	"zgwcsj": null,
     * 	"zxjghyb": null,
     * 	"zxjghybName": "危险化学品生产企业",
     * 	"dbdw": null,
     * 	"zgqk": null
     * }
     *
     * 如果是提交型属性请使用请求 的 表单形式 举例
     * qyzczb.id: 7baa9eed94234c6cbde4983e6e9417a0\n" +
     *                 "qyzczb.sbsj: 2019-03-05 14:49:08\n" +
     *                 "qyzczb.tbr: 黄凯钧\n" +
     *                 "qyzczb.userName: 福州东进世美肯科技有限公司\n" +
     *                 "qyzczb.jcsj: 2019-01-17\n" +
     *                 "qyzczb.jcry: 郭清煌、蔡闽，刘纪鹏\n" +
     *                 "qyzczb.jcrs: 4\n" +
     *                 "qyzczb.fkrq: 2019-02-17
     */
    public String responeOrrequest;
    /**
     * 严格规定不用显示的行
     */
    public String extraHide;

    public String getExtraHide() {
        return extraHide+","+UsedHelp.getIdKeyString(responeOrrequest);
    }

    public ModeBean setExtraHide(String extraHide) {
        this.extraHide = extraHide;
        return this;
    }

    public ModeBean(String mode, String url, String responeOrrequest) {
        this.mode = mode;
        this.url = url;
        this.responeOrrequest = responeOrrequest;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getRespone() {
        return UsedHelp.getUsedKeyString(responeOrrequest);
    }

    public void setRespone(String respone) {
        this.responeOrrequest = responeOrrequest;
    }
}
