/* Time complexity: O(n)
Space complexity: O(1)

1. Using inorder traversal to validate the BST.
2. Checking if left child is smaller than parent node and right child is greater than the 
parent node.
3. Carry out the same process to validate BST.

*/


class Solution {
    TreeNode prev = null;
    public boolean isValidBST(TreeNode root) {
        if(root  == null){
            return true;
        }
        return inorder(root);
    }
    
    private boolean inorder(TreeNode root){
        if(root == null) return true;
        if(inorder(root.left) == false) return false;
        if(prev != null && prev.val >= root.val) return false;
        prev = root; // making the rightchild as root and parent as prev
        return inorder(root.right);
    }
}