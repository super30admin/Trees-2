//Definition for a binary tree node.
public class SumRootLeaf {
    public int sumNumbers(TreeNode root) {
        return sumNodes(root, 0);
    }

    private int sumNodes(TreeNode root, int currentSum) {
        if (root == null) return 0;
        currentSum = currentSum * 10 + root.val;
        if (root.left == null && root.right == null) return currentSum;
        int leftSum = sumNodes(root.left, currentSum);
        int rightSum = sumNodes(root.right, currentSum);
        return leftSum + rightSum;
    }
    public static void main(String[] args){
        SumRootLeaf s = new SumRootLeaf();
        TreeNode root;
        root = new TreeNode(6);
        root.left = new TreeNode(3);
        root.right = new TreeNode(5);
//        root.right.right = new TreeNode(4);
//        root.left.left = new TreeNode(2);
//        root.left.right = new TreeNode(5);
//        root.left.right.right = new TreeNode(4);
//        root.left.right.left = new TreeNode(7);
        System.out.print("Sum is :"+s.sumNumbers(root));

    }
}
