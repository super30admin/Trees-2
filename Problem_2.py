# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

# Iterative Solution using Stack
# class Solution:
#     def sumNumbers(self, root: TreeNode) -> int:
#         if root == None:
#             return 0
#         stack = []
#         result = 0
#         currSum = 0
#         while root != None or len(stack) != 0:
#             while root != None:
#                 currSum = 10 * currSum + root.val
#                 stack.append((root, currSum))
#                 root = root.left
#             pair = stack.pop()
#             root = pair[0]
#             currSum = pair[1]
#             if root.left == None and root.right == None:
#                 result += currSum
#             root = root.right
#         return result

# Recursive solution checking whether node is leaf node or not after pushing to recursive stack
class Solution:
    result = 0
    def sumNumbers(self, root: TreeNode) -> int:
        if root == None:
            return 0
        self.helper(root, 0)
        return self.result
    def helper(self, root: TreeNode, currSum : int) -> None:
        if root == None:
            return
        currSum = 10 * currSum + root.val
        self.helper(root.left, currSum)
        if root.left == None and root.right == None:
            self.result += currSum
        self.helper(root.right, currSum)

# Recursive solution checking whether node is leaf node or not before pushing to recursive stack
# class Solution:
#     def sumNumbers(self, root: TreeNode) -> int:
#         if root == None:
#             return 0
#         return self.helper(root, 0)

#     def helper(self, root: TreeNode, currSum : int) -> int:
#         if root == None:
#             return 0
#         if root.left == None and root.right == None:
#             return 10 * currSum + root.val
#         currSum = 10 * currSum + root.val
#         return self.helper(root.left, currSum) + self.helper(root.right, currSum)

# Using backtracking
# class Solution:
#     def sumNumbers(self, root: TreeNode) -> int:
#         if root == None:
#             return 0
#         self.result = 0
#         self.currSum = 0
#         self.helper(root)
#         return self.result
    
#     def helper(self, root: TreeNode) -> None:
#         if root == None:
#             return
#         self.currSum = 10 * self.currSum + root.val
#         self.helper(root.left)
#         if root.left == None and root.right == None:
#             self.result += self.currSum
#         self.helper(root.right)
# backtrack
#         self.currSum //= 10

    # Time Complexity: O(n) where n is number of nodes of tree
    # Space Complexity: O(h) where h is height of tree

