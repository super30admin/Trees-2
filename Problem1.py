# 106. Construct Binary Tree from Inorder and Postorder Traversal

# Time Complexity: O(n)
# Space Complexity: O(n)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No

# Intuition:
# The last element of the postorder traversal is the root of the tree.
# The elements before the root in the inorder traversal are the left subtree.
# The elements after the root in the inorder traversal are the right subtree.
# Split the postorder and inorder arrays into left and right subtrees and recurse.

class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> TreeNode:
        def helper(in_left: int, in_right: int) -> TreeNode:
            if in_left > in_right:
                return None

            val = postorder.pop()
            root = TreeNode(val)

            index = idx_map[val]

            root.right = helper(index + 1, in_right)
            root.left = helper(in_left, index - 1)
            return root

        idx_map = {val: idx for idx, val in enumerate(inorder)}
        return helper(0, len(inorder) - 1)
    
