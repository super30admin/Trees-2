'''
TC: O(n)
SC: O(h)
'''
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        if not root:
            return 0
        
        
        def rec(node, curr):
            if not node.left and not node.right:
                return curr * 10 + node.val
            sums = 0
            
            if node.left:
                sums += rec(node.left, curr * 10 + node.val)
            
            if node.right:
                sums += rec(node.right, curr * 10 + node.val)
            
            return sums
        
        return rec(root, 0)
