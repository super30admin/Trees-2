/*
* Approach:
*  1. Add all inorder elements into hashmap and 
        maintain a global index for root in postorder.
* 
*  2. Decrement the index everytime we create root node.
        find the rootindex of root node in hashmap
*   
*  3. Update the left and right as follows:
        left: start, rootindex-1
        right : rootindex+1, end

    As this is postorder, we have to make right recursion call first.
* 
* 
* Did this code successfully run on Leetcode : YES
* 
* Any problem you faced while coding this : NO
* 
* Time Complexity: O(n)
* 
* Space Complexity: O(h) + O(n)
    height of the tree + use of hashmap
* 
*/

import java.util.HashMap;

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

public class InorderPostOrder {
    int index;

    HashMap<Integer, Integer> hmap;

    private TreeNode helper(int[] postorder, int start, int end) {
        if (index < 0)
            return null;

        if (start > end)
            return null;

        TreeNode root = new TreeNode(postorder[index]);

        int rootIndex = hmap.get(postorder[index]);

        index--;

        root.right = helper(postorder, rootIndex + 1, end);
        root.left = helper(postorder, start, rootIndex - 1);

        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.index = postorder.length - 1;

        this.hmap = new HashMap<>();

        for (int index = 0; index < inorder.length; index++)
            hmap.put(inorder[index], index);

        return helper(postorder, 0, postorder.length - 1);
    }
}
