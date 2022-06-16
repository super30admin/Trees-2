# T O(n), S:O(h)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    result = 0

    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        self.helper(root, 0)
        return self.result

    def helper(self, root, curr):
        if (root == None):
            return  # reached children
        if (root.right == None and root.left == None):  # check if it is a leaf node
            self.result += ((curr * 10) + root.val)

        self.helper(root.left, ((curr * 10) + root.val))
        self.helper(root.right, ((curr * 10) + root.val))



