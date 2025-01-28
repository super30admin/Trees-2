# Time Complexity : O(n), n is no of nodes in the tree
# Space Complexity : O(h), where h is the height of the tree, since its a recursive solution, it uses stack implementation under the hood, and the no of elements in a stach at any time will at max be equal to the height of the tree (left subtree or right subtree)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : NA 

# Your code here along with comments explaining your approach:
# we have to make sum of all paths in the tree, so we start traversing the tree until we find a leaf node
# if we do, we will add the sum of all the nodes in a number and then return the sum of that path
# else we just keep traversing the left and the right subtree until we find a leaf node
# the formula for adding sum is - root.val (current root's value) + currentsum (previous sum) * 10 => to make the sum number needed



# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution(object):
    def __init__(self):
        self.summ = 0

    def sumNumbers(self, root):
        """
        :type root: Optional[TreeNode]
        :rtype: int
        """
        if root is None:
            return -1
        
        self.dfs(root, 0)
        return self.summ
    
    def dfs(self, root, currsum):
        if root is None:
            return
        
        # checking for leaf nodes, adding the root value to the sum, and then stopping
        if root.left is None and root.right is None:
            self.summ = self.summ + currsum * 10 + root.val
            return
        
        # traversing left and right, updating the current sum
        self.dfs(root.left, currsum * 10 + root.val)
        self.dfs(root.right, currsum * 10 + root.val)

