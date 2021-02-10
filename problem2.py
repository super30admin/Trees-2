// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumNumbers(self, root: TreeNode) -> int:
        self.output=0
        if not root:
            return output
        self.recurr(root,0)
        return self.output
    
    def recurr(self,root, current):
        if not root:
            return 
        current=current*10+root.val
        
        if not root.left and not root.right:
            self.output+=current
            return 
        
        self.recurr(root.left,current)
        self.recurr(root.right,current)
            
