#Time Complexity: O(n)
#Space Complexity: O(n) Hashmap space
# Did this problem run in Leetcode: Yes
# Any problem you faced while coding this: No

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        map_inorder = {val: idx for idx, val in enumerate(inorder)}

        return self.helper(inorder, 0, len(inorder) - 1,
                           postorder, 0, len(postorder) - 1,
                           map_inorder)
    def helper(self, inorder, instart, inend,
                     postorder, poststart, postend,
                     map_inorder):
        if instart > inend or poststart > postend:
            return None

        rootVal = postorder[postend]
        root = TreeNode(rootVal)
        rootidx = map_inorder[rootVal]

        # Number of nodes in the left subtree
        left_size = rootidx - instart

        root.left = self.helper(inorder, instart, rootidx - 1,
                                postorder, poststart, poststart + left_size - 1,
                                map_inorder)

        root.right = self.helper(inorder, rootidx + 1, inend,
                                 postorder, poststart + left_size, postend - 1,
                                 map_inorder)

        return root