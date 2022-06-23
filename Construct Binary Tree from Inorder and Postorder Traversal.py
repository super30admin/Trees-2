# TC : O(n)
# SC : O(n)
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
        if len(postorder)==0 or len(inorder)==0:
            return None
        rootidx=0
        root=TreeNode(postorder[-1])
        for i in range(len(inorder)):
            if inorder[i]==postorder[-1]:
                rootidx=i
        postleft=postorder[0 : rootidx]
        postright=postorder[rootidx : len(postorder)-1]
        left=inorder[0:rootidx]
        right=inorder[rootidx+1:len(inorder)]
        root.left=self.buildTree(left,postleft)
        root.right=self.buildTree(right,postright)
        return root