package Threads;

public class ConsumerB implements Runnable {
    private final SingleElementBufferB buffer;

    public ConsumerB(SingleElementBufferB buffer) {
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
