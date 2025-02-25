class Problem2 {
    int result=0;
    public int sumNumbers(TreeNode root) {
        helper(root,0);
        return result;
    }
    private void helper(TreeNode root, int curr){
        if(root==null) return ;
        curr= curr*10+root.val;
        if(root.left == null && root.right==null){
            result+=curr;
            return ;
        }
        helper(root.left,curr);
        helper(root.right,curr);
        return ;
    }

}