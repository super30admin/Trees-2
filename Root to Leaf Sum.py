# Time Complexity : O(d) where d is the depth of the tree
# Space Complexity : O(d) is the depth of the tree
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no



#In each node we will retrieve the number and add to a list and save the sum, if the sum equals target at any node, we will save the list to the output listt
# we will do in recursive manner such that while backtracking the current element and the sum will be removed

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def sumNumbers(self, root: TreeNode) -> int:

        return self.sumRoot2Leaf(root, 0)

    def sumRoot2Leaf(self, root, sumValue):

        if root == None: return 0

        if root.left == None and root.right == None:
            return sumValue * 10 + root.val

        return self.sumRoot2Leaf(root.left, sumValue * 10 + root.val) + self.sumRoot2Leaf(root.right,
                                                                                          sumValue * 10 + root.val)

