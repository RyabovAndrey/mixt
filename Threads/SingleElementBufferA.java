package Threads;

public class SingleElementBufferA {
    /* В данной реализации буфера мы пытаемся отказаться от notifyAll()
    и заменить его на notify() */
    private int waitedProducer=0;
    private int waitedConsumer=0;
    private Integer element=null;

    public synchronized void put(Integer newElement) throws InterruptedException {
        while (element!=null) {
            waitedProducer++;
            this.wait();
            waitedProducer--;
        }
        this.element=newElement;
        if (waitedConsumer>0) {
            this.notify();
        }
    }

    public synchronized Integer get() throws InterruptedException {
        while (element == null) {
            waitedConsumer++;
            this.wait();
            waitedConsumer--;
        }
        int result = this.element;
        this.element = null;
        if (waitedProducer > 0) {
            this.notify();
        }
        return result;
    }
}
