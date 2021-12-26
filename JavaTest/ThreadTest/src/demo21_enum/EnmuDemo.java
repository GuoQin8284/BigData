package demo21_enum;

public class EnmuDemo {
    public static void main(String[] args) {
        Season spring = Season.spring;
        spring.show();

        Season spring1 = Enum.valueOf(Season.class, "spring");
        System.out.println(spring1);

        Season spring2 = Season.spring;
        int ordinal = spring2.ordinal();
        System.out.println(ordinal);

        Season autumn = Season.autumn;
        int i = autumn.compareTo(spring1);
        System.out.println(i);
        String s = autumn.toString();
        System.out.println(s);

        Season[] values = Season.values();
        for (Season value : values) {
            System.out.println(value.toString());
        }
    }
}
