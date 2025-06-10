//recursively build each number by multiplying the current sum s by 10 and adding the current node’s value. When a leaf node is reached, it returns the full number, and the total sum is the sum of all such paths.
//Time complexity: O(n)
//Space complexity: O(h)

class Solution {
    public int sumNumbers(TreeNode root) {
        return sum(root, 0);
    }

    public int sum(TreeNode n, int s){

            if (n == null) return 0;

            if (n.right == null && n.left == null) return s*10 + n.val;

            return sum(n.left, s*10 + n.val) + sum(n.right, s*10 + n.val);
    }
}