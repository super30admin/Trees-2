# time complexity : O(n)
# space complexity : O(h) where h is the height of the tree, worst case is O(n) for skewed tree
# approach : recursive approach, we keep track of the current sum and pass it to the left and right child of the node. If we reach a leaf node, we return the current sum.

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        
        def helper(node, currSum):

            # base case
            if not node:
                return 0
            
            currSum = currSum*10 + node.val

            # if its a leaf node
            if not node.left and not node.right:
                return currSum

            # recursive calls
            return helper(node.left, currSum) + helper(node.right, currSum)

        return helper(root, 0)