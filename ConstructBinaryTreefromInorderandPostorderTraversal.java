class Solution {
    int index = 0;
    HashMap<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length==0)
            return null;
        
        for(int i=0; i<=inorder.length-1;i++)
        {
            map.put(inorder[i],i);
        }
        index = postorder.length-1;
        return constructTree(inorder, postorder, 0, inorder.length-1);
    }
    
    private TreeNode constructTree(int[] inorder, int[] postorder, int start, int end)
    {
        if(start>end)
            return null;
        int rootIndex = map.get(postorder[index]);
        TreeNode root = new TreeNode(postorder[index]);
        index--;

        root.right = constructTree(inorder, postorder, rootIndex+1, end);
        root.left = constructTree(inorder, postorder,  start, rootIndex-1);

        return root;
    }
}