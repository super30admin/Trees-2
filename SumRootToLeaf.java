// 129. Sum Root to Leaf Numbers
// https://leetcode.com/problems/sum-root-to-leaf-numbers/description/


/**
 * Time Complexity: o(n) since we process each element
 * Space Complexity: o(h) where h is the height of tree. Since in worst case our call stack would have h calls at a time
 */

// Void based recursion

class Solution {
    
    int sum;

    public int sumNumbers(TreeNode root) {
        sum = 0;
        helper(root, 0);
        return sum;
    }

    private void helper(TreeNode root, int no){
        // base condition
        if(root == null){
            return;
        }

        // logic

        // process root to form number
        no = no * 10 + root.val;

        if(root.left == null && root.right == null){
            sum = sum + no;
        }

        helper(root.left, no);
        helper(root.right, no);
    }
}


// Int based recursion
class Solution {

    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }

    private int helper(TreeNode root, int no){
        // base condition
        if(root == null){
            return 0;
        }

        // logic

        // process root to form number
        no = no * 10 + root.val;

        int left = helper(root.left, no);
        int right = helper(root.right, no);

        if(root.left == null && root.right == null){
            return no;
        }

        return left + right;
    }
}