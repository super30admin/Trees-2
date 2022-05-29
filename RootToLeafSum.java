/**
Time Complexity : O(N) , N = number of elements
Space Complexity : O(D), D = depth of the tree
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

*/
class Solution 
{
    int sum = 0;
    
    public int sumNumbers(TreeNode root) 
    {
        traverse(root, 0);
        
        return sum;
    }
    
    public void traverse(TreeNode root, int currentSum)
    {
        if(root == null)
            return;
        
        if(root.left == null && root.right==null)
        {
            currentSum = currentSum*10 + root.val;
            sum = sum + currentSum;
            return;
        }
        
        if(root.left != null)
            traverse(root.left, currentSum*10 + root.val);
        
        if(root.right != null)
            traverse(root.right, currentSum*10 + root.val);
    }
}