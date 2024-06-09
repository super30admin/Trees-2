/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int rootIndex;
    HashMap<Integer, Integer> map;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || inorder.length == 0 || postorder == null || postorder.length == 0) {
            return null;
        }
        // int rootIndex = -1;

        // int rootVal = postorder[postorder.length - 1];
        // TreeNode root = new TreeNode(rootVal);
        // for(int i = 0; i < inorder.length; i++) {
        //     if(rootVal == inorder[i]) {
        //         rootIndex = i;
        //         break;
        //     }
        // }

        // System.out.println(rootIndex);
        // int[] inorderLeft = Arrays.copyOfRange(inorder, 0, rootIndex);
        // int[] inorderRight = Arrays.copyOfRange(inorder, rootIndex + 1, inorder.length);
        // int[] postorderLeft = Arrays.copyOfRange(postorder, 0, postorder.length - inorderRight.length - 1);
        // int[] postorderRight = Arrays.copyOfRange(postorder, postorder.length - inorderRight.length - 1, postorder.length - 1);

        // root.right = buildTree(inorderRight, postorderRight);
        // root.left = buildTree(inorderLeft, postorderLeft);
        
        // return root;


        // using recursion
        rootIndex = postorder.length - 1;
        map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return dfs(postorder, 0, postorder.length - 1);
    }

    private TreeNode dfs(int[] postorder, int start, int end) {
        if(start > end) {
            return null;
        }
        int rootVal = postorder[rootIndex];
        rootIndex--;
        TreeNode root = new TreeNode(rootVal);
        int inorderRootIdx = map.get(rootVal);
        root.right = dfs(postorder, inorderRootIdx + 1, end);
        root.left = dfs(postorder, start, inorderRootIdx - 1);
        return root;
    }
}
