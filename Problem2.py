"""
// Time Complexity : in code
// Space Complexity : in code
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no

--> go along each path, depth-first manner using stack
--> form and store numbers formed by digits so far along with each node 
--> when leaf node is encountered, add the number to final result

// Your code here along with comments explaining your approach
"""


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
"""
RECURSIVE
Time complexity : o(n)
Space: o(h) h-> height
"""

    def helper(self,root,s):
        #base
        if root == None:
            return 0
        
        if not root.left and not root.right:
            return s*10 +root.val
        #logic
        return self.helper(root.left, s*10 + root.val ) + self.helper(root.right, s*10 + root.val ) #s is used to form numbers from digits found at level
    
    def sumNumbers(self, root: TreeNode) -> int:
        
        return self.helper(root,0)
        
        """
        Iterative

        Time :
        Space :

        st = []
        
        
        s = 0 #used to form numbers from digits along each path
        res = 0 #storees the final result
        while root or st:
            
            while root:
                s = s*10 + root.val
                p = (root,s) #storing a tuple of root and corresponding sum
                st.append(p)
                root = root.left
                
                
            pair = st.pop()
            #print(pair)
            s = pair[1] #current number
            root = pair[0] #root
            if not root.left and not root.right: #if leaf node, add the number formed to the result
                res += pair[1]
                #print(res)
            root = pair[0].right #explore right child
            
        return (res)
        """
        