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

// Approach - 1
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // T.C : O(n power 2)
        // S.C: O(n)
        // Executed
        if (inorder == null || inorder.length == 0 || postorder.length == 0)
            return null;
        int rootVal = postorder[postorder.length - 1];
        TreeNode node = new TreeNode(rootVal);
        int rootidx = -1;
        
        for (int i = 0; i < inorder.length; i++) {
            if (rootVal == inorder[i]) {
                rootidx = i;
                break;
            }
        }
        
        int[] inorderLeft = Arrays.copyOfRange(inorder, 0, rootidx);
        int[] inorderRight = Arrays.copyOfRange(inorder, rootidx + 1, inorder.length);
        
        int[] postorderLeft = Arrays.copyOfRange(postorder, 0, rootidx);
        int[] postorderRight = Arrays.copyOfRange(postorder, rootidx, postorder.length - 1);
        
        node.left = buildTree(inorderLeft, postorderLeft);
        node.right = buildTree(inorderRight, postorderRight);
        
        return node;
     }
}

// Approach - 2
// T.C and S.C: O(n)
// Executed
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
    HashMap<Integer, Integer> map;
    int index;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || inorder.length == 0 || postorder.length == 0)
            return null;
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        index = postorder.length-1;
        return helper(inorder, postorder, 0, postorder.length-1);
    }
    
    private TreeNode helper(int[] inorder, int[] postorder, int start, int end) {
        if (start > end)
            return null;
        
        TreeNode root = new TreeNode(postorder[index--]);
        int rootIdx = map.get(root.val);
        
        root.right = helper(inorder, postorder, rootIdx+1, end);
        root.left = helper(inorder, postorder, start, rootIdx-1);
        
        return root;
    }
}