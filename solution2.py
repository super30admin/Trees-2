# time: O(n2)
# space: O(n)
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def buildTree(self, inorder, postorder):
        lenPost = len(postorder)
        if lenPost == 0:
            return None
        root = TreeNode(postorder[lenPost - 1])
        idx = -1
        # find index of root in ionorder
        for i in range(len(inorder)):
            if inorder[i] == root.val:
                idx = i
                break
        inLeft = inorder[ : idx]
        inRight = inorder[idx + 1 :]
        postLeft = postorder[ : len(inLeft)]
        postRight = postorder[len(inLeft) : len(inLeft) + len(inRight)]
        root.left = self.buildTree(inLeft, postLeft)
        root.right = self.buildTree(inRight, postRight)
        return root