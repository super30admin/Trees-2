#Time Complexity O(n)
#Space Complexity O(n)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        if not inorder or not postorder:
            return None
        mapIn = {}

        for i in range(len(inorder)):
            mapIn[inorder[i]] = i

        def helper(postS, postE, inS, inE):
            
            if postS > postE or inS > inE:
                return None

            rootVal = postorder[postE]
            rootIdx = mapIn[rootVal]
            root = TreeNode(rootVal)

            leftSize = rootIdx - inS

            root.right = helper(postS+leftSize, postE-1, rootIdx+1, inE)
            root.left = helper(postS, postS+leftSize-1, inS, rootIdx-1)
            
            return root
        return helper(0, len(postorder)-1, 0, len(inorder)-1)
