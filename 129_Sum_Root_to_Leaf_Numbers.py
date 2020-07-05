# Time Complexity : O(n) [n = number of nodes in tree]
# Space Complexity : O(log n)[n is number of nodes in tree]
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach
# 1. Traverse the tree in preorder way
# 2. return the sum as soon as we hit the leaf node
class Solution:
    def sumNumbersUtil(self, root, num):
        if root is None:
            return 0
        if  root.right is None and root.left is None:
            return (num*10) + root.val
        left = self.sumNumbersUtil(root.left, num*10+root.val)
        right = self.sumNumbersUtil(root.right, num*10+root.val)
        return left+right
    def sumNumbers(self, root: TreeNode) -> int:
        if root is None:return 0
        return self.sumNumbersUtil(root, 0)