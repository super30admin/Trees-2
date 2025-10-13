# Time Complexity : O(N)
# (We visit each node exactly once.)
#
# Space Complexity : O(H)
# (H = height of the tree, due to recursion stack.)
#
# Did this code successfully run on Leetcode : Yes
#
# Any problem you faced while coding this :
# Remembering to multiply current_sum by 10 before adding the node value
# — because each level represents the next digit in the number.

class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        # Start the depth-first search with an initial sum of 0
        return self.dfs(root, 0)

    def dfs(self, node, current_sum):
        # Base case: if the node is None, return 0 (no number to add)
        if not node:
            return 0

        # Build the number so far: shift existing digits left (×10) and add current digit
        current_sum = current_sum * 10 + node.val

        # If this is a leaf node (no children), return the full number formed by this path
        if not node.left and not node.right:
            return current_sum

        # Recursively calculate sums from left and right subtrees
        left = self.dfs(node.left, current_sum)
        right = self.dfs(node.right, current_sum)

        # Return total sum of all root-to-leaf numbers under this node
        return left + right