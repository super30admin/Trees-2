# -*- coding: utf-8 -*-
"""
Created on Mon Apr 19 10:26:26 2021

@author: jgdch
"""

#Space Complexity:O(H)
#Time Complexity:O(N)
#Passed all LC test cases
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumNumbers(self, root: TreeNode):
        
        def preorder(r, curr_num):
            nonlocal sum_rl
            if r:
                curr_num = curr_num * 10 + r.val
                if not (r.left or r.right):
                    sum_rl += curr_num
                    
                preorder(r.left, curr_num)
                preorder(r.right, curr_num) 
        
        sum_rl= 0
        preorder(root, 0)
        return sum_rl        