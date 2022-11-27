//TC is O(n)
//SC is O(n)
class Solution {
    int idx;
    HashMap<Integer, Integer> map;

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        if (inorder == null || postorder == null || inorder.length == 0 || postorder.length == 0
                || postorder.length != inorder.length) {
            return null;
        }

        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        idx = postorder.length - 1;

        return recurse(inorder, postorder, 0, postorder.length - 1);

    }

    private TreeNode recurse(int[] inorder, int[] postorder, int startIdx, int endIdx) {
        // base case
        if (startIdx > endIdx) {
            return null;
        }

        // recurse

        int rootVal = postorder[idx];
        idx--;
        int rootIdxInInorder = map.get(rootVal);
        System.out.println(rootIdxInInorder);
        TreeNode root = new TreeNode(rootVal);
        root.right = recurse(inorder, postorder, rootIdxInInorder + 1, endIdx);
        root.left = recurse(inorder, postorder, startIdx, rootIdxInInorder - 1);

        return root;

    }
}