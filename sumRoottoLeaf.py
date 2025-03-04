# Iterative approach
# TC = O(n)
# SC = O(h)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        # base case
        if root is None: return 0

        # initialize two stacks -
        # one stack to store tree nodes and
        # other stack to store nums at each level
        s_stack = []
        nums_stack = []

        sum = 0
        num = 0

        # while there is at least 1 root or while stack is not empty
        while root or s_stack:
            while root is not None:
                # push each node to stack
                s_stack.append(root)
                # calculate num at each level to push into nums_stack
                num = num * 10 + root.val
                # nums_stack will contain --> 4, 49, 495, ...
                nums_stack.append(num)
                # continue till the last left node
                root = root.left
            # when all left nodes are exhausted
            # Example 2 --> 495 will be poped and sum will be calculated.
            # next item in the stack will be 49 and in s_stack will be 9. both will be popped.
            root = s_stack.pop()
            num = nums_stack.pop()

            # check if leaf node
            if root.left is None and root.right is None:
                # calculate cumulative sum
                sum = sum + num
            # start processing right nodes
            # Example 2 --> right node will be processed and 491 will be pushed
            root = root.right
        return sum


