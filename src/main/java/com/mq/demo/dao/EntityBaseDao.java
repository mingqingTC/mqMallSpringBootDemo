package com.mq.demo.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EntityBaseDao {

    /**
     * 根据id查询单条数据
     *
     * @param id  数据id编号
     * @param <E> 返回的实体类型
     * @return 查询的数据
     */
    <E> E queryOneDataById(@Param("id") long id);

    /**
     * 查询所有数据
     *
     * @param offset 开始的位置
     * @param limit  最多返回的数据数目
     * @param <E>    返回的实体类型
     * @return 查询得到的数据列表
     */
    <E> List<E> queryAllData(@Param("offset") int offset, @Param("limit") int limit);
}
