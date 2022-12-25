# // Time Complexity :O(N) we have to process all nodes
# // Space Complexity : O(N) in the recursive stack if it is skewed we would have to store all
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach   
## we need to get the sum of every branch in tree till the leaf node and sum them up. for this we need to store 
## the val of each node plus the sum at each level this is because if branch out we need the value from the parent node
## so for this reason along with the root we need to pass curr sum in the recursive stack. 
## when we reach the end we add it to our result. 
class Solution:
    result = 0
    def sum(self, root):
        self.helper(root)
        return self.result
    def helper(self, root, sum):
        if root == None:
            return 0
        curr_sum = sum*10 + root.val
        # if root.left == None and root.right == None:    ---> preorder check
        #     self.result+= curr_sum
        leftSum= self.helper(root.left, curr_sum)
        # if root.left == None and root.right == None:    ---> inorder check
        #     self.result+= curr_sum
        rightSum = self.helper(root.right, curr_sum)

        if root.left == None and root.right == None:      ##---> postorder check
            self.result+= curr_sum

       