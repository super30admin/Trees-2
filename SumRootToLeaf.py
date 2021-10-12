# Time complexity: O(n) where n is the total number of nodes in the tree
# Space complexity: O(h) where h is the height of the tree

class Solution:
    def sumNumbers(self, root):
        if not root:
            return 0
        result = [0]

        self.findSum(root, 0, result)
        return result[0]

    def findSum(self, root, curSum, result):
        if not root:
            return
        curSum = curSum*10 + root.val

        if not root.left and not root.right:
            result[0] += curSum

        self.findSum(root.left, curSum, result)
        self.findSum(root.right, curSum, result)
