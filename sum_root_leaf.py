# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.result=0
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        self.helper(root,0)
        return self.result

    def helper(self,root,currSum):
        if root is None:
            return
        currSum = currSum*10 + root.val
        if (root.left is None and root.right is None):
            self.result+=currSum
        self.helper(root.left, currSum)
        self.helper(root.right,currSum)

        


        