# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# TC: O(n)
# SC: O(n)
# LeetCode: Y(https://leetcode.com/problems/sum-root-to-leaf-numbers/)
# Appraoch: Start from root and do an inorder traversal
#           Update currentSum by multiplying it by 10 and current node's val
#           Upon reaching the leaf node, update current sum and add current sum to the result
class Solution:
    
    def __init__(self):
        self.result = 0
        
    def sumNumbers(self, root: TreeNode) -> int:
        
        self.helper(root, 0)
        
        return self.result
    
    def helper(self, root, currentSum):
        if not root:
            return
        
        # update current sum and traverse the left subtree
        self.helper(root.left, currentSum * 10 + root.val)
        
        # if the current node is a leaf node then add current sum to the result
        if(not (root.left or root.right)):
            self.result += currentSum * 10 + root.val
        
        # update current sum and traverse the right subtree
        self.helper(root.right, currentSum * 10 + root.val)
        
        
