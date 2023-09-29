# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        self.idx = len(inorder) - 1
        self.d = {}
        self.postorder = postorder
        for i,val in enumerate(inorder):
            self.d[val] = i
            
        def helper(postorder,inorder,start,end):
            if start > end:
                return None
            rootVal = postorder[self.idx]
            self.idx -= 1
            root = TreeNode(rootVal)
            pos = self.d[rootVal]
            root.right = helper(postorder,inorder,pos+1,end)
            root.left = helper(postorder,inorder,start,pos-1)
            
            return root
        return helper(postorder,inorder,0,len(inorder)-1)
        