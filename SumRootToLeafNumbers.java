// Time complexity : O(n)
// Space complexity :O(h)
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class SumRootToLeafNumbers {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(9);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(1);
        root.right = new TreeNode(0);
        int result = sumNumbers(root);
        System.out.println(result);
    }

    static int sum = 0;

    private static int sumNumbers(TreeNode root) {
        helper(root, 0);
        return sum;
    }

    private static void helper(TreeNode root, int currSum) {
        if (root == null)
            return;
        currSum = currSum * 10 + root.val;
        if (root.left == null && root.right == null) {
            sum += currSum;
        }
        helper(root.left, currSum);
        helper(root.right, currSum);
    }

}
