// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

/*
1. Maintain a totalSum at globalScope
2. maintain a currSum at localScope and keep adding root.val to it (currSum=currSum*10+root.val)
3. Whenever you hot a leaf node, add node's val to the currSum and add it to the totalSum

*/

public class SumRootToLeaf{
    int totalSum=0;
    public int sumNumbers(TreeNode root) {
        int currSum=0;
        findPaths(root,currSum);
        return totalSum;
        
    }
    public void findPaths(TreeNode root,int currSum)
    {
        if(root==null)
            return;
        if(root.left==null && root.right==null)
        {
            currSum=currSum*10+root.val;
            totalSum+=currSum;
            return;
        }
        currSum=currSum*10+root.val;
        findPaths(root.left,currSum);
        findPaths(root.right,currSum);
    }
}