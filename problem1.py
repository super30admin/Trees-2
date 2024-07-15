# time: O(n)
#  space: O(n)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    map = {}
    ind = 0
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        self.ind = len(postorder)-1
        for i in range(len(inorder)):
            self.map[inorder[i]] = i
        
        return self.helper(inorder, postorder, 0, len(postorder)-1)

    def helper(self, inorder, postorder, start, end):
        if start > end:
            return 
        
        rootVal = postorder[self.ind]
        self.ind-=1
        root = TreeNode(rootVal)
        rootInd = self.map[rootVal]
        root.right = self.helper(inorder, postorder, rootInd+1, end)
        root.left = self.helper(inorder, postorder, start, rootInd-1)

        return root



        