'''
Time Complexity - O(n)
Space Complexity - O(h)
'''

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right


class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        self.sum = 0
        return self.helper(root, 0)

    def helper(self, root, currSum):
        if root == None:
            return 0
        currSum = currSum*10 + root.val
        if root.left == None and root.right == None:
            self.sum += currSum
        self.helper(root.left, currSum)
        self.helper(root.right, currSum)
        return self.sum
