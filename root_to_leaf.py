"""
TC:O(n)
SC:O(h), h being height of tree
"""
class Solution:
    def sumNumbers(self, root: TreeNode):
        def preorder(r, curr_number):
            nonlocal root_to_leaf
            if r:
                curr_number = curr_number * 10 + r.val
                # if it's a leaf, update root-to-leaf sum
                if not (r.left or r.right):
                    root_to_leaf += curr_number
                preorder(r.left, curr_number)
                preorder(r.right, curr_number)
        root_to_leaf = 0
        preorder(root, 0)
        return root_to_leaf
