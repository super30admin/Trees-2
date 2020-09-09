// Time Complexity : O(n)
// Space Complexity : O(n) where n is height of tree when including recursive stack, else O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//At every node, we maintain a curr value at that node(node value+10*prev). When we hit leaf node, we add the value to ouput
//recur for left and right subtree at every node.
//return output

class Solution {
    public int sumNumbers(TreeNode root) {
       recurr(root,0);
        return sum;
        
    }
    private int sum=0;
    private void recurr(TreeNode root, int prev){
        if(root==null) return;
    int curr=prev*10+root.val;
    if(root.left==null&&root.right==null){
        sum+=curr;
        return;
    }
    
    recurr(root.left,curr);
    recurr(root.right,curr);
      
    }
}