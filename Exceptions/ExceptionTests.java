package Exceptions;

import com.sun.org.apache.regexp.internal.RE;

/**
 * Created by Администратор on 21.08.2017.
 */
public class ExceptionTests {
    public static void main(String[] args) {
        System.out.println("Тест 0");
        test0();

        System.out.println("Тест 1");
        test1();

        System.out.println("Тест 2");
        test2();

        System.out.println("Тест 3");
        test3();

        System.out.println("Тест 4");
        test4();

        System.out.println("Тест 5");
        // мы вынуждены здесь ловить исключение, т.к. иначе программа прекратит выполняться из-за исключения
        try {
            test5();
        } catch (Exception e) {
            System.out.println(e.fillInStackTrace());
        }

        System.out.println("Тест 6");
        // мы вынуждены здесь ловить исключение, т.к. иначе программа прекратит выполняться из-за исключения
        try {
            test6();
        } catch (Exception e) {
            System.out.println(e.fillInStackTrace());
        }

        System.out.println("Тест 7");
        test7();

        System.out.println("Тест 8");
        // мы вынуждены здесь ловить исключение, т.к. иначе программа прекратит выполняться из-за исключения
        try {
            test8();
        } catch (Exception e) {
            System.out.println(e.fillInStackTrace());
        }

        System.out.println("Тест 9");
        // мы вынуждены здесь ловить исключение, т.к. иначе программа прекратит выполняться из-за исключения
        try {
            test9();
        } catch (Exception e) {
            System.out.println(e.fillInStackTrace());
        }

        System.out.println("Тест 10");
        // мы вынуждены здесь ловить исключение, т.к. иначе программа прекратит выполняться из-за исключения
        try {
            /* Для того чтобы выполнился println вначале мы обязаны рассчитать аргумент, т.е. test10()
            поэтому мы идем в test10() и начинаем его выполнять, но там возникает исключение
            при этом метод println выполнен не будет (называют это - песочница(sand box))*/
            System.out.println(test10());
        } catch (Exception e) {
            System.out.println(e.fillInStackTrace());
        }

        System.out.println("Тест 11");
        System.out.println(test11());

        System.out.println("Тест 12");
        System.out.println(test12());

        System.out.println("Тест 13");
        System.out.println(test13());

        System.out.println("Тест 14");
        // мы вынуждены здесь ловить исключение, т.к. иначе программа прекратит выполняться из-за исключения
        try {
            test14();
        } catch (Exception e) {
            System.out.println(e.fillInStackTrace());
        }

        System.out.println("Тест 15");
        // мы вынуждены здесь ловить исключение, т.к. иначе программа прекратит выполняться из-за исключения
        try {
            test15();
        } catch (Exception e) {
            System.out.println(e.fillInStackTrace());
        }

        System.out.println("Тест 16");
        test16();

        System.out.println("Тест 17");
        test17();

        System.out.println("Тест 18");
        // мы вынуждены здесь ловить исключение, т.к. иначе программа прекратит выполняться из-за исключения
        try {
            test18();
        } catch (Exception e) {
            System.out.println(e.fillInStackTrace());
        }

        System.out.println("Тест 19");
        // мы вынуждены здесь ловить исключение, т.к. иначе программа прекратит выполняться из-за исключения
        try {
            test19();
        } catch (Exception e) {
            System.out.println(e.fillInStackTrace());
        }

        System.out.println("Тест 20");
        // мы вынуждены здесь ловить исключение, т.к. иначе программа прекратит выполняться из-за исключения
        try {
            test20();
        } catch (Exception e) {
            System.out.println(e.fillInStackTrace());
        }

        System.out.println("Тест 21");
        // мы вынуждены здесь ловить исключение, т.к. иначе программа прекратит выполняться из-за исключения
        try {
            test21();
        } catch (Exception e) {
            System.out.println(e.fillInStackTrace());
        }
    }

    public static void test0() {
        /* Заходим в метод - видим try. Пытаемся выполнить все что внутри try
        Если все нормально(нет никаких исключений) не заходим ни
        в один catch(т.е. для программы они перестают существовать)
        и продолжаем выполнение модуля за последней скобкой try-catch */
        try {
            System.out.println(0);
        } catch (RuntimeException e) {
            System.out.println(1);
        }
        System.out.println(2);
    }

    public static void test1() {
        /* Заходим в метод - видим try. Пытаемся выполнить все что внутри try
        Бросаем исключение (эмулируем чтобы посмотреть как все работает).
        В строке где произошло исключение прекращается работа и все что написано после этой строки
        не будет отрабатывать(внутри try{ })
        Начинаем проверять все catch по очереди от первого к последнему.
        Если ислючение совпадает с исключением в catch(или является его потомком), то выполняется
        этот catch{}(и только он единственный из всех). При этом исключение перемещается в переменную e.
        После этого считается что исключение поймано и обезврежено. Выполняем все что написано в нашем
        catch, после чего переходим за последнюю скобку в try-catch
        и продолжаем выполнение модуля за последней скобкой try-catch */
        try {
            System.out.println(0);
            throw new RuntimeException();
        } catch (RuntimeException e) {
            System.out.println(1);
        }
        System.out.println(2);
    }

    public static void test2() {
        /* Заходим в метод - видим try. Пытаемся выполнить все что внутри try
        Бросаем исключение (эмулируем чтобы посмотреть как все работает).
        В строке где произошло исключение прекращается работа и все что написано после этой строки
        не будет отрабатывать(внутри try{ })
        Начинаем проверять все catch по очереди от первого к последнему.
        Если ислючение является потомком  исключения в catch(или совпадает с ним), то выполняется
        этот catch{}(и только он единственный из всех). При этом исключение перемещается в переменную e.
        После этого считается что исключение поймано и обезврежено. Выполняем все что написано в нашем
        catch, после чего переходим за последнюю скобку в try-catch
        и продолжаем выполнение модуля за последней скобкой try-catch */
        try {
            System.out.println(0);
            throw new RuntimeException();
        } catch (Exception e) {
            System.out.println(1);
        }
        System.out.println(2);
    }

    public static void test3() {
        /* все как и в предыдущих, но у нас два catch в которых выполняется условие, т.к.
         в первом точное совпадение, а во втором является потомком
         но выполняется всегда то, что находится выше т.е. в данном случает это catch с
         RuntimeException */
        try {
            System.out.println(0);
            throw new RuntimeException();
        }catch (RuntimeException e) {
            System.out.println(1);
        } catch (Exception e) {
            System.out.println(2);
        }
        System.out.println(3);
    }

    public static void test4() {
        /* все как и в предыдущих, но у нас два catch в которых выполняется условие, т.к.
         в первом точное совпадение, а во втором является потомком
         но выполняется всегда то, что находится выше т.е. в данном случает это catch с
         Exception */
        try {
            System.out.println(0);
            throw new RuntimeException();
        }catch (Exception e) {
            System.out.println(1);
        }
        /* в таком порядке даже не пропускает компилятор, т.к. он знает что RuntimeException будет
        перехвачен в предыдущем catch
        catch (RuntimeException e) {
            System.out.println(2);
        } */
        System.out.println(3);
    }

    public static void test5() {
        /* теперь наше  RuntimeException не является потомком NullPointerException
        в результате мы не попадаем в catch, поэтому все что в catch выполнено не будет
         а также не выполняется ничего после блокаtry-catch
         и управление сразу передается в вызвавший метод и там мы получаем исключение*/
        try {
            System.out.println(0);
            throw new RuntimeException();
        }catch (NullPointerException e) {
            System.out.println(1);
        }
        System.out.println(2);
    }

    public static void test6() {
        /* теперь наше  RuntimeException не является потомком NullPointerException и ArithmeticException
        в результате мы не попадаем ни в один из catch, поэтому все что в catch выполнено не будет,
        а также не выполняется ничего после блока
        try/catch и управление сразу передается в вызвавший метод и там мы получаем исключение*/
        try {
            System.out.println(0);
            throw new RuntimeException();
        }catch (NullPointerException e) {
            System.out.println(1);
        }catch (ArithmeticException e) {
            System.out.println(2);
        }
        System.out.println(3);
    }

    public static void test7() {
        /* теперь наше NullPointerException не является потомком ArithmeticException, но при этом
        является потомком и RuntimeException и Exception.
        В результате мы не попадаем в первый catch по несовпадению, а в третий не поподем, т.к.
        будем перехвачены во втором. Поэтому после второго(минуя третий)
        выходим из блока try/catch и продолжаем выполнять текущий метод*/
        try {
            System.out.println(0);
            throw new NullPointerException();
        }catch (ArithmeticException e) {
            System.out.println(1);
        }catch (RuntimeException e) {
            System.out.println(2);
        } catch (Exception e) {
            System.out.println(3);
        }
        System.out.println(4);
    }

    public static void test8() {
        /* Мы бросаем NullPointerException и благополучно его перехватываем и тут же бросаем
        ArithmeticException, которое казалось бы должно быть перехвачено в следующем catch,
        но в следующий catch мы не попадем, т.к. мы можем зайти только в один catch(а мы в нем уже были)
        и во второй не зайдем ни при каких обстоятельствах. Поэтому ArithmeticException у нас не перехвачено
        и после закрывающей скобки блока try/catch мы вылетаем в вызвавший нас метод */
        try {
            System.out.println(0);
            throw new NullPointerException();
        }catch (NullPointerException e) {
            System.out.println(1);
            throw new ArithmeticException();
        }catch (ArithmeticException e) {
            System.out.println(2);
        }
        System.out.println(3);
    }

    public static void test9() {
        /* когда мы перехватываем исключение то помещаем его в переменную e(это равносильно
         тому что мы e=new NullPointerException();) и поэтому мы можем его бросить */
        try {
            System.out.println(0);
            throw new NullPointerException();
        }catch (NullPointerException e) {
            System.out.println(1);
            throw e;
        } catch (ArithmeticException e) {
            System.out.println(2);
        }
        System.out.println(3);
    }

    public static int test10() {
        /* блок finally служит для того чтобы проделать некую необходимую работу в любом случае
          (например закрыть потоки). Было исключение или не было, перехвачено или нет... в любом */
        try {
            System.out.println(0);
            throw new RuntimeException();
        } finally {
            System.out.println(1);
        }
    }

    public static int test11() {
        /* блок finally выполняется всегда... мы в try секции выбрасываем return и должны прекратить
         любые действия и выйти в вызывающий метод. Но return у нас в try секции и поэтому перед выходом
          в вызывающий метод он сработает несмотря на return. Finally как бы приостанавливает выполнение
          return и выполняется сам, а затем продолжается выполнение return */
        try {
            System.out.println(0);
            return 43;
        } finally {
            System.out.println(1);
        }
    }

    public static int test12() {
        /* если в finally есть свой return, то return в try секции выполнен не будет */
        try {
            System.out.println(0);
            return 43;
        } finally {
            System.out.println(1);
            return 34;
        }
    }

    public static int test13() {
        /* если в finally есть return, то он может уничтожить брошенное в try секции исключение */
        try {
            System.out.println(0);
            throw new RuntimeException();
        } finally {
            System.out.println(1);
            return 34;
        }
    }

    public static int test14() {
        /* если в finally есть throw, то он может уничтожить брошенный в try секции return */
        try {
            System.out.println(0);
            return 34;
        } finally {
            System.out.println(1);
            throw new RuntimeException();
        }
    }

    public static int test15() {
        /* если в finally есть throw, то он может уничтожить брошенный в try секции throw */
        try {
            System.out.println(0);
            throw new NullPointerException();
        } finally {
            System.out.println(1);
            throw new RuntimeException();
        }
    }

    public static void test16() {
        /* Зашли в catch, так как там  NullPointerException, зашли в finally, т.к. здесь мы должны
         побывать в любом случае. Продолжаем выполнять модуль до конца, т.к. исключение перехвачено */
        try {
            System.out.println(0);
            throw new NullPointerException();
        } catch (NullPointerException e) {
            System.out.println(1);
        } finally {
            System.out.println(2);
        }
        System.out.println(3);
    }

    public static void test17() {
        /* Зашли в catch, так как там  NullPointerException потомок RuntimeException, зашли в finally, т.к. здесь мы должны
         побывать в любом случае. Продолжаем выполнять модуль до конца, т.к. исключение перехвачено */
        try {
            System.out.println(0);
            throw new NullPointerException();
        } catch (RuntimeException e) {
            System.out.println(1);
        } finally {
            System.out.println(2);
        }
        System.out.println(3);
    }

    public static void test18() {
        /* Не зашли в catch, так как там  RuntimeException не потомок NullPointerException  , зашли в finally, т.к. здесь мы должны
         побывать в любом случае. По окончании try/catch прерываем выполнение метода и возвращаемся в main,
         т.к. исключение не перехвачено */
        try {
            System.out.println(0);
            throw new RuntimeException();
        } catch (NullPointerException e) {
            System.out.println(1);
        } finally {
            System.out.println(2);
        }
        System.out.println(3);
    }

    public static void test19() {
        /* Зашли в catch, так как там  NullPointerException но тут же бросили новое исключение,
        зашли в finally, т.к. здесь мы должны побывать в любом случае. По окончании try/catch
        прерываем выполнение метода и возвращаемся в main, т.к. исключение ArithmeticException
        не перехвачено */
        try {
            System.out.println(0);
            if (true)
                throw new NullPointerException();
        } catch (NullPointerException e) {
            System.out.println(1);
            throw new ArithmeticException();
        } finally {
            System.out.println(2);
        }
        System.out.println(3);
    }

    public static void test20() {
        /* Зашли в catch, так как там  NullPointerException,
        зашли в finally, т.к. здесь мы должны побывать в любом случае и бросили новое исключение.
        По окончании try/catch прерываем выполнение метода и возвращаемся в main, т.к. исключение
        ArithmeticException не перехвачено */
        try {
            System.out.println(0);
            if (true)
                throw new NullPointerException();
        } catch (NullPointerException e) {
            System.out.println(1);
        } finally {
            System.out.println(2);
            if (true) // вынуждены написать условие, т.к. в противном случае компилятор не пропустит последнюю строку
                throw new ArithmeticException();
        }
        System.out.println(3);
    }

    public static void test21() {
        /* Зашли в catch, так как там  NullPointerException но тут же бросили новое исключение ArithmeticException.
        У нас есть catch c ArithmeticException, но в него мы не попадаем, т.к. в одном catch мы уже
        побывали, а повторного захода в catch не предусмотрено, поэтому исключение продолжет лететь.
        Зашли в finally, т.к. здесь мы должны побывать в любом случае. По окончании try/catch
        прерываем выполнение метода и возвращаемся в main, т.к. исключение ArithmeticException
        не перехвачено */
        try {
            System.out.println(0);
            if (true)
                throw new NullPointerException();
        } catch (NullPointerException e) {
            System.out.println(1);
            throw new ArithmeticException();
        } catch (ArithmeticException e) {
            System.out.println(2);
        } finally {
            System.out.println(3);
        }
        System.out.println(4);
    }
}
