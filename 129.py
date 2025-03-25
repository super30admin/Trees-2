# TC : O(n)
# SC : O(n)
# Definition for a binary tree node.
class TreeNode:
   def __init__(self, val=0, left=None, right=None):
       self.val = val
       self.left = left
       self.right = right
from typing import Optional


class Solution:
    def __init__(self):
        self.Sum = 0
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        if root == None:
            return 0
        self.DFS(root,0)
        return self.Sum

    def DFS(self, root: TreeNode, currentSum):
        if root == None:
            return
        if (root.left == None and root.right == None):
            self.Sum = self.Sum + (currentSum*10  + root.val)
            return
        self.DFS(root.left, currentSum*10 + root.val)
        self.DFS(root.right, currentSum*10 + root.val)
        