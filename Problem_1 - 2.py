"""
Time Complexity : O(n). 
Space Complexity : O(n).
    
"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.hash = {}
        self.index = None 
        
    def buildTree(self, inorder: List[int], postorder: List[int]) -> TreeNode:
        if not postorder:
            return None 
        self.index = len(postorder) - 1 
    
        for i,j in enumerate(inorder):
            self.hash[j] = i 
        
        def helper(inorer, postorder, s, e):
            if s > e: return None 
            print(self.index)
            root_val = postorder[self.index]
            self.index -= 1 
            
            node = TreeNode(root_val)
            idx = self.hash[root_val]
            
            node.right = helper(inorder, postorder, idx + 1, e)
            node.left = helper(inorder, postorder, s, idx - 1)
            
            return node 
            
        
        return helper(inorder, postorder, 0, len(inorder) - 1)

        
        