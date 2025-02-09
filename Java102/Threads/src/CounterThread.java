public class CounterThread extends Thread{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        for (int i = 0; i<10;i++) {
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
