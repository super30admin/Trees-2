''' 
Time Complexity : O(n) 
Space Complexity : O(h) 
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this :  No
'''

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:

    def __init__(self):
        self.total = 0
    
    def helper(self, root, numCount):
        if root == None:
            return

        numCount = numCount * 10 + root.val

        if root.left == None and root.right == None:
            self.total += numCount
        
        self.helper(root.left, numCount)
        self.helper(root.right, numCount)


    def sumNumbers(self, root):
        if root == None:
            return
        
        self.helper(root, 0)

        return self.total
        