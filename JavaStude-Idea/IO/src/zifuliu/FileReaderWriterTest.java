package zifuliu;

import org.junit.Test;

import java.io.*;

/**
 *@ author:吴云鹏
 * Date:2020/4/17
 * Time:22:07
 */
public class FileReaderWriterTest {
    @Test
    public void fileReaderTest() throws IOException {
        FileReader fr = null;
        try {
            fr = new FileReader("hello.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            int data =0;
            while(data != -1){
                data = fr.read();
                System.out.print((char)data);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fr != null)
            fr.close();
        }
    }
    @Test
    /**
     * 使用read（）的重载的方法
     * */
    public void  fileReaderTest1()  {
        File file = new File("hello.txt");
        FileReader fr =null;
        try {
            fr = new FileReader(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        char[] cbuf =new char[10];
        int len;
            try {
                while ((len =fr.read(cbuf))!= -1){
                    System.out.print(cbuf);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        finally {
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            }
    }
    /**写入文件的操作
    注意：输出操作，对应的文件可以不存在。可增加参数决定是覆盖原文件还是追加到原文件中
     */
    @Test
    public void fileWriterTest2() throws IOException {
        FileWriter fw = new FileWriter("haha.txt",true);
        fw.write("I have a dream !\n");
        fw.write("你应该也有一个梦！\n");
        fw.close();
    }
    @Test
    public void fileReadWriterTest3() throws IOException {
        FileReader fr = new FileReader("haha.txt");
        FileWriter fw = new FileWriter("hello.txt");
        char[] cbuf =new char[6];
        int len;
        while ((len = fr.read(cbuf)) != -1){
            fw.write(cbuf,0,len);
        }
        fr.close();
        fw.close();

    }
}
