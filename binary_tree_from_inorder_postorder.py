'''
Time complexity: O(2n)
Space complexity: O(n)
'''

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    
    
    def buildTree(self, inorder: List[int], postorder: List[int]) -> TreeNode:
        self.hm = {}
        self.postIndex = len(postorder) - 1
        for x in range(0, len(inorder)):
            self.hm[inorder[x]] = x
        return self.buildNewTree(inorder, postorder, 0, len(inorder) - 1)
    def buildNewTree(self, inorder: List[int], postorder: List[int], inStart, inEnd):
        if inStart > inEnd:
            return None
        root = TreeNode(postorder[self.postIndex])
        self.postIndex = self.postIndex - 1
        
        index = self.hm.get(root.val)
        root.right = self.buildNewTree(inorder, postorder, index + 1, inEnd)
        root.left = self.buildNewTree(inorder, postorder, inStart, index - 1)
        return root