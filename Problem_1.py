from typing import List
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> TreeNode:
        if len(postorder) == 0 or len(inorder) == 0:
            return None
        self.map = {}
        self.idx = len(postorder) - 1
        for i in range(len(inorder)):
            self.map[inorder[i]] = i
        return self.helper(inorder, postorder, 0, len(inorder) - 1) 
    
    def helper(self, inorder: List[int], postorder: List[int], start: int, end: int) -> TreeNode:
        # base
        if start > end:
            return None
        
        # logic
        rootVal = postorder[self.idx]
        root = TreeNode(rootVal)
        self.idx -= 1
        
        rootIdx = self.map[rootVal]
        root.right = self.helper(inorder, postorder, rootIdx + 1, end)
        root.left = self.helper(inorder, postorder, start, rootIdx - 1)
        
        return root

# Time Complexity: O(n)
# Time Complexity: O(n) -> used for map