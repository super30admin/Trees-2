# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
# Time Complexity: O(n)
# Space Complexity: O(h)  h - height of the tree
class Solution(object):
    #     Define the final sum variable
    curr_sum = 0

    #     Defined recursive function to get the sum of the leaf node
    def getSum(self, root, no_sum):
        #
        #       Checking for base condition if root is null return to previous stage
        #         Base
        if not root:
            return
        # Logic
        #         Calculating the current sum and calling for current root left child with the curren tsum
        no_sum = no_sum * 10 + root.val
        self.getSum(root.left, no_sum)
        #
        #       As we are doing inorder traversal here we need to check if the current root has left and righ tchild , if not then add the current sum to final result
        # As we will be reachig the leaf node
        if not root.left and not root.right:
            self.curr_sum += no_sum
        #
        #       Call the same traversla on roght child of the tree
        self.getSum(root.right, no_sum)

    def sumNumbers(self, root):
        #         Calling recursive function on the root of the tree
        if not root:
            return 0
        self.getSum(root, 0)
        #         returning the final result
        return self.curr_sum
        """
        :type root: TreeNode
        :rtype: int
        """
