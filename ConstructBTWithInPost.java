/*
 * Time Complexity : O(n^2)
 * Space Complexity :  O(h)
 * Did this code successfully run on Leetcode : yes
 * Any problem you faced while coding this : No
 * 
 * Approach - Since we are given postorder, the last element is the root of the tree. We then create a map with the elements in inorder along with their indices to create the root's 
 * left inorder and postorder and the root's right inorder and postorder. For every  node we recursively pass it's inorder array and post order array for its left and right child. 
 */

//https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal

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
class ConstructBTWithInPost {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer,Integer> map = new HashMap<>();
        if(postorder.length==0)return null;
        int rootVal = postorder[postorder.length-1];
        TreeNode root = new TreeNode(rootVal);
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        int idx= map.get(rootVal);
        int[] inLeft = Arrays.copyOfRange(inorder,0,idx);
        int[] inRight = Arrays.copyOfRange(inorder,idx+1,inorder.length);
        int[] postLeft = Arrays.copyOfRange(postorder,0,idx);
        int[] postRight = Arrays.copyOfRange(postorder,idx,idx+inRight.length);

        root.left= buildTree(inLeft,postLeft);
        root.right=buildTree(inRight,postRight);
        return root;
    }
}