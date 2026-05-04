// time complexity: O(n)
// space complexity : O(n)
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
    int idx;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i],i);
        }
        this.idx=postorder.length-1;
        return helper(postorder,0,postorder.length-1,map);
    }
    private TreeNode helper(int[] postorder, int st, int end, HashMap<Integer, Integer> map){
        //base 
        if(st>end) return null; //--> this works because we need null in cases the values are missing 
        //logic
        int rootVal = postorder[idx];
        idx--;
        TreeNode root= new TreeNode(rootVal);
        int rootIdx= map.get(rootVal);
        //right
        root.right = helper(postorder,rootIdx+1,end,map); 
        //left
        root.left = helper(postorder,st, rootIdx-1,map); 
        return root;
    }
}