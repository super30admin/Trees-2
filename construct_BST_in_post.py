# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def buildTree(self, inorder, postorder):
        """
        :type inorder: List[int]
        :type postorder: List[int]
        :rtype: TreeNode
        :SC:O(n^2)
        :TC: O(n^2)
        """
        
        if not inorder or not postorder:
            return None
        root = TreeNode(postorder[len(postorder)-1])
        mid = inorder.index(postorder[len(postorder)-1])
        root.left = self.buildTree(inorder[:mid], postorder[:mid])
        root.right = self.buildTree(inorder[mid+1:], postorder[mid:len(postorder)-1])
        return root