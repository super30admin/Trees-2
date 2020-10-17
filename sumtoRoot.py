# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
"""
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
"""
class Solution:
    def sumNumbers(self, root: TreeNode) -> int:
        
        
        def helper(s, root):
            
            if root is None:
                return 0

            s = 10 * s +  root.val
            
            if not root.left and not root.right:
                return s
            
            return helper(s, root.left) + helper(s, root.right)
            
                                        
        return helper(0, root)