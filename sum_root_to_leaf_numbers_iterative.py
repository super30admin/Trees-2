"""
Problem: 129. Sum Root to Leaf Numbers
Leetcode: https://leetcode.com/problems/sum-root-to-leaf-numbers/
Solution: Iterative DFS preorder traversal
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
    def sumNumbers(self, root: TreeNode):
        total_sum = 0
        stack = [(root, 0)]

        while stack:
            root, curr_number = stack.pop()
            if root:
                curr_number = curr_number * 10 + root.val
                # if it's a leaf, update total_sum
                if not root.left and not root.right:
                    total_sum += curr_number
                else:
                    # push right first and then left so that left can be popped first as we're doing preorder traversal
                    stack.append((root.right, curr_number))
                    stack.append((root.left, curr_number))
        return total_sum