# Time Complexity: O(N)
# Space Complexity: O(H) - H could be from logN for balanced tree to N for skewed tree

class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
      def helper(node, sum):
        if not node:
          return sum
        left = 0
        right = 0
        if node.left and node.right:  
          left = helper(node.left, sum * 10 + node.val)
          right = helper(node.right, sum * 10 + node.val)
          return left + right
        elif node.left:
          return helper(node.left, sum * 10 + node.val)
        else:
          return helper(node.right, sum * 10 + node.val)

      return helper(root, 0)
        
