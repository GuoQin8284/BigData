import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.yarn.webapp.hamlet.Hamlet;

import java.io.IOException;

public class JobMain {
    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {
        Configuration configuration = new Configuration();
        Job jobMain =  Job.getInstance(configuration, "wordcount");

        jobMain.setJarByClass(JobMain.class);
        jobMain.setInputFormatClass(TextInputFormat.class);
//        TextInputFormat.addInputPath(jobMain, new Path("file:///D:\\wordCount"));
        TextInputFormat.addInputPath(jobMain, new Path("hdfs://node1:8020/wordCount"));
        jobMain.setMapperClass(WordCountMapper.class);
        jobMain.setMapOutputKeyClass(Text.class);
        jobMain.setMapOutputValueClass(LongWritable.class);
        jobMain.setReducerClass(WordCountReducer.class);
        jobMain.setMapOutputKeyClass(Text.class);
        jobMain.setMapOutputValueClass(LongWritable.class);

        jobMain.setOutputFormatClass(TextOutputFormat.class);
//        TextOutputFormat.setOutputPath(jobMain, new Path("file:///D:\\outCount"));
        TextOutputFormat.setOutputPath(jobMain, new Path("hdfs://node1:8020/outCount"));
        System.out.println(new Path("file:///D:\\outCount"));
        boolean b = jobMain.waitForCompletion(true);

        System.exit(b?0:1);

    }
}
