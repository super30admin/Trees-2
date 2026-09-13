# Time Complexity : O(n)
# Space Complexity : O(h) where h is the height of the tree
# Did this code successfully run on Leetcode : Yes
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        return self.sum(root, 0)

    def sum(self, root, currSum):
        if root is None:
            return 0
        
        currSum = currSum * 10 + root.val
        if root.left is None and root.right is None:
            return currSum
        return self.sum(root.left, currSum) + self.sum(root.right,currSum)
