package Threads;

public class PlayAccordeonThreeTreads {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i <10 ; i++) {


            Runnable printerA=new PrintRunnable("A    .",99);
            Thread threadA=new Thread(printerA);
            threadA.start();

            Runnable printerB=new PrintRunnable(".    B",100);
            Thread threadB=new Thread(printerB);
            threadB.start();
            threadA.join();
            threadB.join();

            System.out.println("-----");
            Runnable printerC=new PrintRunnable("  C",100);
            Thread threadC=new Thread(printerC);
            threadC.start();
            threadC.join();
            System.out.println("-----");
        }
    }
}
