import javax.swing.tree.TreeNode;

// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
//create a new class so we can have an object pair that holds together the root and sum to insert into stack 
class Pair{
    TreeNode root;
    int sum;
    
    //constructor
    public Pair(TreeNode root, int sum){
        this.root = root;
        this.sum = sum;
    }
    
    public TreeNode getKey(){
        return this.root;
    }
    
    public int getValue(){
        return this.sum;
    }
}

class Solution {
    
    int result;
    
    public int sumNumbers(TreeNode root) {
        if(root == null)
            return 0;
        
        helper(root, 0);
        return result;
    }
    
    private void helper(TreeNode root, int currSum){
        
        //base
        if(root == null) return;
        //logic
        currSum = currSum * 10 + root.val;
        helper(root.left, currSum);
        
        //check if root is leaf node
        if(root.left == null && root.right == null)
            result += currSum;
        
        helper(root.right, currSum);
    }
}



