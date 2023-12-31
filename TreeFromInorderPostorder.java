//Time Complexity:O(n)
//SpaceComplexity:O(h) , h =Binary tree height
//construct tree from postorder, use inorder to find left and right subtrees and rescurse
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
    HashMap<Integer, Integer> inorderMap;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
         postorderIndex = postorder.length - 1;
        inorderMap = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            inorderMap.put(inorder[i], i);
        }
        return buildTree(postorder,0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] postorder,int inStart, int inEnd){
        // base
        if(inStart > inEnd)
            return null;

        // recursion
        TreeNode node = new TreeNode(postorder[postorderIndex]);
        postorderIndex--;

        int inorderIndex = inorderMap.get(node.val);
        node.right = buildTree(postorder,inorderIndex + 1, inEnd);
        node.left = buildTree(postorder,inStart, inorderIndex - 1);

        return node;
    }
}