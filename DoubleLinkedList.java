public class DoubleLinkedList {

    public static void main(String[] args) {
        TreeNode dNode1=new TreeNode(1,null,null);
        TreeNode dNode2=new TreeNode(2,null,null);
        dNode1.right=dNode2;
        dNode2.left=dNode1;
        TreeNode dNode3=new TreeNode(3,null,null);
        dNode2.right=dNode3;
        dNode3.left=dNode2;
        TreeNode dNode4=new TreeNode(4,null,null);
        dNode3.right=dNode4;
        dNode4.left=dNode3;
        TreeNode dNode5=new TreeNode(5,null,null);
        dNode4.right=dNode5;
        dNode5.left=dNode4;
        TreeNode dNode6=new TreeNode(6,null,null);
        dNode5.right=dNode6;
        dNode6.left=dNode5;
        System.out.println(toStringRecFirst(dNode1));
        System.out.println(toStringRecLast(dNode6));
        System.out.println(toStringRecFirst(add(dNode1,7)));
        System.out.println(toStringRecFirst(remove(dNode1)));
        System.out.println(toStringRecFirst(add(dNode1,3,7)));
        System.out.println(toStringRecLast(dNode6));
        System.out.println(toStringRecFirst(remove(dNode1,3)));
        System.out.println(toStringRecLast(dNode6));
    }
    public static String toStringRecFirst(TreeNode ref) {
        if (ref==null)
            return "null";
        else
            return "("+ref.value+")->"+toStringRecFirst(ref.right);
    }

    public static String toStringRecLast(TreeNode ref) {
        if (ref==null)
            return "null";
        else
            return "("+ref.value+")->"+toStringRecLast(ref.left);
    }
    public static TreeNode add(TreeNode ref,int value) {
        TreeNode first=ref;
        while (ref.right!=null) {
            ref=ref.right;
        }
        ref.right=new TreeNode(value,ref,null);
        return first;
    }
    public static TreeNode remove(TreeNode ref ) {
        TreeNode first=ref;
        TreeNode last=ref;
        while (ref.right!=null) {
            ref=ref.right;
        }
        ref.left.right=null;
        return first;
    }
    public static TreeNode add(TreeNode ref,int position,int value) {
        int m=0;
        TreeNode first=ref;
        while (m<position) {
            ref=ref.right;
            m++;
        }
        TreeNode temp=ref.left;
        ref.left=new TreeNode(value,temp,ref);
        temp.right=ref.left;
        return first;
    }
    public static TreeNode remove(TreeNode ref, int position ) {
        int m=0;
        TreeNode first=ref;
        TreeNode last=ref;
        while (m<position) {
            ref=ref.right;
            m++;
        }
        ref.left.right=ref.right;
        ref.right.left=ref.left;
        return first;
    }
}
