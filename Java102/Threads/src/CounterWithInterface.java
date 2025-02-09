public class CounterWithInterface implements Runnable {
    private String name;
    private boolean isRun = true;

    @Override
    public void run() {
        while (isRun) {
            for (int i = 0; i < 10; i++) {
                System.out.println(name + " " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public CounterWithInterface(String name) {
        this.name = name;
    }

    public void stop() {
        this.isRun = false;
    }
}
