# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        if not inorder or not postorder:
            return []
        self.hashmap = {val:index for index, val in enumerate(inorder)}
        self.idx = len(postorder)-1
        return self.recurse(postorder, 0, len(inorder) - 1)
        
    def recurse(self, postorder, start, end):
        if start > end:
            return
        rootVal = postorder[self.idx]
        self.idx -= 1
        index = self.hashmap[rootVal]
        root = TreeNode(rootVal)
        root.right = self.recurse(postorder, index + 1, end)
        root.left = self.recurse(postorder, start, index-1)
       
        return root

            
        
