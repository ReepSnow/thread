package com.reepsnow.thread;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2017/7/4.
 */
public class ThreadTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(ThreadTest.class);
    @Test
    public void test1() throws InterruptedException {
        class Demo1Thread implements Runnable{
            public void run() {
                System.out.println("多线程测试"+new Date().getSeconds());
                LOGGER.error("dddddddddd");
            }
        }
        ThreadPoolManager.getScheduledThreadPool().schedule(new Demo1Thread(),5, TimeUnit.SECONDS);
        ThreadPoolManager.getScheduledThreadPool().scheduleAtFixedRate(new Demo1Thread(),-4,10,TimeUnit.SECONDS);
        Thread.sleep(30000);
    }
}
