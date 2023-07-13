package com.yly.apollo.core.entity.dto;

import java.util.Date;

public class StandardBaseDTO{

    private static final long serialVersionUID = -8775820533392016826L;
    /**
     * 用户的访问ip
     */
    private String            ip;
    /**
     * 接入终端 1.PC 2.IOS 3.Android 4.H5 9.other
     */
    private String            client;

    /**
     * 请求时间
     */
    private Date reqDate;

    /**
     * 请求流水号
     */
    private String            reqNo;

    /**
     * 产品编码
     */
    private String            productCode;

    /**
     * 第三方账号
     */
    private String            thirdUserNo;

    /**
     * 众安用户ID
     */
    private Long              userId;

    /**
     * 核心账号
     */
    private Long              acctId;

    /**
     * api请求名称
     */
    private String            apiName;

    /**
     * api请求版本号
     */
    private String            apiVersion;

    /**
     * api请求路由名称
     */
    private String            routerName;

    /**
     * 商户代码（众安分配）
     */
    private String            partnerNo;

    /**
     * 渠道号码（众安分配）
     */
    private String            channelNo;
    /**
     * 用户来源 JSON格式
     */
    private String            source;

    public StandardBaseDTO(String ip, String client, Date reqDate, String reqNo, String productCode, String thirdUserNo, Long userId, Long acctId, String apiName, String apiVersion, String routerName, String partnerNo, String channelNo, String source) {
        this.ip = ip;
        this.client = client;
        this.reqDate = reqDate;
        this.reqNo = reqNo;
        this.productCode = productCode;
        this.thirdUserNo = thirdUserNo;
        this.userId = userId;
        this.acctId = acctId;
        this.apiName = apiName;
        this.apiVersion = apiVersion;
        this.routerName = routerName;
        this.partnerNo = partnerNo;
        this.channelNo = channelNo;
        this.source = source;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public Date getReqDate() {
        return reqDate;
    }

    public void setReqDate(Date reqDate) {
        this.reqDate = reqDate;
    }

    public String getReqNo() {
        return reqNo;
    }

    public void setReqNo(String reqNo) {
        this.reqNo = reqNo;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getThirdUserNo() {
        return thirdUserNo;
    }

    public void setThirdUserNo(String thirdUserNo) {
        this.thirdUserNo = thirdUserNo;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getAcctId() {
        return acctId;
    }

    public void setAcctId(Long acctId) {
        this.acctId = acctId;
    }

    public String getApiName() {
        return apiName;
    }

    public void setApiName(String apiName) {
        this.apiName = apiName;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    public String getRouterName() {
        return routerName;
    }

    public void setRouterName(String routerName) {
        this.routerName = routerName;
    }

    public String getPartnerNo() {
        return partnerNo;
    }

    public void setPartnerNo(String partnerNo) {
        this.partnerNo = partnerNo;
    }

    public String getChannelNo() {
        return channelNo;
    }

    public void setChannelNo(String channelNo) {
        this.channelNo = channelNo;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
