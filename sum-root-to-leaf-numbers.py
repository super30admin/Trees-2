"""
Time - O(n)
Space - O(n)
Runs on leetcode - YES
"""
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        def dfs(node, curr):
            if not node:
                return 0

            curr = curr * 10 + node.val

            if not node.left and not node.right:
                return curr


            return dfs(node.left, curr) + dfs(node.right, curr)

        return dfs(root, 0)


