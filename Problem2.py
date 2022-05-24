#Time Complexity : O(N)
#Space Complexity : O(N)
#Did this code successfully run on Leetcode : YES
#Any problem you faced while coding this : NO

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        self.summ = 0
        self.helper(root,0)
        return self.summ
        
    def helper(self,root,num):
        #base
        if root == None:
            return 
        
        #logic
        num = num * 10 + root.val
        if root.left == None and root.right == None:
            self.summ += num
            return
        
        self.helper(root.left,num)
        self.helper(root.right,num)
        