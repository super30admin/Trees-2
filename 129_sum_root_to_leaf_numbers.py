# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
from collections import deque


class Solution:
    # bfs
    def sumNumbers(self, root: TreeNode) -> int:
        """
               // Time Complexity : O(n)
                        Visit each node once
               // Space Complexity : O(n) At most n/2 children in the stack
               // Did this code successfully run on Leetcode : Yes
               // Any problem you faced while coding this : No
               // Three line explanation of solution in plain english:
                    - Using BFS to store the nodes with the sum till the parent node
                    - Till reach the leaf node, we keep accumulating the sum
                    - Once we reach the leaf, we add the parent sum with the current node
                    - The leaf node sum is added to the result.
        """
        # edge case
        if not root: return 0
        result = 0
        # Level order traversal
        queue = deque()
        queue.append((root, 0))
        while queue:
            cur_node, cur_sum = queue.popleft()
            if cur_node.left is None and cur_node.right is None:
                result += cur_sum * 10 + cur_node.val
            if cur_node.left:
                queue.append((cur_node.left, cur_sum * 10 + cur_node.val))
            if cur_node.right:
                queue.append((cur_node.right, cur_sum * 10 + cur_node.val))
        return result

    # DFS Approach
    def sumNumbersRecursive(self, root: TreeNode) -> int:
        """
        // Time Complexity : O(n)
        // Space Complexity : O(h) recursive stack else O(1).
        // Did this code successfully run on Leetcode : Yes
        // Any problem you faced while coding this : No
        // Three line explanation of solution in plain english:
            - We calcuate the sum till the ith level using the previous
              result * 10 + current roots value.
            - Recursively do it for both left and right sub trees.
            - If a node has only one child, then the other child will not
              contribute to the sum because we want only sum from root to it's
              leaf. A leaf is a node with no children (both left and right).
        """
        # edge case
        if root is None: return 0
        return self._helper(root, 0)

    def _helper(self, root: TreeNode, result: int):
        # base case
        # one child is null
        if root is None: return 0
        # both the children are None
        if root.left is None and root.right is None:
            return result * 10 + root.val

        # logic
        return self._helper(root.left, result * 10 + root.val) + self._helper(root.right, result * 10 + root.val)
