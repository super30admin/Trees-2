# // Time Complexity : O(n)
# // Space Complexity :  O(n)
# // Did this code successfully run on Leetcode :Yes
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):

    def pathSum(self, root, targetSum):
        """
        :type root: TreeNode
        :type targetSum: int
        :rtype: List[List[int]]
        """
        def findPath(root,curSum,ts,temp_path):
            if root == None:
                return
            curSum += root.val
            temp_path = temp_path + [root.val]
            if not root.left and not root.right and curSum == ts:
                path.append(temp_path)
            if root.left:
                findPath(root.left,curSum,ts,temp_path)
            if root.right:
                findPath(root.right,curSum,ts,temp_path)

        if root == None:
            return []
        temp_path = []
        path = []
        findPath(root,0,targetSum,temp_path)
        return path
