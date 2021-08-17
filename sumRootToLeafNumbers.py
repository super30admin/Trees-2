"""
//Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :YES
// Any problem you faced while coding this : NO
"""
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def sumNumbers(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        #iterative approach
        if root == None:
            return 0
        stack = []
        currSum = 0
        sum1=0
        
        while(root!=None or len(stack)!=0):
            
            while(root!=None):
                currSum=currSum*10+root.val
                stack.append((root,currSum))
                root=root.left
            a = stack.pop()
            root = a[0]
            currSum = a[1]
            if root.left==None and root.right == None:
                sum1+=currSum
            root=root.right
        return sum1
            
            
        
        
        
        #recursive Approach
#         self.sum1 = 0
#         if root==None:
#             return 0
#         self.helper(root,0)
#         return self.sum1
#     def helper(self,root,currSum):
#         if root == None:
#             return 
#         currSum= currSum*10 + root.val
       
#         self.helper(root.left,currSum)
#         if(root.left==None and root.right==None):
#             self.sum1+=currSum
#         self.helper(root.right,currSum)
        