package Threads;

public class PlayAccordeonFourTreads {
    public static void main(String[] args) {
        Runnable coordinator=new PlayAccordeonRun();
        Thread threadA=new Thread(coordinator);
        threadA.start();
    }
}
