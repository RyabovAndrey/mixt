package Threads;

public class InterruptBuffer {
    private ThreadNode producers = null;
    private ThreadNode consumers = null;
    private Integer elem = null;

    public synchronized void put(int newElem) {
        while (elem != null) {
            try {
                producers=new ThreadNode(Thread.currentThread(),producers);
                this.wait();
            } catch (InterruptedException e) {/*NOP*/}
        }
        elem = newElem;
        if (consumers != null) {
//            consumers.thread.interrupt();
            ThreadNode con=consumers;
            while(con.nextNode!=null) {
                con=con.nextNode;
            }
            con.thread.interrupt();
            con=null;
        }
    }

    public synchronized int get() {
        while (elem == null) {
            try {
                // ?
                consumers=new ThreadNode(Thread.currentThread(),consumers);
                this.wait();
            } catch (InterruptedException e) {/*NOP*/}
        }
        int result = elem;
        elem = null;
        if (producers != null) {
  //          producers.thread.interrupt();
            ThreadNode prod=producers;
            while(prod.nextNode!=null) {
                prod=prod.nextNode;
            }
            prod.thread.interrupt();
            prod=null;
        }
        return result;
    }
}
