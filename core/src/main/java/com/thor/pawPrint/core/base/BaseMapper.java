package com.thor.pawPrint.core.base;

import com.thor.pawPrint.core.common.result.PageQuery;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 通用mapper，其中selectCount、selectByPaging没用自动生成，所以需要手动去mapper.xml里面写具体的sql
 * Created by Thor on 2017/2/6.
 * happy coding - 1203!
 */
@Component
public interface BaseMapper<T> {
    /**
     * 根据主键硬删除
     *
     * @param id 主键
     * @return 影响的行数
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 插入整个对象
     *
     * @param record 对象
     * @return 影响行数
     */
    int insert(T record);

    /**
     * 插入属性可能不完整的对象
     *
     * @param record 属性可能不完整的对象
     * @return 影响行数
     */
    int insertSelective(T record);

    /**
     * 根据主键查询对象
     *
     * @param id 主键
     * @return 对象
     */
    T selectByPrimaryKey(Integer id);

    /**
     * 根据主键更新对象， 不更新属性为null的属性
     *
     * @param record 属性可能不完整的对象
     * @return 影响行数
     */
    int updateByPrimaryKeySelective(T record);

    /**
     * 根据主键更新整个对象
     *
     * @param record 整个对象
     * @return 影响行数
     */
    int updateByPrimaryKey(T record);

    /**
     * 查询记录总数
     *
     * @param record 对象
     * @return 符合条件的记录总数
     */
    Long selectCount(T record);

    /**
     * 分页查询
     *
     * @param pageQuery 查询条件
     * @return 结果
     */
    List<T> selectByPaging(PageQuery<T> pageQuery);

    /**
     * 查询符合条件的数据
     *
     * @return 符合条件的数据
     */
    List<T> select(T record);

}
