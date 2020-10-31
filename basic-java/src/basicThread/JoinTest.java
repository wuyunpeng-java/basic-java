package basicThread;

class JoinTest implements Runnable {
    static int a = 0;

    public static void main(String[] args) throws Exception {
        Runnable r = new JoinTest();
        Thread t = new Thread(r);
        t.start();
        // t.join();
        for (int i = 0; i < 2; i++) {
            System.out.println(i);
        }
        System.out.println(a);
    }

    public void run() {
        for (int k = 0; k < 5; k++)

            a = a + 1;
    }
}
