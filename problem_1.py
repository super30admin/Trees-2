# Time O(N)
# Space O(N)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.map = {}
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        if inorder is None or postorder is None:
            return None 
        for i, val in enumerate(inorder):
            self.map[val] = i
        self.idx = len(postorder) - 1

        return self.recurse(postorder, 0, len(postorder) - 1)
    
    def recurse(self, postorder, start, end):
        # base
        if start > end:
            return None

        #logic 
        root_val = postorder[self.idx]
        self.idx -= 1
        root = TreeNode(root_val)
        root_idx = self.map[root_val]
        root.right = self.recurse(postorder, root_idx + 1, end)
        
        root.left = self.recurse(postorder, start, root_idx - 1)
        
        
        return root
        
        