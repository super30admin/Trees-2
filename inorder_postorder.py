#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Sat Sep 11 23:57:50 2021

@author: ameeshas11
"""
#Time Complexity : O(n)
#Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No



# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    hashm = {}
    
    def get_node(self,ino, post, post_ptr, l, h):
        root = TreeNode(post[post_ptr])
        i = Solution.hashm[root.val]
        
        if i==l:
            root.left = None
        else:
            root.left = self.get_node(ino, post, post_ptr-1+i-h, l, i-1)
        if i==h:
            root.right = None
        else:
            root.right = self.get_node(ino, post, post_ptr-1, i+1, h)
            
        return root
    
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        if len(inorder) == 1:
            return TreeNode(inorder[0])
        
        for i in range(len(inorder)):
            Solution.hashm[inorder[i]] = i
            
        return self.get_node(inorder, postorder, len(inorder)-1, 0, len(inorder)-1)
        