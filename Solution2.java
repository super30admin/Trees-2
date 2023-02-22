// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
 * I maintain a global variable sum = 0. I then call the function calculate with root and 0 as the parameters. If the root is null
 * I return outside the function. If root is a leaf node, I add localSum*10 + root.val to sum and return from the function.
 * I recursively call the function on left and right children with localSum*10+root.val as the parameters. At the end, I return
 * sum as the result.
 */

class Solution2 {
    int sum=0;
    
    public int sumNumbers(TreeNode root) {
        calculate(root);
        return sum;
    }

    public void calculate(TreeNode root, int localSum)
    {
        
        if(root==null)
        {
            return;
        }
        if(root.left==null && root.right==null)
        {
            sum+=localSum*10+root.val;
            return;
        }
        calculate(root.left,localSum*10+root.val);
        calculate(root.right,localSum*10+root.val);
    }


}