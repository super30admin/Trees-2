# The code defines a sumNumbers method to calculate the sum of all root-to-leaf numbers in a binary tree.
# Each root-to-leaf path forms a number by concatenating the values of nodes along the path.

# Helper Function (dfs):
#   - The dfs function is a recursive helper that traverses the tree, accumulating the value of each path.
#   - It takes 'node' (the current node) and 'prev' (the accumulated path as a string) as arguments.
#   - Convert the current node's value to a string (val) to build the path.

# Base Case:
#   - If the current node is a leaf (no left or right child), concatenate 'val' to 'prev' to form the full path number.
#   - Convert this path number to an integer and add it to self.sum.

# Recursive Case:
#   - If the node has a left child, recursively call dfs on the left child, passing the updated path (prev + val).
#   - If the node has a right child, recursively call dfs on the right child with the updated path.

# Main Execution:
#   - Initialize self.sum to 0 to store the sum of all root-to-leaf path numbers.
#   - Call dfs on the root node with an empty string to start building path numbers.
#   - Return self.sum, which contains the total sum of all root-to-leaf numbers.

# TC: O(n) - Each node is visited once, making the time complexity linear in the number of nodes.
# SC: O(h) - The space complexity is O(h) due to the recursion stack, where h is the height of the tree.


from typing import Optional


class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        def dfs(node, prev):
            val = str(node.val)
            if not node.left and not node.right:
                self.sum += int(prev + val)
            if node.left:
                dfs(node.left, prev + val)
            if node.right:
                dfs(node.right, prev + val)
        
        self.sum = 0
        dfs(root, '')
        return self.sum