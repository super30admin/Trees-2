// Time Complexity : O(n) as we go through all elements
// Space Complexity : O(1) but O(n) for recursive stack, realistically O(H)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach: recursively call child nodes and keep adding to curr sum
// which is currsum*10+node's val
public class SumRootToLeaf {
    public int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        return helper(root, 0);
        // return sum;
    }
    private /*void*/ int helper(TreeNode root, int currSum){
        if(root == null) return 0;
        currSum = currSum*10 + root.val;
        if(root.left == null && root.right == null){
            // sum += currSum;
            return currSum;
        }
        return helper(root.left, currSum) + helper(root.right, currSum);
    }
}
