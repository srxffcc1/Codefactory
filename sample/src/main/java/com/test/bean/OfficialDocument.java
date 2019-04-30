package com.test.bean;

import com.ay.framework.annotation.ChineseName;
import com.ay.framework.core.pojo.BasePojo;

@ChineseName("发文管理;Detail;List:SHOW=documentTitle,documentNum:FUNCTION=查看,修改,发布,处理;")
public class OfficialDocument extends BasePojo {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ChineseName("文件名称")
    private String documentTitle;

    @ChineseName("文号")
    private String documentNum;

    @ChineseName("文件概要")
    private String documentContent;

    @ChineseName("公文接收人")
    private String documentReceiver;
    
    @ChineseName("公文接收人Ids")
    private  String receiverIds;

    @ChineseName("发布状态")
    private String fbzt; //0未发布，1未处理，2处理完毕，3已转交
    
    @ChineseName("来文单位")
    private String documentUnit;
    @ChineseName("填报人")
    private String informanter;
    @ChineseName("填报日期")
    private String informanteDate;
    @ChineseName("备注")
    private String remark;
    @ChineseName("是否转交;Spinner:string=是,否;")
    private String isTransfer; //0未转交，1已转交
    @ChineseName("转交人")
    private String transferPerson;
    @ChineseName("转交时间")
    private String transferDate;
    @ChineseName("处理人")
    private String handler;
    @ChineseName("处理时间")
    private String handleDate;
    @ChineseName("处理结果")
    private String handleResult;
    @ChineseName("处理详情")
    private String handleDetail;
    
    
    public String getDocumentTitle() {
        return documentTitle;
    }

    public void setDocumentTitle(String documentTitle) {
        this.documentTitle = documentTitle;
    }

    public String getDocumentNum() {
        return documentNum;
    }

    public void setDocumentNum(String documentNum) {
        this.documentNum = documentNum;
    }

    public String getDocumentContent() {
        return documentContent;
    }

    public void setDocumentContent(String documentContent) {
        this.documentContent = documentContent;
    }

    public String getDocumentReceiver() {
        return documentReceiver;
    }

    public void setDocumentReceiver(String documentReceiver) {
        this.documentReceiver = documentReceiver;
    }

    public String getReceiverIds() {
        return receiverIds;
    }

    public void setReceiverIds(String receiverIds) {
        this.receiverIds = receiverIds;
    }

    public String getFbzt() {
        return fbzt;
    }

    public void setFbzt(String fbzt) {
        this.fbzt = fbzt;
    }

	public String getDocumentUnit() {
		return documentUnit;
	}

	public void setDocumentUnit(String documentUnit) {
		this.documentUnit = documentUnit;
	}

	public String getInformanter() {
		return informanter;
	}

	public void setInformanter(String informanter) {
		this.informanter = informanter;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getIsTransfer() {
		return isTransfer;
	}

	public void setIsTransfer(String isTransfer) {
		this.isTransfer = isTransfer;
	}

	public String getTransferPerson() {
		return transferPerson;
	}

	public void setTransferPerson(String transferPerson) {
		this.transferPerson = transferPerson;
	}

	public String getTransferDate() {
		return transferDate;
	}

	public void setTransferDate(String transferDate) {
		this.transferDate = transferDate;
	}

	public String getHandler() {
		return handler;
	}

	public void setHandler(String handler) {
		this.handler = handler;
	}

	public String getHandleDate() {
		return handleDate;
	}

	public void setHandleDate(String handleDate) {
		this.handleDate = handleDate;
	}

	public String getHandleResult() {
		return handleResult;
	}

	public void setHandleResult(String handleResult) {
		this.handleResult = handleResult;
	}

	public String getHandleDetail() {
		return handleDetail;
	}

	public void setHandleDetail(String handleDetail) {
		this.handleDetail = handleDetail;
	}

	public String getInformanteDate() {
		return informanteDate;
	}

	public void setInformanteDate(String informanteDate) {
		this.informanteDate = informanteDate;
	}
    
}
