# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

#Time Complexity : O(N)
#Space Complexity : O(N)
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        
        self.index = 0
        self.map ={}
        for i in range(len(inorder)):
            self.map[inorder[i]] = i
            
        return self.helper(preorder, 0, len(inorder)-1)
        
    
    def helper(self, preorder, start,end):
        
        if start > end:
            return None
        
        rootVal = preorder[self.index]
        self.index += 1
        rootIndex = self.map[rootVal]
        root = TreeNode(rootVal)
        
        root.left = self.helper(preorder, start, rootIndex-1)
        root.right = self.helper(preorder, rootIndex + 1, end)
        
        return root
        
