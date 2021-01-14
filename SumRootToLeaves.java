class Solution {
    int result = 0;
    public int sumNumbers(TreeNode root) {
        helper(root, 0);
        return result;
    }
    public void helper(TreeNode root, int curSum){
        if(root == null)
            return;
        if(root.left == null && root.right==null){
            result = result + curSum*10 + root.val;
            return;
        }
        curSum = curSum*10 + root.val;
        helper(root.left, curSum);
        helper(root.right, curSum);
    }
}

//Time complexity : O(N) where N is the number of elements
//Space complexity : O(h) where h is the height of recursive stack
