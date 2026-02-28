// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/*
Maintain a map to store the inorder array elements and their indices to understand the left and right elements
of root, once we identify the root from postorder array. We can have a helper method to get root element using
a pointer for each recursion and leverage that root element and map to find root's index. All the values before
that index in inorder array would be left and after the index is right. This way, we can construct the whole tree.
 */
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
    int index;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.index = postorder.length - 1;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0 ; i < inorder.length ; i++)
            map.put(inorder[i] , i);
        return helper(postorder, 0, postorder.length - 1, map);
    }

    private TreeNode helper(int[] postorder, int start, int end, Map<Integer, Integer> map) {
        if(start > end)
            return null;
        int rootVal = postorder[index];
        index--;

        int rootIndex = map.get(rootVal);
        TreeNode root = new TreeNode(rootVal);

        root.right = helper(postorder, rootIndex + 1, end, map);
        root.left = helper(postorder, start, rootIndex - 1, map);
        return root;
    }
}