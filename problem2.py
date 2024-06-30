#Time Complexity : O(n) - visit all the nodes
#Space Complexity : O(h) - O(n) for skewed and O(logn) for the best case scenario
#Any problem you faced while coding this :-

#The approach is to traverse the entire binary tree for unqiue paths which would be done while we visit each and every node. We need to maintain a global sum variable and a local number(number formed until that node). At every recursive call we need to change the number by multiplying by 10 and adding the current node value. If we are the leaf node then we add the number to the global sum. We need to have a base case of root being null for handling the scenario where the node has only 1 child.


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def __init__(self):
        self.total_sum = 0

    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        self.helper(root, 0)
        return self.total_sum

    def helper(self, root, currNum):
        #base
        if root is None:
            return

        #logic
        currNum = currNum*10 + root.val
        if root.left is None and root.right is None:
            self.total_sum += currNum

        self.helper(root.left, currNum)
        self.helper(root.right, currNum)


