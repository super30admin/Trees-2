'''
Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and postorder is the postorder traversal of the same tree, construct and return the binary tree.
'''
# // Time Complexity : O(n)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        
        # build hashmap for quick search
        idx_map = {val: idx for idx, val in enumerate(inorder)}
        self.post_idx = len(inorder) - 1

        def helper(in_left, in_right):
            # base case
            if in_left > in_right:
                return None

            # get root value from pre_order using pre_idx
            root_val = postorder[self.post_idx]
            self.post_idx -= 1

            # we create the root node, as we need to return the actual tree
            root = TreeNode(root_val)

            # find root index in inorder using hashmap
            rootidx = idx_map[root_val]

            # recurse
            root.right = helper(rootidx + 1, in_right)
            root.left = helper(in_left, rootidx - 1)

            return root

        return helper(0, len(inorder) - 1)