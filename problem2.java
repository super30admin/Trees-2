import javax.swing.tree.TreeNode;

class sumOfRooteLeaf{
    int sum;
    public int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        helper(root,0);
        return sum;
    }

    private void helper(TreeNode root, int currSum){
        if(root == null){
            return;
        }

        helper(root.left, currSum * 10 + root.val);
        helper(root.right, currSum * 10 + root.val);

        if(root.left == null && root.right == null){
            sum = sum + currSum * 10 + root.val;
            return;
        }
    }
}