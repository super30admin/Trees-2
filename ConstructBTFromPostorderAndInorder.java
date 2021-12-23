// Time complexity - O(n)
// Space Complexity - O(n) Recursive stack, Hashmap
// Leetcode passed - Yes

import java.util.HashMap;
import java.util.Map;

public class ConstructBTFromPostorderAndInorder {
    public static class TreeNode {
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

    int idx; // this is to track the element in postorder array of which node needs to be created
    Map <Integer, Integer> inMap;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = postorder.length;
        inMap = new HashMap <>();

        // Storing inorder elements in hashmap to access in O(1) time
        for(int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        idx = n-1;
        return buildTreehelper(postorder, 0, n-1);
    }

    public TreeNode buildTreehelper(int[] postorder, int inStart, int inEnd) {
        // when the indices cross each other, that means we started moving in wrong direction, hence the node doesn't have any element as its child
        if(inStart > inEnd || idx < 0) {
            return null;
        }
        // the element at idx is the root node
        TreeNode root = new TreeNode(postorder[idx]);
        // finding the index of root node in the inorder array
        int rootIndex = inMap.get(postorder[idx]);
        // decrementing it for further calls
        idx--;

        // Using recursion to find right and left subtree's nodes
        root.left = buildTreehelper(postorder, inStart, rootIndex-1);
        root.right = buildTreehelper(postorder, rootIndex+1, inEnd);
        return root;
    }
}
