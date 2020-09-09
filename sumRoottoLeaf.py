"""
Given preorder and inorder traversal of a tree, construct the binary tree.

Time = O(n), n = number of nodes in a tree
Space: worst = O(n), average(height balanced tree) = O(logn) where n = number of nodes in a tree
Successfully excecuted on leetcode

Approach ---
1. Iterative solution with stack
2. If node doesn't have left or right child, add it to result. If left child is present multiply with 10 and append to stack for next iteration. Same for right child.

"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class ConstructBST:
    def sumNumbers1(self, root):
        if not root:
            return 0
        stack, ans = [(root.val, root)], 0
        while stack:
            node, val = stack.pop()
            if node:
                if not node.left and not node.right:
                    ans += val
                if node.left:
                    stack.append((value*10+node.left.val,node.left))
                if node.right:
                    stack.append((value*10+node.right.val,node.right))
                
        return ans