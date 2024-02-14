// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english
/*
 *
 */

// Your code here along with comments explaining your approach


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
class PostOrderInOrderBST {
    int pstOrdStartPos;

    public String toString(TreeNode node) {
        return "TreeNode [val=" + node.val + ", left=" + node.left + ", right=" + node.right + "]";
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // return helperBruteForcer(inorder, postorder);

        Map<Integer, Integer> hmap = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            hmap.put(inorder[i], i);
        }
        int n = inorder.length;
        pstOrdStartPos = n - 1;
        return helperoptimized(postorder, hmap, -1, 0, n - 1);
    }

    private TreeNode helperoptimized(int[] postorder, Map<Integer, Integer> hmap, int rootInOrdIdx, int inOrdStartPos,
            int inOrderEndPos) {
        // System.out.println(
        //         String.format("inOrdStartPos: %s    inOrderEndPos: %s     rootInOrdIdx: %s     pstOrdStartPos: %s",
        //                 inOrdStartPos, inOrderEndPos, rootInOrdIdx, pstOrdStartPos));

        if (inOrdStartPos > inOrderEndPos || pstOrdStartPos < 0) {
            return null;
        }

        int element = postorder[pstOrdStartPos];
        pstOrdStartPos--;

        TreeNode root = new TreeNode(element);
        rootInOrdIdx = hmap.get(element);
        root.right = helperoptimized(postorder, hmap, rootInOrdIdx, rootInOrdIdx + 1, inOrderEndPos);
        root.left = helperoptimized(postorder, hmap, rootInOrdIdx, inOrdStartPos, rootInOrdIdx - 1);

        return root;
    }

    private TreeNode helperBruteForcer(int[] inorder, int[] postorder) {

        if (postorder.length == 0) {
            return null;
        }
        int pstOrdlen = postorder.length;
        int inOrdlen = inorder.length;
        int pstOrdPos = pstOrdlen - 1;
        int rootElement = postorder[pstOrdPos];
        TreeNode root = new TreeNode(rootElement);
        int inOrdPos = -1;

        for (int i = 0; i < inOrdlen; i++) {
            if (inorder[i] == rootElement) {
                inOrdPos = i;
            }
        }

        int[] inLeft = Arrays.copyOfRange(inorder, 0, inOrdPos);
        int[] inRight = Arrays.copyOfRange(inorder, inOrdPos + 1, inOrdlen);

        int[] pstLeft = Arrays.copyOfRange(postorder, 0, pstOrdPos - inRight.length);
        int[] pstRight = Arrays.copyOfRange(postorder, pstOrdPos - inRight.length, pstOrdPos);

        root.left = helperBruteForcer(inLeft, pstLeft);
        root.right = helperBruteForcer(inRight, pstRight);

        return root;
    }
}