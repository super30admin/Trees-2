# Created by Aashish Adhikari at 9:25 AM 1/15/2021

'''
Time Complexity:
O(n) since we traverse to each node once.

Space Complexity:
O(height of the tree) as we are maintaining a recursive stack
'''


# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def sumNumbers(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """




        total_sum = 0
        current_sum = 0

        from collections import deque
        recursive_stack = deque()

        while root is not None or len(recursive_stack) != 0:

            # traverse only to the left until the end
            while root is not None:

                current_sum = current_sum * 10 + root.val
                recursive_stack.append((root, current_sum))
                root = root.left





            root, current_sum = recursive_stack.pop()

            # mid node, so check here
            if root.left is None and root .right is None:
                total_sum += current_sum



            root = root.right



        return total_sum


