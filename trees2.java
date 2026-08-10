//problem1
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length==0) return null;
        int rootval=postorder[postorder.length-1];
        int idx=-1;
        for(int i=0;i<inorder.length;i++){
            if(inorder[i]==rootval){
                idx=i;
                break;
            }
        }
        TreeNode root=new TreeNode(rootval);
        int[] inleft=Arrays.copyOfRange(inorder,0,idx);
        int[] inright=Arrays.copyOfRange(inorder,idx+1,inorder.length);
        int[] postleft=Arrays.copyOfRange(postorder,0,inleft.length);
        int[] postright=Arrays.copyOfRange(postorder,inleft.length,postorder.length-1);
        root.left=buildTree(inleft,postleft);
        root.right=buildTree(inright,postright);
        return root;
    }
}
//problem2
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
    public int sumNumbers(TreeNode root) {
        String ans="";
        if(root==null) return 0;
        return totalsum(root,ans);
    }
    private int totalsum(TreeNode root,String ans){
        int sum=0;
        if(root==null) return 0;
        ans+=root.val;
        if(root.left==null && root.right==null){
            return Integer.parseInt(ans);
        }
        return totalsum(root.left,ans)+totalsum(root.right,ans);
        
    }
}
