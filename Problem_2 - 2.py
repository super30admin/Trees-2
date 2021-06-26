"""
Recursive Solution.
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
    def __init__(self):
        self.result = 0
    
    def sumNumbers(self, root: TreeNode) -> int:
        if not root:
            return 0  
        
        def helper(root, cursum):
            if not root: return 
            
            cursum = cursum * 10 + root.val 
            
            helper(root.left, cursum)
            
            if not root.left and not root.right:
                self.result += cursum 
            
            helper(root.right, cursum)
            
        
        helper(root, 0)
        return self.result 