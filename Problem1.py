# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        inorderIdx = {v: i for i, v in enumerate(inorder)}  # num -> idx

        def helper(l, r):
            # Base Case:
            if l > r:
                return None
            root = TreeNode(postorder.pop())
            idx = inorderIdx[root.val]
            # Recursive Case
            root.right = helper(idx + 1, r)
            root.left = helper(l, idx - 1)
            return root

        return helper(0, len(inorder) - 1)
        # T: O(n), S: O(h)