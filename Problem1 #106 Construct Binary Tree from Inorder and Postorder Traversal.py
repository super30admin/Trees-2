# Time Complexity : O(N)
# Space Complexity : O(h)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    result = 0

    def helper(self, root, currSum):
        # base
        if root == None:
            return

        # logic
        self.helper(root.left, (currSum*10 + root.val))

        if root.left == None and root.right == None:
            self.result = self.result + (currSum*10 + root.val)

        self.helper(root.right, (currSum*10 + root.val))

    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        currSum = 0
        self.helper(root, currSum)
        print(self.result)
        return self.result
