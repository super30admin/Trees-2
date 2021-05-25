# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> TreeNode:
        if len(postorder)==0:
            return None
        self.idx = len(postorder)-1
        dictmap = dict()
        for i in range(len(inorder)):
            dictmap[inorder[i]] = i
        val = self.helper(postorder,inorder,0,len(postorder)-1,dictmap)
        return val
    def helper(self,postorder,inorder,start,end,dictmap):
        if start>end:
            return None
        value = postorder[self.idx]
        self.idx = self.idx - 1

        root = TreeNode(value)
        hashvalue = dictmap[value]
        root.right = self.helper(postorder,inorder,hashvalue+1,end,dictmap)
        root.left = self.helper(postorder,inorder,start,hashvalue-1,dictmap)
        return root
     
