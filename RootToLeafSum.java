// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class RootToLeafSum {
    int total;
    public int sumNumbers(TreeNode root) {
        total = 0;
        
        if(root == null) return total;
        dfs(root, total);
        return total;
    }
    
    private void dfs(TreeNode node, int parent){
        //base
        if(node == null) return;
        //logic
        parent = parent*10 + node.val;
        if(node.left == null && node.right == null){
            total += parent;
        }
        //recurse
        dfs(node.left, parent);
        dfs(node.right, parent);
    }
}
