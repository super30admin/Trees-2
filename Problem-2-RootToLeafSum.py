# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Pair:
    root = None
    summ = 0

    def __init__(self, root, summ):
        self.summ = summ
        self.root = root

    def getKey(self):
        return self.root

    def getValue(self):
        return self.summ


class Solution:
    result = 0

    def sumNumbers(self, root) :

        if not root:
            return 0

        stack = []
        currsumm = 0

        while root or stack:
            while root:
                currsumm = currsumm * 10 + root.val
                stack.append(Pair(root, currsumm))
                root = root.left

            p = stack.pop()

            root = p.getKey()
            currsumm = p.getValue()

            if not root.right and not root.left:
                self.result = self.result + currsumm

            root = root.right

        return self.result
