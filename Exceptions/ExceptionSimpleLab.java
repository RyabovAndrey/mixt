package Exceptions;

public class ExceptionSimpleLab {
    /* Необходимо подсчитать максимальное количество вариантов захода
    в try/catch/finally если коментарии заменяются(или не заменяются) на
     Error() или NullPointerException() */
    public static void main(String[] args) {
        test1();
        try {test1_1();} catch (Throwable e) { }
        test2();
        try {test2_1();} catch (Throwable e) { }
        try {test2_2();} catch (Throwable e) { }
        try {test3();} catch (Throwable e) { }
        try {test3_1();} catch (Throwable e) { }
        /* итого семь вариантов */
    }
    public static void test1() {
        /* ничего не меняем в try
        и не важно что будет в catch
        */
        System.out.println();
        System.out.print(0);
        try {
            System.out.print(1);
            if (true) {
                /* */
            }
            System.out.print(2);
        } catch(RuntimeException e) {
            System.out.print(3);
            if (true) {
                /* */
            }
            System.out.print(4);
        } finally {
            System.out.print(5);
            if (true) {
                /* */
            }
            System.out.print(6);
        }
        System.out.print(7);
    }

    public static void test1_1() {
        /* ничего не меняем в try
        и не важно что будет в catch
        в finally не важно Error или NullPointerException
        */
        System.out.println();
        System.out.print(0);
        try {
            System.out.print(1);
            if (true) {
                /* */
            }
            System.out.print(2);
        } catch(RuntimeException e) {
            System.out.print(3);
            if (true) {
                /* */
            }
            System.out.print(4);
        } finally {
            System.out.print(5);
            if (true) {
                throw new Error();
            }
            System.out.print(6);
        }
        System.out.print(7);
    }

    public static void test2() {
        /* в try поставили  NullPointerException */
        System.out.println();
        System.out.print(0);
        try {
            System.out.print(1);
            if (true) {
                throw new NullPointerException();
            }
            System.out.print(2);
        } catch(RuntimeException e) {
            System.out.print(3);
            if (true) {
                /* */
            }
            System.out.print(4);
        } finally {
            System.out.print(5);
            if (true) {
                /* */
            }
            System.out.print(6);
        }
        System.out.print(7);
    }

    public static void test2_1() {
        /* в try поставили  NullPointerException
        и не важно что будет в catch
        */
        System.out.println();
        System.out.print(0);
        try {
            System.out.print(1);
            if (true) {
                throw new NullPointerException();
            }
            System.out.print(2);
        } catch(RuntimeException e) {
            System.out.print(3);
            if (true) {
                throw new Error();
            }
            System.out.print(4);
        } finally {
            System.out.print(5);
            if (true) {
                /* */
            }
            System.out.print(6);
        }
        System.out.print(7);
    }

    public static void test2_2() {
        /* в try поставили  NullPointerException
        и не важно что будет в catch
        не важно что в finally
        */
        System.out.println();
        System.out.print(0);
        try {
            System.out.print(1);
            if (true) {
                throw new NullPointerException();
            }
            System.out.print(2);
        } catch(RuntimeException e) {
            System.out.print(3);
            if (true) {
                throw new Error();
            }
            System.out.print(4);
        } finally {
            System.out.print(5);
            if (true) {
                throw new NullPointerException();
            }
            System.out.print(6);
        }
        System.out.print(7);
    }

    public static void test3() {
        /* в try поставили Error
        не важно что в catch
        */
        System.out.println();
        System.out.print(0);
        try {
            System.out.print(1);
            if (true) {
                throw new Error();
            }
            System.out.print(2);
        } catch(RuntimeException e) {
            System.out.print(3);
            if (true) {
                /* */
            }
            System.out.print(4);
        } finally {
            System.out.print(5);
            if (true) {
                /* */
            }
            System.out.print(6);
        }
        System.out.print(7);
    }
    public static void test3_1() {
        /* в try поставили Error
        не важно что в catch
        */
        System.out.println();
        System.out.print(0);
        try {
            System.out.print(1);
            if (true) {
                throw new Error();
            }
            System.out.print(2);
        } catch(RuntimeException e) {
            System.out.print(3);
            if (true) {
                /* */
            }
            System.out.print(4);
        } finally {
            System.out.print(5);
            if (true) {
                throw new Error();
            }
            System.out.print(6);
        }
        System.out.print(7);
    }
}
