# TimeComplexity: O(n)
# SpaceComplexity: O(n)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        return self.rtlTraverse(root, 0)

    def rtlTraverse(self, root: TreeNode, num: int) -> int:
        if root is None:
            return 0

        num = num * 10 + root.val
        if root.left is None and root.right is None:  #leaf node
            return num      

        left_sum = self.rtlTraverse(root.left, num)
        
        right_sum = self.rtlTraverse(root.right, num)
        res = left_sum + right_sum
        return res
res = 0






# TimeComplexity: O(n)
# SpaceComplexity: O(n)
# https://leetcode.com/problems/path-sum/description/
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def hasPathSum(self, root: Optional[TreeNode], targetSum: int) -> bool:
        return self.traversal(root, targetSum, 0)

    def traversal(self, root: Optional[TreeNode], targetSum: int, NodesSum: int) -> bool:
        if root == None:
            return False

        NodesSum = NodesSum + root.val

        if root.left == None and root.right == None:
            return targetSum == NodesSum

        return self.traversal(root.left, targetSum, NodesSum) or self.traversal(root.right, targetSum, NodesSum)
