"""
Problem: 106. Construct Binary Tree from Inorder and Postorder Traversal
Leetcode: https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
Solution: Recursion
Time Complexity: O(n), we traverse all nodes in the tree
Space Complexity: O(n), since we store the entire tree.
"""


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    # class variables
    inorder = []
    postorder = []
    index_map = {}
    post_idx = len(postorder) - 1

    def buildTree(self, inorder, postorder) -> TreeNode:
        self.inorder = inorder
        self.postorder = postorder

        # Create a hashmap with inorder values and indices
        idx = 0
        for i in range(len(inorder)):
            self.index_map[inorder[i]] = i
        return self.helper(0, len(inorder) - 1)

    def helper(self, left, right):
        # Base case
        if left > right:
            return None

        # find the root from postorder list
        root_val = self.postorder[self.post_idx]
        index = self.index_map[root_val]
        self.post_idx -= 1

        root = TreeNode(root_val)

        # Because this is postorder traversal, we've to build right side first
        root.right = self.helper(index + 1, right)
        root.left = self.helper(left, index - 1)
        return root




