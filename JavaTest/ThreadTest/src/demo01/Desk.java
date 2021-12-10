package demo01;

public class Desk {

    private int Count;
    private boolean isFlag = false;
    private final Object lock = new Object();

    public Desk(int count, boolean isFlag) {
        Count = count;
        this.isFlag = isFlag;
    }

    public Desk() {
        this.Count = 10;
    }

    public int getCount() {
        return Count;
    }

    public void setCount(int count) {
        Count = count;
    }

    public boolean isFlag() {
        return isFlag;
    }

    public void setFlag(boolean flag) {
        isFlag = flag;
    }

    public Object getLock() {
        return lock;
    }

    @Override
    public String toString() {
        return "Desk{" +
                "Count=" + Count +
                ", isFlag=" + isFlag +
                '}';
    }
}
