# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> TreeNode:
        if postorder == None or len(postorder) == 0:
            return None
        n = len(postorder)
        postorder = n-1
        inorderMap = {}
        for i in range(0,n):
            inorder[i] = i
        self.helper(inorder, postorder, 0, n-1)
        
    def helper(self,inorder, postorder, start, end) -> TreeNode:
        #base
        if start > end:
            return None
        
        #logic
        rootVal = postorder[postIdx]
        postIdx -= 1
        root = TreeNode(rootval)
        
        # find root index in inorder
        rootIdx = inorderMap[rootval]
        root.right = self.helper(inorder, postorder, rootIdx+1, start)
        root.left = self.helper(inorder, postorder, start, rootIdx-1)
        
        return root
