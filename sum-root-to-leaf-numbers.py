# We use DFS to traverse the tree, accumulating the current path value (num * 10 + curr.val).
# When reaching a leaf node, we return the accumulated sum, and the final result is the sum of all root-to-leaf numbers.

# Time Complexity: O(n) (Each node is visited once).
# Space Complexity: O(h) (Recursive stack depth, where h is the tree height; worst case O(n) for skewed trees, 
# O(logn) for balanced trees).
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        def sumleaf(curr, num):
            if curr is None:
                return 0
            num = num * 10 + curr.val
            if not curr.left and not curr.right:
                return num
            return sumleaf(curr.left, num) + sumleaf(curr.right, num)
        return sumleaf(root, 0)