# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.indx=0
        self.inordermap=dict()
    def buildTree(self, inorder: List[int], postorder: List[int]) -> TreeNode:
        self.indx=len(postorder)-1
        for i in range(len(inorder)):
            self.inordermap[inorder[i]]=i
        return self.helper(postorder, 0, len(postorder)-1)
    def helper(self, postorder, start, end):
        if start>end or self.indx<0:
            return
        rootVal=postorder[self.indx]
        self.indx-=1
        root=TreeNode(rootVal)
        root.right=self.helper(postorder, self.inordermap[rootVal]+1, end)
        root.left=self.helper(postorder, start, self.inordermap[rootVal]-1)
        return root
    
"""Time complexity-O(n) as we are using hashmap for inorder list
    Space complexity-O(n) as using hashmap as auxilary datastruct"""
#     def buildTree(self, inorder: List[int], postorder: List[int]) -> TreeNode:
#         if not postorder:
#             return
#         rootVal=postorder[len(postorder)-1]
#         root=TreeNode(rootVal)
#         inorderRootindx=0
#         for i in range(len(inorder)):
#             if rootVal==inorder[i]:
#                 inorderRootindx=i
#                 break
#         postleft=postorder[:inorderRootindx]
#         postright=postorder[inorderRootindx:len(inorder)-1]
#         inleft=inorder[:inorderRootindx]
#         inright=inorder[inorderRootindx+1:len(inorder)]
#         root.left=self.buildTree(inleft, postleft)
#         root.right=self.buildTree(inright, postright)
#         return root
    
#      """Naive approach
#     Time complexity-O(n^2) as we are looping over the elements present in inorder list in each recursion to get current root index
#     space complexity-O(n^2) as we are creating O(n) extra space at each node(creating 4 different arrays in each recursion)"""
        
        
        

        
