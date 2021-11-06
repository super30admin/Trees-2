// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No
import java.util.*;

class Solution {
    int result = 0;
    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }
    
    private int helper(TreeNode root, int num) {
        if (root == null) {
            return 0;
        }
        
        if (root.left == null && root.right == null) {
            result += (num * 10 + root.val);
            return result;
        }
        num = num * 10 + root.val;
        helper(root.left, num);
        helper(root.right, num);
        
        return result;
    }
}
