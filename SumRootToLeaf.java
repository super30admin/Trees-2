//Time Complexity: O(n)
//Space Complexity: O(1)
// Did this code successfully run on Leetcode :Yes
public class SumRootToLeaf {

    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }

    private int helper(TreeNode root, int current) {
        if (root == null) return 0;

        current = current * 10 + root.val;
        int left = helper(root.left, current);

        if (root.left == null && root.right == null) return current;

        int right = helper(root.right, current);
        return left + right;
    }

    public static void main(String[] args) {
        final TreeNode root = new TreeNode(4, new TreeNode(9, new TreeNode(5), new TreeNode(1, null, new TreeNode(2))), new TreeNode(0));

        final SumRootToLeaf sumRootToLeaf = new SumRootToLeaf();
        System.out.println(sumRootToLeaf.sumNumbers(root)); //return 5447
    }
}
