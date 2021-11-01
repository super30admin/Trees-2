# Time Complexity : O(n)
# Space Complexity : O(n) - stack space
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        Sum = 0
        val = 0
        stack = []
        while root is not None or stack:
            while root is not None:
                val = val*10 + root.val
                stack.append((root, val))
                root = root.left
            root, val = stack.pop(len(stack)-1)
            if root.left is None and root.right is None:
                Sum += val
            root = root.right
        return Sum
