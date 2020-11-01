package java8_datetime;

import org.junit.Test;

import java.time.LocalDateTime;

/**
 * @author:吴云鹏@Date:2020/11/1 - Time:19:17
 * @ DESCRIPTION: LocalDate LocalTime LocalDateTime
 */
public class LocalDateTimeTest {
    @Test
    public void test1(){
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);
    }
}
