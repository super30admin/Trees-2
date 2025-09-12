"""
TC: O(N) {we visit each node exactly once, and index lookup in hashmap is O(1)}
SC: O(N) {for the recursion stack and hashmap storing inorder indices}

Approach:

We first create a hashmap of inorder values to their indices for O(1) lookups. Then we define a helper function 
that takes the start and end indices for the current segment of both inorder and postorder arrays. 

At each call, the last element in the current postorder segment is the root. We find the root's index in inorder 
to calculate left_size, which tells us how many nodes belong to the left subtree. Using left_size, we recursively 
construct the left and right subtrees by passing the correct ranges in both inorder and postorder arrays. 

Finally, we return the root of the reconstructed tree.

The problem ran successfully on LeetCode.
"""

from typing import Optional, List
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def _helper(self, post_start, post_end, in_start, in_end):

        if post_start >= post_end or in_start >= in_end:
            return None
        

        root = TreeNode(self.postorder[post_end - 1])

        idx = self.d1[self.postorder[post_end - 1]]

        left_size = idx - in_start  # number of nodes in left subtree

        root.left = self._helper(post_start, post_start + left_size, in_start, idx)
        root.right = self._helper(post_start+left_size, post_end - 1, idx+1, in_end)

        return root
    
        
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        self.d1 = {val: idx for idx, val in enumerate(inorder)}
        self.postorder = postorder

        return self._helper(0, len(postorder), 0, len(inorder))

