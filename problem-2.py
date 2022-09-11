#Time Complexity: O(n)
#Space Complexity: O(1)
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        self.result = 0 # global var for storing the sum
        def helper(root, currSum):
            if root is None: #base case
                return
            currSum  = currSum*10+ root.val # After visiting each node multiply the currsum value with 10 and add the value for root for the subtree
            if root.left == None and root.right == None: # when coming accross a leaf node add the accumulated sum to the result
                self.result += currSum
            helper(root.left, currSum) #sum of left sub-tree
            helper(root.right, currSum) #sum of right sub-tree
        helper(root,0)
        return self.result