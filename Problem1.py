# Time Complexity : O(n)
# Space Complexity :O(n)
# Did this code successfully run on Leetcode :Yes
# Any problem you faced while coding this :


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def buildTree(self, inorder, postorder):
        if len(inorder) == 0 or len(postorder) == 0:
            return
        else:
            root = postorder[-1]
            tnode = TreeNode(root)
            index = inorder.index(root)

            l = inorder[:index]
            r = inorder[index + 1:]
            tnode.left = self.buildTree(l, postorder[:len(l)])
            tnode.right = self.buildTree(r, postorder[len(l):len(postorder) - 1])

            return tnode

