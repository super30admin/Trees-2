
from typing import Optional, List


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        self.idx = len(postorder) - 1
        self.d = {}

        for i in range(len(inorder)):
            self.d[inorder[i]] = i
        
        def helper(start, end):
            if start > end:
                return None
            
            rootVal = postorder[self.idx]
            self.idx -= 1
            root = TreeNode(rootVal)
            rootIdx = self.d[rootVal]

            root.right = helper(rootIdx + 1, end)
            root.left = helper(start, rootIdx - 1)

            return root
        
        return helper(0, len(postorder) - 1)