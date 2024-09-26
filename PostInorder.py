#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Tue Dec 17 09:04:59 2019

@author: tanvirkaur
"""

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
# Time complexity = O(n)
# Space complexity = O(n^2)
class Solution(object):
    def buildTree(self, inorder, postorder):
        """
        :type inorder: List[int]
        :type postorder: List[int]
        :rtype: TreeNode
        """
        if not inorder or not postorder:
            return None
        root = TreeNode(postorder[len(postorder)-1])
        indexx = inorder.index(root.val)
        root.left = self.buildTree(inorder[:indexx], postorder[:indexx])
        root.right = self.buildTree(inorder[indexx+1:], postorder[indexx:len(postorder)-1])
        return root