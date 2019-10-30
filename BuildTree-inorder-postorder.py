# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


#This is O(n^2) solution as we are searching inrder array for the root

class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> TreeNode:
        if len(postorder) == 0:
            return None
        rootVal = postorder[-1]
        rootidx = -1
        for index, val in enumerate(inorder):
            if val == rootVal:
                rootidx = index
        root = TreeNode(rootVal)
        inleft = inorder[:rootidx]
        inright = inorder[rootidx + 1:]
        postleft = postorder[:rootidx]
        postright = postorder[rootidx:len(postorder) - 1]
        root.left = self.buildTree(inleft, postleft)
        root.right = self.buildTree(inright, postright)
        return root