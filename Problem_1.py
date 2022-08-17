"""
Time Complexity : inside function
Space Complexity :inside function
Did this code successfully run on Leetcode : YEs
Any problem you faced while coding this : No


Problem1 (https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/)
"""
# Approach - 1

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        """
        Time Complexity : O(N^2)
        Space Complexity: O(N)
        """
        if len(inorder) == 0 or len(postorder) == 0:
            return None
        
        # since the root node is the last node in the postorder list, creating the root node
        root = TreeNode(postorder[-1])
        
        # Finding the root node in the inorder list
        index = inorder.index(postorder[-1])
        
               
        # Dividing the list recursively till only one element is left
        
        in_left = inorder[0: index]
        in_right = inorder[index + 1: len(inorder)]
        post_left = postorder[0: len(in_left)]
        post_right = postorder[len(post_left): len(postorder) - 1]
        
        
        root.left = self.buildTree(in_left,post_left)
        root.right = self.buildTree(in_right,post_right)
        
        return root
            
# Approach - 2

class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        """
        Using hash_map for searching the index of the root node and moving one place behind the root value position 
        in postorder list for left tree and for right moving one place ahead.
        Time Complexity: O(N)
        Sapce Complexity : O(1)
        """
        if len(inorder) == 0 or len(postorder) == 0:
            return None
        
        # since the root node is the last node in the postorder list, creating the root node
        self.index_map = {}
        for i in range(len(inorder)):
            self.index_map[inorder[i]] = i
            
        def helper(left, right):
            if left > right:
                return None
            
            
            # taking the last element from postorder list as the root
            
            root = TreeNode(postorder.pop())
            
            # Getting the index of the root val in inorderlist
            index = self.index_map[root.val]
            
            # building the right subtree
            root.right = helper(index + 1, right)
            # building the left subtree
            root.left = helper(left, index - 1)
            
            
            return root
        
        return helper(0, len(inorder) - 1)
         
        
        