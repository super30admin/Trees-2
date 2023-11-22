# // Time Complexity : O(N)
# // Space Complexity : O(N)
# // Did this code successfully run on Leetcode : YES
# // Any problem you faced while coding this : NO


# // Your code here along with comments explaining your approach
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        def dfs(root, currSum):
            nonlocal totalSum
            #IF none -- return
            if not root:
                return

            currSum = currSum*10 + root.val

            #If Leaf -- Then aDD
            if not root.left and not root.right:
                print(currSum)
                totalSum += currSum
                return

            dfs(root.left, currSum)
            dfs(root.right, currSum)
            
        totalSum = 0
        dfs(root, 0)

        return totalSum