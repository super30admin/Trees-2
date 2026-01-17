# -----------Solution 1 : Using Result as global variable and adding currSum to result at leaf node--------
''' Time Complexity : O(n)
    Space Complexity : O(h)

'''

class Solution:
    def __init__(self):
        self.result = 0

    def sumNumbers(self, root: Optional[TreeNode]) -> int:

        def helper(root, currSum):
            if root is None :
                return

            currSum = currSum * 10 + root.val

            if root.left is None and root.right is None:
                self.result += currSum
            
            helper(root.left,currSum)
            helper(root.right,currSum)
        
        helper(root, 0)
        return self.result


    #------Solution 2 : Int based recursion using Left + Right--------
    class Solution:

    def sumNumbers(self, root: Optional[TreeNode]) -> int:

        def helper(root, currSum):
            if root is None :
                return 0

            currSum = currSum * 10 + root.val

            if root.left is None and root.right is None:
                return currSum
            
            left = helper(root.left,currSum)
            right = helper(root.right,currSum)
            return left + right
        
        return helper(root, 0)