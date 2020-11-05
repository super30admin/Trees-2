class Solution:
    def sumNumbers(self, root: TreeNode) -> int:
        
        output = 0
        if not root:
            return 0 
        def helper(node, curr):
            nonlocal output
            
            curr = (curr*10 + node.val)
            print(curr)
            if node.left:
                helper(node.left, curr)
            if node.right:
                helper(node.right, curr)
            if not node.left and not node.right:
                output+=curr
            return output
        return helper(root, 0)

# Time: O(n)
# Space : O(n)