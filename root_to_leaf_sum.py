#Time Complexity : O(N)
#Space Complexity: O(H)
#Yes it ran on leetcode

class Solution(object):

    def sumNumbers(self, root):
        global res
        res = 0
        if root == None:
            return 0
        self.helper(root, 0)
        return res

    def helper(self, root, currsum):
        global res
        if root == None:
            return 0
        currsum = currsum * 10 + root.val
        if root.left == None and root.right == None:
            res += currsum
        left = self.helper(root.left, currsum)
        right = self.helper(root.right, currsum)