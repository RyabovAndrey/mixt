package Threads;

public class HeapSynchronized {
    public static void main(String[] args) throws InterruptedException {
        /*
        Этот метод сработает не смотря на то что synchronized по reference1, а wait
        вызывается у reference2.
        Этот метод показывает, что synchronized срабатывает не на reference1, а на
        том месте в Heap куда указывает reference1.
        Т.е. мы в Heat создали новый Object и в reference1 храним ссылку на него.
        Затем мы ссылку из reference1 передаем переменной reference2. Теперь на наш
        Object из Stack есть две ссылки из reference1 и reference2.
        Поэтому мы спокойно можем вызвать wait() как у reference1, так и у reference2.
        Результат будет одинаковый.
        */
        Object reference1=new Object();
        Object reference2=reference1;
        synchronized (reference2) {
            reference1.wait();
        }
    }
}
