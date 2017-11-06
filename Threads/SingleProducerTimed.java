package Threads;

public class SingleProducerTimed {
    public static void main(String[] args) throws InterruptedException {
        int producerSleepTime = 1200;
        int consumerWaitTime = 1000;

        SingleElementBufferTimed buffer= new SingleElementBufferTimed();
        new Thread(new ConsumerTimed(buffer,consumerWaitTime),"Consumer").start();

        new Thread(new ProducerTimed(1,producerSleepTime,buffer,100),"Producer 1").start();
        Thread.sleep(400);
        new Thread(new ProducerTimed(101,producerSleepTime,buffer,100),"Producer 2").start();
        Thread.sleep(400);
        new Thread(new ProducerTimed(1001,producerSleepTime,buffer,100),"Producer 3").start();
    }
}
