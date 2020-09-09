// Time Complexity : O(N) as we will have to visit each node.
// Space Complexity : O(1) as we are not using any auxillary space.
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : Not really.

public class SumRootToLeaf {
    /* Definition for a binary tree node.*/
    public class TreeNode {
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

    int sum;
    public int sumNumbers(TreeNode root) {
        if(root == null) {
            return 0;
        }

        sum = 0;
        findSum(root, 0);

        return sum;
    }
    
    void findSum(TreeNode root, int sumSoFar) {
        if(root.left == null && root.right == null) {
            sum += sumSoFar + root.val;
            return;
        }
        
        if(root.left != null) {
            findSum(root.left, sumSoFar*10 + root.val*10);
        }
        
        if(root.right != null) {
            findSum(root.right, sumSoFar*10 + root.val*10);
        }
        
        return;
    }
}

