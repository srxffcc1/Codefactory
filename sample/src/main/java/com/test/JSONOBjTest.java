package com.test;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.google.gson.Gson;
import org.json.JSONObject;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JSONOBjTest {
    public static void main(String[] args) {
        List<MemberAccountDetail> memberAccountDetailList=new ArrayList<>();
        memberAccountDetailList.add(new MemberAccountDetail());
        memberAccountDetailList.add(new MemberAccountDetail());
        memberAccountDetailList.add(new MemberAccountDetail());
        memberAccountDetailList.add(new MemberAccountDetail());

        Page<MemberAccountDetail> page=new Page<>();
        page.list=memberAccountDetailList;

        Root<MemberAccount> root=new Root<>();
        root.data=new MemberAccount();

        System.out.println(new Gson().toJson(root));

    }



    public static class  MemberAccountDetail  {
        public Long id=0L;
        public String shareId=""; //分享id 关联 order库的排行表
        public String memberId="";//
        public Integer sourceType=0;//收益来源(0->分享赚)
        public String sourceMemberId="";//收益提供人id
        public String sourceResult="获得10元现金";//项目名称 例如 获得优惠券名称 获得10元现金 获得商品名 或者提现10元
        public Integer incomeType=1;//1->未到帐, 2->已到帐 3->被撤销 4->提现
        public Integer status;
        public String comment="备注";
        @JsonFormat(pattern = "yyyy-MM-dd HH")
        public Date expectReceivingTime=new Date();//预计到帐时间
        @JsonFormat(pattern = "yyyy-MM-dd HH")
        public Date receivingTime=new Date();//到账时间
        @JsonFormat(pattern = "yyyy-MM-dd HH")
        public Date createTime=new Date();
        @JsonFormat(pattern = "yyyy-MM-dd HH")
        public Date updateTime=new Date();

        public Integer pageNum;
        public Integer pageSize;

        public MemberAccountDetail() {
        }
    }
    public static class Root<T> {

        public int code;
        public String msg;
        public T data;
        public String errorCode;
        public String errorContent;

    }

    public static class MemberAccount  {
        public static final long serialVersionUID = 1L;
        public Long id;
        public String memberId;//
        //账户信息
        //总金额
        public BigDecimal totalAmount=BigDecimal.ZERO;
        //未到账金额
        public BigDecimal totalOutstandingAmount=BigDecimal.ZERO;
        //可提现金额
        public BigDecimal totalUsableAmount=BigDecimal.ZERO;
        //已提现金额
        public BigDecimal totalWithdrawalAmount=BigDecimal.ZERO;
        @JsonFormat(pattern = "yyyy-MM-dd HH")
        public Date createTime;
        @JsonFormat(pattern = "yyyy-MM-dd HH")
        public Date updateTime;
    }

    /**
     * Auto-generated: 2022-09-13 9:51:26
     *
     * @author bejson.com (i@bejson.com)
     * @website http://www.bejson.com/java2pojo/
     */
    public static class Page<T> {

        public int total;
        public List<T> list;
        public int pageNum;
        public int pageSize;
        public int size;
        public int startRow;
        public int endRow;
        public int pages;
        public int prePage;
        public int nextPage;
        public boolean isFirstPage;
        public boolean isLastPage;
        public boolean hasPreviousPage;
        public boolean hasNextPage;
        public int navigatePages;
        public List<Integer> navigatepageNums;
        public int navigateFirstPage;
        public int navigateLastPage;
    }
}
