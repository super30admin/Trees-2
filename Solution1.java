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
/*
    Time Complexity : O(n)
    Space Complexity : O(n)
*/
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
       return construct(postorder, inorder, 0, postorder.length-1, 0, inorder.length-1);
    }
    
    public TreeNode construct(int[] preo, int[] ino, int psi, int pei, int isi, int iei){
        if(isi > iei || psi > pei){
            return null;
        }
        
        int rootEle = preo[pei];
        int sidx = -1;
        for(int i=isi; i<=iei; i++){
            if(ino[i]==rootEle){
                sidx = i;
                break;
            }
        }
        int cle = sidx - isi;
        TreeNode root = new TreeNode(rootEle);
                root.right = construct(preo, ino, psi + cle, pei - 1, sidx + 1, iei);

        root.left = construct(preo, ino, psi, psi +  cle - 1, isi, sidx - 1);
        return root;      
        
    }
}
