import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class SortMapper extends Mapper<LongWritable, Text, SortBean, NullWritable> {
    @Override
    protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, SortBean, NullWritable>.Context context) throws IOException, InterruptedException {
        String[] splits = value.toString().split("\t");
        String word = splits[0];
        int num = Integer.parseInt(splits[1]);
        SortBean sortBean = new SortBean(word, num);
        context.write(sortBean, NullWritable.get());
    }
}
