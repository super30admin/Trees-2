# time complexity is o(n), where n is the size of the input
# space complexity is o(h), where h = log(n), n is the size of the input.(Recursive stack space).
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    idx = 0
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        self.idx = len(postorder) - 1
        d = dict()
        for i in range(len(inorder)):
            if(inorder[i] not in d):
                d[inorder[i]] = i
        return self.const(postorder, d, 0, len(inorder)-1)
    def const(self, postorder, d, start, end):
        if(start > end):
            return None
        rootval = postorder[self.idx]
        self.idx -= 1
        root = TreeNode(rootval)
        rootidx = d[rootval]
        root.right = self.const(postorder, d, rootidx+1, end)
        root.left = self.const(postorder, d, start, rootidx-1)
        return root
        
            
    
            
        
