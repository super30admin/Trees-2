import java.util.HashMap;
import java.util.Map;
// LC 106

/**
 * Dry Run by constructing a tree and writing its inorder and preorder.
 * <p>
 * Now, using the postorder and inorder, try to construct the tree.
 * <p>
 * Postorder == LRRoot
 * so, each index from the rear end is a Root and the left content == LR of this Root
 * <p>
 * Inorder == LRootR
 * If we find the index of the postorder.root.val in inorder, say it rootIndex.
 * Then, left of rootIndex == Left subtree of Root, and
 * right of rootIndex == Right subtree of Root
 * <p>
 * Make sure to stay within bounds of the new subtree in the inorder list.
 * <p>
 * We can start with n-1 to 0.
 * Current Node = start, end
 * Left subtree = (start, rootIndex-1)
 * Right subtree = (rootIndex+1, end)
 * <p>
 * NOTE: We know O(1) search can easily be achieved by hashing.
 * So, hash the inorder values to its index.
 * <p>
 * If values are distinct, this approach won't work, and we have to follow the linear search within [start, end].
 */
public class ConstructTree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * TC: O(n) + O(n) for searching
     * SC: O(h), h == n for skewed trees
     *
     * @param postorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] postorder, int[] inorder) {
        int n = postorder.length;
        return buildTree(postorder, inorder, 0, n - 1, new int[]{n - 1});
    }

    TreeNode buildTree(int[] postorder, int[] inorder, int start, int end, int[] index) {
        // NOTE: start is always increasing
        // NOTE: end is always decreasing
        if (index[0] < 0 || start > end) {
            index[0]++;
            return null;
        }
        int val = postorder[index[0]];
        TreeNode root = new TreeNode(val);
        // if values are not distinct
        int rootIndex = findRootInOrder(inorder, val, start, end);
        index[0]--;
        // L <-- R <-- Root
        root.right = buildTree(postorder, inorder, rootIndex + 1, end, index);
        index[0]--;
        root.left = buildTree(postorder, inorder, start, rootIndex - 1, index);
        return root;
    }

    int findRootInOrder(int[] inorder, int val, int start, int end) {
        while (start <= end && inorder[start] != val) {
            start++;
        }
        return start;
    }

    /**
     * TC: O(n)
     * SC: O(h) + O(n) for hashmap, h == n for skewed trees
     */
    public TreeNode buildTree_optimised(int[] inorder, int[] postorder) {
        Map<Integer, Integer> valIndexMap = hashValues(inorder);
        int n = postorder.length;
        return buildTree(postorder, valIndexMap, 0, n - 1, new int[]{n - 1});
    }

    Map<Integer, Integer> hashValues(int[] inorder) {
        Map<Integer, Integer> valIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            valIndexMap.put(inorder[i], i);
        }
        return valIndexMap;
    }

    TreeNode buildTree(int[] postorder, Map<Integer, Integer> inorder, int start, int end, int[] index) {
        if (index[0] < 0 || start > end) {
            index[0]++;
            return null;
        }
        int val = postorder[index[0]];
        TreeNode root = new TreeNode(val);
        int rootIndex = inorder.get(val);
        // if values are not distinct
        // int rootIndex = findRootInOrder(inorder, val, start, end);
        index[0]--;
        // L <-- R <-- Root
        root.right = buildTree(postorder, inorder, rootIndex + 1, end, index);
        index[0]--;
        root.left = buildTree(postorder, inorder, start, rootIndex - 1, index);

        return root;
    }

}
