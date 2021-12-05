import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class WordCountMapper extends Mapper<LongWritable, Text, Text, LongWritable> {
    @Override
    protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, LongWritable>.Context context) throws IOException, InterruptedException {
        String[] line = value.toString().split(",");
        LongWritable longWritable = new LongWritable();
        Text text = new Text();
        for (String V1 : line) {
            text.set(V1);
            longWritable.set(1);
            context.write(text, longWritable);
        }
        
    }
}
