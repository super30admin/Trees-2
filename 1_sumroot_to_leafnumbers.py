// Time Complexity : O(n) 
// Space Complexity : O(h) recursive stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        self.result=0
        self.traverse(root,0)
        return self.result
        
    def traverse(self,node,num):
        
        num= num*10+node.val
        if node.left == None and node.right==None:
            self.result=self.result+num
        
        
        if node.left!=None:
            self.traverse(node.left,num)
            
        if node.right!=None:
            self.traverse(node.right,num)