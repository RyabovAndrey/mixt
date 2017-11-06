package Threads;

public class SingleProducerA {
    /* Еще одна реализация буфера */
    public static void main(String[] args) throws InterruptedException {
        SingleElementBufferA buffer= new SingleElementBufferA();
        new Thread(new ProducerA(1,3000,buffer)).start();
        Thread.sleep(2000);
        new Thread(new ProducerA(101,3000,buffer)).start();
        new Thread(new ConsumerA(buffer)).start();
        new Thread(new ConsumerA(buffer)).start();
        new Thread(new ConsumerA(buffer)).start();
    }
}
