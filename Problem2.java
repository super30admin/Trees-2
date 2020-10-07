// Time Complexity : O(n), since we access all the nodes to calculate the sum
// Space Complexity : O(1), not considering the auxillary space
// Did this code successfully run on Leetcode : 0ms
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

// Basically, we will recursively call the helper functions, accessing all the digits for the tree, and once the leaf node is accessed
// we will add it to the global sum

class Solution {
    int sum2 =0;
    public int sumNumbers(TreeNode root) {
        helper(root,0);
        return sum2;
    }
    
    private void helper(TreeNode root,int sum )
    {
        if(root == null) return;
        if(root.left == null && root.right==null) {
            sum2 += sum*10+root.val;
            return;
    }
        helper(root.left,sum*10+root.val);
        helper(root.right,sum*10+root.val);
        
    }
}

