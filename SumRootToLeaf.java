// Time Complexity : O(n)
// Space Complexity : O(height)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach

class SumRootToLeaf {
    int sum;
    public int sumNumbers(TreeNode root) {
        helper(root, 0);
        return sum;
    }

    private void helper(TreeNode root, int currSum) {
        if(root == null) return;

        //check if leaf node
        if(root.left == null && root.right == null) {
            sum += currSum * 10 + root.val;
        }
        helper(root.left, currSum * 10 + root.val);
        //st.pop()
        helper(root.right, currSum * 10 + root.val);
        //st.pop()
    }
}