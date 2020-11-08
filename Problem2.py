# Time Complexity : O(n)
# Space Complexity :O(l) where l is number of leaves
# Did this code successfully run on Leetcode :Yes
# Any problem you faced while coding this : No


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def sumNumbers(self, root):
        sm = 0
        stack = []

        def helper(root, prev=""):
            if root:
                present = prev + str(root.val)
                if root.left:
                    helper(root.left, present)
                if root.right:
                    helper(root.right, present)
                if root.left is None and root.right is None:
                    stack.append(present)

        if root:
            helper(root)
            for x in stack:
                sm += int(x)
        return sm

#Here I hae defined a helper function to recursively go over all the nodes of the tree and add the combined elements to
# a list id the node is a leaf node. Then fo each number in he list, I have taken the sum and have returned the sum