package com.mq.demo.dao;

import com.mq.demo.entity.SuccessKilled;
import org.apache.ibatis.annotations.Param;

public interface SuccessKilledDao {

    /**
     * 查询成功秒杀的记录
     *
     * @param secKillId 秒杀的商品id
     * @param userPhone 秒杀的用户手机号
     * @return 带有秒杀商品对象的秒杀记录数据
     */
    SuccessKilled querySuccessKilledWithSecKill(@Param("secKillId") long secKillId, @Param("userPhone") long userPhone);

    /**
     * 插入秒成功记录
     *
     * @param secKillId 秒杀的商品id
     * @param userPhone 秒杀的用户手机号
     * @return 影响表数据的行数, 0:没影响,1:插入数据成功
     */
    int insertSuccessKilled(@Param("secKillId") long secKillId, @Param("userPhone") long userPhone);

}
