class TreeNode(object):
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution(object):
    # Time Complexity : O(n), where n is the length of postorder or inorder array.
    # Space Complexity : O(n^2), because at each node there are 4 new arrays made.
    # Did this code successfully run on Leetcode : yes
    # Any problem you faced while coding this : no

    # Your code here along with comments explaining your approach

    # for each number distinguish it's left and right subtrees in the
    # arrays by finding the parent iteratively from the inorder array.
    # Recursively call the function to recreate the subtrees for every node.
    def buildTree(self, inorder, postorder):
        if not postorder or not inorder:
            return None
        root = TreeNode(postorder[-1])
        idx = -1
        for i in range(len(inorder)):
            if inorder[i] == root.val:
                idx = i
        # two arrays from postorder
        postLeft, postRight = postorder[:idx], postorder[idx: -1]
        # two arrays from inorder
        inLeft, inRight = inorder[:idx], inorder[idx + 1:]
        # recursive calls to form left and right subtrees of each node
        root.left = self.buildTree(inLeft, postLeft)
        root.right = self.buildTree(inRight, postRight)
        return root

#------------------------------------------------------x---------------------------------------------------------------#

    # Time Complexity : O(n), where n is the length of postorder or inorder array.
    # Space Complexity : O(h), recursive stack space.
    # Did this code successfully run on Leetcode : yes
    # Any problem you faced while coding this : no

    # Your code here along with comments explaining your approach

    # For each number distinguish it's left and right subtrees in the
    # arrays by finding the parent stored in a hashmap, O(1) lookup.
    # Recreate the two subtrees for each node by passing in indices
    # to distinguish it's subtrees from the original array.
    def __init__(self):
        self.index = 0
        self.store = {}

    def buildTreeBetterSpace(self, inorder, postorder):
        if not inorder or not postorder:
            return None
        self.index = len(postorder) - 1
        for idx, elem in enumerate(inorder):
            self.store[elem] = idx
        return self.helper(postorder, inorder, 0, len(postorder) - 1)

    def helper(self, postorder, inorder, start, end):
        # base case
        if start > end or self.index < 0:
            return None
        # logic
        root = TreeNode(postorder[self.index])
        # index of root to distinguish subtrees
        idx = self.store[root.val]
        self.index -= 1
        # recursive calls to build the tree
        root.right = self.helper(postorder, inorder, idx + 1, end)
        root.left = self.helper(postorder, inorder, start, idx - 1)

        return root
