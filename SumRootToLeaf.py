"""
We use a void-based recursive helper to build numbers from root to leaf by multiplying the current number by 10 and adding the node value.
When we hit a leaf node, we add the current number to the result since it represents a full root-to-leaf path. The recursion continues down left and right children, accumulating the total sum along the way.
Here result is calculated in pre-order manner. It can also be accumulated in in-order or post-order manner.

"""

#Time Complexity: O(N)
#Space Complexity: O(N)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        self.sum = 0
        self.helper(root,0)
        return self.sum

    def helper(self,root,curr):
        if root is None:
            return
        #logic
        curr = curr * 10 + root.val

        if root.left is None and root.right is None:
            self.sum += curr 

        self.helper(root.left,curr)
        self.helper(root.right,curr)