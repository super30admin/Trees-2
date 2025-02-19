// Overall Time Complexity : O(n) . The time taken to iterate over all the nodes in the linked list.
// Overall Space Complexity : O(n) . The space complexity is 0(n) because of the stack size used by recursion calls (for skewed trees).
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No issues faced during implementation

// Use pre-order traversal for iterating the tree. 
// Maintain currSum and update the final sum when we reach the leaf node.
public class Sum {
     
    int res = 0;
    public int sumNumbers(TreeNode root) {
        helper(root,0);
        return res;
    }
    private void helper(TreeNode root, int currSum){
        if (root == null) return ;
        currSum = currSum*10+ root.val;
        if(root.left == null && root.right==null ){
            res+=currSum;
        }
        helper(root.left, currSum);
        helper(root.right,currSum);
       
    }
}

