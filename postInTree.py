# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
idx = 0
maps = {}
class Solution:
   
    def fetchTree(self,inorder, preorder, start, end ):
        global idx, maps
        if start > end:# or idx > len(preorder):
            return None
        rootval = preorder[idx]
        idx = idx + 1
        root = TreeNode(rootval) 
        rootidx = maps.get(rootval)  
        root.left =  self.fetchTree(inorder, preorder, start, rootidx - 1,)
        root.right = self.fetchTree(inorder, preorder, rootidx + 1 , end)
        return root
    
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        global maps
        global idx
        idx = 0
        maps = {}
        if inorder is None or len(inorder) < 1:
            return None
        # if len(inorder) == 1:
        #     return TreeNode(inorder[0]) 
        i = 0
        while( i < len(inorder)):
            maps[inorder[i]] = i
            i += 1
        return self.fetchTree(inorder, preorder, 0 , len(preorder) - 1)
   
