package Threads;

public class DynamicClass {
    public static void main(String[] args) throws InterruptedException {
        /* Здесь порождаем анонимный класс. Мы пишем new Runnable() и открываем скобку
        чтобы описать методы для Runnable, т.к. Runnable - это интерфейс, а у интерфейса
        есть нереализованные методы(в данном случае это метод run()) и следовательно мы
        не можем создавать экземпляр для Runnable()(т.е. мы не можем просто написать
        new Runnable())*/
        Runnable run=new Runnable(){

            @Override
            public void run() {
                System.out.println("Анонимный класс");
            }
        };
        /* JVM работает только с именованными сущностями, поэтому компилятор присваивает
        имя нашему анонимному классу во время компиляции */
        System.out.println("Имя анонимного класса "+run.getClass().getName());
        Thread thread=new Thread(run);
        thread.start();
    }
}
