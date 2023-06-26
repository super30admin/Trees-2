// Time Complexity : O(n)
// Space Complexity : O(n)
    // n is the number of nodes present in the tree.

// Your code here along with comments explaining your approach
    //We use a map(key, value) and an integer as global variables. We use recursion with a helper function. In the helper function, we give indexes of postorder array along with the postorder array. 
    //In the map, we store the numbers mapped to their indexes as in inorder array. We intialize global integer variable as "postorder.length-1", we will use it as the index in postorder array. 
    //We iterate over the postorder array, the last number is root. We then look for the index of root in inorder array. Left of the root, we have numbers of left subtree, and vice versa on the right. We recursively call the helper function with these indexes for the right and then left sub trees.
    
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

    private Map<Integer, Integer> indexMapOfInorder;
    private int index;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.indexMapOfInorder = new HashMap<>();
        this.index = postorder.length-1;
        for (int i=0; i<inorder.length; i++)
        {
            indexMapOfInorder.put(inorder[i], i);
        }    
        return helper(postorder, 0, postorder.length);
    }

    private TreeNode helper(int[] postorder, int start, int end)
    {
        if (start>=end)
        {
            return null;
        }
        int rootVal = postorder[index--];
        TreeNode root = new TreeNode(rootVal);
        int indexInInorder = indexMapOfInorder.get(rootVal);
        root.right = helper(postorder, indexInInorder+1, end);
        root.left = helper(postorder, start, indexInInorder);
        return root;
    }
}