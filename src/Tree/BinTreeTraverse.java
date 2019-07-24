package Tree;

import java.util.Scanner;

public class BinTreeTraverse {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeNode root = createTree(sc);
        preOrder(root);
        System.out.println();
        inOrder(root);
        System.out.println();
        postOrder(root);
    }

    public static TreeNode createTree(Scanner scanner) {
        int val = scanner.nextInt();
        if (val == 0) {
            return null;
        }
        TreeNode treeNode = new TreeNode(val,createTree(scanner),createTree(scanner));
        return treeNode;
    }



    //前序遍历
    public static void preOrder(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }

        System.out.println(treeNode);

        preOrder(treeNode.left);
        preOrder(treeNode.right);
    }

    //中序遍历
    public static void inOrder(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        inOrder(treeNode.left);
        System.out.println(treeNode);
        inOrder(treeNode.right);
    }

    //后序遍历
    public static void postOrder(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        postOrder(treeNode.left);
        postOrder(treeNode.right);
        System.out.println(treeNode);
    }
}
