# APPROACH 1: Iterative Solution
# Time Complexity : O(n), n: number of nodes
# Space Complexity : O(h), h: height of the tree
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None
#
#
# Your code here along with comments explaining your approach
# 1. Do an inorder traversal
# 2. As you push each node to the stack, push the value along with the current sum (sum of the elements on this path)
# 3. When you reach a leaf node, pop the node from the stack and add it's current sum value to the main result.

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumNumbers(self, root: TreeNode) -> int:
        
        if root is None:
            return 0
        
        stack, total_sum, curr_sum, isFirst = [], 0, 0, True
        
        while root is not None or (len(stack) > 0 or isFirst):
            isFirst = False
            
            while root is not None:
                curr_sum = curr_sum * 10 + root.val
                stack.append((root, curr_sum))
                root = root.left
             
            curr_node = stack.pop(-1)
            if curr_node[0].left is None and curr_node[0].right is None:
                total_sum += curr_node[1]
                
            root = curr_node[0].right
            curr_sum = curr_node[1]
            
        return total_sum
        
        
        
        

# APPROACH 2: Recursive solution - without global variable result 
# Time Complexity : O(n), n: number of nodes
# Space Complexity : O(h), h: height of the tree
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None
#
#
# Your code here along with comments explaining your approach
# 1. Base case -> if leaf node, return the current sum found so far
# 2. Else recursively call function on both left and right subtree
# 3. Return the sum of left and right subtrees.

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    
    def sumNumbers(self, root: TreeNode) -> int:
        
        if root is None:
            return 0
        
        return self.helper(root, 0)
    
    
    def helper(self, root, curr_sum):
        if root is None:
            return 0
        
        if root.left is None and root.right is None:
            return curr_sum * 10 + root.val
        
            
        left_sum = self.helper(root.left, curr_sum * 10 + root.val)
        right_sum = self.helper(root.right, curr_sum * 10 + root.val)
        
        return left_sum + right_sum
        
        
        
        

# APPROACH 3: Recursive solution - with result stored as global variable  
# Time Complexity : O(n), n: number of nodes
# Space Complexity : O(h), h: height of the tree
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None
#
#
# Your code here along with comments explaining your approach
# 1. Same as approach 2 but instead of reaching the leaf node and returning the current sum, add the current sum to the global variable result.
# 2. Else recursively call function on both left and right subtree

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    
    def __init__(self):
        self.total_sum = 0
        
    def sumNumbers(self, root: TreeNode) -> int:
        
        if root is None:
            return 0
        
        return self.helper(root, 0)
    
    
    def helper(self, root, curr_sum):
        if root is None:
            return 0
        
        if root.left is None and root.right is None:
            self.total_sum += (curr_sum * 10) + root.val
        
            
        self.helper(root.left, curr_sum * 10 + root.val)
        self.helper(root.right, curr_sum * 10 + root.val)
        
        return self.total_sum
