# Problem 1 : Construct Binary Tree from Inorder and Postorder Traversal
# Time Complexity : O(n^2)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :
'''
None
'''

# Your code here along with comments explaining your approach

# Definition for a binary tree node.
from typing import List

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        if not inorder:
            return 
        # in postorder the last element is the root of the tree
        root = TreeNode(postorder.pop())
        # get the index of the root in the inorder list
        indexInorder = inorder.index(root.val)
        # build right tree. In inorder list elements after root are part of right sub tree
        root.right = self.buildTree(inorder[indexInorder+1:], postorder)
        # build left tree. In inorder list elements before root are part of left sub tree
        root.left = self.buildTree(inorder[:indexInorder], postorder)

        return root
