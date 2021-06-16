//Time complexity - O(N)
//Space complexity - O(H) - Height of the tree


class Solution {

    int result;
    public int sumNumbers(TreeNode root) {

        if(root == null) return 0;
        helper(root,0);
        return result;

    }

    public void helper(TreeNode root, int currSum) {

        if(root == null) return;

        // multiply currSum by 10 + root's value to put it with root value in the recursive stack
        currSum = currSum * 10 + root.val;

        //call left subtree of root
        helper(root.left,currSum);


        //if the root reaches the leaf node pop the stack and add the current sum value to the result
        if(root.left == null && root.right == null) {

            result += currSum;

        }

        // call right subtree
        helper(root.right,currSum);

    }
}