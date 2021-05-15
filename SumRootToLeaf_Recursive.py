# TC: O(N) since we are traversing all nodes.    
# SC: O(H), H = height of tree


class Solution:
    def sumNumbers(self, root: TreeNode) -> int:
        if not root:
            return 0
        self.result = 0
        def inorder(root, cumsum):
            if not root:
                return 0
            cumsum = (cumsum*10) + root.val
            left_sum = inorder(root.left, cumsum)
            right_sum = inorder(root.right, cumsum)
            if not left_sum and not right_sum:
                return cumsum
            return (left_sum + right_sum)
        
        return inorder(root, 0)
