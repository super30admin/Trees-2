"""
Time complexity O(N^2)
Space complexity O(N^2)

"""


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution_notoptimal:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        if len(preorder)==0 or len(inorder)==0:
            return None
        rootval=preorder[0]
        root=TreeNode(rootval)
        rootIdx=-1
        for i in range(len(inorder)):
            if(inorder[i]==rootval):
                rootIdx=i
        preL=preorder[1:rootIdx+1]
        preR=preorder[rootIdx+1:len(preorder)]
        inL=inorder[0:rootIdx]
        inR=inorder[rootIdx+1:len(inorder)]
        
        root.left=self.buildTree(preL,inL)
        root.right=self.buildTree(preR,inR)
        return root