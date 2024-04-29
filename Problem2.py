## Problem2 (https://leetcode.com/problems/sum-root-to-leaf-numbers/)

# Approach
# Traverse from root to leaf node. At each node, add the value to curSum. curSum = curSum * 10 + root.val. check if the node is a leaf node using if root.left == None and root.right == None.
# If yes, add the curSum to res else continue traversing through the tree. Recursively call the left and right child and pass node and curSum to the function
# return root

# Time Complexity: O(n)
# Space Complexity: O(h)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


class Solution:
    res = 0
    def helper(self,root,curSum):
        # Base
        if root == None:
            return

        # Logic
        curSum = curSum * 10 + root.val

        if root.left == None and root.right == None:
            self.res += curSum
        self.helper(root.left,curSum)

        self.helper(root.right,curSum)

    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        self.helper(root,0)
        return self.res