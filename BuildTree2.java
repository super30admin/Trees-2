import java.util.HashMap;
import java.util.Map;

/**
 * @author Vishal Puri
 * // Time Complexity : O(n)
 * // Space Complexity : O(n)
 * // Did this code successfully run on Leetcode : Yes
 * // Any problem you faced while coding this :
 */

public class BuildTree2 {
    int rootCounter;
    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        rootCounter = postorder.length - 1;
        return helper(0, inorder.length - 1, postorder);
    }

    public TreeNode helper(int start, int end, int[] postorder) {
        if (start > end) return null;
        if (rootCounter < 0) return null;

        TreeNode root = new TreeNode(postorder[rootCounter]);
        rootCounter--;

        int rootIndexInorder = map.get(root.val);

        root.right = helper(rootIndexInorder + 1, end, postorder);
        root.left = helper(start, rootIndexInorder - 1, postorder);
        return root;
    }
}
