/* TC: O(n) n: no. of nodes in the tree
 * SC: O(h+n) h:height of the tree for call stack. n: hashMap of inorder.length
 * Approach: Initially i will fill in the hashMap with Elements of inorder[] with its index 
 * so the search for the index is O(1). I will then recursively call my right and left subtress.
 * with the boundary for its left tree and right tree. 
 */


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
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer,Integer> hmap = new HashMap<>();

        for(int i =0; i< inorder.length; i++) hmap.put(inorder[i], i);

        int[] postIndex = {postorder.length - 1};
        return helper(hmap,postIndex, postorder, 0, inorder.length - 1);
    }


    private TreeNode helper(HashMap<Integer,Integer> hmap, int[] postIndex, int[] postorder, int start,int end){
        if(start > end) return null;
        int rootVal = postorder[postIndex[0]];
        postIndex[0]--;

        int index = hmap.get(rootVal);

        TreeNode root = new TreeNode(rootVal);

        root.right = helper(hmap, postIndex, postorder, index + 1, end);
        root.left = helper(hmap, postIndex, postorder, start ,  index - 1);

        return root;
    }
}