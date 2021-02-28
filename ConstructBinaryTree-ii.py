# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# TC: O(N)
# SC: O(N)
# LeetCode: Y(https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/)
# Approach: Postorder traversal is left, right, root. So the last element of the postorder traversal would be the root of the tree. If there exists a right subtree of this root then the root of the right subtree would be the second element of postorder traversal and so on
#           Inorder traversal is left, root, right
#           so build the tree from postorder traversal and determining its left and right subtree from inorder traversal 
class Solution:
    
    def __init__(self):
        self.map = {}
        self.current_index = 0
        
    def buildTree(self, inorder: List[int], postorder: List[int]) -> TreeNode:
        
        # base case
        if not inorder or not postorder or not len(inorder) or not len(postorder) or (len(inorder) != len(postorder)):
            return None
        
        # construct value to index mapping for inorder traversal
        for index, value in enumerate(inorder):
            self.map[value] = index
            
        self.current_index = len(postorder) - 1
        
        return self.helper(postorder, 0, len(inorder) - 1)
        
    def helper(self, postorder: List[int], start: int, end: int) -> TreeNode:
        
        # check for valid range
        if start > end:
            return None
        
        # get value of current index
        root_val = postorder[self.current_index]
        
        # construct node
        root = TreeNode(root_val)
        
        # update current_index
        self.current_index -= 1
        
        # build right subtree
        root.right = self.helper(postorder, self.map[root_val] + 1, end)
        
        # build left subtree
        root.left = self.helper(postorder, start, self.map[root_val] - 1)
        
        # return root
        return root
            
