# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        
        def findsum(root,currSum):
            if root==None:
                return 0
            
            currSum=currSum*10+root.val
            print(currSum)
            if root.left==None and root.right==None:
                return currSum
            return findsum(root.left,currSum) + findsum(root.right,currSum)
        
        return findsum(root,0)