#Approach1: using sum as locan variable in recursion , to keep track of addition of parents, and returning sum when reaches leaf nodes
#Time Complexity: O(N) 
#Space Complexity: recursion stack height of tree
#It successfully runs on the leetcode
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        def helper(root,sum):
            if not root: return 0
            sum= sum*10 + root.val
            if root.left is None and root.right is None:
                return sum
            return helper(root.left,sum) + helper(root.right,sum)
        return helper(root,0)