"""
I keep on adding the node val to the current number until we know its a leaf and then do this recursively. then add the results of dfs of both left and right subtrees
TC is o(n) for iterating though all nodes and SC is o(height of tree) for recursive stack
"""
class Solution(object):
    def sumNumbers(self, root):
        """
        :type root: Optional[TreeNode]
        :rtype: int
        """
        def dfs(node, current):
            if not node:
                return 0
            current = current * 10 + node.val
            if not node.left and not node.right:
                return current
            return dfs(node.left, current) + dfs(node.right, current)
        return dfs(root, 0)


