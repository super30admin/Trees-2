# Time Complexity - O(n)
# Space Complexity - O(H)


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    result = 0

    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        self.helper(root,0)
        return self.result

    def helper(self, root,currNum):
        if not root:
            return

        currNum = currNum * 10 + root.val 
        if not root.left and not root.right:
            self.result += currNum 

        self.helper(root.left,currNum)
        self.helper(root.right,currNum)

        


       
