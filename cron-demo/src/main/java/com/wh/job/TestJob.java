package com.wh.job;

import cn.hutool.cron.CronUtil;
import org.junit.Test;

import java.util.Date;

public class TestJob {

    public void run() {

        System.out.println("--------1111111111---------");
    }

    @Test
    public void test() {
        CronUtil.start();
    }
}
