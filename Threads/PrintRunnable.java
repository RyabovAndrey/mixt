package Threads;

public class PrintRunnable implements Runnable{
    private String msg;
    private long sleepMillis;

    public PrintRunnable(String msg, long sleepMillis) {
        this.msg = msg;
        this.sleepMillis = sleepMillis;
    }

    @Override
    public void run() {
        for (int i = 0; i <10 ; i++) {
            try {
                Thread.sleep(sleepMillis);
            } catch (InterruptedException e) {
                throw new RuntimeException();
            }
            System.out.println(msg);
        }
    }
}
