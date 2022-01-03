import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class Covid19Mapper extends Mapper<LongWritable, Text, Text, NullWritable> {
    @Override
    public void map(LongWritable longWritable, Text text, Context context) throws IOException, InterruptedException {
        context.write(text, NullWritable.get());
    }
}
