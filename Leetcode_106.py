#Time Complexity: O(n)
#Space Complexity: O(n)

# Definition for a binary tree node.
class TreeNode(object):
    def _init_(self,x):
        self.val=x
        self.left=None
        self.right=None
        
class Solution:
    def buildTree(self, inorder, postorder):
        if not inorder:
            return None
        inorder_index=inorder.index(postorder.pop())
        root=TreeNode(inorder[inorder_index])
        root.right=self.buildTree(inorder[inorder_index+1:],postorder)
        root.left=self.buildTree(inorder[:inorder_index],postorder)
        
        return root