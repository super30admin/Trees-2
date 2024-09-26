# Time Complexity : O(N^2)
# Space Complexity : O(N^2) not sure
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> TreeNode:
        
        if len(inorder) == 0:
            return None
        
        rootElement = postorder[-1]
        root = TreeNode(rootElement)
        rootIndex = 0
        for i in range(len(inorder)):
            
            if inorder[i] == rootElement:
                rootIndex +=i
          
        leftInorder = inorder[0:rootIndex]
        leftPostorder = postorder[0:rootIndex]
        root.left = self.buildTree(leftInorder,leftPostorder)
        rightInorder = inorder[rootIndex+1:len(inorder)]
        rightPostorder = postorder[rootIndex:len(postorder)-1]
        root.right = self.buildTree(rightInorder,rightPostorder)
        
        return root
        