"""
129.
https://leetcode.com/problems/sum-root-to-leaf-numbers/
TC - O(n)
SC - O(h)
"""


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:

        stack, rtnData = [], 0
        if root:
            stack.append(root)
        while stack:
            node = stack.pop()
            if not node.left and not node.right:
                rtnData += node.val
            if node.right:
                node.right.val += node.val * 10
                stack.append(node.right)
            if node.left:
                node.left.val += node.val * 10
                stack.append(node.left)
        return rtnData
