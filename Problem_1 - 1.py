"""
Time Complexity : O(n^2). 
Space Complexity : O(n^2).
    
"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> TreeNode:
        if not postorder:
            return None 
        
        root_val = postorder[-1]
        node = TreeNode(root_val)
        index = 0
        
        for i in range(len(inorder)):
            if root_val == inorder[i]:
                index = i
        
        inleft = inorder[:index]
        inright = inorder[index+1:]
        poleft = postorder[:index]
        poright = postorder[index:-1]
        
        node.left = self.buildTree(inleft,poleft)
        node.right = self.buildTree(inright,poright)
        
        return node 