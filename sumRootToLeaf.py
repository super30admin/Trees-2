# Time Complexity : O(n)
# Space Complexity : O(h) h = height of tree
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Approach: Use DFS traversal.
# Carry the current number formed so far while traversing the tree.
# At each node, update num 
# When a leaf node is reached, add the formed number to the result.
# Continue traversal for left and right subtrees.

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        
        def helper(r,num):
            if r is None:
                return
            num = num * 10 + r.val
            if r.right is None and r.left is None:
                self.res += num
            helper(r.left,num)
            helper(r.right,num) 

        self.res = 0
        helper(root,0)
        return self.res