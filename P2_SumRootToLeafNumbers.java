//TC O(n)
//SC O(1)
class Solution {
    int gSum = 0;
    void preorder(TreeNode node, int sum) {
        if(node == null) return;
        sum = (sum*10) + node.val;
        if(node.left == null && node.right == null) {
            gSum += sum;
        }
        preorder(node.left, sum);
        preorder(node.right, sum);
    }
    public int sumNumbers(TreeNode root) {
        preorder(root, 0);
        return gSum;
    }
}