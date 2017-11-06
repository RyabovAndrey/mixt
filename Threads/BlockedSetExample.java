package Threads;

public class BlockedSetExample {
    public static void main(String[] args) throws InterruptedException {
        /* Создаем объект BlockedSetExample и у него заставляем в пяти разных потоках
        выполнять синхронизированный метод f(). Мы увидим, что потоки заходят в метод f()
         по очереди(это свойство называется mutual exclusion, что означает что два или более потоков
         не может находиться в синхронизированном блоке по одной переменной и при этом выполняться)*/
        System.out.println("Метод синхронизирован");
        BlockedSetExample ref1=new BlockedSetExample();
        for (int i = 0; i <5 ; i++) {
            new Thread(new BlockedMethodCallerF(ref1,i)).start();
        }

        Thread.sleep(6000);
        System.out.println();
        System.out.println("Метод не синхронизирован");
        /* Создаем объект BlockedSetExample и у него заставляем в пяти разных потоках
        выполнять не синхронизированный метод g(). Мы увидим, что потоки заходят в метод g()
         все одновременно */
        BlockedSetExample ref2=new BlockedSetExample();
        for (int i = 0; i <5 ; i++) {
            new Thread(new BlockedMethodCallerG(ref2,i)).start();
        }

        Thread.sleep(6000);
        System.out.println();
        System.out.println("Метод синхронизирован, но мы создаем разные объекты");
        /* Создаем пять объектов BlockedSetExample и у каждого из них заставляем в пяти разных потоках
        выполнять синхронизированный метод f(). Мы увидим, что потоки заходят в метод f()
         все одновременно. Это говорит о том, что синхронизация должна происходить по одному объекту */
        for (int i = 0; i <5 ; i++) {
            new Thread(new BlockedMethodCallerF(new BlockedSetExample(),i)).start();
        }

        Thread.sleep(6000);
        System.out.println();
        System.out.println("Метод синхронизирован, но вместо sleep используем wait");
        /* Создаем объект BlockedSetExample и у него заставляем в пяти разных потоках
        выполнять синхронизированный метод h(). Мы увидим, что потоки заходят в метод h()
         все одновременно. Т.е. когда поток зашел в метод - он его блокирует, но по команде
          wait блокировка снимается.

         У всех объектов есть свойство - blocked, которое находится в состоянии false, но
         при заходе в блок synchronized проставляется в true. Другие потоки при попытке войти
         в блок synchronized проверяют blocked и если blocked==true не заходят в блок
         synchronized. При этом все эти потоки помещаются в специальную область block-set
         в которой ожидают, когда blocked станет false и после этого один из потоков начинает
         выполнение(очередность определяет JVM)

         Если поток вошел в synchronized блок он у объекта blocked=true. Если после этого вызвать
         у объекта метод wait(), то объект помещается в специальную область wait-set, где будет
         находиться пока его не разбудят с помощью notify()(notify возвращает объект в block-set).
         При этом свойство blocked=false и другой поток может зайти в synchronized блок. Но при этом
         синтаксически мы будем находиться внутри synchronized блока на той строке, где к нам применили
         wait().

         В этом примере мы видим как пять потоков заходят в поток один за другим, затем они
         блокируют объект и сразу же освобождают его по команде wait(). При этом они все помещаются
         в wait-set, спят там секунду и один за другим возвращаются в synchronized блок(путем помещения
         в block-set), где доделывают работу.
          */
        BlockedSetExample ref3=new BlockedSetExample();
        for (int i = 0; i <5 ; i++) {
            new Thread(new BlockedMethodCallerH(ref3,i)).start();
        }


    }

    public synchronized void f(int x) throws InterruptedException {
        System.out.println("+ "+x);
        Thread.sleep(1000);
        System.out.println("- "+x);

    }

    public void g(int x) throws InterruptedException {
        System.out.println("+ "+x);
        Thread.sleep(1000);
        System.out.println("- "+x);

    }

    public synchronized void h(int x) throws InterruptedException {
        System.out.println("+ "+x);
        this.wait(1000);
        System.out.println("- "+x);

    }
}
