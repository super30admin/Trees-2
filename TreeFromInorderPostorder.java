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

/**

inorder =   [9,3,15,20,7]
postorder = [9,15,7,20,3]

inorder - LNR
postorder - LRN

range = left -> right.

TC - O(N) where N is the length of an postorder array.
SC - O(N) where N is the size of map.

**/
class Solution {
    
    private int postorderIndex;
    private Map<Integer, Integer> valToIndex = new HashMap<>();
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        postorderIndex = postorder.length - 1;
        
        for (int i=0; i<inorder.length; i++)
        {
            valToIndex.put(inorder[i], i);
        }
        
        return buildTreeHelper(inorder, postorder, 0, inorder.length - 1);
    }
    
    private TreeNode buildTreeHelper(int inorder[], int postorder[], int left, int right)
    {
        
        // base conditions
        if (left > right)
        {
            return null;
        }
        
        System.out.println("left:"+left+" Right:"+right+" postorderIndex:"+postorderIndex);
        
        int val = postorder[postorderIndex];
        int index = valToIndex.get(val);
        
        postorderIndex -= 1;
        
        // construct a root node
        TreeNode root = new TreeNode(val);
        root.right = buildTreeHelper(inorder, postorder, index + 1, right);
        root.left = buildTreeHelper(inorder, postorder, left, index - 1);
        
        return root;
    }
}
