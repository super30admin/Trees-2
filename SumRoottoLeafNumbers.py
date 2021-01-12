# Time Complexity : O(H)
# Space Complexity : O(H)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :

# Your code here along with comments explaining your approach
# Using Iterative Preorder Traversal and storing node and sum for each node in the left and right subtree on stack
# If the node is the leaf node that is it doesnt have left or right child then add the sum to res


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumNumbers(self, root: TreeNode) -> int:
        if not root:
            return 0

        def preorder(root):
            stack = [(root, 0)]
            res = 0
            while stack:
                node, num = stack.pop()
                if node:
                    num = num * 10 + node.val
                    if not node.right and not node.left:
                        res += num
                    if node.right:
                        stack.append((node.right, num))
                    if node.left:
                        stack.append((node.left, num))
            return res

        output = preorder(root)
        return output
