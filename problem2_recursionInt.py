"""
Time Complexity  : O(n) where n is the total number of nodes in a tree
Space Complexity : O(h) where h is the height of the tree
Did this code successfully run on Leetcode : Yes

Three line explanation of solution in plain english:
Traverse through the every node of tree. While traversing push currSum value to the stack along with the node.
once reached to the leaf node currSum will be the sum of all the root values from the root to that particular leaf.
currSum = currSum*10 + root.val

In the following code helper function used is returning int
"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def helper(self, root, currSum):
        #base
        if root == None:
            return 0
        
        #Logic
        sumLeft = self.helper(root.left, currSum * 10 + root.val) 
        
        #check leaf
        if root.left == None and root.right == None:
            return currSum * 10 + root.val
        
        sumRight = self.helper(root.right, currSum * 10 + root.val)
        
        return sumLeft + sumRight
        # return self.helper(root.left, currSum * 10 + root.val)  + self.helper(root.right, currSum * 10 + root.val)
        
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        return self.helper(root, 0)