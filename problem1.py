# Time complexity is O(N2) and space is O(h)

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def buildTree(self, inorder, postorder):
        
        if not inorder:
            return
        
        root = TreeNode(postorder.pop())
        idx = inorder.index(root.val)
        
        root.right = self.buildTree(inorder[idx+1:],postorder)
        root.left = self.buildTree(inorder[:idx],postorder)
        return root