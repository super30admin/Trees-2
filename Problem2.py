# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
# Time Complexity --> O(n) where n is the number of nodes
# Space Complexity --> O(log n)
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        return self.helper(root, 0)

    def helper(self, root, curr):
        # base
        if root is None:
            return 0
        # logic
        curr = curr * 10 + root.val

        if root.left is None and root.right is None:
            return curr 
        left = self.helper(root.left, curr)
        right = self.helper(root.right, curr)
        return left + right 
        
        
        
