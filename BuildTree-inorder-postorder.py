# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

#Accepted by leetcode
#Time complexity - O(n) searching root value in inorder
#Space complexity - O(n) asymtotically because we are using extra arrays inleft, inright, postleft, postright

class Solution(object):
    def buildTree(self, inorder, postorder):
        """
        :type inorder: List[int]
        :type postorder: List[int]
        :rtype: TreeNode
        """
        #Edge case
        if len(postorder) == 0:
            return None        
        root = TreeNode(postorder[-1])
        rootindx = -1
        for i,val in enumerate(inorder):
            if val == root.val:
                rootindx = i
        inleft = inorder[:rootindx]
        inright = inorder[rootindx+1:]
        postleft = postorder[:rootindx]
        postright = postorder[rootindx:-1]
        root.left = self.buildTree(inleft, postleft)
        root.right = self.buildTree(inright, postright)
        return root            