import java.util.ArrayList;
import java.util.List;

public class Assignment {
    private static final List<Integer> evenNumbers = new ArrayList<>();
    private static final List<Integer> oddNumbers = new ArrayList<>();

    public static void main(String[] args) {

        Thread th1 = new Thread(new EvenOddFind(0, 2499));
        Thread th2 = new Thread(new EvenOddFind(2500, 4999));
        Thread th3 = new Thread(new EvenOddFind(5000, 7499));
        Thread th4 = new Thread(new EvenOddFind(7500, 9999));

        th1.start();
        th2.start();
        th3.start();
        th4.start();

        try {
            th1.join();
            th2.join();
            th3.join();
            th4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Total Even Numbers: " + evenNumbers.size());
        System.out.println("Total Odd Numbers: " + oddNumbers.size());
    }

    public static synchronized void addEven(int num) {
        evenNumbers.add(num);
    }

    public static synchronized void addOdd(int num) {
        oddNumbers.add(num);
    }
}

class EvenOddFind implements Runnable {
    private int start;
    private int end;

    public EvenOddFind(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        for (int i = start; i <= end; i++) {
            if (i % 2 == 0) {
                Assignment.addEven(i);
            } else {
                Assignment.addOdd(i);
            }
        }
    }
}
