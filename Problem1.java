// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : YES
// Three line explanation of solution in plain english

// Your code here along with comments explaining your approach

/**
 * We can get the root from postorder array. The root will be the last element in the
 * postorder array. Find that element's index in the inorder array. Everything left to
 * that index will be inLeft and everything right to it will be inRight.
 * The postLeft will be 0 -> inLeft.length and postRight will be postLeft.length -> index
 * Now we have separated the elements in the left and right subtree and can perform recursion
 * to build this tree
 */

/**
 * We can optimize on the space by having the pointers on the inorder arrays.
 * But here we will go right first as this postorder is left, right, root.
 */
public class Problem1 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {

        if (postorder == null || inorder == null || postorder.length == 0 || inorder.length == 0) return null;

        int rootIdx = postorder.length - 1;
        int rootVal = postorder[rootIdx];
        TreeNode root = new TreeNode(rootVal);

        if (postorder.length == 1) {
            return root;
        }

        int inRootIdx = -1;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootVal) {
                inRootIdx = i;
                break;
            }
        }
        if (inRootIdx == -1) return null;

        int[] inLeft = Arrays.copyOfRange(inorder, 0, inRootIdx);
        int[] inRight = Arrays.copyOfRange(inorder, 1 + inRootIdx, inorder.length);
        int[] postLeft = Arrays.copyOfRange(postorder, 0, inLeft.length);
        int[] postRight = Arrays.copyOfRange(postorder, postLeft.length, rootIdx);

        root.left = buildTree(inLeft, postLeft);
        root.right = buildTree(inRight, postRight);

        return root;
    }

    static class Problem1Optimized {
        private Map<Integer, Integer> map;
        private int idx;

        public TreeNode buildTree(int[] inorder, int[] postorder) {
            this.map = new HashMap<>();
            idx = postorder.length - 1;

            for (int i = 0; i < inorder.length; i++) {
                map.put(inorder[i], i);
            }

            return helper(0, inorder.length - 1, postorder);
        }

        private TreeNode helper(int start, int end, int[] postorder) {
            //base
            if (start > end) return null;
            if (idx < 0) return null;

            //logic
            int rootVal = postorder[idx];
            int rootIdx = map.get(rootVal);
            idx--;

            TreeNode root = new TreeNode(rootVal);


            root.right = helper(rootIdx + 1, end, postorder);
            root.left = helper(start, rootIdx - 1, postorder);


            return root;

        }
    }
}
