# Time Complexity :O(n) where n is number of nodes
# Space Complexity :O(depth)
#  Did this code successfully run on Leetcode :yes
# Any problem you faced while coding this :no
#Leetcode : 129

# Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
#
# An example is the root-to-leaf path 1->2->3 which represents the number 123.
#
# Find the total sum of all root-to-leaf numbers.
#
# Note: A leaf is a node with no children.
#
# Input: [1, 2, 3]
#  1
# / \
# 2   3
#
# Output: 25
# Explanation:
# The root-to-leaf path 1->2 represents the number 12.
# The root-to-leaf path 1->3 represents the number 13.
# Therefore, sum = 12 + 13 = 25.
#
#
# Input: [4,9,0,5,1]
#     4
#    / \
#   9   0
#  / \
# 5   1
# Output: 1026
# Explanation:
# The root-to-leaf path 4->9->5 represents the number 495.
# The root-to-leaf path 4->9->1 represents the number 491.
# The root-to-leaf path 4->0 represents the number 40.
# Therefore, sum = 495 + 491 + 40 = 1026.

# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution(object):
    # Setting a global output
    def __init__(self):
        self.output = 0

    def sumNumbers(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        # Checking if it is none.
        if not root:
            return 0

        def helper(root, current):
            # recursive fn where this is a base case when there is just right child and no left or vice versa.
            if root == None:
                return

            # The current is the current total val
            current = current * 10 + root.val
            # Main condition when reached leaf then add that value to output
            if not root.left and not root.right:
                self.output += current
                return

            # Going left and right.
            helper(root.left, current)
            helper(root.right, current)

        helper(root, 0)
        return self.output

root = TreeNode(1)
root.left = TreeNode(2)
root.right = TreeNode(3)
print(Solution().sumNumbers(root))