package Threads;

public class ProducerA implements Runnable{
    private int startValue;
    private final int period;
    private final SingleElementBufferA buffer;

    public ProducerA(int startValue, int period, SingleElementBufferA buffer) {
        this.startValue = startValue;
        this.period = period;
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println(startValue+" produced");
                buffer.put(startValue++);
                Thread.sleep(period);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName());
                return;
            }
        }
    }
}
