// Time Complexity : O(n) where 'n' is number of nodes
// Space Complexity : O(h) where 'h' is height of the tree
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// we are calculating the current value by multiplying the parent with 10 and adding the current node's value
// we are passing this current val to each recursive call, until we reach a leaf
// we add the value at leaf to totalsum
//Approach -1 : void based recursion 
class SumRoottoLeaf {
    int totalsum;
    public int sumNumbers(TreeNode root) {
        helper(root, 0);
    return totalsum;    
    }

    private void helper(TreeNode root, int curr){
        if (root == null) return;
        curr = curr*10 + root.val;
        if(root.left == null && root.right == null){
            totalsum = totalsum + curr;
        }
        helper(root.left, curr);
        helper(root.right, curr);
    }
}

//Approach 2 - int based recursion
class SumRoottoLeaf {
    public int sumNumbers(TreeNode root) {
        int out = helper(root, 0);
    return out;    
    }

    private int helper(TreeNode root, int curr){
        if (root == null) return 0;
        curr = curr*10 + root.val;
        if(root.left == null && root.right == null){
            return curr;
        }
        int left = helper(root.left, curr);
        int right = helper(root.right, curr);
        return left + right;
    }
}