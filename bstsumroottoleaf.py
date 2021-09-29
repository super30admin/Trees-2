"""
https://leetcode.com/problems/sum-root-to-leaf-numbers/submissions/
Tc: O(n)
Sc:O(h)
"""


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
# class Solution:
#     def sumNumbers(self, root: Optional[TreeNode]) -> int:
#         if not root:
#             return 0
#         treenodeStack = []
#         numStack = []
#         resultSum = 0
#         num = 0
#         while root != None or len(treenodeStack) != 0:
#             while root != None:
#                 treenodeStack.append(root)
#                 num = num * 10 + root.val
#                 numStack.append(num)
#                 root = root.left
#             root = treenodeStack.pop()
#             num = numStack.pop()
#             if root.left == None and root.right == None:
#                 resultSum += num
#             root = root.right
#         return resultSum
#



"""
:return
Recursive code here
"""


class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        if root == None:
            return 0
        self.sum = 0
        self.helper(root, 0)
        return self.sum

    def helper(self, root, num):
        ##base case
        if root == None:
            return

            ##pre order ## can take it as a base case too
        if root.left == None and root.right == None:
            self.sum += num * 10 + root.val

            ###logic
        self.helper(root.left, (num * 10 + root.val))
        ##stack.pop

        ##inorder

        self.helper(root.right, (num * 10 + root.val))
        ##stack pop

        ##postorder





