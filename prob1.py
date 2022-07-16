# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        if(len(preorder) == None or len(inorder) == None):
            return None
    
        self.ind = 0
        self.hm = dict()
        for i in range(len(inorder)):
            self.hm[inorder[i]] = i
        
        return self.helper(preorder,inorder,0,len(inorder)-1)
    
    def helper(self,preorder,inorder,start,end):
        if(start > end):
            return None
        rootval = preorder[self.ind]
        self.ind += 1
        root = TreeNode(rootval)
        rootidx = self.hm.get(rootval)
        root.left = self.helper(preorder,inorder,start,rootidx - 1)
        root.right=self.helper(preorder,inorder,rootidx+1,end)
        
        
        return root