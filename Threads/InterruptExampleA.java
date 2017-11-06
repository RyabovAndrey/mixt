package Threads;

public class InterruptExampleA {
    /* Здесь мы видим, что метод interrupt() не уничтожает поток, а только выставляет
    флаг о том что поток прерван.
    Кроме того существует метод interrupted(), который если флаг установлен в true -
    меняет его на false и возвращает true(если флаг установлен в false - ничего не делает и
     возвращает false)*/
    public static void main(String[] args) throws InterruptedException {
        /* Здесь порождаем анонимный класс. Мы пишем new Runnable() и открываем скобку
        чтобы описать методы для Runnable, т.к. Runnable - это интерфейс, а у интерфейса
        есть нереализованные методы(в данном случае это метод run()) и следовательно мы
        не можем создавать экземпляр для Runnable()(т.е. мы не можем просто написать
        new Runnable())*/
        Thread thread=new Thread(new Runnable(){

            @Override
            public void run() {
                while (true) {
                    System.out.println(Thread.interrupted());
                    for (long i = 0; i <1_000_000_000L ; i++) { }
                }
            }
        });
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
    }
}
