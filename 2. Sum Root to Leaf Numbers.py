# Iterative Solution
# Time Complexity = O(n)
# Space Complexity = O(n) as we're using two stacks

class Solution:
    def sumNumbers(self, root) -> int:
        if not root:
            return 0
        sum_, currSum = 0, 0

        node_stack = []
        num_stack = []

        while root is not None or len(node_stack) > 0:
            while root is not None:
                currSum = currSum * 10 + root.val
                node_stack.append(root)
                num_stack.append(currSum)
                root = root.left

            # Leaf node
            root = node_stack.pop()
            currSum = num_stack.pop()
            if root.left is None and root.right is None:
                sum_ += currSum

            root = root.right
        return sum_