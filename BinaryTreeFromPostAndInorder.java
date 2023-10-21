import java.util.HashMap;

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
//TC: O(n)
//SC: O(n)
class BinaryTreeFromPostAndInorder {
    HashMap<Integer, Integer> map;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }
    private TreeNode helper(int[] inorder, int[] postorder, int inStart, int inEnd, int postStart, int postEnd) {
        //base
        if(inStart > inEnd || postStart > postEnd) return null;
        //logic
        int rootVal = postorder[postEnd];
        TreeNode root = new TreeNode(rootVal);
        int rootIdx = map.get(rootVal);
        int leftSize = rootIdx - inStart;
        root.left = helper(inorder, postorder, inStart, rootIdx-1, postStart, postStart + leftSize -1);
        root.right = helper(inorder, postorder, rootIdx+1, inEnd, postStart + leftSize, postEnd-1);
        return root;
    }
}


// class Solution {
//     public TreeNode buildTree(int[] inorder, int[] postorder) {
//         //TC: O(N^2) -> O(3N) for each recursive call and at worst case we might have n recursive calls
//         //SC: O(2N) for each recursive call and we have n recursive calls
//         //base
//         if(postorder.length == 0) return null;
//         //logic
//         //the last ele of the postorder is going to be the root
//         int rootVal = postorder[postorder.length - 1];
//         int rootIdx = -1; // this is on inorder array
//         TreeNode root = new TreeNode(rootVal);
//         //now finding the root val in the inorder arr so that we can get the left tree and the right tree
//         for(int i = 0; i < inorder.length; i++) { //O(n)
//             if(inorder[i] == rootVal) {
//                 rootIdx = i;
//                 break;
//             }
//         }
//         int[] inLeft = Arrays.copyOfRange(inorder, 0, rootIdx); //O(n)
//         int[] inRight = Arrays.copyOfRange(inorder, rootIdx+1, inorder.length);
//         int[] postLeft = Arrays.copyOfRange(postorder, 0, inLeft.length); //O(n)
//         int[] postRight = Arrays.copyOfRange(postorder, inLeft.length, postorder.length-1);

//         root.left = buildTree(inLeft, postLeft);
//         root.right = buildTree(inRight, postRight);

//         return root;
//     }
// }