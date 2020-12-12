# Time: O(N)
# Space: O(N)

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def buildTree(self, inorder, postorder):
        idxmap = {val: idx for idx, val in enumerate(inorder)}
        pre_idx = len(postorder) - 1

        def builTreeHelper(start, end):
            if start > end:
                return None
            nonlocal pre_idx
            root_val = postorder[pre_idx]
            root = TreeNode(root_val)

            index = idxmap[root_val]
            # recursion
            pre_idx -= 1
            root.right = builTreeHelper(index + 1, end)
            root.left = builTreeHelper(start, index - 1)
            return root

        return builTreeHelper(0, len(inorder) - 1)