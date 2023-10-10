# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
#Time Complexity: O(n) where n for dictionary created
# Space Complecxity: O(n+h) where n is for the  dictionary's space and h is for the the recursive stack
class Solution(object):
    map = {}
    index = -1
    def buildTree(self, inorder, postorder):
        if len(inorder) == 0 or len(postorder) == 0:
            return
        for i in range(0,len(inorder)):
            self.map[inorder[i]] = i
        self.index = len(postorder)-1 
        return self.helper(postorder, 0, len(inorder)-1)
    
    def helper(self, postorder, start, end):
        if start>end:
            return None
        rootVal = postorder[self.index]
        self.index-=1
        root = TreeNode(rootVal)
        rootIndex = self.map[rootVal]  
        root.right = self.helper(postorder, rootIndex+1, end)
        root.left = self.helper(postorder, start, rootIndex-1)
        
        return root

        

        


        
        
