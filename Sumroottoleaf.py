class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        
        def dfs(root, curr_sum):
            nonlocal result
            
            if not root:
                return
            
            if root != None:
                curr_sum = (curr_sum * 10) + root.val
                
            if not root.right and not root.left:
                result += curr_sum
                
            dfs(root.left, curr_sum)
            dfs(root.right, curr_sum)
            
        result = 0
        dfs(root, 0)
        return result
    
    # This is a recursive solution
    # Time complexity: O(n) as it visits each and every node
    # Space Complexity: O(H) where H is the height of the tree for recursive stack