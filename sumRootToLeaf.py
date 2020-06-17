# Time Complexity : O(n), where n is the number of nodes in the tree.
# Space Complexity : O(h), where h is the height of the tree.
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

# Your code here along with comments explaining your approach
class TreeNode(object):
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution(object):
    # Traversing the tree in a DFS manner where a number is formed until a
    # leaf node is hit and the the number is added to the total.
    def sumNumbers(self, root):
        return self.helper(root, 0)

    def helper(self, root, total):
        if root == None:
            return 0
        # if child node return path to leaf number
        if root.left == None and root.right == None:
            return total * 10 + root.val
        # return left + right
        left = self.helper(root.left, total * 10 + root.val)
        right = self.helper(root.right, total * 10 + root.val)
        return left + right


root = TreeNode(4, TreeNode(9, TreeNode(5), TreeNode(1)), TreeNode(0))  # 1026
print(Solution().sumNumbers(root))
