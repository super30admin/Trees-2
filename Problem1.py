# Time Complexity: O(N)
# Space Complexity: O(N)
# Passed Leetcode

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    
    def recurse(self, left, right):
        
        if left > right:
            return None
        
        root_val = self.postorder[self.postorder_head]
        self.postorder_head -= 1
        node = TreeNode(root_val)
        
        head_index = self.inorder_map[root_val]
        node.right = self.recurse(head_index + 1, right)
        
        node.left = self.recurse(left, head_index - 1)
        
        return node
    
    def buildTree(self, inorder: List[int], postorder: List[int]) -> TreeNode:
        
        self.inorder_map = {}
        self.inorder = inorder
        self.postorder = postorder
        self.postorder_head = len(postorder) - 1
        
        for i in range(len(inorder)):
            
            self.inorder_map[inorder[i]] = i
        
        return self.recurse(0, len(inorder) - 1)