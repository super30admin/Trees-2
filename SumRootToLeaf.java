// Time Complexity : O(m+n) m:edges, n:nodes
// Space Complexity : O(maxDepth)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class SumRootToLeaf {
    int globalSum = 0;

    public int sumNumbers(TreeNode root) {
        calculateSum(root, 0);
        return globalSum;
    }

    private void calculateSum(TreeNode node, int currSum){
        // base case: 1. if node is null
        if(node == null){
            return;
        }

        // base case: 2. if node is leaf, return sum adding its own val
        if(node.left == null && node.right == null){
            currSum += node.val;
            globalSum += currSum;
        }

        // recurring case
        // while we send, we send *10 so that when we add at leaf, we just add lea val
        int nextSum = (currSum + node.val)*10;
        calculateSum(node.left, nextSum);
        calculateSum(node.right, nextSum);
    }
}
