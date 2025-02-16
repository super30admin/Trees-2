# 129. Sum Root to Leaf Numbers

# Time Complexity: O(n)
# Space Complexity: O(h)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No

# Intuition:
# Use DFS to traverse the tree and calculate the sum of all root to leaf numbers.
# Use a helper function to pass the current number and the current node.
# If the node is a leaf, add the current number to the total sum.
# Otherwise, continue the traversal.

class Solution:
    def sumNumbers(self, root: TreeNode) -> int:
        def preorder(r: TreeNode, curr_number: int) -> None:
            nonlocal root_to_leaf
            if r:
                curr_number = curr_number * 10 + r.val
       
                if not (r.left or r.right):
                    root_to_leaf += curr_number

                preorder(r.left, curr_number)
                preorder(r.right, curr_number)

        root_to_leaf = 0
        preorder(root, 0)
        return root_to_leaf