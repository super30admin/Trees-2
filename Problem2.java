/*
Total sum of paths from root to leaf
time: O(n)
space: O(1)
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class Problem2 {
    static int maxSum = 0;
    static int sumNumbers(TreeNode root) {
        helper(root, 0);
        return maxSum;
    }

    static void helper(TreeNode root, int sum) {
        if(root!=null)
            sum = (sum*10)+root.val;
        if(root!=null && root.left==null && root.right==null) {maxSum+=sum;return;}
        if(root.left!=null)helper(root.left, sum);
        if(root.right!=null)helper(root.right, sum);
    }
    public static void main(String []args) {
        TreeNode node = new TreeNode(2);
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(3);
        node.left = left;
        node.right=right;
        sumNumbers(node);
    }
}
