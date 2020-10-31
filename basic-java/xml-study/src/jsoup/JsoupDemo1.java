package jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

/**
 * @ author:吴云鹏@Date:2020/10/19 - Time:20:15
 * @ DESCRIPTION jsoup快速入门
 */
public class JsoupDemo1 {
    public static void main(String[] args) {
// 1,根据XML文档获取Document对象
//        1.1 获取student.xml文档的path
        String path = JsoupDemo1.class.getClassLoader().getResource("student.xml").getPath();
        try {
//        1.2 解析xml文档并加载文档进内存，获取DOM树
            Document document = Jsoup.parse(new File(path), "utf-8");
//  2,  获取元素对象Element
            Elements elements = document.getElementsByTag("name");
            Element element = elements.get(1);
            System.out.println(element.text());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
