# APPROACH 1: Intermediate solution
# Time Complexity : O(n^2), n: number of nodes
# Space Complexity : O(n^2), n: number of nodes
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None
#
#
# Your code here along with comments explaining your approach
# 1. Current Root will always be the last element of the current postorder array.
# 2. Find the index of the root in inorder -> to know the left and right subtree elements.
# 3. Then recursively call the function with left and right subtree elements of both inorder and postorder

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> TreeNode:
        
        if len(inorder) <= 0 or len(postorder) <= 0:
            return None
        
        root_val = postorder[-1]
        root = TreeNode(root_val)
        
        for ind in range(len(inorder)):
            if inorder[ind] == root_val:
                root_inorder_ind = ind
                
        inLeft = inorder[ : root_inorder_ind]
        inRight = inorder[root_inorder_ind + 1 : ]
        postLeft = postorder[ : root_inorder_ind]
        postRight = postorder[root_inorder_ind : -1]
        
        root.left = self.buildTree(inLeft, postLeft)
        root.right = self.buildTree(inRight, postRight)
        
        return root
        
        

# APPROACH 2: Optimal solution
# Time Complexity : O(n), n: number of nodes
# Space Complexity : O(n), n: number of nodes
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None (should call recursive function on right subtree first instead of left else the insertion would be wrong)
#
#
# Your code here along with comments explaining your approach
# 1. Instead of searching the root in inorder list each time, build a hashmap that stores the element and it's position as key and value respectively.
# 2. Instead of creating copies of array each time (left and right subtrees of postorder and inorder), maintain two pointers - start and end of inorder for current iteration.
# 3. Postorder is used only for obtaining the root and we dont need to know the left and right subtree from it

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    
    def __init__(self):
        self.hashmap_inorder = {}
        
    def buildTree(self, inorder: List[int], postorder: List[int]) -> TreeNode:
        
        if len(inorder) == 0 or len(postorder) == 0:
            return None
        
        for ind in range(len(inorder)):
            self.hashmap_inorder[inorder[ind]] = ind
         
        return self.helper(inorder, postorder, 0, len(inorder) - 1)
    
    
    def helper(self, inorder, postorder, start, end):
        if len(postorder) <= 0 or start > end:
            return None
        
        root_inorder_ind = self.hashmap_inorder[postorder.pop(-1)]   
        
        root = TreeNode(inorder[root_inorder_ind])       
        root.right = self.helper(inorder, postorder, root_inorder_ind + 1, end)
        root.left = self.helper(inorder, postorder, start, root_inorder_ind - 1)
            
        return root
