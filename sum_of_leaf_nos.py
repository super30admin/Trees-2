# This solution computes the total sum of all numbers formed by root-to-leaf paths in a binary tree.
# It uses depth-first search (DFS) to traverse the tree and build numbers along each path.
# The `cur_sum` is updated by multiplying by 10 and adding the current node’s value to form the path number.

# Time Complexity: O(n), where n is the number of nodes in the tree, since each node is visited once.
# Space Complexity: O(h), where h is the height of the tree due to the recursion stack (O(n) in the worst case of a skewed tree).

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        result = 0
        def dfs(root, cur_sum):
            nonlocal result
            
            if not root:
                return 0

            cur_sum = cur_sum * 10 + root.val

            if not root.left and not root.right:
                result += cur_sum

            dfs(root.left, cur_sum)
            dfs(root.right, cur_sum)

        dfs(root, 0)

        return result
