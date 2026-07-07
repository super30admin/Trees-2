#Problem 129. SUM ROOT TO LEAF NUMBERS
# TIME COMPELXITY: O(N) where N denotes the number of nodes in a given tree
# SPACE COMPLEXITY: O(H) where H denotes the height of the given tree as we are making a recursive stack call here


# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def sumNumbers(self, root):
        """
        :type root: Optional[TreeNode]
        :rtype: int
        """
        #fullAns=0
        return self.helper(root,0)

    def helper(self,root,current):
        #base
        if root is None:
            return 0
        
        #logic
        current=10*current+root.val

        if root.left is None and root.right is None:
            return current

        left=self.helper(root.left,current)
        right=self.helper(root.right,current)
        #finalAns=left+right
        return left+right

