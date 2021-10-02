# // Time Complexity : O(n) where n is the number of nodes in the tree
# // Space Complexity : O(h) where h is the height of the tree
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : none

# // Your code here along with comments explaining your approach 


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    
    def dfs(self,root,sumSoFar):
        if not root: return 0
        sumSoFar = sumSoFar*10 + root.val
        if not root.left and not root.right: # leaf node
            return sumSoFar
        return self.dfs(root.left,sumSoFar) + self.dfs(root.right,sumSoFar) 
    
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        if not root: return 0
        return self.dfs(root,0)
        