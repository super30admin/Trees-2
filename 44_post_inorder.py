# S30 Big N Problem #44 {Medium}
# LC pproblem - 106

# Recursive approach

# Construct Binary Tree from Inorder and Postorder Traversal

# Time Complexity : O(nlogn) n=no. of nodes in the tree
# Space Complexity : O(1) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No 

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> TreeNode:
        
        return self.helper(len(postorder)-1,0,len(inorder)-1,inorder,postorder)
        
    def helper(self,postroot,instart,inend,inorder,postorder):
        
        if postroot<0 or instart>inend:
            return None
        
        for i in range(instart,inend+1,1):
            if inorder[i]==postorder[postroot]:
                iindex=i
                break
                
        root=TreeNode(postorder[postroot])
        
        root.left=self.helper(postroot-(inend-iindex)-1,instart,iindex-1,inorder,postorder)
        root.right=self.helper(postroot-1,iindex+1,inend,inorder,postorder)
        
        return root
        
        
        
        