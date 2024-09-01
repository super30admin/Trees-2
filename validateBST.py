# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.flag = True
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        self.helper(root,None,None)
        return self.flag

    def helper(self,root,min1,max1):
        if root is None:
            return
        if (min1 is not None and root.val<=min1):
            self.flag = False
        if (max1 is not None and root.val>=max1):
            self.flag = False
        self.helper(root.left,min1,root.val)
        self.helper(root.right,root.val,max1)

    
        