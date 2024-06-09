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
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        // inorder(root, 0);
        // return sum;

        if(root == null) {
            return 0;
        }

        int sum = 0;
        int num = 0;
        Stack<TreeNode> s = new Stack<>();
        Stack<Integer> currNum = new Stack<>();

        while(root != null || !s.isEmpty()) {
            while(root != null) {
                s.push(root);
                num = num * 10 + root.val;
                currNum.push(num);
                root = root.left;
            }
            root = s.pop();
            num = currNum.pop();
            if(root.left == null && root.right == null) {
                sum = sum + num;
            }
            root = root.right;
        }
        return sum;
    }

    private void inorder(TreeNode root, int countNum) {
        if(root == null) {
            return;
        }

        inorder(root.left, countNum * 10 + root.val);
        if(root.left == null && root.right == null) {
            sum = sum + countNum * 10 + root.val;
        }
        inorder(root.right, countNum * 10 + root.val);
    }
}
