# O(N) TIME AND O(N) SPACE
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> TreeNode:
        indices = {inorder[i]:i for i in range(len(inorder))}
        return self.helper(inorder,postorder,0,len(inorder)-1,indices)
    
    def helper(self,inorder,postorder,instart,inend,indices):
        if not len(postorder) or instart > inend:
            return None
        root = TreeNode(postorder[-1])
        idx = indices[postorder[-1]]
        
        postorder.pop()
        
        root.right = self.helper(inorder,postorder,idx+1,inend,indices)
        root.left = self.helper(inorder,postorder,instart,idx-1,indices)
        
        return root
        