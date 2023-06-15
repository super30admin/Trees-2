# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        """
        Time complexity: O(N), N --> number of nodes in the binary tree.
        Space complexity: O(H), H --> height of the binary tree.
        :type root: TreeNode
        :rtype: int
        """
        # Initialize the sum
        total_sum = 0

        def helper(root, currNum):
            nonlocal total_sum  # Declare total_sum as nonlocal to modify the outer total_sum variable
            if root is None:
                return

            currNum = currNum * 10 + root.val

            if root.left is None and root.right is None:
                total_sum += currNum  # Add the current number to the total_sum when reaching a leaf node

            # Recursively traverse the left and right subtrees
            helper(root.left, currNum)
            helper(root.right, currNum)

        # Call the helper function to calculate the sum of all paths
        helper(root, 0)

        return total_sum
