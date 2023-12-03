# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    res=0
    def helper(self,root,sum1):
        if root==None:
            return

        if not root.left and not root.right:
            print(sum1)
            self.res+=sum1
        
        if root.left:
            self.helper(root.left,sum1*10+root.left.val)
        
        if root.right:
            self.helper(root.right,sum1*10+root.right.val)

    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        self.helper(root,root.val)
        return self.res
        