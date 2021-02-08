// Time Complexity : O(V+E) or O(n)
// Space Complexity : O(d) depth of tree
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach
// Recvursively calculate all root to leaf sum and add
class Solution {
    
    int ans = 0;
    
    public int sumNumbers(TreeNode root) {
        
        if(root==null) return 0;
        helper(root, 0);
        return ans;
        
    }
    
    public void helper(TreeNode root, int number) {
        
        number = number*10 + root.val;
        if(root.left==null && root.right==null) {
            
            ans += number;
            return;
        }
        
        if(root.left!=null)
            helper(root.left, number);
        if(root.right!=null)
            helper(root.right, number);
        
    }
}
