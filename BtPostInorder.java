// Time Complexity: O(n)
// Space Complexity: O(n + h) -> O(n)
public class BtPostInorder {
    Map<Integer, Integer> map;
    int idx;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || postorder == null || inorder.length == 0)
            return null;
        
        // location of first root
        idx = postorder.length-1;

        map = new HashMap<>();
        // create a map with roots and its idx form inorder
        for(int i = 0 ; i < inorder.length; i++)
        {
            map.put(inorder[i], i);
        }
        
        return builder(postorder, 0, postorder.length-1);
    }
    
    
    private TreeNode builder(int[] postorder, int start, int end)
    {
        // base
        if(start > end)
            return null;
        
        // recursive
        TreeNode root = new TreeNode(postorder[idx]);
        // next root
        idx--;
        int rootIdx = map.get(root.val);
        root.right = builder(postorder, rootIdx+1, end);
        root.left = builder(postorder, start, rootIdx-1);
        
        return root;
    }
}