# Traverse the tree and keep doing node * 10 + sum to the current sum and pass that to the recursive call left and right. If both nodes are empty then again do the same math equation
# TC: O(n)
# SC: O(H)
# Yes, this worked in leetcode



# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        if root == None:
            return 0
        curr_sum = 0
        count = self.recurse(root, curr_sum)
        return count
    def recurse(self, Node, curr_sum):
        if not Node:
            return 0
        curr_sum = curr_sum * 10 + Node.val

        if not Node.left and not Node.right:
            return curr_sum
        left = self.recurse(Node.left, curr_sum)
        right = self.recurse(Node.right, curr_sum)

        return left + right


