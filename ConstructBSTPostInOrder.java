class Solution {

    HashMap<Integer, Integer> map = new HashMap<>();
    int index;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        index = postorder.length - 1;

        if (postorder.length == 0) {
            return null;
        }

        for (int i=0; i<inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return helper(postorder, 0, index);

    }

    private TreeNode helper(int[] postorder, int start, int end) {

        if (start > end) {
            return null;
        }

        int rootVal = postorder[index];
        TreeNode root = new TreeNode(rootVal);
        index--;
        int rootIndex = map.get(rootVal);


        root.right = helper(postorder, rootIndex + 1, end);
        root.left = helper(postorder, start, rootIndex - 1);
        //The right goes first since the new head that was obtained by decrementing postorder index is head of right tree since post order is left, right root

        return root;

    }
}