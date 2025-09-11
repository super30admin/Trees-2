# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    # tc : O(n) visiting each node once
    # sc : O(h) h used in recurssive stack 
    def sumNumbers(self, root):
        """
        :type root: Optional[TreeNode]
        :rtype: int
        """
        # approach
        # recrussively calculating the sum of the path from root to the leaf node by multiplying the current value with 10 and adding the new node we came across in the path
        # when we reach the leaf noe return the sum we foudn so far as we reached a path, returnign the sum of the left and the right subtree values in the recrussion
        # in recrussive manner sum of left and riht of that node and keep addding so on to get the sum of each path. 
        return self.helper(root,0)

    def helper(self, root, curr):
        if root is None:
            return 0

        curr = curr*10 + root.val

        if root.left is None and root.right is None:
            return curr

        left_sum = self.helper(root.left,curr)
        right_sum = self.helper(root.right,curr)

        return left_sum + right_sum
        
        



        