#Time Complexity :O(n)
#Space Complexity :O(h) h is the height of the tree
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        self.result=0
        return self.helper(root,0)

    def helper(self,root,currNum):
        if not root:
            return 0
        
        currNum=currNum*10+root.val
        if not root.left and not root.right :
            self.result+=currNum
            
        self.helper(root.left,currNum)
        self.helper(root.right,currNum)
        return self.result
