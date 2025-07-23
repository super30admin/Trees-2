//Time Complexity (TC): O(n)-Every node is visited exactly once to compute the sum → where n = number of nodes in the tree.
//Space Complexity (SC): O(h) -Where h = height of the tree (due to recursion stack).

//Use DFS to traverse the binary tree from root to each leaf.
//At each node, keep track of the number formed so far (currentNumber = currentNumber * 10 + node.val).
//When a leaf is reached, return that number; sum all such numbers from left and right subtrees.

class Solution {
    public int sumRootToLeafNumbers(TreeNode root) {
        return calculateSum(root, 0);
    }

    private int calculateSum(TreeNode currentNode, int currentNumber) {
        // Base case: if node is null, return 0
        if (currentNode == null) return 0;

        // Update the current number formed so far
        currentNumber = currentNumber * 10 + currentNode.val;

        // If it's a leaf node, return the current number
        if (currentNode.left == null && currentNode.right == null) {
            return currentNumber;
        }

        // Recurse on left and right subtrees
        int leftSum = calculateSum(currentNode.left, currentNumber);
        int rightSum = calculateSum(currentNode.right, currentNumber);

        return leftSum + rightSum;
    }
}
