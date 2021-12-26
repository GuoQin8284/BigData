package Demo17_myClassLoader;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Demo_ReflectMethod {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Class<?> aClass = Class.forName("Demo17_myClassLoader.Students");

        Constructor<?>[] declaredConstructors = aClass.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println(declaredConstructor);

        }
//        获取私有构造方法
        Constructor<?> constructor2 = aClass.getDeclaredConstructor(String.class, String.class, String.class);
        constructor2.setAccessible(true);

//        创建构造方法对象
        Students students = (Students) constructor2.newInstance("张三","18","test001");
        System.out.println(students);

//        获取公有有参构造方法
//        Constructor<?> constructor = aClass.getConstructor(String.class,String.class,String.class);
//        System.out.println(constructor);

//        获取公有无参构造方法
        Constructor<?> constructor1 = aClass.getConstructor();
        System.out.println(constructor1);

//        获取类属性列表
        Field[] fields = aClass.getDeclaredFields();
        for (Field field : fields) {
            System.out.println("name:"+field.getName());
        }

//        获取公有类属性
        Field name = aClass.getField("name");
        System.out.println(name);

//        获取私有类属性
        Field age = aClass.getDeclaredField("age");
        System.out.println(age);

//        创建公有类对象
        Field name1 = aClass.getField("name");
        System.out.println(name1);
        Students students1 = (Students)aClass.newInstance();
        name1.set(students1, "lisi");
        Object o = name1.get(students1);
        System.out.println(o);

//        创建私有类对象
        Field age1 = aClass.getDeclaredField("age");
        Students students2 = (Students) aClass.newInstance();
        age1.setAccessible(true);
        age1.set(students2, "18");
        String name2 = (String) age1.get(students2);
        System.out.println(name2);

//        获取公有成员方法，并执行方法
        Method setName = aClass.getMethod("setName", String.class);
        System.out.println(setName);
        Students students3 = (Students) aClass.newInstance();
        setName.invoke(students3, "wangwu");

//        获取私有成员方法,并执行方法
        Method setAge = aClass.getMethod("setAge", String.class);
        System.out.println(setAge);
        Students students4 = (Students) aClass.newInstance();
        setName.invoke(students4, "22");



    }

}
