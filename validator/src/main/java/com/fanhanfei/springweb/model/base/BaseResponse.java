package com.fanhanfei.springweb.model.base;

import lombok.Data;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * @author zhangjunshuai
 * @date 2020/2/17
 * @description
 **/
@Data
public class BaseResponse<T> implements Serializable {

    private static final String DEFAULT_VERSION = "1.0.0";

    private boolean ok;

    private int errorCode;

    private String text;

    private String moreInfo;

    private String now;

    private String version;

    private T data;

    public static <T> BaseResponse<T> successResponse() {
        return new BaseResponse().withOk(true);
    }

    public static <T> BaseResponse<T> successResponse(T data) {
        return successResponse().withData(data);
    }

    public static <T> BaseResponse<T> failResponse() {
        return new BaseResponse().withOk(false);
    }

    public static <T> BaseResponse<T> failResponse(ErrorCode errorCode) {
        return failResponse().withErrorInfo(errorCode);
    }

    public static <T> BaseResponse<T> failResponse(int errorCode, String message) {
        return failResponse().withErrorInfo(errorCode, message);
    }

    public static <T> BaseResponse<T> failResponse(ServiceException se) {
        return failResponse().withErrorInfo(se);
    }


    public BaseResponse(){
        initDateAndVersion();
    }

    public BaseResponse(int errorCode){

        this.setOk(false);
        this.setErrorCode(errorCode);

        initDateAndVersion();
    }

    private void initDateAndVersion(){
        // 老接口该字段为utc时间
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
        this.now = formatter.format(new Date());
        this.version = DEFAULT_VERSION;
    }

    public <R extends BaseResponse> R withOk(boolean ok) {
        setOk(ok);
        return (R)this;
    }

    public <R extends BaseResponse> R withData(T data) {
        setData(data);
        return (R)this;
    }

    public <R extends BaseResponse> R withErrorInfo(ErrorCode errorCode) {
        setErrorCode(errorCode.getCode());
        setText(errorCode.getName());
        return (R)this;
    }

    public <R extends BaseResponse> R withErrorInfo(int errorCode, String text) {
        setErrorCode(errorCode);
        setText(text);
        return (R)this;
    }

    public <R extends BaseResponse> R withErrorInfo(ServiceException se) {
        setErrorCode(se.getCode());
        setText(se.getMessage());
        setMoreInfo(se.getDetailInfo());
        return (R)this;
    }

    public <R extends BaseResponse> R withMoreInfo(String moreInfo) {
        setMoreInfo(moreInfo);
        return (R)this;
    }
}
