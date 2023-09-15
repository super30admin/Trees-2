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
      int result = 0;
    public int sumNumbers(TreeNode root) {
         Helper(root, 0, 0);
         return result;
    }
    private void Helper (TreeNode root, int prev, int curr){
      
        if(root == null) return;
        curr = prev * 10;
        prev =  root.val + curr;

        Helper(root.left, prev, curr);

        Helper(root.right, prev, curr);
        if(root.left == null && root.right == null) {
          result = result + prev;
        }
         
    }
}










class Solution {
    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }

    private int helper (TreeNode root, int currNum){
        //base

        if(root == null) return 0;

        currNum = currNum*10 + root.val;
        int left = helper(root.left, currNum);
        if(root.left == null && root.right == null){
            return currNum;
        }
        int right = helper(root.right, currNum);
        return left + right;
    }
}


/**

TC : O(N)

SC : O(H)

Description : Creating a method with return type as int and returning its "CurrNum" wherever there is a leaf node. If we get CurrNum from both sides then adding and retuning retunrng  
both.

 */