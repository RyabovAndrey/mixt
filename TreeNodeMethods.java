public class TreeNodeMethods {
    private static int value=0;
    private static int left=0,maxHeight=0,height=0;


    public static void main(String[] args) {
        TreeNode treeNode=new TreeNode(1,null,null);
        initTree(treeNode);
        toString(treeNode);
        System.out.println();
        System.out.println("Количество вершин");
        System.out.println(countRoots(treeNode));
        System.out.println("Максимальное значение в дереве");
        System.out.println(maxValue(treeNode));
        System.out.println("Глубина дерева");
        System.out.println(heightValue(treeNode));
    }

    public static int heightValue (TreeNode tree) {
        height++;
        if (tree.left!=null)
            heightValue(tree.left);
        if (tree.right!=null)
            heightValue(tree.right);
        maxHeight=Math.max(maxHeight,height);
        height--;
        return maxHeight;
    }

    public static int maxValue (TreeNode tree) {
        if (tree.right!=null)
                value = Math.max(maxValue(tree.right), tree.value);
            else
                value=Math.max(value,tree.value);

        if (tree.left!=null)
            value = Math.max(maxValue(tree.left), tree.value);
        else
            value=Math.max(value,tree.value);

        return value;
    }

    public static int countRoots (TreeNode tree) {
        int result=1;
        if (tree.right!=null) {
            result+=countRoots(tree.right);
        }
        if (tree.left!=null) {
            result+=countRoots(tree.left);
        }
        return result;
    }

    public static void toString(TreeNode tree) {
        System.out.print(" "+tree.value);
        if (tree.left!=null) {
            toString(tree.left);
        }
        if (tree.right!=null) {
            toString(tree.right);
        }
    }

    public static TreeNode initTree(TreeNode tree) {
        tree.left=new TreeNode(2,new TreeNode(13,new TreeNode(10,null,new TreeNode(11,null,new TreeNode(12,null,null))),null),new TreeNode(19,null,null));
        tree.right=new TreeNode(14,new TreeNode(5,new TreeNode(17,null,null),new TreeNode(8,null,null)),new TreeNode(6,null,null));
        return tree;
    }
    public static TreeNode initTreeShort(TreeNode tree) {
        tree.left=new TreeNode(2,new TreeNode(13,null,null),new TreeNode(9,null,null));
        tree.right=new TreeNode(4,new TreeNode(15,null,null),new TreeNode(26,null,null));
        return tree;
    }
}
