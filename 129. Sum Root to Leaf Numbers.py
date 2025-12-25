# VOID BASED RECURSION
# Time: O(n)
# Time: O(h)
# The total variable should be in the global scope as we don't want it to change and the current should be a parameter of recursion as we want to go back to the previous val when we return
# As we go a new node calculate the current number and check if the current node is the leaf node if yes add that into the total sum
# In base case we also need to have if node == null as not all nodes will be leaf nodes there will be nodes where root.left == null but root.right == 8 (i.e a number)
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        self.total = 0
        self.helper(root,0)
        return self.total
    def helper(self,root,curr):
        # base
        if root == None:
            return
        # logic
        curr = curr *10 + root.val
        if root.left == None and root.right == None:
            self.total += curr
        self.helper(root.left,curr)
        self.helper(root.right,curr)


# INT BASED RECURSION
# Time: O(n)
# Time: O(h)
# removing the global total variable we need to return numbers from everywhere now
# The base case would return 0 as adding 0 would not change the result
# On the leaf node the current number should be returned as we need to add that number
# and at the end add the result from left and from right
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        return self.helper(root,0)
    def helper(self,root,curr):
        # base
        if root == None:
            return 0
        # logic
        curr = curr *10 + root.val
        if root.left == None and root.right == None:
            return curr
        left = self.helper(root.left,curr)
        right = self.helper(root.right,curr)
        return left + right