# Time Complexity : O(N) 
# Space Complexity :    O(N) 
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : NO



# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> TreeNode:
        if len(inorder)==0 or len(postorder)==0:
            return None
        
        self.map = {}
        self.index = len(postorder)-1 #index in postorder
        
        for i in range(len(inorder)):
            self.map[inorder[i]]=i
            
        return self.helper(postorder,0,len(inorder)-1)
    
    def helper(self,postorder,start,end):
        if start>end :
            return 
        
        rVal = postorder[self.index]
        root = TreeNode(rVal)
        self.index-=1
        inorderIdx = self.map[rVal]
        
        root.right = self.helper(postorder,inorderIdx+1,end)
        root.left = self.helper(postorder,start,inorderIdx-1)
        return root


        