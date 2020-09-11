// Time Complexity :O(n) n=number of nodes in given tree
// Space Complexity :O(1) 
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
class Solution {
    
    private int output=0;
    
    public int sumNumbers(TreeNode root) {
        recurr(root,0);
        return output;
    }
    
    public void recurr(TreeNode root, int previous){
            if(root==null){
                return;
            }
            
            int current = previous * 10 + root.val;
            
            if(root.left==null && root.right==null){
                output+=current;
            }
            
            recurr(root.left, current);
            recurr(root.right, current);
        }
}