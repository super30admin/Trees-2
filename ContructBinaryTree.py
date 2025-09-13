# Time Complexity : O(n)
# Space Complexity : O(n) for hashmap
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# The intuition here is to take the root from postorder traversal and to determine if left and right subtree exists checkout the inorder traversal
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        hm = {val: idx for idx, val in enumerate(inorder)}

        def helper(l, r):
            if l > r: return None

            root = TreeNode(postorder.pop())
            idx = hm[root.val]
            root.right = helper(idx + 1, r)
            root.left = helper(l, idx - 1)

            return root

        return helper(0, len(inorder) - 1)