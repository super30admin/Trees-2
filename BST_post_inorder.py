"""106. Construct Binary Tree from Inorder and Postorder Traversal
Time Complexity: O(N)
Space Complexity: O(N)"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> TreeNode:
        if not postorder and not inorder:
            return None
        
        root = TreeNode(postorder[len(postorder)-1])
        mid =-1
        for x in range(len(inorder)):
            if inorder[x]==root.val:
                mid =x
                break
        
        leftsize = mid
        rightsize = len(inorder)-1-mid
        
        root.left = self.buildTree(inorder[0:mid],postorder[:leftsize])#right
        root.right =self.buildTree(inorder[mid+1:],postorder[leftsize:len(postorder)-1])#left
        
        return root
        
        