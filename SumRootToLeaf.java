// Time Complexity : O(N)
// Space Complexity : O(H)
// Did this code successfully run on Leetcode : Yes

class Solution {
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        helper(root,0);
        return sum;
    }
    void helper(TreeNode cur, int val){
        if(cur == null){
            return;
        }
        if(cur.left == null && cur.right==null){
            sum = sum + val*10 + cur.val;
            return;
        }
        helper(cur.left, val*10 + cur.val);
        helper(cur.right, val*10 + cur.val);
    }
}