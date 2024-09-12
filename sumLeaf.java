Time Complexity-O(n)
Space Complexity-O(1)

class Solution {
    int FinalSum;
    public int sumNumbers(TreeNode root) {
         helper(root,0);
        return FinalSum;
    }
    public void helper(TreeNode root, int sum)
    {
        //base case
        if(root==null)
             return;;
         if (root.left == null && root.right == null) {
            FinalSum += sum*10+root.val;
            return;
        }
        
        //logic
         helper(root.left,sum*10+root.val);
         helper(root.right,sum*10+root.val);
    }
}
