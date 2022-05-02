# // Time Complexity : O(n)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : no

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:

        def build(left, right):
            nonlocal pindex

            if left > right:
                return None
            root_val = postorder[pindex]
            root = TreeNode(root_val)

            pindex = pindex + 1

            index = position[root_val]

            root.right = build(index + 1, right)

            root.left = build(left, index - 1)

            return root

        postorder.reverse()
        pindex = 0
        position = {}

        for index, val in enumerate(inorder):
            position[val] = index

        return build(0, len(postorder) - 1)
