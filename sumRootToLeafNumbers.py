#O(n) time and O(H) (height) space solution
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        def sum(current, num):
            if not current:
                return 0
            
            num = num * 10 + current.val
            if not current.left and not current.right:
                return num
            return sum(current.left, num) + sum(current.right, num)
        
        return sum(root, 0)