package 日期时间类;

/**
 * @ author 吴云鹏
 * @ date
 */
public class MyDate {
    int month;
    int day;
    private int year;

    public MyDate(int year, int month, int day) {
        super();
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public String toDateString() {
        return (year + "??   " + month + "   ??" + day + "   ??");
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

}
