# Time Complexity : O(n), where n is the number of nodes in the tree
# Space Complexity : O(h), where h is the height of the tree due to recursion stack
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        # Helper function to perform DFS and carry path sum
        def dfs(node, current_sum):
            if not node:
                return 0
            current_sum = current_sum * 10 + node.val
            if not node.left and not node.right:
                return current_sum  # Leaf node, return the number formed
            return dfs(node.left, current_sum) + dfs(node.right, current_sum)

        return dfs(root, 0)
