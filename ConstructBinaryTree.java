// TC - O(n)
// SC - O(n)

import java.util.*;

public class ConstructBinaryTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    int idx;
    HashMap<Integer,Integer> map;
    public TreeNode buildTree(int[] inorder, int[] postorder) {

        idx = postorder.length -1;
        //null check
        if(postorder == null || postorder.length == 0)
            return null;

        map = new HashMap<>();

        for(int i = 0 ; i< inorder.length ; i++){
            map.put(inorder[i],i);
        }

        return helper(postorder,0,inorder.length-1);
    }

    private TreeNode helper(int[] postorder,int start, int end){

        //base case
        if(start > end)
            return null;

        //logic
        int rootVal = postorder[idx];
        int rootIdx = map.get(rootVal);
        idx--;

        TreeNode root = new TreeNode(rootVal);

        root.right = helper(postorder,rootIdx+1,end);
        root.left = helper(postorder,start,rootIdx-1);

        return root;
    }
}
