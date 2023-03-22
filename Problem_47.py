# TC: O(n)
# SC: O(n)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        def helper(root, curNum):
            if root == None:
                return
            curNum = curNum * 10 + root.val

            # PREORDER TRAVERSAL
            if root.left is None and root.right is None:
                self.res += curNum
            helper(root.left, curNum)

            # INORDER TRAVERSAL
            # if root.left is None and root.right is None:
            #     self.res += curNum
            helper(root.right, curNum)

            # POSTORDER TRAVERSAL
            # if root.left is None and root.right is None:
            #     self.res += curNum
        self.res = 0
        helper(root, 0)
        return self.res