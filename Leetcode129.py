#Time complexity = O(n)
#Space Complexity = O(h^2) in worst case due to string concatenation 

# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def __init__(self):
        self.sum = 0
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        if root is None:
            return 0
        self.dfs(root, "")
        return self.sum
    def dfs(self, root: TreeNode, res: str):
        if root is None:
            return
        res += str(root.val) 
        if root.left is None and root.right is None:  # Leaf node condition
            self.sum += int(res)
            return  
        if root.left:
            self.dfs(root.left, res)
        if root.right:
            self.dfs(root.right, res)
