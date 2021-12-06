import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class MyPartitioner extends Partitioner<Text, NullWritable> {

    @Override
    public int getPartition(Text text, NullWritable nullWritable, int i) {
        String Key = text.toString().split("\t")[5];
        int i1 = Integer.parseInt(Key);
        if (i1 >= 15){
            return 0;
        }else {
            return 1;
        }

    }
}
