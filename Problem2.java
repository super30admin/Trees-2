//Time Complexity: O(n)
//Space Complexity: O(h), where h is the height of the tree.
//Code run successfully on LeetCode.

public class Problem2 {

    public int sumNumbers(TreeNode root) {
        
        return helper(root, 0);     
    }
    
    private int helper(TreeNode root, int nums){
        
        if(root == null)
          return 0;
        
        if(root.left == null && root.right == null)
            return nums*10 + root.val;
        
        return helper(root.left, nums*10 + root.val) + helper(root.right, nums*10 + root.val);
        
    }
}
