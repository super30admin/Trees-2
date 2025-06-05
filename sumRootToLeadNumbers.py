"""
problem: sum root to leaf numbers

Approach: have a running sum starting from root and multiply the sum by 10 to put the root.val in the right
next available position to form a number and return that number when reaching the leaf node and return 
the sum while backtracking
t.c. => O(n) where n = number of nodes
s.c. => O(h) where h is the max height of the tree where h = n if tree is not balanced.
"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:

        def helper(root, sums):
            if not root:
                return 0

            sums = (sums * 10) + root.val
            if not root.left and not root.right:
                return sums
            
            return helper(root.left, sums) + helper(root.right, sums)
        return helper(root, 0)