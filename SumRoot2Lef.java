
//  TC: O(n)
//  SC : O(height of the tree)  no of recursive calls in a stack = height at any node.
class Solution {
    // int result;
    public int sumNumbers(TreeNode root) {
        // this.result = 0;
        return helper(root,0);
        // return result;
    }

    private int helper(TreeNode root, int currNum){
        if(root == null) return 0;
        //updated currNum should be in the preorder manner - is the only requirement; all other like traversing or checking for leaf node can be any
        currNum = currNum * 10 + root.val;

        if(root.left == null && root.right == null){
            return currNum;
        }

        int left = helper(root.left, currNum);

        int right = helper(root.right, currNum);

        return left + right;
    }
}