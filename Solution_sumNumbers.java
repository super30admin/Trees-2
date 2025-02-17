//TC: O(n)
//SC: O(1)
//Did it run on leetcode: Yes
public class Solution_sumNumbers {
    int result = 0;
    public int sumNumbers(TreeNode root) {
        helper(root, 0);
        return result;
    }

    public void helper(TreeNode root, int curr){
        if(root == null)
            return;

        curr = curr*10 + root.val;
        if(root.left == null && root.right == null)
            result += curr;
        helper(root.left, curr);
        helper(root.right, curr);
    }
}
