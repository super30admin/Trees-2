//Time complexity: O(N)
//Space complexity: O(H), to keep the recursion stack where H is height of tree.
class Solution {
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        if(root == null) {
            return 0;
        }
        helperMethod(root, 0);
        return sum;
    }

    private void helperMethod(TreeNode root, int num) {
        //base
        if(root == null) {
            return;
        }
        helperMethod(root.left, num * 10 + root.val);
        if(root.left == null && root.right == null) {
            sum = sum + num * 10 + root.val;
        }
        helperMethod(root.right, num * 10 + root.val);
    }
}