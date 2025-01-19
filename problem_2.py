"""
Problem 2: Sum Root to Leaf Numbers (https://leetcode.com/problems/sum-root-to-leaf-numbers/)
TC: O(N)
SC: O(H)
Approach: DFS traversal of the tree. At each node, calculate the current number and pass it to the left and right subtree.
"""


from typing import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        self.result = 0
        self.helper(root, 0)
        return self.result

    def helper(self, node, currNum):
        if not node:
            return
        currNum = currNum * 10 + node.val
        if not node.left and not node.right:
            self.result += currNum
            return
        self.helper(node.left, currNum)
        self.helper(node.right, currNum)