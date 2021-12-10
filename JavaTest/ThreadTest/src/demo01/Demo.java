package demo01;

public class Demo {
    public static void main(String[] args) {
        Desk desk = new Desk();
        Cooker cooker = new Cooker(desk);
        Foodier foodier = new Foodier(desk);

        cooker.start();
        foodier.start();
    }
}
