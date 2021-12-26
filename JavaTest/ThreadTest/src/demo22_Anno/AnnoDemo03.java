package demo22_Anno;

import java.lang.reflect.Method;

public class AnnoDemo03 {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        Class<?> aClass = Class.forName("demo22_Anno.UseTest");
        UseTest o = (UseTest)aClass.newInstance();

        Method[] declaredMethods = aClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            boolean annotationPresent = declaredMethod.isAnnotationPresent(Test.class);
            System.out.println(declaredMethod.toString() + "------" + annotationPresent);
        }
    }
}
