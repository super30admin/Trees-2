# Author: Naveen US
# Titile: 

# Time complexity: O(n)
# Space complexity: O(n)
# Did the code run on leetcode: Yes

class Solution:
    def __init__(self) -> None:
        self.result = 0

    def dfs(self, root, cur_sum):
        if not root:
            return 0
        
        cur_sum = cur_sum * 10 + root.val
        
        if root.left == None and root.right == None:
            self.result += cur_sum
            return self.result

        self.dfs(root.left, cur_sum)
        self.dfs(root.right, cur_sum)
        
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        self.dfs(root, 0)
        return self.result

