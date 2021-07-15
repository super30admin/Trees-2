# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> TreeNode:
        def treeHelper(postorder,inorder,start,end):
            if start>end:
                return None
            rootval=postorder[self.postindex]
            self.postindex-=1
            root=TreeNode(rootval)
            
            rootininorder=self.store[rootval]
            root.right=treeHelper(postorder,inorder,rootininorder+1,end)
            root.left=treeHelper(postorder,inorder,start,rootininorder-1)
            return root
        self.postindex=len(postorder)-1
        self.store=dict()
        for i in range(len(inorder)):
            self.store[inorder[i]]=i
        return treeHelper(postorder,inorder,0,len(postorder)-1)
        #Time O(n)
        #Space O(n^2)
        
#         #Without hashmap
#         def treeHelper(postorder,inorder,start,end):
#             if start>end:
#                 return None
#             rootval=postorder[self.postindex]
#             self.postindex-=1
#             root=TreeNode(rootval)
            
#             rootininorder=inorder.index(rootval, start, end+1)
#             root.right=treeHelper(postorder,inorder,rootininorder+1,end)
#             root.left=treeHelper(postorder,inorder,start,rootininorder-1)
#             return root
#         self.postindex=len(postorder)-1
#         return treeHelper(postorder,inorder,0,len(postorder)-1)
#         #Time O(n^2)
#         #Space O(n^2)
        
