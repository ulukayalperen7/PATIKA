public class Main2 {
    public static void main(String[] args) {
        CounterWithInterface c2 = new CounterWithInterface("c2");

        Thread t1 = new Thread(new CounterWithInterface("c1"));
        Thread t2 = new Thread(c2);

        t1.start();
        t2.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        c2.stop();
    }
}
