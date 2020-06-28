package org.yqj.source.demo.basic.netty.book.chart2.io.abio;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TimeServerHandlerExecutePool {

    private ExecutorService executorService;

    public TimeServerHandlerExecutePool(int threadCount){
        executorService = Executors.newFixedThreadPool(threadCount);
    }

    public void execute(Runnable runnable){
        executorService.execute(runnable);
    }
}
