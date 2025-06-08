# Time Complexity: O(n^2) solution because we are doing a linear search on inorder array to find the index of the root
# Space Complexity: O(n) 
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        if len(postorder) == 0:
            return None
            
        rootVal = postorder[-1]
        rootidx = -1
        for index, val in enumerate(inorder):
            if val == rootVal:
                rootidx = index
        root = TreeNode(rootVal)
        num_rightelements = len(inorder) - rootidx - 1
        inleft = inorder[:rootidx]
        postleft = postorder[:rootidx]
        inright = inorder[rootidx + 1:]
        postright = postorder[rootidx:len(postorder) - 1]
        root.left = self.buildTree(inleft, postleft)
        root.right = self.buildTree(inright, postright)
        return root