package com.yly.apollo.core.entity.dto;

import java.util.Date;

public class ApplyIdempotentDTO extends StandardBaseDTO{


    /**
     *
     */
    private static final long serialVersionUID = -2385014750794440242L;

    private String outerNo;

    public ApplyIdempotentDTO(String ip, String client, Date reqDate, String reqNo, String productCode, String thirdUserNo, Long userId, Long acctId, String apiName, String apiVersion, String routerName, String partnerNo, String channelNo, String source, String outerNo) {
        super(ip, client, reqDate, reqNo, productCode, thirdUserNo, userId, acctId, apiName, apiVersion, routerName, partnerNo, channelNo, source);
        this.outerNo = outerNo;
    }

    public ApplyIdempotentDTO(String ip, String client, Date reqDate, String reqNo, String productCode, String thirdUserNo, Long userId, Long acctId, String apiName, String apiVersion, String routerName, String partnerNo, String channelNo, String source) {
        super(ip, client, reqDate, reqNo, productCode, thirdUserNo, userId, acctId, apiName, apiVersion, routerName, partnerNo, channelNo, source);
    }


}