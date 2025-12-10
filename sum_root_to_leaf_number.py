# https://leetcode.com/problems/sum-root-to-leaf-numbers/

# TimeComplexity- O(n) Space Complexity- O(h)
class Solution:
    def sumNumbers(self, root):
        return self.helper(root, 0)

    def helper(self, root, currNum):
        # handling the edge case
        if root is None:
            return 0
        # update the currnum, multiply it with 10 to get the sum 
        currNum = currNum * 10 + root.val
        # no more node is remain return the currNum
        if root.left is None and root.right is None:
            return currNum
        # recursion on left subtree
        left = self.helper(root.left, currNum)
        # recursion on right subtree
        right = self.helper(root.right, currNum)
        # return the sum
        return left + right

solution = Solution()
print(solution.sumNumbers([4,9,0,5,1]))