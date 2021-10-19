#TC = O(n)
#SC = O(height of tree)


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        def recur(r, curr_number):
            nonlocal summ
            if r:
                curr_number = curr_number * 10 + r.val
                # if it's a leaf, update root-to-leaf sum
                if not (r.left or r.right):
                    summ += curr_number

                recur(r.left, curr_number)
                recur(r.right, curr_number)

        summ = 0
        recur(root, 0)
        return summ





