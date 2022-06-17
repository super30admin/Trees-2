# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

"""
TC:O(n)
SC:O(n)
"""
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        if len(postorder) < 1 :
            return;
        
        rootval = postorder.pop()
        root = TreeNode(rootval)
        rootidx = -1
        for idx in range(len(inorder)):
            if inorder[idx] == rootval:
                rootidx = idx
                break
        inLeft = inorder[:rootidx]
        inRight = inorder[rootidx+1:]
        
        postLeft = postorder[:len(inLeft)]
        postRight = postorder[len(postLeft):len(postorder)]
        root.left = self.buildTree(inLeft, postLeft)
        root.right = self.buildTree(inRight, postRight)
        return root
        
