//Time complexity: O(n)
//Space complexity: O(n)
//executed on leetcode.
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
    HashMap<Integer, Integer> hMap = new HashMap<>();
    int poLength = -1;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder == null || postorder.length==0) return null;        // Inorder follows left->root->right order
        
        poLength = postorder.length-1;									//Post order follows left->right->root order.
        for(int i=0;i<inorder.length;i++)
        {
            hMap.put(inorder[i],i);										//Storing inorder node vals and index in a hashmap.
            /*if(inorder[i] == postorder[postorder.length-1])			//Every last element of post order will be the root node.
            {
                index = i;												//in inorder elements before root go to left sub and elem after root go as right sub tree.
                break;
            }*/															//Post order array tells which is the root and in order gives left and right sub trees.
																		//Based on above conditions we are adding the elements to tree.
        }
        
        /*int[] inOleft = Arrays.copyOfRange(inorder, 0, index);
        int[] inOright = Arrays.copyOfRange(inorder, index+1, inorder.length);
        
        int[] postOleft = Arrays.copyOfRange(postorder, 0 ,index);
        int[] postOright = Arrays.copyOfRange(postorder, index, postorder.length-1);
        
        tree.left = buildTree(inOleft, postOleft);
        tree.right = buildTree(inOright, postOright);*/
        
        return buildTree(inorder, postorder, 0, poLength);
    }
    
    private TreeNode buildTree(int[] inorder, int[] postorder, int startIndex, int endIndex)
    {
        if(endIndex<startIndex)
            return null;
        TreeNode tree = new TreeNode(postorder[poLength]);
        poLength--;
        int index = hMap.get(tree.val);
        
        tree.right = buildTree(inorder, postorder, index+1, endIndex);
        tree.left = buildTree(inorder, postorder, startIndex, index-1 );
        
        return tree;
    }
}