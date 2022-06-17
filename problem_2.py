# Time Complexity : O(n)
# Space Complexity : O(h); h -- height of the tree.
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
#
#

# iterative
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def __init__(self):
        self.sum = 0
        self.val = 0
        self.stack = []

    def sumNumbers(self, root):
        while root or self.stack:
            while root:
                self.stack.append([root, self.val])
                self.val = (self.val * 10) + root.val
                root = root.left
            pop = self.stack.pop()
            root = pop[0]
            if root.left is None and root.right is None:
                self.sum += (root.val + (pop[1] * 10))
            self.val = (root.val + (pop[1] * 10))
            root = root.right
        return self.sum


check = TreeNode(4)
check.left = TreeNode(9)
check.right = TreeNode(0)
check.left.left = TreeNode(5)
check.left.right = TreeNode(1)
check1 = Solution()
print(check1.sumNumbers(check))


# iterative
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
#
#
# class Solution:
#     def __init__(self):
#         self.sum = 0
#         self.val = 0
#         self.stack = []
#
#     def sumNumbers(self, root):
#         while root or self.stack:
#             while root:
#                 self.val = (self.val * 10) + root.val
#                 self.stack.append([root, self.val])
#                 root = root.left
#             pop = self.stack.pop()
#             root = pop[0]
#             if root.left is None and root.right is None:
#                 self.sum += self.val
#             self.val = pop[1]
#             root = root.right
#         return self.sum
#
#
# check = TreeNode(4)
# check.left = TreeNode(9)
# check.right = TreeNode(0)
# check.left.left = TreeNode(5)
# check.left.right = TreeNode(1)
# check1 = Solution()
# print(check1.sumNumbers(check))


# recursive
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# class Solution:
#     def __init__(self):
#         self.sum = 0

#     def helper(self, root, temp):
#         if root is None:
#             return
#         if root.right is None and root.left is None:
#             self.sum += (root.val + temp * 10)
#         self.helper(root.left, temp * 10 + root.val)
#         self.helper(root.right, temp * 10 + root.val)

#     def sumNumbers(self, root):
#         self.helper(root, 0)
#         return self.sum


# check = TreeNode(4)
# check.left = TreeNode(9)
# check.right = TreeNode(0)
# check.left.left = TreeNode(5)
# check.left.right = TreeNode(1)
# check1 = Solution()
# print(check1.sumNumbers(check))


# recursive
# class Solution:
#     def __init__(self):
#         self.sum = 0

#     def helper(self, root, temp):
#         if root.left is None and root.right is None:
#             self.sum += temp
#             return
#         if root.left:
#             self.helper(root.left, temp * 10 + root.left.val)
#         if root.right:
#             self.helper(root.right, temp * 10 + root.right.val)

#     def sumNumbers(self, root):
#         self.helper(root, root.val)
#         return self.sum


# check = TreeNode(4)
# check.left = TreeNode(9)
# check.right = TreeNode(0)
# check.left.left = TreeNode(5)
# check.left.right = TreeNode(1)
# check1 = Solution()
# print(check1.sumNumbers(check))
