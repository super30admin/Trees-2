// TC : O(n)
// SC : O(1)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    int idx;
    Map<Integer, Integer> map;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.map = new HashMap<>();
        this.idx = inorder.length - 1; // Assigning idx to the last index value.
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(postorder, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] postorder, int start, int end) {
        // Base
        if (start > end)
            return null; // When leaf node is reached.

        // Logic
        int val = postorder[idx]; // get value from the postorder index
        idx--; // decrement index so we fetch next element from the postorder
        TreeNode node = new TreeNode(val); // add to a node
        int rootIdx = map.get(val); // get the root index to get value of next root from the map.

        // Left Subtree start and end positions
        int leftStart = start;
        int leftEnd = rootIdx - 1;

        // Right Sub Tree start and end positions
        int rightStart = rootIdx + 1;
        int rightEnd = end;

        // Right - Start with the right tree since this is the postorder traversal
        node.right = helper(postorder, rightStart, end);

        // Left
        node.left = helper(postorder, leftStart, leftEnd);

        return node;
    }
}
