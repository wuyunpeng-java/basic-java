package 日期时间类;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;

/**jdk8之前
 * author:吴云鹏
 * Date:2020/4/6
 * Time:9:31
 * 1 SimpleDateFormat
 */
public class DateTimeTest3 {
    /*SimpleDateFormat的使用：对日期Date类的格式化和解析
     * 两个操作：格式化：日期---字符串；解析：格式化的逆过程：字符串---日期
     * */
    @Test
    public void testSimpleDateFormat() {
        SimpleDateFormat sdf = new SimpleDateFormat();
        Date date = new Date();
        System.out.println(date);
        String format = sdf.format(date);
        System.out.println(format);
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        String format1 = sdf1.format(date);
        System.out.println(format1);

    }

    @Test
    /** 练习一：将字符串“2020-04-07转为java.sql.date
     */
    public void testExer() throws ParseException {
        String birth = "2020-04-07";
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf1.parse(birth);
        java.sql.Date birthDate = new java.sql.Date(date.getTime());
        System.out.println(birthDate);
    }

    /*
    Calendar（抽象）日历类的使用
    实例化两种方式 1，创建其子类（GregorianCalendar)的对象；2：调用其静态方法getInstance（）--推荐；
     */
    @Test
    public void testCalendar() {
        Calendar calendar = Calendar.getInstance();
        // System.out.println(calendar.getClass());
        //get方法：
        int days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);
        System.out.println(calendar.get(Calendar.DAY_OF_YEAR));
        //set
        calendar.set(Calendar.DAY_OF_MONTH,6);
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);
        //add
        calendar.add(Calendar.DAY_OF_MONTH,-3);
        System.out.println(days);
        //getTime()---得到Date对象；
        Date date = calendar.getTime();
        System.out.println(date);
        //setTime
        Date date1 = new Date();
        calendar.setTime(date1);
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);

    }
    /*JDK1.8
     LocalDate,LocalTime,LocalDateTime
    * */
    @Test
    public void test5(){
        LocalDate now = LocalDate.now();
        LocalTime now1 = LocalTime.now();
        LocalDateTime now2 = LocalDateTime.now();
        System.out.println(now);
        System.out.println(now1);
        System.out.println(now2);
    }
}
