# Runtime : O(n)
# Ran on leetcode all test cases passed

# logic : We use a top down approach. We pass down a 
# number, we multiply it by ten and add the current number
# that way we maintain a number made up of all the values
# of all the roots from root to that leaf. 

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def __init__(self):
        self.ans = 0
        
    def sumNumbers(self, root: TreeNode):
        if root == None:
            return 0
        
        def helper(root, num):
            num = 10*num + root.val
            if not root.left and not root.right:
                self.ans += num
            
            if root.left:
                helper(root.left, num)
            
            if root.right:
                helper(root.right, num)
            
            num = num//10
        helper(root, 0)
        return self.ans
