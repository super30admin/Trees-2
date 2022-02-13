#time - n,space - h
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.sum=0
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        self.helper(root,root.val)
        return self.sum
    def helper(self,root,s):
        #base
        if root.left==None and root.right==None:
            self.sum+=s
            return
        #logic
        if root.left:
            self.helper(root.left,(s*10)+root.left.val)
        if root.right:
            self.helper(root.right,(s*10)+root.right.val)