class Solution {
    int sum;
    public int sumNumbers(TreeNode root) {
        if(root==null) return 0;
        helper(root,0);
        return sum;
    }
    private void helper(TreeNode root,Integer currsum){
        if(root==null) return;
        helper(root.left,currsum*10+root.val);
        if(root.left==null && root.right==null){ 
            sum+=currsum*10+root.val;
            return ;
            }
        helper(root.right,currsum*10+root.val);

    }
}