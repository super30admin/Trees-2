"""
## Problem1 (https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/)
Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

inorder = [9,3,15,20,7]
postorder = [9,15,7,20,3]
Return the following binary tree:

   3


   / \


  9  20


    /  \


   15   7

"""
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def bT(self,inorder, postorder):
        if len(postorder)==0:
            return None
        root = TreeNode(postorder[-1])
        index = inorder.index(root.val)
        root.left = self.bT(inorder[:index], postorder[:index])
        root.right = self.bT(inorder[index+1: ], postorder[index : len(postorder)-1])
        return root


