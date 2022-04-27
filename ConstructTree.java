// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach: like in preorder, postorder's last node is root
//find that in inorder and split the array(not actually)

public class ConstructTree {
    public TreeNode ConstructTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, inorder.length-1, 0, postorder, postorder.length-1);
    }

    private TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postorder,
                               int postStart) {
        if (postStart < 0 || inStart < inEnd)
            return null;

        //The last element in postorder is the root
        TreeNode root = new TreeNode(postorder[postStart]);

        //find the index of the root from inorder, iterating from the end
        int rIndex = inStart;
        for (int i = inStart; i >= inEnd; i--) {
            if (inorder[i] == postorder[postStart]) {
                rIndex = i;
                break;
            }
        }
        //build right and left subtrees scanning from the end to find the sections
        root.right = buildTree(inorder, inStart, rIndex + 1, postorder, postStart-1);
        root.left = buildTree(inorder, rIndex - 1, inEnd, postorder, postStart - (inStart - rIndex) -1);
        return root;
    }
}
