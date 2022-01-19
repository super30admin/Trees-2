# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Yes


# Your code here along with comments explaining your approach

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from typing import List, Optional


class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:

        def helper(ileft, iright):

            # condition to check if there are no elements for subtrees
            if ileft > iright:
                return None

            # picking up the last element as a root
            val = postorder.pop()
            root = TreeNode(val)

            idx = hashmap[val]

            # building right subtree
            root.right = helper(idx + 1, iright)

            # building left subtree
            root.left = helper(ileft, idx - 1)
            return root

        # building a hashmap value -> its index
        hashmap = {}

        for idx, r in enumerate(inorder):
            hashmap[r] = idx

        return helper(0, len(inorder) - 1)
