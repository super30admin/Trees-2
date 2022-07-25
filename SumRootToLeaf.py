# Time Complexity : O(N)  //Where n is the size of the array
#  Space Complexity : O(H)  //Recursive stack for the tree
#  Did this code successfully run on Leetcode : Yes
#  Any problem you faced while coding this : N/A

#  Your code here along with comments explaining your approach

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        if not root:
            return None
        
        #Declare a variable to calculate sum
        totalSum = 0
        num = 0
        
        #Function to help traverse the tree and the total sum
        def helper(root,num):
            if not root:
                return
            nonlocal totalSum
            if not root.left and not root.right:
                totalSum = totalSum + num * 10 + root.val
                return
        
            helper(root.left, num * 10 + root.val)
            helper(root.right, num * 10 + root.val)
        
        helper(root,num)
        return totalSum
    
    
        