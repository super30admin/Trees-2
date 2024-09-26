#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Tue Dec 17 09:27:53 2019

@author: tanvirkaur
"""
# Time complexity = O(n)
# Space complexity = O(h) where h is the height of the tree
class Solution(object):
    def sumNumbers(self, root ):
        """
        :type root: TreeNode
        :rtype: int
        """
        if not root:
            return 0
        q = [(root, root.val)]
        result = []
        while q:
            node, val1 = q.pop(0)
            if node.left:
                q.append((node.left, 10*val1+node.left.val))
            if node.right:
                q.append((node.right, 10*val1+node.right.val))
            if not node.left and not node.right:
                result.append(val1)
        return sum(result)
                
                
        
