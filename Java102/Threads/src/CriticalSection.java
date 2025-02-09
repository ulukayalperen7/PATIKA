import java.util.ArrayList;
import java.util.List;

public class CriticalSection {
    public static void main(String[] args) {
        OrderMatic machine = new OrderMatic();
        List<Thread> transactions = new ArrayList<>();
        for(int i =0; i<100 ; i++){
            Thread t = new Thread(machine);
            transactions.add(t);
            t.start();
        }
        for(Thread t : transactions){
            try {
                t.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("last number : " + (machine.getOrderNo() ));
    }
}

class OrderMatic implements Runnable {
    private int orderNo;  // here u can use volatile :
    private final Object LOCK = new Object();

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        synchronized (LOCK) {
           // this.orderNo++;
           // System.out.println(Thread.currentThread().getName() + " - OrderNo : " + this.orderNo);
            increaseOrder();
        }
    }

    private synchronized void increaseOrder(){
        this.orderNo++;
        System.out.println(Thread.currentThread().getName() + " - OrderNo : " + this.orderNo);
    }
    public int getOrderNo() {
        return orderNo;
    }
}