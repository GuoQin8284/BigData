
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

import java.io.IOException;

public class JobMain {
    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {
        Configuration configuration = new Configuration();
        Job sortBeanJob = Job.getInstance(configuration, "sortBean");

        sortBeanJob.setMapperClass(SortMapper.class);
        sortBeanJob.setMapOutputKeyClass(SortBean.class);
        sortBeanJob.setMapOutputValueClass(NullWritable.class);

        sortBeanJob.setReducerClass(SortReduce.class);
        sortBeanJob.setOutputKeyClass(SortBean.class);
        sortBeanJob.setOutputValueClass(NullWritable.class);

        sortBeanJob.setInputFormatClass(TextInputFormat.class);
        TextInputFormat.addInputPath(sortBeanJob, new Path("file:///D:\\input\\sort"));

        sortBeanJob.setOutputFormatClass(TextOutputFormat.class);
        TextOutputFormat.setOutputPath(sortBeanJob, new Path("file:///D:\\output\\sort"));

        boolean b = sortBeanJob.waitForCompletion(true);
        System.exit(b ? 0:1);
    }
}
