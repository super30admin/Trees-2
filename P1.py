# -*- coding: utf-8 -*-
"""
Created on Mon Apr 19 10:19:06 2021

@author: jgdch
"""

#Time Complexity:O(N), N is the number of ndoes in the tree
#Space Complexity:O(N)
#Passed all LC Test testcases

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.index=0
        self.hmap={}
   
    def buildTree(self, inorder: List[int], postorder: List[int]) -> TreeNode:
        self.index=len(postorder)-1
        for i in range(len(inorder)):
            self.hmap[inorder[i]]=i
        
        return self.helper(postorder,0,len(postorder)-1)
    def helper(self,postorder,start,end):
        if(start>end):
            return None
        root=TreeNode(postorder[self.index])
        self.index-=1
        ind=self.hmap[root.val]
        root.right=self.helper(postorder,ind+1,end)
        root.left=self.helper(postorder,start,ind-1)
        return root
        
        