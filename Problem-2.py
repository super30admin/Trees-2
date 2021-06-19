"""
https://leetcode.com/problems/sum-root-to-leaf-numbers/
Approach1: Recursion
TC: O(n)
SC: O(n) with recursive stack
"""

class Solution:
    def __init__(self):
        self.sum_ = 0

    def sumNumbers(self, root: TreeNode) -> int:
        self.helper(root, 0)
        return self.sum_

    def helper(self, root, curr_digit):
        # base
        if not root:
            return

        # logic
        curr_digit = (curr_digit * 10) + root.val
        self.helper(root.left, curr_digit)
        if not root.left and not root.right:
            self.sum_ += curr_digit
        self.helper(root.right, curr_digit)

"""
Approach2: Iteration
TC: O(n)
SC: O(n)
"""


def sumNumbers(self, root: TreeNode) -> int:
    sum_ = 0
    stack = deque()
    curr_digit = 0
    while stack or root:
        while root:
            curr_digit = (curr_digit * 10) + root.val
            stack.append((root, curr_digit))
            root = root.left
        root_tup = stack.pop()
        root = root_tup[0]
        curr_digit = root_tup[1]
        if not root.left and not root.right:
            sum_ += curr_digit
        root = root.right
    return sum_

"""
Approach3: Backtracking
TC: O(n)
SC: O(n)
"""


# approach 3: back tracking
class Solution:
    def __init__(self):
        self.sum_ = 0
        self.curr_digit = 0

    def sumNumbers(self, root: TreeNode) -> int:
        self.helper(root)
        return self.sum_

    def helper(self, root):
        # base
        if not root:
            return

        # logic
        self.curr_digit = (self.curr_digit * 10) + root.val
        self.helper(root.left)
        if not root.left and not root.right:
            self.sum_ += self.curr_digit
        self.helper(root.right)
        self.curr_digit = (self.curr_digit) // 10

