/*
106. Construct Binary Tree from Inorder and Postorder Traversal
Time Complexity: O(n)
Space Complexity: O(n)
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
       
        if(postorder.length == 0)
            return null;
        //HashMap to find element in inroder 
        
        HashMap<Integer, Integer> inOrderMap = new HashMap<Integer, Integer>();
        
        for (int i = 0; i < inorder.length; ++i){
            //no duplicates allowed
            inOrderMap.put(inorder[i],i);
        }
        
        //represens root
        int postorderIndex = inorder.length-1;
        //represents root elements index in the inorder 
        int inOrderIndex = inOrderMap.get(postorder[postorderIndex]);
        int start = 0;
        int end = inorder.length-1;
        return helper(postorderIndex, postorder, inorder, start, end, inOrderMap);
        
    }
    public TreeNode helper(int postorderIndex,int[] postorder,int[] inorder,int start,int end, HashMap<Integer, Integer> inOrderMap){
        //checking if all nodes are processed
    
        if(start > end ){
            return null;
        }
        if(start == end)
            return new TreeNode(inorder[end]);
        
        //creating root node from the postorderIndex
        TreeNode root = new TreeNode(postorder[postorderIndex]);
        root.left = null;
        root.right = null;
        int inOrderIndex = inOrderMap.get(postorder[postorderIndex]);
        int leftCount = inOrderIndex - start;
        int rightCount = end - inOrderIndex;
        //Creating leftSubtree
        root.right = helper(postorderIndex - 1, postorder, inorder, inOrderIndex + 1, end, inOrderMap);
        root.left = helper(postorderIndex - rightCount - 1, postorder, inorder, start, inOrderIndex-1, inOrderMap);
     
        return root;
    }
}
