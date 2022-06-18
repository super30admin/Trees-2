// Time Complexity : O(n^2)
// Space Complexity : O(n^2)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

import java.util.*;

class BuildTree {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder.length==0) return null;
        //Finding the first root node
        int rootVal = postorder[postorder.length-1];
        int rootIdx = -1;
        for(int i=0;i<inorder.length;i++){
            if(inorder[i]==rootVal){
                rootIdx = i;
            }
        }

        TreeNode root = new TreeNode(rootVal);
        //dividing the inorder array into left and right based on root index!
        int [] inLeft = Arrays.copyOfRange(inorder, 0, rootIdx);
        int [] inRight = Arrays.copyOfRange(inorder, rootIdx+1, inorder.length);
        int [] postLeft = Arrays.copyOfRange(postorder, 0, inLeft.length);
        int [] postRight = Arrays.copyOfRange(postorder, postLeft.length, postorder.length-1);

        root.left = buildTree(inLeft, postLeft);
        root.right = buildTree(inRight, postRight);
        return root;
    }
} 