# Time complexity - O(n^2) # because need to find index of inorder along with the recursion call
# Space complexity - O(n) # recursive call stack for skewed tree

# Approach - dfs - Take the last node of postorder as root of the tree, find the index of the root in 
# inorder. Perform dfs on first half of both postorder and inorder and assign it to root.left. 
# Perform dfs on remaining of inorder and postorder assign it to root.right. Note: exclude the last
# element of postorder since it was the start of our tree.

from typing import List, Optional
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        if not inorder or not postorder:
            return None
        
        root = TreeNode(postorder[-1])
        i = inorder.index(postorder[-1])

        root.left = self.buildTree(inorder[:i], postorder[:i])
        root.right = self.buildTree(inorder[i+1:], postorder[i:-1])

        return root