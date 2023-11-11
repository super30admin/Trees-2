//Time Complexity:O(n)
//Space Complexity: O(1)


class Solution {
    public int sumNumbers(TreeNode root) {
        int result = 0;
        return helper(root, 0);
    }
    private int helper(TreeNode root, int currNum){
        if(root == null) return 0;

        currNum = currNum*10 + root.val;
        if(root.left == null && root.right == null){
            return currNum;
        }
        int left = helper(root.left, currNum);
        int right = helper(root.right, currNum);
        return left + right;
    }
}
