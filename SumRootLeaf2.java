public class SumRootLeaf2 {

    // **** Using local variable ****
    // TC - O(n) n - number of nodes in a tree
    // SC - O(h) h - height of the tree
    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }

    private int helper(TreeNode root, int currSum) {
        if(root == null) return 0;

        if(root.left == null && root.right == null){
            return currSum * 10 + root.val;
        }

        int case1 = helper(root.left, currSum);
        int case2 = helper(root.right, currSum);

        return case1 + case2;
    }
}
