#Time Complexity: O(N)
#Space Complexity: O(N)

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]: 
        if len(postorder)==0 or len(inorder)==0:
            return None
        rootidx=0
        root=TreeNode(postorder[-1])
        for i in range(len(inorder)):
            if inorder[i]==postorder[-1]:
                rootidx=i
        postleft=postorder[0 : rootidx]
        postright=postorder[rootidx : len(postorder)-1]
        inleft=inorder[0:rootidx]
        inright=inorder[rootidx+1:len(inorder)]
        root.left=self.buildTree(inleft,postleft)
        root.right=self.buildTree(inright,postright)
        return root
    
        