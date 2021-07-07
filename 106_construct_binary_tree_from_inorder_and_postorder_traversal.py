# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    # temp value for post order
    postorder_index = -1
    inorder_dict = {}

    def buildTree(self, inorder: List[int], postorder: List[int]) -> TreeNode:
        """
              // Time Complexity : O(n)
              // Space Complexity : O(n) dictionary
        """
        if not inorder or not postorder: return None

        self.postorder_index = len(postorder) - 1

        for idx, num in enumerate(inorder):
            self.inorder_dict[num] = idx
        return self._helper(inorder, postorder, 0, len(inorder) - 1)

    def _helper(self, inorder: List[int], postorder: List[int], start: int, end: int):
        # base case
        if start > end or self.postorder_index < 0:
            return
            # logic
        inorder_index = self.inorder_dict[postorder[self.postorder_index]]
        self.postorder_index -= 1
        root = TreeNode(inorder[inorder_index])

        if start == end:
            return root

        root.right = self._helper(inorder, postorder, inorder_index + 1, end)
        root.left = self._helper(inorder, postorder, start, inorder_index - 1)

        return root

    def buildTreeBruteForce(self, inorder: List[int], postorder: List[int]) -> TreeNode:
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
        root.left = self.buildTreeBruteForce(in_left, post_left)
        root.right = self.buildTreeBruteForce(in_right, post_right)
        return root
