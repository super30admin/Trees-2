## Problem2 (https://leetcode.com/problems/sum-root-to-leaf-numbers/)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumNumbers(self, root: TreeNode) -> int:
        self.result = 0
        if root == None: 
            return 0;
        self.helper(root,0)
        return self.result
    def helper(self, root, summ):
        if root == None:
            return 0
        currsum = summ*10+root.val
        self.helper(root.left,currsum)
        if root.left==None and root.right==None:
            self.result = self.result+currsum
            return
        self.helper(root.right,currsum)
        
    #Time Complexity: O(n) n - no of nodes. 
    #Space Complexity: O(h) h - height of the tree.
    #Approach - recursive solution. Multiply the node value by 10 and add to the next node value and append it to the result. Inorder traversal where we keep pushing the node value and calculated current sum value for the next level. 
        
        
        