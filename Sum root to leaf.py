# Time Complexity : O(n)
# Space Complexity : O(H), height of tree

# The code ran on LeetCode

# Traverse over the tree and maintain the number seen until a particular node in a local variable. When we reach a leaf node, add that value to the result

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        self.sum = 0

        def helper(root, curNum):

            if not root:
                return

            if root and root.left == None and root.right == None:
                self.sum += curNum*10 + root.val

            helper(root.left, curNum*10 + root.val)
            helper(root.right, curNum*10 + root.val)

        helper(root, 0)
        return self.sum