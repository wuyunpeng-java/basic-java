package produceAndConsumer;

/**
 *@ author:吴云鹏
 * Date:2020/4/3
 * Time:20:40
 * 线程通信的应用：经典例题：生产者与消费者
 * 生产者（productor)将产品交给店员（clerk),而消费者customer从店员处取走产品；
 * 店员一次只能持有固定数量的产品（比如20）；如果生产者试图生产更多的产品，店员会叫生产者停一下；如果店中有空位再通知生产者继续生产；
 * 如果店中没有产品了，店员会告诉消费者等一下；如果店里有产品了再通知消费者来取走产品
 */
public  class ProductTest {
    public static void main(String[] args) {
        Clerk clerk= new  Clerk();
        Productor p1 = new Productor(clerk);
        Customer c1 = new Customer(clerk);
        p1.setName("生产者1");
        c1.setName("消费者1");
        p1.start();
        c1.start();
    }

}
class Clerk{
     private int count =1;
    public synchronized void produceProductor() {
        if (count<20){
        count++;
        System.out.println(Thread.currentThread().getName()+":开始生产第"+count+"个产品");
        notify();
        }
        else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
      }
    public synchronized void consumerProductor() {
        if (count>1){
            count--;
            System.out.println(Thread.currentThread().getName()+":开始消费第"+count + "个产品");
            notify();
        }else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
 class Productor extends Thread{          //生产者
     Clerk clerk;

    @Override
    public void run() {
        System.out.println(this.getName()+"：开始生产产品....");
        while (true){
            clerk.produceProductor();
        }
    }

    public Productor(Clerk clerk) {
        this.clerk = clerk;
    }
}
class Customer extends Thread{
   private   Clerk clerk;

    public Customer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run(){
        System.out.println(this.getName()+"：开始消费产品....");
        while (true){
            clerk.consumerProductor();
    }

}

    }
