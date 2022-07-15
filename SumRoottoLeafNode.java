//Time Complexity:O(n)
//Space Complexity:O(h)
//Intuit Interview
//Here we will be moving from the root to the leaf node and keep on adding the new digits in the number and in the end we will be returning the sum of all the numbers which we have got till now.

//Now the question is how to find all the numbers starting from root to leaf ; so for that what we will do we will start from root value its going to be the first digit then for left child we will call the same function with root as left child and  the value which will be passed to it will be the product of the current value with 10 + the current node's value , similarly we will be doing for the right tree as well and we will keep on doing this till the time we have not reached the leaf node and while coming back from the called functions we will be adding all the values which we have got and finally we can return the resultant answer.
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
        if(root == null) return 0;
        return helper(root,0);
    }
    private int helper(TreeNode root,int num){
        //base
        if(root == null) return 0;
        //check if you are on a left node
        if(root.left == null && root.right == null){
            return num*10+root.val;
        }
        int case1 = helper(root.left,num*10+root.val);
        int case2 = helper(root.right,num*10+root.val);
        return case1+case2;
    }
}