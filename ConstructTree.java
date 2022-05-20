import java.util.Map;
import javax.swing.tree.TreeNode;

// Time Complexity : O(n)
// Space Complexity : O(n), entire tree
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int[] postorder;
    int[] inorder;
    int postIndex;
    
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.postorder = postorder;
        this.inorder = inorder;
        
        postIndex = postorder.length - 1;
        int index = 0;
        // hashmap (value --> its index) for inorder traversal
        for (Integer val: inorder){
            map.put(val, index);
            index++;
        }
        return helper(0, inorder.length - 1); // return helper with left and right boundaries for current subtree of inorder
    }
    
    public TreeNode helper(int left, int right){
        if (left > right) return null;
        
        int rootVal = postorder[postIndex];
        TreeNode root = new TreeNode(rootVal);
        
        int idx = map.get(rootVal);
        
        postIndex--;
        root.right = helper(idx + 1, right);
        root.left = helper(left, idx - 1);
        return root;
    }
    
}