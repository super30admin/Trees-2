//Time Complexity:O(n)
//Space Complexity:O(1)

public class Solution {
	int result;
    public int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        helper(root, 0);
        return result;
    }
    private void helper(TreeNode root, int sum){
        if(root == null)return;
            sum = sum*10 + root.val;
            helper(root.left,sum);
            if(root.left == null && root.right == null){
                result = result+sum;
            
        }   helper(root.right,sum);     
    }
}
