class Solution: 
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        if root == None: return 0
        def helper(cur , num):    
        # base
            if cur == None:
                return 0
        
        # logic
            num = num * 10 + cur.val
            if(cur.left == None and cur.right == None):
                return num
            val = helper(cur.left, num)
            ans = helper(cur.right, num)
            return val + ans
              
        
        fin = helper(root, 0)
        return fin

# T.C => O(H) = Height of the tree
# S.C => O(N) = Since we using recursive stack
# Approach => Here we have recursive approach and ahve helper function to help for. Everytime we are traversing to left nd right. 
# In left we are appending all the values from root to leef and using a formula of nums *  + the current value which make up the number
# In similar way we do it form right. When the recursion unfolds the values are added which gives us the all the sum values.
#And at the end we return the total result back