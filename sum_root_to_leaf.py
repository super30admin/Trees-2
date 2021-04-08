# Time Complexity: O(n)
# Space Complexity: O(h) where h is the height of tree
# Ran on Leetcode: Yes


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumNumbers(self, root: TreeNode) -> int:
        if not root:
            return 0
        stack = []
        res = 0
        sum = 0
        while root or len(stack):
            while root:
                sum = sum * 10 + root.val
                stack.append([root, sum])
                root = root.left
            node = stack.pop()
            root = node[0]
            if not root.left and not root.right:
                res += sum
            sum = node[1]
            root = root.right
        return res
            