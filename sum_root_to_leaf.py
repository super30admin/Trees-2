# TC : O(N)
# SC : O(N)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.total = 0

    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        if not root:
            return 0
        # Implement dfs - PreOrder traversal
        
        def dfs(root, temp_num):
            # Check if leaf node
            if not root:
                return           
            if not root.left and not root.right:
                self.total += int(temp_num + str(root.val))
                return 
            
            dfs(root.left, temp_num + str(root.val))
            dfs(root.right, temp_num + str(root.val))
        
        dfs(root, '')
        return self.total

