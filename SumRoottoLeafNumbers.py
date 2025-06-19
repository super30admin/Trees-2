# recursive
#Time Complexity:O(n)
#Space Complexity:O(h)
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        return self.helper(root, 0)
    def helper(self, root, curr):
        if root is None:
            return 0
        curr = curr * 10 + root.val
        if root.left is None and root.right is None:
            return curr
        left = self.helper(root.left, curr)
        right = self.helper(root.right, curr)
        return left + right

# #iterative using stack: DFS: (pop() from end)
# # Time: O(n), Space: O(n) in worst case due to the stack
# class Solution:
#     def sumNumbers(self, root: Optional[TreeNode]) -> int:
#         if root is None:
#             return 0
#         res = 0
#         stack = [(root, root.val)]  # Stack stores (node, current path number)
#         while stack:
#             node, curr = stack.pop()
#             # If it's a leaf node, add the path number to result
#             if not node.left and not node.right:
#                 res += curr
#             else:
#                 # Push right and left children with updated path numbers
#                 if node.right:
#                     stack.append((node.right, curr * 10 + node.right.val))
#                 if node.left:
#                     stack.append((node.left, curr * 10 + node.left.val))
#         return res

# #iterative using queue: BFS: (pop(0) from front)
# # Time: O(n), Space: O(n) in worst case due to the queue
# class Solution:
#     def sumNumbers(self, root: Optional[TreeNode]) -> int:
#         if root is None:
#             return 0
#         res = 0
#         queue = [(root, root.val)]  # Queue stores (node, current path number)
#         while queue:
#             node, curr = queue.pop(0)  # FIFO for BFS
#             # If it's a leaf node, add the path number to result
#             if not node.left and not node.right:
#                 res += curr
#             else:
#                 # Enqueue left and right children with updated path numbers
#                 if node.left:
#                     queue.append((node.left, curr * 10 + node.left.val))
#                 if node.right:
#                     queue.append((node.right, curr * 10 + node.right.val))
#         return res