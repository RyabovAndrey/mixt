package Exceptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;

public class StackTraceExamples {
    public static void main(String[] args) {
        System.out.println("Пример 1");
        try {
 //           a();
        } catch (RuntimeException e) {
         //   e.printStackTrace();
            /*
            Из main вызываем a(), из a() вызываем b(), из b() вызываем c().
            В c() бросаем исключение, а в main его перехватываем и печатаем StackTrace:
            java.lang.RuntimeException
	        at Exceptions.StackTraceExamples.c(StackTraceExamples.java:21)
	        at Exceptions.StackTraceExamples.b(StackTraceExamples.java:17)
	        at Exceptions.StackTraceExamples.a(StackTraceExamples.java:13)
	        at Exceptions.StackTraceExamples.main(StackTraceExamples.java:6)
	        Мы видим весь путь по которому пролетело исключение(он же стек вызова)
            c-->b-->-->a-->main.
            Таким способом можно узнать какаим образом происходила последовательность вызывов.
             */
        }
        System.out.println("Пример 2");
        try {
            a();
        } catch (Exception e) {
            /* Посмотрим из чего состоит StackTrace.
            Метод getStackTrace() возвращает массив StackTraceElement[].
            Каждый элемент массива соответствует одному вызову, т.е. в нашем случае
            элементов 4 и они соответствуют c,b,a,main.
             */
            StackTraceElement[] stackTrace=e.getStackTrace();
            for (StackTraceElement onecall : stackTrace) {
                System.out.println(onecall.getMethodName());
            }
        }
        System.out.println("Пример 3");
        aa();
        System.out.println("Пример 4");

        try {
//            aaa();
        } catch (ApplicationStorageException e) {
            /*
            В данном примере мы показываем как одни исключения вкладываются в другие.
            Например нам запрещено в методе main кидать checked исключения, поэтому мы
            оборачиваем наше FileNotFoundException в ApplicationStorageException, а его
            в свою очередь в ApplicationLogicException и создаем для них свои собственные
            сообщения. В результате получается такой StakTrace:

                Exception in thread "main" Exceptions.ApplicationLogicException: Ошибка сохранения
	        at Exceptions.StackTraceExamples.main(StackTraceExamples.java:46)
                Caused by: Exceptions.ApplicationStorageException: Ошибка в файловой системе
	        at Exceptions.StackTraceExamples.ccc(StackTraceExamples.java:97)
	        at Exceptions.StackTraceExamples.bbb(StackTraceExamples.java:90)
	        at Exceptions.StackTraceExamples.aaa(StackTraceExamples.java:86)
	        at Exceptions.StackTraceExamples.main(StackTraceExamples.java:44)
                Caused by: java.io.FileNotFoundException: 1 2 3 (Не удается найти указанный файл)
	        at java.io.FileInputStream.open0(Native Method)
	        at java.io.FileInputStream.open(FileInputStream.java:195)
	        at java.io.FileInputStream.<init>(FileInputStream.java:138)
	        at java.io.FileInputStream.<init>(FileInputStream.java:93)
	        at Exceptions.StackTraceExamples.ccc(StackTraceExamples.java:95)
	        ... 3 more

	        Здесь мы видим как будто бы 3 исключения, но на самом деле это одно, но обернутое в
	        два других.
	        ApplicationLogicException-->ApplicationStorageException-->FileNotFoundException
	        При этом у каждого есть свой StackTrace:

             */
            throw new ApplicationLogicException("Ошибка сохранения",e);
        }
        System.out.println("Пример 5");
        /* Здесь мы видим как образовывается LinkedList из исключений
        ходить по уровням вложений мы можем с помощью getCause() */
        System.out.println(new Error(new Exception()).getCause());
        System.out.println("Пример 6");
        try {
            aaa1();
        } catch (ApplicationLogicException e) {
            Throwable s=e;
            while (s!=null) {
                /*
                Когда мы образуем LinkedList из исключений в каждом исключении
                у нас еще есть и массив - StackTrace.
                Здесь мы идем вглубь по вложенным исключениям и у каждого
                выводим его StackTrace
                 */
                System.out.println(s.getMessage());
                StackTraceElement[] stackTrace=s.getStackTrace();
                for (StackTraceElement onecall : stackTrace) {
                    System.out.println("   "+onecall.getMethodName()+" в строке "+onecall.getLineNumber());
                }
                s=s.getCause();
            }
        }
    }

    public static void a() {
        b();
    }

    public static void b() {
        c();
    }

    public static void c() {
        throw new RuntimeException();
    }
    public static void aa() {
        bb();
    }

    public static void bb() {
        cc();
    }

    public static void cc() {
        /*
        Метод cc() не знает кто его вызвал, но вот таким способом мы можем это
        узнать, т.к. у JVM есть стек вызовов и мы можем к нему обращаться.
        Но это не всегда работает, т.к. JVM во время выполнения может оптимизировать работу.
        Например если JVM увидит что наши методы ничего не делают, а просто вызывают друг друга,
        то она может решить что оптимальнее вызвать метод cc() прямо из main. Как и когда будет
        происходить оптимизация мы не можем знать, поэтому полагаться на такой метод на 100% нельзя
         */
        try {
            throw new RuntimeException();
        } catch (RuntimeException e) {
            System.out.println(e.getStackTrace()[1].getMethodName());
        }
    }

    public static void aaa1(){
        try {
            aaa();
        } catch (ApplicationStorageException e) {
            throw new ApplicationLogicException("Ошибка сохранения",e);
        }
    }
    public static void aaa() {
        bbb();
    }

    public static void bbb() {
        ccc();
    }

    public static void ccc() {
        try {
            new FileInputStream("1 2 3");
        } catch (FileNotFoundException e) {
            throw new ApplicationStorageException("Ошибка в файловой системе",e);
        }
    }
}
