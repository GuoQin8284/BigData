import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

import java.io.IOException;

public class JobMain {
    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {
        Configuration configuration = new Configuration();
        Job wordJob = Job.getInstance(configuration, "wordJob");

        wordJob.setMapperClass(WordMapper.class);
        wordJob.setMapOutputKeyClass(Text.class);
        wordJob.setMapOutputValueClass(LongWritable.class);

        wordJob.setReducerClass(WordReduce.class);
        wordJob.setOutputKeyClass(Text.class);
        wordJob.setOutputValueClass(LongWritable.class);

        wordJob.setInputFormatClass(TextInputFormat.class);
        wordJob.setOutputFormatClass(TextOutputFormat.class);

        wordJob.setPartitionerClass(WordParttion.class);
        wordJob.setNumReduceTasks(2);

        Path inputPath = new Path("D:\\input\\test");
        Path outputPath = new Path("D:\\ouput\\test");

        TextInputFormat.addInputPath(wordJob, inputPath);
        TextOutputFormat.setOutputPath(wordJob, outputPath);

        boolean b = wordJob.waitForCompletion(true);
        System.exit(b?0:1);

    }
}
