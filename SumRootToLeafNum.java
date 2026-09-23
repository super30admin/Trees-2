// **Approach**

// 1. Use DFS and build the current number as `currentNumber * 10 + node.val`.
// 2. When a leaf is reached, return the complete root-to-leaf number.
// 3. Add the results from the left and right subtrees to get the total sum.

// **Time Complexity:** O(n) — visit every node once.
// **Space Complexity:** O(h) — recursion stack, where `h` is the tree height.

//
class SumRootToLeafNum {

    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode node, int currentNumber) {

        if (node == null) {
            return 0;
        }

        // Build the number from root to current node
        currentNumber = currentNumber * 10 + node.val;

        // If leaf, return the number formed
        if (node.left == null && node.right == null) {
            return currentNumber;
        }

        // Sum numbers from left and right subtrees
        return dfs(node.left, currentNumber)
             + dfs(node.right, currentNumber);
    }
}


