# TC: O(n) - Each node is visited once.
# SC: O(h) - Space used by recursion stack, where h is the tree height (O(n) for skewed trees).
# Approach: 
# 1. Use recursion to traverse the tree and build numbers from root to leaf.
# 2. When a leaf node is reached, return the formed number.
# 3. Sum the results from left and right subtrees to get the total.

class Solution(object):
    def sumNumbers(self, root):
        def sum(root, digit):
            if not root:
                return 0

            digit = digit * 10 + root.val
            if not root.left and not root.right:
                return digit
            return sum(root.left, digit) + sum(root.right, digit)

        return sum(root, 0)
