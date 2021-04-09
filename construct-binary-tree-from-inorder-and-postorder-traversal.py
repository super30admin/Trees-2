# Time Complexity : O(n), where n is the number of nodes
# Space Complexity : O(h), where h is the height of the tree
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> TreeNode:
        postorder_index = len(postorder) - 1

        root = TreeNode(postorder[postorder_index])
        postorder_index -= 1

        inorder_map = dict()
        for i, val in enumerate(inorder):
            inorder_map[val] = i

        def helper(start, end):
            nonlocal postorder, postorder_index, inorder_map

            if end < start:
                return None

            root = TreeNode(postorder[postorder_index])
            postorder_index -= 1

            index = inorder_map[root.val]

            root.right = helper(index + 1, end)
            root.left = helper(start, index - 1)

            return root

        index = inorder_map[root.val]

        root.right = helper(index + 1, len(postorder) - 1)
        root.left = helper(0, index - 1)

        return root
