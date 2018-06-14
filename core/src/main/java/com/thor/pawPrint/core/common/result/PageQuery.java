package com.thor.pawPrint.core.common.result;

import lombok.Data;

/**
 * 分页查询对象
 * Created by Thor on 2017/2/6.
 * happy coding - 1203!
 */
@Data
public class PageQuery<T> {
    //开始条目
    private Long startRow;

    //页大小
    private Long pageSize;

    //查询对象
    private T record;

}
