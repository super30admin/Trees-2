#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Tue Dec 17 09:27:46 2019

@author: tanvirkaur
"""

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
# Time complexity = O(n)
# Space complexity = O(1) if we donot consider the recursion stack else it will be O(n)
class Solution(object):
    def sumNumbers(self, root ):
        """
        :type root: TreeNode
        :rtype: int
        """
        return self.helper(root,0)
    def helper(self, root, value):
        # base condition
        if not root:
            return 0
        if not root.left and not root.right:
            return value*10 + root.val
        left = self.helper(root.left, value*10+root.val)
        right = self.helper(root.right, value*10 + root.val)
        return left + right