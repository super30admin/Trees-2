/**
 * Q. Sum Root to Leaf Numbers
 * 
 * Approach - keep on forming number for each path from root to leaf,
 * when you reach leaf add to the sum. 
 * 
 * Time Complexity - O(n) Space Complexity - O(1)
 */
class Solution {

    int sum = 0;

    public void helper(TreeNode root, String number) {

        if (root == null) {
            return;
        }

        number += Integer.toString(root.val);

        if (root.left == null && root.right == null) {
            sum += Integer.parseInt(number);
            return;
        }

        helper(root.left, number);
        helper(root.right, number);

    }

    public int sumNumbers(TreeNode root) {
        String number = "";
        helper(root, number);
        return sum;
    }
}