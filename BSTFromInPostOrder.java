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
 /**This Java solution constructs a binary tree from inorder and postorder traversals:
Build a HashMap (map) to store the indices of values in the inorder traversal.
Use a recursive helper function (helper) to construct the binary tree based on the given postorder and inorder arrays.
Return the root of the constructed binary tree.
Time Complexity: O(N) - where N is the number of nodes in the binary tree, as each node is processed once.
Space Complexity: O(N) - for the HashMap storing indices.

  */
  class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return helper(map, postorder, 0, postorder.length-1, 0, inorder.length-1);
        
    }
    private TreeNode helper(HashMap<Integer, Integer> map, int[] postorder, int postleft, int postright, int inleft, int inright) {
    if (inleft > inright) return null;

    TreeNode root = new TreeNode(postorder[postright]);
    int idx = map.get(root.val);

    int leftTreeSize = idx - inleft;
    root.left = helper(map, postorder, postleft, postleft + leftTreeSize - 1, inleft, idx - 1);
    root.right = helper(map, postorder, postleft + leftTreeSize, postright - 1, idx + 1, inright);

    return root;
}

}