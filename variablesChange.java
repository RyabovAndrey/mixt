public class variablesChange {
    public static void main(String[] args) {
        int a=5;
        int b=3;
        int temp;
        System.out.println("a="+a+"   b="+b);
        //Обмен значениями переменных С использованием временной переменной
        temp=a;
        a=b;
        b=temp;
        System.out.println("Обмен значениями переменных С использованием временной переменной");
        System.out.println("a="+a+"   b="+b);
        //Обмен значениями переменных БЕЗ использованием временной переменной сложение/вычитание
        a=a+b;
        b=a-b;
        a=a-b;
        System.out.println("Обмен значениями переменных БЕЗ использования временной переменной(сложение/вычитание)");
        System.out.println("a="+a+"   b="+b);
        //Обмен значениями переменных БЕЗ использованием временной переменной умножение/деление
        a=a*b;
        b=a/b;
        a=a/b;
        System.out.println("Обмен значениями переменных БЕЗ использования временной переменной(умножение/деление)");
        System.out.println("a="+a+"   b="+b);

    }
}