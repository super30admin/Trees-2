// Time Complexity :O(nodes)
// Space Complexity :O(height of tree)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :no
public class sum {
    public int sumNumbers(TreeNode root) {    
	
        return helper(root, 0);     
    }
    
    public int helper(TreeNode node, int currSum) {
        
        //node is null
        if (node == null) return 0;
        
        //child node
        if (node.left == null && node.right == null) return currSum * 10 + node.val;
        
        //dfs
        return helper(node.left, currSum * 10 + node.val) + helper(node.right, currSum * 10 + node.val);
    }
}
