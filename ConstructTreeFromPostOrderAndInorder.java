// Time Complexity : O(n)
// Space Complexity : O(n) - for map
// Did this code successfully run on Leetcode : Yes

import java.util.HashMap;
import java.util.Map;

public class ConstructTreeFromPostOrderAndInorder {

    public class TreeNode {
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

    int index;
    Map<Integer, Integer> map;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        map = new HashMap<>();
        index = postorder.length - 1;
        for(int i = 0; i < inorder.length ; i++){
            map.put(inorder[i], i);
        }
        return helper(postorder, 0 , postorder.length - 1);
    }


    //in post order - right tree's root will be fetched while traversing postorder arr
    //in pre order - left tree's root will be fetched while traversing preorder arr

    public TreeNode helper(int[] postorder, int start, int end){
        //base
        if(start > end) return null;

        //logic
        int rootVal = postorder[index];
        TreeNode root = new TreeNode(rootVal);
        index--;
        //find root in inorder
        int rootIndex = map.get(rootVal);

        //right subtree
        root.right = helper(postorder, rootIndex+1, end);

        //left subtree
        root.left = helper(postorder, start, rootIndex-1);

        return root;
    }
}
