# Time Complexity : O(n), where n is the number of nodes in the tree, since we visit each node once.
# Space Complexity : O(h), where h is the height of the tree.
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Understanding the traversal of tree

# Your code here along with comments explaining your approach
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        #Assign class variable result
        self.result = 0
        #Pass initial values as root node and current sum at root as 0
        self.helper(root, 0)
        #Return the updated result
        return self.result
    #Function to calculate the currSum at each node
    def helper(self, root, currSum):
        #Base Case
        if(root == None):
            return None
        #Update currSum at each node
        currSum = currSum * 10 + root.val
        #If leaf node is reached then update current sum to result
        if(root.left==None and root.right==None):
            self.result+=currSum
        #Traverse through left subtree
        root.left = self.helper(root.left,currSum)
        #Traverse through right subtree
        root.right = self.helper(root.right,currSum)