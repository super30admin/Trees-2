#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Sun Sep 12 00:01:43 2021

@author: ameeshas11
"""

#Time Complexity : O(n)
#Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No



class Solution:
    sumval = 0
    def help(self, root, num):
        #base
        if root == None:
            return
        if root.left == None and root.right == None:
            self.sumval += num*10 + root.val
        
        #logic
        self.help(root.left, num*10 + root.val)
        self.help(root.right, num*10 + root.val)
    
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        self.sumval = 0
        self.help(root, 0)
        return self.sumval
        