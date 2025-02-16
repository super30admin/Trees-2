// Time Complexity : O(n) where n is the length
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//
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
class ConstructTree {
    int idx;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder.length == 0){
            return null;
        }
        idx = postorder.length-1;
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }

        return helper(inorder, postorder, map, 0, inorder.length-1);
    }

    private TreeNode helper(int[] inorder, int[] postorder, Map<Integer, Integer> map, int start, int end){
        if(start > end){
            return null;
        }

        int val = postorder[idx];
        idx--;

        TreeNode root = new TreeNode(val);
        int rootIdx = map.get(val);


        root.right = helper(inorder, postorder, map, rootIdx+1, end);
        root.left = helper(inorder, postorder, map, start, rootIdx-1);

        return root;
    }
}