# // Time Complexity : o(n) for deepcopy at each node + o(n/2)*o(height of tree).
# // for complete binary tree, time complexity will be o(nlogn)
# // else for a tree with single leaf with n nodes, o(n^2)
# // Space Complexity : o(n^2) every node(n) stores a copy of stack(o(n))
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : Not in particular
#
#
# // Your code here along with comments explaining your approach
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.sums = 0

    def sumNumbers(self, root: TreeNode) -> int:
        if not root:
            return self.sums
        r1 = []
        self.dfs(root, r1)
        return self.sums

    def dfs(self, node, prevList):
        if not node:
            return
        currList = deepcopy(prevList)
        currList.append(node.val)
        if not node.left and not node.right:
            self.addall(currList)
            return
        self.dfs(node.left, currList)
        self.dfs(node.right, currList)

    def addall(self, list1):
        j = 1
        for i in range(len(list1) - 1, -1, -1):
            self.sums += list1[i] * j
            j *= 10