/**
 * 创建3个窗口卖票，总数为100张
 */
public class TicketSaleDemo implements Runnable {
    private int num = 100;
@Override
    public void run() {
        while (num>0)
            show();

    }

    public  synchronized void show() {

        if (num > 0) {
           try {
                Thread.sleep(10);
            } catch (InterruptedException e) {}
          System.out.println(Thread.currentThread().getName() + "....sale...." + num--); }
    }

}

class TicketDemo {
    public static void main(String[] args) {
        TicketSaleDemo t = new TicketSaleDemo();
        Thread t1 = new Thread(t);
        Thread t2 = new Thread(t);
        Thread t3 = new Thread(t);


        t1.start();
        t2.start();
        t3.start();

    }
}

