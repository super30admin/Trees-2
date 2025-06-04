//Problem 129 : Sum Root to Leaf NUmbers
//solved successfully on leetcode n faced no isses
//TC:O(n) SC:O(n)


class Solution {
    public int sumNumbers(TreeNode root) {
        return rtl(root , 0);
        
    }
    private int rtl(TreeNode root , int currentsum){
        if(root == null){
            return 0;
        }
       currentsum = currentsum * 10 + root.val;


        if(root.left == null && root.right == null){ //we found the leaf
            return currentsum ;
        }

        int left = rtl(root.left , currentsum);
        int right = rtl(root.right , currentsum);
        return left+right;
    }
}