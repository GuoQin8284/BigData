package demo01;

public class Foodier extends Thread{
    private Desk desk;
    public Foodier(Desk desk) {
        this.desk = desk;
    }
    @Override
    public void run() {
        synchronized (desk.getLock()){
            while (true){
                if (desk.getCount() == 0){
                    break;
                }else {
                    if (desk.isFlag()){
                        try {
                            System.out.println("吃货正在吃");
                            Thread.sleep(100);
                            desk.setFlag(false);
                            desk.getLock().notifyAll();
                            desk.setCount(desk.getCount() - 1);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }else {
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
