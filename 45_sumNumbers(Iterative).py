# accepted in leetcode(129)
# time - O(N), space - O(H)
# iterative solution for sumNumbers using physical stack.
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def sumNumbers(self, root: TreeNode) -> int:
        result = 0
        stack = []
        stack.append(
            (root, 0))  # Adding a tuple inside each stack element(one stores tree node and other store added sum)
        while stack is not None and len(stack) > 0:
            p = stack.pop()
            node = p[0]
            value = p[1]
            if node is not None:
                if node.left is None and node.right is None:
                    result += 10 * value + node.val

                stack.append((node.left, 10 * value + node.val))
                stack.append((node.right, 10 * value + node.val))

        return result