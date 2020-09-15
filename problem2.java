//Time complexity: O(N)
//Space:O(H)
class Solution {
    int total = 0;

    public int sumNumbers(TreeNode root) {

        recur(root, 0);

        return total;
    }

    void recur(TreeNode root, int prev) {

        if (root == null)
            return;

        int curr = prev * 10 + root.val;

        if (root.left == null && root.right == null) {
            total += curr;
            return;
        }

        recur(root.left, curr);
        recur(root.right, curr);
    }
}