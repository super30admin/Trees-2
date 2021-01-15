# Created by Aashish Adhikari at 6:57 PM 1/14/2021

'''
Time Complexity:
O(n) since we traverse to each node once.

Space Complexity:
Assuming k is the average length of the path from the root to each node, O(n . k) where n is the number of the nodes as
we are creating a new array at each node.'''

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

import copy

class Solution(object):

    def helper(self, node, current_path):



        # base case
        if node.left is None and node.right is None:
            # calculate the current path number
            leng = len(current_path)
            power = 0
            sum = 0
            for idx in range(leng-1, -1, -1):

                sum += (current_path[idx] * pow(10, power))
                power += 1

            self.total_sum += sum




        if node.left is not None:
            path1 = copy.deepcopy(current_path)     # <-- observe the deepcopy
            path1.extend([node.left.val])
            self.helper(node.left, path1)

        if node.right is not None:
            path2 = copy.deepcopy(current_path)     # <-- observe the deepcopy
            path2.extend([node.right.val])
            self.helper(node.right, path2)







    def sumNumbers(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """


        if root is None:
            return 0


        self.total_sum = 0
        self.helper(root, [root.val])

        return self.total_sum
