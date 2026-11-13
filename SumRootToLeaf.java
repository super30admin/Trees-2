/**
 * Time Complexity:  O(n)  where n is the length of the array
 * Space Complexity: O(n) where n is the length of the array
 */

class Solution {
    int preIndex = 0;
    Map<Integer, Integer> nodeToPositionInorder;

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        nodeToPositionInorder = constructMapping(inorder);

        return constructTree(preorder, 0, preorder.length - 1);
    }

    Map<Integer, Integer> constructMapping(int[] arr) {
        Map<Integer, Integer> nodeToPosition = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            nodeToPosition.put(arr[i], i);
        }

        return nodeToPosition;
    }

    TreeNode constructTree(int[] preorder, int left, int right) {
        if (left > right) {
            return null;
        }

        int rootVal = preorder[preIndex++];

        TreeNode root = new TreeNode(rootVal);

        int posInorder = nodeToPositionInorder.get(rootVal);

        root.left = constructTree(preorder, left, posInorder - 1);

        root.right = constructTree(preorder, posInorder + 1, right);

        return root;

    }
}