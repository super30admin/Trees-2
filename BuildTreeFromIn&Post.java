//Time Complexity : O(n)
//Space Complexity: O(n)
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
    private int idx;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }  
        idx = postorder.length -1;      
        return helper(postorder, map, 0, inorder.length -1);
    }

    private TreeNode helper(int[] postorder, HashMap<Integer, Integer> map, int start, int end){
        if(start > end) return null;

        int rootVal = postorder[idx];
        idx--;
        TreeNode root = new TreeNode(rootVal);
        int rootIdx = map.get(rootVal);
        root.right = helper(postorder, map, rootIdx + 1, end);
        root.left = helper(postorder, map, start, rootIdx - 1);
 
        return root;        
    }
}
