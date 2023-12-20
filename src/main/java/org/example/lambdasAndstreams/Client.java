package org.example.lambdasAndstreams;

import com.sun.source.tree.BreakTree;

import java.util.concurrent.*;

public class Client {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //Way-1
        HelloWorldPrinter task = new HelloWorldPrinter();
        Thread thread = new Thread(task); // call the run method of task.
        thread.start();

        // Can we create an object of interface ? -> NO
        // Why? Because interface is incomplete.
        // because of Abstract methods.

        //Way-2 - Anonymous Class.
        // - A class without name used to provide method implementation for interface.
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Anonymous class, " + Thread.currentThread().getName());
            }
        };
        Thread thread1 = new Thread(runnable);
        thread1.start();

        // Way-3 - Lambda Expression
        Thread thread2 = new Thread(() -> { System.out.println("Lambda, " + Thread.currentThread().getName());});
        thread2.start();

        Callable<String> callable  = new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "Scaler";
            }
        };
        ExecutorService executorService = Executors.newCachedThreadPool();
        //Future<String> future = executorService.submit(callable);
        //System.out.println(future.get());

        //Lambda Expression with Callable.
        Future<String> future = executorService.submit(() -> "Scaler");
        System.out.println(future.get());

        Thread t = new Thread(() -> {
            if (5 > 2) {
                System.out.println("5 is greater than 2");
            }

            if (10 > 1) {
                System.out.println("10 is greater than 1");
            }
        });
        t.start();


//        DemoInterface demoInterface = new DemoInterface() {
//            @Override
//            public void fun1() {
//
//            }
//
//            @Override
//            public void fun2() {
//
//            }
//
//            @Override
//            public void fun3() {
//
//            }
//        };
//        demoInterface.fun1();

    }
}
