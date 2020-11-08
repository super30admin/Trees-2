"""
The approach here is to start from the root traverse till the end of the tree where it does'nt have any
child and at every point while traversing add the node value to the value variable. finally at the end
we get the total.
example - 

    4
   / \
  9   0
 / \
5   1
step 1 - 0*10 + 4 = 4
step 2 - 4*10 + 4 = 49
step 3 - 49*10 + 5 = 495
step 4 - returns 495 val = 495
step 5 - 495 + 49 *10 + 1 = 495 + 491 = 986
step 6 returns 986
step 7 - 986 + 4*10 + 1 = 986 + 41 = 1026

Kindly let me know if this understanding of mine is correct
Leetcode running
Time complexity = O(N)
   
"""

def sumNumbers(self, root):
    
        def helper(node,val):
            if node == None:
                return 0
            if node.left == None and node.right == None:
                return val*10+node.val
            else:
                return helper(node.left,val*10+node.val)+ helper(node.right,val*10+node.val)
        return helper(root,0)