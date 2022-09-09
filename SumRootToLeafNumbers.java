// Time complexity: O(N)
// Space complexity: O(H)

// Approach: we basically maintain a global variable result to capture the final sum and then we need to maintain a currsum. The curr sum at every node is currsum*10+node.val.


// void approach
class Solution {
    int result = 0;
    public int sumNumbers(TreeNode root) {
        helper(root, 0);
        return result;
    }
    
    private void helper(TreeNode root, int currSum) {
        // base
        if (root == null) return;
        currSum = currSum*10 + root.val;
        if (root.left == null && root.right == null) {
            result += currSum;
        }
        helper(root.left, currSum);
        helper(root.right, currSum);
    }
}

// int approach

// Time complexity: O(N)
// Space complexity: O(H)

class Solution {
    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }
    
    private int helper(TreeNode root, int currSum) {
        // base
        if (root == null) return 0;
        currSum = currSum*10 + root.val;
        if (root.left == null && root.right == null) {
            return currSum;
        }
        return helper(root.left, currSum) + helper(root.right, currSum);
    }
}