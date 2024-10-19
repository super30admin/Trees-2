"""
From the preorder get the root and from the inorder get the number of right and left children. From here, create 4
array (1) pre_left, (2) in_left (3) pre_right (4) in_right.
ROOT IS FOUND
pre_left: contain elements to the left of root from the preorder array, pre_right: contain elements to the left of root
from the preorder array, in_left: contain elements to the left of root from the inorder array, in_right: contain
elements to the left of root from the  inorder array.
Again from the in_left and pre_left find root and its left and right children. THis is basically the left child
of ROOT
Again from the in_right and pre_right find root and its left and right children. THis is basically the right child
of ROOT.
REPEAT the above steps.
TC: o(n) to search the root in the in-order + O(2n) to copy the 4 arrays. We are making recursive call for every node.
It would O(n^2). SC: (n^2) creating array of size 2n at each node. Thus, O(n^2)

Optimized: Search could be replaced with hash map and another copy of the array could be avoided by using index.
TC: O(n) and SC: O(n)
"""
from typing import List


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution1:
    def helper_appraoch1(self, preorder, inorder):

        # BC
        if len(preorder) == 0:
            return None

            # recursive case
        # ge the root from the pre_order
        root_val = preorder[0]
        # find the root location in the in-order
        # once found break
        root_idx = -1
        for i in range(len(inorder)): #
            if inorder[i] == root_val:
                root_idx = i
                break

        # for the current pair of pre-order and in-order
        # create the tree node as root
        root = TreeNode(root_val)

        # for the current pair of pre-order and in-order
        # create the left child
        in_left = inorder[:root_idx]
        pre_left = preorder[1:len(in_left) + 1]

        # to get the left child of the root, call the helper
        # to create sub tree with that pair of pre-order and in-order
        root.left = self.helper(pre_left, in_left)

        # for the current pair of pre-order and in-order
        # create the right child
        in_right = inorder[root_idx + 1:]
        pre_right = preorder[len(in_left) + 1:]

        # to get the right child of the root, call the helper
        # to create sub tree with that pair of pre-order and in-order
        root.right = self.helper(pre_right, in_right)

        # each recursive call will return its root
        return root


        def helper(self, preorder, inorder, hmap, start, end):
            global idx

            # base case,
            if start > end:
                return None

                # recursive
            root_val = preorder[idx]

            # search for root in in-order
            root_idx = hmap[root_val]

            idx += 1

            # create root
            root = TreeNode(root_val)

            # for the left sub-tree, the start idx is same and end idx is root_idx -1
            root.left = self.helper(preorder, inorder, hmap, start, root_idx - 1)

            # for the right sub-tree, the start idx is root_idx + 1 and end idx is same
            root.right = self.helper(preorder, inorder, hmap, root_idx + 1, end)

            return root

        def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
            hmap = {}
            global idx
            idx = 0
            for i in range(len(inorder)):
                hmap[inorder[i]] = i

            tree = self.helper(preorder, inorder, hmap, 0, len(preorder) - 1)
            return tree

    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        return self.helper(preorder, inorder)


class Solution2:
    def helper(self, preorder, inorder, hmap, start, end):
        global idx

        # base case,
        if start > end:
            return None

            # recursive
        root_val = preorder[idx]

        # search for root in in-order
        root_idx = hmap[root_val]

        idx += 1

        # create root
        root = TreeNode(root_val)

        # for the left sub-tree, the start idx is same and end idx is root_idx -1
        root.left = self.helper(preorder, inorder, hmap, start, root_idx - 1)

        # for the right sub-tree, the start idx is root_idx + 1 and end idx is same
        root.right = self.helper(preorder, inorder, hmap, root_idx + 1, end)

        return root

    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        hmap = {}
        global idx
        idx = 0
        for i in range(len(inorder)):
            hmap[inorder[i]] = i

        tree = self.helper(preorder, inorder, hmap, 0, len(preorder) - 1)
        return tree







