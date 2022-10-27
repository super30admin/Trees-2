// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no

public class SumRtoL {
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
        public int sumNumbers(TreeNode root) {
            return dfs(root, 0);
        }

        public int dfs(TreeNode curr, int sum){
            if(curr == null) return 0;

            sum = sum*10 + curr.val;

            if(curr.left == null && curr.right == null) return sum;

            return dfs(curr.left, sum) + dfs(curr.right, sum);
        }
    }