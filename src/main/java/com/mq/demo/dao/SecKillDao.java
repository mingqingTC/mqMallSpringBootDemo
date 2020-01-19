package com.mq.demo.dao;

import org.apache.ibatis.annotations.Param;

import java.util.Date;

public interface SecKillDao extends EntityBaseDao {

    /**
     * 减库存
     *
     * @param secKillId 秒杀商品id
     * @param killTime  秒杀的时间
     * @return 影响表数据的行数, 0:没影响,1:减库存成功
     */
    int reduceNumber(@Param("secKillId") long secKillId, @Param("killTime") Date killTime);
}
