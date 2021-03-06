import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class SortReduce extends Reducer<SortBean, NullWritable, SortBean, NullWritable> {

    @Override
    protected void reduce(SortBean key, Iterable<NullWritable> values, Reducer<SortBean, NullWritable, SortBean, NullWritable>.Context context) throws IOException, InterruptedException {
        context.write(key, NullWritable.get());
    }
}
