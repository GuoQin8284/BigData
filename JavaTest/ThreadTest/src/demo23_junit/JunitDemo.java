package demo23_junit;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class JunitDemo {

    public void add(int a, int b){
        System.out.println(a + b);
    }
    @Test
    public void addTest(){
        add(1,4);
    }

    @Before
    public void before(){
        System.out.println("before");
    }
    @After
    public void after(){
        System.out.println("after");
    }
}
