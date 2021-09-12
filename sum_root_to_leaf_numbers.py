# Did this code successfully run on Leetcode : YES

# TC: O(N)
# SC: O(H) H = height of tree

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        
        def helper(node, track):
            if not node:
                return 0
            track = (track*10) + node.val
            if not node.left and not node.right:
                return track
            return helper(node.left, track) + helper(node.right, track)
        
        return helper(root, 0)