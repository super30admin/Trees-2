
# Time Complexity :O(n)
# Space Complexity :O(n)
# Did this code successfully run on Leetcode :yes
# Any problem you faced while coding this :no


# Your code here along with comments explaining your approach
# Perform a DFS traversal of the tree, carrying the current number formed along the path.
# At each node, update the number as current * 10 + node.val.
# When a leaf node is reached, return the number; sum the results from left and right subtrees to get the total.

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        total = 0
        return self.helper(root, total)
    def helper(self,root,total):
        if not root:
            return 0
            
        total = total *10+root.val
        if not root.left and not root.right:
            return total
        
        left=self.helper(root.left, total)
        right=self.helper(root.right, total)
        return left+right