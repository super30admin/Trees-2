// Time Complexity : O(n)// all nodes
// Space Complexity : O(h) //height of the stack/tree
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

//method 1: void recursive : using global sum, local currNum

class Solution {
    int sum;
    public int sumNumbers(TreeNode root) {
        helper(root,0);
        return sum;
    }

    private void  helper(TreeNode root, int currNum){
        if(root==null){ //what if all left node is present -> it goes to right node n check
            return;
        }

        currNum= currNum*10 + root.val;
        if(root.left ==null && root.right ==null) {
            sum+=currNum;
            return;
        }
        helper(root.left, currNum);
        helper(root.right, currNum);
    }
}


//method 2: int recursive : using global sum, local currNum

class Solution {
    
    public int sumNumbers(TreeNode root) {
        
        return helper(root,0);
    }

    private int  helper(TreeNode root, int currNum){
        if(root==null){ //what if all left node is present -> it goes to right node n check
            return 0;
        }

        currNum= currNum*10 + root.val;
        if(root.left ==null && root.right ==null) {
            return currNum;
        }
        int left = helper(root.left, currNum);
        int right = helper(root.right, currNum);

        return left+right;
    }
}


