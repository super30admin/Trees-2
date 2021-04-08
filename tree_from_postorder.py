# Time Complexity: O(n)
# Space Complexity: O(n) as we are storing every element in hashmap
# Ran on Leetcode: Yes


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.map = {}
        self.index = -1
    
    def buildTree(self, inorder: List[int], postorder: List[int]) -> TreeNode:
        if not len(postorder):
            return None
        for i in range(len(inorder)):
            self.map[inorder[i]] = i
        self.index= len(postorder) - 1
        return self.helper(postorder, 0, len(postorder) - 1)
    
    def helper(self, postorder, start, end):
        if start > end:
            return None
        root = TreeNode(postorder[self.index])
        self.index -= 1
        idx = self.map[root.val]
        root.right = self.helper(postorder, idx + 1, end)
        root.left = self.helper(postorder, start, idx - 1)
        return root
    
            
        