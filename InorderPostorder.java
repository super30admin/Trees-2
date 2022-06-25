/*This code utilizes recursion to build the binary tree. It finds the root element from the 
postorder array, and finds its location in the inorder array. In the inorder array, everything
to the left of the root will be the left subtree, and everything to the right of the root will
be the right subtree. Using this information, we recursively compute upon the postorder array,
and build the tree

Did this code run on leetcode: Yes
*/
class Solution {
    HashMap<Integer, Integer> map;
    int idx;
    //Time Complexity = O(n)
    //Space Complexity = O(n)
    public TreeNode buildTree(int[] inorder, int[] postorder) 
    {   //We use a hash map to store the indices of the values of the inorder array so that our search can be more optimisied
        map = new HashMap<>();
        //Since root is at the end of postorder, we start from the back
        idx = postorder.length - 1;
        
        for(int i = 0; i < inorder.length; i++)
            map.put(inorder[i], i);
        
        return helper(postorder, 0, postorder.length - 1);
    }
    
    private TreeNode helper(int[] postorder, int start, int end)
    {   
        if(start > end)
            return null;
        
        int rootVal = postorder[idx];
        TreeNode root = new TreeNode(rootVal);
        //In the postorder array, all the root nodes will be in decreasing order 
        idx--;

        int rootIdx = map.get(rootVal);
        root.right = helper(postorder, rootIdx + 1, end);
        root.left = helper(postorder, start, rootIdx - 1);

        return root;
    }
}