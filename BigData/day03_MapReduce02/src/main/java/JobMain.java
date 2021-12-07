import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class JobMain {
    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException, URISyntaxException {
        Configuration configuration = new Configuration();
        Job job = Job.getInstance(configuration, "mypartitioner");
        job.setJarByClass(JobMain.class);

        job.setMapperClass(MyPartitionerMapper.class);
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(NullWritable.class);

        job.setReducerClass(MyPartitionerReducer.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(NullWritable.class);
        Path inputPath = new Path("file:///D:\\input\\partition");
        Path outputPath = new Path("file:///D:\\output\\partition");

        FileSystem outDir = FileSystem.get(new URI("file:///"), configuration);
        if (outDir.exists(outputPath)){
            outDir.delete(outputPath, true);
        }
        job.setInputFormatClass(TextInputFormat.class);
        TextInputFormat.setInputPaths(job, inputPath);

        job.setOutputFormatClass(TextOutputFormat.class);
        TextOutputFormat.setOutputPath(job, outputPath);

        job.setPartitionerClass(MyPartitioner.class);
        job.setNumReduceTasks(2);


        boolean b = job.waitForCompletion(true);

        System.exit(b?0:1);

    }
}
