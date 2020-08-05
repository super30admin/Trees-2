// Time Complexity :O(N) where N is number of nodes
// Space Complexity : O(N) for the values in hashMap.
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// From the postorder, we can get the root value and from the inorder we can get left values or the root right values.
// In the postorder, the root comes at the end(Left, Right, Root). To get current root, we will keep a pointer and decrement
// it to get next root from postorder array. Once we get the root index from inorder map, we can get start and end pointer for left
// tree and start and end pointer of right tree from inorder. We can keep finding left node from the left tree and right node
// from the right tree of the inorder array.

import java.util.HashMap;

public class ConstructBinaryTreeFromInAndPost {
    private int index = 0;

    public TreeNode buildTree(int[] inorder, int[] postOrder) {
        HashMap<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        index = postOrder.length - 1;
        return getBinaryTree(postOrder, inorderMap, 0, inorder.length - 1);
    }

    private TreeNode getBinaryTree(int[] postOrder, HashMap<Integer, Integer> inorderMap, int inorderStart, int inorderEnd) {
        if (inorderStart > inorderEnd) return null;

        TreeNode root = new TreeNode(postOrder[index--]);
        int rootIndex = inorderMap.get(root.val);

        root.right = getBinaryTree(postOrder, inorderMap, rootIndex + 1, inorderEnd);
        root.left = getBinaryTree(postOrder, inorderMap, inorderStart, rootIndex - 1);
        return root;
    }

}
