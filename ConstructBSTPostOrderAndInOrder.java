// Time Complexity : O(n) n = number of nodes
// Space Complexity : O(h) h = height of the tree 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// Traverse postorder from back using global variable. Find it's position in inorder and recursively do the same
// for right (first) and left subtrees. Right needs to go first as we are reading from the back of postorder (Left <- Right <- Root)

import java.util.HashMap;
import java.util.Map;

public class ConstructBSTPostOrderAndInOrder {
    int currentIndex;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.currentIndex = postorder.length - 1;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        // inorder index map for each value
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return buildTreeRecursive(map, inorder, postorder, 0, postorder.length - 1);
    }

    public TreeNode buildTreeRecursive(Map<Integer, Integer> map, int[] inorder, int[] postorder, int left, int right) {
        // no left or right child
        if (currentIndex < 0 || left > right) {
            return null;
        }

        // create node
        TreeNode node = new TreeNode(postorder[currentIndex]);
        // get position
        int position = map.get(node.val);

        currentIndex--;
        node.right = buildTreeRecursive(map, inorder, postorder, position + 1, right);
        node.left = buildTreeRecursive(map, inorder, postorder, left, position - 1);

        return node;
    }
}
