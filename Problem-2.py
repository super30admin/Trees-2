# Approach
# For every node multiply the value of the prarent node and add the current root value
# while traversing root is null then add the present sum to the result.



#COmplexities
# Time O(N)
# Space(N)




# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
from typing import Optional


class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        path = []
        pathSum = []
        self.helper(root, path, pathSum)
        return sum(pathSum)

    def helper(self, root, path, pathSum):
        if root == None:
            return

        path.append(str(root.val))
        if root.left == None and root.right == None:
            pathSum.append(int("".join(path)))

        self.helper(root.left, path, pathSum)
        self.helper(root.right, path, pathSum)
        path.pop(-1)


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        path = []
        pathSum = 0

        return self.helper(root, path, pathSum)

    def helper(self, root, path, pathSum):
        if root == None:
            return 0

        pathSum = pathSum * 10 + root.val

        if root.left == None and root.right == None:
            return pathSum

        return (self.helper(root.left, path, pathSum)
                + self.helper(root.right, path, pathSum))

