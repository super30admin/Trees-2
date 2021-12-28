// Time Complexity :O(N)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


class Solution {

    public int sumNumbers(TreeNode root) {
        return sum(root, 0);
    }

    public int sum(TreeNode n, int s){
        if (n == null) {
            return 0;
        }
        if (n.right == null && n.left == null){
            return s*10 + n.val;
        }
        return sum(n.left, s*10 + n.val) + sum(n.right, s*10 + n.val);

    }

}