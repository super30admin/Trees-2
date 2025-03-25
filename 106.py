# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
# Time complexity : O(n)
# Space Complexity : O(n)
class Solution(object):
    def buildTree(self, inorder, postorder):
        """
        :type inorder: List[int]
        :type postorder: List[int]
        :rtype: Optional[TreeNode]
        """
        if not inorder or not postorder:
            return None

        # Map each value to its index in the inorder list for quick lookup
        inorder_map = {}
        for idx in range(len(inorder)):
             val = inorder[idx]
             inorder_map[val] = idx

        def helper(in_left, in_right):
            if in_left > in_right:
                return None

            # The last element in postorder is the root
            root_val = postorder.pop()
            root = TreeNode(root_val)

            # Get the index of root from inorder to split left and right subtrees
            index = inorder_map[root_val]

            # Build right subtree first since we're popping from the end of postorder
            root.right = helper(index + 1, in_right)
            root.left = helper(in_left, index - 1)

            return root

        return helper(0, len(inorder) - 1)
        