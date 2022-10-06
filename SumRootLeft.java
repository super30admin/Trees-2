// Time Complexity : O(n)
// Space Complexity : O(H)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    // int sum;
    public int sumNumbers(TreeNode root) {
        // base case
        if (root == null) return 0;

        int sum = 0;
        Stack<TreeNode> s = new Stack<>();
        Stack<Integer> nums = new Stack<>();
        int num = 0;

        while ( root != null || !s.isEmpty()) {
            while (root != null) {
                s.push(root);
                num = num * 10 + root.val;
                nums.push(num);
                root = root.left;
            }
            root = s.pop();
            num = nums.pop();
            if (root.left == null && root.right == null) {
                sum = sum + num;
            }

            root = root.right;
        }

        return sum;
    }

//     private int fdsSum(TreeNode root, int num) {
//         // base case
//         if (root == null) return 0;

//         // // check if its a leaf node
//         if(root.left == null && root.right == null) {
//             return num*10 + root.val;
//         }

//         // left case
//         int case1 = fdsSum(root.left, num*10 + root.val);
//         // right case
//         int case2 = fdsSum(root.right, num*10 + root.val);
//         return case1 + case2;

//     }

//     private void fdsSum(TreeNode root, int num) {
//         // base case
//         if (root == null) return;

//         // // check if its a leaf node
//         if(root.left == null && root.right == null) {
//             sum = sum + num*10 + root.val;
//             return;
//         }

//         // left case
//         fdsSum(root.left, num*10 + root.val);
//         // right case
//         fdsSum(root.right, num*10 + root.val);

//     }
}