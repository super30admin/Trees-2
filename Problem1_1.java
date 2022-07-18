//Time Complexity: O(n^2)
//Space Complexity: O(n*h), where h is the height of the tree
//Code run successfully on LeetCode.

public class Problem1_1 {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        if(postorder == null ||postorder.length == 0|| inorder == null|| inorder.length == 0)
            return null;
        
        int rootVal = postorder[postorder.length - 1];
        TreeNode root = new TreeNode(rootVal);
        int rootIdx = 0;
        
        for(int i =0; i< inorder.length; i++){
            if(inorder[i] == rootVal)
            {
                rootIdx = i;
                break;
            }
        }
        
        int[] inorderLeft = Arrays.copyOfRange(inorder, 0, rootIdx );
        int[] inorderRight = Arrays.copyOfRange(inorder, rootIdx +1 , inorder.length);
        int[] postorderLeft = Arrays.copyOfRange(postorder, 0 , rootIdx);
        int[] postorderRight = Arrays.copyOfRange(postorder, rootIdx  , postorder.length-1);
        
        root.left = buildTree(inorderLeft, postorderLeft);
        root.right = buildTree(inorderRight, postorderRight);
        
        return root;
    }
}
