package com.fanhanfei.springweb.model.base.enums;

import com.fanhanfei.springweb.model.base.ErrorCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangjunshuai
 * @date 2020/2/18
 * @description
 **/
public enum BaseErrorCodeEnum implements ErrorCode {

    OK(200, "成功"),

    /**
     * 5开头为服务端内部错误
     */
    UNKNOWN(500, "系统内部错误"),
    DB(501, "数据库错误"),
    MIDDLEWARE(502, "中间件错误"),
    RPC(503, "远程调用错误"),
    MSG_CONSUME_FAILURE(504, "消息消费失败"),

    /**
     * 4开头为客户端错误
     */
    ILLEGAL_PARAMETER(400, "参数错误"),
    DISABLED(401, "信息或服务已被禁用"),
    NOT_FOUND(404, "信息不存在"),
    TIME_OUT(408, "请求超时"),
    FREQUENCY_TOO_FAST(450, "请求频率过快"),

    // 20180903 为 "Land次卡支付类型" 添加. 用于内部自定义失败内容(覆盖"name")
    OPERATION_FAILED(460, "操作失败"),

    ILLEGAL_ARGUMENTS(200001, "请求参数不合法"),
    SERVER_INTERNAL_ERROR(200003, "服务器开小差了"),
    TOKEN_INVALID(200005, "用户token校验失败"),

    SKU_STOCK_NOT_ENOUGH(230007, "库存不足"),
    ORDER_PAID_STATUS(230001, "订单已支付"),
    ;

    private static Map<Integer, BaseErrorCodeEnum> cache = new HashMap<>();

    /**
     * 编号
     */
    private Integer code;

    /**
     * 名称
     */
    private String name;

    static {
        BaseErrorCodeEnum[] errorCodes = BaseErrorCodeEnum.values();
        for (BaseErrorCodeEnum errorCode : errorCodes) {
            cache.put(errorCode.getCode(), errorCode);
        }
    }

    BaseErrorCodeEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    /**
     * 按编号获取对应的名称
     *
     * @param code 编号
     * @return 名称
     */
    public static String getNameByCode(Integer code) {
        ErrorCode errorCode = cache.get(code);
        return errorCode == null ? null : errorCode.getName();
    }
}
