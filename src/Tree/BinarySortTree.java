package Tree;

/**
 * 二叉排序树
 */
public class BinarySortTree {
    int val;
    BinarySortTree left;
    BinarySortTree right;

    BinarySortTree(int val) {
        this(val, null, null);
    }

    BinarySortTree() {

    }

    public BinarySortTree(int val, BinarySortTree left, BinarySortTree right) {
        super();
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public void add(BinarySortTree node) {
        if (node == null) {
            return;
        }
        if (node.val < this.val) {
            //如果左节点为空
            if (this.left == null) {
                this.left = node;
            } else {
                this.left.add(node);
            }
        } else {
            if (this.right == null) {
                this.right = node;
            } else {
                this.right.add(node);
            }
        }
    }
}

