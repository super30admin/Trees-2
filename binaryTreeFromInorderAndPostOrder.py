# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    # TC : O(n)
    # SC : O(n)
    def createTree(self,postorder: List[int],start,end):
        if start > end or self.idx < 0:
            return None
        rootval = postorder[self.idx]
        self.idx -= 1
        root = TreeNode(rootval)
        rootidx = self.hmap[root.val]
        root.right = self.createTree(postorder,rootidx+1,end)
        root.left = self.createTree(postorder,start,rootidx-1)
        
        return root
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        
        if postorder is None or len(postorder) == 0 or len(inorder)==0:
            return None
        
        n = len(postorder)
        self.idx = n-1
        self.hmap = {}
        for i in range(len(inorder)):
            self.hmap[inorder[i]] = i
        return self.createTree(postorder,0,n-1)
        