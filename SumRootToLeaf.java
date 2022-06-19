public class SumRootToLeaf {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    int result;

    public int sumNumbers(TreeNode root) {
        helper(root,0);
        return result;
    }

    private void helper(TreeNode root,int currSum){
        if(root==null){
            return;
        }

        if(root.left==null && root.right==null){
            result+=currSum*10+root.val;
        }

        helper(root.left,currSum*10+root.val);
        helper(root.right,currSum*10+root.val);


    }
}
