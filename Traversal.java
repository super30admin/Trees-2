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
// Time complexity = O(n)// entire array is iterated over.
// Space complexity = O(n) // variable no. of variable length arrays are used. worst case n is the length of an array.
class Traversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // inorder = left, root, right
        // postorder = left, right, root
        if( postorder.length== 0) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postorder.length-1]);// last node is the root.
        int rootIdx = -1;
        for(int i=0;i< inorder.length;i++) {
            if(inorder[i] == root.val) {
                rootIdx = i;
                break;
            }
        }
        int[] inLeft = Arrays.copyOfRange(inorder, 0, rootIdx);
        int[] inRight = Arrays.copyOfRange(inorder, rootIdx+1, inorder.length);
        int[] postLeft = Arrays.copyOfRange(postorder, 0, inLeft.length);
        int[] postRight = Arrays.copyOfRange(postorder,postLeft.length ,postorder.length-1);
        root.left = buildTree(inLeft, postLeft);
        root.right = buildTree(inRight, postRight);
        return root;
    }
}