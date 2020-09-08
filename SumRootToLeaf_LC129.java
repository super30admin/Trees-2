// Time Complexity: O (N) N: number of nodes in tree
// Space Complexity: O(H) stack space for recursion where H is tree height
// Did this code successfully run on Leetcode : Yes

import java.util.Stack;

class StackNode {
    TreeNode node;
    int number;

    StackNode(TreeNode node, int number) {
        this.node = node;
        this.number = number;
    }
}

public class SumRootToLeaf_LC129 {
    public int sumNumbers(TreeNode root) {
        // return sumIterative(root);
        return sumRecursive(root, 0);
    }

    /**
     * Use inorder traversal to reach all possible leaf nodes. Use a stack that stores a node and number formed at that node.
     * Traverse till leftmost node and then lookup stack to traverse right parts of node.
     * Add to sum only when leaf nodes are reached.
     *
     * @param node
     * @return
     */
    int sumIterative(TreeNode node) {
        if (node == null)
            return 0;

        int sum = 0, number = 0;
        Stack<StackNode> stack = new Stack<>();         // Maintain stack

        while (node != null || !stack.isEmpty()) {      // Iterate until node is not null and stack isn't empty
            while (node != null) {
                number = number * 10 + node.val;            // calculate number formed so far in tree path
                stack.push(new StackNode(node, number));
                node = node.left;                           // Keep going to left
            }
            StackNode popped = stack.pop();
            node = popped.node;
            number = popped.number;
            if (node.left == null && node.right == null)    // Add to sum only when leaf is reached
                sum += number;
            node = node.right;                              // Explore right
        }
        return sum;
    }

    /**
     * Use terminating condition as when leaf is reached, return value formed at that leaf or when node is null
     * return 0. Keep recursing left and right subtrees and add up the results from both
     *
     * @param node
     * @param value
     * @return
     */
    int sumRecursive(TreeNode node, int value) {
        if (node == null)
            return 0;

        value = value * 10;
        value += node.val;                              // Calculate number formed from tree path
        if (node.left == null && node.right == null)
            return value;                               // leaf is reached, return value
        return sumRecursive(node.left, value) + sumRecursive(node.right, value);    // Recurse left and right subtree
    }
}
