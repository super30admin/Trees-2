"""
Time complexity O(N)
Space complexity O(1)

"""


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution_buildTreeR:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        self.d={}
        self.idx=0
        for i in range(len(inorder)):
            self.d[inorder[i]]=i
            
        return self.helper(preorder,inorder,0,len(inorder)) 
    
    def helper(self,preorder,inorder,start,end):
        if(start>=end):
            return None
        rootval=preorder[self.idx]
        rootIdx=self.d[rootval]
        root=TreeNode(rootval)
        self.idx+=1
        root.left=self.helper(preorder,inorder,start, rootIdx)
        root.right=self.helper(preorder,inorder,rootIdx+1, end)
        return root