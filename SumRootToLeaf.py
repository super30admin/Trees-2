'''
    Time Complexity:
        O(n) (where h = number of nodes)

    Space Complexity:
        O(h) (where h = height of the tree)

    Did this code successfully run on LeetCode?:
        Yes

    Problems faced while coding this:
        None

    Approach:
        PreOrder fashion.
        Maintain a global variable and add the current (local) sum to it when you encounter a leaf node, i.e. node.left and node.right are null.
'''
class Solution:
    def __init__(self):
        self.total_sum = 0

    def sumNumbers(self, root: TreeNode) -> int:
        self.sum_tree(root, 0)
        return self.total_sum

    def sum_tree(self, root, curr_sum):
        if root is None:
            return

        curr_sum = curr_sum * 10 + root.val

        if root.left is None and root.right is None:
            self.total_sum += curr_sum
            return

        self.sum_tree(root.left, curr_sum)
        self.sum_tree(root.right, curr_sum)
