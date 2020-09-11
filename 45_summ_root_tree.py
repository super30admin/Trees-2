# S30 Big N Problem #45 {Medium}
# LC pproblem - 129. 

# Sum Root to Leaf Numbers

# Time Complexity : O(n) n=no. of nodes in the tree
# Space Complexity : O(1) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No 

# Approach
# Starting from root of the tree, traverse left and right recursively.
# At every step, create the number till the node
# At the leaf node, add this no. to the result variable

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumNumbers(self, root: TreeNode) -> int:
        
        if root is None:
            return 0
        res=0
        
        return self.helper(root,res,0)
                
    def helper(self,root,res,val):
        
        if root is None:
            return res
        
        if root.left is None and root.right is None:
            res=res+(val*10+root.val)
            return res
        
        res=self.helper(root.left,res,val*10+root.val)
        res=self.helper(root.right,res,val*10+root.val)
        
        return res
        
            
        