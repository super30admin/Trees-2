// Time Complexity : O(n)
// Space Complexity : O(maxDepth)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.Arrays;
import java.util.HashMap;

public class BTPostIn {
    //With extra Space
    public TreeNode buildTreeExtraSpace(int[] inorder, int[] postorder) {
        if (postorder.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[postorder.length - 1]);

        int index = -1;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == root.val) {
                index = i;
            }
        }

        int[] inorder_left = Arrays.copyOfRange(inorder, 0, index);
        int[] postorder_left = Arrays.copyOfRange(postorder, 0, index);
        int[] inorder_right = Arrays.copyOfRange(inorder, index + 1, inorder.length);
        int[] postorder_right = Arrays.copyOfRange(postorder, index, postorder.length - 1);

        root.left = buildTree(inorder_left, postorder_left);
        root.right = buildTree(inorder_right, postorder_right);

        return root;
    }

    // Without copying arrays and adding hashmap
    HashMap<Integer, Integer> map = new HashMap<>();

    int currRoot;

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        currRoot = postorder.length - 1;

        for (int i = 0; i < inorder.length; i++) {
            // No duplicates, hence just put
            map.put(inorder[i], i);
        }

        return recurrence(inorder, postorder, 0, inorder.length - 1);

    }

    private TreeNode recurrence(int[] inorder, int[] postorder, int start, int end) {

        // base
        if (start > end || currRoot < 0) {
            return null;
        }

        // recursive case
        TreeNode root = new TreeNode(postorder[currRoot]);
        currRoot -= 1;

        int index = map.get(root.val);

        root.right = recurrence(inorder, postorder, index + 1, end);
        root.left = recurrence(inorder, postorder, start, index - 1);

        return root;

    }
}
