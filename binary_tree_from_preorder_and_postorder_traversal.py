"""
Problem: 889. Construct Binary Tree from Preorder and Postorder Traversal
Leetcode: https://leetcode.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/
Solution: Recursive approach
Time Complexity: O(N), as we iterate both pre index and post index only once.
Space Complexity: O(height), depending on the height of constructed tree.
"""


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    # class variables
    preIndex, postIndex = 0, 0

    def constructFromPrePost(self, pre, post) -> TreeNode:

        root = TreeNode(pre[self.preIndex])
        self.preIndex += 1

        # means there is still tree left to process, call recursively for left sub tree
        if root.val != post[self.postIndex]:
            root.left = self.constructFromPrePost(pre, post)

        # means there is still tree left to process, call recursively for right sub tree
        if root.val != post[self.postIndex]:
            root.right = self.constructFromPrePost(pre, post)

        self.postIndex += 1
        return root

