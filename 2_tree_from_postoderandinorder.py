// Time Complexity : O(n) 
// Space Complexity : O(h) recursive stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        
        self.preindex=0
        return self.btr(preorder,inorder,0,len(inorder)-1)
    
    def btr(self, preorder,inorder,start,end):
        
        
        if start>end:
            return None
        
        val=preorder[self.preindex]
        index=self.find_val(inorder,start,end,val)
        
        self.preindex=self.preindex+1
        
        node=TreeNode(val)
       
        node.left= self.btr(preorder,inorder,start,index-1)
        node.right = self.btr(preorder,inorder,index+1,end)
    
        return node
    
    
    
    def find_val(self,inorder,start,end,val):
        
        for index in range(start,end+1):
            if inorder[index] == val:
                return index
        return -1