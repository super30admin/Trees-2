from typing import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


# Approach 1: Recursive Depth-First Search (DFS)
# We perform a DFS and accumulate the numbers formed by root-to-leaf paths.
# As we traverse down, we multiply the current sum by 10 and add the current node's value.
# TC: O(n) Each node is visited once
# SC: O(h), where h is the height of the tree (due to recursion stack)


class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:

        return self.helper(root, 0)

    def helper(self, root: Optional[TreeNode], s: int) -> int:
        # Base case: if the node is None, return 0 (no number to add)
        if root is None:
            return 0

        # If it's a leaf node, return the current number formed (multiply by 10 and add the node's value)
        if root.left is None and root.right is None:
            return s * 10 + root.val

        # Recur for both left and right subtrees
        return self.helper(root.left, s * 10 + root.val) + self.helper(
            root.right, s * 10 + root.val
        )

    # Approach 2: Iterative Breadth-First Search (BFS) with Queue
    # We use a queue to simulate the DFS and iteratively sum all root-to-leaf numbers.
    # TC: O(n) Each node is processed once
    # SC: O(n), because we store the nodes and current path sums in the queue.

    def IterativeSoln1(self, root: Optional[TreeNode]) -> int:
        if root is None:
            return 0

        res = 0
        queue = [(root, root.val)]  # Queue stores tuples of (node, current path sum)

        while queue:
            node, val = queue.pop(0)

            # If it's a leaf node, add the path sum to the result
            if node.left is None and node.right is None:
                res += val
            else:
                # Add the left and right children to the queue
                if node.left:
                    queue.append((node.left, val * 10 + node.left.val))
                if node.right:
                    queue.append((node.right, val * 10 + node.right.val))

        return res

    # Approach 3: Iterative Depth-First Search (DFS) with Stack
    # We use a stack to simulate recursion and iteratively sum all root-to-leaf numbers.
    # TC: O(n) Each node is processed once
    # SC: O(n), because we store the nodes and current path sums in the stack.

    def IterativeSoln2(self, root: Optional[TreeNode]) -> int:

        if root is None:
            return 0

        res = 0
        stack = [(root, root.val)]  # Stack stores tuples of (node, current path sum)

        while stack:
            node, val = stack.pop()

            # If it's a leaf node, add the path sum to the result
            if node.left is None and node.right is None:
                res += val
            else:
                # Push the left and right children onto the stack
                if node.left:
                    stack.append((node.left, val * 10 + node.left.val))
                if node.right:
                    stack.append((node.right, val * 10 + node.right.val))

        return res


# Helper function to create a binary tree
def build_sample_tree() -> TreeNode:
    root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(3)
    root.left.left = TreeNode(4)
    root.left.right = TreeNode(5)
    root.right.left = TreeNode(6)
    root.right.right = TreeNode(7)
    return root


if __name__ == "__main__":
    #        1
    #       / \
    #      2   3
    #     / \ / \
    #    4  5 6  7
    root = build_sample_tree()

    solution = Solution()

    print("Recursive DFS:", solution.sumNumbers(root))
    print("Iterative BFS:", solution.IterativeSoln1(root))
    print("Iterative DFS:", solution.IterativeSoln2(root))
