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
    HashMap<Integer,Integer> hm;
    int idx;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder==null || postorder==null || inorder.length==0){
            return null;
        }
        hm=new HashMap<>();
        int rootIdx=-1;
        idx=postorder.length-1;
        for(int i=0;i<inorder.length;i++){
            hm.put(inorder[i],i);
        }
        
        return recurse(postorder,inorder,0, postorder.length-1);
    }
    
    private TreeNode recurse(int[] postorder, int[] inorder,int start,int end){
        if(start>end){
            return null;
        }
        
        //logic
        int rootVal=postorder[idx--];
        TreeNode root=new TreeNode(rootVal);
        int rootIdx=hm.get(rootVal);
        root.right=recurse(postorder,inorder,rootIdx+1,end);
        root.left=recurse(postorder,inorder,start,rootIdx-1);
        return root;
    }
}