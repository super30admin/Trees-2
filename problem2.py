#time complexity: O(n)
#space complexity: O(n)
#ran on leetcode: Yes
#Do a BFS traversal. At each level, along with storing root, store the integer formed so far as well. Finally, return the sum of integers at the final level.
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        Q=[]
        Q.append([root,0])
        s=0
        while(Q):
            
            curr,ele=Q[0]
            if(curr.left==None and curr.right==None):
                s+=(ele*10)+curr.val
            else:
                if(curr.left!=None):
                    Q.append([curr.left,ele*10+curr.val])
                if(curr.right!=None):
                    Q.append([curr.right,ele*10+curr.val])
            
            del(Q[0])
        return s
