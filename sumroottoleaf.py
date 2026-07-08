class Solution:
    def sumNumbers(self, root):

        def dfs(node, current_sum):
            if not node:
                return 0

            current_sum = current_sum * 10 + node.val

            # leaf node
            if not node.left and not node.right:
                return current_sum

            return dfs(node.left, current_sum) + dfs(node.right, current_sum)

        return dfs(root, 0)

    # TC - O(n)
    # SC - O(h) - recursion stack