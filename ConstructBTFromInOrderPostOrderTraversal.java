import java.util.HashMap;

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
    /*
        SC - O(n)
        TC - O(n)
        This solution reconstructs the binary tree using the inorder and postorder traversals. 
        A HashMap stores the index of each value in the inorder array for quick lookup. 
        Starting from the end of the postorder array, each value is taken as the root of the current subtree. 
        The root's position in the inorder array splits the tree into left and right subtrees. 
        Since the postorder array is processed backwards (Root → Right → Left), the right subtree is built 
        first, followed by the left subtree. The recursion continues until there are no nodes left in 
        the current inorder range.
    */
    HashMap<Integer, Integer> map;
    int idx;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.map = new HashMap<>();
        for (int i = 0; i< inorder.length; i++) {
            map.put(inorder[i], i);
        }
        this.idx = postorder.length - 1;
        return helper(postorder, 0, postorder.length - 1);
    }

    private TreeNode helper(int[] postorder, int start, int end) {
        if (start > end) {
            return null;
        }

        int rootVal = postorder[this.idx];
        this.idx--;
        int rootIdx = map.get(rootVal);
        
        TreeNode node = new TreeNode(rootVal);
        node.right = helper(postorder, rootIdx + 1, end);
        node.left = helper(postorder, start, rootIdx - 1);

        return node;
    }
}