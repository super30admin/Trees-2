// Time Complexity : o(n)
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

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

/* Iterative Approach
class Pair
{
    TreeNode root;
    int sum;
    
    public Pair(TreeNode root, int sum)
    {
        this.root=root;
        this.sum=sum;
    }
    
    public TreeNode getKey()
    {
        return this.root;
    }
    public int getValue()
    {
        return this.sum;
    }
}
class Solution {
    public int sumNumbers(TreeNode root) {
        if(root==null)
            return 0;
        int currSum=0;int result=0;
        Stack<Pair> s=new Stack<>();
        
        while(root!=null || !s.isEmpty())
        {
            //left
            while(root!=null)
            {
                currSum=currSum*10+root.val;
                s.push(new Pair(root,currSum));
                root=root.left;
            }
            //root
           Pair p=s.pop();
           root= p.getKey();
           currSum=p.getValue();
           
            if(root.left==null && root.right==null)
                result+=currSum;
            //right
            root=root.right;
        }
        return result;
    }
}*/

// Recursive Approach
class Solution 
{
    public int sumNumbers(TreeNode root)
    {
        int result=helper(root,0,0);
        return result;
    }
    
    private int helper(TreeNode root,int currSum,int result)
    {
        if(root==null)
            return result;
        
        currSum=currSum*10+root.val;
        result=helper(root.left,currSum,result);
        if(root.left==null && root.right==null)
        {
            result+=currSum;
        }
        result=helper(root.right,currSum,result);
        
        return result;
    }
}

