// Executed
// Approach - 1
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int sumNumbers(TreeNode root) {
        if (root == null)
            return 0;
        return dfs(root, 0);
    }
    
    private int dfs(TreeNode root, int nums) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return nums * 10 + root.val;
        int case1 = dfs(root.left, nums * 10 + root.val);
        int case2 = dfs(root.right, nums * 10 + root.val);
        return case1 + case2;
    }
}

// Approach - 2 using stacks
class Solution {
    public int sumNumbers(TreeNode root) {
        if (root == null)
            return 0;
        int sum = 0;
        int num = 0;
        Stack<TreeNode> s = new Stack<>();
        Stack<Integer> nums = new Stack<>();
        while (root != null || !s.isEmpty()) {
            while(root != null) {
                s.push(root);
                num = num * 10 + root.val;
                nums.push(num);
                root = root.left;
            }
            root = s.pop();
            num = nums.pop();
            while (root.left == null && root.right == null) {
                sum = sum + num;
            }
            root = root.right;
        }
        return sum;
    }
}
// Time limit exceed