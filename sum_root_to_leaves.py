# Definition for a binary tree node.
from typing import Optional


# TC :O(n) visiting all node
# SC :O(height of tree) 

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        self.g_sum = 0
        def traversor(root, num):
            if not root: # null node check
                return
            if root.left == None and root.right == None: # leaf node
                self.g_sum = self.g_sum + num*10 + root.val

            traversor(root.left, num*10 + root.val) # st.push
            traversor(root.right, num*10 + root.val) # st.push
        traversor(root, 0)
        
        return self.g_sum
        