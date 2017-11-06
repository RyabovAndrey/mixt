package Threads;

public class deadlock {
    public static void main(String[] args) throws InterruptedException {
        /* Самый короткий deadlock
        Thread.currentThread() - возвращает нить метода main и мы из метода
        main присоединяемся к этой нити и пытаемся дождаться окончания метода
        main
        */
        Thread.currentThread().join();
    }
}
