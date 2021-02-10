# O(N) TIME AND O(D) space where N IS NO.OF NODES AND D IS DEPTH OF TREE
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def __init__(self):
        self.final = 0
    def sumNumbers(self, root: TreeNode,currentSum = 0) -> int:
        if root is None:
            return 0
        currentSum = currentSum * 10 + root.val
        if root.left is None and root.right is None:
            self.final += currentSum
        currentSum += self.sumNumbers(root.left,currentSum) + self.sumNumbers(root.right,currentSum)
        return self.final
        