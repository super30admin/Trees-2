# leetcode:accepted
# timecomplexity: o(n)
# space compexity: O(height of tree)
# explianation: leaf node means there are no left or roight child to the node.
# 'So you first find the child node by checking if it hs left child and right child.' .
# whenever you are going to the next level, say from a->b, you multiply a by 10 and b to it.
# When you reach a leaf node, return the previous val*10 + node.val,where that node is the lead node


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def sumNumbers(self, root: TreeNode) -> int:

        def helper(node, val1):
            if node == None:
                return 0
            if (node.left == None and node.right == None):
                return val1 * 10 + node.val
            else:
                return (helper(node.left, val1 * 10 + node.val) + helper(node.right, val1 * 10 + node.val))

        return helper(root, 0)

