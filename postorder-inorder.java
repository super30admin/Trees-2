import java.util.HashMap;
import java.util.Map;

// Time Complexity :O(2n) n is the number of nodes
// Space Complexity :O(1) 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
class Solution {
    Map<Integer, Integer> map;
    int idx;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || inorder.length == 0)
            return null;
        map = new HashMap();
        idx = postorder.length - 1;
        // populate map
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(postorder, 0, postorder.length - 1);
    }

    private TreeNode helper(int[] postorder, int start, int end) {
        if (start > end)
            return null;
        // get root
        int rootVal = postorder[idx];
        idx--;
        TreeNode root = new TreeNode(rootVal);
        // rootIndex
        int rootIdx = map.get(rootVal);
        root.right = helper(postorder, rootIdx + 1, end); /// starting from end of postorder...gives us root right
                                                          /// left...so root and then root of right subtree.
        root.left = helper(postorder, start, rootIdx - 1);
        return root;
    }
}
