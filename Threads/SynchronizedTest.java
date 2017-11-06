package Threads;

public class SynchronizedTest {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Тест 1");
        heapSynchronized();

        System.out.println("Тест 2");
        // мы вынуждены здесь ловить исключение, т.к. иначе программа прекратит выполняться из-за исключения
        try {
            nullReference();
        } catch (RuntimeException e) {
            System.out.println(e.fillInStackTrace());
        }

        System.out.println("Тест 3");
        // мы вынуждены здесь ловить исключение, т.к. иначе программа прекратит выполняться из-за исключения
        try {
            test3();
        } catch (Exception e) {
            System.out.println(e.fillInStackTrace());
        }

        System.out.println("Тест 4");
        test4();

        System.out.println("Тест 5");
        test5();

        System.out.println("Тест 6");
        test6();

        System.out.println("Тест 7");
        /* Мы не можем вызывать из статического метода нестатический, но моожем вызвать нестатический
        метод у экземпляра своего же класса(инстанса). Поэтому мы создаем экземпляр соего класса
        и вызываем у него метод*/
        new SynchronizedTest().test7();

        System.out.println("Тест 8");
        /* Мы не можем вызывать из статического метода нестатический, но моожем вызвать нестатический
        метод у экземпляра своего же класса(инстанса). Поэтому мы создаем экземпляр соего класса
        и вызываем у него метод*/
        new SynchronizedTest().test8();

        System.out.println("Тест 9");
        test9();

        System.out.println("Тест 10");
        test10();

    }
    public static void nullReference() throws InterruptedException {
        /* Этот метод выбросит NullPointerException, т.к. метод wait обращается не к переменной
        reference в Stack, а к объекту в Heap. Но у нас reference=null, а null нет в Heap */
        Object reference=null;
        synchronized (reference) {
            reference.wait(100);
        }
    }

    public static void heapSynchronized() throws InterruptedException {
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
            reference1.wait(100);
        }
    }
    public static void test3() throws InterruptedException {
        /* Этот метод выбросит IllegalMonitorStateException, т.к. мы делаем синхронизацию
        по одному объекту(new Object() в synchronized) а метод wait() вызываем у другого объекта
        (new Object() внутри synchronized блока). Т.е. у нас создается два разных объекта.

        При этом synchronized (new Object()) - бессмысленная операция, т.к. у нас нет ссылки на
        new Object()(этот объект анонимный) и мы ее никогда не сможем получить.
        */
        synchronized (new Object()) {
            new Object().wait(100);
        }
    }

    public static void test4() throws InterruptedException {
        /*
        Этот метод нормально отработает, т.к. synchronized блоки мы можем вкладывать друг в друга.
        */
        Object reference1=new Object();
        Object reference2=new Object();
        synchronized (reference1) {
            synchronized (reference2) {
                reference1.wait(100);
            }
        }
    }

    public static void test5() throws InterruptedException {
        /*
        Все как и в предыдущем методе, только wait() вызывается у reference2. Т.е. порядок
        synchronized блоков значения не имеет.
        */
        Object reference1=new Object();
        Object reference2=new Object();
        synchronized (reference1) {
            synchronized (reference2) {
                reference2.wait(100);
            }
        }
    }

    public static void test6() throws InterruptedException {
        /*
        Также мы можем сделать сколько угодно блокировок по одному объекту. Т.е. написать
        сколько угодно вложенных друг в друга synchronized блоков по одному объекты.
        Не имеет значение сколько раз мы засинхронизировались... Значение имеет только то
        что засинхронизировались мы хотя бы раз или нет.
        */
        Object reference1=new Object();
        synchronized (reference1) {
            synchronized (reference1) {
                reference1.wait(100);
            }
        }
    }

    public synchronized void test7() throws InterruptedException {
        /* Чтобы показать что я могу синхронизироваться по методу с помощью this
        мы вынуждены сделать метод нестатическим(у static методов нет this)*/
        this.wait(100);
    }

    public void test8() throws InterruptedException {
        /* Этот метод абсолютно идентичен предыдущему, но мы убрали из сигнатуры метода
         слово  synchronized*/
        synchronized (this) {
            this.wait(100);
        }
    }

    public static synchronized void test9() throws InterruptedException {
        /* Как только я делаю метод static у меня пропадает ключевое слово this(не создается
        экземпляр объекта). Но если у меня есть статический синхронизированный метод, то
        я могу вызвать wait() у класса(класс является объектом).

        У каждого объекта есть класс, но и каждый класс является объектом. */
        Class clazz=SynchronizedTest.class;
        clazz.wait(100);
    }

    public static  void test10() throws InterruptedException {
        /* Этот пример эквивалентен предыдущему, но без synchronized в сигнатуре метода */
        Class clazz=SynchronizedTest.class;
        synchronized (clazz) {
            clazz.wait(100);
        }
    }
}
