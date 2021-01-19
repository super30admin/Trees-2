# // Time Complexity : O(n)
# // Space Complexity : O(h)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach

	# Start from the root and at every level make the number as num * 10 + the current value 
	# Once the end of the tree is reached(lchild and rchild are null) add the so formed number to
	# a global result variable.
	
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    res = 0
    def helper(self,root,currsum):
        if root == None:
            return
        currsum = currsum * 10 + root.val
        self.helper(root.left,currsum)
        if (root.left == None and root.right==None):
            self.res = self.res + currsum
        self.helper(root.right,currsum)
        return
    
    def sumNumbers(self, root: TreeNode) -> int:
        if root == None:
            return 0
        
        currsum = 0
        self.helper(root,currsum)
        return self.res