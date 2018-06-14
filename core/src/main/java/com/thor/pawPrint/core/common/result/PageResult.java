package com.thor.pawPrint.core.common.result;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 分页数据包装对象
 * Created by Thor on 2017/2/6.
 * happy coding - 1203!
 */
@Data
public class PageResult<T> implements Serializable {
    //页码
    private Long pageNum;

    //页大小
    private Long pageSize;

    //总数
    private Long count;

    //数据
    private List<T> data;

}
