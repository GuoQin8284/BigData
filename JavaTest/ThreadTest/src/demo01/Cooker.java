package demo01;

public class Cooker extends Thread {
    private Desk desk;
    public Cooker(Desk desk) {
        this.desk = desk;
    }
    @Override
    public void run() {
        synchronized (desk.getLock()){
        while (true) {
            if (desk.getCount() == 0) {
                break;
            } else {
                if (!desk.isFlag()) {
                    try {
                        System.out.println("厨师开始做食物");
                        Thread.sleep(10);
                        desk.setFlag(true);
                        desk.getLock().notifyAll();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        desk.getLock().wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        }
    }
}
