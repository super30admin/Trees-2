class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        def helper( root, curr_sum ):
            nonlocal root_to_leaf
            if root:
                curr_sum = curr_sum * 10 + root.val
                if not root.left and not root.right:
                    root_to_leaf += curr_sum
                helper(root.left, curr_sum )
                helper(root.right, curr_sum)
            return curr_sum
            
        root_to_leaf = 0 
        helper(root, 0)
        return root_to_leaf
