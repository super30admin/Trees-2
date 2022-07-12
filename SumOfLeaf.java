public class SumOfLeaf {
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        if(root == null) return sum;
        helper(root, root.val);
        return sum;
    }
    
    // TC is O(n)
    // SC is O(h)
    private void helper(TreeNode root, int currSum){
        // base
        if(root.left == null && root.right == null){
            sum += currSum;
        }
        
        // left
        if(root.left != null){
            helper(root.left, currSum*10+root.left.val);
        }
        
        
        // right
        if(root.right != null){
            helper(root.right, currSum*10+root.right.val);
        }
        
    }
}
