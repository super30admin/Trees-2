/*

Problem2 (https://leetcode.com/problems/sum-root-to-leaf-numbers/)

 
Time Complexity : O(n)
Space Complexity : O(h)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : NA


 */

 class Solution {
    public int sumNumbers(TreeNode root) {
        
        if(root == null){
            return 0;
        }

        return inorder(root, 0);
    }

    private int inorder(TreeNode root, int sum){

        if(root == null){
            return 0;
        }

        if(root.left == null && root.right == null){
            return sum * 10 + root.val;
        }

        int case1 = inorder(root.left, sum * 10 + root.val);
        int case2 = inorder(root.right, sum * 10 + root.val);

        return case1 + case2;

    }
}