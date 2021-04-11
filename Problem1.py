## Problem1 (https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> TreeNode:
        # Use hashmap store the index of inorder numbers 
        order = {}
        for i, e in enumerate(inorder):
            order[e] = i
        
		# Construct the tree with the boundary 
        def tree(low, high):
            if low > high or not postorder:
                return
            root = TreeNode(postorder.pop())      
            mid = order[root.val]
            root.right = tree(mid+1, high)        
            root.left = tree(low, mid-1)          
            return root
        return tree(0, len(postorder)-1) 
    #Time Complexity: O(n)
    #Space Complexity: O(n) hash map
        