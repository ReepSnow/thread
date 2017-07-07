package com.reepsnow.thread;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by Administrator on 2017/7/4.
 */
public class ThreadPoolManager {
    public static final ScheduledExecutorService scheduledThreadPool;
    static {
        scheduledThreadPool = new ScheduledThreadPoolExecutor(50,new DemoThreadFactory("Demo-Schedule"), new ThreadPoolExecutor.CallerRunsPolicy());
    }

    public static ScheduledExecutorService getScheduledThreadPool() {
        return scheduledThreadPool;
    }
}
