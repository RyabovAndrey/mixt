package Threads;

public class Consumer implements Runnable {
    /* Consumer в бесконечном цикле получает значение из буфера buffer*/
    private final SingleElementBuffer buffer;

    public Consumer(SingleElementBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while(true) {
            try {
                int element=buffer.get(); // метод get здесь блокирующий, т.к. синхронизирован
                System.out.println(element+" consumed");
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName());
                return;
            }
        }

    }
}
