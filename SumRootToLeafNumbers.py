# Time Complexity : O(n)
# Space Complexity : O(h) where h is the height of tree
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach : recursive method to iterate and returning the result on leaf node where calculation is done. Result is sum of left and right tree

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        if root == None:
            return 0

        return self.recursive(root, 0)

    def recursive(self, root, num):
        # Base
        if root == None:
            return 0

        # leaf nodes
        if root.left == None and root.right == None:
            return num*10+root.val

        return self.recursive(root.left, num*10+root.val) + self.recursive(root.right, num*10+root.val)
