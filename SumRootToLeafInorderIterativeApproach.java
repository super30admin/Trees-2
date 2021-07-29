// Time Complexity :O(N)
// Space Complexity :O(H)-> H = height of tree
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Pair{
     TreeNode root;
     int sum;
            
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
        
        Stack <Pair> stack = new Stack<>();
        int currSum = 0, result = 0;
        while(root != null || !stack.isEmpty()){
            
            //left
            while(root != null){
                currSum = currSum * 10 + root.val;
                stack.push(new Pair(root, currSum));
                root = root.left;               
            }
            //root
            Pair p = stack.pop();
            root = p.getKey();
            currSum = p.getValue();
           
            if(root.left == null && root.right == null)
                result += currSum;
            
            //right
            root= root.right;
        }
        
        return result;
    }
}