package demo2_threadPool;

import java.util.concurrent.*;

public class Demo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        myThread myThread = new myThread();
        for (int i = 0; i < 100; i++) {
            executorService.submit(()->{
                System.out.println(myThread.getThreadName());
            });
        }
    }

    private static void method1() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        myThread myThread = new myThread();
        executorService.submit(()->{
            System.out.println(myThread.getThreadName());
        });

        executorService.submit(()->{
            System.out.println(myThread.getThreadName());
        });

        executorService.submit(()->{
            System.out.println(myThread.getThreadName());
        });

        executorService.submit(()->{
            System.out.println(myThread.getThreadName());
        });
    }

}
