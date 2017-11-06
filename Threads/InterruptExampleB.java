package Threads;

public class InterruptExampleB {
    public static void main(String[] args) {
        /* Здесь мы видим, что interrupt не прерывает поток, а только устанавливает флаг о прерывании.
        Но блокирующий метод sleep при вызове из потока с установленным флагом не выполняется,
        а выбрасывает исключение InterruptedException */
        System.out.println("Выставили флаг о том что поток метода main прерван.");
        Thread.currentThread().interrupt();
        try {
            System.out.println("Пытаемся уснуть.");
            Thread.sleep(Long.MAX_VALUE);
        } catch (InterruptedException e) {
            System.out.println("Прервано исключением.");
        }
    }
}
