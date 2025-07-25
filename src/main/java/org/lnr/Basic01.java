package org.lnr;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

@Slf4j
public class Basic01 {

//    public static void main(String[] args) {
//        log.info("main method is Started.....");
//        for(int i=0;i<=10;i++) {
//            Thread t1 = new Thread(() -> log.info("Thread Name From Runnable: {}", Thread.currentThread().getName()));
//            t1.start();
//        }
//        log.info("Thread Name From Class: {}",Thread.currentThread().getName());
//    }

    /*
    1)In Java One Thread=One OS Thread --> which expensive and Less available to run
    2)So we needed to Use Less Threads , but So many Tasks there , That is When Thread Pool is coming from
* */

//(1) Fixed Thread Pool
//    public static void main(String[] args) {
//        log.info("main method is Started.....");
//
//        int coreCount=Runtime.getRuntime().availableProcessors();
//        ExecutorService service= Executors.newFixedThreadPool(coreCount);
//        for(int i=0;i<=100;i++) {
//            service.execute(() -> log.info("Thread Name From Runnable: {}", Thread.currentThread().getName()));
//        }
//        log.info("Thread Name From Class: {}",Thread.currentThread().getName());
//    }



    //(2) Cached Thread Pool

//    public static void main(String[] args) {
//        log.info("main method is Started.....");
//
//
//        ExecutorService service= Executors.newCachedThreadPool();
//        for(int i=0;i<=100;i++) {
//            service.execute(() -> log.info("Thread Name From Runnable: {}", Thread.currentThread().getName()));
//        }
//        log.info("Thread Name From Class: {}",Thread.currentThread().getName());
//    }


    //(3) Scheduled Thread Pool

    public static void main(String[] args) {
        log.info("main method is Started.....");

//For scheduling the tasks
        ScheduledExecutorService service= Executors.newScheduledThreadPool(10);

        //(ii) Task to run after 10 Seconds

        for(int i=0;i<=100;i++) {
            //(i) For Scheduling Task 10 seconds delay
            //service.schedule(() -> log.info("Thread Name From Runnable: {}", Thread.currentThread().getName()),10, TimeUnit.SECONDS);
            //(ii) For Scheduling Task Repeatedly every 10 seconds
            //service.scheduleAtFixedRate(() -> log.info("Thread Name From Runnable: {}", Thread.currentThread().getName()),10, 10,TimeUnit.SECONDS);
            //(iii) For Scheduling Task Repeatedly 10 seconds after completed previous task
            service.scheduleWithFixedDelay(() -> log.info("Thread Name From Runnable: {}", Thread.currentThread().getName()),10, 10,TimeUnit.SECONDS);


        }
        log.info("Thread Name From Class: {}",Thread.currentThread().getName());
    }

}
