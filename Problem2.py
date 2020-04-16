#
# Time Complexity  = O(n)
# Space Complexity  = O(h) recursive stack space
#

class Solution:
    def sumNumbers(self, root: TreeNode) -> int:
        def helper(node, curr):
            if not node:
                return 0
            curr = curr*10+node.val
            if not node.left and not node.right:
                return curr
            else:
                return helper(node.left, curr)+helper(node.right, curr)
        return helper(root, 0)
