package com.fanhanfei.springweb.model.base.enums;

import com.fanhanfei.springweb.model.base.ErrorCode;
import com.fanhanfei.springweb.model.base.ErrorCodeV2;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangjunshuai
 * @date 2020/2/18
 * @description
 **/
public enum BaseErrorCodeEnumV2 implements ErrorCodeV2 {

    OK(200, "成功", 200),

    /**
     * 5开头为服务端内部错误
     */
    UNKNOWN(500, "系统内部错误", 500),
    DB(501, "数据库错误", 500),
    MIDDLEWARE(502, "中间件错误", 500),
    RPC(503, "远程调用错误", 500),
    MSG_CONSUME_FAILURE(504, "消息消费失败", 500),

    /**
     * 4开头为客户端错误
     */
    ILLEGAL_PARAMETER(400, "参数错误", 400),
    DISABLED(401, "信息或服务已被禁用", 400),
    NOT_FOUND(404, "信息不存在", 400),
    TIME_OUT(408, "请求超时", 408),
    FREQUENCY_TOO_FAST(450, "请求频率过快", 400),
    ;

    private static Map<Integer, BaseErrorCodeEnumV2> cache = new HashMap<>();

    /**
     * 编号
     */
    private Integer code;

    /**
     * 名称
     */
    private String name;

    private int httpStatus;

    static {
        BaseErrorCodeEnumV2[] errorCodes = BaseErrorCodeEnumV2.values();
        for (BaseErrorCodeEnumV2 errorCode : errorCodes) {
            cache.put(errorCode.getCode(), errorCode);
        }
    }

    BaseErrorCodeEnumV2(Integer code, String name, int httpStatus) {
        this.code = code;
        this.name = name;
        this.httpStatus = httpStatus;
    }

    public Integer getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    @Override
    public int getHttpStatus() {
        return httpStatus;
    }

    /**
     * 按编号获取对应的名称
     * @param code  编号
     * @return  名称
     */
    public static String getNameByCode(Integer code) {
        ErrorCode errorCode = getByCode(code);
        return errorCode == null ? null : errorCode.getName();
    }

    /**
     * 按编号获取对应的名称
     * @param code  编号
     * @return  名称
     */
    public static BaseErrorCodeEnumV2 getByCode(Integer code) {
        BaseErrorCodeEnumV2 errorCode = cache.get(code);
        return errorCode;
    }
}
