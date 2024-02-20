import java.util.*;

// Time Complexity : O(n) - where n is the number of nodes in the postorder or inorder array
// Space Complexity : O(1) - O(h) - where h is the height of the BST (Recursive stack space)

// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
Approach -:



Fact - > The last element in postorder array is always root of BST
         Inorder will be having root in such a way that elements which are left to the root
         forms the left subtree and to the right forms the right subtree.

Constructed the BST by the way preorder traversal. Stored all the inorder elements in
hashmap by index to know the left and right subtree elements by moving the index of
postorder array.

When constructing the right and left subtree elements, to check whether the postorder
root element is falling within the range or not, I've taken start and end index of the
inorder with respect to what element we are dealing with postorder array
 */

class Solution {
    private Map<Integer, Integer> indexByInorderRoot;
    private int idx;

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        indexByInorderRoot = new HashMap<>();
        idx = postorder.length - 1;

        for(int i = 0 ; i < inorder.length; i++) {
            indexByInorderRoot.put(inorder[i], i);
        }

        return helper(postorder, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] postorder, int inorderStart, int inorderEnd) {

        if(inorderStart > inorderEnd) return null;

        int rootVal = postorder[idx--];

        int divider = indexByInorderRoot.get(rootVal);

        TreeNode root = new TreeNode(rootVal);

        root.right = helper(postorder, divider + 1, inorderEnd);
        root.left = helper(postorder, inorderStart, divider - 1);

        return root;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class BSTConstructionFromPostorderAndInorderTraversal {

}
