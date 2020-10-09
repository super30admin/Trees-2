#Complexity is amortised O(n) where n is the size of inorder array. 
# It can be optimized to O(n) by using hashtable to find index of preorder[0] and using start and end indices instead of slicing
#Space -O(n) to create Binary Tree
# Definition for a binary tree node.

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> TreeNode:
        indices = {inorder[i]:i for i in range(len(inorder))}
        return self.helper(0,len(inorder)-1,postorder,inorder,indices)
    
    def helper(self,inStart,inEnd,postorder,inorder,indices):
        
        if inStart > inEnd or not len(postorder):
            return None
        
        root = TreeNode(postorder[-1])
        inIdx = indices[postorder[-1]]
        
        postorder.pop()
        
        root.right = self.helper(inIdx + 1,inEnd,postorder,inorder,indices)
        root.left = self.helper(inStart,inIdx-1,postorder,inorder,indices)
        
        return root
        
        
    


    

        
        