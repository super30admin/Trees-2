class SumRootToLeaf {
    public int sumNumbers(TreeNode root) {
        if(root == null) {
            return 0;
        }

        return recurseSumToLeaf(root, 0);
    }

    private int recurseSumToLeaf(TreeNode root, int sum){
        if(root==null){
            return 0;
        }
        sum=sum*10;
        if(root.left == null && root.right == null){
            return sum + root.val;
        }
        int left = recurseSumToLeaf(root.left, sum + root.val);
        int right = recurseSumToLeaf(root.right, sum + root.val);
        return left + right;
    }
}
