## Problem1 (https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/)

# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution(object):
    def buildTree(self, inorder, postorder):
        if not inorder or not postorder:
            return None
        root = TreeNode(postorder.pop())
        rootIndex = inorder.index(root.val)
        root.right = self.buildTree(inorder[rootIndex+1:], postorder)
        root.left = self.buildTree(inorder[:rootIndex], postorder)
        return root


## Problem2 (https://leetcode.com/problems/sum-root-to-leaf-numbers/)

# Time Complexity : O(n)
# Space Complexity : O(h) h is height of tree
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution(object):
    def sumNumbers(self, root):
        if not root:
            return 0
        self.result = 0
        self.helper(root, 0)
        return self.result

    def helper(self, root, currSum):
        if not root:
            return
        currSum = currSum * 10 + root.val
        self.helper(root.left, currSum)
        if not root.left and not root.right:
            self.result += currSum
        self.helper(root.right, currSum)

