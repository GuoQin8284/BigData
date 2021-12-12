package demo2_threadPool;

public class myThread extends Thread {
    public String getThreadName(){
        return Thread.currentThread().getName();
    }
}
