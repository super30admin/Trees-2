// Time Complexity : O(n^2)), 
// Space Complexity : O(n^2),
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :    No
//using postorder and inorder
import java.util.*;
public class PostOrderTree {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
       //check if postorder is empty
        if(postorder.length == 0) return null;
        int rootVal = postorder[postorder.length - 1];
        int rootIdx = 0;
        TreeNode root = new TreeNode(rootVal);
        for(int i = 0; i < inorder.length; i++){
            if(inorder[i] == rootVal){
                rootIdx = i;
            }
        }
        int [] postLeft = Arrays.copyOfRange(postorder, 0, rootIdx);
        int [] postRight = Arrays.copyOfRange(postorder, rootIdx, (postorder.length -1));
        int [] inLeft = Arrays.copyOfRange(inorder, 0, rootIdx);
        int [] inRight = Arrays.copyOfRange(inorder,rootIdx + 1, inorder.length);
        root.left = buildTree(inLeft, postLeft);
        root.right = buildTree(inRight, postRight);    
        return root;
    }       
}
