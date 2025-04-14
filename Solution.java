

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

    int postorderIndex;
    HashMap<Integer, Integer> map;
    public TreeNode buildTree(int[] inorder, int[] postorder) {

        this.postorderIndex = postorder.length -1;
        this.map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }

        return helper(postorder, postorder.length - 1, 0);

    }

    private TreeNode helper(int[] postorder, int right, int left)
    {
        if(right < left) return null;

        int rootValue = postorder[postorderIndex--];
        TreeNode root = new TreeNode(rootValue);
        int index = map.get(rootValue);

        root.right = helper(postorder, right, index+1);
        root.left = helper(postorder, index -1, left);

        return root;

    }
}