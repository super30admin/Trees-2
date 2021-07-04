"""
Time Complexity : buildTree - O(n^2)
Space Complexity : buildTree - O(n)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : none
"""

class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None
        
class Solution:
    def buildTree(self, inorder, postorder) -> TreeNode:
        len_inOrder = len(inorder)
        len_postOrder = len(postorder)
        if inorder == None or len_inOrder == 0 or postorder == None or len_postOrder == 0:
            return None
        root = TreeNode(postorder[len_postOrder - 1])
        idx = -1
        for i in range(len_inOrder):
            if inorder[i] == root.val:
                idx = i
                break
                
        inLeft = inorder[0:idx]
        inRight = inorder[idx+1:len_inOrder]
        postLeft = postorder[0:idx]
        postRight = postorder[idx:len_postOrder-1]
        
        root.left = self.buildTree(inLeft, postLeft)
        root.right = self.buildTree(inRight, postRight)
        
        return root
    
inOrder = [9,3,15,20,7]
postOrder = [9,15,7,20,3]

s = Solution()
print(s.buildTree(inOrder, postOrder))