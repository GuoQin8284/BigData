import com.jcraft.jsch.IO;
import org.apache.commons.io.IOUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;
import org.apache.hadoop.yarn.webapp.hamlet.Hamlet;
import org.junit.Test;

import javax.security.auth.login.AppConfigurationEntry;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;


public class TestHDFS {
    @Test
    public void getFileSystemMethod01() throws IOException {
        Configuration configuration = new Configuration();
        configuration.set("fs.defaultFS","hdfs://node1:8020");

        FileSystem fileSystem = FileSystem.get(configuration);
        System.out.println(fileSystem);

    }

    public FileSystem getFileSystem() throws URISyntaxException, IOException {
        FileSystem fileSystem = FileSystem.get(new URI("hdfs://node1:8020"), new Configuration());
        return fileSystem;
    }

    @Test
    public void getPathTest() throws URISyntaxException, IOException {
        FileSystem fileSystem = getFileSystem();
        RemoteIterator<LocatedFileStatus> Iterator = fileSystem.listFiles(new Path("/"), true);
        while (Iterator.hasNext()){
            LocatedFileStatus next = Iterator.next();
            System.out.println(next.getPath());
            System.out.println("-------------start-----------------");
            BlockLocation[] blockLocations = next.getBlockLocations();
            System.out.println("当前bolck数量为："+blockLocations.length);
            for (BlockLocation blockLocation : blockLocations) {
                String[] hosts = blockLocation.getHosts();
                for (String host : hosts) {
                    System.out.println(host);
                }

            }
            System.out.println("--------------end-------------------");
        }

    }
    @Test
    public void mkdirTest() throws URISyntaxException, IOException {
        boolean isExists = getFileSystem().exists(new Path("/wordCount"));
        if (!isExists){
            boolean flag = getFileSystem().mkdirs(new Path("/wordCount"));
            System.out.println(flag);
        }

    }

    @Test
    public void downloadTest01() throws URISyntaxException, IOException {
        FSDataInputStream openFile = getFileSystem().open(new Path("/aaa/bbb/ccc/m3.txt"));
        FileOutputStream fileOutputStream = new FileOutputStream("D:/m3.txt");
        int b = 0;
        while ((b = openFile.read()) != -1){
            fileOutputStream.write(b);
        }
        fileOutputStream.close();
        openFile.close();
        getFileSystem().close();
    }

    @Test
    public void downloadTest02() throws URISyntaxException, IOException {
        getFileSystem().copyToLocalFile(new Path("/aaa/bbb/ccc/m3.txt"), new Path("D:/m4.txt"));
        getFileSystem().close();
    }

    @Test
    public void copyTest() throws URISyntaxException, IOException {
        FSDataOutputStream fsDataOutputStream = getFileSystem().create(new Path("/aaa/bbb/ccc/1.mp4"));
        File file = new File("");
        File[] files = file.listFiles();
        for (File file1 : files) {
            FileInputStream fileInputStream = new FileInputStream(file1);
            IOUtils.copy(fileInputStream, fsDataOutputStream);
            IOUtils.closeQuietly(fileInputStream);
        }
        IOUtils.closeQuietly(fsDataOutputStream);
    }

    @Test
    public void getFile() throws URISyntaxException, IOException {
        FSDataInputStream file = getFileSystem().open(new Path("/aaa/bbb/ccc/1.mp4"));
        FileOutputStream fileOutputStream = new FileOutputStream("D:\\1.mp4");
        int b;
        byte[] bytes = new byte[1024];
        while ((b=file.read(bytes)) != -1){
            fileOutputStream.write(bytes,0,b);
        }
        IOUtils.closeQuietly(fileOutputStream);
        IOUtils.closeQuietly(file);
    }

    @Test
    public void upLoadFile() throws IOException, URISyntaxException {
        FileInputStream localFile = new FileInputStream("D:\\wordCount\\wordCount.txt");
        FSDataOutputStream fsDataOutputStream = getFileSystem().create(new Path("hdfs://node1:8020/wordCount/wordCount.txt"));
        IOUtils.copy(localFile, fsDataOutputStream);
        IOUtils.closeQuietly(fsDataOutputStream);
        IOUtils.closeQuietly(localFile);
    }
}
