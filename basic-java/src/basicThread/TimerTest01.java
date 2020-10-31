package basicThread;

import java.util.Timer;
import java.util.TimerTask;

/**
 * 任务定时调度：Timer和Timetask
 * 这两个类配合使用可实现定时执行任务
 * author:吴云鹏
 * Date:2020/5/12
 * Time:17:27
 */
public class TimerTest01 {
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new MyTask(), 1000,500);
    }
}


class MyTask extends TimerTask {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("放空大脑，休息一会....");
        }

        System.out.println("end.....");
    }
}
