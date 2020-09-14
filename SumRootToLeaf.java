class SumRootToLeaf {
    // Time Complexity:     O(n) - Visit each node
    // Space Complexity:    O(h) - height of the root node/ Depth of deepest node
    
    int output = 0;

    public int sumNumbers(TreeNode root) {
        if(root == null)
            return 0;
        
        calc(root, 0);
        return output;
    }
    
    public void calc(TreeNode root, int prev){
        int currSum = prev * 10 + root.val;
        
        if(root.left == null && root.right == null){
            output += currSum;
            return;
        }
        
        if(root.left != null)
            calc(root.left, currSum);
        if(root.right != null)
            calc(root.right, currSum);
    }
}