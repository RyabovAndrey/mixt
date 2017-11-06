public class recursionTest {
    public static void main(String[] args) {
        Node tail=null;
        for (int i = 0; i <5 ; i++) {
            tail=new Node(5-i,tail);
        }
        f(tail);
    }
    public static void f(Node ref) {
        spaces(ref.value);
        System.out.println("1");
        spaces(ref.value);
        System.out.println("2");
        spaces(ref.value);
        System.out.println("Зашли в f");
        if (ref.next!=null) {
           f(ref.next);
        }
        spaces(ref.value);
        System.out.println("Зашли в f повторно");
        spaces(ref.value);
        System.out.println("3");
        spaces(ref.value);
        System.out.println("4");
    }
    public static void spaces(int i) {
        for (int j = 0; j <i ; j++) {
            System.out.print(" ");
        }
    }
}
