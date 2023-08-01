# Time Complexity : O(n)
# Space Complexity : O(H), height of tree
#In Method 2, we do the same as method 1 but process insode the recrursive call.
# Here, if you process inside of the recursive call, the current value of the variable(currNum) will be on the stack cause of 1:1 mapping and it'll be processed before the actual execution of the next recrussion. So, stack will have previous value but recrusion will have updated. 

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        #Method 1 - Normal Recursion
        # self.res=0
        # def helper(root,currNum):
        #     #base
        #     if root==None: 
        #         return
        #     #logic
        #     currNum=currNum*10+root.val
        #     if root.left==None and root.right==None:
        #         self.res+=currNum
        #     helper(root.left,currNum)
        #     helper(root.right,currNum)
        
        # helper(root,0)
        # return self.res

        #Above, If you move line 17,18 after 19(In Order) or after 20(Post Order) it will still work. Here order of iteration doesn't matter

        #Method 2 - Lagging Recursion
        #Now, if you process inside of the recursive call, the current value of the variable(currNum) will be on the stack cause of 1:1 mapping and it'll be processed before the actual execution of the next recrussion. So, stack will have previous value but recrusion will have updated. 

        self.res=0
        def helper(root,currNum):
            #base
            if root==None: 
                return
            #logic
            
            if root.left==None and root.right==None:
                self.res+=currNum*10+root.val #this is needed as, at the 5 and 1 49 will be present cause of lagging recursion
            helper(root.left,currNum*10+root.val)
            helper(root.right,currNum*10+root.val)
        
        helper(root,0)
        return self.res