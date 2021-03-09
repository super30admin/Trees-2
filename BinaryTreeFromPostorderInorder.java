/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class BinaryTreeFromPostorderInorder {

    // Time Complexity: O(n)    (where n -> no. of nodes in the tree)
    // Space Complexity: O(n)

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        // Edge Case Checking
        if(n == 0)
            return null;
        return helper(inorder, 0, n, postorder, 0, n);
    }
    
    private TreeNode helper(int[] inorder, int i1, int i2, int[] postorder, int p1, int p2){
        // If our left and right pointers cross each other then we stop
        if(i1 >= i2 || p1 >= p2)
            return null;
        
        // Create a new node everytime from the end of the postorder array
        TreeNode root = new TreeNode(postorder[p2-1]);
        int root_location = 0;

        // Find the current node in the inorder array
        for(int i = i1; i < i2; i++){
            if(postorder[p2-1] == inorder[i]){
                root_location = i;
                break;
            }
        }
        
        int left = root_location - i1;
        // Make recursive calls by choosing correct left and right subtrees from both inorder and postorder array
        root.left = helper(inorder, i1, i1+left, postorder, p1, p1+left);
        root.right = helper(inorder, root_location+1, i2, postorder, p1+left, p2-1);
        
        return root;
    }
    
}