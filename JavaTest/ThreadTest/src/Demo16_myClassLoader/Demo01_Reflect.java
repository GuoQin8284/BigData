package Demo16_myClassLoader;

public class Demo01_Reflect {
    public static void main(String[] args) throws ClassNotFoundException {
//        第一种方法创建反射
        Class clazz = Class.forName("Demo16_myClassLoader.Students");
        System.out.println(clazz);

//        第二种创建反射方法
        Class<Students> clazz1 = Students.class;
        System.out.println(clazz1);

//        第三种创建反射方法
        Students students = new Students();
        Class<? extends Students> clazz2 = students.getClass();
        System.out.println(clazz2);

        System.out.println(clazz == clazz1);
        System.out.println(clazz1 == clazz2);
    }
}
