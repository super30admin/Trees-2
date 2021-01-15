# Created by Aashish Adhikari at 6:07 PM 1/14/2021


'''
Time Complexity:
Traverse each node and at each node find the index of the root location in the inorder list --> O(n ^ 2)

Space Complexity:
O(n) since creating new variables at each node.
'''

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):




    def buildTree(self, inorder, postorder):
        """
        :type inorder: List[int]
        :type postorder: List[int]
        :rtype: TreeNode
        """

        if len(postorder) == 0:
            return None

            # last node of postorder traversal is the root.
        root = postorder[-1]

        root_pos_in_inorder_traversal = inorder.index(root)

        left_subtree_inorder = inorder[0:root_pos_in_inorder_traversal ]
        right_subtree_inorder = inorder[root_pos_in_inorder_traversal+ 1 :]

        no_elems_in_left_subtree = len(left_subtree_inorder)
        no_elems_in_right_subtree = len(right_subtree_inorder)

        left_subtree_postorder = postorder[0:no_elems_in_left_subtree]
        right_subtree_postorder = postorder[no_elems_in_left_subtree:no_elems_in_left_subtree+no_elems_in_right_subtree]

        left = self.buildTree(left_subtree_inorder, left_subtree_postorder)
        right = self.buildTree(right_subtree_inorder, right_subtree_postorder)

        return TreeNode(val = root, left = left, right = right)
