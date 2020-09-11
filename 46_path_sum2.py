# S30 Big N Problem #46 {Medium
# LC pproblem - 113. 

# Path Sum II

# Time Complexity : O(n) n=no. of nodes in the tree
# Space Complexity : O(n) n=no. of nodes in the tree
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No 

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    
    res=[]
    def pathSum(self, root: TreeNode, sum: int) -> List[List[int]]:
        
        if root is None:
            return self.res
        self.res=[]
        total=0
        path=[]
        self.helper(root,total,path,sum)
        
        return self.res
        
        
    def helper(self,root,total,path,sum):
        
        if root is None:
            return
        
        if root.left is None and root.right is None:
            if root.val+total==sum:
                self.res.append(path+[root.val])
                return
        
        self.helper(root.left,total+root.val,path+[root.val],sum)
        self.helper(root.right,total+root.val,path+[root.val],sum)
        
        return 
        
            
        