/*
Desc: using inorder traversal, we push the curresnt sum and the node into the revursive stack(internally)
and we use the current sum to add into the resultant while a leaf node is encountered.
Time Complexity: O(n)
Space Complexity: O(1)
*/


class Solution {
    int result;
    public int sumNumbers(TreeNode root) {
        int currSum = 0;
        preorder(root,0);
        return result;
    }
    private void preorder(TreeNode root, int currSum){
        if(root==null){
            return;
        }
        currSum = currSum*10 + root.val;
        preorder(root.left,currSum);
        if(root.left == null && root.right == null) result += currSum;
        preorder(root.right,currSum);
    }
}
