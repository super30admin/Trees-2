/* TC: O (n) where n is the number of nodes in the resulting tree
 * SC: O (n)
 *
 * Approach: Store the indices of the inorder array in a map
 * Iterate backwards over the postorder traversal, and for each node, create a root,
 * and build its right subtree by taking the root as the previous postorder index and the
 * tree from the range inorderIndex + 1, right
 * and the left subtree by taking the root from the previous postorder index,
 * and the tree from the range left, inorderIndex - 1;
 */
import java.util.HashMap;
import java.util.Map;

public class ConstructBST2 {
    //Definition for a binary tree node.
    public class TreeNode {
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

    int[] postorder;
    Map<Integer, Integer> inorderMap = new HashMap<>();
    int postorderIndex;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int i = 0;
        for (int inorderVal : inorder) {
            inorderMap.put(inorderVal, i++);
        }
        this.postorder = postorder;
        postorderIndex = postorder.length - 1;
        return build(0, inorder.length - 1);
    }

    private TreeNode build(int left, int right) {
        if (left > right) return null;

        // the tree's root is at the rightmost available value of postorder
        int rootVal = postorder[postorderIndex--];
        TreeNode root = new TreeNode(rootVal);

        // the right tree is given by all the values to the right in the inorder traversal
        root.right = build(inorderMap.get(rootVal) + 1, right);

        // the left tree is given by all the values to the left in the inorder traversal
        root.left = build(left, inorderMap.get(rootVal) - 1);

        return root;
    }

}
