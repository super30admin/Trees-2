package S30.Trees_2;

/*
Time Complexity : O(n) - touching every node
Space Complexity : O(n)[hashmap size] + O(h)[stackframe height]
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None
*/

import java.util.HashMap;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {

    class TreeNode {
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

    int postorderIdx;
    public TreeNode buildTree(int[] inorder, int[] postorder) {

        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i],i);
        }
        postorderIdx = postorder.length - 1;
        return build(inorder,postorder,map,0,inorder.length - 1);
    }

    public TreeNode build(int[] inorder, int[] postorder, HashMap<Integer,Integer> map,int left, int right){

        if(left > right) return null;

        int root = postorder[postorderIdx];
        TreeNode node = new TreeNode(root);

        postorderIdx --;

        int index = map.get(root);
        node.right = build(inorder,postorder,map,index+1,right);
        node.left = build(inorder,postorder,map,left,index-1);

        return node;

    }


}
