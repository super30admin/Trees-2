// Time Complexity : O(N)
// Space Complexity : O(H)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach

/*

Since we need the sum, till the leaf node, we use recursion and with help of local variable, we
keep track of the same.

*/
public class SumRootToLeafNumbers{

    int total;
    public int sumNumbers(TreeNode root) {
        
        if(root == null)
        {
            return 0;
        }
        
         helper(root,0);
        return total;
        
    }
    
    private void helper(TreeNode root, int sum)
    {
        if(root == null)
        {
            return;
        }
     
        if(root.left == null && root.right==null)
        {
            total+=sum*10 + root.val;
            return;
        }
       
        helper(root.left,(sum*10)+root.val);
        helper(root.right,(sum*10)+root.val);
        
    }
}