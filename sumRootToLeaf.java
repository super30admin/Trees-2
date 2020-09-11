    /*  Explanation
    # Leetcode problem link : https://leetcode.com/problems/sum-root-to-leaf-numbers/
    Time Complexity for operators : o(n) .. number of  elements in the matrix
    Extra Space Complexity for operators : o(1) 
    Did this code successfully run on Leetcode : Yes
    Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
        # Basic approach : can concatenate string and use parseInt

        # Optimized approach : simply multiply previous element by 10 and add the current element.
                              
            # 
                    A. traverse thue the tree and maintain prev
                    B. multiply it by 10 and add it to current val
                    C. if left and right both are null that means we are at end add current to output.
                    D. call recursively to left and right by passing prev element.
                    E. at the end return output variable.

       */


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

   class validateBST {

    int output = 0;
    public int sumNumbers(TreeNode root) {
        int prev = 0;
        summation(root,prev);
        return output;
    }
    
    private void summation(TreeNode root, int prev){
        if(root == null)
            return;
        
        int curr = prev * 10 + root.val;
        
        if(root.left==null && root.right == null){
            output += curr;
          //  return;
        }
            
        summation(root.left,curr);
        summation(root.right,curr);
    }
        

}