public class recursion {
    /* Иллюстрация нахождения дважды в области видимости функции при рекурсии*/
    private static final int j=15;
    private static int depth=0;

    public static void main(String[] args) {

        f1(1);
        System.out.println();
        System.out.println();
        f(1);
    }

    public static void f1(int i) {
        System.out.print(" "+i);
        if (i<j) f1(2*i);
        else System.out.println();
        System.out.print(" "+i);
    }

    public static void f(int i) {
        in(i);
        if (check(i)) f(2*i);
        out(i);
    }

    public static boolean check(int x) {
       spaces();
        System.out.println("x<"+j+": "+(x<j));
       return x<j;
    }

    public static void in(int x) {
        spaces();
        System.out.println("("+x+")->");
        depth++;
    }

    public static void out(int x) {
        depth--;
        spaces();
        System.out.println("<-("+x+")");

    }
    private static void spaces() {
        for (int i = 0; i <depth ; i++) {
            System.out.print(" ");
        }
    }
}
