# Time O(N)
# Space O(h)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.total = 0
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        if root is None:
            return 0 
        self.pre_order(root, 0)
        return self.total

    def pre_order(self, root, cur_sum):
        if root is None:
            return
        cur_sum = 10* cur_sum + root.val
        # take sum if a leaf node 
        if root.left is None and root.right is None:
            self.total += cur_sum 
            return
        self.pre_order(root.left, cur_sum)
        self.pre_order(root.right, cur_sum)
        

        