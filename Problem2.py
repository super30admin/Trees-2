'''

Time Complexity : O(n)
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No issues faced

Your code here along with comments explaining your approach

We need to calculate the sum at every leaf node. So we use a local variable sum and a global variable final to get the
desired result

'''



# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right


class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        def calculate(node,sum):
            nonlocal final
            if node.left is None and node.right is None:
                final += (sum * 10 + node.val)
                return

            sum = sum * 10 + node.val
            if node.left:
                calculate(node.left,sum)
            if node.right:
                calculate(node.right,sum)

        final = 0
        calculate(root,0)
        return final