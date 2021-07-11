# Time Complexity: O(n), where n is number of nodes in the tree
# Space Complexity: O(h), where h is the height of the tree
# Did this code successfully run on Leetcode: Yes

# Solution:

class Solution:
    def sumNumbers(self, root: TreeNode) -> int:
        if not root:
            return 0

        self.result = 0
        self.helper(root, 0)
        return self.result

    def helper(self, root: TreeNode, currsum: int) -> None:
        if not root:
            return

        # Form the number from root to leaf node
        currsum = currsum * 10 + root.val

        # If it is leaf node, add the root to leaf number to the result
        if not root.left and not root.right:
            self.result += currsum
            return

        # Recursively traverse to the left and right nodes and perform above steps
        self.helper(root.left, currsum)
        self.helper(root.right, currsum)


