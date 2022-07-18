//Time Complexity: O(n)
//Space Complexity : O(n) + O(h), where h is the height of the tree
//Code run successfully on LeetCode.

public class Problem1_2 {

    HashMap<Integer, Integer> map = new HashMap<>();
    int idx;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        if(postorder == null|| postorder.length == 0 || inorder == null|| inorder.length == 0)
            return null;
        
        idx = postorder.length - 1;
        for(int i =0; i < inorder.length; i++)
            map.put(inorder[i], i);
        
        return helper(inorder, postorder, 0, inorder.length -1);
    }
    
    private TreeNode helper(int[] inorder, int[] postorder, int start, int end){
        
        if(start > end)
            return null;
        
        int rootVal = postorder[idx];
        idx--;
        
        TreeNode root = new TreeNode(rootVal);
        int rootIdx = map.get(rootVal);
        
        root.right = helper(inorder, postorder, rootIdx + 1, end);
        root.left = helper(inorder, postorder, start, rootIdx -1);
        
        return root;
    }
}
