// Time Complexity - O(n)
// Space Complexity - O(h)
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
    HashMap<Integer,Integer> map;
    int idx;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        map = new HashMap<>();
        idx = postorder.length-1;
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return helper(postorder, 0, inorder.length-1);
    }

    private TreeNode helper(int[] postorder, int start, int end){
        // base
        if(start>end) return null; //why return null
        // logic
        int postRoot = postorder[idx];
        idx--;
        TreeNode root = new TreeNode(postRoot);
        int inRootIdx = map.get(postRoot);
        root.right = helper(postorder,inRootIdx+1,end);
        root.left = helper(postorder,start,inRootIdx-1);
        return root;
    }
}