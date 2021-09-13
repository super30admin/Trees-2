package Trees2;
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


import Trees1.TreeNode;

import java.util.HashMap;

// Your code here along with comments explaining your approach
public class BuildTreeFromPostAndInorder {
    int idx;
    HashMap<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        idx = postorder.length-1;
        for(int i=0;i<inorder.length; i++){
            map.put(inorder[i], i);
        }
        return helper(postorder, 0, inorder.length-1);
    }
    private TreeNode helper(int[] postorder, int low, int high){
        if(low > high || idx < 0)
            return null;
        int rootIdx = map.get(postorder[idx]);
        TreeNode root = new TreeNode(postorder[idx--]);
        root.right = helper(postorder, rootIdx+1, high);
        root.left = helper(postorder, low, rootIdx-1);
        return root;
    }
}
