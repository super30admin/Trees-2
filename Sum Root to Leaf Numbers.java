#Time Comlexity= O(n)
#Space Complexity=O(h)
class Solution {

    //with return approach
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int num) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return num * 10 + root.val;
        }
        int case1 = dfs(root.left, num * 10 + root.val);
        int case2 = dfs(root.right, num * 10 + root.val);
        return case1 + case2;
    }
}