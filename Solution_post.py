"""
Time complexity is O(N)
Space Complexity is O(1)

we recursively call right first because we decrement the indx of postorder 
"""


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution_post:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> TreeNode:
        self.d={}
        self.idx=len(postorder)-1
        for i in range(len(inorder)):
            self.d[inorder[i]]=i
            
        return self.helper(postorder,inorder,0,len(inorder)-1) 
    
    def helper(self,postorder,inorder,start,end):
        if(start>end):
            return None
        
        rootval=postorder[self.idx]
        rootIdx=self.d[rootval]
        root=TreeNode(rootval)
        self.idx-=1
        root.right=self.helper(postorder,inorder,rootIdx+1, end)
        root.left=self.helper(postorder,inorder,start, rootIdx-1)
      
        return root