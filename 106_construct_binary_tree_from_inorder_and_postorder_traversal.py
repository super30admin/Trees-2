# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> TreeNode:
        """
        // Time Complexity : O(n^2)
        // Space Complexity : O(n)
        // Did this code successfully run on Leetcode : Yes
        // Any problem you faced while coding this : Logic
        // Three line explanation of solution in plain english:
                Similar idea as constructing tree from inorder and preorder
                its just the root is at the last.
        POSTORDER:
            LEFT, RIGHT, ROOT
        INORDER:
            LEFT, ROOT, RIGHT
        """
        if not inorder or not postorder: return None

        # create root : root is the last element in postorder
        root = TreeNode(postorder[len(postorder) - 1])

        # find the root in inorder
        idx = -1
        for i in range(len(inorder)):
            if inorder[i] == postorder[len(postorder) - 1]:
                # root found in inorder
                idx = i
                break
        # left inorder
        in_left = inorder[:idx]
        # right inorder
        in_right = inorder[idx + 1:]
        # left postorder
        post_left = postorder[:idx]
        # right postorder
        post_right = postorder[idx:len(postorder) - 1]
        root.left = self.buildTree(in_left, post_left)
        root.right = self.buildTree(in_right, post_right)
        return root
