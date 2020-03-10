package com.fanhanfei.springweb.config;

import com.alibaba.fastjson.JSON;
import com.fanhanfei.springweb.model.base.*;
import com.fanhanfei.springweb.model.base.enums.BaseErrorCodeEnum;
import com.fanhanfei.springweb.model.base.enums.BaseErrorCodeEnumV2;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.PropertyAccessException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.web.HttpMediaTypeException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author zhangjunshuai
 * @date 2020/2/18
 * @description
 **/
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 文件上传大小(单位Byte)
     */
    @Value("${file.maxUploadSize:8388608}")
    private int maxUploadSize;

    @ExceptionHandler({IllegalArgumentException.class, PropertyAccessException.class,
            ServletRequestBindingException.class, MethodArgumentNotValidException.class,
            HttpMediaTypeException.class, HttpMessageConversionException.class, HttpMediaTypeException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public BaseResponse handleBadRequest(HttpServletRequest request, Exception ex) {
        log.warn("handleIllegalArguments: URI = {}, {}", request.getRequestURI(), ex.getMessage(), ex);
        return buildIllegalParameterResponse();
    }

    private BaseResponse buildIllegalParameterResponse() {
        BaseResponse response = new BaseResponse();
        response.setOk(false);
        response.setErrorCode(BaseErrorCodeEnum.ILLEGAL_PARAMETER.getCode());
        response.setText("请求参数不合法");
        return response;
    }

    @ExceptionHandler({ConstraintViolationException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public BaseResponse handleConstraintViolation(HttpServletRequest request, ConstraintViolationException ex) {
        log.warn("handleConstraintViolation: URI = {}, {}", request.getRequestURI(), ex.getMessage(), ex);
        BaseResponse response = buildIllegalParameterResponse();
        if (CollectionUtils.isNotEmpty(ex.getConstraintViolations())) {
            response.setMoreInfo(ex.getConstraintViolations().stream()
                    .map(ConstraintViolation::getMessage)
                    .collect(Collectors.joining(",")));
        }
        return response;
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public BaseResponse handleException(HttpServletRequest request, Exception ex) {
        log.error("handleException, URI = {}, msg = {}", request.getRequestURI(), ex.getMessage(), ex);
        return BaseResponse.failResponse(BaseErrorCodeEnum.UNKNOWN.getCode(), "服务器开小差了");
    }

    @ExceptionHandler({MaxUploadSizeExceededException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity handleMaxUploadSizeExceededException(HttpServletRequest request,
                                                               MaxUploadSizeExceededException ex) {
        log.warn("handleMaxUploadSizeExceededException, URI = {}, msg = {}", request.getRequestURI(), ex.getMessage(),
                ex);
        return ResponseEntity.badRequest().body(String.format("上传文件过大，不能超过%dM！", maxUploadSize / 1024 / 1024));
    }

    @ExceptionHandler({NoHandlerFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public BaseResponse handleNotFoundException(HttpServletRequest request, Exception ex) {
        log.error("handleNotFoundException, headers = {}, msg = {}",
                JSON.toJSONString(getAllHeader(request)), ex.getMessage());
        return buildIllegalParameterResponse();
    }

    @ExceptionHandler({HttpRequestMethodNotSupportedException.class})
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    @ResponseBody
    public BaseResponse handleMethodNotSupportedException(HttpServletRequest request, Exception ex) {
        log.error("handleMethodNotSupportedException, headers = {}, msg = {}",
                JSON.toJSONString(getAllHeader(request)), ex.getMessage());
        return buildIllegalParameterResponse();
    }

    @ExceptionHandler(ServiceException.class)
    public ResponseEntity<BaseResponse> handleServiceException(HttpServletRequest request, HttpServletResponse response,
                                                               ServiceException ex) {
        log.warn("handleServiceException happen: URI = {}", request.getRequestURI(), ex);
        BaseResponse baseResponse =
                BaseResponse.failResponse(ex.getCode(), ex.getMessage()).withMoreInfo(ex.getDetailInfo());
        ErrorCodeV2 errorCodeV2 = null;
        BaseErrorCodeEnumV2 errorCodeEnumV2 = BaseErrorCodeEnumV2.getByCode(ex.getCode());
        if (Objects.nonNull(errorCodeEnumV2)) {
            errorCodeV2 = errorCodeEnumV2;
        } else {
//            errorCodeV2=Integer.MAX_VALUE;
        }
        HttpStatus httpStatus =
                Objects.nonNull(errorCodeV2) ? HttpStatus.valueOf(errorCodeV2.getHttpStatus()) : HttpStatus.BAD_REQUEST;
        response.setStatus(httpStatus.value());
        return new ResponseEntity<>(baseResponse, httpStatus);
    }

    private Map<String, String> getAllHeader(HttpServletRequest request) {
        Map<String, String> headers = Maps.newHashMap();
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            headers.put(headerName, request.getHeader(headerName));
        }
        return headers;
    }

}
