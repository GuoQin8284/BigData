package demo22_Anno;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AnnoDemo02 {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Class<?> aClass = Class.forName("demo22_Anno.UseTest");
        UseTest o = (UseTest) aClass.newInstance();

        Method[] declaredMethods = aClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            boolean annotationPresent = declaredMethod.isAnnotationPresent(Test.class);
            if (annotationPresent){
                declaredMethod.invoke(o);
            }
        }
    }
}
