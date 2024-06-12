# Time Complexity : O(n)

# space complexity : O(h)

# Approach :

# use dfs
# keep going left till the leaf node is reached
# keep going right till the leaf node is reached
# keep calculating the digit using the formula : currdigit * 10 + root value
# once the leaf node is reached return the final sum digit


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:

        return self.checkSum(root, 0)

    def checkSum(self, root, sumVal):

        if root is None:
            return 0
        sumLeft = self.checkSum(root.left, (sumVal*10) + root.val)

        if root.left == None and root.right == None:
            sumNew = (sumVal*10) + root.val
            return sumNew

        sumRight = self.checkSum(root.right, (sumVal*10) + root.val)
        return sumLeft + sumRight
