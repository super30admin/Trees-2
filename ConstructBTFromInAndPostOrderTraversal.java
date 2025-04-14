import java.util.HashMap;
/**
 * Time complexity: O(n)
 * Space complexity: O(n)
 * Ran on leetcode? Yes
 * Issues faced? No
 *
 * Approach:
 * 1. Use map to store inorder list with its indexes, which can later
 * be used to form left and right subtree when root is known.
 * 2. From postorder list, determine the root which is the last element in the list and create a root TreeNode.
 * 3. Recursively create right and left subtree for that root.
 * 4. The base condition is when start goes beyond end.
 * 5. This utilizes the property that for binary tree every root node
 * there would be either a null or non-null children
 */
public class ConstructBTFromInAndPostOrderTraversal {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    int index;
    // To store the positions of inorder traversal values
    HashMap<Integer, Integer> map;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        index = postorder.length - 1;
        map = new HashMap<>();
        for (int i = 0; i < inorder.length;i++) {
            map.put(inorder[i], i);
        }

        return createTree(postorder, 0, postorder.length - 1);
    }

    private TreeNode createTree(int[] postorder, int start, int end) {
        // base
        if (start > end) {
            return null;
        }
        // logic
        int rootVal = postorder[index];
        index--;
        int rootIdxInMap = map.get(rootVal);

        TreeNode root = new TreeNode(rootVal);
        root.right = createTree(postorder, rootIdxInMap + 1, end);
        root.left = createTree(postorder, start, rootIdxInMap - 1);
        return root;
    }
}
