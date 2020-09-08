// Time Complexity : o(n) where n all the nodes in the binary tree
// Space Complexity : o(h) h is the height of the binary tree 
// Did this code successfully run on Leetcode : yes
// Three line explanation of solution in plain english
    /* Do a DFS and keep concatinating the digits as you traverse till the leaf node. Get all such numbers from root to leaf and add them together.
    Two variables, number and sum. Number to concatinate the values as we traverse to the leaf node and sum to add all such numbers together.
    Divide the problem into left and right subtree and apply recursion.

*/
// Your code here along with comments explaining your approach



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
        if(root == null){
            return 0;
        } 
        //call to the function to get the sum with initial num and sum value as 0.
        return sum(root, 0,0);
        
    }

    public int sum(TreeNode node, int num, int ans){
        //if the node is null, then simply return the ans containing the sum
        if(node == null){
            return ans;
        }
        //concatinate the digit at each node
        num = num*10 + node.val;
        //if it is the keaf node, add the number to the ans
        if(node.left==null && node.right==null){
            ans = ans+num;
        }
        //recursive call to the right subtree with the num formed from the root and ans obtained from the root.
        int leftSum = sum(node.left, num, ans);
        //recursive call to the right subtree with the num formed from the root and ans obtained from the left subtree.
        int rightSum = sum(node.right, num, leftSum);
        
        return rightSum;
    } 
}