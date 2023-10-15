'''
1. Initialize a variable ans = 0. Start the recursion process with the root node of the tree and currentSum = 0.
2. If we reach a leaf node, append the currentSum*10 + root.val to ans.
3. Recursively call the function with the left and right child of the current node with currentSum*10 + root.val as the currentSum.

TC: O(N )
SC: O(H) where H is the height of the tree as we are using recursion stack.
'''
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        if root == None:
            return 0
        self.ans = 0

        self.dfs(root,0)
        return self.ans

    def dfs(self,root,currentSum):
        if root == None:
            return
        self.dfs(root.left,currentSum*10+root.val)

        if root.left == None and root.right == None:
            self.ans += currentSum*10 + root.val
        self.dfs(root.right,currentSum*10 + root.val)
            
        