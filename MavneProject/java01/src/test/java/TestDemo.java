import org.junit.Assert;

public class TestDemo {
    public void testsay(){
        Demo demo = new Demo();
        String res = demo.say("word");
        Assert.assertEquals("hello word", res);
    }
}
