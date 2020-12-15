// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach

import java.util.*;
class ConstructBTFromPostOrder {
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
    HashMap<Integer, Integer> map;
    int idx;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || inorder.length==0)
            return null;
        map = new HashMap<>();
        for(int i=0; i<inorder.length; i++) {
            map.put(inorder[i], i);
        }
        idx = postorder.length-1;
        return helper(postorder, 0, inorder.length-1);
    }
    
    private TreeNode helper(int[] postorder, int start, int end) {
        if(start>end)
            return null;
        
        int rootval = postorder[idx];
        idx--;
        int rootidx = map.get(rootval);
        TreeNode root = new TreeNode(rootval);
        root.right = helper(postorder, rootidx+1, end);
        root.left = helper(postorder, start, rootidx-1);
        return root;
    }
}