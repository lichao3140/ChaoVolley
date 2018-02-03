package com.lichao.chaovolley.http;

import android.util.Log;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程池---单例模式
 * Created by Administrator on 2018-02-01.
 */

public class ThreadPoolManager {
    private static final String TAG = "lichao";
    private static ThreadPoolManager instance = new ThreadPoolManager();

    private LinkedBlockingQueue<Future<?>> taskQuene = new LinkedBlockingQueue<>();
    private ThreadPoolExecutor threadPoolExecutor;

    public static ThreadPoolManager getInstance() {
        return instance;
    }

    private ThreadPoolManager() {
        //线程池的参数设置
        threadPoolExecutor = new ThreadPoolExecutor(4, 10, 10,
                TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(4), handler);
        threadPoolExecutor.execute(runnable);
    }

    private Runnable runnable =new Runnable() {
        @Override
        public void run() {
            while (true) {
                FutureTask futureTask = null;
                try {
                    //阻塞式函数
                    futureTask = (FutureTask) taskQuene.take();
                    Log.i(TAG, "等待队列     " + taskQuene.size());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (futureTask != null) {
                    //线程池有空线程时，进去执行
                    threadPoolExecutor.execute(futureTask);
                }
                Log.i(TAG, "线程池大小      " + threadPoolExecutor.getPoolSize());
            }
        }
    };

    /**
     * 执行方法暴露给外部调用
     * @param futureTask
     * @param <T>
     * @throws InterruptedException
     */
    public <T> void execute(FutureTask<T> futureTask) throws InterruptedException {
        taskQuene.put(futureTask);
    }

    /**
     * 超过线程池网络拒绝策略
     */
    private RejectedExecutionHandler handler = new RejectedExecutionHandler() {
        @Override
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            try {
                taskQuene.put(new FutureTask<Object>(runnable, null) {
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };
}
