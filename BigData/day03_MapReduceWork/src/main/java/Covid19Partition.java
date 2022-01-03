import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

import java.util.HashMap;

public class Covid19Partition extends Partitioner<Text, NullWritable> {
    private static int index = 0;
    private static HashMap<String, Integer> map = new HashMap<String, Integer>();
    public int getPartition(Text key, NullWritable value, int i) {
        String[] split = key.toString().split(",");
        int partitionIndex = getpartitionIndex(split[2]);
        return partitionIndex;

    }
    private int getpartitionIndex(String stateName){
        boolean b = map.containsKey(stateName);
        if (!b){
            map.put(stateName, ++index);
            return index;
        }else {
            Integer index = map.get(stateName);
            return index;
        }

    }
}
