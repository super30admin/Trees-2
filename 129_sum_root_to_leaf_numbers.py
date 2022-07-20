'''

## Problem 129: Sum Root to Leaf Numbers

## Author: Neha Doiphode
## Date:   07-16-2022

## Description
    You are given the root of a binary tree containing digits from 0 to 9 only.
    Each root-to-leaf path in the tree represents a number.
    For example, the root-to-leaf path 1 -> 2 -> 3 represents the number 123.
    Return the total sum of all root-to-leaf numbers.
    Test cases are generated so that the answer will fit in a 32-bit integer.
    A leaf node is a node with no children.

## Examples:
    Example 1:
        Input: root = [1,2,3]
        Output: 25
        Explanation: The root-to-leaf path 1->2 represents the number 12.
                     The root-to-leaf path 1->3 represents the number 13.
                     Therefore, sum = 12 + 13 = 25.

    Example 2:
        Input: root = [4,9,0,5,1]
        Output: 1026
        Explanation: The root-to-leaf path 4->9->5 represents the number 495.
                     The root-to-leaf path 4->9->1 represents the number 491.
                     The root-to-leaf path 4->0 represents the number 40.
                     Therefore, sum = 495 + 491 + 40 = 1026.

## Constraints:
    The number of nodes in the tree is in the range [1, 1000].
    0 <= Node.val <= 9
    The depth of the tree will not exceed 10.

## Time complexity: O(n), where n is number of nodes in the tree
                          as we traverse all paths from root to leaf nodes of the tree.

## Space complexity: O(n), to store tree nodes on the recursion stack

'''

from typing import List, Optional

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

def to_binary_tree(items):
    if not items:
        return None

    # iter(object, sentinel [optional])
    # sentinel = special character used to represent end of the sequence.
    it = iter(items)
    root = TreeNode(next(it))
    q = [root]
    for node in q:
        val = next(it, None)
        if val is not None:
            node.left = TreeNode(val)
            q.append(node.left)
        val = next(it, None)
        if val is not None:
            node.right = TreeNode(val)
            q.append(node.right)
    return root

def get_input():
    print("Enter nodes of tree with spaces at height h, from left to right.")
    print("Input null if no left or right child to a node at height h.")
    inp_list = input()
    inp_list = inp_list.split()
    l = []
    for value in inp_list:
        if value != "null":
            l.append(int(value))
        else:
            l.append(None)

    return l, to_binary_tree(l)

class Solution:
    total = 0
    def helper(self, root: Optional[TreeNode], prev_num: int) -> None:
        # base case
        if root == None:
            return

        # exit condition
        if root.left == None and root.right == None:
            self.total = self.total + (10 * prev_num) + root.val
            return

        # logic
        self.helper(root.left, (10 * prev_num) + root.val)
        self.helper(root.right, (10 * prev_num) + root.val)


    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        if root != None:
            self.helper(root, 0)
        return self.total

    def helper_without_total(self, root: Optional[TreeNode], prev_num: int) -> int:
        # base case
        if root == None:
            return 0

        # exit condition
        if root.left == None and root.right == None:
            return (10 * prev_num) + root.val

        # logic
        return self.helper_without_total(root.left, (10 * prev_num) + root.val) + self.helper_without_total(root.right, (10 * prev_num) + root.val)

    def sumNumbers_without_total(self, root: Optional[TreeNode]) -> int:
        if root == None:
            return 0
        return self.helper_without_total(root, 0)

    def sumNumbers_using_iteration_with_two_stacks(self, root: Optional[TreeNode]) -> int:
        if root == None:
            return 0

        # To store path sum
        path_sum = 0

        # Iteration stack
        stack = []

        # To keep track of tree node value encountered so far or previous root value
        current_num = []

        # At root node, we assume previous node value is 0.
        num = 0

        # Now perform regular iterative inorder traversal
        while root != None or len(stack) != 0:
            while root != None:
                stack.append(root)
                num  = (10 * num) + root.val
                current_num.append(num)
                root = root.left

            root = stack.pop()
            num  = current_num.pop()
            if root.left == None and root.right == None:
                path_sum += num
            root = root.right

        return path_sum

# Driver code
solution = Solution()
l, root = get_input()
print(f"Input Tree: {l}", end = "")
print()
print(f"Approach 1: With total class variable: Sum of all paths from root to leaf numbers: {solution.sumNumbers(root)}")
print(f"Approach 2: Without total class variable: Sum of all paths from root to leaf numbers: {solution.sumNumbers_without_total(root)}")
