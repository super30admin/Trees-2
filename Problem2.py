# Problem2 (https://leetcode.com/problems/sum-root-to-leaf-numbers/)
# Time Complexity: O(n), we visit every node exactly once
# Space Complexity: O(h), h is the height of the tree, this space comes from the recursion call stack

# Approach: We walk down the tree from root to leaf using recursion.
# As we move to each node, we build a number by taking the number built so far, multiplying it by 10, then adding the current node's value.
# When we reach a leaf node, the number is complete, so we add it to a running total.
# We keep doing this for every path in the tree until all leaves are visited, then return the total.

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        self.result = 0         # this will hold the total sum of all root to leaf numbers, starts at 0 since nothing is added yet
        self.helper(root, 0)    # start the recursion at the root, with current_number as 0 since nothing has been built yet
        return self.result  

    def helper(self, root, current_number):
        if root is None:  # if we have gone past a leaf, there is nothing to do here
            return

        current_number = current_number * 10 + root.val  
        # shift the digits built so far one place to the left, then add the current node's value this is how numbers are built digit by digit.
        if root.left is None and root.right is None:  # this means the current node is a leaf, no children on either side
            self.result += current_number  
            # since this is a leaf, current_number is now a complete root to leaf number, so we add it to the total

        self.helper(root.left, current_number)  
        # move to the left child, carrying forward the number built so far so it can keep building on it
        self.helper(root.right, current_number)  
        # move to the right child, carrying forward the same number built so far, independent of what the left side does