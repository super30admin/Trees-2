#Time Complexity: O(n)
#Space Complexity: O(h)
#submit on leetcode: yes

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def sumNumbers(self, root: [TreeNode]) -> int:
        total_sum = [0]
        self.helper(root, 0, total_sum)
        return total_sum[0]

    def helper(self, root, curr_sum, total_sum):
        if root is None:
            return None

        curr_sum = curr_sum * 10 + root.val
        if root.left is None and root.right is None:
            total_sum[0] += curr_sum
            return total_sum[0]

        self.helper(root.left, curr_sum, total_sum)
        self.helper(root.right, curr_sum, total_sum)


sol = Solution()


tree_root = TreeNode(1)
tree_root.left = TreeNode(2)
tree_root.right = TreeNode(3)

# Check the sum of numbers formed by root-to-leaf paths
result = sol.sumNumbers(tree_root)

# Print the result
print("Sum of numbers:", result)