import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;

import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

import javax.xml.soap.Text;
import java.io.File;
import java.io.IOException;

public class JobMain {
    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {
        Configuration configuration = new Configuration();
        Job job = Job.getInstance(configuration);
        job.setJarByClass(JobMain.class);

        job.setMapperClass(Covid19Mapper.class);
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(NullWritable.class);

        job.setReducerClass(Covid19Reduce.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(NullWritable.class);

        Path inputPath = new Path("D:\\input\\partition");
        Path outputPath = new Path("D:\\ouput\\partition");

        String name = outputPath.getName();
        if (name.equals("partition")){
            File file = new File(String.valueOf(outputPath));
            System.out.println();
            file.delete();
        }

        job.setInputFormatClass(TextInputFormat.class);
        TextInputFormat.addInputPath(job, inputPath);
        job.setOutputFormatClass(TextOutputFormat.class);
        TextOutputFormat.setOutputPath(job, outputPath);

        job.setPartitionerClass(Covid19Partition.class);
        job.setNumReduceTasks(55);

        boolean b = job.waitForCompletion(true);
        System.exit(b?0:1);

    }
}
