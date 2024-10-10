# 129. Sum Root to Leaf Numbers
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        result = 0
        def helper(root,currSum):
            nonlocal result
            if root == None:
                return

            currSum = (currSum * 10) + root.val

            if root.left == None and root.right == None:
                result += currSum
            
            helper(root.left,currSum)
            helper(root.right,currSum)

            

        helper(root, 0)
        return result
        