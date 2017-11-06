package Exceptions;

import java.io.IOException;

public class ExceptionNotSimpleLab {
    /* Необходимо подсчитать максимальное количество вариантов захода
    в try/catch/finally если коментарии заменяются(или не заменяются) на
     Error() или NullPointerException(), IOException(), RuntimeException() */
    public static void main(String[] args) {
        test1();
        try {test1_1();} catch (Throwable e) { }
        try {test2();} catch (Throwable e) { }
        try {test2_1();} catch (Throwable e) { }
        try {test3();} catch (Throwable e) { }
        try {test3_1();} catch (Throwable e) { }
        try {test3_2();} catch (Throwable e) { }
        try {test3_2_1();} catch (Throwable e) { }
        try {test4();} catch (Throwable e) { }
        try {test4_1();} catch (Throwable e) { }
        try {test4_2();} catch (Throwable e) { }
        try {test4_2_1();} catch (Throwable e) { }
        try {test5();} catch (Throwable e) { }
        try {test5_1();} catch (Throwable e) { }
        try {test5_2();} catch (Throwable e) { }
        try {test5_2_1();} catch (Throwable e) { }
    }

    public static void test5() {
        /* В try ставим IOException
        и не важно что будет в других catch
        */
        System.out.println();
        System.out.print(0);
        try {
            System.out.print(1);
            if (true) { throw new IOException();}
            System.out.print(2);
        } catch(NullPointerException e) {
            System.out.print(3);
            if (true) { /* */ }
            System.out.print(4);
        } catch(RuntimeException e) {
            System.out.print(5);
            if (true) { /* */ }
            System.out.print(6);
        } catch(Exception e) {
            System.out.print(7);
            if (true) { /* */ }
            System.out.print(8);
        } finally {
            System.out.print(9);
            if (true) { /* */ }
            System.out.print("a");
        }
        System.out.print("b");
    }

    public static void test5_1() throws IOException {
        /* В try ставим IOException
        и не важно что будет в других catch
        */
        System.out.println();
        System.out.print(0);
        try {
            System.out.print(1);
            if (true) { throw new IOException();}
            System.out.print(2);
        } catch(NullPointerException e) {
            System.out.print(3);
            if (true) { /* */ }
            System.out.print(4);
        } catch(RuntimeException e) {
            System.out.print(5);
            if (true) { /* */ }
            System.out.print(6);
        } catch(Exception e) {
            System.out.print(7);
            if (true) { /* */ }
            System.out.print(8);
        } finally {
            System.out.print(9);
            if (true) { throw new IOException(); }
            System.out.print("a");
        }
        System.out.print("b");
    }

    public static void test5_2() throws IOException {
        /* В try ставим IOException
        и не важно что будет в других catch
        */
        System.out.println();
        System.out.print(0);
        try {
            System.out.print(1);
            if (true) { throw new IOException();}
            System.out.print(2);
        } catch(NullPointerException e) {
            System.out.print(3);
            if (true) { /* */ }
            System.out.print(4);
        } catch(RuntimeException e) {
            System.out.print(5);
            if (true) { /* */ }
            System.out.print(6);
        } catch(Exception e) {
            System.out.print(7);
            if (true) { throw new IOException(); }
            System.out.print(8);
        } finally {
            System.out.print(9);
            if (true) { /* */ }
            System.out.print("a");
        }
        System.out.print("b");
    }

    public static void test5_2_1() throws IOException {
        /* В try ставим IOException
        и не важно что будет в других catch
        при любом исключении в finally
        */
        System.out.println();
        System.out.print(0);
        try {
            System.out.print(1);
            if (true) { throw new IOException();}
            System.out.print(2);
        } catch(NullPointerException e) {
            System.out.print(3);
            if (true) { /* */ }
            System.out.print(4);
        } catch(RuntimeException e) {
            System.out.print(5);
            if (true) { /* */ }
            System.out.print(6);
        } catch(Exception e) {
            System.out.print(7);
            if (true) { throw new IOException(); }
            System.out.print(8);
        } finally {
            System.out.print(9);
            if (true) { throw new IOException(); }
            System.out.print("a");
        }
        System.out.print("b");
    }

    public static void test4() {
        /* В try ставим RuntimeException
        и не важно что будет в других catch
        */
        System.out.println();
        System.out.print(0);
        try {
            System.out.print(1);
            if (true) { throw new RuntimeException();}
            System.out.print(2);
        } catch(NullPointerException e) {
            System.out.print(3);
            if (true) { /* */ }
            System.out.print(4);
        } catch(RuntimeException e) {
            System.out.print(5);
            if (true) { /* */ }
            System.out.print(6);
        } catch(Exception e) {
            System.out.print(7);
            if (true) { /* */ }
            System.out.print(8);
        } finally {
            System.out.print(9);
            if (true) { /* */ }
            System.out.print("a");
        }
        System.out.print("b");
    }

    public static void test4_1() {
        /* В try ставим RuntimeException
        и не важно что будет в других catch
        при любом исключении в finally
        */
        System.out.println();
        System.out.print(0);
        try {
            System.out.print(1);
            if (true) { throw new RuntimeException();}
            System.out.print(2);
        } catch(NullPointerException e) {
            System.out.print(3);
            if (true) { /* */ }
            System.out.print(4);
        } catch(RuntimeException e) {
            System.out.print(5);
            if (true) { /* */ }
            System.out.print(6);
        } catch(Exception e) {
            System.out.print(7);
            if (true) { /* */ }
            System.out.print(8);
        } finally {
            System.out.print(9);
            if (true) { throw new RuntimeException(); }
            System.out.print("a");
        }
        System.out.print("b");
    }

    public static void test4_2() {
        /* В try ставим RuntimeException
        в catch RuntimeException ставим еще одно исключение(любое)
        */
        System.out.println();
        System.out.print(0);
        try {
            System.out.print(1);
            if (true) { throw new RuntimeException();}
            System.out.print(2);
        } catch(NullPointerException e) {
            System.out.print(3);
            if (true) { /* */ }
            System.out.print(4);
        } catch(RuntimeException e) {
            System.out.print(5);
            if (true) { throw new RuntimeException(); }
            System.out.print(6);
        } catch(Exception e) {
            System.out.print(7);
            if (true) { /* */ }
            System.out.print(8);
        } finally {
            System.out.print(9);
            if (true) { /* */ }
            System.out.print("a");
        }
        System.out.print("b");
    }

    public static void test4_2_1() {
        /* В try ставим RuntimeException
        в catch RuntimeException ставим еще одно исключение(любое)
        при любом исключении в finally
        */
        System.out.println();
        System.out.print(0);
        try {
            System.out.print(1);
            if (true) { throw new RuntimeException();}
            System.out.print(2);
        } catch(NullPointerException e) {
            System.out.print(3);
            if (true) { /* */ }
            System.out.print(4);
        } catch(RuntimeException e) {
            System.out.print(5);
            if (true) { throw new RuntimeException(); }
            System.out.print(6);
        } catch(Exception e) {
            System.out.print(7);
            if (true) { /* */ }
            System.out.print(8);
        } finally {
            System.out.print(9);
            if (true) { throw new RuntimeException(); }
            System.out.print("a");
        }
        System.out.print("b");
    }

    public static void test3() {
        /* В try ставим NullPointerException
        и не важно что будет в других catch
        */
        System.out.println();
        System.out.print(0);
        try {
            System.out.print(1);
            if (true) { throw new NullPointerException();}
            System.out.print(2);
        } catch(NullPointerException e) {
            System.out.print(3);
            if (true) { /* */ }
            System.out.print(4);
        } catch(RuntimeException e) {
            System.out.print(5);
            if (true) { /* */ }
            System.out.print(6);
        } catch(Exception e) {
            System.out.print(7);
            if (true) { /* */ }
            System.out.print(8);
        } finally {
            System.out.print(9);
            if (true) { /* */ }
            System.out.print("a");
        }
        System.out.print("b");
    }

    public static void test3_1() {
        /* В try ставим NullPointerException
        и не важно что будет в других catch
        при любом исключении в finally
        */
        System.out.println();
        System.out.print(0);
        try {
            System.out.print(1);
            if (true) { throw new NullPointerException();}
            System.out.print(2);
        } catch(NullPointerException e) {
            System.out.print(3);
            if (true) { /* */ }
            System.out.print(4);
        } catch(RuntimeException e) {
            System.out.print(5);
            if (true) { /* */ }
            System.out.print(6);
        } catch(Exception e) {
            System.out.print(7);
            if (true) { /* */ }
            System.out.print(8);
        } finally {
            System.out.print(9);
            if (true) { throw new NullPointerException(); }
            System.out.print("a");
        }
        System.out.print("b");
    }

    public static void test3_2() {
        /* В try ставим NullPointerException
        в catch NullPointerException ставим еще одно исключение(любое)
        */
        System.out.println();
        System.out.print(0);
        try {
            System.out.print(1);
            if (true) { throw new NullPointerException();}
            System.out.print(2);
        } catch(NullPointerException e) {
            System.out.print(3);
            if (true) { throw new NullPointerException(); }
            System.out.print(4);
        } catch(RuntimeException e) {
            System.out.print(5);
            if (true) { /* */ }
            System.out.print(6);
        } catch(Exception e) {
            System.out.print(7);
            if (true) { /* */ }
            System.out.print(8);
        } finally {
            System.out.print(9);
            if (true) { /* */ }
            System.out.print("a");
        }
        System.out.print("b");
    }

    public static void test3_2_1() {
        /* В try ставим NullPointerException
        в catch NullPointerException ставим еще одно исключение(любое)
        при любом исключении в finally
        */
        System.out.println();
        System.out.print(0);
        try {
            System.out.print(1);
            if (true) { throw new NullPointerException();}
            System.out.print(2);
        } catch(NullPointerException e) {
            System.out.print(3);
            if (true) { throw new NullPointerException(); }
            System.out.print(4);
        } catch(RuntimeException e) {
            System.out.print(5);
            if (true) { /* */ }
            System.out.print(6);
        } catch(Exception e) {
            System.out.print(7);
            if (true) { /* */ }
            System.out.print(8);
        } finally {
            System.out.print(9);
            if (true) { throw new NullPointerException(); }
            System.out.print("a");
        }
        System.out.print("b");
    }

    public static void test2() {
        /* В try ставим Error
        и не важно что будет в catch
        */
        System.out.println();
        System.out.print(0);
        try {
            System.out.print(1);
            if (true) { throw new Error();}
            System.out.print(2);
        } catch(NullPointerException e) {
            System.out.print(3);
            if (true) { /* */ }
            System.out.print(4);
        } catch(RuntimeException e) {
            System.out.print(5);
            if (true) { /* */ }
            System.out.print(6);
        } catch(Exception e) {
            System.out.print(7);
            if (true) { /* */ }
            System.out.print(8);
        } finally {
            System.out.print(9);
            if (true) { /* */ }
            System.out.print("a");
        }
        System.out.print("b");
    }

    public static void test2_1() {
        /* В try ставим Error
        и не важно что будет в catch
        при любом исключении в finally
        */
        System.out.println();
        System.out.print(0);
        try {
            System.out.print(1);
            if (true) { throw new Error();}
            System.out.print(2);
        } catch(NullPointerException e) {
            System.out.print(3);
            if (true) { /* */ }
            System.out.print(4);
        } catch(RuntimeException e) {
            System.out.print(5);
            if (true) { /* */ }
            System.out.print(6);
        } catch(Exception e) {
            System.out.print(7);
            if (true) { /* */ }
            System.out.print(8);
        } finally {
            System.out.print(9);
            if (true) { throw new Error(); }
            System.out.print("a");
        }
        System.out.print("b");
    }

    public static void test1() {
        /* ничего не меняем в try
        и не важно что будет в catch
        */
        System.out.println();
        System.out.print(0);
        try {
            System.out.print(1);
            if (true) { /* */ }
            System.out.print(2);
        } catch(NullPointerException e) {
            System.out.print(3);
            if (true) { /* */ }
            System.out.print(4);
        } catch(RuntimeException e) {
            System.out.print(5);
            if (true) { /* */ }
            System.out.print(6);
        } catch(Exception e) {
            System.out.print(7);
            if (true) { /* */ }
            System.out.print(8);
        } finally {
            System.out.print(9);
            if (true) { /* */ }
            System.out.print("a");
        }
        System.out.print("b");
    }

    public static void test1_1() {
        /* ничего не меняем в try
        и не важно что будет в catch
        при любом исключении в finally */
        System.out.println();
        System.out.print(0);
        try {
            System.out.print(1);
            if (true) { /* */ }
            System.out.print(2);
        } catch(NullPointerException e) {
            System.out.print(3);
            if (true) { /* */ }
            System.out.print(4);
        } catch(RuntimeException e) {
            System.out.print(5);
            if (true) { /* */ }
            System.out.print(6);
        } catch(Exception e) {
            System.out.print(7);
            if (true) { /* */ }
            System.out.print(8);
        } finally {
            System.out.print(9);
            if (true) { throw new RuntimeException(); }
            System.out.print("a");
        }
        System.out.print("b");
    }
}
