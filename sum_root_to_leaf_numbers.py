# Time Complexity :O(n)
# Space Complexity :O(h) because of recursion stack
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
"""
We solve the problem by traversing the tree in preorder fashion and adding the value to the previous value * 10. 
If we reach a leaf node we add the value to the answer.
"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        if root == None: return 0

        self.answer = 0
        self.traverse(root, 0)

        return self.answer

    def traverse(self, root, previous):
        if root == None: return
        
        if root.left == None and root.right == None:
            self.answer += previous * 10 + root.val
            return

        self.traverse(root.left, previous * 10 + root.val)
        self.traverse(root.right, previous * 10 + root.val)