import java.util.Arrays;
// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
//
// Your code here along with comments explaining your approach
// 1 . used the method discussed by ashmeet to build tree from inorder and preorder
public class buildTreeFromInAndPost {
    public static class TreeNode {
        int val;
       TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private static TreeNode buildTree(int[] inorder,int[] postorder){
        if(postorder.length == 0) return null;
        TreeNode root = new TreeNode(postorder[postorder.length - 1]);
        if(postorder.length == 1) return root;
        int breakindex = postorder.length;
        for(int i = inorder.length-1;i>=0;i--){
            if(inorder[i] == root.val){
                breakindex = i;
                break;
            }
        }
        int[] postleft = Arrays.copyOfRange(postorder,0,breakindex);
        int[] postright = Arrays.copyOfRange(postorder,breakindex,postorder.length-1);
        int[] inleft = Arrays.copyOfRange(inorder,0,breakindex);
        int[] inright = Arrays.copyOfRange(inorder,breakindex+1,inorder.length);
        root.left = buildTree(inleft,postleft);
        root.right = buildTree(inright,postright);
        return root;
    }
    public static void main(String[] args) {
        int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};
        TreeNode root = buildTree(inorder,postorder);
        
    }
}
