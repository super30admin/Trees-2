"""
Implemented with reference to the homework solution.
Time Complexity: O(n)
Space Complexity: O(n)
"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        if not root:
            return 0

        from collections import deque
        total_sum = 0
        queue = deque([(root, root.val)])

        while queue:
            node, curr = queue.popleft()

            if not node.left and not node.right:
                total_sum += curr
            if node.left:
                queue.append((node.left, curr * 10 + node.left.val))
            if node.right:
                queue.append((node.right, curr * 10 + node.right.val))

        return total_sum
        