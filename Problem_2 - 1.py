"""
Iterative Solution.
Time Complexity : O(n) where n is the number of nodes in the tree. 
Space Complexity : O(h) where h is the height of the tree. 
    
"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    
    def sumNumbers(self, root: TreeNode) -> int:
        if not root:
            return 0 
        stack = []
        sum_ = 0 
        result = 0 
        
        while root or stack:
            while root:
                sum_ = sum_ * 10 + root.val 
                stack.append((root, sum_))
                root = root.left
            
            root, sum_ = stack.pop()
            
            if not root.left and not root.right:
                result += sum_
            
            root = root.right 
        
        return result
       