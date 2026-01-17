// Time Complexity :  O(N) - Number of nodes in tree
// Space Complexity : O(h) - H is height of the tree. H nodes will be in the recursion stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach :
// Since we need to add sum from root to leaf, we need to pass current root value to child as currSum. At the child,
// do the addition and pass it to next child. At the leaf node, return sum of the value passed by the parent and
// the current value.
public class PathSum {
    public int sumNumbers(TreeNode root) {
        return sumRootToLeaf(root, 0);
    }

    public int sumRootToLeaf(TreeNode root, int currSum){
        if(root == null) return 0;

        currSum = currSum * 10 + root.val;
        // Check if leaf node
        if(root.left == null && root.right == null){
            return currSum;
        }

        int left = sumRootToLeaf(root.left, currSum);
        int right = sumRootToLeaf(root.right, currSum);
        return left + right;
    }
}
