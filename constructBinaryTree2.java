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
    //Time complexity: O(n)
    //Space complexity: O(n)
    Map<Integer,Integer> hm;
    int idx;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        hm=new HashMap<>();
        idx=postorder.length-1;
        for(int i=0;i<inorder.length;i++){
            hm.put(inorder[i],i);
        }
        return helper(postorder,0,postorder.length-1);
    }
    private TreeNode helper(int[] postorder,int s,int e){
        if(s>e)
            return null;
        int rootVal=postorder[idx];
        TreeNode root=new TreeNode(rootVal);
        idx--;
        int rootIdx=hm.get(root.val);
        root.right=helper(postorder,rootIdx+1,e);
        root.left=helper(postorder,s,rootIdx-1);
        return root;
    }
}