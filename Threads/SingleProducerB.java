package Threads;

public class SingleProducerB {
    public static void main(String[] args) throws InterruptedException {
        SingleElementBufferB buffer= new SingleElementBufferB();
        new Thread(new ProducerB(1,3000,buffer)).start();
        Thread.sleep(2000);
        new Thread(new ProducerB(101,3000,buffer)).start();
        new Thread(new ConsumerB(buffer)).start();
    }
}
