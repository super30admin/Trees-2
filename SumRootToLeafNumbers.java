
/**
 Time Complexity: O(n)

Space Complexity: O(h)
 */

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class SumRootToLeafNumbers {
    int ans = 0;

    public int sumNumbers(TreeNode root) {
        helper(root, 0);
        return ans;
    }

    void helper(TreeNode root, int sum) {
        if (root == null) {
            return;
        }

        sum = sum * 10 + root.val;

        //below to check if node is leaf then add in sum
        if (root.left == null && root.right == null) {
            ans = ans + sum;
        }

        helper(root.left, sum);
        helper(root.right, sum);
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        SumRootToLeafNumbers sol = new SumRootToLeafNumbers();
        int result = sol.sumNumbers(root);
        System.out.println("Sum of root-to-leaf numbers: " + result); // Output: 25
    }
}
