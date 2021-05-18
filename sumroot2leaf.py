# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def sumNumbers(self, root: TreeNode) -> int:
        stack, currentSum, result = [], 0, 0
        while root is not None or stack:
            while root:
                currentSum = currentSum * 10 + root.val
                stack.append((root, currentSum))
                root = root.left
            root, currentSum = stack.pop()
            print(currentSum)
            if root.left is None and root.left is None:
                result = result + currentSum
            root = root.right

        return result
