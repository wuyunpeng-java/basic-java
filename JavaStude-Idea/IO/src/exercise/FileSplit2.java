package exercise;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 该实例在前文的基础上用面向对象封装的思想重新设计。（实际上就是对FileSplit进行了封装改写）
 * /* @ auther 吴云鹏
 *
 * @date 将任意文件分割成若干份，并存贮在指定文件夹里面。本例指定了"E:\\dest"文件夹
 * 切割出来的每块的大小在实例化类的时候用构造函数指定。
 */
public class FileSplit2 {
    //源
    private File src;
    //目的地(文件夹)
    private String destDir;
    //所有分割后的文件的存储路径
    private List<String> destPaths;
    //每块大小
    private int blockSize;
    //块数；多少块
    private int size;

    public FileSplit2(String srcPath, String destDir, int blockSize) {
        super();
        this.src = new File(srcPath);
        this.destDir = destDir;
        this.blockSize = blockSize;
        this.destPaths = new ArrayList<String>();
        init();
    }

    public static void main(String[] args) throws IOException {
        FileSplit2 sf = new FileSplit2("e:/me.jpg", "e:/dest", 1024 * 6);

        //sf.split();
        sf.merge("e:/dest/me.jpg");

    }

    private void init() {
        long len = src.length();
        this.size = (int) Math.ceil(len * 1.0 / blockSize);
        for (int i = 0; i < size; i++) {
            destPaths.add(destDir + "/" + i + "-" + src.getName());
        }
        System.out.println(size + "..." + len);
    }

    private void splitDtail(int i, int beginPos, int actuaSize) throws IOException {
        RandomAccessFile raf = new RandomAccessFile(this.src, "r");
        RandomAccessFile raf2 = new RandomAccessFile(destPaths.get(i), "rw");
        raf.seek(beginPos);
        byte[] buff = new byte[3072];
        int len = -1;
        while ((len = raf.read(buff)) != -1) {
            if (actuaSize > len) {
                raf2.write(buff, 0, len);
                actuaSize -= len;
            } else {
                raf2.write(buff, 0, actuaSize);
                break;
            }
        }
        raf.close();
        raf2.close();
    }

    public void split() throws IOException {
        long len = src.length();
        System.out.println(size + "..." + len);
        int beginPos = 0;
        int actualSize = (int) (blockSize > len ? len : blockSize);
        for (int i = 0; i < size; i++) {
            beginPos = i * blockSize;
            if (i == size - 1) {//最后一块
                actualSize = (int) len;
            } else {
                actualSize = blockSize;
                len -= actualSize;
            }
            splitDtail(i, beginPos, actualSize);
            System.out.println(i + "--" + beginPos + "-->" + actualSize);
        }
    }

    /**
     * 文件的合并方法：merge
     *
     * @throws IOException
     */
    public void merge(String destPath) throws IOException {
        //输出流
        OutputStream os = new BufferedOutputStream(new FileOutputStream(destPath, true));
        //输入流
        for (int i = 0; i < destPaths.size(); i++) {
            BufferedInputStream is = new BufferedInputStream(new FileInputStream(destPaths.get(i)));
            //拷贝
            byte[] buff = new byte[1024];//缓冲容器
            int len = 0;//接收长度；
            while ((len = is.read(buff)) != -1) {
                os.write(buff, 0, len);
                os.flush();
            }
            is.close();

        }
        os.close();
    }
}
