package exercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * author:吴云鹏
 * Date:2020/5/10
 * Time:18:50
 */
public class HappyCinema {
    public static void main(String[] args) {
        ArrayList<Integer> available = new ArrayList<>();
        //影院目前可选的位置集合
        Collections.addAll(available,1,2,3,6,7,8);
        //顾客需要的位置
        ArrayList<Integer> seats1 = new ArrayList<>();
        seats1.add(1);
        seats1.add(2);
        ArrayList<Integer> seats2 = new ArrayList<>();
        seats2.add(7);
        seats2.add(8);

        Cinema c = new Cinema(available, "happy sxt");
        new Thread(new Customer(c, seats1), "老吴").start();
        new Thread(new Customer(c,seats2), "XX").start();
    }
}

//顾客
class Customer implements Runnable {
    Cinema cinema;
    List<Integer> seats;

    public Customer(Cinema cinema, List<Integer> seats) {
        this.cinema = cinema;
        this.seats = seats;
    }

    @Override
    public void run() {
        synchronized (cinema) {
            boolean flag = cinema.buyTickets(seats);
            if (flag) {
                System.out.println("出票成功！" + Thread.currentThread().getName() + "位置为：" + seats);
            } else {
                System.out.println("出票失败！" + Thread.currentThread().getName() + "位置不够！");
            }
        }
    }
}

//影院
class Cinema {
    List<Integer> available;//可选的位置
    String name;//影院名称

    public Cinema(List<Integer> available, String name) {
        this.available = available;
        this.name = name;
    }

    public boolean buyTickets(List<Integer> seats) {
        System.out.println("欢迎光临"+this.name+"当前可用位置为：" + available);
        List<Integer> copy = new ArrayList<>();
        copy.addAll(available);
        copy.removeAll(seats);
        //相减并判断是否购票成功
        if (available.size()-copy.size() != seats.size()) {
            return false;
        }
        //成功
        available=copy;
        return true;
    }

}
