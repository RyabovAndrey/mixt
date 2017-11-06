public class FibonacciQuiz {
    private static int depth=0;
    /* Числа Фибоначчи. Значение функции от 0 - 0. Значение от 1 - 1.
     При всех значениях аргумента больше 1 - сумма двух предыдущих значений функции */
    public static void main(String[] args) {
        System.out.println("Комбинаторный взрыв");
        f(5);
        System.out.println();
        System.out.println("То же самое с использованием тернарного условного оператора");
        f1(5);
        System.out.println();
        System.out.println("Формирование дерева в обратном порядке");
        f6(5);
        System.out.println();
        System.out.println("Зеркальное отражение по оси Y");
        f2(5);
        System.out.println();
        System.out.println("Иллюстрация прохода по дереву");
        f3(5);
        System.out.println();
        System.out.println("Фибоначчи с вращением");
        f4(5);
        System.out.println();
        System.out.println("Фибоначчи с вращением 2");
        f5(5);
        System.out.println();
        System.out.println("Формируем выражение по вычислению функции Фибоначчи");
        System.out.print("f(5)==");
        f7(5);

    }
    public static int f(int x) {
        System.out.print(" "+x);
        if (x==0) return 0;
        else if (x==1) return 1;
        else return f(x-2)+f(x-1);
    }

    public static int f1(int x) {
        /* Тернарный условный оператор */
        System.out.print(" "+x);
         return (x<2)? x:f1(x-2)+f1(x-1);
    }

    public static int f2(int x) {
        /* При перемене мест слагаемых дерево отображается зеркально */
        System.out.print(" "+x);
        return (x<2)? x:f2(x-1)+f2(x-2);
    }

    public static int f3(int x) {
        /* Иллюстрация прохода по дереву */
        in(x);
        int result=(x<2)? x:f3(x-2)+f3(x-1);
        out(x);
        return result;
    }

    public static int f4(int x) {
        /* Модификация предыдущей функции, но с изменением прохода по дереву
        в зависимости от четности аргумента.(Фибоначчи с вращением)
         */
        System.out.print(" "+x);
        if (x==0) return 0;
        else if (x==1) return 1;
        else {
            if (x%2==0) return f4(x-2)+f4(x-1);
            else return f4(x-1)+f4(x-2);
        }
    }

    public static int f5(int x) {
        /* (Фибоначчи с вращением 2)
         */
        int result;
        if (x==0) result= 0;
        else if (x==1) result= 1;
        else {
            if (x%2==0) result= f4(x-2)+f4(x-1);
            else result= f5(x-1)+f5(x-2);
        }
        System.out.print(" "+x);
        return result;
    }

    public static int f6(int x) {
        /* Формирование дерева в обратном порядке */
        int result;
        result= (x<2)? x:f6(x-2)+f6(x-1);
        System.out.print(" "+x);
        return result;
    }

    public static int f7(int x) {
        /* Иллюстрация формирования выражения по вычислению функции Фибоначчи */
        if (x<2) return abc(x);
        else return a(x)+f7(x-2)+b(x)+f7(x-1)+c(x);
    }

    public static int abc(int x) {
        System.out.print(x);
        return x;
    }

    public static int a(int x) {
        System.out.print("(");
        return 0;
    }

    public static int b(int x) {
        System.out.print("+");
        return 0;
    }

    public static int c(int x) {
        System.out.print(")");
        return 0;
    }

    public static void in(int x) {
        spaces();
        System.out.println("("+x+")->");
        depth++;
    }

    public static void out(int x) {
        depth--;
    }
    private static void spaces() {
        for (int i = 0; i <depth ; i++) {
            System.out.print(" ");
        }
    }
}
