import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class SortBean implements WritableComparable<SortBean> {
    private String word;
    private int num;

    public SortBean() {
    }

    public SortBean(String word, int num) {
        this.word = word;
        this.num = num;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "SortBean{" +
                "word='" + word + '\'' +
                ", num=" + num +
                '}';
    }

    @Override
    public int compareTo(SortBean o) {
        int i = this.getWord().compareTo(o.getWord());
        if (i == 0){
            i = this.getNum() - o.getNum();
        }
        return i;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeUTF(word);
        dataOutput.writeInt(num);
    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {
        this.word = dataInput.readUTF();
        this.num = dataInput.readInt();
    }
}
