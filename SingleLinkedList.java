public class SingleLinkedList {

    public static void main(String[] args) {
        Node tail=null;
        for (int i = 0; i <10 ; i++) {
            tail=new Node((int)(Math.random()*10),tail);
        }
        System.out.println(toStringIter(tail));
        System.out.println(toStringRec(tail));
        System.out.println(size(tail));
        System.out.println(sum(tail));
        System.out.println(max(tail));
        System.out.println(sizeR(tail));
        System.out.println(sumR(tail));
        System.out.println(maxR(tail));
        System.out.println(toStringIter(add(tail,12)));
        System.out.println(toStringIter(remove(tail)));
        System.out.println(toStringIter(add(tail,3,12)));
        System.out.println(toStringIter(remove(tail,3)));
    }

    public static String toStringIter(Node ref) {
        String result="";
        while (ref!=null) {
            result +="("+ref.value+")->";
            ref=ref.next;
        }
        result+="null";
        return result;
    }
    public static String toStringRec(Node ref) {
        if (ref==null)
            return "null";
        else
            return "("+ref.value+")->"+toStringRec(ref.next);
    }

    public static int size (Node ref) {
        int result=1;
        while (ref.next!=null) {
            result++;
            ref=ref.next;
        }
        return result;
    }

    public static int sum (Node ref) {
        int result=0;
        while (ref.next!=null) {
            result+=ref.value;
            ref=ref.next;
        }
        result+=ref.value;
        return result;
    }
    public static int max (Node ref) {
        int result=Integer.MIN_VALUE;
        while (ref.next!=null) {
            result=Math.max(result,ref.value);
            ref=ref.next;
        }
        result=Math.max(result,ref.value);
        return result;
    }
    public static int sizeR(Node ref) {
        int result=1;
        if (ref.next==null)
            return result;
        else
            return result+=sizeR(ref.next);

    }
    public static int sumR(Node ref) {
        int result=ref.value;
        if (ref.next==null)
            return result;
        else
            return result+=sumR(ref.next);

    }
    public static int maxR(Node ref) {
        int m=Integer.MIN_VALUE;
        if (ref.next==null)
            return Math.max(m,ref.value);
        else
            return Math.max(ref.value,maxR(ref.next));

    }
    public static Node add(Node ref,int value) {
        Node first=ref;
        while (ref.next!=null) {
            ref=ref.next;
        }
        ref.next=new Node(value,null);
        return first;
    }
    public static Node remove(Node ref) {
        Node first=ref;
        Node last=ref;
        while (ref.next!=null) {
            last=ref;
            ref=ref.next;
        }
        ref=last;
        ref.next=null;
        return first;
    }
    public static Node add(Node ref,int position, int value) {
        int m=0;
        Node first=ref;
        Node last=ref;
        while (m<position) {
            last=ref;
            ref=ref.next;
            m++;
        }

        last.next=new Node(value,ref);
        return first;
    }
    public static Node remove(Node ref,int position) {
        int m=0;
        Node first=ref;
        Node last=ref;
        while (m<position) {
            last=ref;
            ref=ref.next;
            m++;
        }
        last.next=ref.next;
        return first;
    }
}
