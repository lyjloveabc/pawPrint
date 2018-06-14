package com.thor.pawPrint.core.utils.system;

import com.thor.pawPrint.core.common.constant.BeanVariable;
import com.thor.pawPrint.core.common.result.Result;
import com.thor.pawPrint.core.common.result.ResultCode;
import com.thor.pawPrint.core.utils.object.EnumUtil;

/**
 * result工具类
 * Created by Thor on 2017/2/6.
 * happy coding - 1203!
 */
public class ResultUtil {
    //**************************************** success ****************************************//
    public static <D> Result<D> successResult() {
        Result<D> result = new Result<>();
        result.setCode(ResultCode.DEFAULT_SUCCESS.getCode());
        result.setData(null);
        result.setMessage(ResultCode.DEFAULT_SUCCESS.getMessage());

        return result;
    }

    public static <D> Result<D> successResult(D data) {
        Result<D> result = new Result<>();
        result.setCode(ResultCode.DEFAULT_SUCCESS.getCode());
        result.setData(data);
        result.setMessage(ResultCode.DEFAULT_SUCCESS.getMessage());

        return result;
    }

    public static <D> Result<D> successResult(D data, String message) {
        Result<D> result = new Result<>();
        result.setCode(ResultCode.DEFAULT_SUCCESS.getCode());
        result.setData(data);
        result.setMessage(message);

        return result;
    }

    //**************************************** error ****************************************//
    public static <D> Result<D> errorResult() {
        Result<D> result = new Result<>();
        result.setCode(ResultCode.DEFAULT_ERROR.getCode());
        result.setData(null);
        result.setMessage(ResultCode.DEFAULT_ERROR.getMessage());

        return result;
    }

    public static <D> Result<D> errorResult(String code) {
        ResultCode resultCodeMsg = null;
        try {
            resultCodeMsg = EnumUtil.getEnum(ResultCode.class, BeanVariable.CODE, code);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Result<D> result = new Result<>();
        result.setCode(resultCodeMsg == null ? ResultCode.DEFAULT_ERROR.getCode() : resultCodeMsg.getCode());
        result.setData(null);
        result.setMessage(resultCodeMsg == null ? ResultCode.DEFAULT_ERROR.getMessage() : resultCodeMsg.getMessage());
        return result;
    }

    public static <D> Result<D> errorResult(ResultCode resultCodeMsg) {
        Result<D> result = new Result<>();
        result.setCode(resultCodeMsg.getCode());
        result.setData(null);
        result.setMessage(resultCodeMsg.getMessage());
        return result;
    }

    public static <D> Result<D> errorResult(D data) {
        Result<D> result = new Result<>();
        result.setCode(ResultCode.DEFAULT_ERROR.getCode());
        result.setData(data);
        result.setMessage(ResultCode.DEFAULT_ERROR.getMessage());
        return result;
    }

    public static <D> Result<D> errorResult(ResultCode resultCodeMsg, D data) {
        Result<D> result = new Result<>();
        result.setCode(resultCodeMsg.getCode());
        result.setData(data);
        result.setMessage(resultCodeMsg.getMessage());
        return result;
    }

}
