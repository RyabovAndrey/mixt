package Threads;

public class ConsumerA implements Runnable {
    private final SingleElementBufferA buffer;

    public ConsumerA(SingleElementBufferA buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while(true) {
            try {
                int element=buffer.get();
                System.out.println(element+" consumed");
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName());
                return;
            }
        }

    }
}
