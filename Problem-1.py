#106. Construct Binary Tree from Inorder and Postorder Traversal
# Time Complexity :O(n)
# Space Complexity :O(h)
# Did this code successfully run on Leetcode :yes
# Any problem you faced while coding this :no


# Your code here along with comments explaining your approach
#from postorder identify the root element from last element in aray
# fint the root element index in the inorder array
# Inorder array, everything on left of root is left subtree of root and everything on right is right subtree of root
#make recusive calls to implement the above logic
#time - O(n)
#space - O(h)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        self.idx=len(postorder)-1 # index of postorder list
        d=dict()##map for maintaining index of values in inorder
        for i in range(0, len(inorder)):
            d[inorder[i]]=i
        return self.helper(postorder, d, 0,len(inorder)-1)
    
    def helper(self,postorder, d, start, end):
        if(start>end):
            return None

        curr=postorder[self.idx]
        print(self.idx)
        root=TreeNode(curr)
        self.idx-=1
        root.right=self.helper(postorder, d, d[curr]+1, end)#right subtree of curr node
        root.left=self.helper(postorder, d, start, d[curr]-1)#left subtree of curr node
        return root
