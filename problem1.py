# https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/

# Time Complexity : O(N) is Number of nodes in the tree.
# Space Complexity : O(H) where H is height of the tree, and stack space is used.
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None

# Your code here along with comments explaining your approach.
# Approach - We add the inorder values into a hashmap, and we iterate over the post-order using a global
# index value, from the end. We search for pre-order node in the hashmap and append it to the root node
# We update the index and build the tree.

from typing import List, Optional


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    index: int

    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        inorder_hash = {}
        self.index = len(inorder) - 1

        for cur_index in range(len(inorder)):
            inorder_hash[inorder[cur_index]] = cur_index

        return self.build(postorder, inorder_hash, 0, len(inorder) - 1)

    def build(self, postorder, inorder_hash, start, end):
        if self.index < 0 or start > end:
            return None

        cur_node_value = postorder[self.index]
        self.index -= 1

        cur_index = inorder_hash[cur_node_value]
        cur = TreeNode(cur_node_value)

        cur.right = self.build(postorder, inorder_hash, cur_index + 1, end)
        cur.left = self.build(postorder, inorder_hash, start, cur_index - 1)

        return cur
