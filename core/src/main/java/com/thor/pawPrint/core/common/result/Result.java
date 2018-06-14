package com.thor.pawPrint.core.common.result;

import lombok.Data;

/**
 * 控制层返回的包装结果
 * Created by Thor on 2017/2/6.
 * happy coding - 1203!
 */
@Data
public class Result<T> {
    //错误码
    private String code;

    //错误信息
    private String message;

    //数据
    private T data;

}
