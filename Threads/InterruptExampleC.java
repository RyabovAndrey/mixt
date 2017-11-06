package Threads;

public class InterruptExampleC {
    public static void main(String[] args) {
        /* Здесь мы видим, что interrupt не прерывает поток, а только устанавливает флаг о прерывании.
        Но метод wait при вызове из потока с установленным флагом не выполняется,
        а выбрасывает исключение InterruptedException */
        System.out.println("Выставили флаг о том что поток метода main прерван.");
        Thread.currentThread().interrupt();
        try {
            System.out.println("Пытаемся уснуть.");
            Object lock=new Object();
            synchronized (lock) {
                lock.wait();
            }
        } catch (InterruptedException e) {
            System.out.println("Прервано исключением.");
        }
    }
}
