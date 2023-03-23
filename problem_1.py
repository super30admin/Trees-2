# Time Complexity - O(n)
# Space Complexity - O(n)


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
       
        self.postIndex = len(postorder)-1
        self.dictionary = {}
        for i in range(len(inorder)):
            self.dictionary[inorder[i]] = i 
        return self.helper(inorder,postorder,0,len(inorder)-1)
        
    def helper(self,inorder,postorder,start,end):
        if start > end : 
            return None     
        rootVal = postorder[self.postIndex]
        self.postIndex -= 1 
        root = TreeNode(rootVal)
        rootIndx = self.dictionary[rootVal] 

        
        root.right = self.helper(inorder,postorder,rootIndx+1,end) 
        root.left = self.helper(inorder,postorder,start,rootIndx-1)

        return root



    