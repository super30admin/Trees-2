// Space Complexity: O(n)
// Time Complexity: O(n)

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
    HashMap<Integer, Integer> map;
    int index;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        map = new HashMap<>();
        index = inorder.length - 1;
        for(int i=0; i< inorder.length; i++){
            map.put(inorder[i], i);
        }
        return helper(postorder, 0, inorder.length - 1);
    }
    public TreeNode helper(int[] postorder, int sIndex, int eIndex){
        if(sIndex > eIndex) return null;
        int rootVal = postorder[index];
        TreeNode root = new TreeNode(rootVal);
        index--;
        int rootIndex = map.get(rootVal);
        root.right = helper(postorder, rootIndex+1, eIndex);
        root.left = helper(postorder, sIndex, rootIndex-1);
        
        return root;
        
    }
}