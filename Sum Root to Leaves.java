//TC: O(N) - traversing the tree only once
// SC: O(N)- recursive stack else O(1)

class Solution {
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        dfs(root,"");
        return sum;
    }
    
    private void dfs(TreeNode root, String res){
        if(root.left == null && root.right == null){
            res+=root.val;
            sum+=Integer.parseInt(res);
        }
        res+=root.val;
        if(root.left != null){
            dfs(root.left,res);
        }
        if(root.right != null){
            dfs(root.right,res);
        }
    }
}