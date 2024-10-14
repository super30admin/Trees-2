class Solution {
    int Gsum;
    public int sumNumbers(TreeNode root) {
        Gsum=0;
        helper(root,0);
        return Gsum;

    }
    private void helper(TreeNode root, int sum){
        sum=sum*10+root.val;
        if(root.left==null && root.right == null){
            Gsum=Gsum+sum; 
            return;
        } 
        if(root.left!=null)
        helper(root.left,sum);
        if(root.right!=null)
        helper(root.right,sum);
        return;
    }
}
