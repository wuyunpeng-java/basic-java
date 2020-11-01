package file.exercise;

import java.io.File;

/**搜寻文件夹及下面子目录的文件夹及文件（使用递归）
 *@ author:吴云鹏
 * Date:2020/4/18
 * Time:12:09
 * 定义一个方法，参数传递File类型的目录，对目录进行遍历
 */
public class SearchDictionatry {
    public static void main(String[] args) {
        File file;
        file = new File("E:\\Users\\Administrator\\IdeaProjects\\JavaStude-Idea\\IO");
        getAllFile(file);
    }

    public static void getAllFile(File dir) {
        File[] files = dir.listFiles();
        for (File f : files) {
            System.out.println(f);
            if (f.isDirectory()){
                getAllFile(f);
            }
        }
    }
}
