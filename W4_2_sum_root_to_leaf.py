# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        self.result = 0
        self.helper(root, 0)
        return self.result

    def helper(self, root, curr_sum):
        #base  
        if root == None:
            return

        #logic
        curr_sum = curr_sum * 10 + root.val

        self.helper(root.left, curr_sum)
        self.helper(root.right, curr_sum)

        # Check if current node if leaf
        if root.right == None and root.left == None:
            self.result = self.result + curr_sum

# Time complexity: O(N), where N is number of nodes in the tree
# Space compexity: O(H), worst case O(N) - h is the height of the tree

