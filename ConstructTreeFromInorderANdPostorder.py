# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):

    hashmap={}
    def buildTree(self, inorder, postorder):
        """
        :type inorder: List[int]
        :type postorder: List[int]
        :rtype: TreeNode
        """
        #optimized solution T.C and S.C is O(N)
        self.idx = len(postorder) - 1
        self.hashmap = {}
        for i in range(0,len(inorder)):
            self.hashmap[inorder[i]]=i
        return self.helper(postorder,inorder,0,len(postorder)-1)
    def helper(self,postorder,inorder,start,end):
        #base
        
        if start>end:
            return None
        rootVal = postorder[self.idx]
        self.idx -=1
        root = TreeNode(rootVal)
        rootIndex = self.hashmap.get(rootVal)
        root.right = self.helper(postorder,inorder,rootIndex+1,end)
        root.left = self.helper(postorder,inorder,start,rootIndex - 1)
        return root 
        
        
        
#         #T.C = O(n^2)
#         #S.C = O(n^2)
#         if len(inorder)==0:
#             return None
#         idx = len(postorder) - 1
#         rootVal = postorder[idx]
#         root = TreeNode(rootVal)
#         index = -1
#         for i in range(0,len(inorder)):
#             if(inorder[i]==rootVal):
#                 index = i
#                 break
#         inorderLeft = inorder[0:index]
#         inorderRight = inorder[index+1:len(inorder)]
#         postorderLeft = postorder[0:index]
#         postorderRight = postorder[index:len(postorder)-1]
#         root.left = self.buildTree(inorderLeft,postorderLeft)
#         root.right = self.buildTree(inorderRight,postorderRight)
#         return root