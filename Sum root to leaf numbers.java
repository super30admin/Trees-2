// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach: 
//We will use a global variable to store the sum received at every node. We will visit all the nodes and multiply is value with 10 and add it to the value in the global variable.



/*************** Void based Recursion ***************/

class Solution {
    int Result;
    public int sumNumbers(TreeNode root) {
        helper(root,0);
        return Result;
    }
    private void helper(TreeNode root,int CurrNum)
    {
        //base
        if(root==null) return;
        //logic
        CurrNum=CurrNum*10 + root.val;
        if(root.left==null && root.right==null)  //checking if it is a leaf node
        {
            Result+=CurrNum; //We add the CurrNum to the existing Result
        }
        //left
        helper(root.left,CurrNum);
        //right
        helper(root.right,CurrNum);
    }
}

/*************** Int based Recursion ***************/


class Solution {
    
    public int sumNumbers(TreeNode root) {
        return helper(root,0);
    }
    private int helper(TreeNode root,int CurrNum)
    {
        //base
        if(root==null) return 0;
        //logic
        CurrNum=CurrNum*10 + root.val;
        if(root.left==null && root.right==null)  //checking if it is a leaf node
        {
            return CurrNum; //We add the CurrNum to the existing Result
        }
        //left
        int left=helper(root.left,CurrNum);
        //right
        int right=helper(root.right,CurrNum);
return left+right;
    }
}


