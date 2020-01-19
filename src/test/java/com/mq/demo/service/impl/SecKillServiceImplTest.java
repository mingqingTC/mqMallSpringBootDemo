package com.mq.demo.service.impl;

import com.mq.demo.BaseTest;
import com.mq.demo.entity.SecKill;
import com.mq.demo.service.SecKillService;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class SecKillServiceImplTest extends BaseTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SecKillService secKillService;

    @Test
    public void queryOneSecKill() {
        long secKillId = 1000L;
        SecKill secKill = secKillService.queryOneSecKill(secKillId);
        logger.info("secKill={}", secKill);
    }

    @Test
    public void querySecKills() {
        List<SecKill> secKillList = secKillService.querySecKills(0, 4);
        logger.info("secKillList={}", secKillList);
    }
}