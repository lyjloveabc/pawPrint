package com.thor.pawPrint.core.common.result;

/**
 * Created by Thor on 2017/2/6.
 * happy coding - 1203!
 */
public enum ResultCode {
    //================================ START default ================================//
    DEFAULT_SUCCESS("111111", "操作成功"),
    DEFAULT_ERROR("000000", "操作失败"),
    //================================ END default ================================//

    //================================ START common ================================//
    NO_DATA("000001", "没有数据"),
    PARAM_ERROR("000002", "参数错误"),
    PARAM_ID_ERROR("000003", "数据库自增ID，不能指定ID新增数据"),
    PARAM_NO_ID("000004", "没有ID"),
    OBJECT_COPY_FAILED("000005", "对象复制出错"),
    NO_LOGIN("000006", "没有登录"),
    //================================ END common ================================//

    //================================ START 微信 ================================//
    NO_IS_USING_WE_CHAT_CONFIG("010001", "没有正在使用的微信配置"),
    GET_ACCESS_TOKEN_FAILED("010002", "获取accessToken失败"),
    WE_CHAT_CONFIG_NO_TOKEN("010003", "微信配置中没有token属性"),
    CHECK_SIGNATURE_FAILED("010004", "微信配置中没有token属性"),
    NO_OPEN_ID("010005", "没有openId"),
    //================================ END 微信 ================================//
    ;

    private String code;

    private String message;

    ResultCode(String code, String msg) {
        this.code = code;
        this.message = msg;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String msg) {
        this.message = msg;
    }

    public static boolean isSuccess(String code) {
        return ResultCode.DEFAULT_SUCCESS.getCode().equals(code);
    }
}
