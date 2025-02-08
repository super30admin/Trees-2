# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        self.result = 0
        self.helper(root, 0)
        return self.result

    def helper(self, root: Optional[TreeNode], currNum) -> None:
        # base
        if (root == None):
            return
        # logic
        currNum = currNum*10 + root.val
        print(currNum)
        if root.left == None and root.right == None:
            self.result += currNum
        
        self.helper(root.left, currNum)
        print("hi")
        self.helper(root.right, currNum)
        