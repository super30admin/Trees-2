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
        """
        if(len(inorder) == 0 or len(postorder) == 0):
            return None
        
        index = -1
        root = TreeNode(postorder[len(postorder) - 1])
        
        for _ in range(len(inorder)):
            if(inorder[_]) == root.val:
                index = _
        
        leftSize = index
        rightSize = (len(inorder) - 1) - index
        
        inLeft = inorder[0:index]
        inRight = inorder[index+1:len(inorder)]
        postLeft = postorder[0:leftSize]
        postRight = postorder[leftSize:len(postorder) - 1]
        
        root.left = self.buildTree(inLeft, postLeft)
        root.right = self.buildTree(inRight, postRight)
        
        return root
