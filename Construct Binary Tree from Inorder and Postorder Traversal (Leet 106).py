# Binary Search (Efficient)
# Time: O(n)
# Space: O(n)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    index = 0
    hm = dict()
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        if len(postorder) is None:
            return None
        
        self.index = len(postorder)-1
        self.hm = {}
        
        for i in range(len(inorder)):
            self.hm[inorder[i]] = i
        
        return self.helper(postorder, 0, len(postorder)-1)
    
    def helper(self, postorder, start, end):
        if start > end:
            return None
        
        rootval = postorder[self.index]
        self.index -= 1
        rootindex = self.hm[rootval]
        root = TreeNode(rootval)
        
        root.right = self.helper(postorder, rootindex+1, end)
        root.left = self.helper(postorder, start, rootindex-1)
        return root
        