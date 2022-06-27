#Time Complexity: O(n)
#Space complexity: O(n)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.iMap = dict()
        self.idx = 0
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        if len(postorder) == 0:
            return None
        
        self.idx = len(postorder)-1
        for i in range(len(inorder)):
            self.iMap[inorder[i]] = i
        
        return self.helper(postorder, 0, len(postorder)-1)
    
    def helper(self, postorder, start, end):
        if start > end:
            return None
        
        rootVal = postorder[self.idx]
        self.idx -= 1
        root = TreeNode(rootVal)
        rootIdx = self.iMap[rootVal]
        
        root.right = self.helper(postorder, rootIdx+1, end)
        root.left = self.helper(postorder, start, rootIdx-1)
        
        
        return root
        
        
    
        
        
