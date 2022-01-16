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
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        
        if not postorder:
            return None
        
        rootVal = postorder[-1]
        i = 0
        l = len(inorder)
        
        while i < l and inorder[i] != rootVal:
            i += 1
            
        root = TreeNode(rootVal)
        root.left = self.buildTree(inorder[:i], postorder[:i])
        root.right = self.buildTree(inorder[i+1:], postorder[i:-1])
        
        return root
        