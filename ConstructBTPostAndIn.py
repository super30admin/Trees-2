# Time Complexity : O(N)  //Where n is the size of the array
#  Space Complexity : O(1)  //We are using the sict to return the result which takes constant time 
#  Did this code successfully run on Leetcode : Yes
#  Any problem you faced while coding this : N/A

#  Your code here along with comments explaining your approach

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        def construct(temp,inorder,start, end, postorder):
            if start > end:
                return None
            
            root = postorder.pop()
            node = TreeNode(root)
            index = temp[root]
            
            node.right = construct(temp, inorder, index+1, end, postorder)
            node.left = construct(temp, inorder, start, index-1, postorder)
            return node
            
        #Creating a dictionary by mapping inorder elements to their respective index    
        temp = dict()
        for i,v in enumerate(inorder):
            temp[v] = i
        
        #Base Case: If there is only 1 element.
        if len(postorder) == 1:
                return TreeNode(postorder.pop())
        else:
            return construct(temp, inorder,0, len(inorder)-1, postorder)