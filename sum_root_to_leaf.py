# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    
    def sumNumbers(self, root: TreeNode) -> int:
    
	# Check input
	    if not root:
		    return 0

	    result = []
	    self.dfs(root, result, "")
	    return sum([int(i) for i in result])

    def dfs(self, root, result, num):
        
	    if not root.left and not root.right:
		    result.append(num + str(root.val))
	    if root.left:
		    self.dfs(root.left, result, num + str(root.val))
	    if root.right:
		    self.dfs(root.right, result, num + str(root.val))
            
            
            #O(n)
            #O(n)