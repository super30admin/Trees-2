"""
TC - O(n)
SC - O(n)
"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        inorder_index = 1

        postorder_index_map = {}

        for idx, val in enumerate(postorder):
            postorder_index_map[val] = idx

        # print(postorder_index_map)

        def array_to_tree(left, right):
            nonlocal inorder_index

            if left > right:
                return None

            # root_value
            root_value = inorder[inorder_index]
            root = TreeNode(root_value)

            inorder_index += 1

            # create subtrees
            root.left = array_to_tree(left, postorder_index_map[root_value] - 1)
            root.right = array_to_tree(postorder_index_map[root_value] + 1, right)

            return root

        return array_to_tree(0, len(postorder) - 1)