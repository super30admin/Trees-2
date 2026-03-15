#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Sun Mar 15 00:00:00 2026

@author: rishigoswamy

    LeetCode 106: Construct Binary Tree from Inorder and Postorder Traversal
    Link: https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/

    Problem:
    Given two integer arrays inorder and postorder where inorder is the inorder
    traversal of a binary tree and postorder is the postorder traversal of the same tree,
    construct and return the binary tree.

    Note: You may assume that duplicates do not exist in the tree.

    Approach:
    Use a hashmap for O(1) inorder index lookup and a global index pointer into postorder.
    The last element of postorder is always the root. Its position in inorder splits
    the tree into left and right subtrees.
    Crucially, right subtree must be built before left (postorder is left→right→root,
    so traversing from the end gives root→right→left).

    1️⃣ Build hMap: value → index for O(1) inorder lookup.
    2️⃣ self.idx starts at len(postorder)-1 and decrements with each root picked.
    3️⃣ createTree(left, right) defines the valid inorder window.
    4️⃣ Pick postorder[self.idx] as root, decrement self.idx.
    5️⃣ Recurse RIGHT first on inorder[rootIdx+1 : right], then LEFT on inorder[left : rootIdx-1].

    // Time Complexity : O(n)
        Each node is visited once; hashmap gives O(1) index lookup.
    // Space Complexity : O(n)
        O(n) for the hashmap + O(h) recursive call stack (h = height of tree).

"""

from typing import List, Optional

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:

    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        self.hMap = {}
        for idx, val in enumerate(inorder):
            self.hMap[val] = idx
        self.idx = len(inorder) - 1
        return self.createTree(postorder, 0, len(postorder) - 1)

    def createTree(self, postorder, left, right):
        if left > right:
            return None

        root_val = postorder[self.idx]
        self.idx -= 1
        root = TreeNode(root_val)

        rootIdx = self.hMap[root_val]

        root.right = self.createTree(postorder, rootIdx + 1, right)
        root.left = self.createTree(postorder, left, rootIdx - 1)

        return root

    '''
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        self.hMap = {}
        for idx, val in enumerate(inorder):
            self.hMap[val] = idx

        return self.createTree(inorder, postorder)

    def createTree(self, inorder, postorder):
        root_val = postorder[-1]
        root = TreeNode(root_val)

        root_idx = -1
        for item in inorder:
            root_idx += 1
            if root_val == item:
                break

        leftInorder = inorder[:root_idx]
        rightInorder = inorder[root_idx + 1:]

        leftPostorder = postorder[:root_idx]
        rightPostorder = postorder[root_idx:len(postorder) - 1]

        root.right = self.createTree(rightInorder, rightPostorder) if rightInorder else None
        root.left = self.createTree(leftInorder, leftPostorder) if leftInorder else None

        return root
    '''

    '''
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        if not postorder:
            return None

        idx = inorder.index(postorder[len(postorder) - 1])
        root = TreeNode(postorder[-1])

        root.right = self.buildTree(inorder[idx + 1:], postorder[idx:len(postorder) - 1])
        root.left = self.buildTree(inorder[:idx], postorder[:idx])

        return root
    '''
