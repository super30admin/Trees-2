"""
Problem: 129. Sum Root to Leaf Numbers
Leetcode: https://leetcode.com/problems/sum-root-to-leaf-numbers/
Solution: Recursive DFS preorder traversal
Time Complexity: O(n), we have to traverse all numbers
Space Complexity: O(h), h is the tree height, recursive approach uses inbuilt stack to store all numbers
"""


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    total_sum = 0

    def sumNumbers(self, root: TreeNode) -> int:
        self.helper(root, self.total_sum)
        return self.total_sum

    def helper(self, node, curr_sum):
        # Base case
        if not node:
            return

        # Leaf node
        if not node.left and not node.right:
            # calculate the total sum
            self.total_sum = self.total_sum + curr_sum * 10 + node.val
            return

        curr_sum = curr_sum * 10 + node.val
        # calculate the left subtree
        self.helper(node.left, curr_sum)
        # calculate the right subtree
        self.helper(node.right, curr_sum)