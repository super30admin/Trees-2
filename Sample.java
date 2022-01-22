// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//we can do this problem with in,pre& post order traversal as in any of the condition we are going to hit our leaf node condition
//for instance for in order traversal we are going to return the value when we hit null but as per recursion we are going to root.right too
//when we hit null on the root.right thw root will goto the stack and it's get poped so the value at root.right and root.left is going to be same
// we are maintaing a local variable as we need to maintain the number at each node
//the global variable is not goig to work over here as it over rides the all the values when it gets poped out from the stack
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
    int sum;
    public int sumNumbers(TreeNode root) {
        helper(root,0);
        return sum;
    }
    private void helper(TreeNode root, int num){
        //base
        if(root == null) return;
         if(root.left ==null && root.right == null){
            sum += num * 10 + root.val;
        }
        //logic
        helper(root.left, num*10+root.val);
        
            //st.pop() both the node and num will pop 
        helper(root.right, num* 10+root.val);
        //st.pop() both the node and num will pop
       
        
    }
}
