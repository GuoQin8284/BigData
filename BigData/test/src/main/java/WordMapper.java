import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class WordMapper extends Mapper<LongWritable, Text, Text, LongWritable> {

    @Override
    protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, LongWritable>.Context context) throws IOException, InterruptedException {
        String[] splits = value.toString().split("#");
        Text text = new Text();
        for (String split : splits) {
            if (!("xxx".equals(split)||"yyy".equals(split))){
                text.set(split);
                context.write(text, new LongWritable(1));
            }
        }
    }
}
