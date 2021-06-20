# Time Complexity : O(N) 
# Space Complexity :    O(H)  - height of tree
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : NO


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
        
class Solution:
    def sumNumbers(self, root: TreeNode) -> int:
        if root==None:
            return 0
        self.ans = 0
        self.helper(root,0)
        return self.ans
        
        
    def helper(self,root,currSum):
        if root==None:
            return
        
        #find currSum at the node
        currSum = currSum*10+root.val
        
        self.helper(root.left,currSum)
        
        #if no left and right child add cursum to the global result
        if root.left==None and root.right==None:
            self.ans+=currSum
        
        self.helper(root.right,currSum)
        
            
            
            
                
        