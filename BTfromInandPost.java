// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english

// Your code here along with c`omments explaining your approach
/*
 * To optimize above approach we use hashmap for inorder and start and end pointer for postorder. idx tracks root node
 * of subtree. We then calculate start and end index from map and call recursively on right and left 
 * subtree and return root. 
*/

import java.util.HashMap;

public class BTfromInandPost {
    HashMap<Integer, Integer> map; 
    int idx;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder == null || postorder.length < 1 || inorder == null || inorder.length < 1) {
            return null;
        }
        map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        idx = postorder.length - 1;
        return helper(postorder, 0, postorder.length - 1);
    }
    private TreeNode helper(int[] postorder, int start, int end) {
    //Base case
        if(start > end) {
            return null;
        }
        int rootVal = postorder[idx];
        idx--;
        TreeNode root = new TreeNode(rootVal);
        int rootIdx = map.get(rootVal);
        root.right = helper(postorder, rootIdx + 1, end);
        root.left = helper(postorder, start, rootIdx - 1);
        return root;
    }
}
