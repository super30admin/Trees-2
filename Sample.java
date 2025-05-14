// Time Complexity: O(n), where n is the number of nodes
//   - Each node is processed once, and inorder index lookup is O(1)
// Space Complexity: O(n) for the map + O(h) recursion stack (h = tree height)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
class Solution {
    private Map<Integer, Integer> inorderIndexMap;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // Build value -> index map for inorder traversal
        inorderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        // Start recursion
        return buildTree(inorder, 0, inorder.length - 1,
                         postorder, 0, postorder.length - 1);
    }

    private TreeNode buildTree(int[] inorder, int inStart, int inEnd,
                               int[] postorder, int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }

        // The last element in postorder is the root
        int rootVal = postorder[postEnd];
        TreeNode root = new TreeNode(rootVal);

        // Find root index in inorder array using map
        int rootIndex = inorderIndexMap.get(rootVal);

        // Number of elements in left subtree
        int leftSize = rootIndex - inStart;

        // Construct left and right subtrees
        root.left = buildTree(inorder, inStart, rootIndex - 1,
                              postorder, postStart, postStart + leftSize - 1);

        root.right = buildTree(inorder, rootIndex + 1, inEnd,
                               postorder, postStart + leftSize, postEnd - 1);

        return root;
    }
}


// Time Complexity: O(n), where n is the number of nodes in the tree
//   - Each node is visited once
// Space Complexity: O(h), where h is the height of the tree (recursion stack)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }

    private int helper(TreeNode root, int sum) {
        if (root == null) return 0;

        // If it's a leaf node, return the complete number formed
        if (root.left == null && root.right == null) {
            return sum * 10 + root.val;
        }

        // Recurse left and right, accumulating the value
        int leftSum = helper(root.left, sum * 10 + root.val);
        int rightSum = helper(root.right, sum * 10 + root.val);

        return leftSum + rightSum;
    }
}
