package com.thor.pawPrint.core.base;

import com.thor.pawPrint.core.common.constant.Constant;
import com.thor.pawPrint.core.common.result.PageQuery;
import com.thor.pawPrint.core.common.result.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 通用DAO
 * Created by Thor on 2017/2/6.
 * happy coding - 1203!
 */

public class BaseDAO<DO, MAPPER extends BaseMapper<DO>> {
    @Autowired
    protected MAPPER mapper;

    /**
     * 根据主键硬删除
     *
     * @param id 主键
     * @return 影响的行数
     */
    public int deleteByPrimaryKey(Integer id) {
        return this.mapper.deleteByPrimaryKey(id);
    }

    /**
     * 插入整个对象
     *
     * @param record 对象
     * @return 影响行数
     */
    public int insert(DO record) {
        return this.mapper.insert(record);
    }

    /**
     * 插入属性可能不完整的对象
     *
     * @param record 属性可能不完整的对象
     * @return 影响行数
     */
    public int insertSelective(DO record) {
        return this.mapper.insertSelective(record);
    }

    /**
     * 根据主键查询对象
     *
     * @param id 主键
     * @return 对象
     */
    public DO selectByPrimaryKey(Integer id) {
        return this.mapper.selectByPrimaryKey(id);
    }

    /**
     * 根据主键更新对象， 不更新属性为null的属性
     *
     * @param record 属性可能不完整的对象
     * @return 影响行数
     */
    public int updateByPrimaryKeySelective(DO record) {
        return this.mapper.updateByPrimaryKeySelective(record);
    }

    /**
     * 根据主键更新整个对象
     *
     * @param record 整个对象
     * @return 影响行数
     */
    public int updateByPrimaryKey(DO record) {
        return this.mapper.updateByPrimaryKey(record);
    }

    /**
     * 查询记录总数
     *
     * @param record 对象
     * @return 符合条件的记录总数
     */
    public Long selectCount(DO record) {
        return this.mapper.selectCount(record);
    }

    /**
     * 分页查询
     *
     * @param record   条件对象
     * @param pageNum  第几页
     * @param pageSize 页大小
     * @return 符合的数据集
     */
    public PageResult<DO> selectByPaging(DO record, Long pageNum, Long pageSize) {
        Long pn = (pageNum == null || pageNum < 1) ? Constant.DEFAULT_PAGE_NUM : pageNum;
        Long ps = (pageSize == null || pageSize < 1) ? Constant.DEFAULT_PAGE_SIZE : pageSize;
        Long startRow = (pn - 1) * ps;

        PageQuery<DO> pageQuery = new PageQuery<>();
        pageQuery.setPageSize(ps);
        pageQuery.setRecord(record);
        pageQuery.setStartRow(startRow);

        Long count = this.mapper.selectCount(record);
        PageResult<DO> pageResult = new PageResult<>();
        pageResult.setPageNum(pn);
        pageResult.setPageSize(ps);
        pageResult.setCount(count);
        pageResult.setData(count == 0 ? null : this.mapper.selectByPaging(pageQuery));
        return pageResult;
    }


    /**
     * 查询符合条件的数据
     *
     * @param record 入参
     * @return 符合条件的数据
     */
    public List<DO> select(DO record) {
        return this.mapper.select(record);
    }

}
