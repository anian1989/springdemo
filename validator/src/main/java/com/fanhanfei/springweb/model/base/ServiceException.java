package com.fanhanfei.springweb.model.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhangjunshuai
 * @date 2020/2/17
 * @description
 **/
public class ServiceException extends RuntimeException {

    /**
     * 错误码
     */
    private Integer code;

    /**
     * 错误详细信息
     */
    private List<String> details;

    public ServiceException() {}

    public ServiceException(ErrorCode error) {
        super(error.getName());
        this.code = error.getCode();
    }

    /**
     *
     * @param code 错误码
     * @param message 错误描述
     */
    public ServiceException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    /**
     * 获取错误码
     *
     * @return 错误码
     */
    public Integer getCode() {
        return code;
    }

    public List<String> getDetails() {
        return details;
    }

    private void preAddDetail() {
        if (this.details == null) {
            this.details = new ArrayList<>();
        }
    }

    public void setDetail(String... details) {
        if (details == null) {
            this.details = new ArrayList<>();
            return;
        }
        this.details = Arrays.asList(details);
    }

    public void setDetail(List<String> details) {
        this.details = details;
    }

    public <T extends ServiceException> T addDetail(List<String> details) {
        if (details == null) {
            return (T) this;
        }
        preAddDetail();
        this.details.addAll(details);
        return (T) this;
    }

    public <T extends ServiceException> T addDetail(String... details) {
        if (details == null) {
            return (T) this;
        }
        preAddDetail();
        this.details.addAll(Arrays.asList(details));
        return (T) this;
    }

    public String getDetailInfo() {
        if (details == null || details.size() == 0) {
            return null;
        }
        if (details.size() == 1) {
            return details.get(0);
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (String item : details) {
            stringBuilder.append("，").append(item);
        }
        return stringBuilder.substring(1);
    }

    @Override
    public String toString() {
        return "code:" + code + ", msg:" + getMessage() + ",details:[" + getDetailInfo() + "]";
    }
}
