# Time Complexity: O(N)
# Space Complexity: O(N)
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
      # last element of postorder is the root
      # if root is at end of inorder => only left branch
      # if root is at first of inorder => only right branch
      # else (root is at middle) => next root will be on right branch
      
      def helper(inorder_l, inorder_r):
        if inorder_l == inorder_r:
          return

        root_val = postorder.pop()
        root = TreeNode(root_val)
        idx = inorder_map[root_val]
        root.right = helper(idx+1, inorder_r)
        root.left = helper(inorder_l, idx)
        return root

      inorder_map = {n: idx for idx, n in enumerate(inorder)}
      return helper(0, len(inorder)
