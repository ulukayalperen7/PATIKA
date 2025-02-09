public class Main {
    public static void main(String[] args) {
// thread pooling ?
        CounterThread c1 = new CounterThread();
        CounterThread c2 = new CounterThread();
        c1.start();
        c2.start();
    }
}
