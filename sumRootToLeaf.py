# Leetcode 129. Sum Root to Leaf Numbers

# Time Complexity :  O(n) where n is the number of the nodes in tree

# Space Complexity : O(h) where h is the height of tree that can be in the recurssive stack

# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Approach: At every node if the node is a leaf node then we calculate the currSum at that node.
# If the node doesnt have both left and right children then we add the current sum to total else we move 
# down the tree until leaf node is found. After calculating the currSum at every node and traversing 
# the whole tree we return the result.


# Your code here along with comments explaining your approach

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    result = 0
    
    def sumNumbers(self, root: TreeNode) -> int:
        if root == None:
            return 0
        self.helper(root,0)
        return self.result
    
    def helper(self,root,currSum):
        # base
        if root == None:
            return
        currSum = currSum*10 + root.val
        # leafnode
        if root.left == None and root.right == None:
            self.result += currSum
            
        self.helper(root.left,currSum)
        self.helper(root.right,currSum)