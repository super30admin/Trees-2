# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# Approach:  DFS inorder iterative
# In this approach we will do a DFS. So while touching every node we will store the number formed till that node along with node itself in a stack. So whenever we pop the element we have two values with us, first the element itself and second the number that is constructed using the previous nodes till that point. If we have reached the leaf node, we will simply add the number formed to the result.

# This is just a simple inorder traversal with slight modification where we are also maintaining the number that is formed until that point.

# Time complexity: O(n) ; n= no of nodes
# Space complexity: O(h); h =height of the tree

# class Solution:
#     def sumNumbers(self, root: TreeNode) -> int:
#         if root == None:
#             return 0
        
#         stack = []
#         result = 0
#         currSum = 0
        
#         while root != None or len(stack) != 0:
#             while root != None:
#                 currSum = currSum * 10 + root.val
#                 stack.append([root, currSum])
#                 root = root.left
            
#             p = stack.pop(0)
#             root = p[0]
#             currSum = p[1]
            
#             if root.left == None and root.right == None:
#                 result += currSum
                
#             root = root.right
        
#         return result
        
# Approach: Recursive inorder

class Solution:
    def sumNumbers(self, root: TreeNode) -> int:
        if root == None:
            return 0
        
        self.result = 0
        self.inorder(root, 0)
        return self.result
    
    def inorder(self, root, currSum):
        if root == None:
            return
        
        self.inorder(root.left, currSum * 10 + root.val)
        if root.left == None and root.right == None:
            self.result += currSum * 10 + root.val
        self.inorder(root.right, currSum * 10 + root.val)
        
# Approach: Recursive preorder

class Solution:
    def sumNumbers(self, root: TreeNode) -> int:
        if root == None:
            return 0
        
        self.result = 0
        self.inorder(root, 0)
        return self.result
    
    def inorder(self, root, currSum):
        if root == None:
            return
        
        if root.left == None and root.right == None:
            self.result += currSum * 10 + root.val
        self.inorder(root.left, currSum * 10 + root.val)
        self.inorder(root.right, currSum * 10 + root.val)
        
# Approach: Recursive postorder

class Solution:
    def sumNumbers(self, root: TreeNode) -> int:
        if root == None:
            return 0
        
        self.result = 0
        self.inorder(root, 0)
        return self.result
    
    def inorder(self, root, currSum):
        if root == None:
            return
        
        self.inorder(root.left, currSum * 10 + root.val)
        self.inorder(root.right, currSum * 10 + root.val)
        if root.left == None and root.right == None:
            self.result += currSum * 10 + root.val
            
# Note: So from above observations we can conclude that the type of traversal does not matter. What matters is we reach every leaf node. 
        