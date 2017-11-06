package Threads;

public class TestThread {
    public static void main(String[] args) throws InterruptedException {
        test1();
        Thread.sleep(200);
        System.out.println();
        test2();
        Thread.sleep(1100);
        System.out.println();
        test3();
        Thread.sleep(1100);
        System.out.println();
        test4();
        System.out.println();
        test5();
        System.out.println();
        test6();
        System.out.println();
        test7();
    }

    public static void test1() throws InterruptedException {
        /* Создаем и запускаем новую нить и она начмнает печатать B.
        Но работа нашего метода продолжается и он после старта нити
        переходит к циклу и начинает печатать А. В результате буквы А и В
        печатаются по очереди */
        System.out.println("Пример 1");
        Runnable printer=new PrintRunnable(" B",100);
        Thread thread=new Thread(printer);
        thread.start();

        for (int i = 0; i <10 ; i++) {
            Thread.sleep(99);
            System.out.println("A");
        }
    }

    public static void test2() throws InterruptedException {
        /*
        Все как в предыдущем примере, но цикл и запуск нити поменяли местами.
        В результате паралельной работы не получилось, т.к. пока цикл не завершит работу,
        программа не перейдет к запуску нити.
        */
        System.out.println("Пример 2");
        for (int i = 0; i <10 ; i++) {
            Thread.sleep(250);
            System.out.println("A");
        }

        Runnable printer=new PrintRunnable(" B",100);
        Thread thread=new Thread(printer);
        thread.start();

    }
    public static void test3() throws InterruptedException {
        /*
        В конце метода поставим сообщение, которое покажет что метод закончился.
        Но работа не закончится, т.к у нас запущена нить и несмотря на то что метод
        из которого запущена нить закончился, нить продолжит работу.
        */
        System.out.println("Пример 3");
        for (int i = 0; i <10 ; i++) {
            Thread.sleep(250);
            System.out.println("A");
        }

        Runnable printer=new PrintRunnable(" B",100);
        Thread thread=new Thread(printer);
        thread.start();
        System.out.println("Метод закончился, а буквы будут печататься ");
    }

    public static void test4() throws InterruptedException {
        /* Создаем и запускаем новую нить и она начмнает печатать B.
        Но после старта выдаем команду join(), которая на время "заморозит"
        выполнение нашего метода, пока не закончит выполняться нить.
        По окончании работы нити - метод продолжит работу. */
        System.out.println("Пример 4");
        Runnable printer=new PrintRunnable(" B",100);
        Thread thread=new Thread(printer);
        System.out.println("Старт нити");
        thread.start();
        System.out.println("Присоединяемся к нити. Нить работает, а мы ждем");
        thread.join();
        System.out.println("Нить закончила работу");

        for (int i = 0; i <10 ; i++) {
            Thread.sleep(99);
            System.out.println("A");
        }
    }
    public static void test5() throws InterruptedException {
        /* Создаем и запускаем новую нить и она начмнает печатать B.
        Затем паралельно начинает выполняться цикл. Цикл работает быстрее нити,
         поэтому и закончит работать раньше. По окончании цикла присоединяемся к нити
         и метод "замораживается", а по окончании работы нити завершается */
        System.out.println("Пример 5");
        Runnable printer=new PrintRunnable(" B",1000);
        Thread thread=new Thread(printer);
        System.out.println("Старт нити");
        thread.start();
        System.out.println("Старт цикла");
        for (int i = 0; i <10 ; i++) {
            Thread.sleep(250);
            System.out.println("A");
        }
        System.out.println("Закончился цикл. Присоединяемся к нити. Нить работает, а мы ждем");
        thread.join();
        System.out.println("Нить закончила работу и метод закончил работу");
    }

    public static void test6() throws InterruptedException {
        /* Создаем и запускаем две нити. А работает быстрее чем В.
         Затем сразу присоединяюсь к А - жду когда она умрет и присоединяюсь к В.
          Жду завершения В и заканчиваю метод.
          */
        System.out.println("Пример 6");
        Runnable printerA=new PrintRunnable("A",300);
        Thread threadA=new Thread(printerA);
        System.out.println("Старт нити A");
        threadA.start();

        Runnable printerB=new PrintRunnable(" B",500);
        Thread threadB=new Thread(printerB);
        System.out.println("Старт нити B");
        threadB.start();


        System.out.println("Присоединяюсь к А");
        threadA.join();
        System.out.println("---- A закончился - присоединяюсь к В");
        threadB.join();
        System.out.println("Закончил метод");
    }

    public static void test7() throws InterruptedException {
        /* Как и в предыдущем случае, только теперь я присоединяюсь к медленной нити В,
        и только потом к быстрой А.
        Т.к. я присоединюсь к уже "умершей" А, то join() присоединится и сразу же отсоединится
          */
        System.out.println("Пример 7");
        Runnable printerA=new PrintRunnable("A",300);
        Thread threadA=new Thread(printerA);
        System.out.println("Старт нити A");
        threadA.start();

        Runnable printerB=new PrintRunnable(" B",500);
        Thread threadB=new Thread(printerB);
        System.out.println("Старт нити B");
        threadB.start();


        System.out.println("Присоединяюсь к В");
        threadB.join();
        System.out.println("---- В закончился - присоединяюсь к А");
        threadA.join();
        System.out.println("Закончил метод");
    }
}
