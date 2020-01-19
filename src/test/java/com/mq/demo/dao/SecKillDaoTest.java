package com.mq.demo.dao;

import com.mq.demo.BaseTest;
import com.mq.demo.entity.SecKill;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;

public class SecKillDaoTest extends BaseTest {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Resource
    private SecKillDao secKillDao;

    @Test
    public void queryOneDataById() {
        long secKillId = 1000;
        SecKill secKill = secKillDao.queryOneDataById(secKillId);
        logger.info("secKill={}", secKill);
    }
}
