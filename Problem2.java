
//Time complexity - O(N)
//Space complexity - O(H) height of tree


class Solution {

    int result;
    public int sumNumbers(TreeNode root) {

        if(root == null) return 0;
        helper(root,0);
        return result;

    }

    public void helper(TreeNode root, int currSum) {

        if(root == null) return;


        currSum = currSum * 10 + root.val;

        helper(root.left,currSum); // Left sub tree

        if(root.left == null && root.right == null) {

            result += currSum;

        }

        helper(root.right,currSum); // Right sub tree

    }
} 