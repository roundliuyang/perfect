package com.yly.apollo.core.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;


import java.util.EnumSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 类ApolloApiEnum.java的实现描述：平台提供的 接口
 * 
 * @author
 */
@Getter
@AllArgsConstructor
public enum ApolloApiEnum {
    /**
     * 开户API
     */
    OPEN_ACCOUNT_API("openAccount", "openAccountApplyValidator", "openAccountApplyHandlers", ApiTypeEnum.API.getCode()),

    /**
     * 授信API
     */
    OSS_STS_API("applyTempOssInfo", "applyTempOssInfoValidator", "applyTempOssInfoHandlers", ApiTypeEnum.API.getCode()),

    /**
     * 授信API
     */
    CREDIT_API("creditApply", "creditApplyValidator", "creditApplyHandlers", ApiTypeEnum.API.getCode()),

    /**
     * 授信API拓展
     */
    CASHLOAN_CREDIT_APPLY_API("cashLoanCreditApply", "cashLoanCreditApplyValidator", "cashLoanCreditApplyHandlers", ApiTypeEnum.API.getCode()),
    /**
     * 授信查询API拓展
     */
    QUERY_CASHLOAN_CREDIT_APPLY_API("queryCashLoanCreditApply", "queryCashLoanCreditApplyValidator", "queryCashLoanCreditApplyHandlers",
            ApiTypeEnum.API.getCode()),
    
    /**
     * 利率查询
     */
    QUERY_CREDITRATE_API("queryCreditRate", "queryCreditRateValidator",
            "queryCreditRateHandlers",
                         ApiTypeEnum.API.getCode()),
    /**
     * LPR基点查询
     */
    LPR_QUERY_API("queryLPR", "lPRQueryValidator",
            "lPRQueryHandlers",
            ApiTypeEnum.API.getCode()),
    /**
     * 所有利率查询
     */
    QUERY_ALLPERIODS_CREDITRATE_API("queryAllPeriodsCreditRate", "queryAllPeriodsCreditRateValidator",
            "queryAllPeriodsCreditRateHandlers",
            ApiTypeEnum.API.getCode()),

    /**
     * 查询可用额度
     */
    QUERY_CUSTOMERAMOUNT_API("queryCustomerAmount", "queryCustomerAmountValidator",
            "queryCustomerAmountHandlers",
                         ApiTypeEnum.API.getCode()),
    /**
     * 查询资金路由
     */
    QUERY_ROUTINGFUND_API("queryRoutingFund", "queryRoutingFundValidator",
            "queryRoutingFundHandlers",
                         ApiTypeEnum.API.getCode()),

    /**
     * 授信API 补偿
     */
    CREDIT_API_POLLING("creditApplyPolling", "", "creditApplyPollingHandlers", ApiTypeEnum.ONS.getCode()),
    
    /**
     * 征信授权书重签
     */
    CREDIT_SIGN_APPLY("creditSignApply", "creditSignApplyValidator", "creditSignApplyHandlers", ApiTypeEnum.API.getCode()),
    
    /**
     * 影像更新
     */
    CREDIT_USER_FILE_UPDATE("certImageUpdate", "certImageUpdateValidator", "creditUserFileUpdateHandlers", ApiTypeEnum.API.getCode()),
    
    /**
     * 影像更新异步处理ONS
     */
    CREDIT_USER_FILE_UPDATE_POLLING("certImageUpdatePolling", "", "creditUserFileUpdatePollingHandlers", ApiTypeEnum.ONS.getCode()),

    /**
     * 影像更新(同步返回接口)
     */
    CREDIT_USER_FILE_UPDATE_SYNC("certImageUpdateSync", "certImageUpdateSyncValidator", "creditUserFileUpdateSyncHandlers", ApiTypeEnum.API.getCode()),
    /**
     * 还款查询接口API
     */
    QUERY_REPAY_API("queryRepay", "queryRepayValidator", "queryRepayHandlers", ApiTypeEnum.API.getCode()),

    /**
     * 
     */
    USER_QUERY_API("userQuery", "userQueryValidator", "userQueryHandlers", ApiTypeEnum.API.getCode()),

    CREDIT_QUERY_API("creditQuery", "creditQueryValidator", "creditQueryHandlers", ApiTypeEnum.API.getCode()),

    AVAILAMOUNT_QUERY_API("availAmountQuery", "availAmountQueryValidator", "availAmountQueryHandlers",
            ApiTypeEnum.API.getCode()),

    FUND_ROUTE_QUERY_API("fundRouteQuery", "fundRouteQueryValidator", "fundRouteQueryHandlers",
            ApiTypeEnum.API.getCode()),

    CONTRACT_QUERY_API("contractQuery", "contractQueryValidator", "contractQueryHandlers", ApiTypeEnum.API.getCode()),

    CREDITRAT_EQUERY_API("creditRateQuery", "creditRateQueryValidator", "creditRateQueryHandlers",
            ApiTypeEnum.API.getCode()),

    BIND_CARD_API("bindCard", "bindCardValidator", "bindCardHandlers", ApiTypeEnum.API.getCode()),

    LOAN_TRIAL_API("loanTrial", "loanTrialValidator", "loanTrialHandlers", ApiTypeEnum.API.getCode()),

    LOAN_QUERY_API("loanQuery", "loanQueryValidator", "loanQueryHandlers", ApiTypeEnum.API.getCode()),

    /**
     * 贷前对外互斥接口
     */
    PRELOAN_EXTERNAL_MUTEX_API("queryWhetherAllowCredit","queryWhetherAllowCreditValidator","queryWhetherAllowCreditHandlers",ApiTypeEnum.API.getCode()),

    /**
     * 贷中对外互斥接口
     */
    CASHLOAN_EXTERNAL_MUTEX_API("queryWhetherAllowLoan","queryWhetherAllowLoanValidator","externalCashloanMutexHandlers",ApiTypeEnum.API.getCode()),

    /**
     * 最新绑卡信息查询
     */
    NEW_BIND_CARD_QUERY("queryNewBindCard","queryNewBindCardValidator","queryNewBindCardHandlers",ApiTypeEnum.API.getCode()),

    /**
     * 授信ons-API
     */
    CREDIT_ONS_API("creditApplyOnsConsumer", "", "creditApplyOnsConsumerHandlers", ApiTypeEnum.ONS.getCode()),
    
    
    
    /**
     * 影像更新ons-API
     */
    CREDIT_IMG_UPDATE_ONS_API("creditImgUpdateAsyncOnsConsumer", "", "creditImgUpdateAsyncOnsConsumerHandlers", ApiTypeEnum.ONS.getCode()),

    /**
     * 借款路由名称-API
     */
    LOAN_API("loanApply", "loanApplyValidator", "loanApplyHandlers", ApiTypeEnum.API.getCode()),
    
    

    /**
     * 授信API 补偿
     */
    LOAN_API_POLLING("loanApplyPolling", "", "loanApplyPollingHandlers", ApiTypeEnum.ONS.getCode()),

    /**
     * 借款ons路由名称-API
     */
    LOAN_ONS_API("loanCallback", "", "loanCallbackHandlers", ApiTypeEnum.ONS.getCode()),

    /**
     * ons协议路由名称-API
     */
    AGREEMENT_ONS_API("agreementOnsConsumer", "", "agreementOnsConsumerHandlers", ApiTypeEnum.ONS.getCode()),
    /**
     * 还款计划ons-API
     */
    REPAY_PLAN_ONS_API("repayPlanCreateOnsConsumer", "", "repayPlanCreateOnsConsumerHandlers", ApiTypeEnum.ONS.getCode()),
    /**
     * 还款计划补偿
     */
    REPAY_PLAN_CREATE_POLLING("repayPlanCreatePolling", "", "repayPlanCreatePollingHandlers", ApiTypeEnum.ONS.getCode()),

    //////////////////////////////////////////////还款部分开始//////////////////////////////////////////////////////////////////////////////
    /**
     * 还款计划查询接口API
     */
    QUERY_REPAY_PLAN_API("queryRepayPlan", "queryRepayPlanValidator", "queryRepayPlanHandlers",ApiTypeEnum.API.getCode()),

    /**
     * 还款试算
     */
    REPAY_TRIAL_API("repayTrial", "repayTrialValidator", "repayTrialHandlers", ApiTypeEnum.API.getCode()),
    
    /**
     * 还款ons-API
     */
    REPAY_ONS_API("repayApplyOnsConsumer", "", "repayApplyOnsConsumerHandlers", ApiTypeEnum.ONS.getCode()),

    /**
     * 还款API 补偿
     */
    CUSTOM_NUM_REPAY_POLLING("customNumRepayPolling", "", "customNumRepayPollingHandlers", ApiTypeEnum.ONS.getCode()),

    /**
     * 还款路由名称-API
     */
    CUSTOM_NUM_REPAY_API("customNumRepay", "customNumRepayValidator", "customNumRepayHandlers",ApiTypeEnum.API.getCode()),
    /**
     * 还款冲销查询
     */
    QUERY_REPAY_LIST("queryRepayList", "queryRepayListValidator", "queryRepayListHandlers", ApiTypeEnum.API.getCode()),

    /////////////////////////////////////////////还款部分结束////////////////////////////////////////////////////////////////////////
    
    /**
     * 直销银行借款
     */
    LOAN_YZFZXYH_API("loan", "loanApplyValidator", "loanApplyHandlers", ApiTypeEnum.API.getCode()),
    
    



    /**
     * 延迟任务重新还款路由名称-API
     */
    RETRY_REPAY_API("retryRepayApply", "", "", ""),

    /**
     * 对公代扣申请-API
     */
    WITHHOLD_PUBLIC_APPLY_API("withholdPublicApply", "", "", ""),

    /**
     * 对私代扣申请-API
     */
    WITHHOLD_PRIVATE_APPLY_API("withholdPrivateApply", "", "", ""),

    /**
     * 代扣ons-API
     */
    WITHHOLD_ONS_API("withholdApplyOnsConsumer", "", "", ""),


    /**
     * 提额ons-API
     */
    ADJUST_AMOUNT_ONS_API("adjustAmountOnsConsumer", "", "adjustAmountOnsConsumerHandlers", ApiTypeEnum.ONS.getCode()),
    
    /**
     * 提额回调通知补偿
     */
    ADJUST_ACCOUNT_NOTIFY_POLLING("adjustAccountNotifyPolling", "", "adjustAccountNotifyPollingHandlers", ApiTypeEnum.ONS.getCode()),


    /**
     * 还款计划查询接口API
     */
    REPAY_PLAN_QUERY_API("repayPlanQuery", "repayPlanQueryValidator", "repayPlanQueryHandlers",
            ApiTypeEnum.API.getCode()),
            
	/**
	 * 还款短信发送接口API
	 */
	SMS_NOTICE_API("httpProxy", "httpProxyValidator", "httpProxyHandlers",
	        ApiTypeEnum.API.getCode()),

    /**
     * 还款查询接口API
     */
    REPAY_QUERY_API("repayQuery", "repayQueryValidator", "repayQueryHandlers", ApiTypeEnum.API.getCode()),

    /**
     * 电子保单补偿
     */
    ELE_INSURANCE_POLLING("eleInsurancePolling", "", "eleInsurancePollingHandlers", ApiTypeEnum.ONS.getCode()),
    /**
     * 协议补偿
     */
    PROTOCOL_POLLING("protocolPolling", "", "protocolPollingHandlers", ApiTypeEnum.ONS.getCode()),

    /**
     * 人行征信授权书
     */
    CREDIT_REPORT_POLLING("creditReportPolling", "", "creditReportHandlers", ApiTypeEnum.ONS.getCode()),

    /**
     * 贷前合同处理
     */
    CREDIT_CONTRACT_POLLING("creditContractPolling", "", "creditContractPollingHandlers", ApiTypeEnum.ONS.getCode()),


    QUERY_USER_QUOTA_AND_RATE("queryUserQuotaAndRate", "queryUserQuotaAndRateValidators",
            "quotaAndRateQueryHandlers", ApiTypeEnum.API.getCode()),



    FUND_ROUTE("fundRoute", "fundRouteQueryValidator", "fundRouteQueryHandlers", ApiTypeEnum.API.getCode()),


    


    /**
     * otp绑卡
     */
    BIND_CARD_OTP_API("bindCardOTP", "bindCardOTPValidator", "bindCardOTPHandlers", ApiTypeEnum.API.getCode()),

    SET_DEFAULT_CARD_API("setDefaultCard", "setDefaultCardValidator", "setDefaultCardHandlers", ApiTypeEnum.API.getCode()),

    QUERY_DEFAULT_CARD_API("queryDefaultCard", "queryDefaultCardValidator", "queryDefaultCardHandlers", ApiTypeEnum.API.getCode()),

    QUERY_AGREEMENT_DEFAULT_CARD_API("queryBindCard", "queryBindCardValidator", "queryBindCardCardHandlers", ApiTypeEnum.API.getCode()),
    /**
     * 沃支付授信回调补偿
     */
    CREDIT_APPLY_NOTIFY_COMPENSATE_API("creditNoticeCompensate","creditNoticeCompensateValidator","creditNoticeCompensateHandlers",ApiTypeEnum.API.getCode()),
    LOAN_QUERY_FOR_ZXYH_API("queryLoan", "queryLoanValidator", "queryLoanHandlers", ApiTypeEnum.API.getCode()),
    
    /**
     * 列举OSS文件
     */
    QUERY_OSS_FILE_LIST("queryOssFileList","queryOssFileListValidator","queryOssFileListHandlers",ApiTypeEnum.API.getCode()),
    
    /**
     * 所有期数借款利率查询接口
     */
    ALL_CREDIT_RATE_QUERY("allCreditRateQuery","allCreditRateQueryValidator","allCreditRateQueryHandlers",ApiTypeEnum.API.getCode()),
    
    /**
     * 卡BIN信息查询
     */
    QUERY_CARD_BIN_INFO("queryCardBin","queryCardBinValidator","queryCardBinHandlers",ApiTypeEnum.API.getCode()),
    
    /**
     * 附属信息保存
     */
    SAVE_EXTEND_INFO("saveExtendInfo","saveExtendInfoValidator","saveExtendInfoHandlers",ApiTypeEnum.API.getCode()),
    
    /**
     * 附属信息查询
     */
    QUERY_EXTEND_INFO("queryExtendInfo","queryExtendInfoValidator","queryExtendInfoHandlers",ApiTypeEnum.API.getCode()),
    /**
     * 手动授信回调
     */
    MANUAL_CREDIT_NOTIFY("manualCreditNotify","manualCreditNotifyValidator","manualCreditNotifyHandlers",ApiTypeEnum.API.getCode()),
    /**
     * 沃支付手动授信回调
     */
    WOPAY_MANUAL_CREDIT_NOTIFY("wopayManualCreditNotify","manualCreditNotifyValidator","wopayManualCreditNotifyHandlers",ApiTypeEnum.API.getCode()),
    /**
     * 直销银行手动授信回调
     */
    ZXYH_MANUAL_CREDIT_NOTIFY("zxyhManualCreditNotify","manualCreditNotifyValidator","zxyhManualCreditNotifyHandlers",ApiTypeEnum.API.getCode()),
    /**
     * 手动借款回调
     */
    MANUAL_LOAN_NOTIFY("manualLoanNotify","manualLoanNotifyValidator","manualLoanNotifyHandlers",ApiTypeEnum.API.getCode()),
    /**
     * 沃支付手动借款回调
     */
    WOPAY_MANUAL_LOAN_NOTIFY("wopayManualLoanNotify","manualLoanNotifyValidator","wopayManualLoanNotifyHandlers",ApiTypeEnum.API.getCode()),

    /**
     * 众安贷欢迎回家用户准入
     */
    USER_MARKETING_ACCESS_API("userMarketingAccess","userMarketingAccessValidator","userMarketingAccessHandlers",ApiTypeEnum.API.getCode()),

    /**
     * 直销银行手动借款回调
     */
    ZXYH_MANUAL_LOAN_NOTIFY("zxyhManualLoanNotify","manualLoanNotifyValidator","zxyhManualLoanNotifyHandlers",ApiTypeEnum.API.getCode()),
    /**
     * 手动还款回调
     */
    MANUAL_REPAY_NOTIFY("manualRepayNotify","manualRepayNotifyValidator","manualRepayNotifyHandlers",ApiTypeEnum.API.getCode()),
    /**
     * 沃支付手动还款回调
     */
    WOPAY_MANUAL_REPAY_NOTIFY("wopayManualRepayNotify","manualRepayNotifyValidator","wopayManualRepayNotifyHandlers",ApiTypeEnum.API.getCode()),
    /**
     * 直销银行手动还款回调
     */
    ZXYH_MANUAL_REPAY_NOTIFY("zxyhManualRepayNotify","manualRepayNotifyValidator","zxyhManualRepayNotifyHandlers",ApiTypeEnum.API.getCode()),
    /**
     * 决策互斥查询
     */
    DECISION_APPLY("userAccess","userAccessValidator","userAccessHandlers",ApiTypeEnum.API.getCode()),
    /**
     * 查询用户绑卡信息
     */
    QUERY_USER_BANK_CARD_LIST("queryUserBankList","queryUserBankListValidator","queryUserBankListHandlers",ApiTypeEnum.API.getCode()),
    /**
     * 查询银行卡列表接口
     */
    QUERY_SUPPORT_BANK_LIST("queryBankList","queryBankListValidator","queryBankListHandlers",ApiTypeEnum.API.getCode()),

    /**
     * 资金方协议列表查询接口
     */
    CONTRACT_LIST_QUERY("contractListQuery","contractListQueryValidator","contractListQueryHandlers",ApiTypeEnum.API.getCode()),

	/**
	 * OCR识别接口
	 */
	OCR_DISCERN("ocrRecg","ocrRecgValidator","ocrRecgHandlers",ApiTypeEnum.API.getCode()),

    /**
     * 人脸认证鉴权接口
     */
    FACE_AUTH("faceAuth","faceAuthValidator","faceAuthHandlers",ApiTypeEnum.API.getCode()),

    /**
     * 公安鉴权接口
     */
    POLICE_AUTH("policeAuth","policeAuthValidator","policeAuthHandlers",ApiTypeEnum.API.getCode()),

    /**
     * 贷中合同处理
     */
    LOAN_CONTRACT_POLLING("loanContractPolling", "", "loanContractPollingHandlers", ApiTypeEnum.ONS.getCode()),


    UNION_LOGIN_API("unionLogin", "unionLoginValidator", "unionLoginHandler", ApiTypeEnum.API.getCode()),

    UNION_CONTRACT_QUERY_API("unionContractQuery", "unionContractQueryValidator", "unionContractQueryHandler", ApiTypeEnum.API.getCode()),

    UNION_CONTRACT_Down_API("unionContractDown", "unionContractDownValidator", "unionContractDownHandler", ApiTypeEnum.API.getCode()),
    /**
     * 借据查询
     */
    EVIDENCE_DEBT_QUERY("evidenceDebtQuery", "evidenceDebtQueryValidator", "evidenceDebtQueryHandlers", ApiTypeEnum.API.getCode()),

    /**
     * 获取活体检测签名
     */
    QUERY_FACE_RECOGNITION_SIGN_API("faceRecognitionSign", "faceRecognitionSignValidator", "faceRecognitionSignHandler", ApiTypeEnum.API.getCode()),

    /**
     * 查询活体检测结果
     */
    QUERY_FACE_RECOGNITION_RESULT_API("queryfaceRecognitionResult", "queryfaceRecognitionResultValidator", "queryfaceRecognitionResultHandler", ApiTypeEnum.API.getCode()),

    /**
     * 查询活体采集文件
     */
    QUERY_FACE_FILE_API("queryFaceFile", "queryFaceFileValidator", "queryFaceFileHandler", ApiTypeEnum.API.getCode()),


    CREDIT_CALL_BACK("creditCallBack", "", "creditCallBackHandlers", ApiTypeEnum.ONS.getCode()),
    /**
     * ons借款异步处理
     */
    LOAN_ASYNC_POLLING("loanAsyncPolling", "", "loanAsyncPollingHandlers", ApiTypeEnum.ONS.getCode()),
    /**
     * ons借款初始化处理
     */
    LOAN_INIT_POLLING("loanInitPolling", "", "loanInitPollingHandlers", ApiTypeEnum.ONS.getCode()),
    /**
     * 微博订单查询api
     */
    JDWB_LOAN_QUERY_API("openflowLoanLoanStatusFetch", "loanQueryValidator", "loanQueryHandlers", ApiTypeEnum.API.getCode()),

    /**
     * 借款授信处理(微聚)
     */
    JDWB_CREDIT_IN_LOAN_APPLY("openflowLoanOrderCommit", "creditInLoanApplyValidator", "creditInLoanApplyHandler", ApiTypeEnum.API.getCode()),
    /**
     * 贷前试算 借点微博
     */
    JDWB_PRELOAN_TRIAL("preTrial", "preTrialValidator", "preloanTrialHandlers", ApiTypeEnum.API.getCode()),
    /**
     * 签约申请 借点微博
     */
    JDWB_SIGN_APPLY("openflowLoanSignApply", "signApplyValidator", "signApplyHandlers", ApiTypeEnum.API.getCode()),
    /**
     * 签约确认 借点微博
     */
    JDWB_SIGN_CONFIRM("openflowLoanSignConfirm", "signConfirmValidator", "signConfirmHandlers", ApiTypeEnum.API.getCode()),
    /**
     * 签约查询 借点微博
     */
    JDWB_SIGN_QUERY("openflowLoanSignQuery", "signQueryValidator", "signQueryHandlers", ApiTypeEnum.API.getCode()),

    /**
     * 授信数据回流API
     */
    SYNC_CREDIT_APPLY("syncCreditApply", "syncCreditApplyValidator", "syncCreditApplyHandlers", ApiTypeEnum.API.getCode()),
    /**
     * 还款数据回流API
     */
    SYNC_REPAY_APPLY("syncRepayApply", "syncRepayValidator", "syncRepayByInstallmentNoHandlers", ApiTypeEnum.API.getCode()),
    /**
     * 借款数据回流API
     */
    SYNC_LOAN_APPLY("syncLoanApply", "syncLoanApplyValidator", "syncLoanApplyHandlers", ApiTypeEnum.API.getCode()),
    /**
     * 授信数据回流，同步影像件信息
     */
    SYNC_CREDIT_ACCT_IMAGE("syncCreditAcctImage", "", "syncCreditAcctImageHandlers", ApiTypeEnum.ONS.getCode()),
    /**
     * 授信数据回流，同步绑卡和公安认证信息
     */
    SYNC_CREDIT_ACCT_CARD_POLICY("syncCreditAcctCardPolicy", "", "syncCreditAcctCardPolicyHandlers", ApiTypeEnum.ONS.getCode()),
    /**
     * 授信数据回流更新
     */
    SYNC_CREDIT_APPLY_UPDATE("syncCreditApplyUpdate", "syncCreditApplyValidator", "syncCreditApplyUpdateHandlers", ApiTypeEnum.API.getCode()),

    /**
     * 同步交易，异步公安鉴权人脸认证API
     */
    UNION_MODEL_SYNC_ONS_API("unionModelQueryApplySyncOnsConsumer", "", "unionModelQueryApplySyncOnsHandlers", ApiTypeEnum.ONS.getCode()),
    /**
     * 同步数据查询请求API
     */
    UNION_MODEL_QUERY_APPLY_SYNC("unionModelQueryApplySync", "unionModelQueryApplySyncValidator", "unionModelQueryApplySyncHandlers", ApiTypeEnum.API.getCode()),
    /**
     * 异步数据查询请求API
     */
    UNION_MODEL_QUERY_APPLY("unionModelQueryApply", "unionModelQueryApplyValidator", "unionModelQueryApplyHandlers", ApiTypeEnum.API.getCode()),
    /**
     * 数据查询API
     */
    UNION_MODEL_QUERY("unionModelQuery", "unionModelQueryValidator", "unionModelQueryHandlers", ApiTypeEnum.API.getCode()),
    /**
     * 模型分结果同步API
     */
    UNION_MODEL_SCORE_SYNC("unionModelScoreSync", "unionModelScoreSyncValidator", "unionModelScoreSyncHandlers", ApiTypeEnum.API.getCode()),
    /**
     * 同步注册用户
     */
    SYNC_REGISTER_USER("syncRegisterUser", "syncRegisterUserValidator", "syncRegisterUserInfo", ApiTypeEnum.API.getCode()),

    /**
     * 同步进件信息
     */
    SYNC_ENTRYINFO_APPLY("syncEntryInfo", "syncEntryInfoValidator", "syncEntryInfoHanlder", ApiTypeEnum.API.getCode()),

    /**
     * 同步进件信息
     */
    APP_SYNC_CREDIT_SAVE_APPLY("appSyncCreditSave", "appSyncCreditSaveValidator", "appSyncCreditSaveHandler", ApiTypeEnum.API.getCode()),
    /**
     * 同步授信结果信息
     */
    APP_SYNC_CREDIT_RESULT_APPLY("appSyncCreditResult", "appSyncCreditResultValidator", "appSyncCreditResultHandler", ApiTypeEnum.API.getCode()),

    /**
     * 借款中参数转换
     */
    APP_SYNC_LOAN_SAVE_APPLY("appSyncLoanSave", "appSyncLoanSaveValidator", "appSyncLoanSaveHandler", ApiTypeEnum.API.getCode()),

    /**
     * 同步借款中信息
     */
    APP_SYNC_LOAN_TRNAS_APPLY("appSyncLoanTrans", "appSyncLoanTransValidator", "appSyncLoanTransHandler", ApiTypeEnum.API.getCode()),

    /**
     * 借款结果同步
     */
    APP_SYNC_LOAN_TRNAS_REUSULT_APPLY("appSyncLoanTransResult", "appSyncLoanTransResultValidator", "appSyncLoanTransResultHandler", ApiTypeEnum.API.getCode()),

    /**
     * 还款申请
     */
    APP_SYNC_REPAY_TRNAS_APPLY("appSyncRepayTrans", "appSyncRepayTransValidator", "appSyncRepayTransHandler", ApiTypeEnum.API.getCode()),
    /**
     * 还款结果申请
     */
    APP_SYNC_REPAY_TRNAS_REUSULT_APPLY("appSyncRepayTransResult", "appSyncRepayTransResultValidator", "appSyncRepayTransResultHandler", ApiTypeEnum.API.getCode()),

    /**
     * 用户注销
     */
    APP_SYNC_USER_CANCEL_APPLY("appSyncUserCancel", "appSyncUserCancelValidator", "appSyncUserCancelHandler", ApiTypeEnum.API.getCode()),

    /**
     * 用户互斥
     */
    APP_SYNC_MUTEX_INFO_APPLY("appMutexInfo", "appMutexInfoValidator", "appMutexInfoHanlder", ApiTypeEnum.API.getCode()),

    /**
     * 借款文件同步
     */
    APP_SYNC_LOAN_FILE_APPLY("appSyncLoanFile", "appSyncLoanFileValidator", "appSyncLoanFileHanlder", ApiTypeEnum.API.getCode()),

    /**
     * app同步账户 公安鉴权，影像件，绑卡信息
     */
    APP_SYNC_CREDIT_ACCT("appSyncCreditAcctInfo", "", "appSyncCreditAcctInfo", ApiTypeEnum.ONS.getCode()),

    /**
     * 全量授信数据回流API
     */
    APP_ALL_SYNC_CREDIT_APPLY("appAllSyncCreditApply", "allAppPreCheckValidator", "appALlSyncCreditApplyHandlers", ApiTypeEnum.API.getCode()),

    /**
     * 全量授信处理中数据回流
     */
    APP_ALL_SYNC_CREDIT_DOING_APPLY("appAllSyncCreditDoingApply", "allAppPreCheckValidator", "appALlSyncCreditDoingApplyHandlers", ApiTypeEnum.API.getCode()),

    /**
     * 全量借款数据回流
     */
    APP_ALL_SYNC_LOAN_APPLY("appAllSyncLoanApply", "allAppInLoanCheckValidator", "appALlSyncLoanApplyHandlers", ApiTypeEnum.API.getCode()),

    /**
     * 全量借款中数据回流
     */
    APP_ALL_SYNC_LOAN_DOING_APPLY("appAllSyncLoanDoingApply", "allAppInLoanCheckValidator", "appALlSyncLoanDoingApplyHandlers", ApiTypeEnum.API.getCode()),

    /**
     * 全量还款数据回流
     */
    APP_ALL_SYNC_REPAY_APPLY("appAllSyncRepayApply", "allAppInLoanCheckValidator", "appALlSyncRepayApplyHandlers", ApiTypeEnum.API.getCode()),

    /**
     * 全量还款中数据回流
     */
    APP_ALL_SYNC_REPAY_DOING_APPLY("appAllSyncRepayDoingApply", "allAppInLoanCheckValidator", "appALlSyncRepayDoingApplyHandlers", ApiTypeEnum.API.getCode()),

    /**
     * 全量借款文件数据回流
     */
    APP_ALL_SYNC_LOAN_FILE("appAllSyncLoanFile", "allAppInLoanCheckValidator", "appAllSyncLoanFileHandlers", ApiTypeEnum.API.getCode()),

    SYNC_SIGN_FILE("syncSignFile", "", "syncSignFileHanlder", ApiTypeEnum.API.getCode()),


    /**
     * 收单回流补偿
     */
    ACQ_SYNC_ORDER_COMPENSATE("acySyncOrderCompensate", "", "acqSyncOrderHandler", ApiTypeEnum.API.getCode()),
    /**
     * 收单回流
     */
    ACQ_SYNC_ORDER("acySyncOrder", "acySyncOrderValidator", "acqSyncOrderHandler", ApiTypeEnum.API.getCode()),
    /**
     * 授信对账回流
     */
    APP_DZ_SYNC_CREDIT("syncJdzadCreditApply", "appDzSyncCreditValidator", "appDzSyncCreditHandler", ApiTypeEnum.API.getCode()),
    /**
     * 授信对账回流处理中数据
     */
    APP_DZ_SYNC_CREDIT_DOING("syncJdzadCreditApplyDoing", "appDzSyncCreditDoingValidator", "appDzSyncCreditHandler", ApiTypeEnum.API.getCode()),
    /**
     * 借款对账回流
     */
    APP_DZ_SYNC_LOAN("syncJdzadLoanApply", "appDzSyncLoanValidator", "appDzSyncLoanHandler", ApiTypeEnum.API.getCode()),
    APP_DZ_SYNC_LOAN_DOING("syncJdzadLoanApplyDoing", "appDzSyncLoanDoingValidator", "appDzSyncLoanHandler", ApiTypeEnum.API.getCode()),
    /**
     * 还款对账回流
     */
    APP_DZ_SYNC_REPAY("syncJdzadRepayApply", "appDzSyncRepayValidator", "appDzSyncRepayHandler", ApiTypeEnum.API.getCode()),
    /**
     * 还款中对账回流
     */
    APP_DZ_SYNC_REPAY_DOING("syncJdzadRepayApplyDoing", "appDzSyncRepayDoingValidator", "appDzSyncRepayHandler", ApiTypeEnum.API.getCode()),
    /**
     * 催收主动划扣
     */
    DEDUCT_APPLY("deductApply", "deductApplyValidator", "deductApplyHandlers", ApiTypeEnum.API.getCode()),
    ;

    /**
     * apiName
     */
    private final String                      apiName;

    /**
     * apiValidator
     */
    private final String                      apiValidator;

    /**
     * apiHandler
     */
    private final String                      apiHandler;

    /**
     * api类型
     */
    private final String                      apiType;

    /**
     * cache
     */
    private static Map<String, ApolloApiEnum> CACHE_HOLDER = new ConcurrentHashMap<>();

    /*
     * init cache
     */
    static {
        EnumSet.allOf(ApolloApiEnum.class).forEach(v -> CACHE_HOLDER.put(v.getApiName(), v));
    }

    /**
     * getValue
     *
     * @param code code
     * @return enum
     */
    public static ApolloApiEnum getValue(String code) {
        return StringUtils.isNotBlank(code) ? CACHE_HOLDER.get(code) : null;
    }

}
