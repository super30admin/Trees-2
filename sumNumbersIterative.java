import java.util.Stack;

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
    public int sumNumbers(TreeNode root) {
        if(root == null)
            return 0;
        
        Stack<Pair> stack = new Stack<>();
        
        //one sum to keep track of path sum and other one for the total result of all the paths
        int currSum = 0, result = 0;
        
        while(root != null || !stack.isEmpty()){
            
            //left: calculate current sum at each node, add the pair to the stack and move forward
            while(root != null){
                currSum = currSum * 10 + root.val;
                stack.push(new Pair(root, currSum));
                root = root.left;
            }
            
            //root: pop the pair, store the pair's values in the variables
            Pair p = stack.pop();
            root = p.getKey();
            currSum = p.getValue();
            
            //check if it is a leaf node then add it to the result sum since path is over
            if(root.left == null && root.right == null)
                result += currSum;
             
            //right
            root = root.right;
        }
        
        return result;
    }
}



