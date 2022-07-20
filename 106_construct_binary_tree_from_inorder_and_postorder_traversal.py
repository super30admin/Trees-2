'''
## Problem 106: Construct binary tree from inorder and postorder traversals

## Author: Neha Doiphode
## Date:   07-19-2022

## Description:
    Given two integer arrays inorder and postorder where,
    inorder is the inorder traversal of a binary tree and
    postorder is the postorder traversal of the same tree,
    construct and return the binary tree.

## Examples:
    Example 1:
        Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
        Output: [3,9,20,null,null,15,7]

    Example 2:
        Input: inorder = [-1], postorder = [-1]
        Output: [-1]

## Constraints:
    1 <= inorder.length <= 3000
    postorder.length == inorder.length
    -3000 <= inorder[i], postorder[i] <= 3000
    inorder and postorder consist of unique values.
    Each value of postorder also appears in inorder.
    inorder is guaranteed to be the inorder traversal of the tree.
    postorder is guaranteed to be the postorder traversal of the tree.

## Time complexity: O(n^2), n to build each node.
                            n to search the node in the list and copying each node.

## Space complexity: O(n^2), n times we build 4 auxiliary arrays.

'''
from typing import List, Optional

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
         self.val = val
         self.left = left
         self.right = right

def get_input():
    print("Enter list of tree nodes in in-order: ", end = "")
    inp_list = input()
    inorder = [int(val) for val in inp_list.split()]

    print("Enter list of tree nodes in post-order: ", end = "")
    inp_list = input()
    preorder = [int(val) for val in inp_list.split()]

    return inorder, postorder

class Solution:
    lookup = {}
    
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        '''
        '''
        if len(inorder) == 0 or len(postorder) == 0:
            return None

        # Find root from postorder list as root will be at the end of postorder list
        root_value = postorder[-1]

        # create root node
        root = TreeNode(root_value)

        # Find root_value and corresponding index from inorder list
        for root_index, num in enumerate(inorder):
            if num == root_value:
                break

        # Find left and right substrees from inorder list based on root index
        inorder_left  = inorder[:root_index]
        inorder_right = inorder[root_index + 1:]

        # Now since we know lengths of left and right subtrees, we can split postorder as well based on lengths of trees.
        postorder_left  = postorder[:root_index]
        postorder_right = postorder[root_index:len(postorder) - 1]

        root.left = self.buildTree(inorder_left, postorder_left)
        root.right = self.buildTree(inorder_right, postorder_right)

        return root

    def helper(self, inorder: List[int], postorder: List[int], start: int, end: int) -> Optional[TreeNode]:
        # base case
        if start > end:
            return None

        root_value = postorder.pop()
        root_index = self.lookup[root_value]
        root = TreeNode(root_value)


        ###### IMPORTANT: BUILDING THE RIGHT SUB-TREE FIRST AS we are give post-order.
        ### Elements in postorder are left right root
        ### accessing the postorder list from the end we get right sub-tree first after the root, so we build that first
        root.right = self.helper(inorder, postorder, root_index + 1, end)
        root.left  = self.helper(inorder, postorder, start, root_index - 1)

        return root

    def buildTree_optimized(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        '''
        ## Time complexity: O(n), iterating over n elements to build n nodes.

        ## Space complexity: O(n), auxiliary hash map to store n elements.
                                  O(h) to store recursive stack.
                                  since h < n we consider O(n).
        '''
        if len(inorder) == 0 or len(postorder) == 0:
            return None

        # Make use of hashmap to find index of root in inorder list to improve the time complexity.
        for i, num in enumerate(inorder):
            self.lookup[num] = i

        # Now call helper function to perform recursion
        return self.helper(inorder, postorder, 0, len(inorder) - 1)
