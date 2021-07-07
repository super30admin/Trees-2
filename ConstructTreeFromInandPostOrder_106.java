/**
Time complexity:
Space complexity:

Algorithm:
=========
1. We have 2 arrays, inorder and postorder. Build a map of (value, index) from inorder array
2. Basic idea is that in postorder, root comes last, so find root index in inorder array
3. Now, inIndx+1 to end is right subtree and start to inIdx-1 is left subtree. 
Left -> Right -> Root in post-order, so construct tree in the same order
4. Construct a binary tree out of this by doing the same steps recursively
 */
class Solution {
    Map<Integer, Integer> map;
    int postidx;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postidx = inorder.length-1;
        map = new HashMap<>();                      // Map of (Value, index) of inorder for O(1) search         
        for(int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],i);
        }
        return helper(postorder, inorder, 0, inorder.length-1);
    }
    
    private TreeNode helper(int[] postorder, int[] inorder, int start, int end) {
        //base
        if(start > end) return null;
        //logic
        TreeNode root = new TreeNode(postorder[postidx]);       // keep track of preorder subtree root index
        int inidx = map.get(root.val);  
        postidx--;// find index of root in inorder using map
        root.right = helper(postorder, inorder, inidx+1, end);   // call buildTree recursively on right subtree 
        
        root.left = helper(postorder, inorder, start, inidx-1);  // call buildTree recursively on left subtree 
        return root;
    }
}