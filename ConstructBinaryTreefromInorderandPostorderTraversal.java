/* Approach
1. The first element in the preorder order list will awlays be the root node.
2. Find the same node in inorder list. And the elements on the left of the node in inorder list would be the left elements of the node in the tree and the right elements in list would also be the right nodes in the tree.
3. Using this logic, form the tree recursively

Time complexity: O(N)
Space complexity: O(1)
*/
class Solution {
    HashMap<Integer, Integer> map = new HashMap<>();
    int index=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //emtpty tree
        if(preorder.length==0)
            return null;
        
        for(int i=0; i<=inorder.length-1; i++)
        {
            map.put(inorder[i],i);
        }
        
        return constructTree(preorder, inorder, 0, inorder.length-1);
    }
    
    private TreeNode constructTree(int[] preorder, int[] inorder, int start, int end)
    {
        if(start>end) return null;
        int rootIndex = map.get(preorder[index]);
        TreeNode root = new TreeNode(preorder[index]);
        index++;
        root.left = constructTree(preorder, inorder, start, rootIndex-1);
        root.right = constructTree(preorder, inorder, rootIndex+1, end);
    
        return root;
    }
}