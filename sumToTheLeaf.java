/* Time complexity: O(n)
Space complexity: O(depth of tree)

*/

class Solution{
    int result;
    public int sumNumbers(TreeNode root){
        if(root == null) return 0;
        helper(root,0);
        return result;
    }
    private void helper(TreeNode root, int currSum){
        if(root == null) return;
        currrsum = currSum*10 + root.val;
        if(root.left == null && root.right == null){
            result += currSum;
        }
        helper(root.left,currSum);
        helper(root.right,currSum);
    }
}