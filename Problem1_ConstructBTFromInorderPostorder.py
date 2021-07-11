# Time Complexity: O(n), where n is the length of the input arrays
# Space Complexity: O(n)
# Did this code successfully run on Leetcode: Yes

# Solution:

class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> TreeNode:
        if not inorder or len(inorder) == 0:
            return None

        self.postorder_idx = len(postorder) - 1

        # A dictionary to store the indices of the inorder values
        self.inorder_idx_map = dict()
        for i in range(len(inorder)):
            self.inorder_idx_map[inorder[i]] = i

        return self.helper(postorder, 0, len(postorder) - 1)


    def helper(self, postorder: List[int], start: int, end: int) -> TreeNode:
        # If there are no elements to build the subtrees
        if start > end:
            return None

        # Consider postorder_idx element as the root and build its right and left subtree using inorder indices
        rootval = postorder[self.postorder_idx]
        self.postorder_idx -= 1
        root = TreeNode(rootval)

        inorder_idx = self.inorder_idx_map[rootval]
        root.right = self.helper(postorder, inorder_idx + 1, end)
        root.left = self.helper(postorder, start, inorder_idx - 1)

        return root



