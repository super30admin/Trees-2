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
        def RootToLeaf(node, curr_sum):
            if not node:
                return 0  # No value to add if the node is None
            
            curr_sum = curr_sum * 10 + node.val  # Forming the number from root to the current node
            
            if node.left is None and node.right is None:
                return curr_sum

            return RootToLeaf(node.left, curr_sum) + RootToLeaf(node.right, curr_sum)

        return RootToLeaf(root, 0)
