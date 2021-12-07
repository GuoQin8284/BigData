import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class MyPartitioner extends Partitioner<Text, NullWritable> {

    @Override
    public int getPartition(Text text, NullWritable nullWritable, int i) {
        String[] split = text.toString().split("\t");
        int i1 = Integer.parseInt(split[5]);
        if (i1 < 15){
            return 0;
        }else {
            return 1;
        }

    }
}
