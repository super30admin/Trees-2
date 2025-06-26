# Time Complexity :
- O(n), where n is the number of nodes in the tree each node is visited once

# Space Complexity :
- O(h), where h is the height of the tree due to recursion stack

# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        def dfs(node, current_sum):
            if not node:
                return 0

            current_sum = current_sum * 10 + node.val

            if not node.left and not node.right:
                return current_sum

            return dfs(node.left, current_sum) + dfs(node.right, current_sum)

        return dfs(root, 0)


