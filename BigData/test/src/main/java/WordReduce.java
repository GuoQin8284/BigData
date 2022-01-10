import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;


import java.io.IOException;

public class WordReduce extends Reducer<Text, LongWritable, Text, LongWritable> {
    @Override
    protected void reduce(Text key, Iterable<LongWritable> values, Reducer<Text, LongWritable, Text, LongWritable>.Context context) throws IOException, InterruptedException {
        Text text = new Text();
        LongWritable longWritable = new LongWritable();
        long count = 0L;
        for (LongWritable value : values) {
            count += value.get();
        }
        text.set(key);
        longWritable.set(count);
        context.write(text, longWritable);
    }
}
