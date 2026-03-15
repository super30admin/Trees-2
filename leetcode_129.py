#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Sun Mar 15 00:00:00 2026

@author: rishigoswamy

    LeetCode 129: Sum Root to Leaf Numbers
    Link: https://leetcode.com/problems/sum-root-to-leaf-numbers/

    Problem:
    You are given the root of a binary tree containing digits from 0 to 9 only.
    Each root-to-leaf path in the tree represents a number (e.g. 1→2→3 = 123).
    Return the total sum of all root-to-leaf numbers.

    Approach:
    BFS (level-order traversal) using a queue of [node, currentValue] pairs.
    Propagate the running number down the tree: at each step, currval = parent*10 + child.val.
    When a leaf is reached (no left or right child), add currval to totalsum.

    1️⃣ Initialize queue with [root, root.val].
    2️⃣ Pop front of queue; push left/right children with updated currval = currval*10 + child.val.
    3️⃣ If node is a leaf, accumulate currval into totalsum.
    4️⃣ Return totalsum when queue is empty.

    // Time Complexity : O(n)
        Every node is visited once.
    // Space Complexity : O(n)
        Queue holds at most O(n) nodes (worst case: last level of a complete binary tree).

"""

from typing import Optional

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        queue = []
        queue.append([root, root.val])
        totalsum = 0

        while queue:
            node, currval = queue.pop(0)

            if node.left:
                queue.append([node.left, currval * 10 + node.left.val])
            if node.right:
                queue.append([node.right, currval * 10 + node.right.val])

            if node.left is None and node.right is None:
                totalsum += currval

        return totalsum
