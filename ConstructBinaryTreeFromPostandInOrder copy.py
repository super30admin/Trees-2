// Time Complexity : O(n^2)
// Space Complexity : O(n^2)
// Did this code successfully run on Leetcode : Yes 
// // Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> TreeNode:
        if len(postorder)==0:
            return
        root=TreeNode(postorder[-1]) 
        for i in range(len(inorder)): #find the index of root
            if inorder[i]==root.val:
                break
        index=i
        inLeft=inorder[:index] #left side of index
        postLeft=postorder[:index] # left side array in postorder
        
        inRight=inorder[index+1:] #right side of index
        postRight=postorder[index:len(postorder)-1] # right side array in postorder
        #print(root.val,"inLeft:",inLeft,"postLeft:",postLeft)
        #print(root.val,"inRight:",inRight,"postRight:",postRight)
        
        root.left=self.buildTree(inLeft,postLeft) #go to left
        root.right=self.buildTree(inRight,postRight) #go to right

        
        return root #tree is built