package com.ay.framework.core.pojo;

import com.ay.framework.annotation.ChineseName;

import java.util.Date;

public class BasePojo extends  Object{
    /** 实体标识. */
    public String id;

    /** 删除标识 */
    public String status;

    /** 创建人 */
    public String created;

    /** 创建者部门IDS */
    public String createdDept;

    /** 创建时间 */
    public Date createTime;

    /** 更新人 */
    public String updated;

    /** 更新时间 */
    public Date updateTime;
    /**
     * 自定义查询语句
     */
    public String diysql;
    /**
     * 数据所属的部门id
     */
//	@ChineseName("部门id")
    public String org;
    /**
     * 数据所属的部门用户结构（上上级部门id-上级部门id-用户id）
     */
//	@ChineseName("部门用户结构")
    public String orgTree;
    /**
     * 用于SQLMapper中动态数据的条件字段
     */
    public String condition;

    public String noWatch = "N";

    public String noPagination = "N";

    public String definitionKey;

    //	@ChineseName("工作流实例Id")
    public String actProcessInstanceId;//尚未在生成模板中添加
    @ChineseName("版本号")
    public String version;

    @ChineseName("地方")
    public String pcode;
    @ChineseName("字")
    public String ycode;
    @ChineseName("号")
    public String ncode;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getCreatedDept() {
        return createdDept;
    }

    public void setCreatedDept(String createdDept) {
        this.createdDept = createdDept;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getDiysql() {
        return diysql;
    }

    public void setDiysql(String diysql) {
        this.diysql = diysql;
    }

    public String getOrg() {
        return org;
    }

    public void setOrg(String org) {
        this.org = org;
    }

    public String getOrgTree() {
        return orgTree;
    }

    public void setOrgTree(String orgTree) {
        this.orgTree = orgTree;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getNoWatch() {
        return noWatch;
    }

    public void setNoWatch(String noWatch) {
        this.noWatch = noWatch;
    }

    public String getNoPagination() {
        return noPagination;
    }

    public void setNoPagination(String noPagination) {
        this.noPagination = noPagination;
    }

    public String getDefinitionKey() {
        return definitionKey;
    }

    public void setDefinitionKey(String definitionKey) {
        this.definitionKey = definitionKey;
    }

    public String getActProcessInstanceId() {
        return actProcessInstanceId;
    }

    public void setActProcessInstanceId(String actProcessInstanceId) {
        this.actProcessInstanceId = actProcessInstanceId;
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
    public String getVersion() {
        return version;
    }
    public void setVersion(String version) {
        this.version = version;
    }

}
