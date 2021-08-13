"""
Time Complexity : O(n)
Space Complexity : O(n)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        # Dictionary having the index values of inorder list
        mainDict = { num:idx for idx, num in enumerate(inorder) }
        self.idx = len(postorder) - 1
        def helper(start:int, end:int):
            # Base
            if start > end:
                return None
            # Logic
            if self.idx >= 0:
                root = TreeNode(postorder[self.idx])
                # Decrementing the index in postorder as we traverse reverse
                self.idx -= 1
                rootIdx = mainDict[root.val]
                # Creating right sub-tree first as postorder will have right node 
                # after we find root node. So moving reverse through the postorder
                root.right = helper(rootIdx + 1, end)
                root.left = helper(start, rootIdx - 1)
                return root
        return helper(0, len(inorder) - 1)