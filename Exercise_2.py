# Time Complexity: O(N)
# Space Complexity: O(H) where H is the height of the tree
# Were you able to solve this on your own? Yes
# Any problem you faced while coding this: No

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.sum = 0

    def sumNumbers(self, root: Optional[TreeNode]) -> int:

        if not root:
            return 0


        def dfs(root: TreeNode, prevsum: int):

            # base case
            if not root:
                return None

            # calculate current node sum by using prev calc sum * 10 with curr node value
            currsum = prevsum * 10 + root.val

            # recursively traverse left subtree
            dfs(root.left, currsum)

            # if leaf node is reached, add the currsum with the total sum so far
            if not root.left and not root.right:
                self.sum += currsum

            # recursively traverse right subtree
            dfs(root.right, currsum)


        dfs(root, 0)

        return self.sum







    
        