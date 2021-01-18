# Time Complexity : O(N)
# Space Complexity : O(H)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumNumbers(self, root: TreeNode) -> int:
        """
            - Can use recursion..whenever we hit a leaf node then return total
        """
        def helper(root, total):
            if not root:
                return 0
            
            total = total*10 +root.val 
            
            if not root.left and not root.right:
                return total 
            
            return helper(root.left, total) + helper(root.right,total)
        
        return helper(root, 0)