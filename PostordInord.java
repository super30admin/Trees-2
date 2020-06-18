// Time Complexity : O(n) n is number of nodes 
// Space Complexity :O(n) n is number of nodes 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class PostordInord {
    HashMap<Integer,Integer> map = new HashMap<>();
    int index = 0;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        index = postorder.length-1;
        for(int i=0;i<inorder.length;i++)
            map.put(inorder[i],i);
        return getRoot(postorder, inorder, 0, postorder.length-1);
    }
    
    private TreeNode getRoot(int[] postorder, int[] inorder, int start, int end)
    {
        if(start>end) return null;
        
        int idx = map.get(postorder[index]);
        TreeNode root = new TreeNode(postorder[index]);
        index--;
        root.right = getRoot(postorder,inorder,idx+1,end);
        root.left = getRoot(postorder,inorder,start,idx-1);
        return root;
    }
}