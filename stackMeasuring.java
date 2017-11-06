public class stackMeasuring {
    /* Количество запущеных методов до переполнения стека*/
    static int counter0=0,counter9=0;
    public static void main(String[] args) {
        try {
            test0();
        } catch (StackOverflowError Ignore) {}
        System.out.println("Количество пустых методов "+counter0);
        try {
            test9();
        } catch (StackOverflowError Ignore) {}
        System.out.println("Количество методов с 9-тью переменными "+counter9);
    }
    public static void test0() {
        counter0++;
        test0();
    }
    public static void test9() {
        long l1=0; long l2=0, longl3=0;
        long l4=0; long l5=0, longl6=0;
        long l7=0; long l8=0, longl9=0;
        counter9++;
        test9();
    }
}
