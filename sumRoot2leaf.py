# // Time Complexity :O(n) for node traversal
# // Space Complexity :O(h) for recursion stack space
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : result[0] instead of result. Also using prev,curr became verbose.


# // Your code here along with comments explaining your approach
# We will store the result in a data-struct sinc, only ds are updated in recursions.
# we can use 10*(prev.node.val)+node.val formula. we create 2 base cases. Only when we know it is a leaf node we append to result[0].

class Solution:
    
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        result = [0]    
        self.helper(root,0,result)
        return result[0]

    def helper(self,root,curr,result):
        if root is None :                               # Base case for recursion (even 1 node is null)
            return

        curr = curr*10+root.val                         # create the number at node(4 -> 49-> 495)

        if root.left == None and root.right == None:    # case for recursion (both nodes are null) explicitly a leaf node
            result[0] += curr
            return None

        self.helper(root.left,curr,result)              # recusions left

        self.helper(root.right,curr,result)             # recursion right