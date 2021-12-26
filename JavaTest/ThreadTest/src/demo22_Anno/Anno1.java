package demo22_Anno;

public @interface Anno1 {
    int a() default 1;
    int[] arr() default {1,2,3};
    public String name();
}
