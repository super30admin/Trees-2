//DFS bruteforce
//T.C=O(N^2)
//S.C=O(N^2)
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
    int index;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder==null || inorder==null || postorder.length==0)return null;
        int rootVal=postorder[postorder.length-1];
        TreeNode root=new TreeNode(rootVal);
        int size=inorder.length;
        for(int i=0;i<size;i++){
            if(inorder[i]==rootVal){
                index=i;
                break;
            }
        }
        
        int[]leftPostOrder=Arrays.copyOfRange(postorder,0,index);
        int[]rightPostOrder=Arrays.copyOfRange(postorder,index,postorder.length-1);
        int[]leftInOrder=Arrays.copyOfRange(inorder,0,index);
        int[]rightInOrder=Arrays.copyOfRange(inorder,index+1,inorder.length);
            root.left=buildTree(leftInOrder,leftPostOrder);
            root.right=buildTree(rightInOrder,rightPostOrder);
        return root;
    }
    
}
