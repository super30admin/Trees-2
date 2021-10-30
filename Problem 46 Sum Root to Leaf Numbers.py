# Did this code successfully run on Leetcode: Yes
# Time Complexity: O(n)
# Space Complexity: O(n)
# Logic: do preorder traversal & keep on adding current node value to a number. if base condition arrives i.e. leaf node
# when cur.left & cur.right both are null then add the number to the resultant sum.

class Solution:
    def sumNumbers(self, root):
        number = 0
        sum = 0
        stack = []
        while stack or root:
            while root:
                number = number*10 + root.val
                stack.append((root, number))
                root = root.left
            root, number = stack.pop()
            if not root.left and not root.right:
                sum += number
            root = root.right
        return sum
