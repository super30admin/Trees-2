/**
 * Time Complexity : O(n^2) (We can further reduce it by using a hashmap instead of finding the element in inorder array every time)
 * Space Complexity : O(h)  where h = height of the tree
 */

public class In_Post_ToBST{
    public TreeNode buildTree(int[] inorder, int[] postorder) {

        return helper(postorder.length - 1,0,inorder.length-1,inorder,postorder);

    }
    public TreeNode helper(int postIndex, int inStart, int inEnd,int[] inorder,int[] postorder)
    {
        if(postIndex<0 || (inStart>inEnd))return null;

        TreeNode root = new TreeNode(postorder[postIndex]);
        int index = 0;
        for(int i = 0; i < inorder.length; i++)
        {
            if(inorder[i] == postorder[postIndex])
            {
                index = i;
                break;
            }
        }
        root.left = helper(postIndex - (inEnd - index + 1 ),inStart,index - 1,inorder,postorder);
        root.right= helper(postIndex-1, index + 1,inEnd,inorder,postorder);

        return root;

    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
