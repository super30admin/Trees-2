# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.result = 0

    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        self.helper(root, 0)
        return self.result

    def helper(
        self,
        root,
        curr_num,
    ):
        if root is None:
            return
        curr_num = curr_num * 10 + root.val

        if root.left is None and root.right is None:
            self.result = self.result + curr_num
        self.helper(root.left, curr_num)
        self.helper(root.right, curr_num)


# time complexity is O(n) where n is the number of nodes in the binary tree
# space complexity is O(logn)
