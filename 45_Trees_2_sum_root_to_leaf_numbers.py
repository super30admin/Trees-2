#Time Complexity : O(n) where n is the number of elements
#Space Complexity : O(n)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : 
#Your code here along with comments explaining your approach

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
        ## Got idea form geeks for geeks
        def helper(root,val): 
            if not root: # if root is none then simply return 0
                return 0
            
            val=val*10+root.val #update the val needed, simply left shift everytime and root.val
            
            if not root.left and not root.right:  #If the node is leaf node, simply return the value of that node
                return root.val 
            
            return helper(root.left,val)+helper(root.right,val)
        
        return helper(root,0) #calling helper function with init value=0
                
            
        
        
        
        
        